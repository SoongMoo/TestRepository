package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberModifyProAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		String pw = Encrypt.getEncryption(
				req.getParameter("userPw"));
		System.out.println(pw);
		String email = req.getParameter("userEmail");
		String addr = req.getParameter("userAddr");
		String memberPh1 = req.getParameter("userPh1");
		String memberPh2  = req.getParameter("userPh2");
		MemberDTO member = new MemberDTO();
		HttpSession session = req.getSession();
		member.setUserId((String)session.getAttribute("memId"));
		member.setUserPw(pw);
		System.out.println("아이디 : " + member.getUserId());
		System.out.println(member.getUserPw());
		member.setUserEmail(email);
		member.setUserAddr(addr);
		member.setUserPh1(memberPh1);
		member.setUserPh2(memberPh2);
		MemberDAO dao = new MemberDAO();
		Integer i = dao.updateMember(member);
		if(i == null || i <= 0) {
			session.setAttribute("msg", "비밀번호가 틀렸습니다.");
		}else {
			session.removeAttribute("msg");
		}
	}
}
