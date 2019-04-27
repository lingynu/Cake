<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/4/21
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <meta name="keywords" content="盒老师">
    <meta name="content" content="盒老师">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script>
        $(document).ready(function(){
            $("img[src='CodeServlet']").click(function(){
                $(this).attr("src","CodeServlet?sdfsf="+Math.random());
            });

            $("#verfy").blur(function(){

                var code=$(this).val();
                console.log(code)

                $.get("${pageContext.request.contextPath}/UserServlet?method=checkCode&code="+code,function(data){
                    if(data=='false'){
                        alert("验证码错误");
                    }
                });

            })

            //这事焦点失去后判断用户名是否存在的ajax代码

            $("#nickname").blur(function(){
                $.post("${pageContext.request.contextPath}/UserServlet",{"method":"checkUserExist","nickname":$(this).val()},function(aaa){
                    if(aaa=='false'){
                        alert('用户名不存在，请检查用户名是否是注册过的账户！');
                    }
                })
            });

        })


    </script>

</head>
<body class="login_bj" >
<div class="zhuce_body">

    <div class="zhuce_kong login_kuang">
        <div class="zc">
            <div class="bj_bai">
                <% request.setCharacterEncoding("utf-8"); %>
                <b style="color: red;">${requestScope.errorMessage}</b>

                <C:if test="${not empty  cookie.nickname.value}">
                    <C:redirect url="/UserServlet?method=login"></C:redirect>
                </C:if>
                <h3>登录</h3>
                <form action="UserServlet?method=login" method="post">


                    用户名：<input id="nickname" name="nickname" type="text" class="kuang_txt" ><br/>
                    密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="password" type="text" class="kuang_txt" ><br/>
                    验证码:<input id="verfy" type="text" name="inputCode" style="width: 60px"/> <img src="CodeServlet"/><br/>
                    <C:choose>
                        <C:when test="${empty cookie.nickname.value}">
                            <input type="checkbox" name="rememberMe" value="true" />一周免登陆
                        </C:when>
                        <C:otherwise>
                            <input type="checkbox" name="rememberMe" value="true"  checked="checked"/>一周免登陆
                        </C:otherwise>
                    </C:choose>
                    <div class="aaa"><a class="zhuce" href="register.jsp">注册</a></div>
                    <input name="登录" type="submit" class="btn_zhuce" value="登录">

                </form>
            </div>
            <div class="bj_right">
                <p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="#">立即登录</a></p>

            </div>
        </div>

    </div>

</div>

</body>
</html>
