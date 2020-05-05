package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServlet  extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException{
			String str = req.getParameter("forward");
			req.setCharacterEncoding("euc-kr");
	 		res.setContentType("text/html;charset=euc-kr");
			PrintWriter out = res.getWriter();
			if(str.equals("Main")) {
			 	
			 	try {
			 		
			 		out.print("<!DOCTYPE html>");
			 		out.print("<html>");
			 		out.print("<head>");
			 		out.print("<meta charset='UTF-8'>");
			 		out.print("<title>Insert title here</title>");
			 		out.print("</head>");
			 		out.print("<body>");
			 		out.print("<a href='Member?forward=login'>로그인페이지로 이동</a>");
			 		out.print("</body>");
			 		out.print("</html>");
			 		out.close();			 		
			 	}catch(Exception e){
			 		getServletContext().log("Error in HelloServlet:",e);
			 	}
			}else if(str.equals("login")) {
				
		 		out.print("<!DOCTYPE html>");
		 		out.print("<html>");
		 		out.print("<head>");
		 		out.print("<meta charset='UTF-8'>");
		 		out.print("<title>Insert title here</title>");
		 		out.print("</head>");
		 		out.print("<body>");
		 		out.print("안녕하세요");
		 		out.print("</body>");
		 		out.print("</html>");
		 		out.close();			 		
			}
		}
	
}
