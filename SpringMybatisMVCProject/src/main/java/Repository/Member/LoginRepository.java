package Repository.Member;

import org.apache.ibatis.session.SqlSession;

import Model.DTO.MemberDTO;

public class LoginRepository extends AbstractRepository{
	private SqlSession sqlSession = getSqlSessionFactory().openSession();
	private final String namespace = "Mappers.loginMapper";
	
	public MemberDTO selectByUserId(MemberDTO member) {
		String statement = namespace + ".selectUser";
		return sqlSession.selectOne(statement, member);
	}
}
