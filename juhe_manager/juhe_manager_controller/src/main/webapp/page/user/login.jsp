<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0027)http://127.0.0.1:8080/login -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="description" content="Bootstrap Admin App + jQuery">
  <meta name="keywords" content="app, responsive, jquery, bootstrap, dashboard, admin">
  <title>聚合数据平台</title>
  <link rel="shortcut icon" type="image/png" href="<%=request.getContextPath()%>/index/img/favicon.png">
 
  <link rel="stylesheet" href="<%=request.getContextPath()%>/index/vendor/fontawesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/index/vendor/simple-line-icons/css/simple-line-icons.css">
  <link rel="stylesheet" id="bscss" href="<%=request.getContextPath()%>/index/media/css/bootstrap.css">
  <link rel="stylesheet" id="maincss" href="<%=request.getContextPath()%>/index/media/css/app.css">
  <link rel="stylesheet" id="maincss" href="<%=request.getContextPath()%>/index/media/css/theme-i.css">
 </head>
  <body>
    <div class="wrapper">
      <div class="block-center mt-xl wd-xl">
         <div class="panel panel-dark panel-flat">
            <div class="panel-heading text-center">
               <a href="<%=request.getContextPath()%>/index">
                  <img src="<%=request.getContextPath()%>/index/img/logo.png" alt="Image" class="block-center img-rounded">
               </a>
            </div>
            <div class="panel-body" id="loginPage">
               <p class="text-center pv">请登录</p>
               <form id="form" data-parsley-validate="true" onsubmit="return false" novalidate="">
                  <div class="form-group has-feedback">
                     <input type="text" placeholder="邮箱地址或登录名称" v-model="username" class="form-control" data-parsley-error-message="请输入邮箱地址或登录名称" required="required" data-parsley-id="4">
                     <span class="fa fa-envelope form-control-feedback text-muted"></span>
                  </div>
                  <div class="form-group has-feedback">
                     <input type="password" placeholder="密码"  v-model="password" class="form-control" data-parsley-error-message="请输入密码" required="required" data-parsley-id="6">
                     <span class="fa fa-lock form-control-feedback text-muted"></span>
                  </div>
                  <div class="clearfix">
                     <div class="pull-right">
                        <a href="<%=request.getContextPath()%>/forgotPassword" class="text-muted">忘记密码？</a>
                     </div>
                  </div>
                  <button v-on:click="login"  class="btn btn-block btn-primary mt-lg">登录</button>
               </form>
              
               <p></p>
               <div id="errorMsg" class="alert alert-danger text-center" style="display:none;"></div>
               <p class="pt-lg text-center">需要注册？</p>
               <a href="<%=request.getContextPath()%>/register" class="btn btn-block btn-default">现在就注册</a>
            </div>
         </div>
         <div class="p-lg text-center">
            <span>©</span>
            <span>2017</span>
            <span>-</span>
            <span>DOUBLE</span>
            <br>
            <span>934590736@qq.com</span>
         </div>
      </div>
   </div>
   <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
	 <script type="text/javascript" src="<%=request.getContextPath()%>/index/vendor/parsleyjs/dist/parsley.min.js"></script> 
  <script type='text/javascript'>
        var loginPage = new Vue({
            el: '#loginPage',
            data: {
                'username': '',
                'password': ''
            },
            methods: {
            	login: function(event){
            		var ok = $('#form').parsley().isValid({force: true});
            		if(!ok){
            			return;
            		}
            		var datas={
            				 userName: this.username,
            				 passWord: this.password
	            	};
                     $.ajax({
                         type: 'POST',
                         data: datas,
                         url: '<%=request.getContextPath()%>/user/login',
                         success:function(result) {
                         	if(result.success) {
                         		window.location.href = "<%=request.getContextPath()%>/home";
                         	} else {
                         		 $("#errorMsg").html(result.errorMessage);
              	    		  	 $("#errorMsg").show();
                         	}
                         }
                   });
                     
                }
            }
        })
    </script>

</body></html>