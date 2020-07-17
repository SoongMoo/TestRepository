package controller.answerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.AnswerBoardDAO;
import model.DTO.AnswerBoardDTO;

public class AnswerBoardReplyAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception  e){e.printStackTrace();}
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setBoardContent(
				request.getParameter("boardContent"));
		dto.setBoardName(request.getParameter("boardName"));
		dto.setBoardPass(request.getParameter("boardPass"));
		dto.setBoardReLev(Long.parseLong(
				request.getParameter("boardReLev")));
		dto.setBoardReRef(Long.parseLong(
				request.getParameter("boardReRef")));
		dto.setBoardReSeq(Long.parseLong(
				request.getParameter("boardReSeq")));
		dto.setBoardSubject(
				request.getParameter("boardSubject"));
		dto.setIpAddr(request.getRemoteAddr());
		HttpSession session = request.getSession();
		String userId = 
				(String)session.getAttribute("logId");
		dto.setUserId(userId);
		AnswerBoardDAO dao = new AnswerBoardDAO();
		dao.answerSeqUpdate(dto);
		dao.answerReplyInsert(dto);
	}
}
