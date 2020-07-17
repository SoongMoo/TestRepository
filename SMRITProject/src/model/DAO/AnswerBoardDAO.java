package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.AnswerBoardDTO;
import model.DTO.LibBoardDTO;

public class AnswerBoardDAO extends DataBaseInfo {
	final String COLUMNS = 
			"BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,"
		  + "BOARD_SUBJECT,BOARD_CONTENT,BOARD_DATE,"
		  + " IP_ADDR,READ_COUNT,ORIGINAL_FILE_NAME,"
		  + " STORE_FILE_NAME,FILE_SIZE,"
		  + " BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ ";
	public void answerReplyInsert(AnswerBoardDTO dto) {
		Long lev = dto.getBoardReLev()+1;
		Long seq = dto.getBoardReSeq()+1;
		conn = getConnection(); 
		sql = " insert into AnswerBoard (" + COLUMNS + ")"
			+ " values(NUM_SEQ.nextval,?,?,?,?,?,sysdate,"
			+ " ?,0,null,null,0, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			pstmt.setLong(7, dto.getBoardReRef());
			pstmt.setLong(8,lev);
			pstmt.setLong(9,seq);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		}catch(Exception e) {e.printStackTrace();			
		}finally {close();}
	}
	public void answerSeqUpdate(AnswerBoardDTO dto) {
		conn = getConnection();
		sql = " update answerboard "
			+ " set board_re_seq = board_re_seq + 1 "
			+ " where board_re_seq > ? "
			+ " and board_Re_Ref = ? ";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setLong(1, dto.getBoardReSeq());
			pstmt.setLong(2, dto.getBoardReRef());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Integer fileUpdate(AnswerBoardDTO dto) {
		Integer i = 0;
		conn = getConnection();
		sql = " update answerboard "
			+ " set original_file_name = ? ,"
			+ "		store_file_name = ? ,"
			+ "     file_size = ? "
			+ " where board_num = ? "
			+ "   and board_pass = ?"
			+ "   and user_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 
					dto.getOriginalFileName());
			pstmt.setString(2, 
					dto.getStoreFileName());
			pstmt.setLong(3, dto.getFileSize());
			pstmt.setLong(4, dto.getBoardNum());
			pstmt.setString(5, dto.getBoardPass());
			pstmt.setString(6, dto.getUserId());
			i = pstmt.executeUpdate();
			System.out.println(i+"개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return i;
	}
	public void ansContentUpdate(AnswerBoardDTO dto) {
		conn = getConnection();
		sql = " update answerboard "
			+ " set board_subject = ? ,"
			+ "     board_content = ?  "
			+ " where board_num =? "
			+ " and board_pass =?  "
			+ " and user_id  = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardSubject());
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setLong(3, dto.getBoardNum());
			pstmt.setString(4, dto.getBoardPass());
			pstmt.setString(5, dto.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
				
	}
	public Integer ansboardDelete(String boardNum,
			String boardPass, String userId ) {
		Integer i = 0;
		conn = getConnection();
		sql = "delete from answerboard "
			 +"where board_num =? and board_pass =?"
			 + " and user_id =? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			pstmt.setString(2, boardPass);
			pstmt.setString(3, userId);
			i = pstmt.executeUpdate();
			System.out.println(i +"개가 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return i;
	}
	public Integer ansCount() {
		Integer i = 0;
		conn = getConnection();
		sql = "select count(*) from answerboard";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}
		}catch(Exception e){e.printStackTrace();}
		finally {close();}
		return i;
	}
	public List<AnswerBoardDTO> ansSelectAll(
			int page, int limit, String num){
		List<AnswerBoardDTO> list =
				new ArrayList<AnswerBoardDTO>();
		int startRow = (page -1) * limit +1;
		int endRow = startRow + limit -1;
		
		String condition = "";
		if( num != null) 
			condition = " and board_num = '" + num + "'";
		conn = getConnection();
		sql = " select * "
			+ " from (select rownum rn, " + COLUMNS
			+ " 	 from (select  " + COLUMNS 
			+ " 	       from answerboard "
			+ "            where 1=1 " + condition
			+ "			   order by board_re_ref desc,"
			+ "                     board_re_seq asc))"
			+ " where rn between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AnswerBoardDTO dto = 
						new AnswerBoardDTO();
				dto.setBoardContent(rs.getString("Board_Content"));
				dto.setBoardDate(rs.getTimestamp("Board_Date"));
				dto.setBoardName(rs.getString("Board_Name"));
				dto.setBoardNum(rs.getLong("Board_Num"));
				dto.setBoardPass(rs.getString("Board_Pass"));
				dto.setBoardSubject(rs.getString("Board_Subject"));
				dto.setFileSize(rs.getLong("File_Size"));
				dto.setIpAddr(rs.getString("Ip_Addr"));
				dto.setOriginalFileName(
						rs.getString("Original_File_Name"));
				dto.setReadCount(rs.getLong("Read_Count"));
				dto.setStoreFileName(rs.getString("Store_File_Name"));
				dto.setUserId(rs.getString("user_id"));
				dto.setBoardReLev(rs.getLong("BOARD_RE_LEV"));
				dto.setBoardReRef(rs.getLong("BOARD_RE_REF"));
				dto.setBoardReSeq(rs.getLong("BOARD_RE_SEQ"));
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		
		return list;
	}
	public void ansInsert(AnswerBoardDTO dto) {
		conn = getConnection(); 
		sql = " insert into AnswerBoard (" + COLUMNS + ")"
			+ " values(NUM_SEQ.nextval,?,?,?,?,?,sysdate,"
			+ " ?,0,?,?,?, NUM_SEQ.currval, 0, 0)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			pstmt.setString(7, dto.getOriginalFileName());
			pstmt.setString(8, dto.getStoreFileName());
			pstmt.setLong(9, dto.getFileSize());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		}catch(Exception e) {e.printStackTrace();			
		}finally {close();}
	}
}
