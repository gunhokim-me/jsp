package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//left.jps : / pagingUser?page=1&pageSize=5
		//===> /pagingUser
		//doGet 메소드에서 page,pageSize 파라미터가 request 객제에 존재하지 않을 때 page는 1로, pageSize 5로 생각을 코드로 작성
		//파라미터가 존재하면 파라미터를 이용
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * request Parameter
		 */
		
		//refactoring : 코드를 (깔끔하게)바꾸는데 기존 동작방식을 유지한 채로 변경하는 기법
		
		//삼항연산자
		String pageparam = request.getParameter("page");
		String pageSizeParam = request.getParameter("pageSize");
		
		int page = pageparam == null? 1 :  Integer.parseInt(pageparam) ;
		int pageSize = pageSizeParam == null? 5 :  Integer.parseInt(pageSizeParam) ;
		
		//if 구문 사용시 
//		int page = 0;
//		int pageSize = 0;
//		if(request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}else {
//			page = 1;
//		}
//		
//		if(request.getParameter("pageSize") != null) {
//			pageSize = Integer.parseInt(request.getParameter("pageSize"));
//		}else {
//			pageSize = 5;
//		}
		
		PageVo vo = new PageVo();
		
		vo.setPage(page);
		vo.setPageSize(pageSize);
		
		Map<String, Object> map = userService.selectPagingUser(vo);
		
		int userCnt = (int)map.get("userCnt");
		
		int pagination = (int)Math.ceil((double)userCnt /pageSize);
		
		List<UserVo> list = (List<UserVo>) map.get("userList");
		
		request.setAttribute("userList", list);
		request.setAttribute("pagination", pagination);
		request.getRequestDispatcher(request.getContextPath() +"/pagingUser.jsp").forward(request, response);
	}

}
