<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TicketDao"/> 
    <jsp:directive.page import="models.Ticket"/>
    <jsp:directive.page import="java.util.List"/>
    <%   
    List ticketList = TicketDao.listTicket();  
    request.setAttribute("ticketList", ticketList);  
%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>管理员-查看车票页面</title>
</head>
<body style="background-color: #F5F5F5;">
<div align="center">
	
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#F5F5F5">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="adminLoginsuccess.jsp">管理员信息首页</a> > 车票信息管理</div>
					<br /><br />
					  <a href="InsertTicket.jsp" style='font-size:16px'>插入车票</a>
					  <a href="adminLoginsuccess.jsp">返回管理员信息首页</a>
				
				<table border="2" bordercolor="#708090"> 
		        <tr align=center>
		        	<td>车票编号</td><td>火车车次</td><td>车厢号</td><td>座位号</td><td>是否有余</td><td>车票操作</td>
		        </tr>
		         <c:forEach items="${ticketList}" var="ticket">  
                    <tr align=center>  
                    	<td>${ticket.ticketid}</td> 
                        <td>${ticket.trainid}</td>  
                        <td>${ticket.carNo}</td>  
                        <td>${ticket.seatNo}</td>  
                        <td>${ticket.available}</td>  
                      
        <%
			List<Ticket> list = TicketDao.listTicket();
 
			for (Ticket ti : list) {
		%><tr>
			<td><%=ti.getTicketid()%></td>
			<td><%=ti.getTrainid()%></td>
			<td><%=ti.getCarNo()%></td>
			<td><%=ti.getSeatNo()%></td>
			<td><%=ti.getAvailable()%></td>
			<td><a href="UpdateTicket.jsp?action=edit&id=${train.trainid}">修改车票</a>
            <a href="DeleteTicket.jsp?action=del&id=${train.trainid}"  
                  	 οnclick="return confirm('确定删除?')">删除车票</a></td>
		</tr>
		 
		<%
			}
		%>  
                        </td>  
                    </tr>  
                </c:forEach>
		        </table>
		        <br /><br />												
				</TD></tr>
			 </table>
			</td>
		</tr>
		<tr><td height="20"></td></tr>
		</table>
	  </div> 	  
	  


</body>
</html> 

