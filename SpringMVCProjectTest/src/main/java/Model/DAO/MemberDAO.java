package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import Model.DTO.MemberDTO;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	final String columns = "user_id,user_pw,user_name,user_birth," 
			+ "user_gender,user_email,user_addr, user_ph1,user_ph2 ";
	@Autowired
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Integer insertMember(MemberDTO memberDTO) {
		Integer i = 0;
		String sql = "insert into member( "+ columns +" ) "
				+ " values(?,?,?,?,?,?,?,?,?)";
		i = jdbcTemplate.update(sql,
				memberDTO.getUserId(),memberDTO.getUserPw(),
				memberDTO.getUserName(), memberDTO.getUserBirth(),
				memberDTO.getUserGender(), memberDTO.getUserEmail(), 
				memberDTO.getUserAddr(), memberDTO.getUserPh1(), 
				memberDTO.getUserPh2());
		return i;
	}
	
	
	
}
