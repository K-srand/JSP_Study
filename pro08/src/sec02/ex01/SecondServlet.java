package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
//@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException {
		// TODO Auto-generated method stub 
		request.setCharacterEncoding("utf-8"); // request 객체 사용 시 명시해주는 것을 권장
		response.setContentType("text/html;charset=utf-8");
		  
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		String name=request.getParameter("name");
		out.println("이름:"+name);
		out.println("<br>");
		out.println("</body></html>");
	}
	
}
