package testSpringBoot.service.comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.domain.CommentDTO;
import testSpringBoot.domain.CommentRepliesDTO;
import testSpringBoot.domain.ReplyDTO;
import testSpringBoot.mapper.CommentMapper;
import testSpringBoot.repository.CommentSessionRepository;
@Component
@Service
@Transactional
public class CommentWriteService {
	@Autowired
	CommentMapper commentMapper;

	
	//@Autowired CommentSessionRepository commentSessionRepository;
	 
	public void commentWrite(CommentDTO commentDTO, Model model, HttpSession session) 
			throws Exception{
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		CommentDTO dto = new CommentDTO(null,userId,null, commentDTO.getCommentSubject(), 
				commentDTO.getCommentContent());
		commentMapper.insertComment(dto);
	}
	
	
	
	  public void commentDetail(Model model, Long commentNo) throws Exception{
	  System.out.println("commentDetail : commentNo :" + commentNo);
	  
	  //CommentRepliesDTO replies = commentSessionRepository.selectCommentByPrimaryKeyCollection(commentNo);
	  
	  CommentRepliesDTO replies = commentMapper.commentRepliesCollection(commentNo);
	  //model.addAttribute("commentUsers", dto);
	  System.out.println("commentDetail : " + replies.getReplies().size());
	  model.addAttribute("replies",replies); }
	 
	
	
	public void replyInsert(ReplyDTO replyDTO, HttpSession session) throws Exception{
		String ruserId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		replyDTO.setRuserId(ruserId);
		commentMapper.insertReply(replyDTO);
	}
}
