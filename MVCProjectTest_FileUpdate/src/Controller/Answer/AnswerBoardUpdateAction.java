package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardUpdateAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		Integer boardNum = Integer.parseInt(request.getParameter("num"));
		AnswerBoardDAO dao = new AnswerBoardDAO();
		AnswerBoardDTO board = dao.getDetail(boardNum);
		request.setAttribute("board", board);
	}
}
