package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.MemberDTO;

public class MemberDAO {
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql ;
	static {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	}
	
	public static void getConnection() {
		try {
		//1. 드라이브 연결
		Class.forName(jdbcDriver);
		// 2. DBMS에 연결
		conn = DriverManager.getConnection(jdbcUrl,"STUDY","STUDY");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Integer pwUpdate(String id,String pw, String newPw) {
		Integer result = 0;
		getConnection();
		sql = "update member "
				+ " set user_pw = ? "
				+ " where user_id = ? and user_pw = ?";
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPw);
				pstmt.setString(2, id);
				pstmt.setString(3, pw);
				result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public Integer updateInfoMember(MemberDTO member) {
		Integer result = null;
		getConnection();
		sql = "update member "
			+ " set user_email = ?, user_addr = ?, "
			+ "    user_ph1 = ?, user_ph2 =? "
			+ " where user_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserEmail());
			pstmt.setString(2, member.getUserAddr());
			pstmt.setString(3, member.getUserPh1());
			pstmt.setString(4, member.getUserPh2());
			pstmt.setString(5, member.getUserId());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public Integer updateMember(MemberDTO member) {
		Integer result = null;
		getConnection();
		sql = "update member "
			+ " set user_email = ?, user_addr = ?, "
			+ "    user_ph1 = ?, user_ph2 =? "
			+ " where user_id = ? and user_pw = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserEmail());
			pstmt.setString(2, member.getUserAddr());
			pstmt.setString(3, member.getUserPh1());
			pstmt.setString(4, member.getUserPh2());
			pstmt.setString(5, member.getUserId());
			pstmt.setString(6, member.getUserPw());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	
	public void memberInfoDelete(String userId) {
		Integer result = null;
		getConnection(); 
		sql ="delete from member where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public Integer memberDelete(String userId,String userPw ) {
		Integer result = null;
		getConnection(); 
		sql ="delete from member "
			+ " where user_id =? and user_pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public MemberDTO memberOneSelect(String id) {
		MemberDTO member = new MemberDTO();
		getConnection(); 
		sql = "select USER_ID, USER_PW, USER_NAME,"
			+ " USER_BIRTH, USER_GENDER, USER_EMAIL,"
			+ " USER_ADDR, USER_PH1, USER_PH2, USER_REGIST "
			+ " from member where USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setUserId(rs.getString("USER_ID"));
				member.setUserName(rs.getString("USER_NAME"));
				member.setUserEmail(rs.getString("USER_EMAIL"));
				member.setUserPh1(rs.getString("USER_PH1"));
				member.setUserRegist(rs.getTimestamp("USER_REGIST"));
				member.setUserAddr(rs.getString("USER_ADDR"));
				member.setUserBirth(rs.getTimestamp("USER_BIRTH"));
				member.setUserGender(rs.getString("USER_GENDER"));
				member.setUserPh2(rs.getString("USER_PH2"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return member;
	}
	public List<MemberDTO> memberAllSelect(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		getConnection();
		sql = "select USER_ID, USER_PW, USER_NAME,"
			+ " USER_BIRTH, USER_GENDER, USER_EMAIL,"
			+ " USER_ADDR, USER_PH1, USER_PH2, USER_REGIST from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setUserId(rs.getString("USER_ID"));
				member.setUserName(rs.getString("USER_NAME"));
				member.setUserEmail(rs.getString("USER_EMAIL"));
				member.setUserPh1(rs.getString("USER_PH1"));
				member.setUserRegist(rs.getTimestamp("USER_REGIST"));
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;		
	}
	public Integer userCheck(String userId,String userPw) {
		getConnection();
		String dbpw=null;
		Integer result = null;
		sql = "select user_pw from member where user_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbpw = rs.getString(1);
				if(userPw.equals(dbpw)) {
					result = 1;
				}else {
					result = 0;
				}
			}else {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public Integer insertMember(MemberDTO member) {
		Integer result = null;
		getConnection();
		sql= "insert into member values(?,?,?,?,?,?,?,?,?,sysdate,null)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getUserId() );
			pstmt.setString(2,member.getUserPw() );
			pstmt.setString(3,member.getUserName() );
			pstmt.setTimestamp(4,member.getUserBirth() );
			pstmt.setString(5,member.getUserGender() );
			pstmt.setString(6,member.getUserEmail() );
			pstmt.setString(7,member.getUserAddr() );
			pstmt.setString(8,member.getUserPh1() );
			pstmt.setString(9,member.getUserPh2() );
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public String selectId(String userId) {
		String result = null;
		getConnection();
		sql = "select user_id from member where user_id = ?";
		try {
			// 3. 쿼리문 전송
			pstmt = conn.prepareStatement(sql);
			// 4. pstmt에 값 저장
			pstmt.setString(1,userId);
			// 5. pstmt에 저장된 값 전송(실행)
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("user_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	private void close() {
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
