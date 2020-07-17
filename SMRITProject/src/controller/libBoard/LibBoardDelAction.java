package controller.libBoard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.LibBoardDAO;
import model.DTO.LibBoardDTO;

public class LibBoardDelAction {
	public void execute(HttpServletRequest request) {
		String boardNum = request.getParameter("num");
		LibBoardDAO dao = new LibBoardDAO();
		LibBoardDTO dto = 
				dao.libSelectAll(1, 1, boardNum).get(0);
		int i = dao.libBoardDel(boardNum);
		File file = null;
		String path = request.getServletContext()
							 .getRealPath("/lib_Board/upload");
		if(i >= 1) {// 파일 삭제
			file = new File(path + "/" + dto.getStoreFileName());
			if(file.exists()) file.delete();
		}
	}
}
