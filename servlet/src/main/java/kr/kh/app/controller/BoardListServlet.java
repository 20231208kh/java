package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String type = request.getParameter("type");
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e){
			page =1;
		}
		
		Criteria cri = new Criteria(page, 2, type, search);
		//검색어, 검색타입에 맞는 전체 게시글 개수를 가져옴
		int totalCount = boardService.getTotalCount(cri);
		
		PageMaker pm = new PageMaker(page,cri,totalCount);
		request.setAttribute("pm", pm);
		//전체 게시글 리스트
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		request.setAttribute("list", list);//화면에 전송
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

}