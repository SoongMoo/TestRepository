package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.BoardDTO;
import Model.DTO.MemberDTO;

public class BoardDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BoardDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	final String columns = "board_num,user_id,board_name,board_pass,"
			+ "board_subject,board_content,board_date,ip_addr,read_count";
	
	
	private RowMapper<BoardDTO> boardRowMapper = 
			new RowMapper<BoardDTO>() {
		public BoardDTO mapRow(ResultSet rs, 
				int rowNum) throws SQLException {
			
		BoardDTO board = new BoardDTO();
		board.setBoardNum(rs.getInt("board_num"));
		board.setUserId(rs.getString("user_id"));
		board.setBoardName(rs.getString("board_name"));
		board.setBoardPass(rs.getString("board_pass"));
		board.setBoardSubject(rs.getString("board_subject"));
		board.setBoardContent(rs.getString("board_content"));
		board.setBoardDate(rs.getTimestamp("board_date"));
		board.setIpAddr(rs.getString("ip_addr"));
		board.setReadCount(rs.getInt("read_count"));
		return board;
	}
};
	public void insertBoard(BoardDTO dto) {
		String sql = " insert into board(" + columns + ")" + " values(num_seq.nextval,?,?,?,?,?,default,?,0)";
		jdbcTemplate.update(sql, dto.getUserId(), dto.getBoardName(), dto.getBoardPass(), dto.getBoardSubject(),
				dto.getBoardContent(), dto.getIpAddr());

	}
	

	public List<BoardDTO> allSelect() {
		String sql = "select " + columns + " from board";
		List<BoardDTO> result = jdbcTemplate.query(sql,boardRowMapper );
		return result;
		
	}
	public int count() {
		String sql ="select count(*) from board";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}

	public BoardDTO selectOneBoard(BoardDTO board) {
		String sql ="select " +columns + " from board where board_num=?";
		List<BoardDTO> results = jdbcTemplate.query(sql,boardRowMapper,board.getBoardNum());
		return results.isEmpty() ? null : results.get(0);
		
	}
}
