<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/14
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page buffer="16kb" %>
<C:if test="${empty requestScope.allCake}">
	<C:redirect url="/CakeServlet?method=listAllCake&page=1&count=9"></C:redirect>
</C:if>
<%--<C:if test="${empty requestScope.allFlavor}">--%>
	<%--console.log(${requestScope.allFlavor}+"123")--%>
    <%--<C:redirect url="/CakeServlet?method=listTypeCake"></C:redirect>--%>
<%--</C:if>--%>
<%--<C:if test="${empty requestScope.allSize}">--%>
    <%--<C:redirect url="/CakeServlet?method=listTypeCake&flavor=1&size=9"></C:redirect>--%>
<%--</C:if>--%>
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- the jScrollPane script -->
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- //the jScrollPane script -->
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
<!-- the mousewheel plugin -->
	<script type="text/javascript">
		$(document).ready(function (){
			$("#flavor1").click(function (){
				$.post("/CakeServlet",{"method":"listTypeCake","flavor":"香草"})
            })
        })
	</script>
</head>
<body>

	<!--header-->
		<%@include file="top.jsp"%>
	<!--//header-->
	<!--products-->
	<div class="products">
		<div class="container">
			<h2>我们的蛋糕</h2>
			<div class="col-md-9 product-model-sec">
				<C:forEach var="m" items="${requestScope.allCake}"   varStatus="s">
				<div class="product-grid">
					<a href="single.jsp">
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img style="height: 180px" src=${m.imageUrl} class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button><a href="CakeServlet?method=listCake&cakeId=${m.cakeId}" style="color: white">详情</a></button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${m.cakeName}</h4>
							<span class="item_price">${m.price}</span>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
				</C:forEach>
				<a href="/deliciousFood_war_exploded/CakeServlet?method=listAllCake&page=1&count=9">首页</a>
				<a href="/deliciousFood_war_exploded/CakeServlet?method=listAllCake&page=${requestScope.pageBean.previousPage}&count=9">上一页</a>
				<a href="/deliciousFood_war_exploded/CakeServlet?method=listAllCake&page=${requestScope.pageBean.nextPage}&count=9">下一页</a>
				<a href="/deliciousFood_war_exploded/CakeServlet?method=listAllCake&page=${requestScope.pageBean.allPage}&count=9">尾页</a>
				<span>当前第${requestScope.pageBean.nowPage}页/总共${requestScope.pageBean.allPage}页 ,每页${requestScope.pageBean.everyPageCount}条/总共${requestScope.pageBean.allCount}条</span>
			</div>	
			<div class="col-md-3 rsidebar span_1_of_left">
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>折扣</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
                            <C:forEach var="a" items="${sessionScope.allSales}"   varStatus="s">
                                <label class="checkbox"><a href="/deliciousFood_war_exploded/CakeServlet?method=listSalesCake&sales=${a.sales}">${a.sales}</a></label>
                            </C:forEach>
						</div>
					</div>
				</section>  				 
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>价格</h4>
					<ul class="dropdown-menu1">
						<li>
                            <form class="navbar-form" action="CakeServlet?method=listPriceCake" method="post">
                                <div id="slider-range"></div>
                                <input type="text" id="amount" name="amount" style="border: 0; font-weight: NORMAL; font-family: 'Dosis-Regular';" />
                                <input type="submit" class="btn btn-default" aria-label="Center Align" value="搜索" style="position: absolute;top: 320px;left: 105px">
                            </form>
						</li>
					</ul>
				</section>
				<!---->
				<script type="text/javascript" src="js/jquery-ui.min.js"></script>
				<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
					<script type='text/javascript'>//<![CDATA[ 
						$(window).load(function(){
						 $( "#slider-range" ).slider({
									range: true,
									min: 0,
									max: 1000,
									values: [ 0, 1000 ],
									slide: function( event, ui ) {
									    $( "#amount" ).val( ui.values[ 0 ] + "-" + ui.values[ 1 ] );
									}

						 });
						$( "#amount" ).val( $( "#slider-range" ).slider( "values", 0 ) + "-" + $( "#slider-range" ).slider( "values", 1 ) );

						});//]]> 
					</script>
				<!---->
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>风味</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4" id="flavorCheck">
                            <C:forEach var="n" items="${sessionScope.allFlavor}"   varStatus="s">
								<label class="checkbox"><a href="/deliciousFood_war_exploded/CakeServlet?method=listTypeCake&flavor=${n.flavor}">${n.flavor}</a></label>
                            </C:forEach>
						</div>
					</div>
				</section>
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>尺寸</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
                            <C:forEach var="p" items="${sessionScope.allSize}"   varStatus="s">
								<label class="checkbox"><a href="/deliciousFood_war_exploded/CakeServlet?method=listTypeCake&size=${p.size}">${p.size}</a></label>
                            </C:forEach>
							<label class="checkbox"><a href="contact.jsp">不够大请联系我们</a></label>
						</div>
					</div>
				</section>	

			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//products-->
	<!--footer-->
		<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>