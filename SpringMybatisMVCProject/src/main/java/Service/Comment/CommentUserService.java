package Service.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.CommentRepliesDTO;
import Model.DTO.MemberDTO;
import Repository.Comment.CommentListRepository;

@Service
public class CommentUserService {
	@Autowired
	CommentListRepository commentListRepository;
	public void execute(Model model, Long commentNo) {
		MemberDTO dto = commentListRepository.commentUser(commentNo);
		CommentRepliesDTO replies = commentListRepository.commentReplies(commentNo);
		model.addAttribute("commentUsers", dto);
		model.addAttribute("replies",replies);
	}
}