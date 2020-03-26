package Controller.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO goods = dao.goodsDetailSelect(request.getParameter("num"));
		request.setAttribute("goods", goods);

		ActionForward forward = new ActionForward();
		forward.setPath("Goods/goodsDetail.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
