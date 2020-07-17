package controller.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.CommentDAO;
import model.DTO.CommentDTO;

public class CommentWriteAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {e.printStackTrace();}
		CommentDTO dto = new CommentDTO();
		dto.setCommentContent(
				request.getParameter("commentContent"));
		dto.setCommentSubject(
				request.getParameter("commentSubject"));
		HttpSession session = request.getSession();
		dto.setCuserId(
				(String)session.getAttribute("logId"));
		CommentDAO dao = new CommentDAO();
		dao.commentInsert(dto);
	}
}
