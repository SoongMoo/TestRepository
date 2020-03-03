package Service.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.DTO.AuthInfo;
import Model.DTO.CommentDTO;
import Model.DTO.ReplyDTO;
import Repository.Comment.CommentInsertRepository;
@Service
public class CommentInsertService {
	@Autowired
	CommentInsertRepository commentInsertRepository;
	public void replyInsert(String cuserId,Long commentNo,String replyContent,
			HttpSession session) {
		ReplyDTO dto = new ReplyDTO();
		dto.setCommentNo(commentNo);
		dto.setCuserId(cuserId);
		dto.setReplyContent(replyContent);
		String ruserId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		dto.setRuserId(ruserId);
		commentInsertRepository.replyInsert(dto);
	}
	public void execute(String commentSubject,String commentContent,
			HttpSession session) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		CommentDTO dto = new CommentDTO(null,userId,null, commentSubject, 
				 commentContent);
		commentInsertRepository.commentInsert(dto);
	}
}
