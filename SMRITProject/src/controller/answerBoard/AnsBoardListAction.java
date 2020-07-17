package controller.answerBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.AnswerBoardDAO;
import model.DTO.AnswerBoardDTO;

public class AnsBoardListAction {
	public void execute(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = 
				Integer.parseInt(
						request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
		
		AnswerBoardDAO dao = new AnswerBoardDAO();
		List<AnswerBoardDTO> list =
				dao.ansSelectAll(page, limit, null);
		Integer count = dao.ansCount();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
				
		PageAction action = new PageAction();
		action.page(request, count, limit, limitPage, page,
				"ansBoardList.ans?");
	}
}
