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
    <title>Склад</title>
</head>
<body>

<div class="pageWrapper">
    <div class="header">
        <p>Добавить новый товар:</p>
        <hr/>
        <form:form method="post" action="addProduct" commandName="product">
            <table>
                <tr>
                    <td><form:label path="productName">Название товара:</form:label></td>
                    <td><form:label path="productDescription">Описание товаров</form:label></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td><form:input path="productName"/></td>
                    <td><form:input path="productDescription"/></td>
                    <td><input type="submit" value="Добавить"/></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div class="content">
        <p>Список товаров:</p>
        <hr/>
        <c:choose>
            <c:when test="${empty productList}">
                <p>Список пуст!</p>
            </c:when>
            <c:when test="${!empty productList}">
                <table border="1" class="viewData">
                    <tr class="titleRow">
                        <td>Идентификатор</td>
                        <td>Название товара</td>
                        <td>Описание товара</td>
                        <td>Количество</td>
                        <td>&nbsp;</td>
                    </tr>
                    <c:forEach items="${productList}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.productName}</td>
                            <td>${product.productDescription}</td>
                            <td>${product.store.count}</td>
                            <td><a href="delete/${product.id}">удалить</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
    <div class="hFooter"></div>
</div>
<div class="footer">
    <ul class="menu">
        <li><a href="/">Главная</a></li>
        <li><a href="/passing_document">Покупка/продажа товара</a></li>
    </ul>
</div>

</body>
</html>