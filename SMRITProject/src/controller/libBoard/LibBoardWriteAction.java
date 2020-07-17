package controller.libBoard;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibBoardWriteAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String filePath= "/lib_Board/upload";
		String realPath = 
				request.getServletContext().getRealPath(filePath);
		int fileSize = 1024*1024*5;
		LibBoardDTO dto = new LibBoardDTO();
		String ipAddr = request.getRemoteAddr();
		HttpSession session = request.getSession();
		String userId =(String)session.getAttribute("logId");
		try {
			MultipartRequest multi = 
					new MultipartRequest(
							request, realPath, fileSize,"utf-8" ,
							new DefaultFileRenamePolicy());
			dto.setBoardContent(multi.getParameter("boardContent"));
			dto.setBoardPass(multi.getParameter("boardPass"));
			dto.setBoardSubject(multi.getParameter("boardSubject"));
			dto.setBoardName(multi.getParameter("boardName"));
			dto.setIpAddr(ipAddr);
			dto.setUserId(userId);
			dto.setOriginalFileName(
					multi.getOriginalFileName("fileUp"));
			dto.setStoreFileName(
					multi.getFilesystemName("fileUp"));
			File file= multi.getFile("fileUp");
			dto.setFileSize(file.length());
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		LibBoardDAO dao = new LibBoardDAO();
		dao.libInsert(dto);
	}
}
