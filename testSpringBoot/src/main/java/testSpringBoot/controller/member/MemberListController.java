package testSpringBoot.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import testSpringBoot.command.AuthInfo;
import testSpringBoot.command.ChangePwdCommand;
import testSpringBoot.command.MemberCommand;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.service.member.MemberDeleteSevice;
import testSpringBoot.service.member.MemberDetailService;
import testSpringBoot.service.member.MemberListService;
import testSpringBoot.service.member.MemberModifyService;
import testSpringBoot.service.member.PwModifyProService;
import testSpringBoot.service.member.PwModifyService;

@Controller
@RequestMapping("member")
public class MemberListController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberListService memberListService;
	@Autowired
	private MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService; 
	@Autowired
	PwModifyService pwModifyService;
	@Autowired
	PwModifyProService pwModifyProService;
	@Autowired
	MemberDeleteSevice memberDeleteSevice;
	
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping("list")
	public String  memberlist(Model model , @RequestParam(value = "page" , defaultValue = "1") Integer page )  
			 throws Exception{
		memberListService.memberList(model,page);

		return "member/memberList";
	}
	@RequestMapping("memberDetail")
	public String  memberDetail(Model model,HttpSession session )  
			 throws Exception{
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		memberDetailService.memberDetail(authInfo.getId(), model);
		return "thymeleaf/member/memberDetail";
	}
	@RequestMapping("memberPw")
	public String  memberPw(Model model,HttpServletRequest request )  {
		return "thymeleaf/member/memberInfoPw";
	}
	@RequestMapping("memberInfoCng")
	public String  memberInfoCng(Model model,HttpSession session, MemberCommand memberCommand)  
			 throws Exception{
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO member = memberDetailService.memberDetail(authInfo.getId(), model);
		if(passwordEncoder.matches(memberCommand.getUserPw(), member.getUserPw())) {
			return "thymeleaf/member/memberInfoPro";
		}else {
			model.addAttribute("valid_Pw" ,"비밀번호가 틀렸습니다.");
			return "thymeleaf/member/memberInfoPw";
		}
	}
	@RequestMapping("memberInfoModifyPro")
	public String  memberInfoModifyPro(Model model, MemberCommand memberCommand)  
			 throws Exception{
		Integer i = memberModifyService.memberModify(memberCommand, model);
		if(i > 0) {
			return "redirect:/member/memberDetail";
		}else {
			model.addAttribute("valid_Pw", "비밀번호가 틀렸습니다.");
			return "thymeleaf/member/memberInfoPro";
		}
	}
	@RequestMapping(value="memberPwForm", method = RequestMethod.GET)
	public String  memberPwForm(MemberCommand memberCommand)  {
		return "thymeleaf/member/pwModify";
	}
	@RequestMapping(value="memberPwForm", method = RequestMethod.POST)
	public String  memberPwForm1(Model model, ChangePwdCommand changePwdCommand, HttpSession session)  
			 throws Exception{
		return pwModifyService.execute(changePwdCommand , model, session);
	}
	@RequestMapping(value="pwModifyPro", method = RequestMethod.POST)
	public String  pwModifyPro(Model model, ChangePwdCommand changePwdCommand,HttpSession session) 
			 throws Exception{
		if(!changePwdCommand.isNewPwToReNewPw()) {
			model.addAttribute("valid_reNewPw", "새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "thymeleaf/member/pwModify_1";
		}
		return pwModifyProService.execute(model, changePwdCommand ,  session);
	}
	@RequestMapping(value="memberUserDel", method = RequestMethod.GET)
	public String  memberUserDel( MemberCommand memberCommand)  {
		return "thymeleaf/member/userDeltePw";
	}
	@RequestMapping(value="memberUserDelPro", method = RequestMethod.POST)
	public String  memberUserDelPro(@RequestParam(value = "userPw") String userPw, Model model,HttpSession session) 
			 throws Exception{
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		int i = memberDeleteSevice.memberInfoDelete(authInfo.getId(),userPw);
		if(i > 0) return "redirect:/logout";
		else {
			model.addAttribute("valid_Pw","비밀번호가 틀렸습니다.");
			return "thymeleaf/member/userDeltePw";
		}
	}
	
	
	
	
	
	
}
