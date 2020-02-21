package Controller.AnswerBoard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class BoardWritePro {
	public String execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String path = null;
		String filePath = "AnswerBoard\\update";
		String realPath = request.getRealPath(filePath);
		int fileSize = 1024*1024*5;
		
		try {
			MultipartRequest multi = 
					new MultipartRequest(request, realPath, fileSize,
							 "UTF-8", new DefaultFileRenamePolicy());
				AnswerBoardDTO dto = new AnswerBoardDTO();
				dto.setBoardContent(multi.getParameter("BOARD_CONTENT"));
				dto.setBoardName(multi.getParameter("BOARD_NAME"));
				dto.setBoardPass(multi.getParameter("BOARD_PASS"));
				dto.setBoardSubject(multi.getParameter("BOARD_SUBJECT"));
				
				// 추가내용
				dto.setOriginalfileName(
						multi.getOriginalFileName("BOARD_FILE"));
				dto.setStoreFileName(
						multi.getFilesystemName("BOARD_FILE"));
				File f = multi.getFile("BOARD_FILE");
				dto.setFileSize(f.length());
				
				dto.setIpAddr(request.getRemoteAddr());
				HttpSession session = request.getSession();
				dto.setUserId((String)session.getAttribute("memId"));
				
				AnswerBoardDAO dao =  new AnswerBoardDAO();
				Integer result = dao.boardInsert(dto);
			
			if(result == 0) {
				path = "BoardWrite.ab";
			}else {
				path = "answerBoard.ab";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}