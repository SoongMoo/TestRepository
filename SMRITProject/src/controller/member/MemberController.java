package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberController extends HttpServlet implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		if(command.equals("/mem/meberList.mem")) {
			MeberListAction action = new MeberListAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberRegist.mem")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberForm.html");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberOk.mem")) {
			MemberOkAction action = new MemberOkAction();
			action.execute(request);
			HttpSession session = request.getSession();
			if(session.getAttribute("logId")!= null) {
				response.sendRedirect("meberList.mem");
			}else {
				response.sendRedirect("../main.main");
			}
		}else if(command.equals("/mem/memberInfo.mem")) {
			MemberInfoAction action = new MemberInfoAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberInfoPw.mem")) {
			MemberInfoAction action = new MemberInfoAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberInfoPro.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberInfoModifyPro.mem")) {
			MemberInfoModifyAction action = 
					new MemberInfoModifyAction();
			action.execute(request);
			if(request.getParameter("memChk") != null && 
					request.getParameter("memChk").equals("true")) {
				response.sendRedirect("memberDetail.mem");
			}else {
				response.sendRedirect("memberInfo.mem?userId="+
						request.getParameter("id"));
				
			}
		}else if(command.equals("/mem/memberDel.mem")) {
			MemberDelAction action = new MemberDelAction();
			action.execute(request);
			response.sendRedirect("meberList.mem");
		}else if(command.equals("/mem/memberAgree.mem")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/member/agree.html");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/userConfirm.mem")) {
			//아이디 중복 체크
			MemberConfirmAction action = 
					new MemberConfirmAction();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(
							"/member/userConfirm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberJoinOk.mem")) {
			MemberJoinOkAction action = 
					new MemberJoinOkAction();
			String path = action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberDetail.mem")) {
			MemberDetailAction action = 
					new MemberDetailAction();
			action.execute(request);
			String path = "/member/memberDetail.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberPw.mem")) {
			String path = "/member/memberInfoPw.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberInfoCng.mem")) {
			MemberInfoCngAction action = 
					new MemberInfoCngAction();
			Integer i = action.execute(request);
			if(i == 1) {
				MemberDetailAction action1 = 
						new MemberDetailAction();
				action1.execute(request);
				request.setAttribute("memChk", "true");
				String path = "/member/memberInfoPro.jsp";
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else if(i == 0) {
				response.sendRedirect("memberPw.mem");
			}
		}else if(command.equals("/mem/memberPwForm.mem")) {
			String path = "/member/pwModify.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/pwModify1.mem")) {
			PwModifyAction action = new PwModifyAction();
			Integer i = action.execute(request);
			if(i == 1) {
				String path = "/member/pwModify_1.jsp";
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else if(i == 0) {
				response.sendRedirect("memberPwForm.mem");
			}
		}else if(command.equals("/mem/pwModifyPro.mem")){
			PwModifyProAction action =
					new PwModifyProAction();
			Integer i = action.execute(request);
			if(i == 1) {
				String path = "/member/pwModifyOk.jsp";
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else if(i == 0) {
				response.sendRedirect("memberPwForm.mem");
			}
		}else if(command.equals("/mem/memberUserDel.mem")) {
			String path = "/member/userDeltePw.html";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/memberUserDelPro.mem")){
			MemberUserDelAction action = 
					new MemberUserDelAction();
			action.execute(request);
			response.sendRedirect("../login/logOutPro.main");
		}else if(command.equals("/mem/idCk.mem")) {
			RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/member/idCk.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mem/idCkPro.mem")) {
			IdCkProAction action = new IdCkProAction();
			Integer i = action.execute(request);
			if(i == 1) {//아이디가 있습니다.
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/member/idConfirm.jsp");
				dispatcher.forward(request, response);
			}else {//아이디가 없습니다.
				response.sendRedirect("idCk.mem");
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
