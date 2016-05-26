<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>提交订单成功</title>
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
         <!-- 包含头页面 -->
         <jsp:include page="/jsps/head.jsp"></jsp:include>
         
         <div id="main" style="width : 700px;height: 460px;margin:10px auto 10px;">
             <table>
                 <tr>
                    <td><image src="/LiGongBao/images/true.jpg"></td>
                    <td>提交订单成功,<a href="/LiGongBao/jsps/index.html">去支付</a></td>
                 </tr>
             </table>
         </div>
         
         <!-- 包含foot.jsp页脚页面 -->
       <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
