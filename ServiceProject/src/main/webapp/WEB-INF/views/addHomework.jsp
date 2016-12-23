<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布作业</title>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link
	href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css"
	rel="stylesheet" media="screen">
<script type="text/javascript"
	src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<style>
.top h1 {
	font-family: "STXingkai";
	font-size: 40px;
	text-align: center;
}

.left { //
	border-right: 1px solid #ddd; //
	height: 100%;
}

.right { //
	height: 100%;
	border-left: 1px solid #ddd;
}

#answer {
	display: none;
}

.center {
	height: auto;
}

.bottom_right_top li {
	display: inline;
}

.bottom {
	text-align: center;
	font-size: 20px;
}

li {
	list-style: none;
}

.Navigation li {
	display: inline;
}

.Navigation ul {
	position: absolute;
	bottom: 10px;
	font-size: 30px;
}

li :hover {
	text-decoration: none;
	background-color: #0088CC;
}

.right button {
	position: absolute;
	bottom: 300px;
	right: 300px;
}

#title {
	font-size: 35px;
	text-align: center;
}

.breadcrumb {
	font-size: 30px;
}

select {
	border: solid 1px #000;
	width: 50px;
	height: 30px;
	appearance: none;
	-moz-appearance: none;
	-webkit-appearance: none;
	padding-right: 14px;
	background: url("http://ourjs.github.io/static/2015/arrow.png")
		no-repeat scroll right center transparent;
}

.footer {
	margin-top: 20px;
	padding-top: 30px;
	border-top: 5px solid #ddd;
}

.main {
	text-align: center;
	margin: 0px auto;
	font-size: 20px;
}

textarea {
	height: 100px;
	width: 300px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid top">
			<div class="span12">
				<h1>跟我学--在线作业系统</h1>
				<hr
					style="height: 10px; border: none; border-top: 10px groove skyblue;" />
				<!--加载图片轮播-->
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<div class="carousel slide" id="carousel-75682">
								<ol class="carousel-indicators">
									<li data-slide-to="0" data-target="#carousel-75682"></li>
									<li data-slide-to="1" data-target="#carousel-75682"></li>
									<li data-slide-to="2" data-target="#carousel-75682"
										class="active"></li>
								</ol>
								<div class="carousel-inner">
									<div class="item">
										<img alt="" src="img/1.jpg" />
										<div class="carousel-caption">
											<h4>课程介绍</h4>
											<p>课程讲述以实际操作结合理论讲解，通俗易懂，贴合实际需求，教您学会不同风格的化妆技巧</p>
										</div>
									</div>
									<div class="item">
										<img alt="" src="img/2.jpg" />
										<div class="carousel-caption">
											<h4>H2 college</h4>
											<p>开启你的梦想进阶之路，H2学院2017年开班计划</p>
										</div>
									</div>
									<div class="item active">
										<img alt="" src="img/3.jpg" />
										<div class="carousel-caption">
											<h4>邓强</h4>
											<p>浙江大学电商人才基地美工教研组讲师，明德学校信息部总监</p>
										</div>
									</div>
								</div>
								<a rel="nofollow" data-slide="prev" href="#carousel-75682"
									class="left carousel-control">‹</a> <a rel="nofollow"
									data-slide="next" href="#carousel-75682"
									class="right carousel-control">›</a>
							</div>
						</div>
					</div>
				</div>
				<ul class="breadcrumb">
					<li><a rel="nofollow" href="#">主页</a> <span class="divider">/</span>
					</li>
					<li><a rel="nofollow" href="#">课程</a> <span class="divider">/</span>
					</li>
					<li class="active">作业</li>
				</ul>
			</div>
		</div>
		<div class="row-fluid center">
			<div class="main">
				<form action="tea_addHomework.do" method="get">
					课程号：<input type="text" name="cou_id"
						value="${requestScope.section.cou_id}" readonly="readonly" /><br />
					章节号：<input type="text" name="sec_num"
						value="${requestScope.section.sec_num}" readonly="readonly" /><br />
					作业：
					<textarea name="sec_homework" placeholder="请用;隔开"></textarea>
					<br /> 答案：
					<textarea name="sec_home_ans" placeholder="请用;隔开"></textarea>
					<br /> <input type="submit" value="发布" />
				</form>
			</div>
			<div class="row-fluid footer">
				<div class="span12">
					<div class="bottom">

						<div class="bottom_right">
							<ul class="bottom_right_top">
								<li><a href="#">首页</a></li>
								<li>|</li>
								<li><a href="#">关于</a></li>
								<li>|</li>
								<li><a href="#">帮助</a></li>
								<li>|</li>
								<li><a href="#">联系我们</a></li>
							</ul>
							<ul class="bottom_right_bottom">
								<li>地址：辽宁省大连市开发区8号路大连理工大学软件学院</li>
								<li>电话：010-80768888</li>
								<li>辽ICP备06005295号-1</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>