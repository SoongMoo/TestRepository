package Controller.LibraryBoard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.LibraryBoardDAO;

public class LibraryBoardListAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		List list = new ArrayList();
		LibraryBoardDAO dao = new LibraryBoardDAO();
		list = dao.boardAllSelect();
		Integer count = dao.boardCount();
		request.setAttribute("boards", list);
		request.setAttribute("count", count);
	}
}
