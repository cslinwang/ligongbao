<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" type="text/css" href="/LiGongBao/jsps/css/body.css" />
<script src="js/jquery-2.1.1.js" charset="GB2312"></script>
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

 
  
<jsp:include page="/jsps/head.jsp"></jsp:include>
<div id="main">

         <c:forEach items="${computerList}" var="computer" >
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

</div>

