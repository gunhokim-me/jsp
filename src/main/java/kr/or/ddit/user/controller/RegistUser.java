package kr.or.ddit.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.util.FileUtil;

@MultipartConfig
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass"); 
		String usernm = request.getParameter("usernm"); 
		String alias = request.getParameter("alias"); 
		String addr1 = request.getParameter("addr1"); 
		String addr2 = request.getParameter("addr2"); 
		String zipcode = request.getParameter("zipcode"); 
		
		//사용자가 profile을 업로드 한 경우
		//전송한 파일이름(filename)
		//파일 확장자
		//서버에 저장할 파일 이름(realfilename)
		//서버에 지정된 공간에 저장
		Part profile =  request.getPart("profile");
		String filename = "";
		String realfilename = "";
		if(profile.getSize() > 0) {
			filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);
			realfilename = UUID.randomUUID().toString() + fileExtension;
			
			profile.write("D:\\upload\\" + realfilename);
		}
		
		UserVo vo = new UserVo(userid, usernm, pass, new Date(), alias, addr1, addr2, zipcode, filename, realfilename);
		
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
