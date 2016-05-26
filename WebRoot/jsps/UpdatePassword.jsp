<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="css/UpdatePassword.css" />
    <script type="text/javascript">
       function subs(){
          document.getElementById("forms").submit();
       }
    </script>
  </head>
  
  <body bgcolor="#5E8F36">
      <!-- 包含头页面 -->
      <jsp:include page="/jsps/head.jsp"></jsp:include>
      
      <div id="main" style="width:900px;height:470px;margin:10px auto 10px;border:solid 1px #cdcdcd;">
          <div id="head">
             <span style="font-size: 18px;font-family: 楷体;color : #696969;line-height: 25px;margin-left: 8px;">修改密码</span>
          </div>
          
          <div id="body">
              <form action="/LiGongBao/UpdatePassword" method="POST" id="forms">
              <table style="margin: 10px auto 10px;" width=300px; height="160px">
                  <tr>
                  	  <td rowspan="3"><img alt="" src="../images/rihe.png"></td>
                      <td class="text">原密码:</td>
                      <td><input type="password" name="oldpassword" class="input"></td>
                  </tr>
                  <tr>
                      <td class="text">新密码:</td>
                      <td><input type="password" name="newpassword" class="input"></td>
                  </tr>
                  <tr>
                      <td class="text">重复输入新密码:</td>
                      <td><input type="password" name="password" class="input"></td>
                  </tr>
                  <tr>
                      <td>&nbsp;</td>
                      <td><a href="javascript:subs()" id="sub">保存修改</a></td>
                  </tr>
              </table>
              </form>
          </div>
          
      </div>
      
      <!-- 包含foot.jsp页脚页面 -->
      <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
