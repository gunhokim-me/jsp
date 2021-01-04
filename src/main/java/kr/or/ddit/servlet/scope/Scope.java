package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/scope.jsp").forward(request, response);
		
		//response.sendRedirect(request.getContextPath() + "/jsp/scope.jsp"); 요청을 두번 날릴 필요는 없음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext app = request.getServletContext();
		
		String scope = request.getParameter("scope");
		
		request.setAttribute("request", scope+"_request");
		session.setAttribute("session", scope+"_session");
		app.setAttribute("application", scope+"_application");
		
		request.getRequestDispatcher(request.getContextPath()+ "/jsp/scopeResult.jsp").forward(request, response);
	}

}
