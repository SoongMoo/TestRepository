package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.AnswerBoardDTO;

public class AnswerBoardDAO extends DataBaseInfo{
	final String columns =" BOARD_NUM, USER_ID, BOARD_NAME,BOARD_PASS,"
            + " BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE,"
            + " IP_ADDR, READ_COUNT, "
            + "  Original_File_Name, Store_File_Name, file_size ,  "
            + "  board_re_ref, board_re_lev, board_re_seq";
	
	final String subquery = "select nvl(max(board_num),0) + 1 "
	        + " from answerboard";
	
	public void boardReply(AnswerBoardDTO dto) {
		getConnection();
		sql = " update answerboard "
			+ " set board_re_seq = board_re_seq +1 "
			+ " where board_re_ref = ? and board_re_seq > ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoardReRef());
			pstmt.setInt(2, dto.getBoardReSeq());
			pstmt.executeUpdate();
			
			int lev = dto.getBoardReLev() + 1;
			int seq = dto.getBoardReSeq() + 1;
			sql = "insert into answerboard (" + columns + " ) "
				+ " values (( " + subquery + " ),?,?,?,?,?,default,"
				+ " ?,0,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			pstmt.setString(7, dto.getOriginalfileName());
			pstmt.setString(8, dto.getStoreFileName());
			pstmt.setLong(9, 0);
			pstmt.setInt(10, dto.getBoardReRef());
			pstmt.setInt(11, lev);
			pstmt.setInt(12, seq);
			pstmt.executeUpdate(); 						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void boardDelete(String boardNum) {
		getConnection();
		sql="delete from answerboard where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void AnswerBoardUpdate(AnswerBoardDTO dto) {
		getConnection();
		sql = " update answerboard "
			+ " set board_subject = ?, board_content =?"
			+ " where board_num = ? and board_pass =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardSubject());
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setInt(3, dto.getBoardNum());
			pstmt.setString(4, dto.getBoardPass());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void boardCountUpdate(String boardNum) {
		getConnection();
		sql = " update answerboard "
			+ " set READ_COUNT = READ_COUNT + 1  "
			+ " where board_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public AnswerBoardDTO boardOneSelect(String boardNum) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		getConnection();
		sql = "select " + columns 
				+ " from answerboard where board_num = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			rs =  pstmt.executeQuery();
			if(rs.next()) {
				dto.setBoardNum(rs.getInt(1));
				dto.setUserId(rs.getString(2));
				dto.setBoardName(rs.getString(3));
				dto.setBoardPass(rs.getString(4));
				dto.setBoardSubject(rs.getString(5));
				dto.setBoardContent(rs.getString(6));
				dto.setBoardDate(rs.getTimestamp(7));
				dto.setIpAddr(rs.getString(8));
				dto.setReadCount(rs.getInt(9));
				//  파일 추가된 내용
				dto.setOriginalfileName(rs.getString(10));
				dto.setStoreFileName(rs.getString(11));
				dto.setFileSize(rs.getLong(12));
				
				// 답변형 추가 내용
				dto.setBoardReRef(rs.getInt(13));
				dto.setBoardReLev(rs.getInt(14));
				dto.setBoardReSeq(rs.getInt(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	public Integer boardCount() {
		Integer result = 0;
		getConnection();
		sql = "select count(*) from answerboard";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public List boardAllSelect(int page , int limit) {
		int startRow = (page -1) * limit + 1 ;
		int endRow = startRow + limit -1 ;
		List list = new ArrayList();
		System.out.println("aaaa");
		getConnection();
		sql = " select * "
			+ " from (select rownum rn ," + columns
			+ "  	  from ( select " + columns + " from answerboard "
			+ "          order by BOARD_RE_REF DESC, BOARD_RE_SEQ ASC))"
			+ " where rn >= ? and rn <= ? ";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnswerBoardDTO dto = new AnswerBoardDTO();
				dto.setBoardNum(rs.getInt(2));
				dto.setUserId(rs.getString(3));
				dto.setBoardName(rs.getString(4));
				dto.setBoardPass(rs.getString(5));
				dto.setBoardSubject(rs.getString(6));
				dto.setBoardContent(rs.getString(7));
				dto.setBoardDate(rs.getTimestamp(8));
				dto.setIpAddr(rs.getString(9));
				dto.setReadCount(rs.getInt(10));
				dto.setBoardReRef(rs.getInt(14));
				dto.setBoardReLev(rs.getInt(15));
				dto.setBoardReSeq(rs.getInt(16));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public Integer boardInsert(AnswerBoardDTO dto) {
		Integer result = 0;
		getConnection();
		sql = "insert into answerboard( " + columns + " ) "
			+ " values((" + subquery + "), ?,?,?,?,?,default,?,0,?,?,?,"
			+ " ("+ subquery + ") , 0 , 0)";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			// 파일 내용 추가
			pstmt.setString(7, dto.getOriginalfileName());
			pstmt.setString(8, dto.getStoreFileName());
			pstmt.setLong(9, dto.getFileSize());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
}









