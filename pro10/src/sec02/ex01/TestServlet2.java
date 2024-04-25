package sec02.ex01;
/*
 * 문제 : URL 패턴 테스트
 * 조건 : 디렉토리까지 일치
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
//@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet2</title>");
		out.println("</head>");
		out.println("<body bgcolor='yellow'>");
		out.println("<b>TestServlet2입니다.</b><br>");
		out.println("<b>컨텍스트명 : "+ context + "</b><br>");
		out.println("<b>전체경로 : "+ url +"<b><br>");
		out.println("<b>매핑명 : "+mapping+"<b><br>");
		out.println("<b>URI : " + uri + "<b>");	
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
