package Service.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

@Service
public class AnswerBoardDetailService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	public String detailView(Integer boardNum,Model model, int i) {
		AnswerBoardDTO dto = answerBoardDAO.answerDetailSelect(boardNum);
		if(dto == null) {
			return "redirect:/answer/answerBoard";
		}
		if(i == 1) {
		dto.setBoardContent(dto.getBoardContent().replace("\n", "<br />"));
		}else {
			dto.setBoardSubject("re : " + dto.getBoardSubject());
			dto.setBoardContent("\n\n========\n"+dto.getBoardContent());
		}
		if(dto.getOriginalfileName() != null) {
		String [] org = dto.getOriginalfileName().split("-");
		String [] str = dto.getStoreFileName().split("-");
		model.addAttribute("originalfileName", org);
		model.addAttribute("storeFileName", str);
		}
		model.addAttribute("answerCommand", dto);
		if(i == 1) {
			return "AnswerBoard/ans_board_view";
		}else {
			return "AnswerBoard/ans_board_reply";
		}
	}
}
