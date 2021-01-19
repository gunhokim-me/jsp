package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

public class SessionCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//요청 URI가 S_USER 속성이 세션에 있어야하는 주소인지 체크
		HttpServletRequest req = ((HttpServletRequest)request);
		String uri = req.getRequestURI();
		
		//세션 체크가 필요없는 주소 : login.jsp, loginController
		if(uri.endsWith("login.jsp") || uri.endsWith("LoginController") || uri.contains("/css/") || uri.contains("/profile/") || uri.contains("/js/")) {
			chain.doFilter(request, response);
		}else {
			//세션 체크가 필요있는 주소(S_USER 속성 확인)
			//session에 S_USER 속성이 있는지 확인
			UserVo user = (UserVo) req.getSession().getAttribute("S_USER");
			//user 정보가 NULL ==> 로그인을 안함 ==> 로그인 화면으로 이동
			//user 정보가 !NULL ==> 로그인을 함 ==> 요청 처리
			if(user == null) {
				((HttpServletResponse)response).sendRedirect(req.getContextPath()+"/login.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
