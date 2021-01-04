package kr.or.ddit.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MulCalculation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(request.getContextPath() + "/jsp/inputSum.jsp").forward(request, response);
	}

	private static final Logger logger = LoggerFactory.getLogger(MulCalculation.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		int res = (param1 * param2);
		session.setAttribute("mulResult", res);
		logger.debug(param1 + "과 " +  param2 + "의 곱 : " + res);
		request.setAttribute("param1", Integer.toString(param1));
		request.setAttribute("param2", Integer.toString(param2));
		request.getRequestDispatcher(request.getContextPath() + "/jsp/mulResult.jsp").forward(request, response);
	}

}
