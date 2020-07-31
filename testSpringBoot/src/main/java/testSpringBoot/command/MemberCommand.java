package testSpringBoot.command;


import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class MemberCommand {
	@Size(min = 1, max = 127,message = "아이디를 입력하여 주세요.")
	String userId;
	@NotEmpty
	/*
	 * @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message
	 * = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
	 */
	String userPw;
	@NotBlank
	///@Min(1)
	///@Max(127)
	String userPwCon;
	@NotBlank(message = "이름을 입력해주세요!")
	@Size(min = 1, max = 127)
	String userName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	LocalDateTime userBirth;
	@NotNull(message="성별을 선택해 주세요.")
	@Size(min = 1, max = 1)
	String userGender;
	@NotNull
	@Email
	String userEmail;
	@NotEmpty
	@Size(min = 1, max = 127)
	String userAddr;
	@NotNull
	@Size(min = 1, max = 13)
	String userPh1;
	String userPh2;
	
	public boolean isUserPwEqualToUserPwCon() {
		if(userPw.equals(userPwCon)) {
			return true;
		}
		return false;
	}
}
