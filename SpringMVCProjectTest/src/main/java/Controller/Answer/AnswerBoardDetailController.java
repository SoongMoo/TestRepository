package Controller.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Answer.AnswerBoardDetailService;

@Controller
public class AnswerBoardDetailController {
	@Autowired
	AnswerBoardDetailService answerBoardDetailService;
	@RequestMapping(value="/answer/boardDetail/{id}")
	public String detail(@PathVariable(value = "id") Integer boardNum,
			Model model) {
		System.out.println(boardNum);
		return answerBoardDetailService.detailView(boardNum, model,1);
	}
	@RequestMapping(value="/answer/answerBoardReply")
	public String reply(@RequestParam("num") Integer boardNum,
			Model model) {
		System.out.println(boardNum);
		return answerBoardDetailService.detailView(boardNum, model ,2);
	}
}
