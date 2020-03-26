package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Encrypt;
import Model.DAO.MemberDAO;

public class LoginAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		String userId = request.getParameter("id1");
		String userPw = request.getParameter("pw");
		String idStore = request.getParameter("idStore");
		String auto1 = request.getParameter("autoLogin");
		
		MemberDAO dao = new MemberDAO();
		Integer i = dao.userCheck(userId, 
				Encrypt.getEncryption(userPw));
		HttpSession session = request.getSession();
		if(i == 1) {
			session.setAttribute("memId", userId);
			session.removeAttribute("failPw");
			session.removeAttribute("failId");
			if(auto1 != null && auto1.equals("auto")) {
				Cookie autoCk = new Cookie("auto1",userId);
				autoCk.setMaxAge(60*60*24);
				response.addCookie(autoCk);
			}
			if(idStore != null && idStore.equals("store")) {
				Cookie cookie = new Cookie("id",userId);
				cookie.setMaxAge(60*60*24*30);
				response.addCookie(cookie);
			}else {// ����Ƽüũ�� üũ�� ������ ��
				Cookie cookie = new Cookie("id","");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}else if(i == 0) {
			session.setAttribute("failPw", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			session.removeAttribute("failId");
		}else if(i == -1){
			session.setAttribute("failId", "���̵� �������� �ʰų� "
					+ "���� Ȯ���� �ȵǾ����ϴ�..");
			session.removeAttribute("failPw");
		}
	}
}
