package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsModifyAction {
	public String execute(HttpServletRequest request){
		/// 체크
		String realPath = 
				request.getServletContext()
					   .getRealPath("/goodsView/upload");
		int limitSize= 1024 * 1024 * 5;
		GoodsDTO dto = new GoodsDTO();
		HttpSession session = request.getSession();
		dto.setUserId(
				(String)session.getAttribute("logId"));
		GoodsDAO dao = new GoodsDAO();
		MultipartRequest multi = null;
		try {
			// 객체생성되면서 파일이 저장
			multi = new MultipartRequest(request,
					realPath,limitSize,	"utf-8",
					new DefaultFileRenamePolicy());
			dto.setGoodsContent(
					multi.getParameter("goodsContent"));
			dto.setGoodsNum(
					multi.getParameter("goodsNum"));
			dto.setGoodsPrice(
					Long.parseLong(
						multi.getParameter("goodsPrice")));
			dao.goodsContentUpdate(dto);
			// 파일이 저장된 경우에만 실행
			if(multi.getFile("goodsImage") != null) { // 체크
				System.out.println("안되나요...");
				dto.setGoodsImage(
						multi.getFilesystemName("goodsImage")); // 체크
				int i = dao.fileUpdate(dto);
				File file = null;
				if(i >= 1) {
					String fileName = realPath + "/" 
					        + multi.getParameter("fileDel");
					file = new File(fileName);
					if(file.exists())file.delete();
					else System.out.println("파일이 없슴.");
				}
			}else {
				System.out.println("왜 안되될까요...");
			}
		}catch(Exception e) {e.printStackTrace();}
		// 체크
		return multi.getParameter("goodsNum");
	}
}
