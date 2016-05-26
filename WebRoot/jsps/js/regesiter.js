$(document).ready(function(){
	     //输入框获得焦点时改变边框
         $('.input').focus(function(){
        	 $(this).css({'border':'solid 1px #483D8B'});
        	 inputId = $(this).attr('id');
        	 spanId   = inputId + 'text';
        	 showInfoemation(spanId);
         });
         $('.input').focusout(function(){
        	 $(this).css({'border':'solid 1px #ABABAB'});
        	 /*
        	  * 利用span显示错误输出
        	  * 得到失去焦点的元素,获取id 然后通过id找到对应的错误输出span元素
        	  * 然后就执行相应的函数来检查
        	  * 如果输入的信息符合要求就不报错
        	  * 如果输入的信息不符合要求就在span元素中显示错误信息
        	  * */
        	 //alert($(this).attr('id')); 得到输入框的id
        	 inputId = $(this).attr('id');
        	 //相应的span元素的id
        	 spanId  = inputId + 'text';
        	 //通过eval()函数来执行一个同名的函数
        	 eval(spanId+'("'+inputId+'")');	  
         });
         //验证码校验
         
 });

//验证用户名
function inputusernametext(inputId){
	//alert("inputusernametext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('用户名不能为空!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(Trim(text).length<4||text.length>20){
		$('#'+inputId+'text').text('用户名必须是长度为4-20的数字,字母和下划线!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(!Trim(text).match("^[0-9a-zA-z-_]+$")){
		$('#'+inputId+'text').text('用户名只能是数字字母和下划线').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('用户名可用!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//验证密码
function inputuserpasstext(inputId){
	//alert("inputuserpasstext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('密码不能为空!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(Trim(text).length<6||text.length>20){
		$('#'+inputId+'text').text('密码必须是长度为6-20的字符!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('密码可用!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//验证二次输入密码
function inputuserrepasstext(inputId){
	//alert("inputuserrepasstext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('密码不能为空!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(text!=$("#inputuserpass").val()){
		$('#'+inputId+'text').text('确认密码与原密码不相同!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('密码可用!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//验证邮箱
function inputemailtext(inputId){
	//alert("inputemailtext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('邮箱不能为空!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(text)){
		$('#'+inputId+'text').text('邮箱格式不正确!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('邮箱可用!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//验证校验码
function verifyImagetext(inputId){
	//alert("inputverifytext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('校验码不能为空!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(Trim(text).length!=4){
		$('#'+inputId+'text').text('校验码长度必须为4').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(!/^[A-Za-z0-9]+$/.test(text)){
		$('#'+inputId+'text').text('校验码长度必须为字母或数字').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('校验码可用!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
	
}
//输入框得到焦点时span元素显示提示内容
function showInfoemation(spanId){
	//alert("showInfoemation()");
	if(spanId == "inputusernametext"){
		$('#'+spanId).text('* 用户名（昵称），字母、数字、下划线(4-20个字符)，注册成功后将不能更改。').css({'color':'#696969'});
	}else if(spanId == "inputuserpasstext"){
		$('#'+spanId).text('* 登录密码（6-20个字符），必须包含字母以及数字，例如：password3。').css({'color':'#696969'});
	}else if(spanId == "inputuserrepasstext"){
		$('#'+spanId).text('* 重复输入登录密码。').css({'color':'#696969'});
	}else if(spanId == "inputemailtext"){
		$('#'+spanId).text('* 您的常用邮箱，该邮箱将用来登录会员及接收所有重要通知。').css({'color':'#696969'});
	}else{
		$('#'+spanId).text('* 请输入验证码。').css({'color':'#696969'});
	}
}
//处理登录按钮 如果符合要求则提交,不符合则不能提交
function verifyRegesiter(id){
	//alert("verifyRegesiter()");
	var bool = true;
	if(!inputusernametext("inputusername")){
		bool = false;
	}
	if(!inputuserpasstext("inputuserpass")){
		bool = false;
	}
	if(!inputuserrepasstext("inputuserrepass")){
		bool = false;
	}
	if(!inputemailtext("inputemail")){
		bool = false;
	}
	if(!verifyImagetext("verifyImage")){
		bool = false;
	}
	if(bool){
		$("#"+id).submit();
	}
}
//字符串去空格
function Trim(value){
	var res = String(value).replace(/^[\s]+|[\s]+$/g,'');
	return res;
} 