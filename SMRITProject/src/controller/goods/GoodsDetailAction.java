package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsDetailAction {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		dao.updateReadCount(num);
		List<GoodsDTO> list = dao.goodsSelectAll(1,1,num);
		request.setAttribute("list", list);
	}
}
