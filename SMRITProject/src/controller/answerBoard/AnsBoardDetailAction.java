package controller.answerBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.AnswerBoardDAO;
import model.DTO.AnswerBoardDTO;

public class AnsBoardDetailAction {
	public void execute(HttpServletRequest request) {
		String boardNum =
				request.getParameter("boardNum");
		AnswerBoardDAO dao = new AnswerBoardDAO();
		dao.updateReadCount(boardNum, "answerboard");
		/*
		List<AnswerBoardDTO> list =
				dao.ansSelectAll(1, 1, boardNum);
		request.setAttribute("dto", list.get(0));
		*/
		AnswerBoardDTO dto =
				dao.ansSelectAll(1, 1, boardNum).get(0);
		request.setAttribute("dto", dto);
	}
}
