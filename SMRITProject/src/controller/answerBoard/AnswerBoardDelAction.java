package controller.answerBoard;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.AnswerBoardDAO;
import model.DTO.AnswerBoardDTO;

public class AnswerBoardDelAction {
	public void execute(HttpServletRequest request) {
		String boardNum = request.getParameter("boardNum");
		String boardPass =
				request.getParameter("boardPass");
		HttpSession session = request.getSession();
		String userId= 
				(String)session.getAttribute("logId");
		AnswerBoardDAO dao = new AnswerBoardDAO();
		List<AnswerBoardDTO> list =
				dao.ansSelectAll(1, 1, boardNum);
		int i = dao.ansboardDelete(boardNum,boardPass,
												userId );
		if(i >= 1) {
			String path = request.getServletContext()
					 .getRealPath("/answerBoard/upload");
			File file = 
				new File(path + "/" + list.get(0)
				                    .getStoreFileName() );
			if(file.exists()) file.delete();	
		}
	}
}
