<%--
  Created by IntelliJ IDEA.
  User: sword
  Date: 2019/4/24
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>付款</title>
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
    <%--<link href="css/confOrder.css" type="text/css" rel="stylesheet">--%>
    <script src="js/payment.js"></script>
</head>
<body>
<%@include file="top.jsp"%>
<div id="orderDiv">
    <p id="idP">${toBePaidOrder.orderId}</p>
    <p>${toBePaidOrder.creationTime}</p>
    <p>${toBePaidOrder.allPrice}</p>
    <p id="statusP">未付款</p>
    <input type="button" id="confirmPay" onclick="goPay()" value="确认付款"><br>
    <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrderDetails&orderId=${toBePaidOrder.orderId}">查看订单详情</a>
    <a href="index.jsp">返回首页</a>
</div>
</body>
</html>
