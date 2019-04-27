<%--
  Created by IntelliJ IDEA.
  User: An
  Date: 2019/4/20
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<link href="css/commentDetails.css" type="text/css" rel="stylesheet">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/commentDetails.js" type="text/javascript"></script>
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
                <img src="images/2.png">用户名:${requestScope.comment.nickname}
            </div>
            <div class="detail-content">
                <div class="detail-comment">
                    <input type="hidden" value="${requestScope.comment.score}" id="score"/>
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
                    <div class="detail">
                        这里是评论信息的详细描述
                        ${requestScope.comment.content}
                    </div>
                </div>
                <div class="reply">
                    <form class="form-horizontal" action="CommentServlet?method=submitCommentReply&userId=1&cakeId=1&commentId=${requestScope.comment.commentId}" method="post">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <textarea class="form-control" id="replyComment" name="replyContent" rows="3" placeholder="回复 用户名"></textarea>
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
                        <C:forEach var="c" items="${requestScope.allCommentReply}" varStatus="s">
                            <li class="li">
                                <div class="lidiv">
                                    ${c.replyNickName}:&nbsp;&nbsp;${c.content}
                                </div>
                            </li>
                        </C:forEach>
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
