package Controller.Member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberListAction {
	public void execute(HttpServletRequest req, 
			HttpServletResponse resp) {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list  = dao.memberAllSelect();
		req.setAttribute("list", list);
		req.setAttribute("listCount", list.size());
	}
}
