<%--
  Created by IntelliJ IDEA.
  User: An
  Date: 2019/4/20
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<link href="css/commentDetails.css" type="text/css" rel="stylesheet">
<html>
<head>
    <title>评论详情</title>
</head>
<body>
    <div class="logo">
        <h1>Cake</h1>
    </div>
    <hr>
    <div class="content">
        <div class="contentleft">
            <div class="detail-user">
                <img src="images/2.png">用户名
            </div>
            <div class="detail-content">
                <div class="detail-comment">
                    这里是评论信息的详细描述
                </div>
                <div class="reply">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <textarea class="form-control" id="replyMessage" rows="3" placeholder="回复 用户名"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="detail-reply">
                    <ul class="ul">
                        <li class="li">
                            <div class="lidiv">
                                用户名：这是用户评论
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="contentright">
            这里是商品的信息
        </div>
    </div>
</body>
</html>
