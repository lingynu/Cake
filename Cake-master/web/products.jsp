<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
				<div class="product-grid">
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
							<h4>粉色少女心蛋糕</h4>
							<span class="item_price">200.00</span>
							<div class="ofr">
								<p class="pric1"><del>230.00</del></p>
								<p class="disc">[15% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m2.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button>详情</button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>紫色玫瑰蛋糕</h4>
							<span class="item_price">220.00</span>
							<div class="ofr">
								<p class="pric1"><del>250.00</del></p>
								<p class="disc">[12% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m3.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情 </button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>彩色绿油蛋糕</h4>
							<span class="item_price">180.00</span>
							<div class="ofr">
								<p class="pric1"><del>300.00</del></p>
								<p class="disc">[30% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m4.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情</button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>巧克力丝滑蛋糕</h4>
							<span class="item_price">100.00</span>
							<div class="ofr">
								<p class="pric1"><del>200.00</del></p>
								<p class="disc">[50% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>							
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m5.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情 </button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>粉嘟嘟鲜花蛋糕</h4>
							<span class="item_price">230.00</span>
							<div class="ofr">
								<p class="pric1"><del>270.00</del></p>
								<p class="disc">[16% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>							
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m6.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情 </button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>巧克力水果蛋糕</h4>
							<span class="item_price">210.00</span>
							<div class="ofr">
								<p class="pric1"><del>2300.00</del></p>
								<p class="disc">[15% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m7.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情</button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>炽热爱情蛋糕</h4>
							<span class="item_price">260.00</span>
							<div class="ofr">
								<p class="pric1"><del>300.00</del></p>
								<p class="disc">[34% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m8.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情</button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>黄金致富蛋糕</h4>
							<span class="item_price">180.00</span>
							<div class="ofr">
								<p class="pric1"><del>200.00</del></p>
								<p class="disc">[10% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>							
					</div>
				</div>
				<div class="product-grid">
					<a href="single.jsp">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/m9.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> 详情</button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>麦香白巧克力蛋糕</h4>
							<span class="item_price">200.00</span>
							<div class="ofr">
								<p class="pric1"><del>300.00</del></p>
								<p class="disc">[43% 折扣]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<input type="button" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
			</div>	
			<div class="col-md-3 rsidebar span_1_of_left">
				<section  class="sky-form">
					<div class="product_right">
						<h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>类别</h4>
						<div class="tab1">
							<ul class="place">								
								<li class="sort">常规蛋糕</li>
								<li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></li>								
							</ul>
							<div class="clearfix"> </div>
							<div class="single-bottom">						
								<a href="#"><p>冰淇淋蛋糕</p></a>
								<a href="#"><p>奶酪蛋糕</p></a>
								<a href="#"><p>椰果蛋糕</p></a>
								<a href="#"><p>纸杯蛋糕</p></a>
						    </div>
					    </div>						  
						<div class="tab2">
							<ul class="place">								
								<li class="sort">特别的蛋糕</li>
								<li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></li>
							</ul>
							<div class="clearfix"> </div>
							<div class="single-bottom">						
								<a href="#"><p>慕斯蛋糕</p></a>
								<a href="#"><p>酸奶蛋糕</p></a>
						    </div>
					    </div>
						<div class="tab3">
							<ul class="place">								
								<li class="sort">大众的蛋糕</li>
								<li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></li>
							</ul>
							<div class="clearfix"> </div>
							<div class="single-bottom">						
								<a href="#"><p>奶油蛋糕</p></a>
								<a href="#"><p>水果蛋糕</p></a>
						    </div>
					    </div>
						<div class="tab4">
							<ul class="place">								
								<li class="sort">小众蛋糕</li>
								<li class="by"><span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span></li>
							</ul>
							<div class="clearfix"> </div>
							<div class="single-bottom">						
								<a href="#"><p>扭动蛋糕</p></a>
								<a href="#"><p>花香蛋糕</p></a>
								<a href="#"><p>双色蛋糕</p></a>
						    </div>
					    </div>
						<!--script-->
						<script>
							$(document).ready(function(){
								$(".tab1 .single-bottom").hide();
								$(".tab2 .single-bottom").hide();
								$(".tab3 .single-bottom").hide();
								$(".tab4 .single-bottom").hide();
								$(".tab5 .single-bottom").hide();
								
								$(".tab1 ul").click(function(){
									$(".tab1 .single-bottom").slideToggle(300);
									$(".tab2 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab2 ul").click(function(){
									$(".tab2 .single-bottom").slideToggle(300);
									$(".tab1 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
								})
								$(".tab3 ul").click(function(){
									$(".tab3 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab5 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})
								$(".tab4 ul").click(function(){
									$(".tab4 .single-bottom").slideToggle(300);
									$(".tab5 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
								$(".tab5 ul").click(function(){
									$(".tab5 .single-bottom").slideToggle(300);
									$(".tab4 .single-bottom").hide();
									$(".tab3 .single-bottom").hide();
									$(".tab2 .single-bottom").hide();
									$(".tab1 .single-bottom").hide();
								})	
							});
						</script>
						<!--//script -->	
					</div>
				</section>
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>折扣</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Upto - 10% (20)</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>70% - 60% (5)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>50% - 40% (7)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (2)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (5)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>30% - 20% (7)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>10% - 5% (2)</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>其他(50)</label>
						</div>
					</div>
				</section>  				 
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>价格</h4>
					<ul class="dropdown-menu1">
						<li><a href="">								               
							<div id="slider-range"></div>							
							<input type="text" id="amount" style="border: 0; font-weight: NORMAL;   font-family: 'Dosis-Regular';" />
							</a></li>			
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
									max: 100000,
									values: [ 500, 100000 ],
									slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
									}
						 });
						$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

						});//]]> 
					</script>
				<!---->
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>风味</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>香草</label>
						</div>
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>巧克力</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>奶油</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>草莓</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>黑森林</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>混合水果</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>蜂蜜</label>
						</div>
					</div>
				</section>
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>尺寸</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>六寸</label>
						</div>		
						<div class="col col-4">
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>八寸</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>十寸</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>双层</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>三层</label>
							<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>不够大请联系我们</label>
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