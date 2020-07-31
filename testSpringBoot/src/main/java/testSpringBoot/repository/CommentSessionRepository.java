package testSpringBoot.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import testSpringBoot.domain.CommentRepliesDTO;

@Repository
public class CommentSessionRepository extends AbstractRepository {
	private final String namespace = "testSpringBoot.mapper.CommentMapperDynamic";

	public CommentRepliesDTO selectCommentByPrimaryKeyCollection(Long commentNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".commentRepliesCollection";
			return (CommentRepliesDTO)sqlSession.selectOne(statement, commentNo);
		} finally {
			sqlSession.close();
		}
	}
}
