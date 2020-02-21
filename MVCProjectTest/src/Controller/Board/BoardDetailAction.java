package Controller.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

public class BoardDetailAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer boardNum = Integer.parseInt(
					request.getParameter("num"));
		BoardDAO dao = new BoardDAO();
		dao.boardCountUpdate(boardNum);
		BoardDTO dto = dao.boardOneselect(boardNum);
		request.setAttribute("board", dto);
	}
}
