package controller.survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.QuestionDAO;
import model.DTO.QuestionOptionsDTO;

public class SurveyAction {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userId = 
				(String)session.getAttribute("logId");
		QuestionDAO dao = new QuestionDAO();
		List<QuestionOptionsDTO> list =
				dao.surveySelect(userId);
		System.out.println(list.size());
		request.setAttribute("list", list);
	}
}
