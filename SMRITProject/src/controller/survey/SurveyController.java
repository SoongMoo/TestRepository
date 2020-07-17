package controller.survey;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SurveyController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(
				contextPath.length());
		if(command.equals("/survey/surveyForm.sv")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/survey/surveyInsert.html");
			dispatcher.forward(request, response);
		}else if(command.equals("/survey/surveyInsert.sv")) {
			SurveyInsertService action = 
					new SurveyInsertService();
			action.execute(request);
			response.sendRedirect("surveyForm.sv");
		}else if(command.equals("/survey/survey.sv")) {
			SurveyAction action = new SurveyAction();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/survey/surveyForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/survey/surveyOk.sv")) {
			SurveyOkAction action =
					new SurveyOkAction();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"/survey/submitted.jsp");
			dispatcher.forward(request, response);
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
