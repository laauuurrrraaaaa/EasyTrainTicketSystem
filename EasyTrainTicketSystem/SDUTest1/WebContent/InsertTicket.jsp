<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TicketDao"/>  
<jsp:directive.page import="models.Ticket"/>
<jsp:directive.page import="java.util.List"/> 
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta charset="UTF-8">
<title>管理员-插入车票页面</title>
</head>
<body>
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#F5F5F5">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="adminLoginsuccess.jsp">管理员信息首页</a> > 
						<a href="Ticket.jsp">车票信息管理</a> > 插入车票</div>
					<br /><br />
				<form action="TicketInsertion" method="post">
				<table border="1" bordercolor="#708090" align=center> 
					<tr>
						<td>车票编号:</td><td><input type="text" id="ticketid" 
							name="ticketid" style='font-size:18px' width=200/></td>
					</tr>
					<tr>
						<td>火车车次:</td><td><input type="text" id="trainid" 
							name="trainid" style='font-size:18px' width=200/></td>
					</tr>
					<tr>
						<td>车厢号:</td><td><input type="text" id="carNo" 
							name="carNo" style='font-size:18px' width=200/></td>
					</tr>
					<tr>
						<td>座位号:</td><td><input type="text" id="seatNo" 
							name="seatNo" style='font-size:18px'/></td>
					</tr>
					<tr>
						<td>是否有余:</td><td><input type="text" id="available" 
							name="available" style='font-size:18px'/></td>
					</tr>
					<td colspan=2 align=center><input type="submit" 
							name="Submit" value="提交" style='font-size:18px' width=200/></td>
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
	  
	<div class="div">
</body>
</html>