package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsProAction {
	public void execute(HttpServletRequest request) {
		GoodsDTO dto = new GoodsDTO();
		String path = "/goodsView/upload";
		String realPath =
				request.getServletContext()
				       .getRealPath(path);
		int fileSize = 1024*1024*5;
		HttpSession session = request.getSession();
		dto.setUserId(
				(String)session.getAttribute("logId"));
		dto.setIpAddr(request.getRemoteAddr());
		try {
			MultipartRequest multi =
					new MultipartRequest(request, realPath,
							fileSize, "utf-8",
							new DefaultFileRenamePolicy());
			dto.setGoodsContent(
					multi.getParameter("goodsContent"));
			dto.setGoodsImage(
					multi.getFilesystemName("goodsImage"));
			dto.setGoodsName(
					multi.getParameter("goodsName"));
			dto.setGoodsNum(
					multi.getParameter("goodsNum"));
			dto.setGoodsPrice(
					Long.parseLong(
							multi.getParameter("goodsPrice")));
			GoodsDAO dao = new GoodsDAO();
			dao.goodsInsert(dto);
		}catch(Exception e) {e.printStackTrace();}
		
		
	}
}
