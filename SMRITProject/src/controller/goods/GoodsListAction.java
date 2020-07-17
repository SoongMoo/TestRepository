package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.PageAction;
import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsListAction {
	public void execute(HttpServletRequest request) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = 
				Integer.parseInt(
						request.getParameter("page"));
		}
		int limit = 10;
		int limitPage = 10;
		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> list 
			= dao.goodsSelectAll(page, limit, null);
		Integer count = dao.goodsCount();
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		PageAction pageAction = new PageAction();
		pageAction.page(request, count, limit, 
				limitPage, page, "goodsList.gd?");
	}
}
