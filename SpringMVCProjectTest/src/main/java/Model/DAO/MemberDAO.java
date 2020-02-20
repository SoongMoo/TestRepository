package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.MemberDTO;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	final String columns = "user_id,user_pw,user_name,user_birth," 
			+ "user_gender,user_email,user_addr, user_ph1,user_ph2,"
			+ " USER_REGIST ";
	private RowMapper<MemberDTO> memRowMapper = 
			new RowMapper<MemberDTO>() {
		public MemberDTO mapRow(ResultSet rs, 
				int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			MemberDTO member = new MemberDTO();
			member.setUserId(rs.getString("USER_ID"));
			member.setUserName(rs.getString("USER_NAME"));
			member.setUserEmail(rs.getString("USER_EMAIL"));
			member.setUserPh1(rs.getString("USER_PH1"));
			member.setUserRegist(rs.getTimestamp("USER_REGIST"));
			member.setUserAddr(rs.getString("USER_ADDR"));
			member.setUserBirth(rs.getTimestamp("USER_BIRTH"));
			member.setUserGender(rs.getString("USER_GENDER"));
			member.setUserPh2(rs.getString("USER_PH2"));
			member.setUserPw(rs.getString("USER_pw"));
			return member;
		}
	};
	@Autowired
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Integer pwUpdate(String userId, String pw, String newPw) {
		String sql = "update member "
				+ "   set user_pw = ?"
				+ "   where USER_ID = ? and USER_PW = ?  ";
		System.out.println();
		System.out.println("pwUpdate : " + pw);
		System.out.println("pwUpdate : " + newPw);
		System.out.println("pwUpdate : " + userId);
		return jdbcTemplate.update(sql,newPw,userId,pw);
	}
	public Integer memberModify(MemberDTO member) {
		String sql = " update member "
				+ "   set USER_EMAIL = ?, USER_ADDR = ?, "
				+ "       USER_PH1 = ? , USER_PH2 = ?"
				+ "   where USER_ID = ? and USER_PW = ?  ";
		Integer i = jdbcTemplate.update(sql, 
				member.getUserEmail(), member.getUserAddr(),
				member.getUserPh1(),member.getUserPh2(),
				member.getUserId(),member.getUserPw());
		return i ;
	}
	public List<MemberDTO> selectList(){
		String sql = "select " + columns + " from member ";
		List<MemberDTO> results = 
				jdbcTemplate.query(sql, memRowMapper);
		return results;
	}
	public  MemberDTO selectByUserId(MemberDTO member) {
		String sql = "select " + columns 
				+ " from member where USER_ID = ?" ;
		List<MemberDTO> results = 
				jdbcTemplate.query(sql, memRowMapper ,member.getUserId());
		return 	results.isEmpty() ? null : results.get(0);
	}
	public int count() {
		String sql ="select count(*) from member";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	public Integer insertMember(MemberDTO memberDTO) {
		Integer i = 0;
		String sql = "insert into member( "+ columns +" ) "
				+ " values(?,?,?,?,?,?,?,?,?,sysdate)";
		i = jdbcTemplate.update(sql,
				memberDTO.getUserId(),memberDTO.getUserPw(),
				memberDTO.getUserName(), memberDTO.getUserBirth(),
				memberDTO.getUserGender(), memberDTO.getUserEmail(), 
				memberDTO.getUserAddr(), memberDTO.getUserPh1(), 
				memberDTO.getUserPh2());
		return i;
	}
	
	
	
}
