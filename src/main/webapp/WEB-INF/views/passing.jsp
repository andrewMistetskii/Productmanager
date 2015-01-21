<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="font" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Покупка/продажа товара</title>
</head>
<body>

<div class="pageWrapper">
    <div class="headerProd">
        <p>Действия на складе:</p>
        <hr/>
        <form:form method="post" action="addDocument" commandName="document">
            <table class="event" border="1">
                <tr class="titleRow">
                    <td>Выбрать тип документа:</td>
                    <td>Выбрать товар:</td>
                    <td>Количество:</td>
                    <td>Описание:</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="chooseEvent">
                        <form:radiobutton path="operationType" value="buy" checked="checked"/>Покупка<br/>
                        <form:radiobutton path="operationType" value="sale"/>Продажа<br/>
                        <form:radiobutton path="operationType" value="writeOff"/>Списание<br/>
                    </td>
                    <td>
                        <form:select path="productId">
                            <form:option value="-1" label="--- Выбрать ---"/>
                            <c:if test="${!empty productList}">
                                <c:forEach items="${productList}" var="prod">
                                    <form:option value="${prod.id}" label="${prod.productName} <${prod.store.count}>"/>
                                </c:forEach>
                            </c:if>
                        </form:select>
                    </td>
                    <td>
                        <form:input path="amount"/>
                    </td>
                    <td>
                        <form:textarea path="description"/>
                    </td>
                    <td>
                        <input type="submit" value="Принять"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
    <div class="content">
        <p>Список документов:</p>
        <hr/>
        <c:choose>
            <c:when test="${empty documentList}">
                <p>Список пуст!</p>
            </c:when>
            <c:when test="${!empty documentList}">
                <table border="1" class="viewData">
                    <tr class="titleRow">
                        <td>№ Документа</td>
                        <td>Тип операцыи</td>
                        <td>Товар</td>
                        <td>Количество</td>
                        <td>Дата операцыи</td>
                        <td>Опесание</td>
                    </tr>
                    <c:forEach items="${documentList}" var="document">
                        <tr>
                            <td>${document.id}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${document.operationType == 'buy'}">
                                        Покупка
                                    </c:when>
                                    <c:when test="${document.operationType == 'sale'}">
                                        Продажа
                                    </c:when>
                                    <c:when test="${document.operationType == 'writeOff'}">
                                        Списание
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>
                                ${document.manyToOneProductId.productName}
                            </td>
                            <td>
                                ${document.amount}
                            </td>
                            <td>
                                ${document.createDate}
                            </td>
                            <td>
                                ${document.description}
                            </td>
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
        <li><a href="/products">Склад</a></li>
    </ul>
</div>

</body>
</html>
