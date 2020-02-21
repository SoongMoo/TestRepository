package Controller.Goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.GoodsDAO;
import Model.DTO.CartDTO;
import Model.DTO.GoodsDTO;

public class GoodsCartAddAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String goodsSeq = request.getParameter("num");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO goods = dao.goodsDetailSelect(goodsSeq);
		
		CartDTO cart = null;
		HttpSession session = request.getSession();
		List<CartDTO> list = 
				(List<CartDTO>)session.getAttribute("cartList");
		if(list == null) {		
			list = new ArrayList<CartDTO>();
		}
		boolean newcart = true; // 현재 선택한 상품이 새로운 상품인지를 확인
		for(CartDTO c  : list) {
			if(c.getGoodsSeq() == goods.getGoodsSeq()) {
				System.out.println("ddfdfdf");
				newcart = false;
				c.setQty(c.getQty()+1);
			}
		}
		if(newcart) {
			cart = new CartDTO();
			cart.setGoodsSeq(goods.getGoodsSeq());
			cart.setGoodsName(goods.getGoodsName());
			cart.setGoodsPrice(goods.getGoodsPrice());
			cart.setGoodsImage(goods.getGoodsImage());
			cart.setQty(1);
			list.add(cart);
		}		
		session.setAttribute("cartList", list);
		
	}
}
