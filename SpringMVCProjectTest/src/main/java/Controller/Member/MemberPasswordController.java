package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;
import Contoller.Encrypt;
import Model.DTO.MemberDTO;
import Service.Member.PwModifyService;

@Controller
@RequestMapping("/edit/changePassword")
public class MemberPasswordController {
	@Autowired
	protected PwModifyService pwModifyService; 
	@RequestMapping(method = RequestMethod.GET)
	public String memPw(MemberCommand memberCommand) {
		return "member/pwModify";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String changePw(MemberCommand memberCommand,Errors errors,
			Model model) {
		// userId로만 비교하므로 member 객체는 가져옴.
		MemberDTO member = 
				pwModifyService.execute(memberCommand);
		if(!Encrypt.getEncryption(memberCommand.getUserPw()).equals(
				member.getUserPw())) {
			errors.rejectValue("userPw", "badPw");
			return "member/pwModify";
		}
		ChangePwdCommand aaa = new ChangePwdCommand();
		aaa.setUserId(memberCommand.getUserId());
		model.addAttribute("changePwdCommand",aaa);
		return "member/pwModify_1";
	}
}
