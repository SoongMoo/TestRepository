package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Contoller.Encrypt;
import Model.DAO.MemberDAO;

public class PwModifyProAction {
	public Integer execute(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId= (String)session.getAttribute("memId");
		String currPw = 
				Encrypt.getEncryption(
						request.getParameter("pw")); 
		String newPw = 
				Encrypt.getEncryption(
						request.getParameter("newPw"));
		MemberDAO dao = new MemberDAO();
		Integer result = dao.pwUpdate(userId, currPw, newPw);
		return result;
	}
}
