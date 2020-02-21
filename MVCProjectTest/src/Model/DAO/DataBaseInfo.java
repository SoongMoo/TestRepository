package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseInfo {
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	PreparedStatement pstmt;
	String sql ;
	ResultSet rs;
	static { 
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	}
	public static void getConnection() {
		try {
			Class.forName(jdbcDriver);
			conn= DriverManager.getConnection(jdbcUrl,"STUDY","STUDY");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
