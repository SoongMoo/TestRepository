package model.DTO;

import java.util.List;

public class QuestionOptionsDTO {
	QuestionDTO question;
	List<OptionsDTO> options;
	public QuestionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
	public List<OptionsDTO> getOptions() {
		return options;
	}
	public void setOptions(List<OptionsDTO> options) {
		this.options = options;
	}
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
