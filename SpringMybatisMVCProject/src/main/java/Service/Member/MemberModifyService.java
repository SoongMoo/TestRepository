package Service.Member;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;
import Repository.Member.MemberDMLRepository;

public class MemberModifyService {
	@Autowired
	MemberDMLRepository memberDMLRepository; 
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	public Integer memberModify(MemberCommand memberCommand,Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setUserAddr(memberCommand.getUserAddr());
		dto.setUserBirth(new Timestamp(memberCommand.getUserBirth().getTime()));
		dto.setUserEmail(memberCommand.getUserEmail());
		dto.setUserGender(memberCommand.getUserGender());
		dto.setUserId(memberCommand.getUserId());
		dto.setUserName(memberCommand.getUserName());
		dto.setUserPh1(memberCommand.getUserPh1());
		dto.setUserPh2(memberCommand.getUserPh2());
		MemberDTO member = new MemberDTO();
		member = loginRepository.selectByUserId(dto);
		if(bcryptPasswordEncoder.matches(
				memberCommand.getUserPw() , member.getUserPw())) {
			dto.setUserPw(member.getUserPw());
			return memberDMLRepository.memberUpdate(dto);
		}
		return 0;
	}
}
