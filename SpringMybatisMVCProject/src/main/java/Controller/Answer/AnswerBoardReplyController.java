

package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Answer.AnswerCommand;
import Service.Answer.AnswerBoardReplyService;
import Validator.AnswerCommandValidate;

@Controller
public class AnswerBoardReplyController {
	@Autowired
	AnswerBoardReplyService answerBoardReplyService;
	@RequestMapping("/answer/boardReplyPro")
	public String reply(AnswerCommand answerCommand,Errors errors,
			HttpSession session,HttpServletRequest request) {
		new AnswerCommandValidate().validate(answerCommand, errors);
		if(errors.hasErrors()) {
			return "AnswerBoard/ans_board_reply";
		}
		answerBoardReplyService.replyInsert(answerCommand,session,request);
		return "redirect:/answer/answerBoard";
	}
}
