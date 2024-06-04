package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.AddressDAO;
import com.nonage.vo.AddressVO;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("IdCheckFormAction -> execute()");
		
		String url = "member/idcheck.jsp";
		
		//id 중복확인을 위한 id 출력
		String id = request.getParameter("id");
		System.out.println("id: "+id);
		
		// DB 연동
		
		//바인딩
		request.setAttribute("message", -1);
		request.setAttribute("id", id);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
