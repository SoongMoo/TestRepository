package Controller.Goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.GoodsDAO;

public class GoodsDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String num = request.getParameter("num");
		Integer goodsSeq = Integer.parseInt(num);
		String goodsImage  = request.getParameter("image");
			
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("memId");
		
		GoodsDAO dao = new GoodsDAO();
		Integer Integer =  dao.goodsDelete(goodsSeq, userId);
				
		String realPath = request.getRealPath("/Goods/upload");
		if(Integer > 0){
			String filePath = realPath + "/" + goodsImage;
			File f = new File(filePath);
			if(f.exists()){ 
				f.delete();
			}
		}
		System.out.println("/Goods/upload : " + realPath);

		ActionForward forward = new ActionForward();
		forward.setPath("goodsList.gd");
		forward.setRedirect(true);
		return forward;
	}
}
