package Repository.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.BoardDTO;

@Repository
public class BoardWriteRepository {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "Mappers.boardMapper";
	public void insertBoard(BoardDTO dto) {
		String statement = namespace + ".boardInsert";
		Integer result = sqlSession.insert(statement, dto);
	}
}
