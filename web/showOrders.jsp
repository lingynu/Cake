<%--
  Created by IntelliJ IDEA.
  User: sword
  Date: 2019/4/25
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Custom Theme files -->
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="css/style.css" type="text/css" rel="stylesheet" media="all">
    <!-- js -->
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <!-- //js -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"> </script>
    <%--<script src="js/index.js"> </script>--%>
    <!-- cart -->
</head>
<body>
<%@include file="top.jsp"%>
<C:forEach var="o" items="${requestScope.orders}" varStatus="s">
    <p>订单编号：${o.orderId}</p>
    <p>创建时间：${o.creationTime}</p>

    <p>总价：${o.allPrice}</p>
    <p>订单状态：${o.status}</p>
    <p>姓名：${o.address.name}</p>
    <p>电话：${o.address.phone}</p>
    <p>地址：${o.address.place}</p>
    <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrderDetails&orderId=${o.orderId}">订单详情</a>
    <br><br><br>
</C:forEach>
</body>
</html>
