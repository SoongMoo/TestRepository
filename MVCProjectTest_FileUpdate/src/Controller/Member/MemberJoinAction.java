package Controller.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberJoinAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		MemberDTO member = new MemberDTO();
		member.setUserAddr(req.getParameter("userAddr"));
		member.setUserEmail(req.getParameter("userEmail"));
		member.setUserGender(req.getParameter("userGender"));
		
		String bithDay = req.getParameter("userBirth");
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd");
		Date date = dt.parse(bithDay); 
		Timestamp userBirth = new Timestamp(date.getTime());
		member.setUserBirth(userBirth);
		
		member.setUserId(req.getParameter("userId"));
		member.setUserName(req.getParameter("userName"));
		member.setUserPh1(req.getParameter("userPh1"));
		member.setUserPh2(req.getParameter("userPh2"));
		member.setUserPw(Encrypt.getEncryption(
				req.getParameter("userPw")));
		
		MemberDAO dao = new MemberDAO();
		Integer result = dao.insertMember(member);
	}
}
