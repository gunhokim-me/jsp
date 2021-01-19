package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*@WebFilter(urlPatterns = "/*", initParams = {@WebInitParam(name = "encoding", value="UTF-8")})*/
public class EncodingFilter implements Filter {
	
	FilterConfig config;
	private static final Logger logger = LoggerFactory.getLogger(EncodingFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		logger.debug("EncodingFilter 호출");
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
