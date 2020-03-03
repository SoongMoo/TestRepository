package Controller.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Comment.CommentInsertService;
import Service.Comment.CommentListService;

@Controller
public class CommentController {
	@Autowired
	CommentInsertService commentInsertService;
	@Autowired
	CommentListService commentListService;
	
	@RequestMapping(value = "/comment/comment_list",method = RequestMethod.GET)
	public String commentList(Model model) {
		commentListService.execute(model);
		return "comment/comment_list";
	}
	@RequestMapping(value = "/comment/comment_insert", method = RequestMethod.POST)
	public String commentInsert(
			@RequestParam(value = "commentSubject") String commentSubject,
			@RequestParam(value = "commentContent") String commentContent,
			HttpSession session) {
		commentInsertService.execute(commentSubject,commentContent,
				session);
		return "redirect:/comment/comment_list";
	}
	
	
}
