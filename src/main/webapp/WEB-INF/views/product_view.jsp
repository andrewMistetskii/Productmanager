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
    <title><spring:message code="label.title" /></title>
</head>
<body>

<div class="pageWrapper">
    <div class="header">
        <h1>produxt_view</h1>
        <a href="/">--> main</a>
    </div>
    <div class="content">

        <table border="1" class="viewData">
            <tr class="headRow">
                <td>id</td>
                <td>product name</td>
                <td>product description</td>
                <td>count</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>${id}</td>
                <td>${name}</td>
                <td>${description}</td>
                <td>${count}</td>
                <td><a href="delete/${id}">delete</a></td>
            </tr>
        </table>

    </div>
    <div class="hFooter"></div>
</div>
<div class="footer">
    <h1><spring:message code="label.title"/></h1>
</div>

</body>
</html>