
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        html, body, h1, form, fieldset, legend, ol ,li{
            padding:0;
            margin:0;
        }
        ol{
            list-style:none;
        }
        body{
            background:#fff;
            color:#111;
            padding:20px;
        }
        form#payment{
            background:#9cbc2c;
            -webkit-border-radius:5px;
            border-radius:5px;
            padding:20px;
            width:400px;
        }
        form#payment fieldset{
            border:none;
            margin-bottom:10px;
        }
        form#payment fieldset:last-of-type{ margin-bottom:0; }
        form#payment legend{
            color:#384313;
            font-size:16px;
            font-weight:bold;
            padding-bottom:10px;
            text-shadow:0px 1px 1px #c0d576;
        }

        form#payment fieldset fieldset legend{
            color:#111;
            font-size:13px;
            font-weight:normal;
            padding-bottom:0;
        }
        form#payment ol li{
            background:#b9cf6a;
            background:rgba(255, 255, 255, 0.3);
            border:#e3ebc3;
            border-color:rgba(255, 255, 255, 0.6);
            border-style:solid;
            border-width:2px;
            -webkit-border-radius:5px;
            line-height:30px;
            padding:5px 10px;
            margin-bottom:2px;
        }
        form#payment ol ol li{
            bakcground:none;
            border:none;
            float:left;
        }
        form#payment label{
            float:left;
            font-size:13px;
            width:110px;
        }
        form#payment fieldset fieldset label{
            background:none no-repeat left 50%;
            line-height:20px;
            padding:0 0 0 30px;
            width:auto;
        }
        form#payment fieldset fieldset label:hover{cursor:pointer;}
        form#payment input:not([type=radio]), form#payment textarea{
            background:#fff;
            border:#fc3 solid 1px;
            -webkit-border-radius:3px;
            outline:none;
            padding:5px;
        }

        .juzhong{
            text-align: center;
            margin: 0 auto;
            position: absolute;
            left: 455px;
            top: 60px;
}
        .round_icon{
            width: 40px;
            height:40px;
            display:flex;
            border-radius:50%;
            align-items:center;
            justify-content:center;
            overflow:hidden;
        }
    </style>
</head>
<body>
<div class="juzhong" >
     <% request.setCharacterEncoding("utf-8"); %>
      <b style="color: red;">${requestScope.errorMessage}</b>
    <form id=payment action="${pageContext.request.contextPath}/UserServlet?method=revise" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>修改资料</legend>

            <img src='${sessionScope.user.head}' class="round_icon"  alt="">
            <ol>
                <li>
                    <label for="name">姓名：</label>
                    <input type="text" id="name" name="name" placeholder="请输入用户名" required autofocus value="${sessionScope.user.name}">
                </li>
                <li>
                    <label for="nickname">用户名：</label>
                    <input type="text" name="nickname" id="nickname" placeholder="example@163.com" required value="${sessionScope.user.nickname}">
                </li>
                <li>
                    <label for="password">密码：</label>
                    <input type="text" name="password" id="password" placeholder="example@163.com" required value="${sessionScope.user.password}">
                </li>
                <li>
                    <label for="phone">联系电话：</label>
                    <input type="tel" placeholder="010-12345678" id="phone" name="phone" value="${sessionScope.user.phone}">
                </li>
                 <li>
                    <label for="age">年龄：</label>
                    <input type="tel" placeholder="010-12345678" id="age" name="age" value="${sessionScope.user.age}">
                </li>
                <li>
                    <label for="sex">性别：</label>
                    <input type="tel" placeholder="010-12345678" id="sex" name="sex" value="${sessionScope.user.sex}">
                </li>
                <li>
                    <label for="head">修改头像：</label>
                    <a href="javascript:;" class="a-upload">
                        <input class="kuang_txt " type="file" name="head" id="head" value="${sessionScope.user.head}">
                    </a>
                </li>
            </ol>
        </fieldset>



        <fieldset>
            <input name="修改" type="submit" class="btn_zhuce" value="确认修改">
        </fieldset>
    </form>

</div>
</body>
</html>
