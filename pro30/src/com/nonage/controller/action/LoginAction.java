package com.nonage.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nonage.dao.MemberDAO;
import com.nonage.vo.MemberVO;

public class LoginAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginAction -> execute()");
		
		//이동할 페이지
		String url = "member/login_fail.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		
		System.out.println("id: " + id);
		System.out.println("pwd: " + pwd);
		
		//MemberDAO를 통한 데이터베이스 연동
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		//MemberVO를 바인딩
		MemberVO memberVO = memberDAO.getMember(id);
		
		//세션객체에 바인딩해주세요.
		HttpSession session = request.getSession();
		
		if(memberVO != null) {
			System.out.println("memberVO.id: " + memberVO.getId());
			System.out.println("memberVO.pwd: " + memberVO.getPwd());
			
			if(memberVO.getPwd().equals(pwd)) {
				session.setAttribute("loginUser", memberVO);
				//페이지 이동
				url = "NonageShop?command=index";
			}
		} 
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}
	
	

}
