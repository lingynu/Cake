<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: An
  Date: 2019/3/28
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/productComment.css" type="text/css" rel="stylesheet">
<script src="js/productComment.js" type="text/javascript"></script>
<C:if test="${empty requestScope.allComments}">
    <C:redirect url="/CommentServlet?method=listCommentByPage&cakeId=1&page=1&count=10"></C:redirect>
    <% System.out.println("进入if"); %>
</C:if>
<div class="main">
    <div class="top">
        <h3>商品评论</h3>
    </div>
    <div class="con">
        <ul class="ul">
            <C:forEach var="n" items="${requestScope.allComments}" varStatus="s">
                <li class="li">
                    <div class="lileft">
                        <img src="images/2.png">用户名:${n.nickname}
                    </div>
                    <div class="liright">
                        <div class="lirighttop">
                            <input type="hidden" value="${n.score}" id="score"/>
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
                            ${n.content}
                        </div>
                        <div class="lirightbotton">
                            <input type="hidden" value="${n.commentId}" id="commentId"/>
                            <a class="btn btn-default btn-lg" id="like">
                                <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span><div id="likeNum">${n.like}</div>
                            </a>
                            <a class="reviews" href="/CommentServlet?method=listCommentReply&userId=1&cakeId=1&commentId=${n.commentId}">
                                <img src="images/message.png">
                            </a>
                        </div>
                    </div>
                </li>
            </C:forEach>
        </ul>
    </div>
    <div class="page">
        <span>当前第${requestScope.pageBean.nowPage}页/总共${requestScope.pageBean.allPages}页</span>
        <a class="btn btn-sm btn-default" href="/CommentServlet?method=listCommentByPage&cakeId=1&page=1&count=10">首页</a>
        <a class="btn btn-sm btn-default" href="/CommentServlet?method=listCommentByPage&cakeId=1&page=${requestScope.pageBean.previousPage}&count=10">上一页</a>
        <a class="btn btn-sm btn-default" href="/CommentServlet?method=listCommentByPage&cakeId=1&page=${requestScope.pageBean.nextPage}&count=10">下一页</a>
        <a class="btn btn-sm btn-default" href="/CommentServlet?method=listCommentByPage&cakeId=1&page=${requestScope.pageBean.lastPage}&count=10">尾页</a>
    </div>
</div>
