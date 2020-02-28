package Controller.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Board.BoardDetailService;

@Controller
public class BoardDetailController {
	@Autowired
	BoardDetailService boardDetailService;
	
	@RequestMapping("/board/boardDetail")
	public String detail(@RequestParam("num") Integer boardNum,Model model) {
		boardDetailService.boardDetail(boardNum,model);
		return "board/qna_board_view";
	}
}
