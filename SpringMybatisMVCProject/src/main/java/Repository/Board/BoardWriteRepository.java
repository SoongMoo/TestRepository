package Repository.Board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.BoardDTO;

@Repository
public class BoardWriteRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace="boardMapper";
	
	public Integer insertBoard(BoardDTO dto) {
		String statement = namespace+".boardInsert";
		Integer result = sqlSession.insert(statement, dto);

		return result;
	}
	
	
	public BoardDTO boardOneSelect(Integer boardNum) {
		String statement = namespace+".boardSelect";
		BoardDTO dto = sqlSession.selectOne(statement,boardNum); //하나만 보기
		return dto;
	}
	public List<BoardDTO> boardAllSelect() {
		String statement = namespace+".boardSelect";
		List<BoardDTO> list = sqlSession.selectList(statement,null);  //전체보기
		
		return list;
	}
}
