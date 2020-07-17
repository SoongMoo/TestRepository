package controller.libBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibBoardListAction {
	public void execute(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = 
				Integer.parseInt(
						request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
		
		String num = null;
		LibBoardDAO dao = new LibBoardDAO();
		List<LibBoardDTO> list = dao.libSelectAll(page,limit,num);
		Integer count = dao.libCount();
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, 
				limitPage, page, "libBoardList.lib?");
	}
}
