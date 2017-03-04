/*login.js style*/
window.onload=function(){
	/*onload style*/
	document.getElementById('username').onfocus=function(){
		document.getElementById('username_div').style.border="1px solid #93c273";
	}
	document.getElementById('username').onblur=function(){
		document.getElementById('username_div').style.border="1px solid #e5e5e8";
	}
	document.getElementById('password').onfocus=function(){
		document.getElementById('password_div').style.border="1px solid #93c273";
	}
	document.getElementById('password').onblur=function(){
		document.getElementById('password_div').style.border="1px solid #e5e5e8";
	}
	document.getElementById('username').onfocus();
	document.getElementById('username').select();
	function checkloginform()
	{
		var username=document.getElementById('username').value;
		var password=document.getElementById('password').value;
		if(username.length<8)
		{
			document.getElementById('toolstrip').innerHTML="用户名格式不正确";
			return false;
		}
		else
		{
			if (password.length<8)
			{
				document.getElementById('toolstrip').innerHTML="密码格式不正确";
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	document.getElementById('login_form').onsubmit=function(){
		return checkloginform();
	}
	
	/*end style*/

	/*onload check*/
	
	
	/*end check*/

	/*a link style*/
	
	/*and a link*/
}
/*end login*/