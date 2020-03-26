package Controller.Goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsModifyProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("Goods/upload");
		System.out.println(path);
		int limitSize = 1024 * 1024 * 5;
	
		MultipartRequest multi = new MultipartRequest(request,
				path, limitSize, "utf-8", new DefaultFileRenamePolicy());
		
		String goodsSeq = multi.getParameter("goodsSeq");
		Integer goodsPrice = Integer.parseInt(
				multi.getParameter("goodsPrice"));
		Integer goodsQty = Integer.parseInt(
				multi.getParameter("goodsQty"));
		String goodsContent = multi.getParameter("goodsContent");
		
		GoodsDTO goods = new GoodsDTO();
		goods.setGoodsSeq(Integer.parseInt(goodsSeq));
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsQty(goodsQty);
		goods.setGoodsContent(goodsContent);
		
		HttpSession session = request.getSession();
		goods.setUserId((String)session.getAttribute("memId"));
		
		File file = null;
		GoodsDAO dao = new GoodsDAO();
		if(multi.getFile("goodsImage") == null )//파일저장이 안되는 경우
		{
			System.out.println(multi.getParameter("fileDel"));
			if(!multi.getParameter("fileDel").trim().equals(""))//파일이 삭제되는 경우
			{
				System.out.println("삭제");
				dao.goodsNoFileUpdate(goods);
				file = new File(path + "/" + 
						multi.getParameter("fileDel"));
				if(file.exists()) {file.delete();}
			}else { //삭제가 안되는경우 
				System.out.println("삭제안됨");
				dao.goodsContentUpdate(goods);
			}
		}else { // 저장된 경우
			System.out.println("");
			goods.setGoodsImage(multi.getFilesystemName("goodsImage"));
			dao.goodsFileUpdate(goods);
			file = new File(path + "/" + 
					multi.getParameter("fileDel"));
			if(file.exists()) {file.delete();};
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("goodsDetail.gd?num=" + goodsSeq);
		return forward;
	}

}
