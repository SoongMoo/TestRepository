package Controller.LibraryBoard;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

public class BoardWritePro {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		
		String filePath = "LibraryBoard\\update";
		String realPath = request.getRealPath(filePath);
		int fileSize = 1024*1024*5;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, 
					realPath, fileSize, "utf-8",
					new DefaultFileRenamePolicy());
			System.out.println(realPath);
			HttpSession session = request.getSession();
			LibraryBoardDTO dto = new LibraryBoardDTO();
			
			dto.setUserId((String)session.getAttribute("memId"));
			dto.setBoardContent(multi.getParameter("BOARD_CONTENT"));
			dto.setBoardName(multi.getParameter("BOARD_NAME"));
			dto.setBoardPass(multi.getParameter("BOARD_PASS"));
			dto.setBoardSubject(multi.getParameter("BOARD_SUBJECT"));
			dto.setIpAddr(request.getRemoteAddr());

			dto.setOriginalfileName(
					multi.getOriginalFileName("BOARD_FILE"));
			dto.setStoreFileName(multi.getFilesystemName("BOARD_FILE"));
			File file = multi.getFile("BOARD_FILE");
			String  extension = null;
			if(file != null) {
				dto.setFileSize(file.length());
				String fileName =  multi.getOriginalFileName("BOARD_FILE");
				extension = fileName.substring(
						fileName.lastIndexOf("."));
				System.out.println(extension);
				if(extension.equals(".jsp") ) {
					file.delete();
					response.setContentType("text/html;charset=UTF-8");
			   		PrintWriter out=response.getWriter();
			   		out.println("<script>");
			   		out.println("alert('JSP파일은 업로드할 수 없습니.');");
			   		out.println("location.href='BoardWrite.lb';");
			   		out.println("</script>");
			   		out.close();
			   		return;
				}
			}
			LibraryBoardDAO dao = new LibraryBoardDAO();
			dao.boardInsert(dto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
