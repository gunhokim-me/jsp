package kr.or.ddit.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	UserServiceI service = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo vo = new UserVo();
		
		String userid = (String) request.getAttribute("userid");
		if(userid == null) {
			userid = request.getParameter("userid");
		}
		
		logger.debug(userid);
		vo = service.selectUser(userid);
		request.setAttribute("user", vo);
		request.getRequestDispatcher(request.getContextPath()+"/user/user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
