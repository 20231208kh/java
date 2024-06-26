package kr.kh.team2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import kr.kh.team2.model.vo.common.ProgrammingCategoryVO;
import kr.kh.team2.model.vo.common.ProgrammingLanguageVO;
import kr.kh.team2.model.vo.common.ReportContentVO;
import kr.kh.team2.model.vo.common.SearchMenuVO;
import kr.kh.team2.model.vo.common.TotalCategoryVO;
import kr.kh.team2.model.vo.common.TotalLanguageVO;
import kr.kh.team2.model.vo.lecture.LectureFileVO;
import kr.kh.team2.model.vo.lecture.LectureRegisterVO;
import kr.kh.team2.model.vo.lecture.LectureVO;
import kr.kh.team2.model.vo.member.MemberVO;
import kr.kh.team2.pagination.Criteria;
import kr.kh.team2.pagination.PageMaker;
import kr.kh.team2.service.LectureService;
import kr.kh.team2.service.ReportService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class LectureController {

	@Autowired
	LectureService lectureService;
	@Autowired
	ReportService reportService;
	
    private String restApiKey="";
    private String restApiSecret="";
    
	private final IamportClient iamportClient;
	
	@GetMapping("/lecture/list")
	public String lectureList(Model model, Criteria cri, SearchMenuVO search) {
		cri.setPerPageNum(2);
		ArrayList<LectureVO> list = lectureService.getAllLectureList(cri, search);
		int lectureCount = lectureService.getLectureCount(cri, search);
		PageMaker pm = new PageMaker(3, cri, lectureCount);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		model.addAttribute("search", search);
		model.addAttribute("title", "강의글 목록");
		return "/lecture/list";
	}
	
//	//강의 하위메뉴 분야 선택했을때 동작
//	@GetMapping("/lecture/list/cate")
//	public String lectureListCate(Model model, Criteria cri, SearchMenuVO search) {
//		cri.setPerPageNum(2);
//		search.setSearchType("cate");
//		ArrayList<LectureVO> list = lectureService.getLectureList(cri, search);
//		int lectureCount = lectureService.getLectureCount(cri, search);
//		PageMaker pm = new PageMaker(3, cri, lectureCount);
//		model.addAttribute("list", list);
//		model.addAttribute("pm", pm);
//		model.addAttribute("search", search);
//		model.addAttribute("title", "강의글 목록");
//		return "/lecture/list";
//	}
	
//	//강의 하위메뉴 언어 선택했을때 동작
//	@GetMapping("/lecture/list/lang")
//	public String lectureListLang(Model model, Criteria cri, SearchMenuVO search) {
//		cri.setPerPageNum(2);
//		search.setSearchType("lang");
//		ArrayList<LectureVO> list = lectureService.getLectureList(cri, search);
//		int lectureCount = lectureService.getLectureCount(cri, search);
//		PageMaker pm = new PageMaker(3, cri, lectureCount);
//		model.addAttribute("list", list);
//		model.addAttribute("pm", pm);
//		model.addAttribute("search", search);
//		model.addAttribute("title", "강의글 목록");
//		return "/lecture/list";
//	}
	
	@GetMapping("/lecture/myList")
	public String lectureMyList(Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		ArrayList<LectureVO> list = lectureService.getMyLecture(user);
		model.addAttribute("list", list);
		model.addAttribute("title", "내가 구매한 강의모음");
		return "/lecture/myList";
	}
	
	
	
	//강의 동록 화면 띄우기
	@GetMapping("/lecture/insert")
	public String lectureInsert(Model model) {
		
		ArrayList<ProgrammingCategoryVO> categoryList = lectureService.getProgrammingCategoryList();
		ArrayList<ProgrammingLanguageVO> languageList = lectureService.getProgrammingLanguageList();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("languageList", languageList);
		model.addAttribute("title","강의 등록");
		return "/lecture/insert";
	}
	
	//강의 등록하기
	@PostMapping("/lecture/insert")
	public String lectureInsertPost(Model model, String progCtList, String progLangList ,
			LectureVO lecture, HttpSession session, MultipartFile[] file) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		log.info(lecture);
		log.info(file);
		//강의 글 등록
		boolean res = lectureService.insertLecture(lecture, user, progCtList, progLangList, file);
		
		if(res) {
			model.addAttribute("msg", "강의를 등록했습니다.");
			model.addAttribute("url", "/lecture/list"); 
		} else {
			model.addAttribute("msg", "강의를 등록하지 못했습니다.");
			model.addAttribute("url", "/lecture/insert");
		}
		return "message";
	}
	
	@ResponseBody
	@PostMapping("/img/upload")
	public Map<String, Object> imgUpload(MultipartFile file){
		HashMap<String, Object> map = new HashMap<String, Object>();
		String uploadPath = lectureService.uploadImg(file);
		map.put("url", uploadPath);
		return map;
	}
	
	@ResponseBody
	@PostMapping("/img/delete")
	public Map<String, Object> imgDelete(String file){
		HashMap<String, Object> map = new HashMap<String, Object>();
		lectureService.deleteImg(file);
		map.put("res", "삭제");
		return map;
	}
	
	//강의글 상세 조회
	@GetMapping("/lecture/detail")
	public String lectureDetail(Model model, Criteria cri, SearchMenuVO search, int lectNum, HttpSession session) {
		cri.setPerPageNum(5);
		LectureVO lecture = lectureService.getLecture(lectNum);
		//강의를 올린 멘토 아이디 닉네임 가져오기
		MemberVO writer = lectureService.getLecture_Mento(lecture.getLect_mentIf_me_id());
		//모집 공고에 등록된 분야, 언어 가져옴
		String table = "lecture";
		
		ArrayList<TotalCategoryVO> totalCategory = lectureService.getCategory(lectNum, table);
		ArrayList<TotalLanguageVO> totalLanguage = lectureService.getLanguage(lectNum, table);
		//첨부된 강의파일 가져오기
		ArrayList<LectureFileVO> fileList = lectureService.getFileList(lectNum);
		
		//신고 유형 정보 가져오기
		ArrayList<ReportContentVO> contentList = reportService.getReportContentList();
		//강의 신고 여부 불러오기
		boolean istrue = true;
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			istrue = reportService.getReportIsTrue(Integer.toString(lectNum), "lecture", user.getMe_id());
		}
		
		//유저의 강의 결제 여부
		LectureRegisterVO lectRg = lectureService.getLecturePayment(lectNum, user);
		
		model.addAttribute("payment", lectRg);
		model.addAttribute("lecture", lecture);
		model.addAttribute("writer", writer);
		model.addAttribute("istrue", istrue);
		model.addAttribute("totalCategory", totalCategory);
		model.addAttribute("totalLanguage", totalLanguage);
		model.addAttribute("fileList", fileList);
		model.addAttribute("contentList", contentList);
		model.addAttribute("title", "강의 상세");
		return "/lecture/detail";
	}
	
	//강의 결제 완료후 데이터베이스에 넣기
	@ResponseBody
	@PostMapping("/lecture/detail")
	public Map<String, Object> lectureRegisterPost(LectureRegisterVO lectureRgVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = lectureService.insertLectureRegister(lectureRgVo);
		
		map.put("result", res);
		return map;
	}
	
	@GetMapping("/lecture/register")
	public String lecturePayment(Model model, int lect_num, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		LectureVO lecture = lectureService.getLecture(lect_num);
		model.addAttribute("title", "강의 구매 완료");
		model.addAttribute("user", user);
		model.addAttribute("lecture", lecture);
		return "/lecture/register";
	}
	
	public LectureController() {
        this.iamportClient = new IamportClient(restApiKey, restApiSecret);
    }

    @ResponseBody
    @RequestMapping("/verify")
    public IamportResponse<Payment> paymentByImpUid(String imp_uid)
            throws IamportResponseException, IOException {
    	IamportResponse<Payment> payment = iamportClient.paymentByImpUid(imp_uid);
    	System.out.println(payment);
        return payment;
    }
	
    @GetMapping("/lecture/update")
	public String boardUpdate(Model model, int lect_num) {
		//게시글을 가져옴
		LectureVO lecture = lectureService.getLecture(lect_num);
		//첨부파일을 가져옴
		ArrayList<LectureFileVO> fileList = lectureService.getFileList(lect_num);
		
		model.addAttribute("fileList", fileList);
		model.addAttribute("lecture", lecture);
		return "/lecture/update";
	}
    
    @PostMapping("/lecture/update")
    public String boardUpdatePost(Model model, LectureVO lecture, MultipartFile []file,
			int [] delNums, HttpSession session) {
    	MemberVO user = (MemberVO) session.getAttribute("user");
    	boolean res = lectureService.updateLecture(lecture, user, file, delNums);
    	
    	if(res) {
    		model.addAttribute("url", "/lecture/detail?lectNum="+lecture.getLect_num());
    		model.addAttribute("msg", "강의를 수정했습니다");
    	}else {
    		model.addAttribute("url", "/lecture/detail?lectNum="+lecture.getLect_num());
    		model.addAttribute("msg", "강의 수정에 실패했습니다.");
    	}
    	return "message";
    }
    
    
}
