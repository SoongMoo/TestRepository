package Service.Answer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardListService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	public void answerAllBoard(Model model) {
		List<AnswerBoardDTO> lists  = answerBoardDAO.answerAllSelect();
		model.addAttribute("boards", lists);
	}
}	
