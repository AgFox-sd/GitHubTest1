<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
  <form action="loginServlet" method="post">
 	     用户名：<input type="text" name="uname"/>
 	     密码：<input type="text" name="pwd"/>
 	   <input type="submit" value="登录"/>
 	</form>
</body>
</html>