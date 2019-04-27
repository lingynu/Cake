<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Contact</title>
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
	<!--contact-->
	<div class="contact">
		<div class="container">
			<h2>联系</h2>
			<div class="map">	
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d205251.8961757029!2d-82.55659211602483!3d36.50439253757311!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x885a856b70074b97%3A0x6f9cc0d30bcc841f!2sKingsport%2C+TN%2C+USA!5e0!3m2!1sen!2sin!4v1433743549812"></iframe>
			</div>
			<div class="contact-infom">
				<h4>全部的信息:</h4>
				<p>
                    小主对我们有什么想法嘛
                    或者也忍不住想加入我们了吧
                    哈哈哈哈哈哈哈哈哈哈很开心你能联系我们
                </p>
			</div>
			<div class="address">
				<div class="col-md-4 address-grids">
					<h4>地址 :</h4>
					<ul>
						<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<p>	湖北文理学院<br>
							校长办公室<br>
							准备好自信心哈
						</p>
					</ul>
				</div>
				<div class="col-md-4 address-grids">
					<h4>电话:</h4>
					<p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>+2 800 544 6035</p>
					<p><span class="glyphicon glyphicon-print" aria-hidden="true"></span>+2 100 889 9466</p>
				</div>
				<div class="col-md-4 address-grids">
					<h4>邮箱 :</h4>
					<p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span><a href="mailto:example@mail.com">mail@example.com</a></p>
				</div>
				<div class="clearfix"> </div>
			</div>		
			<div class="contact-form">
				<h4>填写表格</h4>
				<form>
					<input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
					<input type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="text" value="Telephone" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Telephone';}" required="">
					<textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
					<button class="btn1">提交</button>
				</form>
			</div>	
		</div>
	</div>
	<!--//contact-->
	<!--footer-->
		<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>