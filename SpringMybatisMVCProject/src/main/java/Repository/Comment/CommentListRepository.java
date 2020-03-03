package Repository.Comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CommentDTO;
import Model.DTO.CommentRepliesDTO;
import Model.DTO.MemberDTO;

@Repository
public class CommentListRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "Repository.Mapper.CommentMapperDynamic";
	public List<CommentDTO> commentList(){
		String statement = namespace + ".commentList";
		return sqlSession.selectList(statement);
	}
	public CommentRepliesDTO commentReplies(Long commentNo){ // 1:n
		String statement = namespace + ".commentRepliesCollection";
		return sqlSession.selectOne(statement, commentNo);
	}
	public MemberDTO commentUser(Long commentNo){ // 1:1
		String statement = namespace + ".commentAssociation";
		return sqlSession.selectOne(statement, commentNo);
	}
}
