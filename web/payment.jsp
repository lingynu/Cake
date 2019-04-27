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
    <link href="css/payment.css" type="text/css" rel="stylesheet">
    <script src="js/payment.js"></script>
</head>
<body>
<%@include file="top.jsp"%>
<div id="main_Div">
    <div id="img_Div">
        <img id="cashImg" src="images/orderImgs/shouyin.jpg">
    </div>

    <div>
        <div id="order_top_Div">
            <p id="tipText">订单提交成功，请尽快支付！</p><br>
            <p class="orderText">订单编号：<span id="idSpan">${toBePaidOrder.orderId}</span></p><br>
            <p class="orderText">创建时间：${toBePaidOrder.creationTime}</p><br>
        </div>
        <div id="line_Div"></div>
        <div id="order_buttom_Div">

            <p >总价：<span class="priceSpan">${toBePaidOrder.allPrice}</span></p><br>
            <p id="statusP">未付款</p><br>
        </div>
        <div id="control_Div">
            <input type="button" id="confirmPay" onclick="goPay()" value="确认付款"><br><br>
            <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrderDetails&orderId=${toBePaidOrder.orderId}">查看订单详情</a>
            <a href="index.jsp">返回首页</a>
        </div>


    </div>


</div>
</body>
</html>
