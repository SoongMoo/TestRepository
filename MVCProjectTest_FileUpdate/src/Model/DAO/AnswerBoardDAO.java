package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.AnswerBoardDTO;

public class AnswerBoardDAO {
	DataBaseInfo info;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	String subquery = "select nvl(max(board_num),0)+1 from boarder";
	public AnswerBoardDAO() {
		this.info = new  DataBaseInfo();
	}
	public void boardReply(AnswerBoardDTO board) {
		try {
			sql = " update boarder "
				+ " set board_re_seq = board_re_seq + 1 "
				+ " where board_re_ref = ? and board_re_seq > ? ";
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardReRef());
			pstmt.setInt(2, board.getBoardReSeq());
			pstmt.executeUpdate();
			
			int seq= board.getBoardReSeq()+1;
			int lev = board.getBoardReLev()+1;
			
			sql = "insert into BOARDER(BOARD_NUM, user_id, BOARD_NAME, "
					+ " BOARD_PASS, BOARD_SUBJECT,BOARD_CONTENT, "
					+ " BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ,"
					+ " BOARD_READCOUNT,BOARD_DATE ) values(("
					+ subquery 
					+ ") ,?,?,?,?,?,?,?,?,0,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getUserId());
			pstmt.setString(2, board.getBoardName());
			pstmt.setString(3, board.getBoardPass());
			pstmt.setString(4, board.getBoardSubject());
			pstmt.setString(5, board.getBoardContent());
			pstmt.setInt(6, board.getBoardReRef());
			pstmt.setInt(7, lev);
			pstmt.setInt(8, seq);
			pstmt.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
	}
	public Integer boardDelete(String userId,String boardNum,String boardPass) {
		Integer result = 0;
		sql = " delete from boarder "
			+ " where  user_id =? and BOARD_PASS = ? and BOARD_NUM =?";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, boardPass);
			pstmt.setInt(3, Integer.parseInt(boardNum));
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;
	}
	public Integer boardModify(AnswerBoardDTO board) {
		Integer result = 0;
		sql = " update boarder "
			+ " set BOARD_NAME = ?, BOARD_SUBJECT = ?,"
			+ "     BOARD_CONTENT = ?"
			+ " where  user_id =? and BOARD_PASS = ? "
			+ " and BOARD_NUM =?";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardName());
			pstmt.setString(2, board.getBoardSubject());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getUserId());
			pstmt.setString(5, board.getBoardPass());
			pstmt.setInt(6, board.getBoardNum());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;
	}
	public AnswerBoardDTO getDetail(Integer boardNum) {
		AnswerBoardDTO board = new AnswerBoardDTO();
		sql = " select BOARD_NUM,user_id, BOARD_NAME, BOARD_PASS,"
				+ " BOARD_SUBJECT, BOARD_CONTENT,BOARD_RE_REF,"
				+ "  BOARD_RE_LEV,BOARD_RE_SEQ ,BOARD_READCOUNT,"
				+ " BOARD_DATE from boarder "
				+ " where  BOARD_NUM = ?";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBoardNum(rs.getInt(1));
				board.setUserId(rs.getString(2));
				board.setBoardName(rs.getString(3));
				board.setBoardPass(rs.getString(4));
				board.setBoardSubject(rs.getString(5));
				board.setBoardContent(rs.getString(6));
				board.setBoardReRef(rs.getInt(7));
				board.setBoardReLev(rs.getInt(8));
				board.setBoardReSeq(rs.getInt(9));
				board.setBoardReadcount(rs.getInt(10));
				board.setBoardDate(rs.getTimestamp(11));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		
		return board;
	}
	public void setReadCountUpdate(Integer boardNum) {
		sql = "update boarder "
			+ " set BOARD_READCOUNT = BOARD_READCOUNT + 1 "
			+ " where BOARD_NUM = ? ";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
	}
	public Integer getCount() {
		Integer result = null;
		sql="select count(*) from boarder";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;
	}
	public List<AnswerBoardDTO> getBoardList(){
		List<AnswerBoardDTO> list = new ArrayList<AnswerBoardDTO>();
		try {
			conn = info.getConnection();
			sql = " select BOARD_NUM,user_id, BOARD_NAME, BOARD_PASS,"
				+ " BOARD_SUBJECT, BOARD_CONTENT,BOARD_RE_REF,"
				+ "  BOARD_RE_LEV,BOARD_RE_SEQ ,BOARD_READCOUNT,"
				+ " BOARD_DATE from boarder "
				+ " order by BOARD_RE_REF DESC, BOARD_RE_SEQ asc ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnswerBoardDTO board = new AnswerBoardDTO();
				board.setBoardNum(rs.getInt("BOARD_NUM"));
				board.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				board.setBoardName(rs.getString("BOARD_NAME"));
				board.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				board.setBoardReadcount(rs.getInt("BOARD_READCOUNT"));
				board.setBoardReLev(rs.getInt("BOARD_RE_LEV"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return list;
	}
	public Integer boardInsert(AnswerBoardDTO board) {
		Integer result = null;
		try {
			conn = info.getConnection();
			sql = "insert into BOARDER(BOARD_NUM, user_id, BOARD_NAME, "
				+ " BOARD_PASS, BOARD_SUBJECT,BOARD_CONTENT, "
				+ " BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ,"
				+ " BOARD_READCOUNT,BOARD_DATE ) values(("
				+ subquery 
				+ ") ,?,?,?,?,?,(" 
				+ subquery 
				+ "),0,0,0,sysdate)";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getUserId());
			pstmt.setString(2, board.getBoardName());
			pstmt.setString(3, board.getBoardPass());
			pstmt.setString(4, board.getBoardSubject());
			pstmt.setString(5, board.getBoardContent());
			result = pstmt.executeUpdate(); 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
