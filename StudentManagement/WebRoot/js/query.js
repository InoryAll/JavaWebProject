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
	var oForm=document.getElementById('queryForm');
	var preA=document.getElementById('prePage');
	var nextA=document.getElementById('nextPage');
	var oStart=document.getElementById('start');
	var othisPage=document.getElementById('nowPage');
	var pages=document.getElementById('pages');
	var interval=3;
	
	preA.onclick=function(){
		if(othisPage.value==1)
		{
			preA.disabled=true;
		}
		else
		{
			preA.disabled=false;
			othisPage.value=parseInt(othisPage.value)-1;
			oStart.value=parseInt(oStart.value)-interval;
			oForm.submit();
			
		}	
	}
	
	nextA.onclick=function(){
		
		if(othisPage.value==pages.value)
		{
			nextA.disabled=true;
		}
		else
		{
			nextA.disabled=false;
			othisPage.value=parseInt(othisPage.value)+1;
			oStart.value=parseInt(oStart.value)+interval;
			oForm.submit();
		}
		
		
	}
	/*end animate*/
	
}

/*end course*/

