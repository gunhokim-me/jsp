package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserServiceI service = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo vo = new UserVo();
		String userid = request.getParameter("userid");
		vo = service.selectUser(userid);
		request.setAttribute("uservo", vo);
		request.getRequestDispatcher(request.getContextPath()+"/user/userModify.jsp").forward(request, response);
	}

	//사용자 정보 수정 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행
		//servlet doPost마다 실행 필요 ==> Filter
		request.setCharacterEncoding("UTF-8");
		UserVo vo = new UserVo();
		String userid = request.getParameter("userid");
		vo.setUserid(userid);
		vo.setPass(request.getParameter("userid"));
		vo.setUsernm(request.getParameter("usernm"));
		vo.setReg_dt(new Date());
		vo.setAlias(request.getParameter("alias"));
		vo.setAddr1(request.getParameter("addr1"));
		vo.setAddr2(request.getParameter("addr2"));
		vo.setZipcode(request.getParameter("zipcode"));
		
		int cnt = service.modifyUser(vo);
		if(cnt == 1) {
//			request.setAttribute("userid", request.getParameter("userid"));
//			request.getRequestDispatcher("/user").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/user?userid="+userid);
		}else {
			doGet(request, response);
		}
		
	}

}
