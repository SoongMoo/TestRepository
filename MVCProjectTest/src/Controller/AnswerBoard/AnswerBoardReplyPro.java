package Controller.AnswerBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardReplyPro {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		AnswerBoardDTO board = new AnswerBoardDTO();
		board.setBoardNum(Integer.parseInt(
				request.getParameter("BOARD_NUM")));
		board.setBoardReRef(Integer.parseInt(
				request.getParameter("BOARD_RE_REF")));
		board.setBoardReLev(Integer.parseInt(
				request.getParameter("BOARD_RE_LEV")));
		board.setBoardReSeq(Integer.parseInt(
				request.getParameter("BOARD_RE_SEQ")));
		board.setBoardName(request.getParameter("BOARD_NAME"));
		board.setBoardSubject(request.getParameter("BOARD_SUBJECT"));
		board.setBoardContent(request.getParameter("BOARD_CONTENT"));
		System.out.println(board.getBoardContent());
		board.setBoardPass(request.getParameter("BOARD_PASS"));
		HttpSession session = request.getSession();		
		board.setUserId((String)session.getAttribute("memId"));
		board.setIpAddr(request.getRemoteAddr());
		AnswerBoardDAO dao = new AnswerBoardDAO();
		dao.boardReply(board);
	}
}
