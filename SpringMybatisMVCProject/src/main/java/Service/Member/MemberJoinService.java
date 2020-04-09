package Service.Member;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import Command.Member.MemberCommand;
import Controller.SmsSend;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

public class MemberJoinService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberRegMailService memberRegMailService;
	public Integer numUpdate(String num,String reciver,String userId) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setJoinOk(num);
		memberDTO.setUserEmail(reciver);
		memberDTO.setUserId(userId);
		return memberRepository.joinOkUpdate(memberDTO);
	}
	public Integer execute(MemberCommand memberCommand) {
		Integer result = null;
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		Timestamp userBirth = 
				new Timestamp(memberCommand.getUserBirth().getTime());
		memberDTO.setUserBirth(userBirth);
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		memberDTO.setUserPw(
				bcryptPasswordEncoder.encode(memberCommand.getUserPw()));
		System.out.println(memberDTO.getUserPw());
		result = memberRepository.insertMember(memberDTO);
		if(result != null) {
			SmsSend ss = new SmsSend();
			ss.smsSend(memberDTO.getUserPh1(), 
					memberDTO.getUserName()+"님 회원가입을 축하합니다.");
			memberRegMailService.sendMail(memberDTO.getUserEmail(), memberDTO.getUserId());
		}
		return result;
	}
}
