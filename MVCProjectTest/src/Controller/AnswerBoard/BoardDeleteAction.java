package Controller.AnswerBoard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class BoardDeleteAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String boardNum = request.getParameter("num");
		AnswerBoardDAO dao = new AnswerBoardDAO();
		AnswerBoardDTO dto =  dao.boardOneSelect(boardNum);
		String realPath = 
				request.getRealPath("AnswerBoard\\update");
		String fileName=dto.getStoreFileName();
		File f = new File(realPath + "\\" + fileName );
		f.delete();
		dao.boardDelete(boardNum);
	}
}
