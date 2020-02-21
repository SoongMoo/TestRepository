package Controller.Goods;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsModifyProAction {
	public String execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String realPath = request.getRealPath("GoodsView\\update");
		int limitSize = 1024 * 1024 * 5;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request,
					realPath, limitSize, "utf-8", 
					new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		GoodsDTO goods = new GoodsDTO();
		goods.setGoodsSeq(Integer.parseInt(
				multi.getParameter("goodsSeq")));
		goods.setGoodsPrice(Integer.parseInt(
				multi.getParameter("goodsPrice")));
		goods.setGoodsQty(Integer.parseInt(
				multi.getParameter("goodsQty")));
		goods.setGoodsContent(multi.getParameter("goodsContent"));
		HttpSession session = request.getSession();
		goods.setUserId((String)session.getAttribute("memId"));
		File file = null;
		GoodsDAO dao = new GoodsDAO();
		if(multi.getFile("goodsImage") == null ) {
			// 파일 변경 없이 내용만 변경
			dao.goodsContentUpdate(goods);
		}else {
			// 파일과 내용 변경
			String fileName = multi.getParameter("fileDel");
			file = new File(realPath + "\\" + fileName);
			if(file.exists()) file.delete();
			goods.setGoodsImage(multi.getFilesystemName("goodsImage"));
			dao.goodsFileUpdate(goods);
		}
		return multi.getParameter("goodsSeq");
	}
}
