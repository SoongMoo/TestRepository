package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.MemberDTO;

public class MemberDAO extends DataBaseInfo{
	final String columns = "user_id,user_pw,user_name,user_birth," 
			+ "user_gender,user_email,user_addr, user_ph1,user_ph2 ";
	public void joinUpdate(String num, String userEmail) {
		getConnection();
		sql = "update member "
			+ " set join_ok = ? "
			+ " where user_email = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, userEmail);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public String joinOkcheck(String userEmail) {
		String joinOk = null;
		getConnection();
		sql = "select join_ok from member "
			+ " where user_email = ? and join_ok is null";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				joinOk = "t";
			}else {
				joinOk = "f";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return joinOk;
	}
	public Integer pwUpdate(String userId, String currPw, String newPw){
		Integer result = 0;
		getConnection();
		sql = "update member "
			+ " set user_pw = ? "
			+ " where user_id = ? and user_pw = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,newPw);
			pstmt.setString(2,userId);
			pstmt.setString(3,currPw);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void memberInfoDelete(String userId) {
		getConnection();
		sql = " delete from member where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void updateInfoMember(MemberDTO member) {
		getConnection();
		sql = " update member "
			+ " set  user_email = ?, user_addr = ?, "
			+ "      user_ph1 = ?, user_ph2 = ? "
			+ " where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserEmail());
			pstmt.setString(2, member.getUserAddr());
			pstmt.setString(3, member.getUserPh1());
			pstmt.setString(4, member.getUserPh2());
			pstmt.setString(5, member.getUserId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public Integer memberCount() {
		getConnection();
		sql = "select count(*) from member ";
		Integer result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public List memberAllSelect() {
		getConnection();
		sql = "select " + columns + ", user_regist from member ";
		List list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setUserAddr(rs.getString("user_addr"));
				dto.setUserBirth(rs.getTimestamp("user_birth"));
				dto.setUserEmail(rs.getString("user_email"));
				dto.setUserGender(rs.getString("user_gender"));
				dto.setUserId(rs.getString("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserPh1(rs.getString("user_ph1"));
				dto.setUserPh2(rs.getString("user_ph2"));
				dto.setUserRegist(rs.getTimestamp("user_regist"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public MemberDTO memberOneSelect(String userId) {
		MemberDTO dto = new MemberDTO();
		getConnection();
		sql = "select " + columns + " from member where user_id =?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setUserAddr(rs.getString("user_addr"));
				dto.setUserBirth(rs.getTimestamp("user_birth"));
				dto.setUserEmail(rs.getString("user_email"));
				dto.setUserGender(rs.getString("user_gender"));
				dto.setUserId(rs.getString("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserPh1(rs.getString("user_ph1"));
				dto.setUserPh2(rs.getString("user_ph2"));
				dto.setUserRegist(rs.getTimestamp("user_regist"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	public Integer userCheck(String userId,String userPw) {
		Integer result = null; 
		getConnection();
		sql = "select user_pw from member "
			+ "where user_id =? and join_ok is not null";
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPw = rs.getString("user_pw");
				if(userPw.equals(dbPw)) {
					result = 1; // 로그인
				}else { 
					result = 0;// 비밀번호가 틀림
				}
			}else {
				result = -1; // 아이디가 존재하지 않음.
			}
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
		sql = "select user_id FROM member where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
	public Integer insertMember(MemberDTO member) {
		Integer result = null;
		getConnection();
		sql = "insert into member( "+ columns +" ) "
			+ " values(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setTimestamp(4, member.getUserBirth());
			pstmt.setString(5, member.getUserGender());
			pstmt.setString(6, member.getUserEmail());
			pstmt.setString(7, member.getUserAddr());
			pstmt.setString(8, member.getUserPh1());
			pstmt.setString(9, member.getUserPh2());
			result = pstmt.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {	close(); }
		return result;
	}
}