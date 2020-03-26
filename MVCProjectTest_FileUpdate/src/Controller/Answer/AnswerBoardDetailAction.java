package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardDetailAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		Integer boardNum = Integer.parseInt(request.getParameter("num"));
		AnswerBoardDAO dao = new AnswerBoardDAO();
		dao.setReadCountUpdate(boardNum);
		AnswerBoardDTO board = dao.getDetail(boardNum);
		board.setBoardContent(
				board.getBoardContent().replace("\n", "<br />"));
		request.setAttribute("board", board);
	}
}
