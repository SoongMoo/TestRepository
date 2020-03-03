package Repository.Comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.DTO.CommentDTO;
import Model.DTO.ReplyDTO;




public class CommentInsertRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "Repository.Comment.commentMapper";
	
	public void replyInsert(ReplyDTO dto) {
		String statement = namespace + ".insertReply";
		sqlSession.insert(statement, dto);
	}
	public void commentInsert(CommentDTO dto) {
		String statement = namespace + ".insertComment";
		sqlSession.insert(statement, dto);
	}
}
