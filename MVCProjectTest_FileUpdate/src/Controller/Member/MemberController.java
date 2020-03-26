package Controller.Member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberController 
	extends javax.servlet.http.HttpServlet 
	implements javax.servlet.Servlet{
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp );
	}
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
	public void doProcess(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException{
		String RequestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = RequestURI.substring(
				contextPath.length());
		if(command.equals("/index.nhn")) {
			CookieAction action = new CookieAction();
			action.execute(req,resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("Main/main.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberRegist.nhn")) {
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberForm.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/userConfirm.nhn")){
			MemberConfirm action = new MemberConfirm();
			action.execute(req, resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/userConfirm.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/MemberJoinAction.nhn")) {
			MemberJoinAction action = new MemberJoinAction();
			try {
				action.execute(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("index.nhn");
		}else if(command.equals("/loginPro.nhn")) {
			LoginAction action = new LoginAction();
			action.execute(req, resp);
			resp.sendRedirect("index.nhn");
		}else if(command.equals("/logout.nhn")) {
			LogoutAction action = new LogoutAction();
			action.execute(req, resp);
			resp.sendRedirect("index.nhn");
		}else if(command.equals("/memberList.nhn")) {
			MemberListAction action = new MemberListAction();
			action.execute(req, resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberList.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberDetail.nhn")) {
			MemberDetailAction action =  new MemberDetailAction();
			action.execute(req, resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberDetail.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberDel.nhn")) {
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberDel.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberDelPro.nhn")) {
			MemberDelAction action = new MemberDelAction();
			Integer result = action.execute(req, resp);
			System.out.println("memberDelPro : " + result);
			if(result > 0) {
				resp.sendRedirect("logout.nhn");
			}else {
				resp.sendRedirect("memberDetail.nhn");
			}
		}else if(command.equals("/memberInfo.nhn")) {
			MemberInfoAction action =  new MemberInfoAction();
			action.execute(req, resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberInfo.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberInfoDel.nhn")){
			MemberInfoDelAction action = new MemberInfoDelAction();
			action.execute(req, resp);
			resp.sendRedirect("memberList.nhn");
		}else if(command.equals("/memberModify.nhn")) {
			MemberModifyAction action = new MemberModifyAction();
			action.execute(req, resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberModify.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberModifyPro.nhn")) {
			MemberModifyProAction action = 
					new MemberModifyProAction();
			action.execute(req, resp);
			resp.sendRedirect("memberModify.nhn");
		}else if(command.equals("/memberInfoModify.nhn")) {
			MemberInfoModifyAction action = 
					new MemberInfoModifyAction();
			action.execute(req, resp);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/memberInfoPro.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/memberInfoModifyPro.nhn")) {
			MemberInfoModifyProAction action = 
					new MemberInfoModifyProAction();
			action.execute(req, resp);
			resp.sendRedirect("memberInfoModify.nhn?id="
							+req.getParameter("id"));
		}else if(command.equals("/memPw.nhn")) {
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher(
							"Member/pwModify.jsp");
			dispatcher.forward(req, resp);
		}else if(command.equals("/pwModify1.nhn")) {
			PwModifyAction action = new PwModifyAction();
			Integer result = action.execute(req, resp);
			System.out.println("pwModify1.nhn : " + result);
			if(result == 1) {
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher(
								"Member/pwModify_1.jsp");
				dispatcher.forward(req, resp);
			}else {
				resp.sendRedirect("memPw.nhn");
			}
		}else if(command.equals("/pwModifyPro.nhn")) {
			PwModifyProAction action = new PwModifyProAction();
			Integer result = action.execute(req, resp);
			if(result == 0) {
				resp.sendRedirect("memPw.nhn");
			}else {
				resp.sendRedirect("memberDetail.nhn");
			}
		}
	}
}
