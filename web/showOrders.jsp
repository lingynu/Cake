<%--
  Created by IntelliJ IDEA.
  User: sword
  Date: 2019/4/25
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<C:if test="${empty sessionScope.user}">--%>
    <%--<C:redirect url="index.jsp"></C:redirect>--%>
<%--</C:if>--%>
<C:if test="${empty requestScope.allOrders}">
    <C:redirect url="/OrderServlet?method=listOrders&userId=10000&page=1&count=7"></C:redirect>
</C:if>
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

    <link href="css/showOrders.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@include file="top.jsp"%>
<table id="orderTip_Table">
    <tr>
        <th class="name_T orderTipTh">商品</th>
        <th class="price_T orderTipTh">单价</th>
        <th class="number_T orderTipTh">数量</th>
        <th class="comSta_T orderTipTh">评论状态</th>
        <th class="allPri_T orderTipTh">总价</th>
        <th class="ordSta_T orderTipTh">订单状态</th>
        <th class="ordControl_T orderTipTh">订单操作</th>
    </tr>
</table>
<C:forEach var="o" items="${requestScope.allOrders}" varStatus="s">
    <div>
        <table id="order_Table">
            <tr id="orderTopTr " style="background-color:rgb(234,248,255)">
                <td id="orderIdTd">
                    订单编号：${o.key.orderId}
                </td>
                <td id="creatTimeTd" colspan="6">
                    创建时间：${o.key.creationTime}
                </td>
            </tr>

            <C:forEach var="d" items="${o.value}" varStatus="s">
                <tr>
                    <td class="name_T">
                        <img id="cakeImg" src="${d.cake.imageUrl}">
                            ${d.cake.cakeName}
                        
                    </td>
                    <td class="price_T">${d.cake.price}</td>
                    <td class="number_T">${d.number}</td>
                    <td class="comSta_T">${d.commentStatus}</td>
                    <td class="allPri_T order_after">${o.key.allPrice}</td>
                    <td class="ordSta_T order_after">
                        ${o.key.status}
                        <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrderDetails&orderId=${o.key.orderId}">订单详情</a>
                    </td>
                    <td class="ordControl_T order_after">
                        <C:if test="${o.key.status eq '未付款'}">
                            <a href="${pageContext.request.contextPath}/OrderServlet?method=payOrder&orderId=${o.key.orderId}">立即付款</a>
                        </C:if>
                        <C:if test="${d.commentStatus eq '未评论'}">
                            <a href="评论页">去评论</a>
                        </C:if>
                    </td>
                </tr>
            </C:forEach>

                <%--<p>姓名：${o.address.name}</p>--%>
                <%--<p>电话：${o.address.phone}</p>--%>
                <%--<p>地址：${o.address.place}</p>--%>

            <br><br><br>
        </table>
    </div>

</C:forEach>
<div class="page_Div">
    <br><br>
    <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrders&userId=10000&page=1&count=7">首页</a>
    <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrders&userId=10000&page=${requestScope.pageBean.previousPage}&count=${requestScope.pageBean.everyPageCount}">上一页</a>
    <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrders&userId=10000&page=${requestScope.pageBean.nextPage}&count=${requestScope.pageBean.everyPageCount}">下一页</a>
    <a href="${pageContext.request.contextPath}/OrderServlet?method=listOrders&userId=10000&page=${requestScope.pageBean.allPages}&count=${requestScope.pageBean.everyPageCount}">尾页</a>
    <span>当前第${requestScope.pageBean.nowPage}页/总共${requestScope.pageBean.allPages}页 ,每页${requestScope.pageBean.everyPageCount}条/总共${requestScope.pageBean.allCount}条</span>
    <br><br><br><br>

</div>
<!--footer-->
<%@include file="footer.jsp"%>
<!--//footer-->
</body>
</html>
