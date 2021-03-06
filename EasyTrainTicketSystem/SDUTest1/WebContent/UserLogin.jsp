<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"
        +request.getServerName()+":"+request.getServerPort()
        +path+"/";
        System.out.println(basePath);
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>火车售票管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="validate/js/jquery-1.11.3.min.js" ></script>
    <script type="text/javascript" src="validate/js/additional-methods.min.js" ></script>
    <script type="text/javascript" src="validate/js/jquery.metadata.js" ></script>
    <script type="text/javascript" src="validate/js/jquery.validate.min.js" ></script>
    <script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
    <script type="text/javascript" src="validate/login.js"></script>
</head>
<body style="background-color: #E0EEEE;">
<div align = center class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <h2>火车售票管理系统（用户）</h2>
        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form id="loginForm" action="UserServlet" method="post">
                    <hr />
                    <h5>请输入登录信息，您的身份证号即为用户名</h5>
                    <a href="AdminLogin.jsp">切换至管理员登录页面</a>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-user"  ></i></span>
                        <input type="text" class="form-control" id="aid" name="aid" placeholder="请输入您的用户名 " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入您的密码" />
                    </div>

                    <button type="submit" class="btn btn-primary col-md-offset-7">登录</button>
                  
                </form>
            </div>

        </div>
    </div>
</div>
</body>
<script  type="text/javascript">
var a='<%=request.getAttribute("msg")%>';
if(a!='null')
	alert(a);
</script>
</html>
