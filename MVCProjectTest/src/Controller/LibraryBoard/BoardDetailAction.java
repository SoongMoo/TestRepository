package Controller.LibraryBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

public class BoardDetailAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		Integer boardNum = Integer.parseInt(
				request.getParameter("num"));
		LibraryBoardDAO dao = new LibraryBoardDAO();
		LibraryBoardDTO dto = dao.boardOneselect(boardNum);
		request.setAttribute("board", dto);
	}
}
