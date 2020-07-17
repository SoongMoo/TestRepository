package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.MemberDTO;

public class MemberDAO extends DataBaseInfo{
	final String COLUMNS = "USER_ID, USER_PW, USER_NAME, "
			+ "USER_BIRTH,"
			+ "USER_GENDER, USER_ADDR, USER_PH1,USER_PH2,"
			+ "USER_REGIST, USER_EMAIL , interest";
	public void userMemberDel(String userId,String userPw) {
		conn = getConnection();
		sql = "delete from member "
			+ " where user_id = ? and user_pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Integer passUpdate(String userId, 
			String userPw, String newPw) {
		Integer i = 0; 
		conn = getConnection();
		sql = " update member "
			+ " set user_pw = ? "
			+ " where user_id = ? and user_pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPw);
			i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();		
		}finally {close();}
		return i;
	}
	public Integer memberLoginCk(String userId, String userPw) {
		Integer result = -1;
		conn = getConnection();
		sql = "select user_pw from member where user_id = ? "
				+ " and join_ok is not null";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPw = rs.getString(1);
				if(userPw.equals(dbPw)) {
					result = 1; // 로그인
				}else {
					result = 0; //비밀번호가 틀렸습니다.
				}
			}else {
				result = -1; // 아이디가 틀렸을 때
			}
		}
		catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return result;
	}
	public Integer joinOkUPdate(String email,String joinOk) {
		Integer result = 0;
		conn = getConnection();
		sql = "update member set join_ok = ? " 
		    + " where user_email = ? and  join_ok is null";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, joinOk);
			pstmt.setString(2, email);
			result = pstmt.executeUpdate();
			System.out.println(result + "개가 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	public String memberConfirm(String userId) {
		String id = null;
		conn = getConnection();
		sql = "select user_id from member where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return id;
	}
	public void memberDelete(MemberDTO dto) {
		int i = 0;
		conn = getConnection();
		String condition = "";
		if(dto.getUserPw()!=null) {
			condition = " and user_pw = ? ";
		}
		sql = "delete from member where user_id = ? " + condition;
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			System.out.println(dto.getUserId());
			if(dto.getUserPw()!=null) {
				pstmt.setString(2, dto.getUserPw());
			}
			i = pstmt.executeUpdate(); 
			System.out.println(i + "개가 삭제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void memberUpdate(MemberDTO dto) {
		conn = getConnection();
		sql = " update member "
			+ " set USER_ADDR= ? , USER_PH1= ?, USER_PH2= ?,"
			+ "     USER_EMAIL = ?"
			+ "  where user_id = ? and user_pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserAddr());
			pstmt.setString(2, dto.getUserPh1());
			pstmt.setString(3, dto.getUserPh2());
			pstmt.setString(4, dto.getUserEmail());
			pstmt.setString(5, dto.getUserId());
			pstmt.setString(6, dto.getUserPw());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public List<MemberDTO> memberSelect(int page, 
			int limit, String userId){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int startRow = (page -1) * limit +1;
		int endRow = startRow + limit -1;
		System.out.println(startRow);
		System.out.println(endRow);
		String condition = "";
		if(userId != null) condition = " and user_id = ?";
		conn = getConnection();
		sql = " select * "
			+ " from (select rownum rn, " + COLUMNS 
			+ " 	 from (select " + COLUMNS +" from member "
			+ " 	 where 1=1 " + condition 
			+ " 	 order by USER_REGIST desc))"
			+ " where rn between ? and ? " ;
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			if(userId != null) { 
				pstmt.setString(1, userId);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}else {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setInterest(rs.getString("interest"));
				dto.setUserAddr(rs.getString("User_Addr"));
				dto.setUserBirth(rs.getTimestamp("User_Birth"));
				dto.setUserEmail(rs.getString("User_Email"));
				dto.setUserGender(rs.getString("User_Gender"));
				dto.setUserId(rs.getString("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserPh1(rs.getString("user_ph1"));
				dto.setUserPh2(rs.getString("user_ph2"));
				dto.setUserRegist(rs.getTimestamp("User_Regist"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public Integer memberCount() {
		Integer result = 0;
		conn = getConnection();
		sql = "select count(*) from member";
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
	public Integer memberInsert(MemberDTO dto) {
		Integer i = null; 
		conn = getConnection();
		sql = "insert into member ( "+ COLUMNS +" )"
			+ "values(?,?,?,?,?,?,?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			pstmt.setString(3, dto.getUserName());
			pstmt.setTimestamp(4, dto.getUserBirth());
			pstmt.setString(5, dto.getUserGender());
			pstmt.setString(6, dto.getUserAddr());
			pstmt.setString(7, dto.getUserPh1());
			pstmt.setString(8, dto.getUserPh2());
			pstmt.setString(9, dto.getUserEmail());
			pstmt.setString(10, dto.getInterest());
			i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
	}
	public String checkId(String userEmail, String userPh1) {
		// TODO Auto-generated method stub
		conn = getConnection();
		sql = "select user_id from member where user_email = ? and user_ph1 = ?";
		String userId = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, userPh1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userId = rs.getString(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			close();
		}return userId;
	}
}
