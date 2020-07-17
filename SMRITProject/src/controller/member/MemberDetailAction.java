package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

public class MemberDetailAction {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("logId");
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.memberSelect(1,1,userId);
		System.out.println();
		request.setAttribute("dto", list.get(0));
	}
}
