package Controller.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController 
	extends javax.servlet.http.HttpServlet 
	implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/index.nhn")) {
			CookieAction action =new CookieAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Main/main.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberRegist.nhn")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/MemberJoinAction.nhn")) {
			MemberJoinAction action = new MemberJoinAction();
			String path = action.execute(request, response);
			response.sendRedirect(path);
		}else if(command.equals("/userConfirm.nhn")) {
			MemberConfirm action = new MemberConfirm();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/userConfirm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/loginPro.nhn")) {
			LoginAction action = new LoginAction();
			action.execute(request, response);
			response.sendRedirect("index.nhn");
		}else if(command.equals("/logout.nhn")) {
			LogoutAction action = new LogoutAction();
			action.execute(request, response);
			response.sendRedirect("index.nhn");
		}else if(command.equals("/memberDetail.nhn")) {
			MemberDetailAction action =  new MemberDetailAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/memberDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberList.nhn")) {
			MemberListAction action = new MemberListAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberInfo.nhn")) {
			System.out.println("aaaaa");
			MemberInfoAction action =  new MemberInfoAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberInfoModify.nhn")) {
			MemberInfoAction action =  new MemberInfoAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/memberInfoPro.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberInfoModifyPro.nhn")) {
			MemberInfoModifyPro action = new MemberInfoModifyPro();
			action.execute(request, response);
			response.sendRedirect("memberInfo.nhn?id="
									+ request.getParameter("id"));
		}else if(command.equals("/memberInfoDel.nhn")) {
			MemberInfoDelAction action = new MemberInfoDelAction();
			action.execute(request, response);
			response.sendRedirect("memberList.nhn");
		}else if(command.equals("/memberModify.nhn")) {
			MemberModifyAction action = new MemberModifyAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/memberModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memPw.nhn")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Member/pwModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/pwModify1.nhn")) {
			PwModifyAction action = new PwModifyAction();
			Integer result = action.execute(request, response);
			if(result==1) {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("Member/pwModify_1.jsp");
				dispatcher.forward(request, response);
			}else if(result == 0) {
				response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('비밀번호가 일치하지 않습니다.');");
		   		out.println("location.href='memPw.nhn';");
		   		out.println("</script>");
		   		out.close();
			}
		}else if(command.equals("/pwModifyPro.nhn")) {
			PwModifyProAction action = new PwModifyProAction();
			Integer result = action.execute(request, response);
			if(result == 1) {
				response.sendRedirect("memberDetail.nhn");
			}else {
				response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('비밀번호가 일치하지 않습니다.');");
		   		out.println("location.href='memPw.nhn';");
		   		out.println("</script>");
		   		out.close();
			}
		}else if(command.equals("/mailForm.nhn")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Mail/mailForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/mailSend.nhn")) {
			MailSendAction action = new MailSendAction();
			action.execute(request, response);
			response.sendRedirect("index.nhn");
		}else if(command.equals("/memberOk.nhn")) {
			MemberMailOk action = new MemberMailOk();
			String path = action.execute(request, response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException{
		doProcess(request,response);		
	}
}
