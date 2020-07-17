package controller.libBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibBoardController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		if(command.equals("/lib/libBoardList.lib")) {
			LibBoardListAction action = 
					new LibBoardListAction();
			action.execute(request);
			String path = "/lib_Board/lib_board_list.jsp";
			RequestDispatcher dispatcher =
				request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/lib/libBoardForm.lib")) {
			String path = "/lib_Board/lib_board_write.jsp";
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/lib/libBoardWrite.lib")) {
			LibBoardWriteAction action = 
					new LibBoardWriteAction();
			action.execute(request);
			response.sendRedirect("libBoardList.lib");
		}else if(command.equals("/lib/libBoardDetail.lib")) {
			LibBoardDetailAction action = new LibBoardDetailAction();
			action.execute(request);
			String path = "/lib_Board/lib_board_view.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/lib/libBoardModify.lib")) {
			LibBoardDetailAction action = new LibBoardDetailAction();
			action.execute(request);
			String path = "/lib_Board/lib_board_modify.jsp";
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if(command.equals("/lib/libBoardDel.lib")) {
			LibBoardDelAction action = 
					new LibBoardDelAction();
			action.execute(request);
			response.sendRedirect("libBoardList.lib");
		}else if(command.equals("/lib/libBoardModifyPro.lib")) {
			LibBoardModifyAction action =
					new LibBoardModifyAction();
			String num = action.execute(request);
			response.sendRedirect(
					"libBoardDetail.lib?num="
					+ num) ;
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
