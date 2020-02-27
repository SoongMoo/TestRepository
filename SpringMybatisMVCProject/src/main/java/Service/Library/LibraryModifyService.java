package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Library.LibraryBoardCommand;
import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryModifyService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	
	public String modifyPro(LibraryBoardCommand libraryBoardCommand,
			Errors errors) {
		LibraryBoardDTO dto = new LibraryBoardDTO();
		dto.setBoardNum(libraryBoardCommand.getBoardNum());
		dto.setBoardSubject(libraryBoardCommand.getBoardSubject());
		dto.setBoardContent(libraryBoardCommand.getBoardContent());
		dto.setBoardPass(Encrypt.getEncryption(
				libraryBoardCommand.getBoardPass()));
		Integer i = libraryBoardDAO.libraryBoardUpdate(dto);
		String path= null;
		if(i > 0) {
			path = 
			"redirect:/libraryBoard/boardDetail?num="+ dto.getBoardNum();
		}else {
			errors.rejectValue("boardPass", "bad");
			path = "LibraryBoard/board_modify";
		}
		return path;
	}
}
