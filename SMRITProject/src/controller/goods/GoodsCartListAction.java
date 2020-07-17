package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.CartDTO;

public class GoodsCartListAction {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = 
				(String)session.getAttribute("logId");
		GoodsDAO dao = new GoodsDAO();
		List<CartDTO> list = 
				dao.cartAllSelect(userId);
		request.setAttribute("cartList", list);				
	}
}
