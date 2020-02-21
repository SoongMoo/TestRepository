package Controller.AnswerBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

public class AnswerBoardModifyProAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setBoardNum(Integer.parseInt(
				request.getParameter("BOARD_NUM")));
		dto.setBoardPass(request.getParameter("BOARD_PASS"));
		dto.setBoardSubject(request.getParameter("BOARD_SUBJECT"));
		dto.setBoardContent(request.getParameter("BOARD_CONTENT"));
		AnswerBoardDAO dao = new AnswerBoardDAO();
		dao.AnswerBoardUpdate(dto);
	}
}
