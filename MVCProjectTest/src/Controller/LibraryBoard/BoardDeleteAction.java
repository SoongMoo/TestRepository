package Controller.LibraryBoard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

public class BoardDeleteAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		Integer boardNum = 
				Integer.parseInt(request.getParameter("num"));
		LibraryBoardDAO  dao = new LibraryBoardDAO();
		LibraryBoardDTO dto = dao.boardOneselect(boardNum);
		String fileName=dto.getStoreFileName();
		String path = 
				request.getRealPath("LibraryBoard\\update");
		File file = new File(path+"\\"+fileName);
		file.delete();		
		dao.boardDelete(request.getParameter("num"));
	}
}
