package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Train;
import Dao.Connect;
import Dao.TrainDao;
 
public class TrainInsertion extends HttpServlet {
 
	public TrainInsertion() {
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
			//插入数据库
			String m_trainid = request.getParameter("trainid");
			String m_departPlace = request.getParameter("departPlace");
			String m_arrivePlace = request.getParameter("arrivePlace");
			String m_departTime = request.getParameter("departTime");
			
				
			Train train = new Train();
			train.setTrainid(m_trainid);
			train.setDepartPlace(m_departPlace);
			train.setArrivePlace(m_arrivePlace);
			train.setDepartTime(m_departTime);
			
			  
		    int success  = TrainDao.insert(train);  
			request.setAttribute("success", success);  
			
		    response.sendRedirect("http://localhost:8080/SDUTest1/Train.jsp");  
		    
		} catch(Exception e) {
			System.out.println("错误："+e.getMessage());  
            response.sendRedirect("http://localhost:8080/SDUTest1/Train.jsp");  
		}
		
	}
 
	public void init() throws ServletException {
		// Put your code here
	}
 

}
