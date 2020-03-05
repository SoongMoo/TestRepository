package Controller.Board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Board.BoardCommand;
import Service.Board.BoardListService;
import Service.Board.BoardWriteService;
import Validator.boardCommandValidator;

@Controller
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	
	@RequestMapping(value="/board/boardlist" ,method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("ccc");
		boardListService.boardAllSelect(model);
		return "board/qna_board_list";
	}

	@RequestMapping(value="/board/boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
		return "board/qna_board_write";
	}
	
	@RequestMapping(value ="/board/boardWritePro",method=RequestMethod.POST)
	public String boardWritePro(BoardCommand boardCommand,Errors errors,HttpServletRequest request) {
		new boardCommandValidator().validate(boardCommand,errors);
		if(errors.hasErrors()) {
			return "board/qna_board_write";
		}
		boardWriteService.boardInsert(boardCommand,request);
		
		return "redirect:/board/boardList";
	}
}
