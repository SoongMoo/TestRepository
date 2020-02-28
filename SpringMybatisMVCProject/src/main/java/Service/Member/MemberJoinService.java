package Service.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import Command.Member.MemberCommand;
import Controller.Encrypt;
import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

public class MemberJoinService {
	@Autowired
	MemberRepository memberRepository;
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
				Encrypt.getEncryption(memberCommand.getUserPw()));
		try {
			result = memberRepository.insertMember(memberDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
