<%--
  Created by IntelliJ IDEA.
  User: HeZhu
  Date: 2020/12/28
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有账户信息</h3>
    ${list}
    <c:forEach items="${list}" var="account">
        ${account.name}
        ${account.money}
    </c:forEach>
</body>
</html>
