<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta name="description" content="Bootstrap Admin App + jQuery">
   <meta name="keywords" content="app, responsive, jquery, bootstrap, dashboard, admin">
  <title>聚合数据平台</title>
  <link rel="shortcut icon" type="image/png" href="<%=request.getContextPath()%>/index/img/favicon.png">
  
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
               <a href="http://127.0.0.1:8080/">
                  <img src="<%=request.getContextPath()%>/index/img/logo.png" alt="Image" class="block-center img-rounded"></a>
            </div>
            <div class="panel-body" id="forgotPasswordPage">
               <p class="text-center pv">重置密码</p>
               <form id="form" data-parsley-validate="true" onsubmit="return false" novalidate="">
               	  <p class="text-center pv">请填写您的登录邮箱来收取密码重置邮件</p>
                  <div class="form-group has-feedback">
                     <input id="email" name="email" type="email" placeholder="输入邮箱" class="form-control" v-model="email" data-parsley-required-message="请输入邮箱地址" data-parsley-type-message="请输入正确的邮箱地址" required="required" data-parsley-id="4">
                     <span class="fa fa-envelope form-control-feedback text-muted"></span>
                  </div>
                  <button id="sendEmailButton" onclick="sendEmail();" class="btn btn-block btn-primary mt-lg">发送重置邮件</button>
               </form>
               <p></p>
               <div id="errorMsg" class="alert alert-danger text-center" style="display:none;"></div>
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
 

</body></html>