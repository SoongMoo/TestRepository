package Validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Answer.AnswerCommand;

public class AnswerCommandValidate implements Validator{

	public boolean supports(Class<?> clazz) {
		return AnswerCommand.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "boardName", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardPass", "required");
	}

}
