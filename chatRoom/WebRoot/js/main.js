$(function(){
	var loginstate=false;
	var username;
	var password;
	$('.main-box').css('width',$('.main').css('width'));
	$(window).on('resize',function(){
		$('.main-box').css('width',$('.main').css('width'));
	});
	$('#login-btn').on('click',function(ev){
		loginstate=false;
		login();
	});
 	$('#login-action').on('click',function(ev){
		$('.help-block').html('');
		$('#username').val('');
		$('#password').val('');
 	});
 	$('#exit').on('click',function(ev){
 		$('.userdiv').css('display','block');
		$('.login-detail').css('display','none');
		loginstate=false;
 	});
 	$('#send').on('click',function(ev){
 		if (!loginstate) {
 			$('#send').tooltip('show');
 		}
 		else
 		{
 			$('#send').tooltip('destroy');
 			sendMessage();
 			$('#message').val('');

 			/*
 			var newItem=$('<div class="item left clearfix"><span class="name">'+username+'</span><span class="time">'+time+'</span><span class="content">'+$('#message').html()+'</span></div>');
			
			$('.main-box').append(newItem);
			$('.main-box .item:last').css('padding','0');
			$('.main-box .item:last').css('height','0');
			$('.main-box .item:last').css('opacity','0');
			$('.main-box .item:last').animate({height:"100%",opacity:"1"},1000);
			$('.main-box .item:last').css('padding','2rem');
			*/
 		}
 	});

 	function getMessage()
 	{
 		if (loginstate) {
 			$.ajax({
 				type:'POST',
 				url:'messageAction',
 				data:{
 					action:'getMessage',
 				},
 				success:function(data){
 					data=JSON.parse(data);
 					if(data.code=="1")
 					{
 						if ($('.main-box .item:last .time')){
 							if ($('.main-box .item:last .time').html()!=data.time) {
 								if (data.sender==username) {
			 						var newItem=$('<div class="item left clearfix"><span class="name">'+data.sender+'</span><span class="time">'+data.time+'</span><span class="content">'+data.content+'</span></div>');
			 						$('.main-box').append(newItem);
		 						}
			 					else
			 					{
			 						var newItem=$('<div class="item right clearfix"><span class="time">'+data.time+'</span><span class="name">'+data.sender+'</span><span class="content">'+data.content+'</span></div>');
			 						$('.main-box').append(newItem);
			 					}
		 						$('.main-box .item:last').css('height','0');
								$('.main-box .item:last').css('opacity','0');
								$('.main-box .item:last').animate({height:"100%",opacity:"1"},1000);
								
								$('.main-container').animate({scrollTop:$('.main-box').prop('scrollHeight')},600);

 							}
 						}
 						else
 						{
 							if (data.sender==username) {
		 						var newItem=$('<div class="item left clearfix"><span class="name">'+data.sender+'</span><span class="time">'+data.time+'</span><span class="content">'+data.content+'</span></div>');
		 						$('.main-box').append(newItem);
	 						}
		 					else
		 					{
		 						var newItem=$('<div class="item right clearfix"><span class="time">'+data.time+'</span><span class="name">'+data.sender+'</span><span class="content">'+data.content+'</span></div>');
		 						$('.main-box').append(newItem);
		 					}
	 						$('.main-box .item:last').css('height','0');
							$('.main-box .item:last').css('opacity','0');
							$('.main-box .item:last').animate({height:"100%",opacity:"1"},1000);
							$('.main-container').animate({scrollTop:$('.main-box').prop('scrollHeight')},600);
 						}
 					}
 					setTimeout(getMessage,1000);
 				},
 				error:function(error){
 					
 				}
 			});
 		}
 	}
 	function getAllMessage(){
	 		if (loginstate) {
	 			$.ajax({
	 			type:'POST',
	 			url:'messageAction',
	 			data:{
	 				username:username,
	 				action:'getAllMessage'
	 			},
	 			success:function(data){
	 				/*
	 				data=JSON.parse(data);
	 				for (var i = 0; i < data.length; i++) {
	 					if (data[i].sender==username) {
	 						var newItem=$('<div class="item left clearfix"><span class="name">'+data[i].sender+'</span><span class="time">'+data[i].time+'</span><span class="content">'+data[i].content+'</span></div>');
	 						$('.main-box').append(newItem);
	 					}
	 					else
	 					{
	 						var newItem=$('<div class="item right clearfix"><span class="time">'+data[i].time+'</span><span class="name">'+data[i].sender+'</span><span class="content">'+data[i].content+'</span></div>');
	 						$('.main-box').append(newItem);
	 					}
	 				}
	 				*/
	 			},
	 			error:function(error){

	 			}
	 		});
 		}
 	}

 	function sendMessage(){
 		var message=$('#message').val();
 		var time=new Date();
		time=changeDate(time);
 		$.ajax({
 			type:'POST',
 			url:'messageAction',
 			data:{
 				sender:username,
 				time:time,
 				message:message,
 				action:'sendMessage'
 			},
 			success:function(data){
				setTimeout(getMessage,1000);
 			},
 			error:function(error){

 			}
 		});
 	}
 	function changeDate(time){
 		var year=time.getFullYear();
 		var month=time.getMonth()+1;
 		var day=time.getDate();
 		var hour=time.getHours();
 		var minute=time.getMinutes();
 		var second=time.getSeconds();
 		return year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
 	}
	function login(){
		username=$('#username').val();
		password=$('#password').val();
		$.ajax({
			type:'POST',
			url:'userAction',
			data:{
				username:username,
				password:password,
				action:'login'
			},
			success:function(data){
				data=JSON.parse(data);
				if(data.code=='0')
				{
					$('.help-block').html(data.message);
				}
				else
				{
					$('.help-block').html(data.message);
					$('.userdiv').css('display','none');
					$('.login-detail').css('display','block');
					$('.login-detail .detail p').html(username);
					$('.main-box').html('');
					setTimeout(function(){
						$('#myModal').modal('hide');
					},1000);
					loginstate=true;
					getAllMessage();
					setTimeout(getMessage,1000);
				}
			},
			error:function(error){

			}
		});
	}
});