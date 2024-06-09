package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;


@WebServlet("/comment/update")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num =0;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		String content = request.getParameter("content");
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		
		CommentVO comment = new CommentVO(0,content,user.getMe_id());
		comment.setCm_num(num);
		
		boolean res = boardService.updateComment(comment);
		
		response.getWriter().write(res?"ok":"");
		
	}

}
