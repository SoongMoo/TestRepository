package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseInfo {
	static String jdbcDriver;
	static String jdbcUrl;
	Connection conn;
	static {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() {
		try {
		//1. 드라이브 연결
		Class.forName(jdbcDriver);
		// 2. DBMS에 연결
		conn = DriverManager.getConnection(jdbcUrl,"STUDY","STUDY");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close(ResultSet rs, PreparedStatement pstmt) {
		if (rs != null) 
			try { rs.close(); } 
		    catch(SQLException ex) {}
        if (pstmt != null) 
        	try { pstmt.close(); } 
            catch(SQLException ex) {}
        if (conn != null) 
        	try { conn.close(); } 
            catch(SQLException ex) {}
	}
}
