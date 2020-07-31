package testSpringBoot.command;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component	
@Data
public class ChangePwdCommand {
	private String userId;
	private String userPw;
	private String newPw;
	private String reNewPw;
	public boolean isNewPwToReNewPw() {
		if(newPw.equals(reNewPw)) {
			return true;
		}
		return false;
	}
}
