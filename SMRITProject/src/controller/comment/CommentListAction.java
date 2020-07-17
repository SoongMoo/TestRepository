package controller.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.CommentDAO;
import model.DTO.CommentDTO;

public class CommentListAction {
	public void execute(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = 
				Integer.parseInt(
						request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
				
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> list =	
				dao.commentSelectAll(page,limit);
		Integer count = dao.commentCount();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, 
				limitPage, page, "commentList.cb?");
	}
}
