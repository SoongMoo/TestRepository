package controller.member;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import controller.MailAction;
import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberOkAction {
	public void execute(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userBir = request.getParameter("userBirth");
		userBir = userBir.replace("T", " ");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userAddr = request.getParameter("userAddr");
		String userPh1 = request.getParameter("userPh1");
		String userPh2 = request.getParameter("userPh2");
		String [] chk1 = request.getParameterValues("chk1");
		String interest ="";
		for(String s : chk1) {
			interest += s + "`";
		}
		SimpleDateFormat dt = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date =  null;
		try {
			date = dt.parse(userBir);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp userBirth = new Timestamp(date.getTime());
		System.out.println(userBirth);
		
		MemberDTO dto = new MemberDTO();
		dto.setInterest(interest);
		dto.setUserAddr(userAddr);
		dto.setUserBirth(userBirth);
		dto.setUserEmail(userEmail);
		dto.setUserGender(userGender);
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPh1(userPh1);
		dto.setUserPh2(userPh2);
		dto.setUserPw(userPw);
		
		MemberDAO dao = new MemberDAO();
		Integer i = dao.memberInsert(dto);
		if(i != null) {
			MailAction mail = new MailAction();
			mail.sendMail(dto);
		}
	}
}
