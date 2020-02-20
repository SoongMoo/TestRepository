package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Contoller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberModifyService {
	@Autowired
	private MemberDAO memberDAO;
	public Integer memberModify(MemberCommand memberCommand, Model model) {
		MemberDTO member = new MemberDTO();
		member.setUserId(memberCommand.getUserId());
		member.setUserEmail(memberCommand.getUserEmail());
		member.setUserAddr(memberCommand.getUserAddr());
		member.setUserPh1(memberCommand.getUserPh1());
		member.setUserPh2(memberCommand.getUserPh2());
		member.setUserPw(
				Encrypt.getEncryption(memberCommand.getUserPw()));
		Integer i = memberDAO.memberModify(member);
		return i;
	}
	
}
