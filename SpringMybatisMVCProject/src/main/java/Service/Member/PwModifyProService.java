package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import Command.Member.ChangePwdCommand;
import Model.DTO.MemberDTO;
import Model.DTO.UserPwChangeDTO;
import Repository.Member.LoginRepository;
import Repository.Member.MemberDMLRepository;

public class PwModifyProService {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberDMLRepository memberDMLRepository;
	public String execute(ChangePwdCommand changePwdCommand,
			Model model, Errors errors) {
		MemberDTO member = new MemberDTO();
		member.setUserId(changePwdCommand.getUserId());
		member = loginRepository.selectByUserId(member);
		if(bcryptPasswordEncoder.matches(changePwdCommand.getPw(), 
				member.getUserPw())) {
			UserPwChangeDTO dto = new UserPwChangeDTO(
					changePwdCommand.getUserId(),
					member.getUserPw(),
					bcryptPasswordEncoder.encode(
							changePwdCommand.getNewPw()));
			memberDMLRepository.changePw(dto);	
			return "redirect:/member/list";
		}else {
			errors.rejectValue("pw", "notCurrent");
			return "member/pwModify_1";
		}
	}
}
