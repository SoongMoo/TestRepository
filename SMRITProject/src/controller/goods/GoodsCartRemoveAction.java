package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsCartRemoveAction {
	public void execute(HttpServletRequest request) {
		String [] cartNum =
				request.getParameterValues("delete");
		GoodsDAO dao = new GoodsDAO(); 
		dao.cartRemove(cartNum);
	}
}
