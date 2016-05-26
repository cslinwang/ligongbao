<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'computer.jsp' starting page</title>
    <link rel="icon" href="/favicon.ico" type="image/x-icon" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/LiGongBao/jsps/css/computer.css">

  </head>
  
  <body bgcolor="#5E8F36">
        <!-- 包含头页面 -->
        <jsp:include page="/jsps/head.jsp"></jsp:include>
        
        <div class="main">

         <div class="left">
            <img src="/LiGongBao/${computer.nimage}" style="width:100%;height:85%;margin-bottom: 10px;"/>
            <div style="width:100%;height:15%;text-align: center;">
               <span style="font-family: 楷体;font-size: 21px;color:#696969;">${computer.nname}</span>
            </div>
         </div>
         
         <div class="right">
             <div class="price">
                       <p>
                                                   商品编号:${computer.nid} <br />
                                                   商品价格:<span>￥${computer.nrprice}</span>              <br />
                                                   商品定价:<del>￥${computer.nprice}</del>&nbsp;折扣价:<font color="#ff0000">${computer.ndiscount}</font>折             <br />
                       </p>
                      
             </div>
             <br />
             <hr width="100%" size=2 color="#888" align="left">
             <div class="publish">
                  <span>公司 : ${computer.ncompany}</span><br /><br />
                  <span>库存 : 999999+</span><br /><br />
                  <span>产品描述 : 数量有限，欲购从速！</span>
                  
                  
             </div>
             <div class="buy">
                  <form action="/goods/orderServlet?method=showOrder&bid=${book.bid}" method="post">
                                           购买数量: <input type="text" name="counts" value="1">&nbsp;本<br />
                                           <br />
                     
                  </form>
                  <table width=260px;>
                      <tr>
                           <td><a href="/LiGongBao/ConfirmOrder?nid=${computer.nid}" class="orderShopCart">立即购买</a></td>
                           <td align="right"><a href="/LiGongBao/AddToShopCart?nid=${computer.nid}" class="orderShopCart">加入购物车</a></td>
                      </tr>
                  </table>
             </div>
         </div>
    </div>
        
        <!-- 包含foot.jsp页脚页面 -->
       <jsp:include page="/jsps/foot.jsp"></jsp:include>
  </body>
</html>
