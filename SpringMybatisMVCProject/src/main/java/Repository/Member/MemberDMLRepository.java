package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Model.DTO.UserPwChangeDTO;

@Repository
public class MemberDMLRepository extends AbstractRepository{
	private final String namespace = "Mappers.memberDMLMapper";
	public MemberDMLRepository() {
		super();
	}
	public void changePw(UserPwChangeDTO dto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".userPwChange";
		Integer i = sqlSession.update(statement,dto);
		try {
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
	public void memberDelete(MemberDTO dto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".memberDelete";
		Integer i = sqlSession.update(statement,dto);
		try {
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
	}
	public Integer memberUpdate(MemberDTO dto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".memberUpdate";
		Integer i = 0; 
		i = sqlSession.update(statement,dto);
		try {
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
		}finally{
			sqlSession.close();
		}
		return i;
	}
	
}
