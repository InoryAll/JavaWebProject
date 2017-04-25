/*
*Author:Inory;
*Date:2017-4-5;
*last modefied by:Inory;
*last modefied time:2017-4-5;
*/

$(document).ready(function(){

	/*设置轮播插件初始化*/
	$(".owl-carousel").owlCarousel({
		items:1,
		loop:true,
		autoplay:true,
		autoplayTimeout:3000,
		autoplayHoverPause:true
	});

	/*设置白键监听*/
	setWhiteActive();
	setWhiteMouseDown();
	setWhiteMouseUp();

	/*设置黑键监听*/
	setBlackActive();
	setBlackMouseDown();
	setBlackMouseUp();

	/*清空之前的事件操作*/
	clearMouseUp();

	/*绑定按钮事件*/
	btnMouseOver();

	/*绑定白键手势事件*/
	setWhiteTouchStart();
	setWhiteTouchEnd();

});

/*绑定白键划过监听*/
function setWhiteActive(){
	$('.white li').on('mouseover', function(ev) {
		$(this).addClass('white-active');
		ev.preventDefault();
	});
	$('.white li').on('mouseout', function(ev) {
		$(this).removeClass('white-active');
		ev.preventDefault();
	});
}

/*绑定白键点下监听*/
function setWhiteMouseDown(){
	$('.white li').on('mousedown', function(ev) {
		var index=$('.white li').index(this);
		$(this).addClass('white-focus');
		$('.white-source').eq(index).get(0).play();
		ev.preventDefault();
	});

}

/*绑定白键抬起监听*/
function setWhiteMouseUp(){
	$('.white li').on('mouseup', function(ev) {
		$('.white li').removeClass('white-focus');
		ev.preventDefault();
	});
}

/*绑定黑键划过监听*/
function setBlackActive(){
	$('.black li').on('mouseover',function(ev){
		$(this).addClass('black-active');
		ev.preventDefault();
	});
	$('.black li').on('mouseout',function(ev){
		$(this).removeClass('black-active');
		ev.preventDefault();
	});
}

/*绑定黑键点下监听*/
function setBlackMouseDown(){
	$('.black li').on('mousedown',function(ev){
		var index=$('.black li').index(this);
		$(this).addClass('black-focus');
		$('.black-source').eq(index).get(0).play();
		ev.preventDefault();
	});
}

/*绑定黑键抬起监听*/
function setBlackMouseUp(){
	$('.black li').on('mouseup',function(ev){
		$('.black li').removeClass('black-focus');
		ev.preventDefault();
	});
}

/*清楚抬起后所有的样式*/
function clearMouseUp(){
	$(document).on('mouseup',function(ev){
		$('.white li').removeClass('white-active');
		$('.black li').removeClass('black-active');
		$('.white li').removeClass('white-focus');
		$('.black li').removeClass('black-focus');
		ev.preventDefault();
	});
}

/*按钮鼠标划过监听*/
function btnMouseOver(){
	$('.enter').on('mouseover',function(ev){
		$(this).css('background','url(\'img/music.gif\') 200px 5px no-repeat #395ea6');
	});
	$('.enter').on('mouseout',function(ev){
		$(this).css('background','#395ea6');
	});
}

/*手指按下的白键监听*/
function setWhiteTouchStart(){
	$('.white li').on('touchstart',function(ev){
		var index=$('.black li').index(this);
		$(this).addClass('black-focus');
		$('.black-source').eq(index).get(0).play();
		ev.preventDefault();
	});
}

/*手指移开的白键监听*/
function setWhiteTouchEnd(){
	$('.white li').on('touchend',function(ev){
		$('.white li').removeClass('white-focus');
		ev.preventDefault();
	});
}

