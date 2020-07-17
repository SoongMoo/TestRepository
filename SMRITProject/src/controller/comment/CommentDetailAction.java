package controller.comment;

import javax.servlet.http.HttpServletRequest;

import model.DAO.CommentDAO;
import model.DTO.CommentRepliesDTO;

public class CommentDetailAction {
	public void execute(HttpServletRequest request) {
		CommentDAO dao = new CommentDAO();
		String commentNo =
				request.getParameter("commentNo");
		CommentRepliesDTO dto = 
				dao.commentCollection(commentNo);
		request.setAttribute("cmtReDTO", dto);
	}
}
