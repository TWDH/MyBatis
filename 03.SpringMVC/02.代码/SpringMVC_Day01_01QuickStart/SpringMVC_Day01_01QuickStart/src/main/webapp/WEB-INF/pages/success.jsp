<%--
  Created by IntelliJ IDEA.
  User: HeZhu
  Date: 2020/12/15
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <h3>入门成功</h3>

    <%-- EL表达式，request域的map集合 --%>
    <%-- 所有request的集合 --%>
    ${requestScope.msg}

    ${sessionScope}
</head>
<body>

</body>
</html>
