package Service.Library;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardDeleteService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	public String libraryDelete(
			String boardNum,String boardPass,
			HttpServletRequest request) {
		LibraryBoardDTO dto = 
				libraryBoardDAO.boardDetail(Long.parseLong(boardNum),
						                         "libraryboard");
		Integer i = 
				libraryBoardDAO.libraryDelete(boardNum,
						Encrypt.getEncryption(boardPass));
		String path="";
		if(i > 0 ) {
			String RealPath = "WEB-INF\\view\\LibraryBoard\\update\\";
			String filePath = 
					request.getServletContext().getRealPath(RealPath);
			String [] storeFileName = dto.getStoreFileName().split("-");
			for(String f : storeFileName) {
				File file = new File(filePath + "\\" + f);
				file.delete();
			}
			path = "redirect:/libraryBoard/library";
		}else {
			request.setAttribute("passError", "비밀번호가 틀렸습니다.");
			request.setAttribute("num" , boardNum);
			path = "LibraryBoard/board_delete";
		}
		return path;
	}
}
