package sec02.ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
//@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nextPage = null;
		
		//1. 요청받은 정보 추출
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		
		if (action == null || action.equals("/listMembers.do")) {
			
			//2. 회원정보 목록 DB 연동 처리
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			
			nextPage = "/test03/listMembers.jsp";
			
		}else if (action.equals("/memberForm.do")) {
			
			nextPage = "/test03/memberForm.jsp";
			
		}else if (action.equals("/addMember.do")) {
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			//2. 회원가입 정보 DB 연동 처리
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			
			nextPage = "/member/listMembers.do";

		} else if(action.equals("/modMemberForm.do")){

		     String id=request.getParameter("id");
		     
		     //2. 회원정보 수정화면 DB 연동 처리
		     MemberVO memInfo = memberDAO.findMember(id);
		     request.setAttribute("memInfo", memInfo);
		     
		     nextPage="/test03/modMemberForm.jsp";
		
		} else if(action.equals("/modMember.do")){
			
		     String id=request.getParameter("id");
		     String pwd=request.getParameter("pwd");
		     String name= request.getParameter("name");
	         String email= request.getParameter("email");
	         
	         // 2. 회원정보 수정 DB 연동 처리
		     MemberVO memberVO = new MemberVO(id, pwd, name, email);
		     memberDAO.modMember(memberVO);
		     
		     request.setAttribute("msg", "modified");
		     nextPage="/member/listMembers.do";
		     
		} else if(action.equals("/delMember.do")){
		     String id=request.getParameter("id");
		     
		     //2. 회원정보 삭제 DB 연동 처리
		     memberDAO.delMember(id);
		     request.setAttribute("msg", "deleted");
		     nextPage="/member/listMembers.do";
		     
		} else {
			
			//nextPage = "/member/listMembers.do";
	    	//2. 회원정보 목록 DB 연동 처리
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			
			nextPage = "/test03/listMembers.jsp";
			
		}
		
		//3. 화면 이동
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}

}