package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;

public class GoodsCartQtyDownAction {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("logId");
		GoodsDAO dao = new GoodsDAO(); 
		dao.cartQtyDown(goodsNum, userId);
	}
}
