<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>err</title>
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
             <div style="margin:50px auto 10px;width:500px;height:30px;"><span style="font-size: 21px;font-family: 楷体;color:#ff5500;">您没有登录或帐号信息已经过期</span></div>
             <div style="margin:20px auto 10px;width:500px;height:30px;">
             
                 <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="jsps/login.jsp" style="text-decoration: none;">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="jsps/register.jsp" style="text-decoration: none;">注册</a></span>
             </div>
         </div>
         
         <!-- 包含foot.jsp页脚页面 -->
       <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
