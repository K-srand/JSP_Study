package sec03.ex01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException { 
		// TODO Auto-generated method stub 
		response.setContentType("text/html;charset=utf-8");
//		RequestDispatcher dispatch = request.getRequestDispatcher("second");
		RequestDispatcher dispatch = request.getRequestDispatcher("second?name=lee");  
		dispatch.forward(request, response);
	}
	
}

