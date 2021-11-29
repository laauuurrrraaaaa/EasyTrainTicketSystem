<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎登录火车售票管理系统</title>
</head>
<body>
<body style="background-color: #F5F5F5;">
<div align="center">
<h1>管理员登录成功</h1>

<td align="center">	<font size="3" color="blue">请选择您今天要完成的事物：</font></td>
<tr>
				<td align="center"><p><a href="Train.jsp">
				<a href="Train.jsp" style='font-size:16px'>管理车次</a>
				<a href="Ticket.jsp" style='font-size:16px'>管理车票</a>
</tr>
</div>
</body>
<script  type="text/javascript">
var a='<%=request.getAttribute("msg")%>';
if(a!='null')
	alert(a);
</script>
</html>