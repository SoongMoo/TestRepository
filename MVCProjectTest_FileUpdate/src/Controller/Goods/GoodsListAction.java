package Controller.Goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int page = 1;
		int limit = 10;
		int limitPage = 10;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<GoodsDTO> list = null; //의존객체(x)
		Integer goodsCount = null; 
		GoodsDAO dao = new GoodsDAO(); //의존객체
		list = dao.getGoodsAllSelect(page,limit );		
		goodsCount = dao.getGoodsCount();
		
		
		// 전체 페이지를 알기 위해서는 전체 갯수 에 limit로 나눈다.
		int maxPage = (int)((double)goodsCount / limit + 0.95);
		int startPage = (int)(((double)page / limitPage + 0.9 ) -1) * 10 +1;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);

		request.setAttribute("goodsCount", goodsCount);
		request.setAttribute("goodsList", list);
		ActionForward forward = new ActionForward();
		forward.setPath("Goods/goodsList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
