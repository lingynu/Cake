
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/17
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">买买买<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-4">

                        </ul>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">我的订单<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-4">

                        </ul>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">新品促销<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-4">

                        </ul>
                    </li>
                    <li class="dropdown grid">
                        <a href="#" class="dropdown-toggle list1" data-toggle="dropdown">关于我们<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">

                        </ul>
                    </li>
                </ul>
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div>
            <C:choose>
                <C:when test="${empty sessionScope.user}">
                    <div class="header-right login">
                        <a href="login.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                    </div>
                </C:when>
                <C:otherwise>



                    <div class="huaiying"><span class="ziti">欢迎你:</span><span style="text-shadow: 0px 0px 5px darkolivegreen;color: white"><a style="color: white" href="profile.jsp" class="ziti">${sessionScope.user.nickname}</a></span>
                        <%--<img style="width: 20px;height: 20px;border-radius: 50%;border: 1px solid gray;" src='${sessionScope.user.head}' />--%>
                    </div>
                     <div style="width: 60px;height: 60px;position: absolute;right: 280px;top: 22px;"><img  src='${sessionScope.user.head}' class="round_icon"  alt=""></div>
                    <div  style="width:80px;height:30px;position: absolute;right: 100px;top: 25px;"><a   style="color:white;font-size: 15px;" href="UserServlet?method=logoff" >安全退出</a></div>
                </C:otherwise>
            </C:choose>
        </div>


        <div class="header-info">
            <div class="header-right search-box">
                <a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                <div class="search">
                    <form class="navbar-form">
                        <input type="text" class="form-control">
                        <button type="submit" class="btn btn-default" aria-label="Left Align">
                            搜一搜
                        </button>
                    </form>
                </div>
            </div>

           <%-- <div>
            <C:choose>
                <C:when test="${empty sessionScope.user}">
                    <div class="header-right login">
                        <a href="login.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
                    </div>
                </C:when>
                <C:otherwise>



                    &lt;%&ndash;<li>欢迎你:<span style="text-shadow: 0px 0px 5px darkolivegreen;color: white"><a href="profile.jsp">${sessionScope.user.nickname}</a></span><img style="width: 20px;height: 20px;border-radius: 50%;border: 1px solid gray;" src='${sessionScope.user.head}' /></li><li><a style="color:green;font-size: 12px;" href="UserServlet?method=logoff" >安全退出</a></li>&ndash;%&gt;
                </C:otherwise>
            </C:choose>
            </div>--%>



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