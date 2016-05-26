<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 网站登录页面-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
 	<link rel="icon" href="/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="/LiGongBao/jsps/css/regesiter.css" />
    <script src="/LiGongBao/jsps/js/jquery-2.1.1.js" charset="GB2312"></script>
    <script src="/LiGongBao/jsps/js/regesiter.js" charset="GB2312"></script>
  </head>
  
  <body >
       <!-- 包含头页面 -->
       <jsp:include page="/jsps/head.jsp"></jsp:include>
       
       <form action="/LiGongBao/UserServlet" method="POST" id="form">
       <div id="main">
       <table id="table" height="300px" width ="800px" style="font-size: 19px;font-family: 仿宋; color: #696969;font-weight: bold;">
          <tr >
              <td align="right">用户名: </td>
              <td align="left"><input type="text" class="input" id="inputusername" name="userName"  maxlength="20" autocomplete="off" value="${requ.userName}"></td>
              <td align="left" width="500px" style="word-wrap:break-word;table-layout:fixed;"><span style="font-size: 12px;" id="inputusernametext">
              <c:out value="${errMap.userName}" default="* 用户名（昵称），字母、数字、下划线(4-20个字符)，注册成功后将不能更改。" escapeXml="true"></c:out>
              <!-- 当服务器有值传入页面时就执行script将字体改为红色并添加错误图片 --> 
              <c:if test="${errMap.userName!=null}">
                    <script type="text/javascript">
                       $(document).ready(function(){
                           $('#inputusernametext').css({'color':'#AA0000'});
		                   $('#inputusernametext').prepend("<img src='/LiGongBao/images/false.jpg' width='14' height='14'>");
                       });
                    </script>
              </c:if>
              </span></td>
          </tr>
          <tr>
              <td align="right">密码: </td>
              <td align="left"><input type="password" class="input" style="font-size: 10;color: #696969" id="inputuserpass" name="userPass" maxlength="20" autocomplete="off""></td>
              <td align="left"  width="500px" style="word-wrap:break-word;table-layout:fixed;"><span style="font-size: 12px;" id="inputuserpasstext">
              <c:out value="${errMap.userPass}" default="* 登录密码（6-20个字符），必须包含字母以及数字，例如：password3。" escapeXml="true"></c:out>
              <!-- 当服务器有值传入页面时就执行script将字体改为红色并添加错误图片 -->  
              <c:if test="${errMap.userPass!=null}">
                    <script type="text/javascript">
                       $(document).ready(function(){
                           $('#inputuserpasstext').css({'color':'#AA0000'});
		                   $('#inputuserpasstext').prepend("<img src='/LiGongBao/images/false.jpg' width='14' height='14'>");
                       });
                    </script>
              </c:if>
              </span></td>
          </tr>
          <tr>
              <td align="right">确认密码: </td>
              <td align="left"><input type="password" class="input" style="font-size: 10;color: #696969" id="inputuserrepass" maxlength="20" name="userRePass" autocomplete="off""></td>
              <td align="left" width="500px" style="word-wrap:break-word;table-layout:fixed;"><span style="font-size: 12px;" id="inputuserrepasstext">
              <c:out value="${errMap.userRePass}" default="* 重复输入登录密码。" escapeXml="true"></c:out>
              <!-- 当服务器有值传入页面时就执行script将字体改为红色并添加错误图片 -->
              <c:if test="${errMap.userRePass!=null}">
                    <script type="text/javascript">
                       $(document).ready(function(){
                           $('#inputuserrepasstext').css({'color':'#AA0000'});
		                   $('#inputuserrepasstext').prepend("<img src='/LiGongBao/images/false.jpg' width='14' height='14'>");
                       });
                    </script>
              </c:if>
              </span></td>
          </tr>
          <tr>
              <td align="right">邮箱: </td>
              <td align="left"><input type="text" class="input" id="inputemail" name="userEmail" maxlength="60" autocomplete="off" value="${requ.userEmail}"></td>
              <td align="left" width="500px" style="word-wrap:break-word;table-layout:fixed;"><span style="font-size: 12px;" id="inputemailtext">
              <c:out value="${errMap.userEmail}" default="* 您的常用邮箱，该邮箱将用来登录会员及接收所有重要通知。" escapeXml="true"></c:out>
              <!-- 当服务器有值传入页面时就执行script将字体改为红色并添加错误图片 -->
              <c:if test="${errMap.userEmail!=null}">
                    <script type="text/javascript">
                       $(document).ready(function(){
                           $('#inputemailtext').css({'color':'#AA0000'});
		                   $('#inputemailtext').prepend("<img src='/LiGongBao/images/false.jpg' width='14' height='14'>");
                       });
                    </script>
              </c:if>
              </span></td>
          </tr>
          <tr>
              <td align="right">验证码: </td>
              <td align="left"><input type="text" class="input" id="verifyImage" name="verifyImage" maxlength="4" autocomplete="off">&nbsp;<img width="80px" height="25" src="/LiGongBao/imageCode" id="imageCode"></img></td>
              <td align="left" width="500px" style="word-wrap:break-word;table-layout:fixed;"><span style="font-size: 12px;" id="verifyImagetext">
              <c:out value="${errMap.verifyImage}" default="* 请输入校验码." escapeXml="true"></c:out>
              
              <!-- 当服务器有值传入页面时就执行script将字体改为红色并添加错误图片 -->
              <c:if test="${errMap.verifyImage!=null}">
                    <script type="text/javascript">
                       $(document).ready(function(){
                           $('#verifyImagetext').css({'color':'#AA0000'});
		                   $('#verifyImagetext').prepend("<img src='/LiGongBao/images/false.jpg' width='14' height='14'>");
                       });
                    </script>
              </c:if>
              </span></td>
          </tr>
       </table>
       <a id="regesiter" href="javascript:verifyRegesiter('form')">提交注册</a><a href="/LiGongBao/jsps/login.jsp" id="login">直接登录</a>
       </div>
       </form>
       <!-- 包含foot.jsp页脚页面 -->
       <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
