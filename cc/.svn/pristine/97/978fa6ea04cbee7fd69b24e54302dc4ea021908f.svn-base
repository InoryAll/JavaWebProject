$(document).ready(function() {
	setUpload();
	upload();
});

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