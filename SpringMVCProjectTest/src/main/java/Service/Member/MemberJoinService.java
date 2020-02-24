package Service.Member;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.MemberCommand;
import Contoller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;
@Service
public class MemberJoinService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Integer execute(MemberCommand memberCommand) {
		Integer result = 0;
		MemberDTO memberDTO = new MemberDTO();
				memberDTO.setUserAddr(memberCommand.getUserAddr());
		Timestamp userBirth = new Timestamp(
				memberCommand.getUserBirth().getTime());
		memberDTO.setUserBirth(userBirth);
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		memberDTO.setUserPw(Encrypt.getEncryption(
				memberCommand.getUserPw()));
		result = memberDAO.insertMember(memberDTO);
		return result;
	}
}
