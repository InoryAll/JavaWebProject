<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="utf-8">
  	<meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>ChatRoom</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="js/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="js/vendor/bootstrap/css/bootstrap-theme.css">
  </head>
  <body>
    <header>
    	<div class="container">
        <div class="row">
          <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="container-fluid login-detail clearfix">
              <div class="pic">
                <img src="img/head1.jpg" class="img-responsive">
              </div>
              <div class="detail">
                <p>Name</p>
                <a href="javascript:;" id="exit">退出</a>
              </div>
            </div>
          </div>
          <div class="col-md-4 col-sm-12 col-xs-12 userdiv">
           	<h3 class="text-center">请您先登录！</h3>
           	<button type="button" class="btn btn-default center-block" data-toggle="modal" data-target="#myModal" id="login-action">登录</button>
          </div>
        </div> 
      </div>
    </header>
    <div class="container">
    	<div class="row">
    		<div class="col-md-4 user-info hidden-sm hidden-xs">
    			<div class="container-fluid user-detail">
    				<h3 class="text-center">会话</h3>
    				<div class="item-box">
    					<div class="item clearfix">
    						<div class="pic">
    							<img src="img/head2.jpg" class="img-responsive">
    						</div>
    						<div class="detail">
    							<p>Knightly<span>(卞靖)</span></p>
    						</div>
    					</div>
    					<div class="item clearfix">
    						<div class="pic">
    							<img src="img/head3.jpg" class="img-responsive">
    						</div>
    						<div class="detail">
    							<p>Cinderela<span>(哇哈)</span></p>
    						</div>
    					</div>
    				</div>
    				<div class="tool-box">
    					<div class="tool-item">
    						<span class="glyphicon glyphicon-user text-center"></span>
    					</div><div class="tool-item">
    						<span class="glyphicon glyphicon-cog text-center"></span>
    					</div><div class="tool-item">
    						<span class="glyphicon glyphicon-refresh text-center"></span>
    					</div><div class="tool-item">
    						<span class="glyphicon glyphicon-repeat text-center"></span>
    					</div>
    				</div>
    			</div>
    		</div>
    		<div class="col-md-8 chat-info col-sm-12 col-xs-12">
    			<h3 class="header text-center">
    				当前会话
    			</h3>
    			<div class="main">
            <div class="main-container">
              <div class="main-box">
                <div class="item left clearfix">
                  <span class="name">我是玩家</span>
                  <span class="time">2017-2-13 15:11:22</span>
                  <span class="content">你好，我是一个好人</span>
                </div>
                <div class="item right clearfix">
                  <span class="time">2017-2-13 15:11:23</span>
                  <span class="name">我是玩家</span>
                  <span class="content">你好，我也是一个好人</span>
                </div>
                   <div class="item left clearfix">
                  <span class="name">我是玩家</span>
                  <span class="time">2017-2-13 15:12:22</span>
                  <span class="content">让我们开始聊天吧~</span>
                </div>
                <div class="item right clearfix">
                  <span class="time">2017-2-13 15:12:23</span>
                  <span class="name">我是玩家</span>
                  <span class="content">好的，好的~</span>
                </div>
              </div>
            </div>
    			</div>
    			<div class="footer clearfix">
    				<div class="inputbox">
    					<input type="text" name="message" class="form-control" id="message">
    				</div>
    				<div class="inputbtn">
    					<button type="button" class="btn btn-info btn-block" id="send" data-toggle="tooltip" data-placement="left" title="请您登陆！">发送</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <footer>
      <div class="container">
      	<p>
      		<em>2017-2-13 欢迎光临chatroom系统</em>
      	</p>
      </div>
    </footer>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">登录</h4>
          </div>
          <div class="modal-body">
            <form id="loginform" action="#" method="post">
              <div class="form-group has-feedback">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="请填写您的用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
              </div>
              <div class="form-group has-feedback">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="请填写您的密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
              </div>
              <div class="form-group">
                <p class="help-block"></p>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary" id="login-btn">登录</button>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript" src="js/vendor/jquery-3.1.1.min.js"></script>
  <script type="text/javascript" src="js/vendor/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/main.js"></script>
</html>