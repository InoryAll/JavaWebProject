<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page 
    	import="com.model.*"
    	import="com.args.Constant"
    	import="java.util.List"%>
    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>优创导师网</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
</head>

<body>
	<div id="header_box">
		<div id="header">
			<h1 class="logo">
				优创导师网
			</h1>
			<a class="user" href="javascript:;">
				欢迎您,${loginUser.name}用户
			</a>
		</div>
	</div>
	<div id="main_box">
		<form action="#" method="po
		st" id="index_form" name="index_form">
		<!--隐藏的hidden域，用来记录操作类型-->
		<input type="hidden" name="action" id="action" value=${action}>
			<div id="main">
				<div id="main_left">
					<ul id="list">
						<li class="first_li">
							<a href="${pageContext.request.contextPath}/user/UserAction?action=logout" class="re_login">
								注销
							</a>
							<a href="${pageContext.request.contextPath}/user/regedit.jsp" class="go_regedit">
								注册
							</a>
						</li>
						<li class="first_menu">
							<span class="menu_1">
								<img src="${pageContext.request.contextPath}/images/menu1.png">
								基本信息查询
							</span>
							<ul class="second_menu">
								<li id="search">			
									|---查看个人信息
								</li>
							</ul>
						</li>
						<li class="first_menu">
							<span class="menu_2">
							<img src="${pageContext.request.contextPath}/images/menu2.png">
								学生选课
							</span>
							<ul class="second_menu">
								<li  id="select">
									|---选课
								</li>
								<li  id="query">
									|---查看已选课程
								</li>
							</ul>
						</li>
						<li class="last_li first_menu">
							<span class="menu_3">
							<img src="${pageContext.request.contextPath}/images/menu3.png">
								课程评价
							</span>
							<ul class="second_menu">
								<li id="judge">
									|---评价
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<div id="main_right">
					<div class="top_menu" id="top_menu">
						<span id="location">
							首页
						</span>
					</div>

					<div id="index_div">
						Hello World!
					</div>
						<table class="search_table" id="search_table">
							<thead></thead>
							<tbody>
								<tr>
									<td>
										<p class="tip">* 单击以进行修改,注意:用户名无法进行修改</p>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											用户:
										</span>
										<div class="input_div id_div">
											<input type="text" name="id" readonly="true"  
											value="" >
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											密码:
										</span>
										<div class="input_div">
											<input type="password" name="password" 
											value="">
										</div>								
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											姓名:
										</span>
										<div class="input_div">
											<input type="text" name="name" 
											value="">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											性别:
										</span>
										<span class="radio_span">
											<input type="radio" name="gender" checked value="男">&nbsp;&nbsp;男
										</span>
										<span class="radio_span">
											<input type="radio" name="gender" value="女">&nbsp;&nbsp;女
										</span>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											邮箱:
										</span>
										<div class="input_div">
											<input type="text" name="email" 
											value="">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											电话:
										</span>
										<div class="input_div">
											<input type="text" name="tel" 
											value="">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											院系:
										</span>
										<div class="select_div">
											<select class="select_list">
												<option>信息工程学院</option>
												<option>机械学院</option>
												<option>物理学院</option>
											</select>
										</div>	
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											专业:
										</span>
										<div class="select_div">
											<select class="select_list">
												<option>软件工程</option>
												<option>计算机科学与技术</option>
												<option>通信工程</option>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<span class="input_span">
											班级:
										</span>
										<div class="select_div">
											<select class="select_list">
												<option>141</option>
												<option>142</option>
												<option>143</option>
											</select>
										</div>
									</td>
								</tr>
							<tr class="last_tr">
								<td>
									<input type="button" name="" value="修改" id="regedit_btn">
									<a href="${pageContext.request.contextPath}/user/student.jsp" id="back_to_home">返回</a>
								</td>
							</tr>
						</tbody>
					</table>

						<table class="search_table select_table" id="select_table">
							<thead></thead>
							<tbody>
								<tr class="first_tr">
									<td colspan="6">
										选课
									</td>
								</tr>
								<tr>
									<td colspan="3" id="query_info">
										<select id="CourseName" name="CourseName" class="query_select">
											<option value='0'>请选择课程名</option>
										</select>
										<select id="TeacherName" name="TeacherName" class="query_select">
											<option value='0'>请选择教师名</option>
										</select>
									</td>
									<td colspan="3" id="query_place">
										<div class="search_btn_div">
											<input type="text" name="" placeholder="按课程名搜索">
										</div>
										<a href="javascript:;" class="search_btn">搜索</a>
									</td>
								</tr>
								<tr>
									<th>课程号</th>
									<th>课程名</th>
									<th>教师号</th>
									<th>教师名</th>
									<th>上课时间</th>
									<th>是否选课</th>
								</tr>
								
								<tr id="query_last">
									<td colspan="6">
										<a href="${pageContext.request.contextPath}/user/student.jsp" id="select_back_home">返回</a>
										<input type="button"  name="" value="提交" id="select_submit">
									</td>
								</tr>
							</tbody>
						</table>

					
					<table class="search_table query_table" id="query_table">
						<thead></thead>
						<tbody>
							<tr class="first_tr">
								<td colspan="6">
								已选课程
								</td>
							</tr>
							<tr>
								<th>课程号</th>
								<th>课程名</th>
								<th>教师号</th>
								<th>教师名</th>
								<th>上课时间</th>
								<th>退选</th>
							</tr>
							
							<tr id="query_last">
								<td colspan="6">
									<a href="${pageContext.request.contextPath}/user/student.jsp" id="query_back_home">返回</a>
								</td>
							</tr>
						</tbody>
					</table>

					<table class="search_table judge_table" id="judge_table">
						<thead></thead>
						<tbody>
							<tr class="first_tr">
								<td colspan="6">
								评教
								</td>
							</tr>
							<tr>
								<th>课程号</th>
								<th>课程名</th>
								<th>教师号</th>
								<th>教师名</th>
								<th>上课时间</th>
								<th>评教</th>
							</tr>
							
							<tr id="query_last">
								<td colspan="6">
									<a href="${pageContext.request.contextPath}/user/student.jsp" id="judge_back_home">返回</a>
								</td>
							</tr>
						</tbody>
					</table>
						

					<div id="footer_box">

						<div id="footer">
							<div class="split_bottom"></div>
							<p id="copy">
							</p>
						</div>
					</div>
					
					<div id="delete_div">
						<span>您确定要退选么？</span>
						<input type="hidden" name="delete_item" id="delete_item" value=''>
						<input type="button" name="" id="delete_confirm" value="确定">
						<input type="button" id="delete_concel" value="取消">
					</div>
					
					<div id="judge_div">
						<span class="judge_title">请对此课程作评价</span>
						<input type="hidden" name="judge_item" id="judge_item" value=''>
						<input type="hidden" name="judge_detail" id="judge_detail" value=''> 
						<span class="judge_teacher">教师：</span>
						<span class="judge_course">课程：</span>
						<div class="judge_area">
							<span>教师本人知识丰富程度：</span>
							<ul>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
							</ul>
						</div>
						<div class="judge_area">
							<span>教师课堂表现力：</span>
							<ul>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
							</ul>
						</div>
						<div class="judge_area">
							<span>内容实用性：</span>
							<ul>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
							</ul>
						</div>
						<div class="judge_area">
							<span>课堂的交互性：</span>
							<ul>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/images/star.png">
								</li>
							</ul>
						</div>
						<div class="judge_area">
							<textarea cols="50" rows="2" placeholder="请输入你的额外评价内容" name="extra_content"></textarea>
						</div>
						<input type="button" value="提交" id="judge_submit">
						<input type="button" value="取消" id="judge_cancel">
					</div>
					
					<div class="teacherInfoDiv">
						<table>
							<tr>
								<td>
									姓名：
									<span class="name">
										姜海峰
									</span>
								</td>
								<td rowspan="3">
									<img src="" alt="正在载入图像..." class="head">
								</td>
							</tr>
							<tr>
								<td colspan="2">
									性别：
									<span class="gender">
										<input type="radio" value="男" name="_gender" readonly="true">&nbsp;男
										&nbsp;&nbsp;
										<input type="radio" value="女" name="_gender" readonly="true">&nbsp;女
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									民族：
									<span class="nation">
										汉
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									部门：
									<span class="department">
										大连大学
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									QQ：
									<span class="onlinetool">
									111111111111
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									邮箱：
									<span class="email">
									11111@qq.com
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									职称：
									<span class="title">
									6456464
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									擅长领域：
									<span class="goodfield">
									132313132
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									简介：
									<p class="info">
									11111111111111111111111111111111111111
									</p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" value="取消">
								</td>
							</tr>
						</table>
					</div>
					
					<div class="courseInfoDiv">
						<table>
							<tr>
								<td>
									课程名：
									<span class="name">
										1111
									</span>
								</td>
							</tr>
							<tr>
								<td>
									上课时间：
									<span class="date">
										111111111
									</span>
								</td>
							</tr>
							<tr>
								<td>
									课程简介：
									<span class="info">
										11111111111
									</span>
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" value="取消">
								</td>
							</tr>
						</table>
					</div>	
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<script>
	var flag=false; 
	var basePath="${pageContext.request.contextPath}";
	$(document).ready(function(){
		/*右侧菜单图片显示问题*/
		var oSecond_menu=$('.second_menu');
		for(var i=0;i<oSecond_menu.length;i++){
			for(var j=0;j<oSecond_menu[i].children.length;j++)
			{
				oSecond_menu[i].children[j].index=j;
				oSecond_menu[i].children[j].onmouseover=function(){
					this.style.color='#2b7dbc';
					this.style.background='url(\''+basePath+'/images/menu_select.png\') no-repeat #f5f7fa 192px 7px';
					this.style.borderLeft='2px solid #c86139';
				}
				oSecond_menu[i].children[j].onmouseout=function(){
					this.style.color='#585858';
					this.style.background='#fff';
					this.style.borderLeft='none';
				}
			}
		}
		
		/*查看个人信息*/
 		$('#search').on('mousedown',function(){
			$.ajax({
				url:basePath+'/user/StudentAction',
				data:{
					action:'modify',
					first:'true'
				},
				type:'POST',
				success:function(data){
					data=JSON.parse(data);
					$('input[name=id]').val(data.id);
					$('input[name=password]').val(data.password);
					$('input[name=name]').val(data.name);
					if(data.gender=='男')
					{
						$('input[value=男]').attr('checked','true');
					}
					else
					{
						$('input[value=女]').attr('checked','true');
					}
					$('input[name=email]').val(data.email);
					$('input[name=tel]').val(data.tel);
					for(var i=0;i<$('.select_list').eq(0).find('option').length;i++)
					{
						if($('.select_list').eq(0).find('option').eq(i).html()==data.department)
						{
							$('.select_list').eq(0).find('option').eq(i).attr('selected',true);
						}
					}
					var classic;
					var classes;
					var pre=data.classes.split(' ');
					classic=pre[0];
					classes=pre[1];
					for(var i=0;i<$('.select_list').eq(1).find('option').length;i++)
					{
						if($('.select_list').eq(1).find('option').eq(i).html()==classic)
						{
							$('.select_list').eq(1).find('option').eq(i).attr('selected',true);
						}
					}
					for(var i=0;i<$('.select_list').eq(2).find('option').length;i++)
					{
						if($('.select_list').eq(2).find('option').eq(i).html()==classes)
						{
							$('.select_list').eq(2).find('option').eq(i).attr('selected',true);
						}
					}
				},
				error:function(error){
				}
			});
		});
		
		/*修改个人信息*/
		$('#regedit_btn').on('mousedown',function(){
			$('input[name=password]').val(hex_md5($('input[name=password]').val()));
			$.ajax({
				url:basePath+'/user/StudentAction',
				data:{
					action:'modify',
					first:'false',
					id:$('input[name=id]').val(),
					name:$('input[name=name]').val(),
					password:$('input[name=password]').val(),
					gender:$('input:radio:checked').val(),
					email:$('input[name=email]').val(),
					tel:$('input[name=tel]').val(),
					department:$('.select_list:eq(0) option:selected').text(),
					classes:$('.select_list:eq(1) option:selected').text()+' '+$('.select_list:eq(2) option:selected').text()
				},
				type:'POST',
				success:function(data){
					data=JSON.parse(data);
					$('.tip').html(data.message);
					$('input[name=id]').val(data.id);
					$('input[name=password]').val(data.password);
					$('input[name=password]').attr('type', 'password');
					$('input[name=name]').val(data.name);
					if(data.gender=='男')
					{
						$('input[value=男]').attr('checked','true');
					}
					else
					{
						$('input[value=女]').attr('checked','true');
					}
					$('input[name=email]').val(data.email);
					$('input[name=tel]').val(data.tel);
					for(var i=0;i<$('.select_list').eq(0).find('option').length;i++)
					{
						if($('.select_list').eq(0).find('option').eq(i).html()==data.depatment)
						{
							$('.select_list').eq(0).find('option').eq(i).attr('selected',true);
						}
					}
					var classic;
					var classes;
					var pre=data.classes.split(' ');
					classic=pre[0];
					classes=pre[1];
					for(var i=0;i<$('.select_list').eq(1).find('option').length;i++)
					{
						if($('.select_list').eq(1).find('option').eq(i).html()==classic)
						{
							$('.select_list').eq(1).find('option').eq(i).attr('selected',true);
						}
					}
					for(var i=0;i<$('.select_list').eq(2).find('option').length;i++)
					{
						if($('.select_list').eq(2).find('option').eq(i).html()==classes)
						{
							$('.select_list').eq(2).find('option').eq(i).attr('selected',true);
						}
					}
				},
				error:function(error){
					
				}
			});
		});
		
		/*预加载*/
		$('#select').on('mousedown',function(){
			$('#TeacherName option[value!=0]').remove();
			$('#CourseName option[value!=0]').remove();
			$.ajax({
				url:basePath+'/course/CourseAction',
				type:'POST',
				data:{
					action:'query',
					first:'true'
				},
				success:function(data){
					data=JSON.parse(data);
					var teacherHtml=$('#TeacherName').html();
					var courseHtml=$('#CourseName').html();
					for(var i=0;i<data.TeacherNames.length;i++)
					{						
						teacherHtml+='<option>'+data.TeacherNames[i]+'</option>';	
					}
					for(var i=0;i<data.CourseNames.length;i++)
					{
						courseHtml+='<option>'+data.CourseNames[i]+'</option>';
					}
					$('#TeacherName').html(teacherHtml);
					$('#CourseName').html(courseHtml);
				},
				error:function(error){
					
				}
			});	
		});
		
		/*查询课程*/
		$('.search_btn').on('click',function(){
			var CourseName;
			var TeacherName;
			CourseName=$('#CourseName option:selected').val()==0?CourseName=' ':CourseName=$('#CourseName option:selected').text();
			TeacherName=$('#TeacherName option:selected').val()==0?TeacherName=' ':TeacherName=$('#TeacherName option:selected').text();
			$('#select_table .single').remove();
			$('#select_table .double').remove();
			$.ajax({
				url:basePath+'/course/CourseAction',
				type:'POST',
				data:{
					action:'query',
					first:'false',
					CourseName:CourseName,
					TeacherName:TeacherName
				},
				success:function(data){
					data=JSON.parse(data);
					for(var i=0;i<data.CourseResult.length;i++)
					{
						var targetNode=$('#query_last');		
						if(i%2!=0)
						{
							var insertNode=$('<tr class="single"><td>'+data.CourseResult[i].id+'</td><td><a href="javascript:;" class="courseInfo">'+data.CourseResult[i].name+'</a></td><td>'+data.CourseResult[i].teacherId+'</td><td><a href="javascript:;" class="teacherInfo">'+data.CourseResult[i].teacherName+'</a></td><td>'+data.CourseResult[i].date+'</td><td><input type="checkbox" id="lesson" name="lesson" value="'+data.CourseResult[i].id+' '+data.CourseResult[i].date+'"></td></tr>');
						}
						else
						{
							var insertNode=$('<tr class="double"><td>'+data.CourseResult[i].id+'</td><td><a href="javascript:;" class="courseInfo">'+data.CourseResult[i].name+'</a></td><td>'+data.CourseResult[i].teacherId+'</td><td><a href="javascript:;" class="teacherInfo">'+data.CourseResult[i].teacherName+'</a></td><td>'+data.CourseResult[i].date+'</td><td><input type="checkbox" id="lesson" name="lesson" value="'+data.CourseResult[i].id+' '+data.CourseResult[i].date+'"></td></tr>');
						}
						
						insertNode.insertBefore(targetNode);
					}
					
					/*教师悬浮div*/
					$('.teacherInfo').click(function(){
						$('.teacherInfoDiv').css('left',(parseInt($(window).outerWidth())/2-parseInt($('.teacherInfoDiv').css('width'))/2-200)+'px'); 
						if((parseInt($(window).outerHeight())-parseInt($('.teacherInfoDiv').css('height'))-100)>0)
						{
							$('.teacherInfoDiv').css('top',(parseInt($(window).outerHeight())/2-parseInt($('.teacherInfoDiv').css('height'))/2-100)+'px');
						}
						else
						{
							$('.teacherInfoDiv').css('top',100+'px');
						}
						$('.search_table').css('opacity','0.1');
						$('.teacherInfoDiv').css('display','block');
						$.ajax({
							url:basePath+'/user/StudentAction',
							type:'POST',
							data:{
								action:'getteacher',
								first:'true',
								teacherId:parseInt(this.parentNode.parentNode.children[2].innerHTML)
							},
							success:function(data){
								data=JSON.parse(data);
								$('.name').html(data.name);
								data.gender=='男'?$('.gender input:eq(0)').attr('checked',true):$('.gender input:eq(1)'.attr('checked',true));
								$('.nation').html(data.nation);
								$('.department').html(data.department);
								$('.onlinetool').html(data.onlinetool);
								$('.email').html(data.email);
								$('.title').html(data.title);
								$('.goodfield').html(data.goodfield);
								$('.info').html(data.info);
								$('.head').attr('src',basePath+'/head/'+data.image);
							},
							error:function(error){
								
							}
						});
						
					});
					
					/*课程悬浮div*/
					$('.courseInfo').click(function(){
						$('.courseInfoDiv').css('left',(parseInt($(window).outerWidth())/2-parseInt($('.teacherInfoDiv').css('width'))/2-200)+'px'); 
						if(parseInt($(window).outerHeight())-parseInt($('.teacherInfoDiv').css('height'))>0)
						{
							$('.courseInfoDiv').css('top',(parseInt($(window).outerHeight())/2-parseInt($('.teacherInfoDiv').css('height'))/2-100)+'px');
						}
						else
						{
							$('.courseInfoDiv').css('top',100+'px');
						}
						$('.search_table').css('opacity','0.1');
						$('.courseInfoDiv').css('display','block');
						$.ajax({
							url:basePath+'/user/StudentAction',
							type:'POST',
							data:{
								action:'getcourse',
								first:'true',
								courseId:parseInt(this.parentNode.parentNode.children[0].innerHTML)
							},
							success:function(data){
								data=JSON.parse(data);
								$('.name').html(data.name);
								$('.date').html(data.date);
								$('.info').html(data.info);
							},
							error:function(error){
								
							}
						});
						
					});
					
				},
				error:function(error){
					
				}
			});
		});
		
		/*选课*/
		$('#select_submit').on('click',function(){
			var  course='';
			var courseArr=$('input[type=checkbox]:checked');
			var preCourse=[];
			if(courseArr.length>0){
				for(var i=0;i<courseArr.length;i++)
				{
					preCourse=courseArr[i].value.split(' ');
					if(i==courseArr.length-1)
					{
						course+=''+preCourse[0]+','+preCourse[1]+'';
					}
					else
					{
						course+=''+preCourse[0]+','+preCourse[1]+''+' ';
					}
				}
				$.ajax({
					url:basePath+'/course/CourseAction',
					type:'POST',
					data:{
						action:'select',
						courseId:course,
						first:'false'
					},
					success:function(data){
							data=JSON.parse(data);
							if(data.code==1)
							{
								alert(data.message);
								for(var i=0;i<courseArr.length;i++)
								{
									preCourse=courseArr[i];
									preCourse.parentNode.parentNode.remove();
								}
							}
							else
							{
								alert(data.message);
							}
					},
					error:function(error){
						
					}
				});
			}
		});  	
		
		
		/*查看已选课程*/
		$('#query').on('mousedown',function(){
			$('.query_table .single').remove();
			$('.query_table .double').remove();
			$.ajax({
				url:basePath+'/course/CourseAction',
				data:{
					action:'querysel',
					first:'true',
				},
				type:'POST',
				success:function(data){
					data=JSON.parse(data);
					var courseArr=data.queryResult;
					var insertNode='';
					var targetNode=$('.query_table #query_last');
					for(var i=0;i<courseArr.length;i++)
					{
						var course=courseArr[i]; 
						if(i%2!=0)
						{
							insertNode=$('<tr class="single"><td>'+course.id+'</td><td>'+course.name+'</td><td>'+course.teacherId+'</td><td>'+course.teacherName+'</td><td>'+course.date+'</td><td><a href="javascript:;" class="do_delete">退选</a></td></tr>');
						}
						else
						{
							insertNode=$('<tr class="double"><td>'+course.id+'</td><td>'+course.name+'</td><td>'+course.teacherId+'</td><td>'+course.teacherName+'</td><td>'+course.date+'</td><td><a href="javascript:;" class="do_delete">退选</a></td></tr>');
						}
						insertNode.insertBefore(targetNode);
					}
					
					oDeleteDiv=document.getElementById('delete_div');
					oDeleteA=$('.do_delete');
					delete_item=document.getElementById('delete_item');
					oRight=document.getElementById('main_right');
					oTable=$('.search_table');
					var reg=/\d+/g;
					for (var i = 0; i < oDeleteA.length; i++) {
						oDeleteA.eq(i).click(function(){
							var delete_message=(this.parentNode.parentNode.children[0].innerHTML).match(reg);
							var scrollTop=document.body.scrollTop||document.documentElement.scrollTop;
							oDeleteDiv.style.display='block';
							oDeleteDiv.style.left=Math.round((oRight.offsetWidth-oDeleteDiv.offsetWidth)/2)+'px';
							oDeleteDiv.style.top=Math.round((oRight.offsetHeight-oDeleteDiv.offsetHeight)/2+scrollTop)+'px';
							oTable.eq(0).css('opacity',0.3);
							oTable.eq(1).css('opacity',0.3);
							oTable.eq(2).css('opacity',0.3);
							oTable.eq(3).css('opacity',0.3); 
							oDeleteDiv.style.opacity='1';
							delete_item.value=delete_message;
						});
					}
				},
				error:function(error){
					
				}
			});
		});	
		
		/*退选课程*/
		
		var oDeleteDiv=document.getElementById('delete_div');
		var oTable=$('.search_table');
		$('#delete_concel').get(0).onclick=function(){
			oDeleteDiv.style.display='none';
			oTable.eq(0).css('opacity',1);
			oTable.eq(1).css('opacity',1);
			oTable.eq(2).css('opacity',1);
			oTable.eq(3).css('opacity',1); 
			oDeleteDiv.style.opacity='1';
		}
		$('#delete_confirm').get(0).onclick=function(){
			$.ajax({
				url:basePath+'/course/CourseAction',
				type:'POST',
				data:{
					action:'back',
					first:'true',
					delete_item:$('#delete_item').val()
				},
				success:function(data){
					data=JSON.parse(data);
					if(data.code==1)
					{
						alert(data.message);
					}
					else
					{
						alert('退选失败!');
					}
					oDeleteDiv.style.display='none';
					oTable.eq(0).css('opacity',1);
					oTable.eq(1).css('opacity',1);
					oTable.eq(2).css('opacity',1);
					oTable.eq(3).css('opacity',1); 
					oDeleteDiv.style.opacity='1';
					for(var i=0;i<$('.query_table td').length;i++)
					{
						if($('.query_table td').eq(i).html()==$('#delete_item').val())
						{
							$('.query_table td').eq(i).parent().remove();
						}
					}
				},
				error:function(error){
				
				}							
			});
		}
		
		/*学生评教*/
		
		var judge_detail_arr=[0,0,0,0];
		var judge_detail_str='';
		var judge_detail=document.getElementById('judge_detail');
		var judge_item=document.getElementById('judge_item');
		var oJudgeDiv=document.getElementById('judge_div');
		$('#judge').on('mousedown',function(){
			$('#judge_table .single').remove();
			$('#judge_table .double').remove();
			$.ajax({
				url:basePath+'/course/CourseAction',
				type:'POST',
				data:{
					first:'true',
					action:'judge'
				},
				success:function(data){
					
					data=JSON.parse(data);
					var courseArr=data.queryResult;
					var insertNode='';
					var targetNode=$('.judge_table #query_last');
					for(var i=0;i<courseArr.length;i++)
					{
						var course=courseArr[i]; 
						if(i%2!=0)
						{
							insertNode=$('<tr class="single"><td>'+course.id+'</td><td>'+course.name+'</td><td>'+course.teacherId+'</td><td>'+course.teacherName+'</td><td>'+course.date+'</td><td><a href="javascript:;" class="do_judge">评价</a></td></tr>');
						}
						else
						{
							insertNode=$('<tr class="double"><td>'+course.id+'</td><td>'+course.name+'</td><td>'+course.teacherId+'</td><td>'+course.teacherName+'</td><td>'+course.date+'</td><td><a href="javascript:;" class="do_judge">评价</a></td></tr>');
						}
						insertNode.insertBefore(targetNode);
					}
					
					
					
					var oTable=$('.search_table');
					var oRight=document.getElementById('main_right');		
					var oJudgeArea=$('.judge_area');
					var oJudgeA=$('.do_judge');	
					var judge_submit=document.getElementById('judge_submit');
					var judge_cancel=document.getElementById('judge_cancel');
				
					
				
					var reg=/\d+/g;
					
					for (var i = 0; i < oJudgeArea.length; i++) {
						var str=0;
						var oJudgeLi=oJudgeArea.eq(i).get(0).getElementsByTagName('li');
						setJudgeStyle(oJudgeLi,str,i);
					}
					
					/*点击评价时显示评价窗口，课号+' '+教师号,存储在变量judge_item中*/
					
					for (var i = 0; i < oJudgeA.length; i++) {
						oJudgeA.eq(i).get(0).onclick=function(){
							var judge_message=(this.parentNode.parentNode.children[0].innerHTML).match(reg);
							var scrollTop=document.body.scrollTop||document.documentElement.scrollTop;
							oJudgeDiv.style.display='block';
							oJudgeDiv.style.left=Math.round((oRight.offsetWidth-oJudgeDiv.offsetWidth)/2)+'px';
							oJudgeDiv.style.top=Math.round((oRight.offsetHeight-oJudgeDiv.offsetHeight)/2+scrollTop)+'px';
							if(parseInt(oJudgeDiv.style.top)>20)
							{
								oJudgeDiv.style.top=20+'px';
							}
							oTable.eq(0).css('opacity',0.3);
							oTable.eq(1).css('opacity',0.3);
							oTable.eq(2).css('opacity',0.3);
							oTable.eq(3).css('opacity',0.3);
							oJudgeDiv.style.opacity='1';
							judge_item.value=judge_message;
							$('textarea').val('');
							$('.judge_teacher').html('教师:	'+this.parentNode.parentNode.children[3].innerHTML);
							$('.judge_course').html('课程:	'+this.parentNode.parentNode.children[1].innerHTML);
						}
					}
				},
				error:function(error){
					
				}
			});
		});
		
		
		var judge_submit=document.getElementById('judge_submit');
		var judge_cancel=document.getElementById('judge_cancel');
		var oTable=$('.search_table');
		judge_cancel.onclick=function(){
			oJudgeDiv.style.display='none';
			oTable.eq(0).css('opacity',1);
			oTable.eq(1).css('opacity',1);
			oTable.eq(2).css('opacity',1);
			oTable.eq(3).css('opacity',1); 
			oJudgeDiv.style.opacity='1';
		}
	
		judge_submit.onclick=function(){
			judge_detail_str=judge_detail_arr.join(' ');
			judge_detail.value=judge_detail_str;
			$.ajax({
				url:basePath+'/course/CourseAction',
				type:'POST',
				data:{
					first:'false',
					action:'judge',
					judge_item:$('#judge_item').val(),
					judge_detail:$('#judge_detail').val(),
					extra_content:$('textarea').val()
				},
				success:function(data){
					data=JSON.parse(data);
					if(data.code==1)
					{
						alert(data.message);
					}
					oJudgeDiv.style.display='none';
					oTable.eq(0).css('opacity',1);
					oTable.eq(1).css('opacity',1);
					oTable.eq(2).css('opacity',1);
					oTable.eq(3).css('opacity',1); 
					oJudgeDiv.style.opacity='1';
					
					for(var i=0;i<$('.judge_area img').length;i++)
					{
						$('.judge_area img').eq(i).attr('src',basePath+'/images/star.png');
					}
					
					for(var i=0;i<$('.judge_table td').length;i++)
					{
						if($('.judge_table td').eq(i).html()==$('#judge_item').val())
						{
							$('.judge_table td').eq(i).parent().remove();
						}
					}
									
				},
				error:function(error){
					
				}
			});
		}
		
		
		/*评教函数*/
		function setJudgeStyle(obj,str,index){
			for (var i = 0; i < obj.length; i++) {
				var _click=-1;
				obj[i].index=i;
				obj[i].onmouseover=function(){
					for(var j=0;j<=this.index;j++)
					{
						var img=obj[j].getElementsByTagName('img')[0];
						img.src=basePath+'/images/starhover.png';
					}
					for(var j=this.index+1;j<obj.length;j++)
					{
						var img=obj[j].getElementsByTagName('img')[0];
						img.src=basePath+'/images/star.png';
					}
				}
				obj[i].onclick=function(){
					_click=this.index;
					str=_click+1;
					for(var j=0;j<=this.index;j++)
					{
						var img=obj[j].getElementsByTagName('img')[0];
						img.src=basePath+'/images/starhover.png';
					}
					judge_detail_arr[index]=str;
				}
				obj[i].onmouseout=function(){
					if (_click<0) {
						for (var j = 0; j < obj.length; j++) {
							var img=obj[j].getElementsByTagName('img')[0];
							img.src=basePath+'/images/star.png';
						}
					}
					else
					{
						for(var j=0;j<=_click;j++)
						{
							var img=obj[j].getElementsByTagName('img')[0];
							img.src=basePath+'/images/starhover.png';
						}
						for(var j=_click+1;j<obj.length;j++)
						{
							var img=obj[j].getElementsByTagName('img')[0];
							img.src=basePath+'/images/star.png';
						}
					}
				}
			}
		}
		
		/*查看教师信息*/
		$('.teacherInfoDiv input[type=button]').click(function(){
			$('.search_table').css('opacity','1');
			$('.teacherInfoDiv').css('display','none');
			
		});
		
		/*查看课程信息*/
		$('.courseInfoDiv input[type=button]').click(function(){
			$('.search_table').css('opacity','1');
			$('.courseInfoDiv').css('display','none');
			
		});

		
	});
</script>
</body>
</html>