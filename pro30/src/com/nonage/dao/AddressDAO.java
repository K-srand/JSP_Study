package com.nonage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nonage.vo.AddressVO;

import util.DBManager;

public class AddressDAO {
	
	private AddressDAO() {
		
	}
	
	private static AddressDAO instance = new AddressDAO();
	
	public static AddressDAO getInstance() {
		return instance;
	}
	
	public ArrayList<AddressVO> selectAdressByDong(String dong){
		
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		
		return list;
			
	
//		System.out.println("AddressVO -> getAddress(dong) | dong: " + dong);
//		
//		//DB 연결하기 위한 준비
//		Connection conn = null;
//	    PreparedStatement pstmt = null;
//	    ResultSet rs = null;
//	    
//	    //쿼리문 작성
//	    String sql = "select * from member where dong=?";
//	    
//	    //DB 연동
//	    try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dong);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				addressVO = new AddressVO();
//				addressVO.setZipNum(rs.getString("zipNum"));
//				addressVO.setPwd(rs.getString("sido"));
//				addressVO.setName(rs.getString("gugun"));
//				addressVO.setEmail(rs.getString("dong"));
//				addressVO.setZipNum(rs.getString("zipCode"));
//				addressVO.setAddress(rs.getString("bunji"));
//		
//			}
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		
//		return addressVO;
	} 

}
