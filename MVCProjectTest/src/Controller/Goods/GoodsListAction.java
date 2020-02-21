package Controller.Goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.GoodsDAO;

public class GoodsListAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		GoodsDAO dao = new GoodsDAO(); 
		List list = dao.getGoodsAllSelect(page, limit);
		Integer goodsCount = dao.getGoodsCount();
		// goodsCount = 12  , maxPage =2
		int maxPage = (int)((double)goodsCount/limit +0.95) ;
		// page = 11,12,13,14,15,16,17,18,19,20; startPage = 11
		// page = 21,22,23,24,25,26,27,28,29,30; startPage = 21
		int startPage = (int)(((double) page / limitPage +0.9) -1)  * limitPage + 1; 
		// page = 1,2,3,4,5,6,7,8,9,10; endPage = 10
		// page = 11,12,13,14,15,16,17,18,19,20; endPage = 20
		// page = 21,22,23,24,25,26,27,28,29,30; endPage = 30
		int endPage = startPage + limitPage -1;  // page = 12; endPage = 20;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);
		request.setAttribute("goodsCount", goodsCount);
		request.setAttribute("goodsList", list);
	}
}
