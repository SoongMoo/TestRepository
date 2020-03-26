package Controller.Goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DTO.CartDTO;

public class GoodsCartQtyUpAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsNum = request.getParameter("goodsNum");
		HttpSession session = request.getSession();
		List<CartDTO> cartList =
				(List<CartDTO>)session.getAttribute("cartList");
		for(CartDTO cart : cartList) {
			if(cart.getGoodsNum().equals(goodsNum)) {
				cart.setQty(cart.getQty()+1);
			}
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("goodsCartList.gd");
		return forward;
	}
	
}
