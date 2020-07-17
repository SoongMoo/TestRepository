package controller.libBoard;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibBoardModifyAction {
	public String execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String realPath = 
				request.getServletContext()
				       .getRealPath("/lib_Board/upload");
		int limitSize= 1024 * 1024 * 5;
		String boardNum = null;
		String boardSubject = null;
		String boardContent = null;
		String boardPass = null;
		HttpSession session = request.getSession();
		String userId = 
				(String)session.getAttribute("logId");
		MultipartRequest multi = null;
		LibBoardDTO dto = new  LibBoardDTO();
		LibBoardDAO dao = new LibBoardDAO();
		try {
			multi = new MultipartRequest(request,
					realPath,limitSize,	"utf-8",
					new DefaultFileRenamePolicy());
			boardNum = 
					multi.getParameter("boardNum");
			boardSubject = 
					multi.getParameter(
							"boardSubject");
			boardContent =
					multi.getParameter("boardContent");
			boardPass =
					multi.getParameter("boardPass");
			dto.setBoardContent(boardContent);
			dto.setBoardNum(Long.parseLong(boardNum));
			dto.setBoardPass(boardPass);
			dto.setBoardSubject(boardSubject);
			dto.setUserId(userId);
			dao.libContentUpdate(dto);
			File file = null;
			if(multi.getFile("fileUp") == null) {// 파일이 없는 경우
				if(!multi.getParameter("fileDel").trim().equals("")) { // 파일 삭제
					dto.setOriginalFileName("");
					dto.setStoreFileName("");
					dto.setFileSize(0L);
					int i = dao.fileUpdate(dto);
					if( i >= 1) {
						String fl = multi.getParameter("fileDel");
						file = new File(realPath + "/" + fl);
						if(file.exists()) file.delete();	
					}
				}
			}else { // 파일이 있는 경우
				String originalFileName =
						multi.getOriginalFileName("fileUp");
				String storeFileName =
						multi.getFilesystemName("fileUp");
				file = multi.getFile("fileUp");
				Long fileSize = file.length();
				dto.setOriginalFileName(originalFileName);
				dto.setStoreFileName(storeFileName);
				dto.setFileSize(fileSize);
				int i = dao.fileUpdate(dto);
				if(i >= 1) {
					String fl = 
							multi.getParameter("fileDel");
					file = new File(realPath + "/" + fl);
					if(file.exists()) file.delete();	
				}
			}
			
		}catch(Exception e) {e.printStackTrace();}
		return boardNum;
	}
}
