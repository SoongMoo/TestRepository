package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDetailService;

@Controller
public class LibraryBoardDetailController {
	@Autowired
	private LibraryBoardDetailService libraryBoardDetailService;
	@RequestMapping("/libraryBoard/boardDetail")
	public String boardView(@RequestParam(value="num") Long boardNum,
			Model model) {
		String tableName = "libraryboard";
		libraryBoardDetailService.boardView(boardNum,model,tableName,0);
		return "LibraryBoard/board_view";
	}
	@RequestMapping("/libraryBoard/boardModify")
	public String libraryModify(@RequestParam(value = "num") Long boardNum ,
			Model model) {
		String tableName = "libraryboard";
		libraryBoardDetailService.boardView(boardNum, model, tableName,1);
		return "LibraryBoard/board_modify";
	}
}
