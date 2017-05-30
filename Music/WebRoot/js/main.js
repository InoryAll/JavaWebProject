/*
*Author:Inory;
*Date:2017-4-7;
*last modefied by:Inory;
*last modefied time:2017-4-7;
*/

$(document).ready(function(){
	
	/*设置轮播效果*/
	setCarousel();
	/*设置显示音乐特征选择菜单*/
	showMusicSelectMenu();
	/*设置搜索按钮事件*/
	setSearchBtn();
	/*var str='';
	for (var i = 0; i < 127; i++) {
		str+=0;
	}
	console.log(str);*/


});

function setSearchBtn(){
	$('.search-btn').on('click',function(ev){
		$('#personalSearch').modal('toggle');
		var music=new Music('Hello','','me','me','2:50','1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000');
		var src=getImage(music).src;
		$('.musicImg').attr('src',src);
		ev.preventDefault();
	});
}

/*音乐实体类*/
function Music(name,info,author,origin,length,style){
	this.name=name;
	this.info=info;
	this.author=author;
	this.origin=origin;
	this.length=length;
	this.style=style;
}

/*根据音乐特征来选择显示图片*/
function getImage(music){
	var style=music.style;
	var firstDivide;
	var secondDivide;
	var catalog;
	var randomNum;

	/*进行第一次划分*/
	firstDivide=firstMusicDivide(style).firstDivide;
	style=firstMusicDivide(style).style;

	/*进行第二次划分*/
	secondDivide=secondMusicDivide(firstDivide,style).secondDivide;
	style=secondMusicDivide(firstDivide,style).style;

	/*随机生成图片序号*/
	randomNum=getRandomNumber(3);

	/*返回音乐目录*/
	catalog='img/divided/'+firstDivide+'/'+secondDivide+'/'+randomNum+'.png';

	return {'src':catalog};
}

/*音乐的第一次图片分类*/
function firstMusicDivide(style){
	var firstDivide='';
	if (style.substring(0, 42).indexOf('1')>-1){
		firstDivide='active';
		style=style.substring(0, 42);
	}
	if (style.substring(42, 84).indexOf('1')>-1){
		firstDivide='middle';
		style=style.substring(42, 84);
	}
	if (style.substring(84).indexOf('1')>-1){
		firstDivide='negative';
		style=style.substring(84);
	}
	return {'firstDivide':firstDivide,'style':style};
}

/*音乐的第二次图片分类*/
function secondMusicDivide(firstDivide,style){

	/*第一次划分的结果分析*/
	var secondDivide='';
	switch (firstDivide){
		case 'active':
			doSecondDivide();
			break;
		case 'middle':
			doSecondDivide();
			break;
		case 'negative':
			doSecondDivide();
			break;
	}

	/*做音乐字符串分析*/
	function doSecondDivide(){
		if (style.substring(0, 14).indexOf('1')>-1) {
			secondDivide='100';
			style=style.substring(0, 14);
		}
		if (style.substring(14, 28).indexOf('1')>-1) {
			secondDivide='010';
			style=style.substring(14, 28);
		}
		if (style.substring(28).indexOf('1')>-1) {
			secondDivide='001';
			style=style.substring(28);
		}
	}

	return {'secondDivide':secondDivide,'style':style};

}

/*获取随机数字*/
function getRandomNumber(range){
	return Math.floor(Math.random()*range);
}

/*显示音乐特征选择菜单*/
function showMusicSelectMenu(){
	$('.getMore .getMoreBtn').on('click',function(ev){
		if ($('.searchMusic').css('display')=='none') {
			$('.searchMusic').css('opacity', '0');
			$('.searchMusic').css('display', 'block');
			$('.searchMusic').animate({
				'opacity': 1,},
				800, function() {
				
			});
		}
		else
		{
			$('.searchMusic').animate({
				'opacity': 0,},
				800, function() {
					$('.searchMusic').css('opacity', '0');
					$('.searchMusic').css('display', 'none');
			});
		}
		ev.preventDefault();
	});
}

/*实现轮播效果*/
function setCarousel(){
	$(".owl-carousel").owlCarousel({
		items:1,
		loop:true,
		autoplay:true,
		autoplayTimeout:3000,
		autoplayHoverPause:true,
	});
	$('#ad').on('mouseenter',function(ev){
		$('.pre').animate({
			'opacity': '0.3'},
			400, function() {
		});
		$('.next').animate({
			'opacity': '0.3'},
			400, function() {
		});
		ev.preventDefault();
	});
	$('#ad').on('mouseleave',function(ev){
		$('.pre').animate({
			'opacity': '0'},
			400, function() {
		});
		$('.next').animate({
			'opacity': '0'},
			400, function() {
		});
		ev.preventDefault();
	});
	$('#ad .pre').on('mouseover',function(ev){
		$('.pre').animate({
			'opacity': '0.5'},
			400, function() {
		});
		ev.preventDefault();
	});
	$('#ad .pre').on('mouseout',function(ev){
		$('.pre').animate({
			'opacity': '0.3'},
			400, function() {
		});
		ev.preventDefault();
	});
	$('#ad .next').on('mouseover',function(ev){
		$('.next').animate({
			'opacity': '0.5'},
			400, function() {
		});
		ev.preventDefault();
	});
	$('#ad .next').on('mouseout',function(ev){
			$('.next').animate({
			'opacity': '0.3'},
			400, function() {
		});
		ev.preventDefault();
	});
	$('#ad .pre').on('click',function(ev){
		$('.owl-carousel').trigger('prev.owl.carousel');
		ev.preventDefault();
	});
	$('#ad .next').on('click',function(ev){
		$('.owl-carousel').trigger('next.owl.carousel');
		ev.preventDefault();
	});
}