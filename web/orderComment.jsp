<%--
  Created by IntelliJ IDEA.
  User: An
  Date: 2019/4/20
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/orderComment.css" rel="stylesheet" type="text/css" />

<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/orderComment.js" type="text/javascript"></script>

<html>
<head>
    <title>评价晒单</title>
</head>
<body>
    <div class="logo">
        <h1>Cake</h1>
    </div>
    <hr>
    <div class="top"><h2>评价商品</h2></div>
    <div class="top-order">
        <div class="orderid">订单号：</div>
        <div class="ordertime">时间</div>
    </div>
    <div class="main">
        <form action="CommentServlet?method=orderComment" method="post">
            <div class="up">
                <div class="left">
                    <input id="cake" name="cake">商品信息
                </div>
                <div class="right">
                    <div class="commentScore">
                        <span style="font-size: 16px;">商品评分:</span>
                        <table>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                        <span><input type="text" readonly="readonly" id="score" name="score" value="0">分</span>
                    </div>
                    <div class="col-sm-10">
                        <span style="font-size: 16px;">商品评价:</span>
                        <textarea class="form-control" id="content" name="content" rows="6" placeholder="评价晒单"></textarea>
                    </div>
                </div>
            </div>
            <div class="down">
                <input type="submit" class="btn btn-danger btn-lg" value="提交">
                <input type="checkbox" class="btn btn-default" name="anonymous" value="anonymous">匿名评价
            </div>
        </form>
    </div>
</body>
</html>
