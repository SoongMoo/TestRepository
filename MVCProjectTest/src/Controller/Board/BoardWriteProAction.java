package Controller.Board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

public class BoardWriteProAction {
	public String execute(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		BoardDTO dto = new  BoardDTO();
		dto.setUserId((String)session.getAttribute("memId"));
		dto.setBoardContent(request.getParameter("BOARD_CONTENT"));
		dto.setBoardName(request.getParameter("BOARD_NAME"));
		dto.setBoardPass(request.getParameter("BOARD_PASS"));
		dto.setBoardSubject(request.getParameter("BOARD_SUBJECT"));
		dto.setIpAddr(request.getRemoteAddr());
		BoardDAO dao =  new BoardDAO();
		Integer result = dao.boardInsert(dto);
		String path = null;
		if(result == 1) {
			path = "board.bd";
		}else {
			path = "boardWrite.bd";
		}
		return path;
	}
}
