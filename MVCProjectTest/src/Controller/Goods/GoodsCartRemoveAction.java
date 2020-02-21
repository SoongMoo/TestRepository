package Controller.Goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DTO.CartDTO;

public class GoodsCartRemoveAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String [] nums = request.getParameterValues("delete"); 
		HttpSession session = request.getSession();
		List<CartDTO> cartList = 
				(List<CartDTO>)session.getAttribute("cartList");
		for(String str : nums) {
			for(CartDTO c : cartList) {
				if(c.getGoodsSeq().toString().equals(str)) {
					cartList.remove(c);
					break;
				}
			}
		}
	}
}
