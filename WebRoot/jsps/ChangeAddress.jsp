<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改地址</title>
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/ChangeAddress.css">


  </head>
  
  <body>
        <!-- 包含头页面 -->
	    <jsp:include page="/jsps/head.jsp"></jsp:include>
	    
	    <div id="main">
           <div id="address_head">
              <span>管理收货地址</span>
           </div>
           <div id="address_body">
               <table  width="700px" align="center" border="1px">
               
                  <c:forEach items="${addressList}" var="address">
                  <tr>
                      <td align="center" width="500px">${address.province}${address.city}${address.county}${address.detaileaddress}${address.postalcode}${address.addressee}</td>
                      <td align="center" width="100px"><a href="/LiGongBao/UpdateAddress?aid=${address.aid}">修改</a></td>
                      <td align="center" width="100px"><a href="/LiGongBao/DropAddress?aid=${address.aid}">删除</a></td>
                  </tr>
                  </c:forEach>
                
               </table>
           </div>
      </div>
	    
	    <!-- 包含foot.jsp页脚页面 -->
	    <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
