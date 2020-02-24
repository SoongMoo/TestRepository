package Controller.Library;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Library.LibraryBoardCommand;
import Validator.LibraryBoardModifyValidator;

@Controller
public class LibraryBoardModifyProController {
	@RequestMapping("/libraryBoard/boardModifyPro")
	public String ModifyPro(LibraryBoardCommand board, Errors errors) {
		new LibraryBoardModifyValidator().validate(board, errors);
		if(errors.hasErrors()) {
			return "LibraryBoard/board_modify";
		}
		return "LibraryBoard/board_detail";
	}
}
