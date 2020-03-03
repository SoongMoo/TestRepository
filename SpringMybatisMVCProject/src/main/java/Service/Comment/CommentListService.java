package Service.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.CommentDTO;
import Repository.Comment.CommentListRepository;
@Service
public class CommentListService {
	@Autowired
	CommentListRepository commentListRepository;
	public void execute(Model model) {
		List<CommentDTO> lists = commentListRepository.commentList();
		model.addAttribute("comments", lists);
	}
	
}
