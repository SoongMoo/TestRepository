package Repository.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Model.DTO.StartEndPageDTO;

@Repository
public class MemberRepository extends AbstractRepository{
	private final String namespace = "Mappers.memberMapper";
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	
	public List<String> selectMemberAll(){
		String statement =  namespace + ".selectMemberAll";
		List<String> list = sqlSession.selectList(statement);
		sqlSession.close();
		return list;
	}
	
	public Integer joinOkUpdate(MemberDTO memberDTO) {
		String statement = namespace + ".joinOkUpdate";
		Integer i = sqlSession.update(statement, memberDTO);
		sqlSession.commit();
		sqlSession.close();
		return i;
	}
	public List<MemberDTO> getMemberList(int page, int limit){
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		String statement = namespace + ".memberList";
		List<MemberDTO> lists = 
				sqlSession.selectList(statement, 
						new StartEndPageDTO(startRow,endRow));
		sqlSession.close();		
		return lists;
	}
	public Integer getListCount() {
		String statement = namespace + ".memberCount";
		Integer i = sqlSession.selectOne(statement);
		sqlSession.close();
		return i;
	}
	public Integer insertMember(MemberDTO dto) {
		Integer result = null;
		String statement = namespace + ".insertMember";
		try {
			result = sqlSession.insert(statement, dto) ;
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		return result;
	}
}
