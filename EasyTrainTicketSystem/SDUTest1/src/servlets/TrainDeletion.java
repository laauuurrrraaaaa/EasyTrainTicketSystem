package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Ticket;
import models.Train;
import Dao.Connect;
import Dao.TicketDao;
import Dao.TrainDao;
 
public class TrainDeletion extends HttpServlet {
 
	public TrainDeletion() {
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
 
	//The doPost method of the servlet
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		response.setCharacterEncoding("UTF-8"); //设置输出编码  
	    request.setCharacterEncoding("UTF-8");  
		
		try {
			//更新数据库
			String del_trainid = request.getParameter("trainid");
			  
		    int success  = TrainDao.delete(del_trainid);  
			request.setAttribute("success", success);  
			//设置全路径 否则trainManage.jsp跳转到servlet/trainManage.jsp路径下不存在
		    response.sendRedirect("http://localhost:8080/SDUTest1/Train.jsp");  
		    
		} catch(Exception e) {
			System.out.println("错误："+e.getMessage());  
            response.sendRedirect("http://localhost:8080/SDUTest1/Train.jsp");  
		}
	}
 
 
}
