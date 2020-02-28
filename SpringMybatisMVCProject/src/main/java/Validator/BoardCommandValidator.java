package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Board.BoardCommand;

public class BoardCommandValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return BoardCommand.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "boardName", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardPass", "required");
	}
}
