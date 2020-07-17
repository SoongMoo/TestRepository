package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.LibBoardDTO;

public class LibBoardDAO extends DataBaseInfo{
	final String COLUMNS = 
			"BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,"
		  + "BOARD_SUBJECT,BOARD_CONTENT,BOARD_DATE,"
		  + " IP_ADDR,READ_COUNT,ORIGINAL_FILE_NAME,"
		  + " STORE_FILE_NAME,FILE_SIZE";
	public Integer fileUpdate(LibBoardDTO dto) {
		Integer i = 0;
		conn = getConnection();
		sql = " update libraryboard "
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
	public void libContentUpdate(LibBoardDTO dto) {
		conn = getConnection();
		sql = " update libraryboard "
			+ " set board_subject = ? ,"
			+ "     board_content = ? "
			+ " where board_num =? "
			+ " and board_pass =? "
			+ " and user_id  = ? ";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardSubject());
			System.out.println(dto.getBoardSubject());
			pstmt.setString(2, dto.getBoardContent());
			System.out.println(dto.getBoardContent());
			pstmt.setLong(3, dto.getBoardNum());
			System.out.println(dto.getBoardNum());
			pstmt.setString(4, dto.getBoardPass());
			System.out.println(dto.getBoardPass());
			pstmt.setString(5, dto.getUserId());
			System.out.println(dto.getUserId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Integer libBoardDel(String boardNum) {
		Integer i = 0;
		conn = getConnection();
		sql = " delete from libraryboard "
			+ " where board_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			i = pstmt.executeUpdate();
			System.out.println(i +"개가 삭제되었습니다.");
		}catch(Exception e) { e.printStackTrace();}
		finally {close();}
		return i;
	}
	
	public Integer libCount() {
		Integer i = 0;
		conn = getConnection();
		sql = "select count(*) cnt  from libraryboard";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt("cnt");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
	}
	public List<LibBoardDTO> libSelectAll(int page,
			int limit, String num){
		int startRow = (page -1) * limit +1;
		int endRow = startRow + limit -1;
		
		String condition = "";
		if(num != null) condition = " and board_num = " + num;
		
		List<LibBoardDTO> list = new ArrayList<LibBoardDTO>();
		conn = getConnection();
		sql = "select * "
			+ "from (select rownum rn , " + COLUMNS 
			+ " 	 from (select "+ COLUMNS 
			+ " 	  	  from libraryboard where 1=1 "
			+         	  condition +" order by Board_num desc))"
			+ " where rn between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				LibBoardDTO dto = new LibBoardDTO();
				dto.setBoardContent(rs.getString("Board_Content"));
				dto.setBoardDate(rs.getTimestamp("Board_Date"));
				dto.setBoardName(rs.getString("Board_Name"));
				dto.setBoardNum(rs.getLong("Board_Num"));
				dto.setBoardPass(rs.getString("Board_Pass"));
				dto.setBoardSubject(rs.getString("Board_Subject"));
				dto.setFileSize(rs.getLong("File_Size"));
				dto.setIpAddr(rs.getString("Ip_Addr"));
				dto.setOriginalFileName(rs.getString("Original_File_Name"));
				dto.setReadCount(rs.getLong("Read_Count"));
				dto.setStoreFileName(rs.getString("Store_File_Name"));
				dto.setUserId(rs.getString("user_id"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public void libInsert(LibBoardDTO dto) {
		sql ="insert into LIBRARYBOARD ("+ COLUMNS +") "
		   + "values(NUM_SEQ.nextval,"
		   + "?,?,?,?,?,sysdate,?,0,?,?,?)";
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
