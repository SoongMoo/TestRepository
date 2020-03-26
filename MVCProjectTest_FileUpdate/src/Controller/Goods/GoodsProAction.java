package Controller.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsProAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String filePath = "Goods\\upload";
		String realPath = request.getRealPath(filePath);
		int fileSize = 1024*1024*5;
		// MultipartRequest객체가 생성과 동시에 realPath에 파일이 저장됨
		MultipartRequest multi =
				new MultipartRequest(request, realPath,fileSize,
						"utf-8", new DefaultFileRenamePolicy());
		HttpSession session = request.getSession(); 
		
		GoodsDTO goods = new GoodsDTO(); // 의존객체
		goods.setGoodsNum(multi.getParameter("goodsNum"));
		goods.setUserId((String)session.getAttribute("memId"));
		goods.setGoodsName(multi.getParameter("goodsName"));
		goods.setGoodsContent(multi.getParameter("goodsContent"));
		goods.setGoodsPrice(Integer.parseInt(multi.getParameter("goodsPrice")));
		goods.setGoodsQty(Integer.parseInt(multi.getParameter("goodsQty")));
		goods.setGoodsImage(multi.getFilesystemName("goodsImage"));
		
		
		GoodsDAO dao = new GoodsDAO(); // 의존객체
		Integer result = dao.goodsInsert(goods);

		ActionForward fordward = new  ActionForward();
		fordward.setRedirect(true);
		if(result > 0) {
			fordward.setPath("goodsList.gd");
		}else {
			fordward.setPath("goodsWriter.gd");
		}
		return fordward;
	}

}
