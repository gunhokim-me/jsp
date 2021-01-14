package kr.or.ddit.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceI service = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("id");
		int cnt = service.countUser(userid);
		request.setAttribute("cnt", cnt);
		request.getRequestDispatcher(request.getContextPath()+"/user/test.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass"); 
		String usernm = request.getParameter("usernm"); 
		String alias = request.getParameter("alias"); 
		String addr1 = request.getParameter("addr1"); 
		String addr2 = request.getParameter("addr2"); 
		String zipcode = request.getParameter("zipcode"); 
		 
		UserVo vo = new UserVo(userid, usernm, pass, new Date(), alias, addr1, addr2, zipcode);
		
		int cnt = 0;
		try {
			cnt = service.registUser(vo);
		} catch (Exception e) {
			cnt = 0;
		}
		
		if(cnt == 1) {
			response.sendRedirect(request.getContextPath()+"/pagingUser");
		}else {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher(request.getContextPath()+"/user/registUser.jsp").forward(request, response);
		}
	}
}
