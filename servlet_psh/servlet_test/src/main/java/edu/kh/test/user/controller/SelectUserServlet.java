package edu.kh.test.user.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;


@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDao;   

    public SelectUserServlet() {
    	
		String resource = "edu/kh/test/user/config/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			userDao = session.getMapper(UserDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = 0;
		try {
			userNo = Integer.parseInt(request.getParameter("userNo"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		UserDTO userDTO = userDao.selectUser(userNo);
		
		if(userDTO != null) {
			request.setAttribute("userDTO", userDTO);
			request.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(request, response);
		}
		

		
		
	}



}
