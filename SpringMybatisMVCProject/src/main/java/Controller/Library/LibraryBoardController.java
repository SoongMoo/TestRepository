

package Controller.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Library.LibraryBoardCommand;
import Service.Library.LibraryBoardListService;
import Service.Library.LibraryBoardService;

@Controller
public class LibraryBoardController {
	@Autowired
	LibraryBoardService libraryBoardService;
	@Autowired
	LibraryBoardListService libraryBoardListService;
	@RequestMapping("/libraryBoard/library")
	public String libraryList(Model model, 
			@RequestParam(value="page", required = false) Integer page) {
		libraryBoardListService.libraryBoardList(model, page);
		return "LibraryBoard/board_list";
	}
	@RequestMapping("/libraryBoard/boardWrite")
	public String libraryWrite() {
		return "LibraryBoard/board_write";
	}
	@RequestMapping("/libraryBoard/boardWritePro")
	public String libraryWritePro(
			LibraryBoardCommand libraryBoardCommand, 
			HttpSession session,
			HttpServletRequest request){
		return 
	libraryBoardService.writePro(libraryBoardCommand, session, request);
		 
	}
	
	
	
}






