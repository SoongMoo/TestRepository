package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberInfoModifyProAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
			String email = req.getParameter("userEmail");
			String addr = req.getParameter("userAddr");
			String memberPh1 = req.getParameter("userPh1");
			String memberPh2  = req.getParameter("userPh2");
			MemberDTO member = new MemberDTO();
			member.setUserId(req.getParameter("id"));
			System.out.println("아이디 : " + member.getUserId());
			System.out.println(member.getUserPw());
			member.setUserEmail(email);
			member.setUserAddr(addr);
			member.setUserPh1(memberPh1);
			member.setUserPh2(memberPh2);
			MemberDAO dao = new MemberDAO();
			Integer i = dao.updateInfoMember(member);
	}
}
