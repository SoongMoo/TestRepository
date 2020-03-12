package Service.Survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.Question;

@Service
public class SurveyService {
	public void execute(Model model) {
		List<Question> questions = new ArrayList<Question>();
		
		
		List<String> list = new ArrayList<String>();
		
		list.add("서버");
		list.add("프론트");
		list.add("풀스택");
		
		Question q1 = new Question("당신의 역할은?", list);
		questions.add(q1);
		
		
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", 
				Arrays.asList("이클립스", "인텔리J", "서브라임"));
		questions.add(q2);
		Question q3 = new Question("하고 싶은 말을 적어주세요.");
		questions.add(q3);
		model.addAttribute("questions", questions);
	}
}
