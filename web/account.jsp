<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
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
<!-- cart -->
</head>
<body>
	<!--header-->
		<%@include file="top.jsp"%>
	<!--//header-->
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
				<form> 
					<div class="register-top-grid">
						<h3>个人信息</h3>
						<div class="input">
							<span>姓名<label>*</label></span>
							<input type="text"> 
						</div>
						<div class="input">
							<span>性别<label>*</label></span>
							<input type="text"> 
						</div>
						<div class="input">
							<span>邮箱地址<label>*</label></span>
							<input type="text"> 
						</div>
						<a class="news-letter" href="#">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>保存信息</label>
						</a>
						<div class="clearfix"> </div>
					</div>
				    <div class="register-bottom-grid">
						<h3>登录</h3>
						<div class="input">
							<span>密码<label>*</label></span>
							<input type="password">
						</div>
						<div class="input">
							<span>确认密码<label>*</label></span>
							<input type="password">
						 </div>
					</div>
				</form>
				<div class="clearfix"> </div>
				<div class="register-but">
				   <form>
					   <input type="submit" value="提交">
					   <div class="clearfix"> </div>
				   </form>
				</div>
			</div>
	    </div>
	</div>
	<!--//account-->
	<!--footer-->
		<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>