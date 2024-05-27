package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String uid = "scott";
	private static String pwd = "tiger";
	
	public static Connection getConnection() {
		
		System.out.println("DBManager -> getConnection()");
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// 순서 : rs / pstmt / conn 
		System.out.println("DBManager -> close(3)");
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		
		System.out.println("DBManager -> close(2)");
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
