package Service.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Library.LibraryBoardCommand;
import Contoller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.AuthInfo;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	public void writePro(LibraryBoardCommand libraryBoardCommand,
			HttpSession session,
			HttpServletRequest request) {
		LibraryBoardDTO libraryBoardDTO = new LibraryBoardDTO();
		libraryBoardDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		libraryBoardDTO.setBoardName(libraryBoardCommand.getBoardName());
		libraryBoardDTO.setBoardPass(
				Encrypt.getEncryption(
						libraryBoardCommand.getBoardPass()));
		libraryBoardDTO.setBoardSubject(libraryBoardCommand.getBoardSubject());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		libraryBoardDTO.setUserId(authInfo.getId());
		libraryBoardDTO.setIpAddr(request.getRemoteAddr());
		libraryBoardDAO.libraryInsert(libraryBoardDTO);
	}
}
