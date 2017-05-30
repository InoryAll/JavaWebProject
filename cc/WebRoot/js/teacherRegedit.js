$(document).ready(function() {
	setUpload();
	upload();
	setDatePicker();
});

function setDatePicker(){
	$('#datepicker').datepicker({
		dateFormat:"yy-mm-dd",
		changeYear:true,
        yearSuffix: '年',
        showMonthAfterYear:true,
        defaultDate:'1990-06-01',  
        monthNames: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],  
        dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],  
        dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],  
        dayNamesMin: ['日','一','二','三','四','五','六'],
        yearRange:'1900:+50'
	});
}

function setUpload(){
	$('.upload_btn').on('click',function(){
		$('.upload').click();
	});
}

function upload(){
	$('.upload').on('change', function(ev) {
		var reg=/image+/g;
		var reader=new FileReader();
		var img=new Image();
		reader.onload=function (ev) {
				img.src=ev.target.result;		
				if(reg.test(imageFile.type.toLowerCase())&&(imageFile.size<40960))
				{
					var imgWidth;
					var imgHeight;
					img.onload=function(){
						imgWidth=img.width;
						imgHeight=img.height;
						$('.header').attr('src', ev.target.result);
						/*console.log(imageFile+' '+img.width+' '+img.height+' '+img.src);*/
						if (imgWidth>=130&&imgWidth<=150&&imgHeight>=170&&imgHeight<=190) {	
							$('.header').attr('src', ev.target.result);
						}
						else{
							$('.header').attr('src', '');
							$('.header').attr('alt', '照片像素不符合要求');
							
						}
					}
				}
				else{
					if(imageFile.size>40960)
					{
						$('.header').attr('src', '');
						$('.header').attr('alt', '文件大小偏大');
					}
					else{
						$('.header').attr('src', '');
						$('.header').attr('alt', '照片格式不对');
					}
				}
			}

		var imageFile = this.files[0];
        reader.readAsDataURL(imageFile);
	});
}