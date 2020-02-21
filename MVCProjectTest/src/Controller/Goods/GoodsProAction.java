package Controller.Goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.DAO.GoodsDAO;
import Model.DTO.GoodsDTO;

public class GoodsProAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {

		String filePath = "GoodsView\\update";
		String realPath = request.getSession().getServletContext().getRealPath(filePath);
		System.out.println(realPath);
		int fileSize = 1024*1024*5;
		HttpSession session = request.getSession();
		try {
			MultipartRequest multi = new MultipartRequest(
					request, realPath, fileSize,"UTF-8" ,
					new DefaultFileRenamePolicy());
			GoodsDTO dto = new GoodsDTO(null,
					multi.getParameter("goodsNum"),
					(String)session.getAttribute("memId"),
					multi.getParameter("goodsName"),
					Integer.parseInt(multi.getParameter("goodsPrice")),
					Integer.parseInt(multi.getParameter("goodsQty")),
					multi.getParameter("goodsContent"),
					multi.getFilesystemName("goodsImage"),
					null);
			GoodsDAO dao = new GoodsDAO();
			dao.goodsInsert(dto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
