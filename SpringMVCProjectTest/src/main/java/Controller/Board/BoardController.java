package Controller.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Board.BoardCommand;
import Service.Board.BoardListService;
import Service.Board.BoardWriteService;

@Controller
public class BoardController {
	@Autowired
	private BoardWriteService boardWriteService;
	@Autowired
	private BoardListService boardListService;
	
	@RequestMapping("/board")
	public String board(Model model) {
		boardListService.boardList(model);
		
		return "board/qna_board_list";
	}
	@RequestMapping("/board/Write" )
	public String writeBoard(BoardCommand boardCommand) {
		return "board/qna_board_write";
	}
	@RequestMapping("/board/WritePro" )
	public String writeBoardPro(BoardCommand boardCommand,HttpSession session,HttpServletRequest request) {
		System.out.println("writeBoardPro : " + boardCommand.getBoardName());
		boardWriteService.execute(boardCommand,session,request);
		
		return "board/qna_board_list";
	}
	
	
}
