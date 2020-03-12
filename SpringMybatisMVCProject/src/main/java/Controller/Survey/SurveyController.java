package Controller.Survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Service.Survey.SurveyService;

@Controller
@RequestMapping("/survey/survey")
public class SurveyController {
	@Autowired
	SurveyService surveyService;
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		surveyService.execute(model);
		return "survey/surveyForm";
	}
	
	//@RequestMapping(method = RequestMethod.POST)
}
