<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<link type="text/css" rel="stylesheet" type="text/css"
	href="/LiGongBao/jsps/css/head.css">
<script type="text/javascript">
	function subll() {
		document.getElementById("form_Search").submit();
	}
</script>
<!-- 菜单栏上面的空白区域 -->
<div id="head_top">
	<!-- 网站logo -->
	<div id="head_top_logo">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<image src="/LiGongBao/images/foot/logo.jpg"></image>
	</div>

	<!-- 搜索 -->
	<div id="head_top_search">
		<form action="/LiGongBao/SearchComputer" method="post"
			id="form_Search">
			<ul>
				<li><input name="name" type="text" id="SearchComputer">
				</li>
				<li><a href="javascript:subll()">搜索</a>
				</li>
			</ul>
		</form>
	</div>

	<!-- 用户登录注册 -->
	<div id="head_top_user">
		<%
			if (session.getAttribute("user") == null) {
		%>
		<span>亲,您还没有登录[<a href="/LiGongBao/jsps/login.jsp">登录</a>][<a
			href="/LiGongBao/jsps/register.jsp">注册</a>]</span>
		<%
			} else {
				if (session.getAttribute("sign") == null) {
		%>
		<span>${user.username},欢迎来到理工宝&nbsp;未签到[<a href="SignServlet">签到</a>][<a
			href="/LiGongBao/RemoveSession">退出</a>]</span>
		<%
			} else {
		%>
		<span>${user.username},欢迎来到理工宝&nbsp;已签到[<a
			href="/LiGongBao/RemoveSession">退出</a>]</span>
		<%
			}
			}
			;
		%>
	</div>
</div>

<!-- 菜单栏 -->
<div id="head_nav">
	<ul id="nav_ul">
		<li><a href="/LiGongBao">首页</a>
		</li>
		<li><a href="/LiGongBao/jsps/UpdatePassword.jsp">修改密码</a>
		</li>
		<li><a href="/LiGongBao/OrderServlet">我的订单</a>
		</li>
		<li><a href="/LiGongBao/ShopCartServlet">我的购物车</a>
		</li>
	</ul>
</div>
