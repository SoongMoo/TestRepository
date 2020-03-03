package Repository.Comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;

@Repository
public class CommentListRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "Repository.Mapper.CommentMapperDynamic";
	public List<MemberDTO> commentList(){
		String statement = namespace + ".commentAssociation";
		return sqlSession.selectList(statement);
	}
}
