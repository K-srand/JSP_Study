package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LogoutAction -> execute()");
		
		String url = "NonageShop?command=index";
		
		//세션 정보 해제
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
