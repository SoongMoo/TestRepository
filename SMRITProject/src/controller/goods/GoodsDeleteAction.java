package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsDeleteAction {
	public void execute(HttpServletRequest request) {
		String goodsNum =
				request.getParameter("goodsNum");
		String goodsImage =
				request.getParameter("image");
		GoodsDAO dao = new GoodsDAO();
		int i = dao.goodsDel(goodsNum);
		File file = null;
		if(i >= 1) {
			String path = "/goodsView/upload"; 
			String realPath = 
					request.getServletContext()
					       .getRealPath(path);
			String fileName = 
					realPath + "/" + goodsImage;
			file = new File(fileName);
			if(file.exists())file.delete();
			else System.out.println("파일이 없슴.");
		}
	}
}
