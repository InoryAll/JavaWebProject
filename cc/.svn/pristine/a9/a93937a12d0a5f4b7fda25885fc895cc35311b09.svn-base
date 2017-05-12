/*login.js*/

window.onload=function(){
	var oHead=document.getElementById('header');
	var oMain=document.getElementById('main');
	var oFooter=document.getElementById('footer');
	var oPicTabBox=document.getElementById('picTab_box');
	var oScrollTab=document.getElementById('scrollTab');
	var oLoginTable=document.getElementById('login_table');
	var preHeight;
	var oHeightChange;
	var oForm=document.getElementById('login_form');
	var oLogin_btn=document.getElementById('login_btn');
	var oExit=document.getElementById('exit');
	var oAstudent_user=document.getElementById('student_user');
	var oAteacher_user=document.getElementById('teacher_user');
	var oUser=document.getElementById('user');
	var oUl=document.getElementById('picTab');
	var oScrollUl=document.getElementById('scrollTab');
	var aScrollLi=oScrollUl.getElementsByTagName('li');
	var preScroll=0;
	var aInput=oForm.getElementsByTagName('input');
	var aCheckElement=[];
	var oMessage=document.getElementById('message');
	var oReturnMessage=document.getElementById('ReturnMessage');
	initWindow();

	

	for (var i = 0; i < aInput.length; i++) {
		if(aInput[i].type=='text'||aInput[i].type=='password')
		{
			aCheckElement.push(aInput[i]);
		}
	}

	if (aCheckElement[0].value.length<6||aCheckElement[1].value.length<6) {
		oMessage.innerHTML='';
		oLogin_btn.style.background='#c8d2d8';
		oLogin_btn.disabled=true;
	}
	else
	{
			oMessage.innerHTML='';
			oLogin_btn.style.background='#428bca';
			oLogin_btn.disabled=false;
	}


	for(var i=0;i<aCheckElement.length;i++)
	{
		aCheckElement[i].index=i;
		aCheckElement[i].value='';
		aCheckElement[i].onfocus=function(){
			aCheckElement[this.index].parentNode.style.border='2px solid #e3c94c';
			oReturnMessage.innerHTML='';
		}
		aCheckElement[i].onblur=function(){
			aCheckElement[this.index].parentNode.style.border='2px solid #d5d5d5';
		}
		aCheckElement[i].oninput=function(){
			if (aCheckElement[0].value.length<6||aCheckElement[1].value.length<6) {
				oMessage.innerHTML='输入的格式有误';
				oLogin_btn.style.background='#c8d2d8';
				oLogin_btn.disabled=true;
			}
			else
			{
				oMessage.innerHTML='';
				oLogin_btn.style.background='#428bca';
				oLogin_btn.disabled=false;
			}
		}
	}
	

	oForm.onsubmit=function(){
		$('input[name=password]').val(hex_md5($('input[name=password]').val()));
		return check();
	}


	window.onresize=function(){
		initWindow();
	}

	var start=getStyle(oUl,'left');
	var end=getStyle(oUl,'width')*(-1)*2/3;
	var interval=end/2;
	var pre=start;
	var tag=true;
	var num=0;

	for(var i=0;i<aScrollLi.length;i++)
	{
		aScrollLi[i].index=i;
		aScrollLi[i].onclick=function(){
			aScrollLi[preScroll].style.background='#94a59c';
			aScrollLi[this.index].style.background='#438eb9';
			if(this.index>preScroll)
			{
				pre+=interval;
				num++;
			}
			else
			{
				pre-=interval;
				num--;
			}
			preScroll=this.index;
			oUl.style.left=this.index*interval+'px';
		}
	}

	aScrollLi[preScroll].style.background='#438eb9';
	setInterval(function(){
		if(pre>end&&tag)
		{
			pre+=interval;
			aScrollLi[preScroll].style.background='#94a59c';
			doMove(oUl,'left',30,pre);
			num++;
			preScroll=num;
			aScrollLi[preScroll].style.background='#438eb9';
		}
		else
		{
			tag=false;
		}
		if(pre<start&&tag==false)
		{ 
				pre-=interval;
				aScrollLi[preScroll].style.background='#94a59c';
				doMove(oUl,'left',30,pre);
				num--;
				preScroll=num;
				aScrollLi[preScroll].style.background='#438eb9';

		}
		else
		{
			tag=true;
		}
			
	},3000);

	function check(){
		if(aCheckElement[0].value.length<6||aCheckElement[1].value.length<6)
		{
			oMessage.innerHTML='输入的格式有误';
			return false;
		}
		else
		{
			return true;
		}
	}

	function doMove(obj,attr,dire,target,endFn){
		var speed;
		clearInterval(obj.timer);
		if(getStyle(obj,attr)>target)
			dire=-dire;
		obj.timer=setInterval(function(){
			speed=getStyle(obj,attr)+dire;
			if((speed>target&&dire>0)||(speed<target&&dire<0))
			{
				speed=target;
			}
			obj.style[attr]=speed+'px';
			if(speed==target)
			{
				clearInterval(obj.timer);
				endFn&&endFn();
			}
		},50);
	}

	function getStyle(obj,attr){
		return obj.currentStyle?parseInt(obj.currentStyle[attr]):parseInt(getComputedStyle(obj)[attr]);
	}

	function initWindow(){
		preHeight=getStyle(oMain,'height');
		oMain.style.height=document.documentElement.offsetHeight-getStyle(oHead,'height')-getStyle(oFooter,'height')+'px';
		oHeightChange=getStyle(oMain,'height')-preHeight;
		oPicTabBox.style.top=getStyle(oPicTabBox,'top')+oHeightChange/2+'px';
		oScrollTab.style.bottom=getStyle(oScrollTab,'bottom')-oHeightChange/2+'px';
		oLoginTable.style.top=getStyle(oLoginTable,'top')+oHeightChange/2+'px';
	}
}

