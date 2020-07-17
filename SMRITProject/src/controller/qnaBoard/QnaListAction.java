package controller.qnaBoard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.QnaBoardDAO;
import model.DTO.QnaBoardDTO;

public class QnaListAction {
	public void execute(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = 
				Integer.parseInt(
						request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
		
		QnaBoardDAO dao = new QnaBoardDAO();
		List<QnaBoardDTO> list = dao.qnaSelectAll(page,limit);
		request.setAttribute("list1234", list);

		int count = dao.qnaCount();
		request.setAttribute("qnaCount", count );
		
		PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, 
				limitPage, page, "qnaList.qna?");
	}
}
