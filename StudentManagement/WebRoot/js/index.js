/*index.js style*/

/*onload style*/

/*end style*/

/*a link style*/
window.onload=function(){


	
	document.getElementById('menu').onclick=function(){
			/* way 1.0 */

			/*
			document.getElementById('hide_content_box').style.display="block";
			document.getElementById('header').style.display="none";
			document.getElementById('main').style.display="none";
			document.getElementById('footer').style.display="none";
			document.getElementById('body').style.width="100%";
			document.getElementById('body').style.height="100%";
			document.getElementById('html').style.width="100%";
			document.getElementById('html').style.height="100%";
			document.getElementById('body').style.overflow="none";
			document.getElementById('html').style.overflow="none";
			*/

			/* end way 1.0 */

			/*way 2.0*/
			document.getElementById('hide_content_box').style.transition="top 0.5s linear 0s";
			document.getElementById('hide_content_box').style.top="0%";
			document.getElementById('body').style.width="100%";
			document.getElementById('body').style.height="100%";
			document.getElementById('html').style.width="100%";
			document.getElementById('html').style.height="100%";
			document.getElementById('body').style.overflow="none";
			document.getElementById('html').style.overflow="none";
			document.getElementById('header').style.opacity="0.5";
			document.getElementById('main').style.opacity="0.5";
			document.getElementById('footer').style.opacity="0.5";
			/*end way 2.0*/
			
	}

	document.getElementById('exit').onclick=function(){
			/* way 1.0 */

			/*
			document.getElementById('hide_content_box').style.display="none";
			document.getElementById('header').style.display="block";
			document.getElementById('main').style.display="block";
			document.getElementById('footer').style.display="block";
			document.getElementById('body').style.width="100%";
			document.getElementById('body').style.height="100%";
			document.getElementById('html').style.width="100%";
			document.getElementById('html').style.height="100%";
			document.getElementById('body').style.overflow="visible";
			document.getElementById('html').style.overflow="visible";
			*/

			/* end way 1.0 */

			/*way 2.0*/
			document.getElementById('hide_content_box').style.transition="top 0.5s linear 0s";
			document.getElementById('hide_content_box').style.top="-100%";
			document.getElementById('body').style.width="100%";
			document.getElementById('body').style.height="100%";
			document.getElementById('html').style.width="100%";
			document.getElementById('html').style.height="100%";
			document.getElementById('body').style.overflow="visible";
			document.getElementById('html').style.overflow="visible";
			document.getElementById('header').style.opacity="1";
			document.getElementById('main').style.opacity="1";
			document.getElementById('footer').style.opacity="1";
			/*end way 2.0*/
			
	}
	/*end a link*/

	/*animate style*/
	document.getElementById('precious').onmouseover=function(){
		document.getElementById('precious').style.transform="scale(1.2,1.2)";
	}
	document.getElementById('precious').onmouseout=function(){
		document.getElementById('precious').style.transform="scale(1,1)";
	}
	document.getElementById('next').onmouseover=function(){
		document.getElementById('next').style.transform="scale(1.2,1.2)";
	}
	document.getElementById('next').onmouseout=function(){
		document.getElementById('next').style.transform="scale(1,1)";
	}
	document.getElementById('top').onmouseover=function(){
		document.getElementById('top').style.transform="scale(1.5,1.5)";
	}
	document.getElementById('top').onmouseout=function(){
		document.getElementById('top').style.transform="scale(1,1)";
	}

	document.getElementById('go_to_regedit').onclick=function(){
		document.getElementById('init_form').submit();
	}
	/*end animate*/

	/*change state*/
	document.getElementById('student_search_btn').onclick=function(){
		document.getElementById('action').value="query_course";
		document.getElementById('init_form').submit();
	}
	document.getElementById('student_select_btn').onclick=function(){
		document.getElementById('action').value="select_course";
		document.getElementById('init_form').submit();
	}
	document.getElementById('student_judgement_btn').onclick=function(){
		document.getElementById('action').value="judgement";
		document.getElementById('init_form').submit();
	}
	/*end change*/
	var precious=document.getElementById('precious');
	var next=document.getElementById('next');
	var oLi=getElementsByClass('item1')[0];
	var num=0;
	var timer=null;
	var PicUrl=['images/map.png','images/devices.png','images/photoshop.png','images/tools.png'];
	timer=setInterval(function(){
		num%=4;
		oLi.style.background='url(\"'+PicUrl[num]+'\")'+'no-repeat center 85%';
		oLi.style.backgroundSize='750px 450px';
		num++;
	},2000);

	
	precious.onclick=function(){
		num--;
		if(num<0)
			num=3;
		num%=4;
		oLi.style.background='url(\"'+PicUrl[num]+'\")'+'no-repeat center 85%';
		oLi.style.backgroundSize='750px 450px';
	}
	next.onclick=function(){
		num++;
		num%=4;
		oLi.style.background='url(\"'+PicUrl[num]+'\")'+'no-repeat center 85%';
		oLi.style.backgroundSize='750px 450px';
	}

	doMove(getElementsByClass('top_container')[0],'marginTop',20,50);
	
	window.onscroll=function(){
		var oScrollTop=document.documentElement.scrollTop;
		if(oScrollTop>=0&&oScrollTop<=200){
			doMove(getElementsByClass('top_container')[0],'marginTop',20,50);
		}
		if (oScrollTop>=450&&oScrollTop<=550) {
			doMove(getElementsByClass('top_container')[0],'marginTop',20,-230);
			doMove(getElementsByClass('student_search_pic')[0],'paddingLeft',20,60);
		}
		if(oScrollTop>=950&&oScrollTop<=1050){
			doMove(getElementsByClass('student_search_pic')[0],'paddingLeft',20,0,function(){
				doMove(getElementsByClass('student_select_pic')[0],'paddingLeft',20,10);
			});
		}
		if (oScrollTop>=1450&&oScrollTop<=1550) {
			doMove(getElementsByClass('student_select_pic')[0],'paddingLeft',20,76,function(){
				doMove(getElementsByClass('student_judgement_pic')[0],'paddingLeft',20,60);
			});	
		}
		if(oScrollTop>=1950&&oScrollTop<=2050)
		{
			doMove(getElementsByClass('student_judgement_pic')[0],'paddingLeft',20,0);
		}

	}
	
	
	var student_search_btn=document.getElementById('student_search_btn');
	var student_select_btn=document.getElementById('student_select_btn');
	var student_judgement_btn=document.getElementById('student_judgement_btn');

	

	
	student_search_btn.onmouseover=function(){
		doShake(getElementsByClass('student_search_pic')[0],'paddingLeft');
	}
	student_select_btn.onmouseover=function(){
		doShake(getElementsByClass('student_select_pic')[0],'paddingLeft');
	}
	student_judgement_btn.onmouseover=function(){
		doShake(getElementsByClass('student_judgement_pic')[0],'paddingLeft');
	}

	function doShake(obj,attr,endfn){
		if(!obj.isOn)
		{
			var shakeArr=[];
			var num=0;
			var pos;
			for (var i = 10; i > 0; i--) {
				shakeArr.push(i,-i);
			}
			shakeArr.push(0);
			obj.shake=setInterval(function(){
				obj.isOn=true;
				if (num>=shakeArr.length) 
				{
					num=shakeArr.length-1;
				}
				pos=getStyle(obj,attr)+shakeArr[num];
				obj.style[attr]=pos+'px';
				if(num==shakeArr.length-1)
				{
					clearInterval(obj.shake);
					obj.isOn=false;
					endfn&&endfn();
				}
				num++;
			},50);
		}
	}


	function doMove(obj,attr,dire,targets,endfn){
		var speed;
		clearInterval(obj.timer);
		if(getStyle(obj,attr)>targets)
			dire=-dire;
		obj.timer=setInterval(function(){
			speed=getStyle(obj,attr)+dire;
			if((speed>targets&&dire>0)||(speed<targets&&dire<0))
				speed=targets;
			obj.style[attr]=speed+'px';
			if(speed==targets)
			{
				clearInterval(obj.timer);
				endfn&&endfn();
			}
		},30);
	}

	function getStyle(obj,attr){
		return obj.currentStyle?parseInt(obj.currentStyle[attr]):parseInt(getComputedStyle(obj)[attr]);
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
}





/*end index*/