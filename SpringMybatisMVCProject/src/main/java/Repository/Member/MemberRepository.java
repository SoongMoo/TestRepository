package Repository.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Model.DTO.StartEndPageDTO;

@Repository
public class MemberRepository extends AbstractRepository{
	private final String namespace = "Mappers.memberMapper";
	public MemberRepository() {
		super();
	}
	
	public List<String> selectMemberAll(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement =  namespace + ".selectMemberAll";
			List<String> list = sqlSession.selectList(statement);
			return list;
		}finally{
				sqlSession.close();
		}
	}
	
	public Integer joinOkUpdate(MemberDTO memberDTO) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".joinOkUpdate";
			Integer i = sqlSession.update(statement, memberDTO);
			sqlSession.commit();
			return i;
		}finally{
			sqlSession.close();
		}
	}
	public List<MemberDTO> getMemberList(int page, int limit){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			Long startRow = ((long)page -1 ) * 10 +1;
			Long endRow = startRow + limit -1;
			String statement = namespace + ".memberList";
			List<MemberDTO> lists = 
				sqlSession.selectList(statement, 
						new StartEndPageDTO(startRow,endRow));
			return lists;
		}finally{
			sqlSession.close();
		}
	}
	public Integer getListCount() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".memberCount";
			Integer i = sqlSession.selectOne(statement);
			return i;
		}finally{
			sqlSession.close();
		}
	}
	public Integer insertMember(MemberDTO dto) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Integer result = null;
		String statement = namespace + ".insertMember";
		try {
			result = sqlSession.insert(statement, dto) ;
			if(result >0 )	sqlSession.commit();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			return result;
		}finally {
			sqlSession.close();
		}
		
	}
}
