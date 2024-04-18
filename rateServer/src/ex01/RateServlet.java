package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RateServlet
 */
@WebServlet("/calc")
public class RateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  // 직렬화 생략가능
	
	private static float USD_RATE= 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.97F;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("doGet >> Served at: ").append(request.getContextPath());
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("doPost >> Served at: ").append(request.getContextPath());
		doHandle(request,response);
	}
	

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  // 인코딩 설정
		response.setContentType("text/html; charset=utf-8");  // 한글 출력 깨짐 방지
		PrintWriter pw = response.getWriter();  // 클라이언트에 결과를 출력하기 위함
		String command=request.getParameter("command");
		String won=request.getParameter("won");
		String operator=request.getParameter("operator");
		
		if(command!= null && command.equals("calculate")){
			String result = calculate(Float.parseFloat(won),operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>"+result+"</font><br><br><br>");
			pw.print("<a href='/rateServer/calc'>환율 계산기 </a>");
			return;
		}
		
		pw.print("<html><title>환율계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form  name='frmCalc' method='get'  action='/rateServer/calc'  />  ");
		pw.print("원화: <input type='text' name='won' size=10  />  ");
		pw.print("<select name='operator' >");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'  />  ");
		pw.println("<input type='submit' value='변환'  />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
	}

	private String calculate(float won, String operator) {
		// TODO Auto-generated method stub
		String result=null;
		if(operator.equals("dollar")){
			result=String.format("%.6f",won/USD_RATE);
		}else if(operator.equals("en")){
			result=String.format("%.6f",won/JPY_RATE);
		}else if(operator.equals("wian")){
			result=String.format("%.6f",won/CNY_RATE);
		}else if(operator.equals("pound")) {
			result=String.format("%.6f",won/GBP_RATE);
		}else if(operator.equals("euro")) {
			result=String.format("%.6f",won/EUR_RATE);
		}
		return result;
	}
	


}
