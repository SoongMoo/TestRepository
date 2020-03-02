package Service.Board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Board.BoardCommand;
import Model.DTO.BoardDTO;
import Repository.Board.BoardWriteRepository;


@Service
public class BoardWriteService {
	@Autowired
	BoardWriteRepository boardWriteRepository; 
	
	public void boardInsert(BoardCommand boardCommand, 
			HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setUserId("5555");
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardName(boardCommand.getBoardName());
		dto.setBoardPass(boardCommand.getBoardPass());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setIpAddr(request.getRemoteAddr());
		boardWriteRepository.insertBoard(dto);
	}
}
