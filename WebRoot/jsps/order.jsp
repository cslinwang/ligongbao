<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>我的订单</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">

        <link rel="stylesheet" type="text/css"href="/LiGongBao/jsps/css/order.css">

    </head>
    <body bgcolor="#5E8F36">
    <div id="content">
        <!-- 包含头页面 -->
	    <jsp:include page="/jsps/head.jsp"></jsp:include>

        <form action="#" method="post" name="form">

        <!-- 购物车信息栏 -->
        <div id="shopcart_head">
            <table width="900px" height="30px">
            <tr>
                <td width="420">商品信息</td>
                <td width="120">单价</td>
                <td width="120">数量</td>
                <td width="120">金额(元)</td>
                <td width="120">订单状态</td>
            </tr>
            </table>
         </div>
    
    
    <!-- 购物车商品信息 -->
    <c:forEach items="${Orderlist}" var="order">
    <div class="shopcart_body">
        <table width=""900" height="100px">
             <tr>
                   
                   <td width="200px" align="center" valign="top"><a href="/LiGongBao/ComputerInfo?nid=${order.nid}"><image src="/LiGongBao/${order.image}" height="80px" width="100px" style="margin:8px;"></image></a></td>
                   <td width="130px" align="center"><a href="/LiGongBao/ComputerInfo?nid=${order.nid}">${order.nname}</a></td>
                   <td width="150px" align="center">${order.nrprice}</td>
                   <td width="100px" align="center">${order.counts}</td>
                   <fmt:formatNumber type="number" value="${order.nrprice*order.counts}" maxFractionDigits="2" var="sum"/>
                   <td width="160px" align="center" style="font-size: 21px;color:#f00;">${sum}</td>
                   <td width="100px">
                      <table width="100px" height="100px;">
                      
                         <c:if test="${order.statu==0}">
                              <tr><td align="center" style="vertical-align: bottom;">未付款</td></tr>
                              <tr><td align="center" style="vertical-align: top;"><a href="#">立即付款</a></td></tr>
                         </c:if>
                         
                         <c:if test="${order.statu==1}">
                              <tr><td align="center" style="vertical-align: bottom;">卖家未发货</td></tr>
                              <tr><td align="center" style="vertical-align: top;"><a href="#">提醒卖家发货</a></td></tr>
                         </c:if>
                         <c:if test="${order.statu==2}">
                              <tr><td align="center" style="vertical-align: bottom;">买家未确认收货</td></tr>
                              <tr><td align="center" style="vertical-align: top;"><a href="#">确认收货</a></td></tr>
                         </c:if>
                      </table>
                   </td>
             </tr>
        </table>
    </div>
    
    </c:forEach>
    </form>

	<!-- 包含foot.jsp页脚页面 -->
	<jsp:include page="/jsps/foot.jsp"></jsp:include>
	     </div>
    </body>
<html>