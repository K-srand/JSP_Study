package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

import com.nonage.vo.MemberVO;

public class MemberDAO {
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public MemberVO getMember(String id) {
		
		System.out.println("MemberDAO -> getMember(id) | id: " + id);
		MemberVO memberVO = null;
		
		//DB 연결하기 위한 준비
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    //쿼리문 작성
	    String sql = "select * from member where id=?";
	    
	    //DB 연동
	    try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setZipNum(rs.getString("zip_num"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setUseyn(rs.getString("useyn"));
				memberVO.setIndate(rs.getTimestamp("indate"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return memberVO;
		
	}

	public void insertMember(MemberVO memberVO) {
		System.out.println("MemberDAO -> insertMember(memberVO) | id: " + memberVO.getId());
		System.out.println("MemberDAO -> insertMember(memberVO) | id: " + memberVO.getName());
		
		//DB 연결하기 위한 준비
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    //쿼리문 작성
		String sql = "insert into member(id, pwd, name, email, zip_num, address, phone) ";
		sql +="values(?,?,?,?,?,?,?)";
	    
	    //DB 연동
	    try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getZipNum());
			pstmt.setString(6, memberVO.getAddress());
			pstmt.setString(7, memberVO.getPhone());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	

}
