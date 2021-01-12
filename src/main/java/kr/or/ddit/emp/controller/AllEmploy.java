package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.emp.model.EmployVo;
import kr.or.ddit.emp.service.EmployService;
import kr.or.ddit.emp.service.EmployServiceI;

public class AllEmploy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployServiceI service = new EmployService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmployVo> list = service.selectAllEmploy();
		request.setAttribute("empList", list);
		request.getRequestDispatcher(request.getContextPath()+"/allEmp.jsp").forward(request, response);
	}

}
