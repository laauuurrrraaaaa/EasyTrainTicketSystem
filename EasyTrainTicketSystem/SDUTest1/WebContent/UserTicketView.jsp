<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TicketDao"/> 
<jsp:directive.page import="Dao.BuyTicketDao"/> 
<jsp:directive.page import="Dao.TrainDao"/> 
<jsp:directive.page import="models.Train"/>
    <jsp:directive.page import="models.Ticket"/>
    <jsp:directive.page import="models.BuyTicket"/>
    <jsp:directive.page import="java.util.List"/>
    <%   
    List ticketList = TicketDao.listTicket();  
    request.setAttribute("ticketList", ticketList);   
%>   
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String searchByTrain = request.getParameter("trainid");
	
    List<Ticket> trainList = TicketDao.findByTrain(searchByTrain); 
      
    request.setAttribute("trainList", trainList); 
   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>用户-火车车票详情</title>
</head>
<body style="background-color: #E0EEEE;">
	<div class="trainCSS">
		<table border="0" width="1024" cellpadding="0" cellspacing="0">
		<tr><td width="130" bgcolor="#E0EEEE" valign="top">
		  <table width="100%" cellpadding="0" cellspacing="0"  border="0">
		  	<tr><td height="10"></td></tr>
			<tr><td align="center">	<font size="3" color="black">请填写您要购买的车票：</font></td></tr>
			<tr><td height="10"></td></tr>
			
			<form action="BuyTicketInsertion" method="post">
			<table border="0" bordercolor="#708090" align=center> 
					<tr>
						<td>身份证号:</td>
					</tr>
					<tr>
						<td><input type="text" id="userid" 
							name="userid" style='font-size:16px' width=200/></td>
					</tr>
					<tr>
						<td>车票编号:</td>
					</tr>
					<tr>
						<td><input type="text" id="ticketid" 
							name="ticketid" style='font-size:16px' width=200/></td>
					</tr>
					<tr>
						<td>火车车次:</td>
					</tr>
					<tr>
						<td><input type="text" id="trainid" 
							name="trainid" style='font-size:16px' width=200/></td>
					</tr>
					<!-- <tr>
						<td>出发地:</td>
					</tr>
					<tr>
						<td><input type="text" id="departPlace" 
							name="departPlace" style='font-size:16px' width=200/></td>
					</tr>
					<tr>
						<td>到达地:</td>
					</tr>
					<tr>
						<td><input type="text" id="arrivePlace" 
							name="arrivePlace" style='font-size:16px'/></td>
					</tr>
					<tr> -->
						<td>价格:</td>
					</tr>
					<tr>
						<td><input type="text" id="price" 
							name="price" style='font-size:16px'/></td>
					</tr>
					<td colspan=2 align=center><input type="submit" 
							name="Submit" value="确认购买" style='font-size:18px' width=200/></td>
				</table>
		   </form>
		   </td>
		  
		   </td>
		   <td>
			<table width="100%" height="500" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#E0EEEE">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="loginsuccess.jsp">个人信息首页</a> > 车票信息管理</div>
					<br /><br />
				<form action="UserTicketView.jsp" method="post">
				<!-- html:form为struts -->
					按火车车次查询: <input type="text" id="trainid" name="trainid" style='font-size:18px'/><br /><br />
					<input type="submit" name="Select" value="查询车次" style='font-size:18px'/>
					  
				</form>
				<font size="3" color="black">以下为查询结果：</font>
				<table border="2" bordercolor="#000080"> 
		        <tr align=center>
		        	<td>车票编号</td><td>火车车次</td><td>车厢号</td><td>座位号</td><td>价格</td><!-- <td>是否有余</td> -->
		        
        <%
 
			for (Ticket ti : trainList) {
		%><tr>
			<td><%=ti.getTicketid()%></td>
			<td><%=ti.getTrainid()%></td>
			<td><%=ti.getCarNo()%></td>
			<td><%=ti.getSeatNo()%></td>
			<td><%=ti.getPrice()%></td>
			<%-- <td><%=ti.getAvailable()%></td> --%>
			
		</tr>
		 
		<%
			}
		%>  
		
		<table border="2" bordercolor="#708090" style = "margin-top: 20px"> 
	    <font size="3" color="black">以下为全部车票：</font>
		        <tr align=center>
		        	<td>车票编号</td><td>火车车次</td><td>车厢号</td><td>座位号</td><td>价格</td><!-- <td>是否有余</td> -->
		        
		 <%
			List<Ticket> list2 = TicketDao.listTicket();
 
			for (Ticket ti : list2) {
		%><tr>
			<td><%=ti.getTicketid()%></td>
			<td><%=ti.getTrainid()%></td>
			<td><%=ti.getCarNo()%></td>
			<td><%=ti.getSeatNo()%></td>
			<td><%=ti.getPrice()%></td>
		<%-- 	<td><%=ti.getAvailable()%></td> --%>
			
		</tr>
		 
		<%
			}
		%>  
		</table> 
         
		        </table>
		        
		        <br /><br />												
				</TD></tr>
			 </table>
			</td>
		</tr>
		
		</table>
	  </div> 	  
	  


</body>
</html> 

