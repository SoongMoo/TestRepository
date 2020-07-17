package controller.survey;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DTO.AnsweredData;
import model.DTO.Respondent;

public class SurveyOkAction {
	public void execute(HttpServletRequest request) {
		List<String> list = new ArrayList<String>();
		
		Enumeration enums = request.getParameterNames();
		while(enums.hasMoreElements()) {
			String name= (String)enums.nextElement();
			if(name.startsWith("responses")) {
				list.add(request.getParameter(name));
			}
		}
		
		AnsweredData data = new AnsweredData();
		Respondent res = new Respondent();
		res.setAge(
				Integer.parseInt(
						request.getParameter("res.age")));
		res.setLocation(
				request.getParameter("res.location"));
		data.setRes(res);
		/*
		data.getRes().setLocation(
			request.getParameter("res.location"));
		data.getRes().setAge(
			Integer.parseInt(
				request.getParameter("res.age")));
		*/
		data.setResponses(list);
		request.setAttribute("ansData",data);
	}
}
