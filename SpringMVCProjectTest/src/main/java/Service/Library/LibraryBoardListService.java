package Service.Library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

public class LibraryBoardListService {
	@Autowired
	LibraryBoardDAO libraryBoardDAO;
	public void libraryBoardList(Model model, Integer page) {
		int nowPage = 1;
		if(page != null) {
			nowPage = page;
		}
		int limit = 10; 
		int limitPage = 10 ;
		List<LibraryBoardDTO> lists = 
				libraryBoardDAO.BoardList(nowPage,limit);
		model.addAttribute("boards", lists);
	}
}
