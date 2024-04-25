package sec03.ex01;
/*
 * 문제 : 필터 클래스를 이용하여 모든 요청에 utf-8 인코딩할 수 있도록 출력
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
//@WebFilter("/*")
public class EncoderFilter implements Filter {
	ServletContext context;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("utf-8 인코딩............");
		context = fConfig.getServletContext();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context  정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로:  " + realPath;
		System.out.println(mesg);

		long begin = System.currentTimeMillis();
		chain.doFilter(request, response); //다음 필터로 넘기는 작업 수행
		long end = System.currentTimeMillis();
		System.out.println("작업 시간:" + (end - begin) + "ms");

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 호출");
	}

}
