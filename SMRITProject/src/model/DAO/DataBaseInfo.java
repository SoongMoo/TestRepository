package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseInfo {
	String jdbcDriver;
	String jdbcUrl;
	Connection conn;
	PreparedStatement pstmt;
	String sql ;
	ResultSet rs;
	
	public DataBaseInfo() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public void updateReadCount(String num,
			String tableName) {
		conn = getConnection();
		sql = "update  " + tableName
			+ " set READ_COUNT = READ_COUNT + 1 "
			+ " where BOARD_NUM = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcUrl
					,"study","study");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close() {
		if (rs != null) try { rs.close(); } 
			            catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } 
				           catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } 
				          catch(SQLException ex) {}		
	}
}
