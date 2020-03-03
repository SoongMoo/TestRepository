package Repository.Comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CommentDTO;




public class CommentInsertRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "Repository.Comment.commentMapper";
	public void commentInsert(CommentDTO dto) {
		String statement = namespace + ".insertComment";
		sqlSession.insert(statement, dto);
	}
}
