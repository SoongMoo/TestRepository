package Controller.Member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;

public class MemberConfirm {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userId = req.getParameter("userId");
		MemberDAO dao = new MemberDAO();
		// 변수 = 값;
		String userConfirm = dao.selectId(userId);
		if(userConfirm == null) {
			req.setAttribute("msg", "사용가능한 id입니다.");
			req.setAttribute("num", 2);
		}else {
			req.setAttribute("msg", "사용중인 id입니다.");
			req.setAttribute("num", 1);
		}
		req.setAttribute("userId", userId);
	}
}
