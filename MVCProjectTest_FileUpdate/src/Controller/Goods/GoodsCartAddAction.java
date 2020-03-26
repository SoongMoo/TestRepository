package Controller.Goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.GoodsDAO;
import Model.DTO.CartDTO;
import Model.DTO.GoodsDTO;

public class GoodsCartAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String goodsSeq = request.getParameter("num");
		
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO goods = dao.goodsDetailSelect(goodsSeq);
		
		CartDTO cart = null;	
		boolean newCart = true; // 장바구니가 새로 상품이 만들어질 때 
		
		HttpSession session = request.getSession();
		List<CartDTO> list = 
				(List<CartDTO>)session.getAttribute("cartList");
		
		//  처음 상품을 담았을 때
		if(list == null) {
				list = new ArrayList<CartDTO>();
		}
			
		// 처음 상품이거나 새로운 상품을 추가할 때
		for(CartDTO c : list) {
			// 상품이 같습니까? 구매수량을 1증가
			if(goods.getGoodsNum().equals(c.getGoodsNum())) {
				newCart = false; // 같은 상품이면 FALSE로 만들어서 48행실행x
				c.setQty(c.getQty()+1);
			}
		}
		
		if(newCart) {
			System.out.println("aaaa");
			cart = new CartDTO();
			cart.setGoodsNum(goods.getGoodsNum());
			cart.setGoodsImage(goods.getGoodsImage());
			cart.setGoodsName(goods.getGoodsName());
			cart.setGoodsPrice(goods.getGoodsPrice());
			cart.setQty(1);
			list.add(cart);
		}
		session.setAttribute("cartList", list);

		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("goodsCartList.gd"); // 장바구니 가기
		return forward;
	}

}
