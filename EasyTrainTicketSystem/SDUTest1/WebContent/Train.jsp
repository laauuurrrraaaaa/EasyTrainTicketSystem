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
<title>管理员-查看车次页面</title>
</head>
<body style="background-color: #F5F5F5;">
<div align="center">
	  
	  
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#F5F5F5">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="adminLoginsuccess.jsp">管理员信息首页</a> > 车次信息管理</div>
					<br /><br />
					  <a href="InsertTrain.jsp" style='font-size:16px'>插入车次</a>
					  <a href="adminLoginsuccess.jsp">返回管理员信息首页</a>
				<table border="2" bordercolor="#708090"> 
		        <tr align=center>
		        	<td>火车列次</td><td>出发地</td><td>目的地</td><td>出发时间</td><td>车次操作</td>
		        </tr>
		        <c:forEach items="${trainList}" var="train">  
                    <tr align=center>  
                        <td>${train.trainid}</td>  
                        <td>${train.departPlace}</td>  
                        <td>${train.arrivePlace}</td>  
                        <td>${train.departTime}</td>  
                       
        <%
			List<Train> list = TrainDao.listTrain();
 
			for (Train t : list) {
		%><tr>
			<td><%=t.getTrainid()%></td>
			<td><%=t.getDepartPlace()%></td>
			<td><%=t.getArrivePlace()%></td>
			<td><%=t.getDepartTime()%></td>
			<td><a href="UpdateTrain.jsp?action=edit&id=${train.trainid}">修改车次</a>
            <a href="DeleteTrain.jsp?action=del&id=${train.trainid}"  
                  	 οnclick="return confirm('确定删除?')">删除车次</a></td>
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

