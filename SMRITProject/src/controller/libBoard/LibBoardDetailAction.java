package controller.libBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibBoardDetailAction {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		LibBoardDAO dao = new LibBoardDAO();
		dao.updateReadCount(num,"libraryboard");
		List<LibBoardDTO> list = dao.libSelectAll(1,1,num);
		request.setAttribute("list", list);
	}
}
