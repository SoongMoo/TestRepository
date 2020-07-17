package controller.qnaBoard;

import javax.servlet.http.HttpServletRequest;

import model.DAO.QnaBoardDAO;
import model.DTO.QnaBoardDTO;

public class QnaDetailAction {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		QnaBoardDAO dao = new QnaBoardDAO();
		
		dao.updateReadCount(num,"board");
		
		QnaBoardDTO dto =  dao.QnaOneSelect(num);
		request.setAttribute("dto", dto);
	}
}
