

package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Answer.AnswerCommand;
import Service.Answer.AnswerWriteService;

@Controller
@RequestMapping(value = "/answer/boardWrite")
public class AnswerBoardWriteController {
	@Autowired
	private AnswerWriteService answerWriteService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("answerCommand") 
								AnswerCommand answerCommand) {
		return "AnswerBoard/ans_board_write";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(AnswerCommand answerCommand, 
			HttpServletRequest request, HttpSession session) {
		System.out.println("aaaa");
		String path = answerWriteService.answerInsert(answerCommand,
				request,session);
		return path;
	}

}
