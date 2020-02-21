package Controller.Goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DTO.CartDTO;

public class GoodsCartListAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<CartDTO> cartList = 
				(List<CartDTO>)session.getAttribute("cartList");
		int totalMoney = 0;
		for(CartDTO c : cartList) {
			totalMoney += c.getGoodsPrice() * c.getQty();
		}
		session.setAttribute("totalMoney", totalMoney);
	}
}
