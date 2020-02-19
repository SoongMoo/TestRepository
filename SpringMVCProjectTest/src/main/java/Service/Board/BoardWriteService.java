package Service.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Board.BoardCommand;
import Model.DAO.BoardDAO;
import Model.DTO.AuthInfo;
import Model.DTO.BoardDTO;


@Service
public class BoardWriteService {
	@Autowired
	private BoardDAO boardDAO;
	
	public void execute(BoardCommand boardCommand,HttpSession session,HttpServletRequest request) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		System.out.println("aaaaa" + boardCommand.getBoardName());
		BoardDTO dto = new BoardDTO();
		dto.setUserId(authInfo.getId());
		dto.setBoardName(boardCommand.getBoardName());
		dto.setBoardPass(boardCommand.getBoardPass());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setIpAddr(request.getRemoteAddr());
		System.out.println("aaaaa" + dto.getBoardName());
		boardDAO.insertBoard(dto);
		
	}
	
	
}
