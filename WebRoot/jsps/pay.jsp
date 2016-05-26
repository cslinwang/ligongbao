<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>提交订单页面</title>
      <link rel="icon" href="/favicon.ico" type="image/x-icon" />
      <link rel="stylesheet" type="text/css" href="/LiGongBao/jsps/css/pay.css" />
      
      <script type="text/javascript">
          function subq(){
             document.getElementById("formq").submit();
          }
      </script>
   </head>
   <body>
       <!-- 包含头页面 -->
       <jsp:include page="/jsps/head.jsp"></jsp:include>
       
       <form action="/LiGongBao/AddOrder" id="formq" method="GET">
       <div id="adress">
           <span>选择收货地址</span><a href="/LiGongBao/ChangeAddress" style="margin-left:708px;">管理收货地址</a>
           <hr width="900px"  style="float:left;"/>  
           <ul style="list-style-type:none;margin-top:10px;">
           
           <c:forEach items="${addressList}" var="address">
              <li><input type="radio" value="${address.aid}" name="addressAid">${address.province}${address.city}${address.county}${address.detaileaddress}${address.postalcode}${address.addressee}收&nbsp;</li><br />
           </c:forEach>
             
              <li><a href="/LiGongBao/jsps/address.jsp?nid=${computer.nid}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增收货地址</a></li>
           </ul>
           
       </div>
       <div style="margin-left:100px;margin-top:20px;"><h3>确认订单信息</h3></div>
       <div id="order_head">
         
          <table width="900px" height="30px">
            <tr>
                <td width="420">商品信息</td>
                <td width="120">单价</td>
                <td width="120">数量</td>
                <td width="120">金额(元)</td>
            </tr>
            </table>
       </div>
       
       <div class="shopcart_body">
        <table width=""900" height="100px">
             <tr>
                   <input type="hidden" name="nid" value="${computer.nid}" />
                   <td width="200px" align="center" valign="top"><a href="/LiGongBao/ComputerInfo?nid=${computer.nid}"><image src="/LiGongBao/${computer.nimage}" height="80px" width="100px" style="margin:8px;"></image></a></td>
                   <td width="130px" align="center"><a href="/LiGongBao/ComputerInfo?nid=${computer.nid}">${computer.nname}</a></td>
                   <td width="180px" align="right">${computer.nrprice}</td>
                   <td width="200px" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1</td>
                   <td width="180px" align="center" style="font-size: 21px;color:#f00;">${computer.nrprice}</td>
                   
             </tr>
        </table>
    </div>
    
    <div id="order_botton" style="width:914px;margin-left:100px;height:200px;">
       <div id="main" style="width:300px;height:200px;float:right;">
           <div id="submit_info" style="width:290px;height:120px;border:solid 1px #ff5500;padding:5px;">
                <span  style="color:#666;font-size: 15px; font-family: 楷体;">实付款:<soan style="font-size:21px;color : #ff5500;">${computer.nrprice}</span></span><br><br />
                <span  style="color:#666;font-size: 15px; font-family: 楷体;">寄送至:山西省太原市太原理工大学</span><br /><br />
                 <span style="color:#666;font-size: 15px; font-family: 楷体;">收货人:理工宝  13623661470</span><br />
           </div>
           <div id="submit" style="width:300px;height:30px;">
                 <a href="javascript:subq()" style="display: block;width:120px;height:30px;margin-left:182px;">提交订单</a>
           </div>
        </div>
    </div>
    </form>
  
       <!-- 包含foot.jsp页脚页面 -->
       <jsp:include page="/jsps/foot.jsp"></jsp:include>
   </body>
</html>