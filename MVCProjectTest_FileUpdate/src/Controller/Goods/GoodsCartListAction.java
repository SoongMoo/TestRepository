package Controller.Goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DTO.CartDTO;

public class GoodsCartListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
				
		HttpSession session = request.getSession();
		List<CartDTO> cartList = 
				(List<CartDTO>)session.getAttribute("cartList");
		
		int totalMoney = 0;
		
		for(CartDTO c : cartList) {
			int money = c.getGoodsPrice() * c.getQty();
			totalMoney += money;
		}
		
		session.setAttribute("totalMoney", totalMoney);
		session.setAttribute("cartList", cartList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("Goods/goodsCartList.jsp");
		return forward;
	}

}
