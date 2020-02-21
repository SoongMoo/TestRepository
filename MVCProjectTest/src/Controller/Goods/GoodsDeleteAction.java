package Controller.Goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.GoodsDAO;

public class GoodsDeleteAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String realPath = 
				request.getSession().getServletContext().getRealPath("GoodsView\\update");
		File file = new File(realPath + "\\" 
					+ request.getParameter("image"));
		file.delete();
		GoodsDAO dao = new GoodsDAO();
		dao.goodsDelete(request.getParameter("num"));
		
	}
}
