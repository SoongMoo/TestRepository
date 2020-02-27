package Service.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Answer.AnswerCommand;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;
import Model.DTO.AuthInfo;
@Service
public class AnswerBoardReplyService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	public void replyInsert(AnswerCommand answerCommand,
			HttpSession session,HttpServletRequest request) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setBoardContent(answerCommand.getBoardContent());
		dto.setBoardName(answerCommand.getBoardName());
		dto.setBoardNum(answerCommand.getBoardNum());
		dto.setBoardPass(answerCommand.getBoardPass());
		dto.setBoardReLev(answerCommand.getBoardReLev());
		dto.setBoardReRef(answerCommand.getBoardReRef());
		dto.setBoardReSeq(answerCommand.getBoardReSeq());
		dto.setBoardSubject(answerCommand.getBoardSubject());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setUserId(authInfo.getId());
		dto.setIpAddr(request.getRemoteAddr());
		answerBoardDAO.replyInsert(dto);
	}
}
