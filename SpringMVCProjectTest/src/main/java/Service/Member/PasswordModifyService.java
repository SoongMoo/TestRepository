package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;

import Command.Member.ChangePwdCommand;
import Contoller.Encrypt;
import Model.DAO.MemberDAO;

public class PasswordModifyService {
	@Autowired
	private MemberDAO memberDAO;
	public Integer updatePassword(ChangePwdCommand changePwdCommand) {
		return memberDAO.pwUpdate(changePwdCommand.getUserId(), 
				Encrypt.getEncryption(changePwdCommand.getPw()),
				Encrypt.getEncryption(changePwdCommand.getNewPw()));
	}
}