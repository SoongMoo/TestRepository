package testSpringBoot.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginCommand {
	@NotEmpty
	@Size(min = 1, max = 127,message = "아이디를 입력하여 주세요.")
	String id1;
	@NotEmpty
	/*
	 * @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message
	 * = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
	 */
	String pw;
	Boolean idStore;
	Boolean autoLogin;
	
}