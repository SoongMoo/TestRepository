package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsCartAddAction {
	public void execute(HttpServletRequest request) {
		String goodsNum = 
				request.getParameter("goodsNum");
		HttpSession session =
				request.getSession();
		// 상품을 선택한 사용자
		String userId = 
				(String)session.getAttribute("logId");
		System.out.println(userId);
		GoodsDAO dao = new GoodsDAO();
		// 사용자가 선택한 상품정보 가져오기
		GoodsDTO dto = 
				dao.goodsSelectAll(1, 1, goodsNum).get(0);
		// 사용자가 선택한 상품정보를 카트에 담기
		dao.goodsCartAdd(dto, userId);
	}
}
