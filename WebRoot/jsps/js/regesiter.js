$(document).ready(function(){
	     //������ý���ʱ�ı�߿�
         $('.input').focus(function(){
        	 $(this).css({'border':'solid 1px #483D8B'});
        	 inputId = $(this).attr('id');
        	 spanId   = inputId + 'text';
        	 showInfoemation(spanId);
         });
         $('.input').focusout(function(){
        	 $(this).css({'border':'solid 1px #ABABAB'});
        	 /*
        	  * ����span��ʾ�������
        	  * �õ�ʧȥ�����Ԫ��,��ȡid Ȼ��ͨ��id�ҵ���Ӧ�Ĵ������spanԪ��
        	  * Ȼ���ִ����Ӧ�ĺ��������
        	  * ����������Ϣ����Ҫ��Ͳ�����
        	  * ����������Ϣ������Ҫ�����spanԪ������ʾ������Ϣ
        	  * */
        	 //alert($(this).attr('id')); �õ�������id
        	 inputId = $(this).attr('id');
        	 //��Ӧ��spanԪ�ص�id
        	 spanId  = inputId + 'text';
        	 //ͨ��eval()������ִ��һ��ͬ���ĺ���
        	 eval(spanId+'("'+inputId+'")');	  
         });
         //��֤��У��
         
 });

//��֤�û���
function inputusernametext(inputId){
	//alert("inputusernametext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('�û�������Ϊ��!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(Trim(text).length<4||text.length>20){
		$('#'+inputId+'text').text('�û��������ǳ���Ϊ4-20������,��ĸ���»���!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(!Trim(text).match("^[0-9a-zA-z-_]+$")){
		$('#'+inputId+'text').text('�û���ֻ����������ĸ���»���').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('�û�������!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//��֤����
function inputuserpasstext(inputId){
	//alert("inputuserpasstext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('���벻��Ϊ��!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(Trim(text).length<6||text.length>20){
		$('#'+inputId+'text').text('��������ǳ���Ϊ6-20���ַ�!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('�������!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//��֤������������
function inputuserrepasstext(inputId){
	//alert("inputuserrepasstext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('���벻��Ϊ��!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(text!=$("#inputuserpass").val()){
		$('#'+inputId+'text').text('ȷ��������ԭ���벻��ͬ!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('�������!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//��֤����
function inputemailtext(inputId){
	//alert("inputemailtext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('���䲻��Ϊ��!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(text)){
		$('#'+inputId+'text').text('�����ʽ����ȷ!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('�������!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
}

//��֤У����
function verifyImagetext(inputId){
	//alert("inputverifytext()");
	var text = $('#'+inputId).val();
	if(Trim(text).length==0){
		$('#'+inputId+'text').text('У���벻��Ϊ��!').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(Trim(text).length!=4){
		$('#'+inputId+'text').text('У���볤�ȱ���Ϊ4').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else if(!/^[A-Za-z0-9]+$/.test(text)){
		$('#'+inputId+'text').text('У���볤�ȱ���Ϊ��ĸ������').css({'color':'#AA0000'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/false.jpg' width='14' height='14'>");
		return false;
	}else{
		$('#'+inputId+'text').text('У�������!').css({'color':'#696969'});
		$('#'+inputId+'text').prepend("<img src='/NoteHome/images/true.jpg' width='20' height='20'>");
		return true;
	}
	
}
//�����õ�����ʱspanԪ����ʾ��ʾ����
function showInfoemation(spanId){
	//alert("showInfoemation()");
	if(spanId == "inputusernametext"){
		$('#'+spanId).text('* �û������ǳƣ�����ĸ�����֡��»���(4-20���ַ�)��ע��ɹ��󽫲��ܸ��ġ�').css({'color':'#696969'});
	}else if(spanId == "inputuserpasstext"){
		$('#'+spanId).text('* ��¼���루6-20���ַ��������������ĸ�Լ����֣����磺password3��').css({'color':'#696969'});
	}else if(spanId == "inputuserrepasstext"){
		$('#'+spanId).text('* �ظ������¼���롣').css({'color':'#696969'});
	}else if(spanId == "inputemailtext"){
		$('#'+spanId).text('* ���ĳ������䣬�����佫������¼��Ա������������Ҫ֪ͨ��').css({'color':'#696969'});
	}else{
		$('#'+spanId).text('* ��������֤�롣').css({'color':'#696969'});
	}
}
//�����¼��ť �������Ҫ�����ύ,�����������ύ
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
//�ַ���ȥ�ո�
function Trim(value){
	var res = String(value).replace(/^[\s]+|[\s]+$/g,'');
	return res;
} 