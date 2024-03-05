package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;


@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			num =0;
		}
		
		BoardVO board = boardService.getBoard(num);
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		request.setAttribute("board", board);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num;
		int community;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			community = Integer.parseInt(request.getParameter("community"));
		}catch(Exception e) {
			num =0;
			community = 0;
		}
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO board = new BoardVO(num,community,title,content);
		
		
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		boolean res = boardService.updateBoard(user,board);
		
		if(res) {
			request.setAttribute("msg", "게시글을 수정 했습니다.");
			request.setAttribute("url", "board/list");
		}else {
			request.setAttribute("msg", "게시글을 수정하지 못했습니다.");
			request.setAttribute("url", "board/detail?num="+num);
		}
		
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
