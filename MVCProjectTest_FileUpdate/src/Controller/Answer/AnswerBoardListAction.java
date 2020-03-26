package Controller.Answer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardListAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		AnswerBoardDAO dao = new AnswerBoardDAO();
		List<AnswerBoardDTO> list = dao.getBoardList();
		Integer boardCount = dao.getCount();
		request.setAttribute("boardList", list);	
		request.setAttribute("boardCount", boardCount);
	}
}
