package controller.survey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.QuestionDAO;
import model.DTO.OptionsDTO;
import model.DTO.QuestionDTO;

public class SurveyInsertService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {}
		String question = request.getParameter("question");
		String option = request.getParameter("options");
		String [] options = option.split(",");
		
		HttpSession session = request.getSession();
		String userId = 
				(String)session.getAttribute("logId");
		// 질문에 대해서 db에 저장
		QuestionDTO qdto = new  QuestionDTO();
		qdto.setQuestionTitle(question);
		qdto.setUserId(userId);
		
		QuestionDAO dao = new QuestionDAO();
		int questionNum = dao.questionInsert(qdto);
		
		int optionsNum = 1;
		if(option != null && !option.trim().equals("")) {
			for(String optionsName : options) {
				OptionsDTO odto = new OptionsDTO();
				odto.setQuestionNum(questionNum);
				odto.setOptionsNum(optionsNum++);
				odto.setOptionsName(optionsName);
				odto.setUserId(userId);
				dao.optionInsert(odto);
			}
		}
		
	}
}
