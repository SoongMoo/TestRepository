package Controller.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String goodsSeq = request.getParameter("num");
		GoodsDAO  dao = new GoodsDAO();
		GoodsDTO goods = dao.goodsDetailSelect(goodsSeq);
		
		request.setAttribute("goods", goods);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("Goods/goodsModify.jsp");
		return forward;
	}

}
