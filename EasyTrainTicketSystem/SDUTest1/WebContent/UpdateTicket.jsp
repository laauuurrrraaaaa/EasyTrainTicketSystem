<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TicketDao"/>  
<jsp:directive.page import="models.Ticket"/>
<jsp:directive.page import="java.util.List"/> 
<%
	String action = request.getParameter("action");
	String id = request.getParameter("id");
	Ticket ticket = TicketDao.find(id);  
    request.setAttribute("ticket", ticket);   
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员-修改车票页面</title>
  </head>
  
  <body>
  
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#F5F5F5">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="adminLoginsuccess.jsp">管理员信息首页</a> > <a href="Ticket.jsp">车票信息管理</a> > 插入车票</div>
					<br /><br />
					<H2 style="COLOR: #880000">修改车票信息</H2> 
				<form action="TicketUpdate" method="post">	
				<table border="1" bordercolor="#708090" align=center> 
					<tr>
						<td>车票编号:</td><td><input type="text" id="ticketid" name="ticketid" 
							value=${ticket.ticketid} ></td>
					</tr>
					<tr>
						<td>火车车次:</td><td><input type="text" id="trainid" name="trainid" 
							value=${ticket.trainid} ></td>
					</tr>
					<tr>
						<td>车厢号:</td><td><input type="text" id="carNo" name="carNo" 
							value=${ticket.carNo} ></td>
					</tr>
					<tr>
						<td>座位号:</td><td><input type="text" id="seatNo" name="seatNo" 
							value=${ticket.seatNo} ></td>
					</tr>
					<tr>
						<td>是否有余:</td><td><input type="text" id="available" name="available" 
							value=${ticket.available} ></td>
					</tr>
					
					<tr>
						<td colspan=2 align=center><input type="submit" name="Submit" 
							value="提交" style='font-size:18px' width=200/></td>
					</tr>
				</table>
				</form>
		        <br /><br />												
				</TD></tr>
			 </table>
			</td>
		</tr>
		<tr><td height="20"></td></tr>
		</table>
	  </div>
	  
	
	</div>
  </body>
</html>