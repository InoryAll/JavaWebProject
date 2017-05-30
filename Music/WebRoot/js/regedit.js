/*
*Author:Inory;
*Date:2017-4-6;
*last modefied by:Inory;
*last modefied time:2017-4-6;
*/

$(document).ready(function(){
	/*设置ui插件*/
	setJqueryUi();

	/*设置区域变换*/
	setCarousel();

	/*设置页面跳转*/
	jumpToIndex();

	/*设置标签选择效果*/
	setLabelStyle();
});

/*初始化ui插件*/
function setJqueryUi(){
	$( "input[type='radio']" ).checkboxradio();
	$( "#datepicker" ).datepicker({
		dateFormat: 'yy-mm-dd'
	});
}

/*实现各个区域之间的变换*/
function setCarousel(){
	$('.start').on('click',function(ev){
		$('#box').animate({
			'marginLeft': '-102%'},
			1000, function() {
				$('#box').animate({
					'marginLeft': '-100%'},
					400, function() {
				});
		});
		ev.preventDefault();
	});
	$('#basicInfo .next').on('click',function(ev){
		$('#box').animate({
			'marginLeft': '-202%'},
			1000, function() {
				$('#box').animate({
					'marginLeft': '-200%'},
					400, function() {
				});
		});
		ev.preventDefault();
	});
	$('#habit .next').on('click',function(ev){
		$('#box').animate({
			'marginLeft': '-302%'},
			1000, function() {
				$('#box').animate({
					'marginLeft': '-300%'},
					400, function() {
				});
		});
		ev.preventDefault();
	});
}

/*最后实现跳转下一页*/
function jumpToIndex(){
	$('.end').on('click',function(ev){
		$('#thanks').animate({
			'height': '0px'},
			600, function() {
					$('#thanks').css('display', 'none');
					location.href="index.html";
		});
		ev.preventDefault();
	});
}

/*标签选择效果*/
function setLabelStyle() {
	$('.item').on('mouseover',function(ev) {
		var index=$('.item').index(this);
		$('.item').eq(index).css('border','1px solid #fff');
		$('.item').eq(index).css('background', '#4994fd');
		$('.item').eq(index).css('color', '#fff');
		$('.item').eq(index).css({
			'transform': 'translatey(-5px)',
			'transition':'1s ease'
		});
		ev.preventDefault();
	});
	$('.item').on('mouseout',function(ev) {
		var index=$('.item').index(this);
		$('.item').eq(index).css('border','none');
		$('.item').eq(index).css('background', '#eeeeee');
		$('.item').eq(index).css('color', '#00937F');
		$('.item').eq(index).css({
			'transform': 'translatey(5px)',
			'transition':'1s ease'
		});
		ev.preventDefault();
	});
	$('.item ').on('click',function(ev){
		var index=$('.item').index(this);
		$('.item').eq(index).toggleClass('active');
		ev.preventDefault();
	});
}