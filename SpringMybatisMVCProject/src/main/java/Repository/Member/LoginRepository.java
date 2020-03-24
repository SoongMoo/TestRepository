package Repository.Member;

import org.apache.ibatis.session.SqlSession;

import Model.DTO.MemberDTO;

public class LoginRepository extends AbstractRepository{
	private final String namespace = "Mappers.loginMapper";
	public LoginRepository() {
		super();
	}
	public MemberDTO selectByUserId(MemberDTO member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".selectUser";
			MemberDTO member1 = sqlSession.selectOne(statement, member);
			return member1;
		}finally{
			sqlSession.close();
		}
		
		
	}
}
