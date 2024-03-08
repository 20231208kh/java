package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/id/check")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberService memberService = new MemberServiceImp();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
	
		String res = memberService.checkId(id);
		
		response.getWriter().write(res);
		
		
		
	}


}
