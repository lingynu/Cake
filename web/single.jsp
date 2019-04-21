<%@ page import="edu.hbuas.cake.model.javabean.Cake" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>single</title>
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
<script src="js/imagezoom.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- FlexSlider -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
	  $('.flexslider').flexslider({
		animation: "slide",
		controlNav: "thumbnails"
	  });
	});
</script>
<!--//FlexSlider -->
</head>
<body>
	<!--header-->
		<%@include file="top.jsp"%>
	<!--//header-->
	<!--//single-page-->
	<div class="single">
		<div class="container">
			<div class="single-grids">
				<div class="col-md-4 single-grid">

							<li data-thumb="<%=((Cake)request.getAttribute("cake")).getImageUrl()%>">
								<div class="thumb-image"> <img src="<%=((Cake)request.getAttribute("cake")).getImageUrl()%>" data-imagezoom="true" class="img-responsive"> </div>
							</li>

				</div>
				<div class="col-md-4 single-grid simpleCart_shelfItem">		
					<h3><%=((Cake)request.getAttribute("cake")).getCakeName()%></h3>
					<p><%=((Cake)request.getAttribute("cake")).getDescribe()%></p>
					<ul class="size">
						<h3>尺寸</h3>
							<li><a href="#"><%=((Cake)request.getAttribute("cake")).getType().getSize()%></a></li>
					</ul>
					<ul class="size">
						<h3>口味</h3>
							<li><a href="#"><%=((Cake)request.getAttribute("cake")).getType().getFlavor()%></a></li>
					</ul>
					<ul class="size">
						<h3>库存</h3>
						<li><a href="#"><%=((Cake)request.getAttribute("cake")).getStock()%></a></li>
					</ul>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price"><%=((Cake)request.getAttribute("cake")).getPrice()%></h5>
						</div>
						<ul class="size">
							<h3>折扣</h3>
							<li><a href="#"><%=((Cake)request.getAttribute("cake")).getSales()%></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<p class="qty"> 数量 :  </p><input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
					<div class="btn_form">
						<a href="#" class="add-cart item_add">加购</a>
					</div>
				</div>
				<div class="col-md-4 single-grid1">
					<h2>用户</h2>
					<ul>
						<li><a href="products.jsp">新品发布</a></li>
						<li><a href="account.jsp">注册</a></li>
						<li><a href="account.jsp">忘记密码</a></li>
						<li><a href="account.jsp">我的账户</a></li>
						<li><a href="contact.jsp">地址管理</a></li>
						<li><a href="checkout.html.html">购物车清单</a></li>
						<li><a href="checkout.html.html">历史记录</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- collapse -->
	<div class="collpse tabs">
		<div class="container">
			<div class="panel-group collpse" id="accordion" role="tablist" aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							  我们的蛋糕制作
							</a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
                            我想打造一个小小的蛋糕店，里面满是浓浓的烘焙香。我要把蛋糕店刷成像奶油一样甜蜜的白色，墙上会挂上一栏栏花草，窗前放一张长长的木椅。木门上会挂一方小黑板，如果路过的你突然想起一种蛋糕的样子，可以写上，也可以画上，不管你会不会再来，我都会做好放在玻璃橱窗中。希望你再次路过的时候，看见专为你做的蛋糕
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                我们的制作团队
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
                            我们的蛋糕店有着世界上最好的设计制作团队，有国际顶尖蛋糕造型大师马飞，他曾经获得全国蛋糕设计大赛金奖，有着最得力的蛋糕装饰与搭配大师赵让学，裴加强，张玉磊，还有美食专家王雪婷与赵梦玲，她们具有独特的味蕾能分辨蛋糕的口感与品质。我为有她们而深感骄傲
                        </div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingThree">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                蛋糕的历史
							</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
						<div class="panel-body">
                            历史起源蛋糕最早起源于西方，后来才慢慢的传入中国。最早的蛋糕是用几样简单的材料做出来的，这些蛋糕是古老宗教神话与奇迹式迷信的象征。早期的经贸路线使异国香料由远东向北输入，坚果、花露水、柑橘类水果、枣子与无花果从中东引进，甘蔗则从东方国家与南方国家进口。在欧洲黑暗时代，这些珍奇的原料只有僧侣与贵族才能拥有，而他们的糕点创作则是蜂蜜姜饼以及扁平硬饼干之类的东西。
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingFour">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
								您的建议我们诚心接纳
							</a>
						</h4>
					</div>
					<div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
						<div class="panel-body">
							我知道即使再完美的团队都会有不足的地方，我们诚心邀请您给我们广提建议，我们很是荣幸，很是感激，小主我们的联系方式是8888888888，我们在湖北文理学院，等风也等你
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--//collapse -->
	<!--related-products-->
	<div class="related-products">
		<div class="container">
			<h3>相关</h3>
			<div class="product-model-sec single-product-grids">
				<div class="product-grid single-product">
					<a href="single.jsp">
					<div class="more-product"><span> </span></div>						
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/m1.png" class="img-responsive" alt="">
						<div class="b-wrapper">
						<h4 class="b-animate b-from-left  b-delay03">							
						<button>详情</button>
						</h4>
						</div>
					</div>
					</a>					
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>粉色千层鲜花蛋糕</h4>
							<span class="item_price">200</span>
							<div class="ofr">
							  <p class="pric1"><del>300</del></p>
							  <p class="disc">[36% 折扣]</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				<div class="product-grid single-product">
					<a href="single.jsp">
					<div class="more-product"><span> </span></div>						
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/m2.png" class="img-responsive" alt="">
						<div class="b-wrapper">
						<h4 class="b-animate b-from-left  b-delay03">							
						<button>详情</button>
						</h4>
						</div>
					</div>
					</a>					
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>巧克力鲜花蛋糕</h4>
							<span class="item_price">300</span>
							<div class="ofr">
							  <p class="pric1"><del>400</del></p>
							  <p class="disc">[45% 折扣]</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				<div class="product-grid single-product">
					<a href="single.jsp">
					<div class="more-product"><span> </span></div>						
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/m3.png" class="img-responsive" alt="">
						<div class="b-wrapper">
						<h4 class="b-animate b-from-left  b-delay03">							
						<button>详情</button>
						</h4>
						</div>
					</div>
					</a>					
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>彩虹绿油蛋糕</h4>
							<span class="item_price">220</span>
							<div class="ofr">
							  <p class="pric1"><del>280</del></p>
							  <p class="disc">[15% 折扣]</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				<div class="product-grid single-product">
					<a href="single.jsp">
					<div class="more-product"><span> </span></div>						
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/m4.png" class="img-responsive" alt="">
						<div class="b-wrapper">
						<h4 class="b-animate b-from-left  b-delay03">							
						<button>详情</button>
						</h4>
						</div>
					</div>
					</a>					
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>甜腻腻蛋糕</h4>
							<span class="item_price">200</span>
							<div class="ofr">
							  <p class="pric1"><del>230</del></p>
							  <p class="disc">[15% 折扣]</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--related-products-->
	<!--footer-->
		<%@include file="footer.jsp"%>
	<!--//footer-->
</html>