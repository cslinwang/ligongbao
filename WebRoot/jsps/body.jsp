<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <title>用户登陆</title>
    </head>
<link rel="stylesheet" type="text/css" href="/LiGongBao/jsps/css/body.css" />
<script src="/LiGongBao/jsps/js/jquery-2.1.1.js" charset="GB2312"></script>
<script type="text/javascript">
$(function(){
	$(".computer").hover(
			
	function(){
		
		$(this).css({"border":"solid #483D8B 1px","box-shadow" : "3px 5px 8px #483D8B"});
	},
	function(){
		
		$(this).css({"border":"solid #fff 1px","box-shadow" : "0px 0px 0px #f0f0f0"});
	}
	);
});
    
</script>
<body bgcolor="#5E8F36">
 
  
<jsp:include page="/jsps/head.jsp"></jsp:include>
<div id="main">

         <c:forEach items="${computerlist}" var="computer" >
         <div class="computer">
             <div class="image_div"><a href="/LiGongBao/ComputerInfo?nid=${computer.nid}"><image src="/LiGongBao/${computer.nimage}" class="image"></a></div>
             <div class="computer_info">
                  <table width="200px" height="120px">
                      <tr align="center">
                            <td><a href="/LiGongBao/ComputerInfo?nid=${computer.nid}">${computer.nname}</a></td>
                      </tr>
                      <tr align="center">
                             <td><del>￥${computer.nprice}</del>&nbsp;<span style="color:#FF8854;font-size: 18px;">￥${computer.nrprice}</span></td>
                      </tr>
                      <tr align="center">
                             <td><a href="/LiGongBao/ConfirmOrder?nid=${computer.nid}">立即购买</a>&nbsp;<a href="/LiGongBao/AddToShopCart?nid=${computer.nid}">加入购物车</a></td>
                      </tr>
                  </table>
             </div>
         </div>
         </c:forEach>
         
        
          
         <!-- 分页栏 -->
         <div id="page">
         
              <table>
                   <tr>
                       <td><a href="/LiGongBao/ComputerServlet?page=${pa-1>=0?pa-1:0}" id="before_page">上一页</a></td>
                       
                        <c:forEach begin="0" end="${page}" var="i">
                       
                        <td><a href="/LiGongBao/ComputerServlet?page=${i}" class="page_main">${i+1}</a></td>
                       
                        </c:forEach>
                       
                       <td><a href="/LiGongBao/ComputerServlet?page=${pa+1<=page?pa+1:page}" id="last_page">下一页</a></td>
                   </tr>
              </table>
         </div>
</div>

 <jsp:include page="/jsps/foot.jsp"></jsp:include>
 </body>
</html>