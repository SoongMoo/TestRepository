package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDeleteService;

@Controller
public class LibraryBoardDeleteController {

	 @Autowired 
	 LibraryBoardDeleteService libraryBoardDeleteService;

	@RequestMapping("/libraryBoard/boardDelete")
	public String deleteLibrary(@ModelAttribute("num") String boardNum) {
		System.out.println(boardNum);
		return "LibraryBoard/board_delete";
	}
	@RequestMapping("/libraryBoard/boardDeletePro")
	public String deleteLibrary(
			@RequestParam(value = "boardNum") String boardNum,
			@RequestParam(value = "boardPass") String boardPass,
			Model model) {
		String path = libraryBoardDeleteService.libraryDelete(
										boardNum,boardPass,model);
		return 	path;
	}
	
}
