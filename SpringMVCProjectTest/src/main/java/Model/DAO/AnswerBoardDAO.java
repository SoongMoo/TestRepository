package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.AnswerBoardDTO;

public class AnswerBoardDAO {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private final String COLUMNS = "BOARD_NUM, USER_ID, BOARD_NAME, BOARD_PASS,"
			+ "BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE, IP_ADDR, READ_COUNT,"
			+ " ORIGINAL_FILE_NAME, STORE_FILE_NAME,FILE_SIZE,  "
			+ " BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ";
	private RowMapper<AnswerBoardDTO> answerBoardMapper = 
			new RowMapper<AnswerBoardDTO>() {
				public AnswerBoardDTO mapRow(ResultSet rs, int rowNum) 
						throws SQLException {
					// TODO Auto-generated method stub
					AnswerBoardDTO dto = new AnswerBoardDTO();
					dto.setBoardContent(rs.getString("BOARD_CONTENT"));
					dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
					dto.setBoardName(rs.getString("BOARD_NAME"));
					dto.setBoardNum(rs.getInt("BOARD_NUM"));
					dto.setBoardPass(rs.getString("BOARD_PASS"));
					dto.setBoardReLev(rs.getInt("BOARD_RE_LEV"));
					dto.setBoardReRef(rs.getInt("BOARD_RE_REF"));
					dto.setBoardReSeq(rs.getInt("BOARD_RE_SEQ"));
					dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
					dto.setFileSize(rs.getString("FILE_SIZE"));
					dto.setIpAddr(rs.getString("IP_ADDR"));
					dto.setOriginalfileName(rs.getString("ORIGINAL_FILE_NAME"));
					dto.setReadCount(rs.getInt("READ_COUNT"));
					dto.setStoreFileName(rs.getString("STORE_FILE_NAME"));
					dto.setUserId(rs.getString("USER_ID"));
					return dto;
				}
	};

	@Autowired
	public AnswerBoardDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<AnswerBoardDTO> answerAllSelect(){
		sql = "select " + COLUMNS + " from answerboard";
		List<AnswerBoardDTO> list = 
				jdbcTemplate.query(sql, answerBoardMapper);
		return list;
	}
	public void answerInsert(AnswerBoardDTO dto) {
		sql = "insert into answerboard( " + COLUMNS + " ) "
			+ " values (num_seq.nextval,?,?,?,?,?,sysdate,?,0,?,?,?, "
			+ " num_seq.currval, 0, 0) ";
		System.out.println();
		
		System.out.println(sql);
		jdbcTemplate.update(sql, dto.getUserId(),dto.getBoardName(),
				dto.getBoardPass(),dto.getBoardSubject(),dto.getBoardContent(),
				dto.getIpAddr(), dto.getOriginalfileName(), 
				dto.getStoreFileName(), dto.getFileSize());
	}  
}
