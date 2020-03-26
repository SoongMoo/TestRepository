package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;

public class MemberDelAction {
	public Integer execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("memId");
		String userPw = Encrypt.getEncryption(req.getParameter("userPw"));
		MemberDAO dao = new MemberDAO();
		Integer result = dao.memberDelete(userId,userPw );
		return result;
	}
}
