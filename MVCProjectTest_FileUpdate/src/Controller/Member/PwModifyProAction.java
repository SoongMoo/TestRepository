package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;

public class PwModifyProAction {
	public Integer execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("memId");
		String pw = Encrypt.getEncryption(
				req.getParameter("pw"));
		String newPw = Encrypt.getEncryption(
				req.getParameter("newPw"));
		MemberDAO dao = new MemberDAO();
		Integer result = dao.pwUpdate(id, pw, newPw);
		return result;
	}
}
