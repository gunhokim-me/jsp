package kr.or.ddit.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SumCalculation() {
        super();
    }
    
    private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(request.getContextPath() + "/jsp/inputSum.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int start = Integer.parseInt(request.getParameter("start")); 
		int end = Integer.parseInt(request.getParameter("end"));
		int sum = 0;
		
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		logger.debug(start + "부터 " + end + "까지 합 : " + sum);
		
		request.setAttribute("start", Integer.toString(start));
		request.setAttribute("end", Integer.toString(end));
		session.setAttribute("sumResult", sum);
		request.getRequestDispatcher(request.getContextPath() + "/jsp/sumResult.jsp").forward(request, response);
	}

}
