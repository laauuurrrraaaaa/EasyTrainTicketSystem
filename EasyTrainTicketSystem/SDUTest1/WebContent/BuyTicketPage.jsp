<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.BuyTicketDao"/> 
    <jsp:directive.page import="models.BuyTicket"/>
    <jsp:directive.page import="java.util.List"/>
    <%   
    List buyList = BuyTicketDao.listbuying();  
    request.setAttribute("buyList", buyList);  
%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>用户购买车票</title>
</head>
<body style="background-color: #E0EEEE;">
<div align="center">
	  
	  
	  <div class="trainCSS">
		
		   
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#E0EEEE">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="loginsuccess.jsp">个人信息首页</a> > 查看车票</div>
					<br /><br />
				
				<table border="2" bordercolor="#708090"> 
		        <tr align=center>
		        	<td>身份证号</td><td>车票编号</td><td>火车车次</td><<td>价格</td><td>操作</td>
		        </tr>
		        
        <%
			List<BuyTicket> list = BuyTicketDao.listbuying();
 
			for (BuyTicket ti : list) {
		%><tr>
			<td><%=ti.getUserid()%></td>
			<td><%=ti.getTicketid()%></td>
			<td><%=ti.getTrainid()%></td>
			<%-- <td><%=ti.getDepartPlace()%></td>
			<td><%=ti.getArrivePlace()%></td> --%>
			<td><%=ti.getPrice()%></td>
			<td>
            <a href="BuyTicketDelete.jsp?action=del&id=${buyticket.ticketid}"  
                  	 >退票</a></td>
		</tr>
		 
		<%
			}
		%>  
                        <a href="loginsuccess.jsp">返回个人信息首页</a>
                 
     
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

