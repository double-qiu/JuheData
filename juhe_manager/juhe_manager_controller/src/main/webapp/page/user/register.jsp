<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0069)file:///C:/Users/Administrator/Desktop/favoritesUI/home/register.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta name="description" content="Bootstrap Admin App + jQuery">
   <meta name="keywords" content="app, responsive, jquery, bootstrap, dashboard, admin">
   <title>云收藏 | 让收藏更简单</title>
   
</head><body>

      <link rel="stylesheet" href="<%=request.getContextPath()%>/index/vendor/fontawesome/css/font-awesome.min.css">
	  <link rel="stylesheet" href="<%=request.getContextPath()%>/index/vendor/simple-line-icons/css/simple-line-icons.css">
	  <link rel="stylesheet" id="bscss" href="<%=request.getContextPath()%>/index/media/css/bootstrap.css">
	  <link rel="stylesheet" id="maincss" href="<%=request.getContextPath()%>/index/media/css/app.css">
	  <link rel="stylesheet" id="maincss" href="<%=request.getContextPath()%>/index/media/css/theme-i.css">

   <div class="wrapper">
      <div class="block-center mt-xl wd-xl">
         <div class="panel panel-dark panel-flat">
            <div class="panel-heading text-center">
               <a href="http://127.0.0.1:8080/index">
                  <img src="<%=request.getContextPath()%>/index/img/logo.png" alt="Image" class="block-center img-rounded"></a>
            </div>
            <div class="panel-body" id="registPage">
               <p class="text-center pv">快速注册新用户</p>
               <form id="form" data-parsley-validate="true" onsubmit="return false" novalidate="">
                  <div class="form-group has-feedback">
                     <label for="signupInputEmail1" class="text-muted">登录邮箱</label>
                     <input id="signupInputEmail1" type="email" placeholder="输入邮箱地址" class="form-control" v-model="email"   data-parsley-required-message="请输入邮箱地址" data-parsley-type-message="请输入正确的邮箱地址" required="required" data-parsley-id="4">
                     <span class="fa fa-envelope form-control-feedback text-muted"></span>
                  </div>
                  <div class="form-group has-feedback">
                     <label for="signupInputEmail1" class="text-muted">登录名称</label>
                     <input id="signupInputEmail1" type="text" placeholder="我们该如何称呼您？" class="form-control" v-model="userName"   data-parsley-required-message="请输入登录名称" required="required" data-parsley-id="6">
                     <span class="fa fa-user form-control-feedback text-muted"></span>
                  </div>
                  <div class="form-group has-feedback">
                     <label for="signupInputPassword" class="text-muted">密码</label>
                     <input id="signupInputPassword" type="password" placeholder="密码" class="form-control"  v-model="password"   required="required" data-parsley-required-message="请输入密码" pattern="/^(?![0-9]+$)(?![a-zA-Z]+$)(?![^0-9a-zA-Z]+$)\S{6,20}$/" data-parsley-pattern-message="请输入6-20位字母数字组合" data-parsley-id="8">
                     <span class="fa fa-lock form-control-feedback text-muted"></span>
                  </div>
                  <button v-on:click="regist" class="btn btn-block btn-primary mt-lg">创建账户</button>
               </form>
               <p></p>
               <div id="errorMsg" class="alert alert-danger text-center" style="display:none;"></div>
               <p class="pt-lg text-center">已经有账户？</p>
               <a href="<%=request.getContextPath()%>/login" class="btn btn-block btn-default">登录</a>
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
	<script type="text/javascript" >
   	var registPage = new Vue({
   	  		el: '#registPage',
            data: {
            	 'email': '',
                 'password': '',
                 'userName':''
            },
            methods: {
            	regist: function(event){
            		var ok = $('#form').parsley().isValid({force: true});
            		if(!ok){
            			return;
            		}
            		var datas={
            				 email: this.email,
            				 passWord: this.password,
            				 userName: this.userName
	            	};
            	$.ajax({
                         type: 'POST',
                         data: datas,
                         url: '<%=request.getContextPath()%>/user/register',
                         success:function(result) {
                         	if(result.success) {
                         		window.location.href = "<%=request.getContextPath()%>/login";
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