package Controller.AnswerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardReplyAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String boardNum = request.getParameter("num");
		AnswerBoardDAO dao = new AnswerBoardDAO();
		AnswerBoardDTO dto = dao.boardOneSelect(boardNum);
		request.setAttribute("dto", dto);
	}
}
