package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;

@Service
public class PwModifyService {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public String execute(MemberCommand memberCommand,Errors errors,
			Model model) {
		MemberDTO member = new MemberDTO();
		member.setUserId(memberCommand.getUserId());
		member = loginRepository.selectByUserId(member);
		if(bcryptPasswordEncoder.matches(
				memberCommand.getUserPw() , member.getUserPw())) {
			ChangePwdCommand changePwdCommand = new ChangePwdCommand();
			changePwdCommand.setUserId(memberCommand.getUserId());
			model.addAttribute("changePwdCommand", changePwdCommand	); 
			return "member/pwModify_1";
		}else {
			errors.rejectValue("userPw", "badPw");
			return "member/pwModify";
		}
	}
}
