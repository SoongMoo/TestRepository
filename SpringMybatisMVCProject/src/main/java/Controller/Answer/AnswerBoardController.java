package Controller.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Answer.AnswerBoardListService;

@Controller
public class AnswerBoardController {
	@Autowired
	AnswerBoardListService answerBoardListService;
	@RequestMapping("answer/answerBoard")
	public String form(Model model) {
		answerBoardListService.answerAllBoard(model);
		return "AnswerBoard/ans_board_list";
	}
}