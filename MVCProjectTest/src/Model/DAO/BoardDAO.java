package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.BoardDTO;

public class BoardDAO extends DataBaseInfo{
	final String columns =" BOARD_NUM, USER_ID, BOARD_NAME,BOARD_PASS, "
			            + " BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE, "
			            + " IP_ADDR, READ_COUNT ";
	public void boardUpdate(BoardDTO dto) {
		getConnection();
		sql = "update board "
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
	public void boardCountUpdate(Integer boardNum) {
		getConnection();
		sql = "update board set READ_COUNT = READ_COUNT + 1 "
			+ " where board_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
	}
	public BoardDTO boardOneselect(Integer boardNum) {
		System.out.println(boardNum);
		BoardDTO dto = new BoardDTO();
		getConnection();
		sql = "select " + columns + " from board where board_num = ?";
		System.out.println(sql);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return dto;
	}
	public Integer boardCount() {
		Integer result = 0;
		getConnection();
		sql = "select count(*) from board";
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
		sql = "select " + columns + " from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
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
		}finally {
			close();
		}
		return list;
	}
	public Integer boardInsert(BoardDTO dto) {
		Integer result= null;
		getConnection();
		sql = " insert into board("+ columns + ")"
			+ " values(num_seq.nextval,?,?,?,?,?,default,?,0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
}
