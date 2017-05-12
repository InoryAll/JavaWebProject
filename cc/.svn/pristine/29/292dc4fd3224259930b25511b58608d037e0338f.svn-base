/*index.js*/

/*	
	action对应值：-1、0、1、2、3、4、5、6
	  对应的操作：首页、查看个人信息界面、选课界面、查看已选课程界面、评价界面、修改个人信息操作、选课操作、评价操作	
*/
	
window.onload=function(){
	var oHeader=document.getElementById('header');
	var oFooter=document.getElementById('footer');
	var oMain=document.getElementById('main');
	var oLeft=document.getElementById('main_left');
	var oRight=document.getElementById('main_right');
	var oTable=getElementsByClass('search_table');
	var topMenu=document.getElementById('top_menu');
	var copy=document.getElementById('copy');
	var split=getElementsByClass('split_bottom')[0];
	var oFirst_menu=getElementsByClass('first_menu');
	var oSecond_menu=getElementsByClass('second_menu');
	var preHeight;
	var oHeight;
	var preWidth;
	var oWidth;
	var pre=0;
	var oSearch_table=document.getElementById('search_table');
	var allImg=document.getElementsByTagName('img');

	var oSelectSubmit=document.getElementById('select_submit');
	var oUpdateBtn=document.getElementById('regedit_btn');

	var oDeleteDiv=document.getElementById('delete_div');
	var oDeleteA=getElementsByClass('do_delete');
	var delete_item=document.getElementById('delete_item');
	var delete_confirm=document.getElementById('delete_confirm');
	var delete_concel=document.getElementById('delete_concel');

	var oJudgeDiv=document.getElementById('judge_div');
	var oJudgeArea=getElementsByClass('judge_area');
	var oJudgeA=getElementsByClass('do_judge');
	var judge_item=document.getElementById('judge_item');
	var judge_detail=document.getElementById('judge_detail');
	var judge_submit=document.getElementById('judge_submit');
	var judge_cancel=document.getElementById('judge_cancel');

	var judge_detail_arr=[0,0,0,0];
	var judge_detail_str='';

	var reg=/\d+/g;

	var index_div=document.getElementById('index_div');

	var oSecond_menu_li=[];

	var action=document.getElementById('action');
	var oForm=document.getElementById('index_form');

	/*
		action.value=-1;
	*/
	
	for (var i = 0; i < oSecond_menu.length; i++) {
		for (var j = 0; j < oSecond_menu[i].children.length; j++) {
			oSecond_menu_li.push(oSecond_menu[i].children[j]);
		}
	}

	for (var i = 0; i < allImg.length; i++) {
		allImg[i].onmousedown=function(ev){
			var ev=ev||event;
			ev.preventDefault();
		}
	}

	for(var i=0;i<oSecond_menu.length;i++)
	{
		oSecond_menu[i].index=i;
		oSecond_menu[i].style.display='none';
	}

	for(var i=0;i<oFirst_menu.length;i++)
	{
		oFirst_menu[i].index=i;
		oFirst_menu[i].onmouseover=function(){
			if(oSecond_menu[this.index].style.display=='none')
			{
				this.style.color='#2b7dbc';
				this.style.borderLeft='3px solid #629cc9';
			}
		}
		oFirst_menu[i].onmouseout=function(){
				if(oSecond_menu[this.index].style.display=='none')
					this.style.color='#585858';
				this.style.borderLeft='none';
		}
		oFirst_menu[i].onclick=function(){
			oSecond_menu[pre].style.display='none';
			for (var j = 0; j < oSecond_menu[pre].children.length; j++) {
				oSecond_menu[pre].children[j].style.background='#f8f8f8';
			}
			oFirst_menu[pre].style.color='#585858';
			this.style.borderLeft='none';
			oSecond_menu[pre].style.background='#f8f8f8';
			oFirst_menu[pre].style.background='#f8f8f8';
			oFirst_menu[pre].style.borderRight='none';

			oSecond_menu[this.index].style.display='block';
			pre=this.index;

			for (var j = 0; j < oSecond_menu[this.index].children.length; j++) {
				oSecond_menu[this.index].children[j].style.background='#fff';
				oSecond_menu[this.index].children[j].style.borderTop='1px solid #e5e5e5';
			}
			oSecond_menu[this.index].style.background='#fff';
			this.style.background='#fff';
			this.style.color='#2b7dbc';
			this.style.borderRight='2px solid #2b7dbc';
		}
	}

	


	split.parentNode.parentNode.style.display='block';
	preWidth=getStyle(oMain,'width');
	preHeight=getStyle(oMain,'height');
	oMain.style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')+17+'px';
	oMain.style.width=document.documentElement.offsetWidth+'px';
	oLeft.style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')+'px';
	top_menu.style.width=document.documentElement.offsetWidth-getStyle(oLeft,'width')+'px';
	$('#main_left').height(parseInt($(document).height())-parseInt($('#header').height())+'px');
	oTable[0].style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')-getStyle(oFooter,'height')-getStyle(top_menu,'height')-20+'px';
	oTable[1].style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')-getStyle(oFooter,'height')-getStyle(top_menu,'height')-20+'px';
	oTable[2].style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')-getStyle(oFooter,'height')-getStyle(top_menu,'height')-20+'px';
	oTable[3].style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')-getStyle(oFooter,'height')-getStyle(top_menu,'height')-20+'px';

	index_div.style.top=Math.round((main_right.offsetHeight-index_div.offsetHeight)/2)+'px';
	index_div.style.left=Math.round((main_right.offsetWidth-index_div.offsetWidth)/2)+'px';
	split.style.width=document.documentElement.offsetWidth-getStyle(oLeft,'width')+'px';
	oWidth=getStyle(oMain,'width')-preWidth;
	oHeight=getStyle(oMain,'height')-preHeight;
	split.parentNode.parentNode.style.display='none';
	window.onresize=function(){
		split.parentNode.parentNode.style.display='block';
		preWidth=getStyle(oMain,'width');
		preHeight=getStyle(oMain,'height');
		oMain.style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')+17+'px';
		oMain.style.width=document.documentElement.offsetWidth+'px';
		oLeft.style.height=document.documentElement.offsetHeight-getStyle(oHeader,'height')+'px';
		oWidth=getStyle(oMain,'width')-preWidth;
		oHeight=getStyle(oMain,'height')-preHeight;
		top_menu.style.width=getStyle(top_menu,'width')+oWidth+'px';
		split.style.width=getStyle(split,'width')+oWidth+'px';
		$('#main_left').height(parseInt($(document).height())-parseInt($('#header').height())+'px');

		index_div.style.top=Math.round((main_right.offsetHeight-index_div.offsetHeight)/2)+'px';
		index_div.style.left=Math.round((main_right.offsetWidth-index_div.offsetWidth)/2)+'px';

		oTable[0].style.height=getStyle(oTable[0],'height')+oHeight+'px';
		oTable[1].style.height=getStyle(oTable[1],'height')+oHeight+'px';
		oTable[2].style.height=getStyle(oTable[2],'height')+oHeight+'px';
		oTable[3].style.height=getStyle(oTable[3],'height')+oHeight+'px';
		split.parentNode.parentNode.style.display='none';
	}
	

	var oInputDivs=getElementsByClass('input_div');
	for (var i = 0; i < oInputDivs.length; i++) {
		oInputDivs[i].index=i;
		oInputDivs[i].readonly=true;
		if(i!=0)
		{
			oInputDivs[i].children[0].onclick=function(){
				this.style.border='2px solid #e3c94c';
				this.readonly=false;
				this.style.cursor='text';
			}
		}
	}
	oInputDivs[1].children[0].onclick=function(){
		this.type='text';
		this.value='';
		this.style.border='2px solid #e3c94c';
		this.readonly=false;
		this.style.cursor='text';
	}

	/*点击修改个人信息时，提交服务器*/
	oUpdateBtn.onclick=function(){
		action.value='modify';
	}

	oSelectSubmit.onclick=function(){
		action.value='select';
	}
	
	for (var i = 0; i < oSecond_menu_li.length; i++)
	{
		oSecond_menu_li[i].position=i;
	}

	for (var i = 0; i < oSecond_menu_li.length; i++) {
		oSecond_menu_li[i].onclick=function(){
			for (var j = 0; j < oTable.length; j++) {
				oTable[j].style.display='none';
			}
			index_div.style.display='none';
			oTable[this.position].style.display='block';
			split.parentNode.parentNode.style.display='block';
			$('#main_left').height(parseInt($(document).height())-parseInt($('#header').height())+'px');
		}
	}
	


	

	function getStyle(obj,attr){
		return obj.currentStyle?parseInt(obj.currentStyle[attr]):parseInt(getComputedStyle(obj)[attr]);
	}

	function getElementsByClass(className)
	{
		var aEls=document.getElementsByTagName('*');
		var arrEls=[];
		var str;
		for(var i=0;i<aEls.length;i++)
		{
			str=aEls[i].className.split(' ');
			for (var j = 0; j < str.length; j++) {
				if(str[j]==className)
				{
					arrEls.push(aEls[i]);
				}
			}
		}
		return arrEls;
	}
}