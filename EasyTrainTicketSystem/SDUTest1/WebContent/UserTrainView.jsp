<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TrainDao"/> 
    <jsp:directive.page import="models.Train"/>
    <jsp:directive.page import="java.util.List"/>
     <%  
    List trainList = TrainDao.listTrain();  
    request.setAttribute("trainList", trainList);  
%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>用户-火车车次详情</title>
</head>
<body style="background-color: #E0EEEE;">
<div align="center">
	  
	  
	  <div class="trainCSS">
	  
		  
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#E0EEEE">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="loginsuccess.jsp">个人信息首页</a> > 车次管理信息</div>
					<br /><br />
					<a href="loginsuccess.jsp">返回个人信息首页</a>
					<a href="UserTicketView.jsp">查看车票详情</a>
				<table border="2" bordercolor="#708090"> 
		        <tr align=center>
		        	<td>火车列次</td><td>出发地</td><td>目的地</td><td>出发时间</td>
		        </tr>
                       
        <%
			List<Train> list = TrainDao.listTrain();
 
			for (Train t : list) {
		%><tr>
			<td><%=t.getTrainid()%></td>
			<td><%=t.getDepartPlace()%></td>
			<td><%=t.getArrivePlace()%></td>
			<td><%=t.getDepartTime()%></td>
		</tr>
		 
		<%
			}
		%>  
                        </td>  
                    </tr>  
                
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

