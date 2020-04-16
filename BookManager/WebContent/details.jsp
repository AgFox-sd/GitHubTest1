<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>详情页面</title>
<style type="text/css">
.ds{
background-color: #E7E7FF;
width: 400px;
height: 40px;
line-height: 40px;
}
.dss{
background-color: #E7E7FF;
width: 400px;
height: 120px;
line-height: 120px;
}
.ss{
background-color: #F7F7F7;
width: 400px;
height: 40px;
line-height: 40px;
}
.dsa{
margin-left: 100px;
}
</style>
</head>
<body>
 <div class="dss">图片 <a class="dsa"><img  src="img/${bk.bookImage }" width="100px" height="120px"> </a></div>
 <div class="ss">名称 <a class="dsa">  ${bk.bookName }</a></div>
 <div class="ds">作者  <a class="dsa">${bk.bookAuthor }</a></div>
 <div class="ss">出版社<a style="margin-left: 85px;"> ${bk.bookCbs }</a></div>
 <div class="ds">出版时间<a style="margin-left: 70px;"> ${bk.date }</a></div>
 <div class="ss">字数<a class="dsa"> ${bk.count }</a></div>
 <div class="ds">ISBN <a style="margin-left: 95px;">${bk.isbn }</a></div>
 <div class="ss">价格<a class="dsa"> ${bk.price }</a></div>
</body>
</html>