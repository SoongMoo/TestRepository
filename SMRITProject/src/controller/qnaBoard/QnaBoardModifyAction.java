package controller.qnaBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.QnaBoardDAO;
import model.DTO.QnaBoardDTO;

public class QnaBoardModifyAction {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId =(String)session.getAttribute("logId");
		
		String boardNum = request.getParameter("boardNum");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		String boardPass = request.getParameter("boardPass");
		
		QnaBoardDTO dto = new QnaBoardDTO();
		
		dto.setBoardContent(boardContent);
		dto.setBoardNum(Long.parseLong(boardNum));
		dto.setBoardPass(boardPass);
		dto.setBoardSubject(boardSubject);
		dto.setUserId(userId);
		
		QnaBoardDAO dao = new QnaBoardDAO();
		dao.qnaUpdate(dto);
		
	}
}
