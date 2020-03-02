

package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Library.LibraryBoardCommand;
import Service.Library.LibraryModifyService;
import Validator.LibraryBoardModifyValidator;

@Controller
public class LibraryBoardModifyProController {
	@Autowired
	LibraryModifyService libraryModifyService;
	@RequestMapping("/libraryBoard/boardModifyPro")
	public String ModifyPro(LibraryBoardCommand libraryBoardCommand, 
			Errors errors) {
		new LibraryBoardModifyValidator().validate(libraryBoardCommand, errors);
		if(errors.hasErrors()) {
			return "LibraryBoard/board_modify";
		}
		String path = libraryModifyService.modifyPro(libraryBoardCommand,errors);
		return path;
	}
}
