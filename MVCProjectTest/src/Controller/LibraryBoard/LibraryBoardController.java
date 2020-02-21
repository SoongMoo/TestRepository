package Controller.LibraryBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryBoardController 
	extends javax.servlet.http.HttpServlet 
	implements javax.servlet.Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException  {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		if(command.equals("/library.lb")) {
			LibraryBoardListAction action = 
					new LibraryBoardListAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("LibraryBoard/board_list.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/BoardWrite.lb")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("LibraryBoard/board_write.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWritePro.lb")) {
			BoardWritePro action = new BoardWritePro();
			action.execute(request,response);
			response.sendRedirect("library.lb");
		}else if(command.equals("/boardDetailAction.lb")) {
			BoardDetailAction action = new BoardDetailAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("LibraryBoard/board_view.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.lb")) {
			BoardDetailAction action = new BoardDetailAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("LibraryBoard/board_modify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/BoardModifyAction.lb")) {
			BoardModifyAction action = new BoardModifyAction();
			action.execute(request,response);
			response.sendRedirect("boardDetailAction.lb?num="+
					request.getParameter("BOARD_NUM"));
		}else if(command.equals("/boardDelete.lb")) {
			BoardDeleteAction action = new BoardDeleteAction();
			action.execute(request,response);
			response.sendRedirect("library.lb");
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
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
