package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class IdCkProAction {

	public Integer execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int i = 0;
		String userEmail = request.getParameter("userEmail");
		String userPh1 = request.getParameter("userPh1");
		MemberDAO dao = new MemberDAO();
		String userId = dao.checkId(userEmail,userPh1);
		request.setAttribute("userId", userId);
		if(userId == null) {
			return i;
		}else {
			i =1;
			return i;
		}
	}
	
}
