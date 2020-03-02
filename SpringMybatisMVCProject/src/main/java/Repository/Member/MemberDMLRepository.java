package Repository.Member;

import org.apache.ibatis.session.SqlSession;

import Model.DTO.MemberDTO;

public class MemberDMLRepository extends AbstractRepository{
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	private final String namespace = "Mappers.memberDMLMapper";
	public Integer memberUpdate(MemberDTO dto) {
		String statement = namespace + ".memberUpdate";
		Integer i = sqlSession.update(statement,dto);
		try {
			sqlSession.commit();
			sqlSession.close();
			return i;
		}catch(Exception e) {
			sqlSession.rollback();
			sqlSession.close();
			return 0;
		}
	}
}
