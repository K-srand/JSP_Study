package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindZipNumAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FindZipNumAction -> execute()");
		
		String url = "member/findZipNum.jsp";
		
		//동 확인
		String dong = request.getParameter("dong");
		System.out.println("dong: "+ dong);
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
