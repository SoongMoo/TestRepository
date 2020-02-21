package Controller.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsDetailAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		GoodsDAO dao = new GoodsDAO();
		dao.visitCountUpdate(request.getParameter("num"));
		GoodsDTO goods = dao.goodsDetailSelect(request.getParameter("num"));
		request.setAttribute("goods", goods);
	}
	
}
