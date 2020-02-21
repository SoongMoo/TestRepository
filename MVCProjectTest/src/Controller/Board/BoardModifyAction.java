package Controller.Board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

public class BoardModifyAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(request.getParameter("BOARD_CONTENT"));
		dto.setBoardNum(
				Integer.parseInt(request.getParameter("BOARD_NUM")));
		dto.setBoardSubject(request.getParameter("BOARD_SUBJECT"));
		dto.setBoardPass(request.getParameter("BOARD_PASS"));
		BoardDAO  dao = new BoardDAO();
		dao.boardUpdate(dto);
	}
}
