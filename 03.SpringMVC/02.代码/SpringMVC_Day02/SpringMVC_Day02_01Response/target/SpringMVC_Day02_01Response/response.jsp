<%--
  Created by IntelliJ IDEA.
  User: HeZhu
  Date: 2020/12/26
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response</title>
    <%-- 引入jquery --%>
    <script src="js/jquery.min.js"></script>

    <script>
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //发送ajax请求
                $.ajax({
                    //url：请求服务器端那个路径
                    url:"user/testAjax",
                    //编码
                    contentType:"application/json;charset=UTF-8",
                    //json数据，传到服务器
                    data:'{"username":"HeZhu", "password":"123", "age":"30"}',
                    dataType:"json",
                    type:"post",
                    //success请求成功后的回调函数
                    success:function (data) {
                        //data是服务器端响应的json数据
                        alert(data);
                        alert(data.username);
                        alert(data.password);

                    }
                })
            });
        });
    </script>

</head>
<body>
<a href="user/testString">testString</a>
<br>

<a href="user/testVoid">testVoid</a>
<br>

<a href="user/testModelAndView">testModelAndView</a>
<br>

<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
<br>

<button id="btn">发送ajax请求</button>

</body>
</html>
