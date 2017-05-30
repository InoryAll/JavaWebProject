<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/regedit.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/jquery-ui.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/teacherRegedit.css">
</head>
<body>
	<div id="header_box">
		<div id="header">
			<h1 class="logo">
				优创导师网
			</h1>
		</div>
	</div>
	<div id="main_box">
		<div id="main">
			<form method="post" action="#" id="regedit_form" enctype="multipart/form-data">
				<input type="hidden" name="action" id="action" value="register">
				<input type="hidden" name="isSucceed" id="isSucceed" value=1>
				<input type="hidden" name="first" value="true">
				<input type="hidden" name="encodePassword" value="">
				<div id="table_box">
					<div class="title">
					<p>注&nbsp;册</p>
					</div>
					<ul id="nav">
						<li>
							<div class="step_circle active">1</div>
							<div class="linear linear_right active"></div>
							<div class="info font_active">填写用户名以及密码</div>
						</li>
						<li>
							<div class="linear linear_left"></div>
							<div class="step_circle">2</div>
							<div class="linear linear_right"></div>
							<div class="info">填写基本信息</div>
						</li>
						<li>
							<div class="linear linear_left"></div>
							<div class="step_circle">3</div>
							<div class="info">完成注册</div>
						</li>
					</ul>
					<div class="split">
					</div>
					<div class="img-box">
						<img src="" alt="图片大小小于2M且为140*180像素" class="header">
						<input type="button" value="上传照片" class="upload_btn">
						<input type="file" class="upload" name="image">
					</div>
					<table id="regedit_table1">
						<thead>	
						</thead>
						<tbody>	
							<tr>
								<td>
									<p class="tip">
										请注意:带*的项目为必填项目
									</p>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										用户名:
									</span>
									<div id="input_div">
										<input type="text" name="id" placeholder="请输入手机号作为账号"  id="stu_id">
									</div>
									<span class="input_tip">
										* 使用手机号作为账号
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										姓名:
									</span>
									<div id="input_div">
										<input type="text" name="name" placeholder="输入你的姓名" id="stu_name">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										密码:
									</span>
									<div id="input_div">
										<input type="password" name="password" placeholder="输入你的密码" id="stu_password">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										重新输入:
									</span>
									<div id="input_div">
										<input type="password" name="re_password" placeholder="再次输入你的密码">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<div>
										<span class="input_span">
											性别:
										</span>
										<span class="radio_span">
											<input type="radio" name="gender" checked value="男">&nbsp;&nbsp;男
										</span>
										<span class="radio_span female">
											<input type="radio" name="gender" value="女">&nbsp;&nbsp;女
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										出生日期:
									</span>
									<div id="input_div">
										<input type="text" name="birthday" placeholder="输入日期,例:1996-06-01" id="datepicker">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<div>
										<span class="input_span">
											 导师类别:
										</span>
										<span class="radio_span">
											<input type="radio" name="tags" checked value="0">&nbsp;&nbsp;校内
										</span>
										<span class="radio_span female">
											<input type="radio" name="tags" value="1">&nbsp;&nbsp;校外
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										工作单位:
									</span>
									<div id="input_div">
										<input type="text" name="department" placeholder="输入你的工作单位" id="department">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										QQ或微信:
									</span>
									<div id="input_div">
										<input type="text" name="onlinetool" placeholder="输入QQ或微信" id="onlinetool">
									</div>
									<span class="input_tip">
										
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										民族:
									</span>
									<div id="input_div">
										<input type="text" name="nation" placeholder="输入民族，加上'族'字" id="nation">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										毕业院校:
									</span>
									<div id="input_div">
										<input type="text" name="gschool" placeholder="输入毕业院校" id="gschool">
									</div>
									<span class="input_tip">
										
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										所学专业:
									</span>
									<div id="input_div">
										<input type="text" name="major" placeholder="输入所学专业" id="major">
									</div>
									<span class="input_tip">
										
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<a href="javascript:;" class="pre">上一页</a>
									<a href="javascript:;" class="next">下一页</a>
								</td>
							</tr>
						</tbody>
					</table>
					<table id="regedit_table2">
						<thead>	
						</thead>
						<tbody>	
							<tr>
								<td>
									<span class="input_span">
										邮箱:
									</span>
									<div id="input_div">
										<input type="text" name="email" placeholder="输入你的邮箱" id="stu_email">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										职务:
									</span>
									<div id="input_div">
										<input type="text" name="post" placeholder="输入职务" id="post">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										职称:
									</span>
									<div id="input_div">
										<input type="text" name="title" placeholder="输入你的职称" id="title">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span class="input_span">
										擅长领域:
									</span>
									<div id="input_div">
										<input type="text" name="goodfield" placeholder="输入你的擅长领域" id="goodfield">
									</div>
									<span class="input_tip">
										*
									</span>
								</td>
							</tr>
							<tr class="info-tr">
								<td class="info-td clearfix">
									<span class="input_span info-style">
										创新创业教育工作或创业工作简历:
									</span>
									<textarea name="info1" class="info-intro" cols="10" rows="20" placeholder=""></textarea>
								</td>	
							</tr>
							<tr class="info-tr">
								<td class="info-td clearfix">
									<span class="input_span info-style">
										近年来在创新创业教育方面所获成果和奖励:
									</span>
									<textarea name="info2" class="info-intro" cols="10" rows="20" placeholder=""></textarea>
								</td>	
							</tr>
							<tr class="info-tr">
								<td class="info-td clearfix">
									<span class="input_span info-style">
										近年来担任国家级、省级、校级、创新创业教育方面项目评审专家、社会兼职情况:
									</span>
									<textarea name="info3" class="info-intro" cols="10" rows="20" placeholder=""></textarea>
								</td>	
							</tr>
							<tr>
								<td>
									<a href="javascript:;" class="pre">上一页</a>
									<input type="button" value="注册" id="submit_btn">
								</td>
							</tr>
						</tbody>
					</table>
					<table id="regedit_table3">
						<thead>	
						</thead>
						<tbody>	
							<tr>
								<td>
									<span id="success_message">
										注册成功
									</span>
									<span id="failed_message">
										注册失败
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<span id="message">
										
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<a href="${pageContext.request.contextPath}/user/teacherRegedit.jsp" id="back_to_regedit">返回注册</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="${pageContext.request.contextPath}/user/login.jsp" id="back_to_login">返回登录</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
		</div>
	</div>
	<div id="footer_box">
		<div id="footer">
			<div class="split_bottom">
			</div>
			<p id="copy">
			</p>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/regedit.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/teacherRegedit.js"></script>
<script>
	var basePath="${pageContext.request.contextPath}";
	$(document).ready(function() {
		$('#submit_btn').on('click',function(){

			var reg=/^1\d{10}$/g;
			if (reg.test($('input[name=id]').val())==false){
				alert('手机号限定11位，且首位为1');
				return;
			}

			if ($('input[name=name]').val().length<2){
				alert('姓名长度不能小于2位');
				return;
			}

			if ($('input[name=password]').val().length<6||$('input[name=re_password]').val().length<6) {
				alert('密码的长度不得小于6位');
				return;
			}

			if ($('input[name=password]').val()!=$('input[name=re_password]').val()) {
				alert('两次输入的密码不一致');
				return;
			}

			reg=/^\d{4}\-\d{1,2}\-\d{1,2}$/;
			if (reg.test($('input[name=birthday]').val())==false){
				alert('生日的格式不正确,应为XXXX-XX-XX');
				return;
			}

			if ($('input[name=post]').val().length<2){
				alert('请填写正确的职务');
				return;
			}

			if ($('input[name=nation]').val().length<2){
				alert('民族长度不能小于2位，请注意加上\'族\'字');
				return;
			}

			reg=/^\w+@\S{5,20}$/g;
			if (reg.test($('input[name=email]').val())==false){
				alert('邮箱格式不正确');
				return;
			}

			if ($('input[name=title]').val().length<2){
				alert('请填写完整职称');
				return;
			}

			if ($('input[name=department]').val()<2){
				alert('请填写完整部门');
				return;
			}

			if ($('input[name=goodfield]').val()<2){
				alert('请填写擅长领域');
				return;
			}


			$('#message').html('');

			$('input[name=password]').val(hex_md5($('input[name=password]').val()));

			$('#regedit_form').ajaxSubmit({
				url:basePath+'/user/TeacherAction',
				type:'POST',
				success:function(data){
					data=JSON.parse(data);
					data=data.ReturnMessage;
					if (data){
						$('#regedit_table1').css('display','none');
						$('#regedit_table2').css('display','none');
						$('#regedit_table3').css('display','block');
						initPageNew(3);
						$('.img-box').css('display', 'none');
						if (data=='注册成功') {
							$('#success_message').css('display','block');
							$('#failed_message').css('display','none');	
						}
						else
						{
							$('#success_message').css('display','none');
							$('#failed_message').css('display','block');
							$('#message').html(data);
						}
					}
					else
					{
						$('#success_message').css('display','none');
						$('#failed_message').css('display','block');
						$('#message').html(data);
					}
				}
			});
		});
	});
</script>
</html>