/*course.js style*/

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
	
	
	/*end animate*/
	var textLook=[];
	var textHeight=[];
	var textAttitude=[];
	var textWay=[];
	var textAtmos=[];
	var student_judge_table=getElementsByClass('student_judge_table')[0];
	for(var i=0;i<student_judge_table.getElementsByTagName('tr').length-3;i++)
	{
		textLook.push(document.getElementById("textLook"+i));
		textHeight.push(document.getElementById("textHeight"+i));
		textAttitude.push(document.getElementById("textAttitude"+i));
		textWay.push(document.getElementById("textWay"+i));
		textAtmos.push(document.getElementById("textAtmos"+i));
	}
	
	for(var i=0;i<textLook.length;i++)
	{
		textLook[i].style.display='none';
		textHeight[i].style.display='none';
		textAttitude[i].style.display='none';
		textWay[i].style.display='none';
		textAtmos[i].style.display='none';
		
		textLook[i].style.width='70px';
		textHeight[i].style.width='70px';
		textAttitude[i].style.width='70px';
		textWay[i].style.width='70px';
		textAtmos[i].style.width='70px';
	}
	
	var aSelect=student_judge_table.getElementsByTagName('select');
	for(var i=0;i<aSelect.length;i++)
	{
		aSelect[i].onchange=function(){
			if(this.options[this.selectedIndex].value=='C'||this.options[this.selectedIndex].value=='D')
			{
				this.nextElementSibling.style.display="inline";
				this.nextElementSibling.focus();
			}
			else
			{
				this.nextElementSibling.style.display="none";
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
	
	
}

/*end course*/

