package Controller.Answer;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardReplyPro {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		AnswerBoardDTO board = new AnswerBoardDTO();
		board.setBoardNum(Integer.parseInt(
						request.getParameter("boardNum")));
		board.setBoardReRef(Integer.parseInt(
						request.getParameter("boardReRef")));
		board.setBoardReLev(Integer.parseInt(
						request.getParameter("boardReLev")));
		board.setBoardReSeq(Integer.parseInt(
						request.getParameter("boardReSeq")));
		board.setBoardName(request.getParameter("boardName"));
		board.setBoardSubject(request.getParameter("boardSubject"));
		board.setBoardContent(request.getParameter("boardContent"));
		board.setBoardPass(request.getParameter("boardPass"));
		HttpSession session = request.getSession();
		board.setUserId((String)session.getAttribute("memId"));
		AnswerBoardDAO dao = new AnswerBoardDAO();
		dao.boardReply(board);
	}
}
