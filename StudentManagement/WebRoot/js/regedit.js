/*regedit.js style*/
window.onload=function(){
/*onload style*/
document.getElementById('regedit_username').onfocus=function(){
	document.getElementById('username_tip').innerHTML="请输入用户名,长度不要少于8位";
}
document.getElementById('regedit_username').onblur=function(){
	document.getElementById('username_tip').innerHTML="*";
}
document.getElementById('regedit_password').onfocus=function(){
	document.getElementById('password_tip').innerHTML="请输入密码,密码长度不要少于8位";
}
document.getElementById('regedit_password').onblur=function(){
	document.getElementById('password_tip').innerHTML="*";
}
document.getElementById('regedit_password_confirm').onfocus=function(){
	document.getElementById('password_confirm_tip').innerHTML="请再次输入密码";
}
document.getElementById('regedit_password_confirm').onblur=function(){
	var password=document.getElementById('regedit_password').value;
	var password_confirm=document.getElementById('regedit_password_confirm').value;
	if(password!=password_confirm)
	{
		document.getElementById('password_confirm_tip').innerHTML="两次输入的密码不一致";
	}
	else
	{
		document.getElementById('password_confirm_tip').innerHTML="*";
	}
}
document.getElementById('regedit_name').onfocus=function(){
	document.getElementById('name_tip').innerHTML="请输入您的姓名";
}
document.getElementById('regedit_name').onblur=function(){
	document.getElementById('name_tip').innerHTML="*";
}
document.getElementById('male').onfocus=function(){
	document.getElementById('sex_tip').innerHTML="请选择您的性别";
}
document.getElementById('female').onfocus=function(){
	document.getElementById('sex_tip').innerHTML="请选择您的性别";
}
document.getElementById('male').onblur=function(){
	document.getElementById('sex_tip').innerHTML="*";
}
document.getElementById('female').onblur=function(){
	document.getElementById('sex_tip').innerHTML="*";
}
document.getElementById('department_tip').innerHTML="请选择你的专业";
document.getElementById('department_select').onchange=function(){
	var department=document.getElementById('department_select').value;
	if(department!="0")
	{
		document.getElementById('department_tip').innerHTML="";
	}
	else
	{
		document.getElementById('department_tip').innerHTML="请选择你的专业";
	}
}
document.getElementById('class_tip').innerHTML="请选择你的班级";
document.getElementById('class_select').onchange=function(){
	var classes=document.getElementById('class_select').value;
	if(classes!="0")
	{
		document.getElementById('class_tip').innerHTML="";
	}
	else
	{
		document.getElementById('class_tip').innerHTML="请选择你的班级";
	}
}
document.getElementById('regedit_phone').onfocus=function(){
	document.getElementById('phone_tip').innerHTML="请输入您的手机号码";
}
document.getElementById('regedit_phone').onblur=function(){
		document.getElementById('phone_tip').innerHTML="";
}
/*end style*/

/*onload check*/
function checkRegeditForm(){
	var username=document.getElementById('regedit_username').value;
	var password=document.getElementById('regedit_password').value;
	var password_confirm=document.getElementById('regedit_password_confirm').value;
	if(username.length<8)
	{
		document.getElementById('submit_check_tip').innerHTML="用户名长度少于8位";
		return false;
	}
	else
	{
		if(password.length<8)
		{
			document.getElementById('submit_check_tip').innerHTML="密码长度小于8位";
			return false;
		}
		else
		{
			if(password!=password_confirm)
			{
				document.getElementById('submit_check_tip').innerHTML="两次输入的密码不一致";
				return false;
			}
			else
			{
				return true;
			}
		}
	}
}
document.getElementById('regedit_form').onsubmit=function(){
	return checkRegeditForm();
}
/*end check*/

/*a link style*/
document.getElementById('regedit_next_1').onclick=function(){
	document.getElementById('regedit_content1').style.display="none";
	document.getElementById('regedit_content2').style.display="block";
	document.getElementById('regedit_content3').style.display="none";
}
document.getElementById('regedit_next_2').onclick=function(){
	document.getElementById('regedit_content1').style.display="none";
	document.getElementById('regedit_content2').style.display="none";
	document.getElementById('regedit_content3').style.display="block";
}

var aRegeditStep=getElementsByClass('regedit_step');
for (var i = 0; i < aRegeditStep.length; i++) {
	if (i%3==0) {
		aRegeditStep[i].onclick=function(){
			document.getElementById('regedit_content1').style.display="block";
			document.getElementById('regedit_content2').style.display="none";
			document.getElementById('regedit_content3').style.display="none";
		}
	}
	if (i%3==1) {
		aRegeditStep[i].onclick=function(){
			document.getElementById('regedit_content1').style.display="none";
			document.getElementById('regedit_content2').style.display="block";
			document.getElementById('regedit_content3').style.display="none";
		}
	}
	if (i%3==2) {
		aRegeditStep[i].onclick=function(){
			document.getElementById('regedit_content1').style.display="none";
			document.getElementById('regedit_content2').style.display="none";
			document.getElementById('regedit_content3').style.display="block";
		}
	}
	
}


function getElementsByClass(className){
	var aEls=document.getElementsByTagName('*');
	var aControls=[];
	for (var i = 0; i < aEls.length; i++) {
		var str=aEls[i].className.split(' ');
		for (var j = 0; j < str.length; j++) {
			if(str[j]==className)
			{
				aControls.push(aEls[i]);
			}
		}
	}
	return aControls;
}
/*end a link*/
}
/*end regedit*/