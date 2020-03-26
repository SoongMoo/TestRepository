package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;

public class PwModifyAction {
	public Integer execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		String pw= Encrypt.getEncryption(
				req.getParameter("pw"));
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("memId");
		MemberDAO dao = new MemberDAO();
		// 로그인 할때 사용했던 메서드를 이용하여 비밀번호 확인
		Integer result = dao.userCheck(id, pw);	
		if(result == 0) {
			session.setAttribute("msg", "비밀번호를 다시 입력해주세요.");
		}else if(result == 1) {
			session.removeAttribute("msg");
		}
		return result;
	}
}
