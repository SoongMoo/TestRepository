package Controller.Goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DTO.CartDTO;

public class GoodsCartRemoveAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String [] nums = request.getParameterValues("delete"); 
		HttpSession session = request.getSession();
		List<CartDTO> cartList = 
				(List<CartDTO>)session.getAttribute("cartList");
		
		int size = cartList.size();
		for(int j = 0; j < nums.length ;j++ ) {
			for(int i = 0; i< cartList.size(); i++) {
				CartDTO c = cartList.get(i);
				if(c.getGoodsNum().equals(nums[j])) {
					System.out.println(c.getGoodsNum());
					cartList.remove(c);
					break;
				}
			}				
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("goodsCartList.gd");
		return forward;
	}

}
