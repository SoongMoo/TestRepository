package Repository.Survey;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.DTO.QuestionOptionDTO;

public class SurveyRepository {
	@Autowired
	SqlSession sqlSession;
	
	private final String namespace = "Repository.Mapper.Question";
			
	public List<QuestionOptionDTO> surveySelectAll(){
		String statement = namespace + ".surveySelectAll";
		return sqlSession.selectList(statement);
	}
}
