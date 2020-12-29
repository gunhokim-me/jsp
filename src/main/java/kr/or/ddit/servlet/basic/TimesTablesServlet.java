package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>TimesTablesServlet</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table border='1' style='width: 100%;height: 500px; text-align: center;'>");
		for(int i = 1; i <= 9; i++) {
			pw.println("			<tr>");
			for(int j = 2; j <= 9; j++) {
				pw.println("			<td>"+ j +" * "+ i +" = "+(j*i)+"</td>");
			}
			pw.println("			</tr>");
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
		
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
