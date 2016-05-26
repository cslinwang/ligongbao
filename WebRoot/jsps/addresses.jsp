<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>管理收货地址</title>
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/address.css">
	
	<script type="text/javascript" charset="gb2312">
	    function subt(){
	        document.getElementById("formt").submit();
	    }
	</script>

  </head>
  
  <body>
  
      <!-- 包含头页面 -->
	  <jsp:include page="/jsps/head.jsp"></jsp:include>
      
      <div id="main">
           <div id="address_head">
              <span>新增收货地址</span>
           </div>
           <div id="address_body">
               <form action="/LiGongBao/AddressServlets" method="POST" id="formt">
               <!-- 隐式表单提交数据 -->
               <input type="hidden"  name="nid" value="<%=request.getParameter("nid")%>"/>
               <table width="800px" height="288px" id="address_table">
                   <tr>
                       <td>收货地址 : </td>
                       <td><input type="text" name="province" class="input">省
                                   <input type="text" name="city" class="input">市
                                   <input type="text" name="county" class="input">县/区
                       </td>
                       
                   </tr>
                   <tr>
                       <td>详细地址 : </td>
                       <td><textarea rows="5" cols="60" name="DetailedAddress" id="areainput"></textarea></td>
                   </tr>
                   <tr>
                        <td>邮政编码: </td>
                        <td><input type="text" name="PostalCode" class="inputs"></td>
                   </tr>
                   <tr>
                        <td>电话号码/手机号码:</td>
                        <td><input type="text" name="MobileNumber" class="inputs"></td>
                   </tr>
                   <tr>
                         <td>收件人:</td>
                         <td><input type="text" name="Addressee" class="inputs"></td>
                   </tr>
                   <tr>
                          <td>&nbsp;</td>
                          <td><a href="javascript:subt()" id="sumbit_form">保存</a></td>
                   </tr>
               </table>
               </form>
           </div>
      </div>
      
      <!-- 包含foot.jsp页脚页面 -->
	  <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
