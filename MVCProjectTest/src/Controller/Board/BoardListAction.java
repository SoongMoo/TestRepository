package Controller.Board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.BoardDAO;

public class BoardListAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		List list = new ArrayList();
		list = dao.boardAllSelect();
		Integer count = dao.boardCount();
		request.setAttribute("boards", list);
		request.setAttribute("count", count);
	}
}
