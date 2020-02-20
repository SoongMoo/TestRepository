package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import Command.Member.MemberCommand;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class PwModifyService {
	@Autowired
	MemberDAO memberDAO;
	public MemberDTO execute(MemberCommand memberCommand) {
		MemberDTO member = new MemberDTO();
		member.setUserId(memberCommand.getUserId());
		member.setUserPw(memberCommand.getUserPw());
		member = memberDAO.selectByUserId(member);
		return member;
	}
}
