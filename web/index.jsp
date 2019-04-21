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
	<!--gallery-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-grids">
				<div class="col-md-8 gallery-grid glry-one">
					<a href="products.jsp"><img src="images/g1.jpg" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>巧克力黑松露蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4 gallery-grid glry-two">
					<a href="products.jsp"><img src="images/g2.jpg" class="img-responsive" alt=""/>
						<div class="gallery-info galrr-info-two">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>鲜花千层蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g3.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>Kitty猫蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g4.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>巧克力千层蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g5.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>碎花千层蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g6.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>卡尼熊蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g7.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>巧克力慕斯蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g8.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>巧克力玫瑰蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g9.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>彩虹千层蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-3 gallery-grid ">
					<a href="products.jsp"><img src="images/g10.png" class="img-responsive" alt=""/>
						<div class="gallery-info">
							<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> 看过</p>
							<a class="shop" href="single.jsp">详情</a>
							<div class="clearfix"> </div>
						</div>
					</a>
					<div class="galy-info">
						<p>甜腻腻蛋糕</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
								<span>☆</span>
							</div>						
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
	<!--//gallery-->
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