<%--
  Created by IntelliJ IDEA.
  User: sword
  Date: 2019/4/25
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
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
<C:forEach var="d" items="${requestScope.orderDetails}" varStatus="s">
    <p>订单编号：${d.orderId}</p>
    <p>蛋糕名称：${d.cake.cakeName}</p>
    <img src="${d.cake.imageUrl}">
    <p>蛋糕单价：${d.cake.price}</p>
    <p>蛋糕数量：${d.number}</p>
    <p>评论状态：${d.commentStatus}</p>
    <C:if test="${d.commentStatus eq '未评论'}">
        <a href="添加评论页">去评论</a>
    </C:if>
    <C:if test="${d.commentStatus eq '已评论'}">
        <a href="评论页">查看评论</a>
    </C:if>
    <br><br><br>
</C:forEach>
<a href="showOrders.jsp">查看全部订单</a>        //${sessionScope.user.userId}

<!--footer-->
<%@include file="footer.jsp"%>
<!--//footer-->
</body>
</html>
