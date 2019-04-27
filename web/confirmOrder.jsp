<%--
  Created by IntelliJ IDEA.
  User: sword
  Date: 2019/4/22
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<C:if test="${empty requestScope.manyAddress}">
    <C:redirect url="/AddressServlet?method=show&userId=10000"></C:redirect>
</C:if>
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
    <link href="css/confOrder.css" type="text/css" rel="stylesheet">
    <script src="js/confirmOrder.js"></script>
</head>
<body>
<%@include file="top.jsp"%>
<div class="main">
    <div class="address_top fu_div">
        <div><h3>选择收货地址</h3></div>

        <ul>
            <C:forEach var="a" items="${requestScope.manyAddress}" varStatus="s">
                <li class="addLi">
                    <input type="radio" name="address" id="${a.addressId}">
                    <span>
                        <span>${a.place}</span>
                        <span>(${a.name} 收)</span>
                        <span>${a.phone}</span>
                    </span>
                    <a href="修改地址servlet?addressId=*">修改</a>
                </li>
            </C:forEach>
        </ul>


    </div>
    <div class="fu_div">
        <div><h3>确认订单信息</h3></div>
        <div>
            <div class="child_div">商品名称</div>
            <div class="child_div">商品属性</div>
            <div class="child_div">单价</div>
            <div class="child_div">数量</div>
            <div class="child_div">小计</div>
        </div>
    </div>
    <div class="fu_div">
        <div class="child_div">
            <div>图片</div>
            <div>商品名</div>
        </div>
        <div class="child_div">
            <p>口味</p>
            <p>尺寸</p>
        </div>
        <div class="child_div">
            单价
        </div>
        <div class="child_div">
            <span>数量</span>
        </div>
        <div class="child_div">
            <span>单商品价</span>
        </div>
    </div>
    <div class="fu_div">
        <div class="child_right_div">
            <span>合计</span>
            <span>100.0</span>
        </div>
    </div>
    <div class="fu_div">
        <div class="child_right_div">
            <div>
                <span>实付款：</span>
                <span>100.0</span>
            </div>
            <div>
                <span>寄送至:</span>
                <span>地址</span>
            </div>
            <div>
                <span>收货人：</span>
                <span>姓名 电话</span>
            </div>
        </div>
    </div>
    <div class="fu_div">
        <div class="child_right_div">
            <a href="gouwuche">返回购物车</a>
            <a id="toSubmit" href="javascript:void(0)" onclick="goSubmit()">提交订单</a>
        </div>
    </div>
</div>

<form id="orderForm"  action="OrderServlet?method=addOrder" method="post">
    <%--OrderServlet?method=addOrder--%>
    <input name="userId" value="10000">
    <input name="addressId" value="1">
    <input name="allPrice" value="251.5">
    <input name="cakeIds" value="14,15">
    <input name="cakeNumber" value="2,3">
</form>

</body>
</html>
