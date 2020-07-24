<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aibatjetenov
  Date: 11/05/2020
  Time: 12:13
  To change this template use File | Settings | File Templates.
  view
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guest book</title>
</head>
<body>
<table border="1">
    <c:forEach items = "${requestScope.posts}" var = "post">
        <tr>
            <td>${post.id}</td>
            <td><c:out value="${post.txt}"/></td>
            <td>
                <a href="delete?id=${post.id}">
                    <img src="del.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/httpDemo_war_exploded/add" method="post">
        <tr>
            <td colspan="2">
                <input name="txt" type="text">
            </td>
            <td>
                <input type="submit">
            </td>
        </tr>
    </form>

</table>

</body>
</html>
