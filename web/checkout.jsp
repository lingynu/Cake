<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
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
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
			<h2>我的购物车</h2>
			<script>$(document).ready(function(c) {
				$('.close1').on('click', function(c){
					$('.cart-header').fadeOut('slow', function(c){
						$('.cart-header').remove();
					});
					});	  
				});
			</script>
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/m1.png" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> 粉色千层蛋糕 </a><span>商品详情:</span></h3>
						<ul class="qty">
							<li><p>商品价格:</p></li>
							<li><p>尺寸口味</p></li>
						</ul>
						<div class="delivery">
							<p>运费 : 10.00</p>
							<span>配送时间:30 hours</span>
							<div class="clearfix"></div>
						</div>	
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			 <script>$(document).ready(function(c) {
					$('.close2').on('click', function(c){
							$('.cart-header2').fadeOut('slow', function(c){
						$('.cart-header2').remove();
					});
					});	  
					});
			 </script>
			<div class="cart-header2">
				<div class="close2"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/m2.png" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> 巧克力鲜花蛋糕 </a><span>商品详情:</span></h3>
						<ul class="qty">
							<li><p>商品价格:</p></li>
							<li><p>尺寸口味</p></li>
						</ul>
						<div class="delivery">
                            <p>运费 : 10.00</p>
                            <span>配送时间:30 hours</span>
						<div class="clearfix"></div>
					</div>	
				   </div>
				   <div class="clearfix"></div>
				</div>
			</div>
				<script>$(document).ready(function(c) {
					$('.close3').on('click', function(c){
							$('.cart-header3').fadeOut('slow', function(c){
						$('.cart-header3').remove();
					});
					});	  
					});
				</script>
			<div class="cart-header3">
				<div class="close3"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/m3.png" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> 彩虹绿油蛋糕 </a><span>商品详情:</span></h3>
						<ul class="qty">
							<li><p>商品价格:</p></li>
							<li><p>尺寸口味</p></li>
						</ul>
						<div class="delivery">
                            <p>运费 : 10.00</p>
                            <span>配送时间:30 hours</span>
							<div class="clearfix"></div>
						</div>	
					</div>
					<div class="clearfix"></div>
				</div>
			</div>		
		</div>
	</div>
	<!--//checkout-->
	<!--footer-->
		<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>