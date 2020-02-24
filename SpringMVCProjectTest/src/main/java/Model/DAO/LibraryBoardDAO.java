package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.LibraryBoardDTO;

public class LibraryBoardDAO {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private final String COLUMNS = "BOARD_NUM, USER_ID,BOARD_NAME, "
			+ " BOARD_PASS,BOARD_SUBJECT, BOARD_CONTENT,BOARD_DATE, "
			+ " IP_ADDR,READ_COUNT, ORIGINAL_FILE_NAME,STORE_FILE_NAME,"
			+ " FILE_SIZE ";
	private RowMapper<LibraryBoardDTO> libraryBoardMapper =
				new RowMapper<LibraryBoardDTO>() {
		public LibraryBoardDTO mapRow(ResultSet rs, int rowNum) 
				throws SQLException {
			LibraryBoardDTO dto = new LibraryBoardDTO();
			dto.setBoardContent(rs.getString("BOARD_CONTENT"));
			dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
			dto.setBoardName(rs.getString("BOARD_NAME"));
			dto.setBoardNum(rs.getInt("BOARD_NUM"));
			dto.setBoardPass(rs.getString("BOARD_PASS"));
			dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
			dto.setFileSize(rs.getLong("FILE_SIZE"));
			dto.setIpAddr(rs.getString("IP_ADDR"));
			dto.setOriginalfileName(rs.getString("ORIGINAL_FILE_NAME"));
			dto.setReadCount(rs.getInt("READ_COUNT"));
			dto.setStoreFileName(rs.getString("STORE_FILE_NAME"));
			dto.setUserId(rs.getString("USER_ID"));
			return dto;
		}	
	};
	@Autowired
	public LibraryBoardDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Integer libraryDelete(String boardNum,String boardPass) {
		sql = " delete from libraryboard"
			+ " where BOARD_NUM = ? and BOARD_PASS =? ";
		return jdbcTemplate.update(sql,boardNum,boardPass);
	}
	public Integer libraryBoardUpdate(LibraryBoardDTO dto) {
		sql = "update libraryboard "
			+ " set BOARD_SUBJECT = ? , BOARD_CONTENT = ? "
			+ " where BOARD_NUM = ? and BOARD_PASS =? ";
		return jdbcTemplate.update(sql,dto.getBoardSubject(),
				dto.getBoardContent(),dto.getBoardNum(),
				dto.getBoardPass());
	}
	public void boardReadcountUpdate(Long boardNum) {
		sql = "update libraryboard "
			+ " set READ_COUNT = READ_COUNT + 1 "
			+ " where BOARD_NUM = ?";
		jdbcTemplate.update(sql,boardNum);
	}
	public LibraryBoardDTO boardDetail(Long boardNum, String tablename) {
		sql = " select " + COLUMNS + "from  " + tablename
			+ " where BOARD_NUM = ?";
		List<LibraryBoardDTO> list =
				jdbcTemplate.query(sql, libraryBoardMapper , boardNum );
		return list.isEmpty() ? null : list.get(0);
	}
	public Integer count() {
		sql = "select count(*) from libraryboard ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	public List<LibraryBoardDTO> BoardList(int page, int limit){
		sql = " select  * "
			+ "from (select rownum rn , " + COLUMNS 
			+ " from ( select " + COLUMNS + " from libraryboard "
					+ " order by BOARD_NUM desc)) "
			+ " where rn >= ? and rn <= ? ";
		int startrow = (page -1) * limit + 1;
		int endrow	= 	startrow + limit -1;
		return jdbcTemplate.query(sql, libraryBoardMapper, 
				startrow, endrow);
	}
	public void libraryInsert(LibraryBoardDTO dto) {
		sql = "insert into libraryboard (" + COLUMNS + ") "
			+ " values (num_seq.nextval, ?, ?,?,?,?,sysdate,?,0,"
			+ "null,null,null)";
		jdbcTemplate.update(sql, dto.getUserId(),dto.getBoardName(),
				dto.getBoardPass(),dto.getBoardSubject(),
				dto.getBoardContent(),dto.getIpAddr());
	}
}