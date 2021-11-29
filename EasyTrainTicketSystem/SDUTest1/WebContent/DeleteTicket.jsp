<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TicketDao"/>  
<jsp:directive.page import="models.Ticket"/>
<jsp:directive.page import="java.util.List"/> 
<%
	String action = request.getParameter("action");
	String id = request.getParameter("id");
    
	if("del".equals(action)){
		int isDelete = TicketDao.delete(id);  
    	request.setAttribute("isDelete", isDelete);  
	}
	
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>管理员-删除车票页面</title>
  </head>
  <body>
    <div align="center">
	   
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#F5F5F5">
				<tr><td align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="adminLoginsuccess.jsp">管理员信息首页</a> > 
						<a href="Ticket.jsp">车票信息管理</a> > 删除车票</div>
					<br /><br />
					<form action="TicketDeletion" method="post">	
					<table border="2" bordercolor="#708090" width="50%" height="80%">
					<tr>
						<td align="center">车票编号:</td><td align="center"><input type="text" id="ticketid" name="ticketid" 
							value=${ticket.ticketid} ></td>
					</tr>
					<tr>
						<td colspan=2 align=center><input type="submit" name="Submit" 
							value="提交" style='font-size:18px' width=200/></td>
			        </table>
		        <br /><br />												
				</TD></tr>
			 </table>
			</td>
		
		
	  </div>
	
  </body>

</html>