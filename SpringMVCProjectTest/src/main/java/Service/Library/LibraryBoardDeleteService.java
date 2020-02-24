package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Contoller.Encrypt;
import Model.DAO.LibraryBoardDAO;

@Service
public class LibraryBoardDeleteService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	public String libraryDelete(
			String boardNum,String boardPass,Model model) {
		Integer i = 
				libraryBoardDAO.libraryDelete(boardNum,
						Encrypt.getEncryption(boardPass));
		String path = null;
		if(i > 0 ) {
			path = "redirect:/libraryBoard/library";
		}else {
			model.addAttribute("passError", "비밀번호가 틀렸습니다.");
			model.addAttribute("num" , boardNum);
			path = "LibraryBoard/board_delete";
		}
		return path;
	}
}
