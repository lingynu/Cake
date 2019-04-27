<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
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
	<!--banner-->
	<div class="banner">
		<div class="container">
			<h2 class="hdng">今天你<span>撑</span>了吗</h2>
			<p>我们不生产蛋糕</p>
            <p>我们只是蛋糕的搬运工</p>
			<a href="products.jsp">不够撑 看这里</a>
			<div class="banner-text">			
				<img src="images/2.png" alt=""/>	
			</div>
		</div>
	</div>			
	<!--//banner-->
	<!--subscribe-->
	<div class="subscribe">
		 <div class="container">
			 <h3>新闻动态</h3>
			 <form>
				 <input type="text" class="text" value="邮箱" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Email';}">
				 <input type="submit" value="搜索栏">
			 </form>
		 </div>
	</div>
	<!--//subscribe-->
	<!--footer-->
		<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>