package Controller.Answer;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardAddAction {
	public Integer execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		AnswerBoardDTO board = new AnswerBoardDTO();
		board.setUserId((String)session.getAttribute("memId"));
		board.setBoardName(request.getParameter("boardName"));
		board.setBoardPass(request.getParameter("boardPass"));
		board.setBoardSubject(request.getParameter("boardSubject"));
		board.setBoardContent(request.getParameter("boardContent"));
		AnswerBoardDAO dao = new AnswerBoardDAO();
		Integer result = dao.boardInsert(board);
		return result;
	}
}
