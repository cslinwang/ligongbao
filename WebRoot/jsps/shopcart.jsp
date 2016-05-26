<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的购物车</title>
<link rel="icon" href="/favicon.ico" type="image/x-icon" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css"
	href="/LiGongBao/jsps/css/shopcart.css">
</head>

<body bgcolor="#5E8F36">
	<div id="content">
		<!-- 包含头页面 -->
		<jsp:include page="/jsps/head.jsp"></jsp:include>


		<!-- 购物车信息栏 -->
		<div id="shopcart_head">
			<table width="900px" height="30px">
				<tr>
					<td width="420">商品信息</td>
					<td width="120">单价</td>
					<td width="120">数量</td>
					<td width="120">金额(元)</td>
					<td width="120">操作</td>
				</tr>
			</table>
		</div>

		<!-- 购物车商品信息 -->
		<c:forEach items="${shopcartList}" var="shopcart">
			<div class="shopcart_body">
				<table width="" 900" height="100px">
					<tr>

						<td width="200px" align="center"><a
							href="/LiGongBao/ComputerInfo?nid=${shopcart.nid}"><image
									src="/LiGongBao/${shopcart.nimage}" height="80px" width="100px"></image>
						</a>
						</td>
						<td width="130px" align="center"><a
							href="/LiGongBao/ComputerInfo?nid=${shopcart.nid}">${shopcart.nname}</a>
						</td>
						<td width="150px" align="center">${shopcart.nrprice}</td>
						<td width="100px" align="center"><a
							href="ChangeCountServlet?count=${shopcart.scount}&&sid=${shopcart.sid}&&name=de">-</a>
							${shopcart.scount} <a
							href="ChangeCountServlet?count=${shopcart.scount}&&sid=${shopcart.sid}&&name=sum">+</a>
						</td>
						<td width="160px" align="center">${shopcart.nrprice *
							shopcart.scount}</td>
						<td width="60px" align="center"><a
							href="/LiGongBao/RemoveShop?sid=${shopcart.sid}&&count">删除</a>
						</td>
						<c:set var="a" value="${a + shopcart.nrprice * shopcart.scount}"></c:set>
						<c:set var="b" value="${b + shopcart.scount}"></c:set>
					</tr>
				</table>
			</div>
		</c:forEach>


		<!-- 购物车底部结算栏 -->
		<div id="shopcart_buttom">
			<table width="900px" height="30px">
				<tr>
					<td width="260">删除</td>
					<td width="120">已选商品<span
						style="font-size: 21px;color:#FF6F00;">${b}</span>件</td>
					<td width="130">合计金额<sapn
							style="font-size: 21px;color:#FF6F00;">
						<fmt:formatNumber type="number" value="${a}" maxFractionDigits="2" />
						</span>
						<span style="font-size: 17px;color:#696969;">元</span>
					</td>
					<td width="120" align="right"><a
						href="/LiGongBao/ShopCartForOrder" id="pay">结&nbsp;算</a>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 包含foot.jsp页脚页面 -->
	<jsp:include page="/jsps/foot.jsp"></jsp:include>

</body>
</html>
