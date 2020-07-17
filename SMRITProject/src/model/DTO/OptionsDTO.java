package model.DTO;

public class OptionsDTO {
	Integer questionNum;
	Integer optionsNum;
	String optionsName;
	String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}
	public Integer getOptionsNum() {
		return optionsNum;
	}
	public void setOptionsNum(Integer optionsNum) {
		this.optionsNum = optionsNum;
	}
	public String getOptionsName() {
		return optionsName;
	}
	public void setOptionsName(String optionsName) {
		this.optionsName = optionsName;
	}
}
