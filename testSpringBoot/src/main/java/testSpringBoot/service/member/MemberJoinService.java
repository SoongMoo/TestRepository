package testSpringBoot.service.member;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.extern.log4j.Log4j;
import testSpringBoot.command.MemberCommand;
import testSpringBoot.controller.MailAction;
import testSpringBoot.controller.SmsSend;
import testSpringBoot.domain.MemberDTO;
import testSpringBoot.mapper.MemberMapper;
@Component
@Service
@Transactional
public class MemberJoinService {
	//BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
	@Autowired
	MemberMapper memberRepository;
	@Autowired
	MailAction mailAction;
	public Integer numUpdate(String num,String reciver,String userId) throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setJoinOk(num);
		memberDTO.setUserEmail(reciver);
		memberDTO.setUserId(userId);
		return memberRepository.joinOkUpdate(memberDTO);
	}
	public Integer execute(MemberCommand memberCommand,Model model) throws Exception{
		if(!memberCommand.isUserPwEqualToUserPwCon()) {
			model.addAttribute("valid_userPwCon", "비밀번호가 일치하지 않습니다.");
			return null;
		}
		Integer result = null;
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		Timestamp userBirth = 
				Timestamp.valueOf(memberCommand.getUserBirth());
		memberDTO.setUserBirth(userBirth);
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		memberDTO.setUserPw(memberCommand.getUserPw());
		/*
		 * memberDTO.setUserPw(
		 * bcryptPasswordEncoder.encode(memberCommand.getUserPw()));
		 */
		System.out.println(memberDTO.getUserPw());
		result = memberRepository.insertMember(memberDTO);
		if(result != null) {
			SmsSend ss = new SmsSend();
			try {
				mailAction.sendMail(memberDTO.getUserEmail(), memberDTO.getUserId());
				ss.smsSend(memberDTO.getUserPh1(), memberDTO.getUserName()+"님 회원가입을 축하합니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("duplicate_userId","사용중인 아이디입니다.");
		}
		return result;
	}
}
