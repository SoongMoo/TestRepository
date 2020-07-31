package testSpringBoot.controller.comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import testSpringBoot.domain.CommentDTO;
import testSpringBoot.domain.ReplyDTO;
import testSpringBoot.service.comment.CommentListService;
import testSpringBoot.service.comment.CommentWriteService;

@Controller
@RequestMapping("comment")
public class CommentController {
	@Autowired
	CommentListService commentListService;
	@Autowired
	CommentWriteService commentWriteService;
	
	@ModelAttribute
	CommentDTO setCommentDTO() {
		return new CommentDTO();
	}
	
	ReplyDTO setReplyDTO() {
		return new ReplyDTO();
	}
	@RequestMapping(value = "comment_list",method = RequestMethod.GET)
	public String commentList(Model model, @RequestParam(value = "page" , defaultValue = "1") Integer page) throws Exception{
		commentListService.execute(model, page);
		return "comment/comment_list";
	}
	@RequestMapping(value = "commentBoard",method = RequestMethod.GET)
	public String commentBoard(Model model) throws Exception{
		return "thymeleaf/comment/commentForm";
	}
	@RequestMapping(value = "commentBoard",method = RequestMethod.POST)
	public String commentWrite(CommentDTO commentDTO,Model model, HttpSession session) throws Exception{
		commentWriteService.commentWrite(commentDTO,model, session);
		return "redirect:/comment/comment_list";
	}
	@RequestMapping(value = "commentDetail" )
	public String commentDetail(@RequestParam(value = "commentNo") Long commentNo,
			Model model) throws Exception{
		commentWriteService.commentDetail(model,commentNo);
		return "thymeleaf/comment/comment_Collection";
	}
	@RequestMapping(value = "replyInsert" )
	public String replyInsert(ReplyDTO replyDTO, HttpSession session) throws Exception{
		commentWriteService.replyInsert(replyDTO, session);
		return "redirect:/comment/commentDetail?commentNo=" + replyDTO.getCommentNo() ;
	}	
}
