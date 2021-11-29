<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.page import="Dao.TrainDao"/>  
<jsp:directive.page import="models.Train"/>
<jsp:directive.page import="java.util.List"/> 
<%
	String action = request.getParameter("action");
	String id = request.getParameter("id");
	Train train = TrainDao.find(id);  
    request.setAttribute("train", train);   
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员-修改车次页面</title>
  </head>
  
  <body>
  
		   <td>
			<table width="100%" height="350" border="1"  cellpadding="0" cellspacing="0"  bgcolor="#F5F5F5">
				<tr><TD align="center" valign="top" style="padding-left:20px;padding-top:10px;">
					<div align="left">当前位置: <a href="adminLoginsuccess.jsp">管理员信息首页</a> > <a href="Train.jsp">车次信息管理</a> > 插入车次</div>
					<br /><br />
					<H2 style="COLOR: #880000">修改车次信息</H2> 
				<form action="TrainUpdate" method="post">	
				<table border="1" bordercolor="#708090" align=center> 
					<tr>
						<td>火车车次:</td><td><input type="text" id="trainid" name="trainid" 
							value=${train.trainid} ></td>
					</tr>
					<tr>
						<td>出发地:</td><td><input type="text" id="departPlace" name="departPlace" 
							value=${train.departPlace} ></td>
					</tr>
					<tr>
						<td>到达地:</td><td><input type="text" id="arrivePlace" name="arrivePlace" 
							value=${train.arrivePlace} ></td>
					</tr>
					<tr>
						<td>出发时间:</td><td><input type="text" id="departTime" name="departTime" 
							value=${train.departTime} ></td>
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