<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/4/20
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册界面</title>
    <meta name="keywords" content="盒老师">
    <meta name="content" content="盒老师">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="css/login.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <%--<script type="text/javascript" src="js/jquery-3.3.1.js"></script>--%>
    <script type="text/javascript" src="js/formtest.js"></script>
    <%--<script type="text/javascript" src="js/jquery.min.js"></script>--%>

</head>
<body class="login_bj" >

<div class="zhuce_body">
    <%--<div class="logo"><a href="#"><img src="images/logo.png" width="114" height="54" border="0"></a></div>--%>
    <div class="zhuce_kong">
        <div class="zc">
            <div class="bj_bai">
                <% request.setCharacterEncoding("utf-8"); %>
                <b style="color: red;">${requestScope.errorMessage}</b>
                <div class="title"><h3>欢迎注册</h3></div>
                <div>
                <form id="regiForm" action="${pageContext.request.contextPath}/UserServlet?method=register" method="post" enctype="multipart/form-data">
                    <table id="biaoge">
                     <tr>
                         <td><input  name="name" type="text" class="kuang_txt name " placeholder="姓名"></td>
                     </tr>
                     <tr>
                         <td class="high"><span class="tip"><p style="font-size: 5%;">姓名非空，长度2位以上，包含任何字符！</p></span></td>
                     </tr>
                     <tr>
                         <td><input name="nickname" type="text" class="kuang_txt nickname " placeholder="用户名"></td>
                     </tr>
                        <tr>
                            <td class="high"><span class="tip"><p style="font-size: 5%;">用户名非空，长度2位以上，不包含特殊字符！</p></span></td>
                        </tr>
                     <tr>
                         <td><input name="phone" type="text" class="kuang_txt phone " placeholder="手机号"></td>
                     </tr>
                        <tr>
                            <td class="high"><span class="tip"><p style="font-size: 5%;">请输入正确的手机号！</p></span></td>
                        </tr>


                     <tr>
                         <td>
                             <select class="kuang_txt age" name="age">
                                 <%
                                     for(int n=0;n<=100;n++){

                                 %>
                                 <option value="<%=n%>"><%=n%>岁</option>
                                 <%
                                     }
                                 %>

                             </select>

                         </td>
                     </tr>

                     <tr>
                         <td><input name="password" type="password" class="kuang_txt password" placeholder="密码"></td>
                     </tr>
                        <tr>
                            <td class="high"><span class="tip"><p style="font-size: 5%;">密码不为空！</p></span></td>
                        </tr>
                        <tr>
                            <td><input name="password" type="password" class="kuang_txt passwordcheck" placeholder="确认密码"></td>
                        </tr>
                        <tr>
                            <td class="high"><span class="tip"><p style="font-size: 5%;">请保证密码一致！</p></span></td>
                        </tr>
                        <tr>
                            <td>
                                <input name="sex" type="text" class="kuang_txt sex " placeholder="性别">
                               <%-- <br>
                                <select class="kuang_txt ">
                                    <option ><p style="font-size: 2%;">请选择年龄！</p></option>
                                    <option name="sex" value = "0">男</option>
                                    <option name="sex" value = "1">女</option>
                                </select>--%>
                              </td>
                        </tr>
                       <%-- <tr><td>头像:<input type="file" name="head" style="display: inline"></td></tr>--%>
                        <tr>
                            <td class="high"><br><br><br><br><br><br><br><span class="tip"><p style="font-size: 5%;">请选择要上传的头像！</p></span></td>
                        </tr>
                        <tr>
                            <td>
                                <a href="javascript:;" class="a-upload">
                                <input class="kuang_txt " type="file" name="head" id="">点击这里上传文件
                            </a>
                            </td>
                        </tr>
                    </table>



                    <div class="btn_xieyi">
                        <input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                    </div>
                    <input name="注册" type="submit" class="btn_zhuce" value="注册">

                </form>
                </div>
            </div>
            <div class="bj_right">
                <p>使用以下账号直接登录</p>
                <a href="#" class="zhuce_qq">QQ注册</a>
                <a href="#" class="zhuce_wb">微博注册</a>
                <a href="#" class="zhuce_wx">微信注册</a>
                <p>已有账号？<a href="login.jsp">立即登录</a></p>

            </div>
        </div>

    </div>

</div>



</body>
</html>
