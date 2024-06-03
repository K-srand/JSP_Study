package com.nonage.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nonage.dao.AddressDAO;
import com.nonage.vo.AddressVO;

public class FindZipNumAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FindZipNumAction -> execute()");
		
		String url = "member/findZipNum.jsp";
		
		//동 확인
		String dong = request.getParameter("dong");
		
		if(dong!=null && dong.trim().equals("") == false) {
			System.out.println("dong: "+ dong);
			
			AddressDAO addressDAO = AddressDAO.getInstance();
			ArrayList<AddressVO> addresslist = addressDAO.selectAdressByDong(dong.trim());
			request.setAttribute("addressList", addresslist);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
