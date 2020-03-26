package Controller.Answer;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardModifyAction {
	public Integer execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		Integer boardNum = Integer.parseInt( 
				request.getParameter("boardNum"));
		HttpSession session = request.getSession();
		AnswerBoardDTO board  = new AnswerBoardDTO();
		board.setBoardNum(boardNum);
		board.setBoardName(request.getParameter("boardName"));
		System.out.println("AnswerBoardModifyAction : " + board.getBoardName());
		board.setBoardSubject(request.getParameter("boardSubject"));
		board.setBoardContent(request.getParameter("boardContent"));
		board.setBoardPass(request.getParameter("boardPass"));
		board.setUserId((String)session.getAttribute("memId"));
		AnswerBoardDAO dao = new AnswerBoardDAO();
		Integer result = dao.boardModify(board);
		if(result > 0) {
			session.removeAttribute("msg");
		}else {
			session.setAttribute("msg", "권한이 없습니다.");
		}
		return result;
	}
}
