<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/17
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <%--<script>
        $(document).ready(function(){
            $("img[src='CodeServlet']").click(function (){
                $(this).attr("src","CodeServlet?erwr="+Math.random());
            });
            $("#username").blur(function(){
                var username=$(this).val();
                var xhr=new XMLHttpRequest();
                xhr.onreadystatechange=function(){
                    if (xhr.readyState==4&&xhr.status==200) {
                        var result=xhr.responseText;
                        if(result=='false'){
                            alert("用户名或者密码不存在");
                        }
                    }
                };
                xhr.open("get","/UserServlet?method=checkUserExist&username="+username);
                xhr.send(null);
            });
            $("#code").blur(function (){
                $.ajax({url="/UserServlet?method=checkCode&code="+code,type:"get",sucess:function (data){
                        if (data=='false'){
                            alert("验证码输入错误")；
                        }
                    }})
            })
        })
    </script>--%>
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand"><a  href="index.jsp">撑了吗</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp" class="active">首页</a></li>
                    <li class="dropdown">
                        <a href="products.jsp" class="dropdown-toggle">买买买</a>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">我的订单</a>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">新品促销</a>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">关于我们</a>
                    </li>
                </ul>
        ..
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                <div class="search">
                    <div>
                        <form class="navbar-form" action="CakeServlet?method=listMoHuZhiCake" method="post">
                            <input type="text" class="form-control" name="mohuzhi" id="mohuzhi">
                            <input type="submit" class="btn btn-default" id="bu" aria-label="Center Align" value="搜索">
                        </form>
                    </div>
                    <div id="popDiv">
                        <ul id="c">
                            <li></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="header-right login">
                <a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                <div id="loginBox">
                    <form id="loginForm">
                        <fieldset id="body">
                            <fieldset>
                                <label for="email">邮箱地址</label>
                                <input type="text" name="email" id="email">
                            </fieldset>
                            <fieldset>
                                <label for="password">密码</label>
                                <input type="password" name="password" id="password">
                            </fieldset>
                            <input type="submit" id="login" value="注册">
                            <label for="checkbox"><input type="checkbox" id="checkbox"> <i>记住我</i></label>
                        </fieldset>
                        <p>新用户 ? <a class="sign" href="account.jsp">注册吧</a> <span><a href="#">密码忘记了呢 ?</a></span></p>
                    </form>
                </div>
            </div>
            <div class="header-right cart">
                <a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
                <div class="cart-box">
                    <h4><a href="checkout.jsp">
                        <span class="simpleCart_total">0.00</span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>)
                    </a></h4>
                    <p><a href="javascript:;" class="simpleCart_empty">空的呢</a></p>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
