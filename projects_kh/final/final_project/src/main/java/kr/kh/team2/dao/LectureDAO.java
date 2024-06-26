package kr.kh.team2.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.kh.team2.model.vo.common.ProgrammingCategoryVO;
import kr.kh.team2.model.vo.common.ProgrammingLanguageVO;
import kr.kh.team2.model.vo.common.SearchMenuVO;
import kr.kh.team2.model.vo.common.TotalCategoryVO;
import kr.kh.team2.model.vo.common.TotalLanguageVO;
import kr.kh.team2.model.vo.lecture.LectureFileVO;
import kr.kh.team2.model.vo.lecture.LectureRegisterVO;
import kr.kh.team2.model.vo.lecture.LectureVO;
import kr.kh.team2.model.vo.member.MemberVO;
import kr.kh.team2.pagination.Criteria;

public interface LectureDAO {

	ArrayList<LectureVO> selectAllLectureList(@Param("cri") Criteria cri, @Param("search")SearchMenuVO search);

	ArrayList<LectureVO> selectLectureList(@Param("cri") Criteria cri, @Param("search") SearchMenuVO search);

	int selectLectureCount(@Param("cri") Criteria cri, @Param("search") SearchMenuVO search);

	LectureVO selectLecture(@Param("lect_num") int lectNum);

	MemberVO selectLecture_Mento(@Param("mentIf_me_id") String lect_mentIf_me_id);

	ArrayList<TotalCategoryVO> selectCategoryList(@Param("num") int lectNum, @Param("table") String table);

	ArrayList<TotalLanguageVO> selectLanguageList(@Param("num") int lectNum, @Param("table") String table);

	ArrayList<ProgrammingCategoryVO> selectProgrammingCategoryList();

	ArrayList<ProgrammingLanguageVO> selectProgrammingLanguageList();

	boolean insertLecture(@Param("lecture")LectureVO lecture);

	boolean insertTotalCate(@Param("toCate")TotalCategoryVO totalCateVo);

	boolean insertTotalLang(@Param("toLang")TotalLanguageVO totalLangVo);

	void insertFile(@Param("fi")LectureFileVO fileVO);

	void deleteFile(@Param("fi_num")int lectFi_num);

	ArrayList<LectureFileVO> selectFileList(@Param("lect_num")int lectNum);
  
	ArrayList<LectureVO> selectHotLectureList();

	Date selectDue(@Param("lect_num")String reco_target);

	boolean insertLectureRegister(@Param("lectRg")LectureRegisterVO lectureRgVo);

	LectureRegisterVO selectLecturePayment(@Param("lect_num")int lectNum,@Param("me_id") String me_id);

	boolean updateLecture(@Param("lecture") LectureVO lecture);

	LectureFileVO selectFile(@Param("lectFi_num") int tmp);

	ArrayList<LectureVO> selectMyLecture(@Param("me_id") String me_id);

}
