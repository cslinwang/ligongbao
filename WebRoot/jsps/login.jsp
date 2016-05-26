<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>用户登陆</title>
    </head>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    
    <script src="js/jquery-2.1.1.js" charset="GB2312"></script>
    <script type="text/javascript">
         function varifySubmit(id){
              $("#"+id).submit();
         }
    </script>
    <body bgcolor="#5E8F36">
	
    <!-- 包含头页面 -->
    <jsp:include page="/jsps/head.jsp"></jsp:include>
    <div id="login_main">
         <!-- 登陆页面左边的图片 -->
         <div id="login_left">
              <image src="../images/login/page1.jpg">
         </div>
         
         <!-- 登陆页面的右边登陆框 -->
         <div id="login_right">
         
             <!-- 登陆上面的图片 -->
             <div id="top">
                  <image src="../images/login/page2.jpg">
             </div>
             
             <!-- 中间的登陆部分 -->
             <div id="body">
                   <form action="/LiGongBao/LoginServlet" method="post" id="form">
                        <table id="table" height="100px" width ="100%" style="font-size: 15px;font-family: 仿宋; color: #696969;font-weight: bold; margin-left:30px;">
                            <tr>
                                <td>账号</td>
                                <td><input type="text" value="" name="userName" class="form_input" maxlength="20" autocomplete="off" style="width:180px;height:26px;font-size: 18px;color:#696969"></td>
                            </tr>
                            <tr>
                                <td>密码</td>
                                <td><input type="password" value="" name="userPass" class="form_input" maxlength="20" autocomplete="off" style="width:180px;height:26px;font-size: 14px;color:#696969"></td>
                            </tr> 
                        </table>
                        <a href="javascript:varifySubmit('form')" id="login_buttom">登&nbsp;陆</a><a href="#" id="login"></a>
                   </form>
             </div>
             
             <!-- 下面的提示用户注册部分 -->
             <div id="botton" style="text-align: center;line-height: 80px;font-size: 16px;color:#696969;font-family: 楷体">
                <span id="botton_text">没有LiGongBao账号，<a href="register.jsp">立即注册</a></span>
             </div>
         </div>
    </div>
    
    <!-- 包含foot.jsp页脚页面 -->
    <jsp:include page="/jsps/foot.jsp" ></jsp:include>
    </body>
</html>