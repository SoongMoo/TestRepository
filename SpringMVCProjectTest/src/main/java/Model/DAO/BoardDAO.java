package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.BoardDTO;

public class BoardDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BoardDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	final String columns = "board_num,user_id,board_name,board_pass,"
			+ "board_subject,board_content,board_date,ip_addr,read_count";

	public void insertBoard(BoardDTO dto) {
		String sql = " insert into board(" + columns + ")" + " values(num_seq.nextval,?,?,?,?,?,default,?,0)";
		jdbcTemplate.update(sql, dto.getUserId(), dto.getBoardName(), dto.getBoardPass(), dto.getBoardSubject(),
				dto.getBoardContent(), dto.getIpAddr());

	}

	public void allSelect() {
		String sql = "select " + columns + " from board";
		List<BoardDTO> result = jdbcTemplate.query(sql, 
				new RowMapper<BoardDTO>() {

					public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						
						return null;
					}
			
		})
	}

}
