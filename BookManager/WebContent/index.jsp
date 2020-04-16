<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页面</title>
<style type="text/css">
#no{
background-color: red;
color:white;
height: 40px;
}
.no{
background-color: white;
color:black;
height: 40px;
}
#tbl{
border-collapse: collapse;
}
</style>
</head>
<body>
<a style="font-size: 30px;color: blue;">欢迎您${user }</a>
<table border="1" id="tbl">
<tr align="center" id="no">
<td>书籍名称</a></td>
<td>作者</td>
<td>出版社名称</td>
<td>出版时间</td>
<td>ISBN</td>
<td>字数</td>
<td>价格</td>
</tr>
<c:forEach items="${list }" var="bk">
<tr class="no">
<td><a href="bookServlet?id=${bk.bookId }">${bk.bookName }</a></td>
<td>${bk.bookAuthor }</td>
<td>${bk.bookCbs }</td>
<td>${bk.date }</td>
<td>${bk.isbn }</td>
<td>${bk.count }</td>
<td>￥${bk.price }</td>
</tr>
</c:forEach>
</table>
</body>
</html>