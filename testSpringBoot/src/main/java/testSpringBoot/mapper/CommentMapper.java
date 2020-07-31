package testSpringBoot.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import testSpringBoot.domain.CommentDTO;
import testSpringBoot.domain.CommentRepliesDTO;
import testSpringBoot.domain.ReplyDTO;
import testSpringBoot.domain.StartEndPageDTO;
@Component
@Repository("testSpringBoot.mapper.CommentMapper")
public interface CommentMapper {
	public List<CommentDTO> getCommentList(StartEndPageDTO startEndPageDTO) throws Exception;
	public void insertComment(CommentDTO commentDTO) throws Exception;
	public int getCommentCount() throws Exception;
	public CommentRepliesDTO commentRepliesCollection(Long commentNo)throws Exception;
	public void insertReply(ReplyDTO replyDTO) throws Exception;
}
