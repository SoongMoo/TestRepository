package controller.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.CommentDAO;
import model.DTO.ReplyDTO;

public class ReplyInsertAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		String cuserId = request.getParameter("cuserId");
		String commentNo = request.getParameter("commentNo");
		String replyContent =
				request.getParameter("replyContent");
		ReplyDTO dto = new ReplyDTO();
		dto.setCommentNo(Long.parseLong(commentNo));
		dto.setCuserId(cuserId);
		dto.setReplyContent(replyContent);
		HttpSession session = request.getSession();
		dto.setRuserId((String)session.getAttribute("logId"));
		
		CommentDAO dao = new CommentDAO();
		dao.replyInsert(dto);
		
		
		
	}
}
