package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.BuyTicket;
import models.Ticket;
import models.User;
import Dao.Connect;
import Dao.BuyTicketDao;
import Dao.TicketDao;
import Dao.UserDao;
 
public class BuyTicketInsertion extends HttpServlet {
 
	public BuyTicketInsertion() {
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
			String buyti_userid = request.getParameter("userid");
			String buyti_ticketid = request.getParameter("ticketid");
			String buyti_trainid = request.getParameter("trainid");
//			String buyti_departPlace = request.getParameter("departPlace");
//			String buyti_arrivePlace = request.getParameter("arrivePlace");
			String buyti_price = request.getParameter("price");
			
				
			BuyTicket buy = new BuyTicket();
			buy.setUserid(buyti_userid);
			buy.setTicketid(buyti_ticketid);
			buy.setTrainid(buyti_trainid);
//			buy.setDepartPlace(buyti_departPlace);
//			buy.setArrivePlace(buyti_arrivePlace);
			buy.setPrice(buyti_price);
			
			
			  
		    int success  = BuyTicketDao.insert(buy);  
		    
			request.setAttribute("success", success); 

			//设置全路径 否则trainManage.jsp跳转到servlet/trainManage.jsp路径下不存在
		    response.sendRedirect("http://localhost:8080/SDUTest1/UserTicketView.jsp");  
		    
		} catch(Exception e) {
			System.out.println("错误："+e.getMessage());  
            response.sendRedirect("http://localhost:8080/SDUTest1/UserTicketView.jsp");  
		}
		
	}
	
//	public String checkMatch(HttpServletRequest request) {
//        String msg = "";//表示提示信息
//        String url = "";//表示跳转路径
//        //取得页面中传递过来的数据
//        String ticket = request.getParameter("ticket");
//        String train = request.getParameter("train");
//        System.out.println(ticket+","+train);
//        //判断用户名或者密码是否为空
//        if(ticket.equals(null)||train.equals(null))
//        {
//        	msg="车票编号或者火车车次为空,请重新输入！";
//        	url="/BuyTicketPage.jsp";
//        }else {
//        	//在数据库中查询用户是否存在
//	        UserDao userdao;
//	        User user=null;
//			try {
//				userdao = new UserDao();
//				user=userdao.getUserById(aid);
//				System.out.println(user);
//				//如果用户名错误
//				if(user==null)
//				{
//					msg="用户名错误,请重新输入!";
//					url="/index.jsp";
//				}else
//				{
//					//如果用户名不正确
//					if(!user.getPassword().equals(password))
//					{
//						msg="密码错误，请重新输入！";
//						url="/index.jsp";
//					}else {
//						msg="用户"+aid+",欢迎您使用系统！";
//						url="/loginsuccess.jsp";	
//					}
//				} 
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//        }
//        request.setAttribute("msg", msg);
//        return url;
//        
//        
// }

 
	public void init() throws ServletException {
		// Put your code here
	}
 

}
