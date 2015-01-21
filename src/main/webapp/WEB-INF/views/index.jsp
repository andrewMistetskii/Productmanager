<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>h1</title>
</head>
<body>

<div class="pageWrapper">
    <div class="header">
        <h1>Index</h1>
    </div>
    <div class="content">
        <ul>
            <li><a href="/products">--> Склад</a></li>
            <li><a href="/passing_document">--> Покупка/продажа товара</a></li>
        </ul>
    </div>
    <div class="hFooter"></div>
</div>
<div class="footer">
    <h1>h1</h1>
</div>

</body>
</html>
