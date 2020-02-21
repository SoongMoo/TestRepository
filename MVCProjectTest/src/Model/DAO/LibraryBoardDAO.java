package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.BoardDTO;
import Model.DTO.LibraryBoardDTO;

public class LibraryBoardDAO extends DataBaseInfo{
	final String columns ="BOARD_NUM, USER_ID, BOARD_NAME,BOARD_PASS, "
            + " BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE, "
            + " IP_ADDR, READ_COUNT, original_file_name, "
            + " store_file_name, file_size ";
	public void boardDelete(String boardNum) {
		getConnection();
		sql = "delete from libraryboard where board_num = ?";
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
	public void boardUpdate(LibraryBoardDTO dto) {
		getConnection();
		sql = "update libraryboard "
			+ "set BOARD_SUBJECT = ?, BOARD_CONTENT = ? "
			+ "where BOARD_NUM = ? and BOARD_PASS = ?";
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
	public LibraryBoardDTO boardOneselect(Integer boardNum) {
		LibraryBoardDTO dto = new LibraryBoardDTO();
		getConnection();
		sql = " select  " + columns + " from libraryboard "
			+ " where board_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
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
				dto.setOriginalfileName(rs.getString(10));
				dto.setStoreFileName(rs.getString(11));
				dto.setFileSize(rs.getLong(12));
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
		sql = "select count(*) from libraryboard";
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
	public List boardAllSelect() {
		List list = new ArrayList();
		getConnection();
		sql = "select " + columns + " from libraryboard";
		try {
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				LibraryBoardDTO dto= new LibraryBoardDTO();
				dto.setBoardNum(rs.getInt(1));
				dto.setUserId(rs.getString(2));
				dto.setBoardName(rs.getString(3));
				dto.setBoardPass(rs.getString(4));
				dto.setBoardSubject(rs.getString(5));
				dto.setBoardContent(rs.getString(6));
				dto.setBoardDate(rs.getTimestamp(7));
				dto.setIpAddr(rs.getString(8));
				dto.setReadCount(rs.getInt(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	public void boardInsert(LibraryBoardDTO dto) {
		getConnection();
		String subquery = 
				"select nvl(max(board_num),0)+1 from libraryboard";
		sql = "insert into libraryboard (" + columns + ") "
			+ " values (("+ subquery +"),?,?,?,?,?,default,?,0,?,?,?)";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			pstmt.setString(7, dto.getOriginalfileName());
			pstmt.setString(8, dto.getStoreFileName());
			if(dto.getFileSize() == null) {
				pstmt.setLong(9, 0);
			}else {
				pstmt.setLong(9, dto.getFileSize());
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			close();
		}
	}
}






