package Controller.Member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;

public class MemberListAction {
	public void execute(HttpServletRequest request, 
			HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		List list = dao.memberAllSelect();
		Integer count = dao.memberCount();
		request.setAttribute("memberList",list);
		request.setAttribute("count",count);
	}
}
