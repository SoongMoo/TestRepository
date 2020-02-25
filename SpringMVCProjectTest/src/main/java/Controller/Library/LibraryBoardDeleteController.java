package Controller.Library;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDeleteService;

@Controller
@RequestMapping("/libraryBoard/boardDelete")
public class LibraryBoardDeleteController {
	 @Autowired 
	 LibraryBoardDeleteService libraryBoardDeleteService;
	@RequestMapping(method = RequestMethod.GET)
	public String deleteLibrary(@ModelAttribute("num") String boardNum) {
		System.out.println(boardNum);
		return "LibraryBoard/board_delete";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String deleteLibrary(
			@RequestParam(value = "boardNum") String boardNum,
			@RequestParam(value = "boardPass") String boardPass,
			HttpServletRequest request) {
		String path = libraryBoardDeleteService.libraryDelete(
										boardNum,boardPass,request);
		return 	path;
	}
}
