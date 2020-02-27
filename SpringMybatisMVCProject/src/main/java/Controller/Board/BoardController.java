package Controller.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Board.BoardCommand;
import Service.Board.BoardDetailService;
import Service.Board.BoardListService;
import Service.Board.BoardWriteService;

@Controller
public class BoardController {
	@Autowired
	private BoardWriteService boardWriteService;
	@Autowired
	private BoardListService boardListService;
	@Autowired
	private BoardDetailService boardDetailService;
	
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
	
	@RequestMapping("/board/boardDetail/{aaa}")
	public String boardDetail(@PathVariable("aaa") Integer boardNum,Model model) {
		try {
			boardDetailService.boardDetail(boardNum,model);
		}catch(Exception e) {
			return "redirect:/board/qna_board_list";
		}
		return "board/qna_board_view"; //이거 내일 페이지 보고 수정
	}
	
}
