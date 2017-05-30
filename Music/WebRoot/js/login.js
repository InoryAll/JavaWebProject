/*
*Author:Inory;
*Date:2017-4-6;
*last modefied by:Inory;
*last modefied time:2017-4-6;
*/

$(document).ready(function() {

	/*初始化空间布局*/
	initAllControl();

	/*设置选择变换事件*/
	setSelectPanel();

	/*a链接变换选择区域*/
	setASelectPanel();
	
	/*设置文本框获取焦点事件*/
	setOnFocus();

	/*设置文本框失去焦点事件*/
	setOnBlur();

	/*设置登录按钮事件*/
	setLoginBtnEvent();

	/*设置注册按钮事件*/
	setRegeditBtnEvent();

	/*设置框体定位*/
	setMainPostion();

	/*窗口重构时定位*/
	$(window).on('resize',function(ev){
		setMainPostion();
		ev.preventDefault();
	});

});

/*设置选择变换区域显示*/
function setSelectPanel(){
	$('.login').on('click',function(ev){
		if ($('.login-content').css('display')=='block') 
		{
			return;
		}
		else
		{
			$('.regedit').removeClass('active');
			$('.login').addClass('active');
			$('.regedit-content').css('display', 'none');
			$('.login-content').css({
				'display': 'block',
				'opacity': '0'
			});
			$('.login-content').animate({
				'opacity': '1',},
				800, function() {
			});
		}
		ev.preventDefault();
	});
	$('.regedit').on('click',function(ev){
		if ($('.regedit-content').css('display')=='block') 
		{
			return;
		}
		else
		{
			$('.login').removeClass('active');
			$('.regedit').addClass('active');
			$('.login-content').css('display', 'none');
			$('.regedit-content').css({
				'display': 'block',
				'opacity': '0'
			});
			$('.regedit-content').animate({
				'opacity': '1',},
				800, function() {
			});
		}
		ev.preventDefault();
	});
}

/*a链接变换区域显示*/
function setASelectPanel() {
	$('.doLogin').on('click',function(ev){
		if ($('.login-content').css('display')=='block') 
		{
			return;
		}
		else
		{
			$('.regedit').removeClass('active');
			$('.login').addClass('active');
			$('.regedit-content').css('display', 'none');
			$('.login-content').css({
				'display': 'block',
				'opacity': '0'
			});
			$('.login-content').animate({
				'opacity': '1',},
				800, function() {
			});
		}
		ev.preventDefault();
	});
	$('.doRegedit').on('click',function(ev){
		if ($('.regedit-content').css('display')=='block') 
		{
			return;
		}
		else
		{
			$('.login').removeClass('active');
			$('.regedit').addClass('active');
			$('.login-content').css('display', 'none');
			$('.regedit-content').css({
				'display': 'block',
				'opacity': '0'
			});
			$('.regedit-content').animate({
				'opacity': '1',},
				800, function() {
			});
		}
		ev.preventDefault();
	});
}

/*文本以及密码框获取焦点触发feedback改变*/
function setOnFocus(){
	$('input').on('focus',function(ev){
		var index=$('input').index(this);
		if ($('input').eq(index).attr('name')=='login-username') 
		{
			if (checkUsername('login-username')) 
			{
				$('input[name=login-username]').next().removeClass('glyphicon-remove');
				$('input[name=login-username]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=login-username]').next().removeClass('glyphicon-ok');
				$('input[name=login-username]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input').eq(index).attr('name')=='regedit-username') 
		{
			if (checkUsername('regedit-username')) 
			{
				$('input[name=regedit-username]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-username]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-username]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-username]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input[name=login-password]').attr('name')=='login-password'){
			if (checkSinglePassword('login-password')) 
			{
				$('input[name=login-password]').next().removeClass('glyphicon-remove');
				$('input[name=login-password]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=login-password]').next().removeClass('glyphicon-ok');
				$('input[name=login-password]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input[name=regedit-password]').attr('name')=='regedit-password'){
			if (checkSinglePassword('regedit-password')) 
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input[name=regedit-password-confirm]').attr('name')=='regedit-password-confirm'){
			if (checkSinglePassword('regedit-password-confirm')) 
			{
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-remove');
			}
		}
		if (checkSinglePassword('regedit-password')&&checkSinglePassword('regedit-password-confirm'))
		{
			if(checkDoublePassword('regedit-password','regedit-password-confirm'))
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password]').next().addClass('glyphicon-ok');
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password]').next().addClass('glyphicon-remove');
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-remove');
			}
		}
		ev.preventDefault();
	});
}

/*文本以及密码框失去焦点触发feedback改变*/
function setOnBlur(){
	$('input').on('blur',function(ev){
		var index=$('input').index(this);
		if ($('input').eq(index).attr('name')=='login-username') 
		{
			if (checkUsername('login-username')) 
			{
				$('input[name=login-username]').next().removeClass('glyphicon-remove');
				$('input[name=login-username]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=login-username]').next().removeClass('glyphicon-ok');
				$('input[name=login-username]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input').eq(index).attr('name')=='regedit-username') 
		{
			if (checkUsername('regedit-username')) 
			{
				$('input[name=regedit-username]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-username]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-username]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-username]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input[name=login-password]').attr('name')=='login-password'){
			if (checkSinglePassword('login-password')) 
			{
				$('input[name=login-password]').next().removeClass('glyphicon-remove');
				$('input[name=login-password]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=login-password]').next().removeClass('glyphicon-ok');
				$('input[name=login-password]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input[name=regedit-password]').attr('name')=='regedit-password'){
			if (checkSinglePassword('regedit-password')) 
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password]').next().addClass('glyphicon-remove');
			}
		}
		if ($('input[name=regedit-password-confirm]').attr('name')=='regedit-password-confirm'){
			if (checkSinglePassword('regedit-password-confirm')) 
			{
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-remove');
			}
		}
		if (checkSinglePassword('regedit-password')&&checkSinglePassword('regedit-password-confirm'))
		{
			if(checkDoublePassword('regedit-password','regedit-password-confirm'))
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password]').next().addClass('glyphicon-ok');
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-remove');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-ok');
			}
			else
			{
				$('input[name=regedit-password]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password]').next().addClass('glyphicon-remove');
				$('input[name=regedit-password-confirm]').next().removeClass('glyphicon-ok');
				$('input[name=regedit-password-confirm]').next().addClass('glyphicon-remove');
			}
		}
		ev.preventDefault();
	});
}

/*验证用户名格式*/
function checkUsername(name){
	var reg=/^\w+@\w{2,6}\.[a-z]{2,4}$/gi;
	return reg.test($('input[name='+name+']').val());
}

/*验证单个密码格式*/
function checkSinglePassword(name){
	var reg=/^\w{6,}$/gi;
	return reg.test($('input[name='+name+']').val());
}

/*验证重复密码*/
function checkDoublePassword(first,second){
	if ($('input[name='+first+']').val()==$('input[name='+second+']')) 
	{
		return true;
	}
	else
	{
		return false;
	}
}

/*初始化所有控件的值*/
function initAllControl(){
	$('input').val();
}

/*登录按钮触发事件*/
function setLoginBtnEvent() {
	$('.btn-login').on('click',function(ev){
		if (!checkUsername('login-username')){
			$('.message').html('请以邮箱作为用户名哦，并且保证格式的正确!');
			$('#message-modal').modal('toggle');
			return;
		}
		if (!checkSinglePassword('login-password'))
		{
			$('.message').html('密码长度不能小于6位哦!');
			$('#message-modal').modal('toggle');
			return;
		}
		/*ajax验证用户是否正确*/
		/*$.ajax({
			url:,
			type:,
			data:{

			},
			success:function(data){

			},
			error:function(error){

			}
		});*/
		location.href="regedit.html"
		ev.preventDefault();
	});
}

/*注册按钮触发事件*/
function setRegeditBtnEvent(){
	$('.btn-regedit').on('click',function(ev){
		if (!checkUsername('regedit-username')) 
		{
			$('.message').html('请以邮箱作为用户名哦，并且保证格式的正确!');
			$('#message-modal').modal('toggle');
			return;
		}
		if (!checkSinglePassword('regedit-password')||!checkSinglePassword('regedit-password-confirm'))
		{
			$('.message').html('密码长度不能小于6位哦!');
			$('#message-modal').modal('toggle');
			return;
		}
		if (!checkDoublePassword('regedit-password','regedit-password-confirm')) 
		{
			$('.message').html('两次输入的密码请保持一致哦!');
			$('#message-modal').modal('toggle');
			return;
		}
		/*ajax检测用户名是否存在*/
		/*$.ajax({
			url:,
			type:,
			data:{

			},
			success:function(data){

			},
			error:function(error){

			}
		});*/
		location.href="regedit.html"
		ev.preventDefault();
	});
}

/*登录框定位*/
function setMainPostion(){
	var height=parseInt($(document).height())/2-parseInt($('#main').css('height'))/2;
	if (height<0) 
	{
		$('#main').css('marginTop', 0+'px');
	}
	else
	{
		$('#main').css('marginTop', height+'px');
	}
}