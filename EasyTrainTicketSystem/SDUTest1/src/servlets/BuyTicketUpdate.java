package servlets;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Dao.TicketDao;
import models.Ticket;
 
public class BuyTicketUpdate extends HttpServlet {
 
	public BuyTicketUpdate() {
		super();
	}
 //doGet
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
 
//doPost
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		response.setCharacterEncoding("UTF-8"); 
	    request.setCharacterEncoding("UTF-8");  
		
		try {
			String noTicket = "无";
			Ticket ticket = new Ticket();
			ticket.setAvailable(noTicket);
			
			  
		    int success  = TicketDao.update(ticket);  
			request.setAttribute("success", success);  
			
		    response.sendRedirect("http://localhost:8080/SDUTest1/UserTicketView.jsp");  
		    
		} catch(Exception e) {
			System.out.println("错误："+e.getMessage());  
            response.sendRedirect("http://localhost:8080/SDUTest1/UserTicketView.jsp");  
		}
	}
 
}