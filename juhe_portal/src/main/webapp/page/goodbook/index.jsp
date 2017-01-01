<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>图书商城-首页</title>
<link href="<%=request.getContextPath()%>/layui/css/layui.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/layui/css/main.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"/>
</head>
<body class="layui-body-gbook">
<style>
a, a:hover {
   text-decoration: none;
}

</style>
<div class="layui-header header header-index">
	<div class="layui-main">
		<a class="logo" href="/">
	      <img src="images/logo.png" alt="layui">
	    </a>
		<ul class="layui-nav">
		  <li class="layui-nav-item"><a href="">最新活动</a></li>
		  <li class="layui-nav-item layui-this">
		    <a href="">产品</a>
		    <dl class="layui-nav-child">
		      <dd><a href="" style="height:30px;padding-top: 5px;">选项1</a></dd>
		      <dd><a href="" style="height:30px;padding-top: 5px;">选项2</a></dd>
		      <dd><a href="" style="height:30px;padding-top: 5px;">选项3</a></dd>
		    </dl>
		  </li>
		  <li class="layui-nav-item"><a href="">大数据</a></li>
		  <li class="layui-nav-item">
		    <a href="javascript:;">解决方案</a>
		    <dl class="layui-nav-child">
		      <dd><a href="" style="height:30px;padding-top: 5px;">移动模块</a></dd>
		      <dd><a href="" style="height:30px;padding-top: 5px;">后台模版</a></dd>
		      <dd><a href="" style="height:30px;padding-top: 5px;">电商平台</a></dd>
		    </dl>
		  </li>
		  <li class="layui-nav-item"><a href="">社区</a></li>
		</ul>
		<form action="#search" class="layui-search">
			<i class="layui-icon icon-sousuo" style="font-size: 24px; color: #1E9FFF;">&#xe615;</i>
			<input class="layui-input" autocomplete="off" placeholder="搜索内容，回车跳转" type="text" name="q">
		</form>
	</div>
</div>

<div class="layui-main">
	<blockquote class="layui-elem-quote layui-mt">
    我是天空里的一片云， 
	偶尔投影在你的波心，
	你不必讶异， 
	更无须欢喜，
	在转瞬间消灭了踪影。 
	你我相逢在黑夜的海上， 
	你有你的方向，我有我的方向， 
	你记得也好， 
	最好你忘掉， 
	在这交会时互放的光亮
    </blockquote>
</div>

<div class="layui-main">
	<!-- 文章开始 -->
	<div class="row ">
                  
                        <div class=" col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/1.jpeg" alt="">
                                <div>
                                    <h4><a href="#">梦里花落知多少</a></h4>
                                </div>
                                <div class="text-center">
                                    <div class="inside">
                                        <h4><a href="#">中国文学 散文</a></h4>
                                        <p>三毛散文集：《梦里花落知多少》</p>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/2.jpeg" alt="">
                                <div>
                                    <h4><a href="#">明朝那些事儿</a></h4>
                                </div>
                                <div>
                                        <h4><a href="#">中国文学 历史 小说</a></h4>
                                        <p>当时明月经典著作：《明朝那些事儿》</p>                                    
                                </div>
                            </div>
                        </div> 
                        <div class=" col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/3.jpeg" alt="">
                                <div >
                                    <h4><a href="#">于丹：重温最美古诗词</a></h4>
                                </div>
                                <div >                     
                                        <h4><a href="#">中国文学 散文</a></h4>
                                        <p>《于丹：重温最美古诗词》</p>
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/4.jpeg" alt="">
                                <div>
                                    <h4><a href="#">许三观卖血记</a></h4>
                                </div>
                                <div>                                
                                     <h4><a href="#">中国文学 小说</a></h4>
                                     <p>余华巨著：《许三观卖血记》</p>  
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/5.jpeg" alt="">
                                <div>
                                    <h4><a href="#">世间所有相遇都是久别重逢</a></h4>
                                </div>
                                <div>    
                                        <h4><a href="#">中国文学 散文</a></h4>
                                        <p>《世间所有相遇都是久别重逢》</p>
                                </div>
                            </div>
                        </div> 
                        <div class=" col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/6.jpeg" alt="">
                                <div>
                                    <h4><a href="#">京华烟云</a></h4>
                                </div>
                                <div>     
                                        <h4><a href="#">中国文学 小说 经典名著</a></h4>
                                        <p>现代版“红楼梦”：《京华烟云》</p>
                                   
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/7.jpeg" alt="">
                                <div>
                                    <h4><a href="#">倾城之恋</a></h4>
                                </div>
                                <div >       
                                        <h4><a href="#">中国文学 小说</a></h4>
                                        <p>张爱玲著名小说：《倾城之恋》</p>
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/8.jpeg" alt="">
                                <div>
                                    <h4><a href="#">人生"</a></h4>
                                </div>
                               
                                 <div>
                                         
                                        <h4><a href="#">中国文学 小说 经典名著</a></h4>
                                        <p>路遥经典著作：《人生》</p>
                                   
                                 </div>
                            </div>
                        </div> 
                        <div class="col-md-4 col-sm-6">
                            <div class="text-center">
                                <img src="images/9.jpeg" alt="">
                                <div>
                                    <h4><a href="#">青铜葵花</a></h4>
                                </div>
                                <div>
										<h4><a href="#">中国文学 儿童文学 小说</a></h4>
                                        <p>美丽的痛苦，诗意的苦难：《青铜葵花》</p>
                                   
                                </div>
                            </div>
                        </div> 
                   
                </div>
	
	<div id="page" class="text-center"></div>

</div>

<div class="layui-footer footer-index">
  <div class="layui-main">
    <p>2016 © <a href="/">layui.com</a> LGPL license</p>
    <p>
      <a href="http://fly.layui.com/jie/3147.html" target="_blank">捐赠作者</a>
      <a href="mailto:xianxin@layui.com">广告联系</a>
      <a href="https://github.com/sentsin/layui/" target="_blank">Git仓库</a>
      <a href="http://weibo.com/SentsinXu" target="_blank" rel="nofollow">微博</a>
      <a href="http://fly.layui.com/jie/2461.html" target="_blank">微信公众号</a>
    </p>
  </div>
</div>

<script src="<%=request.getContextPath()%>/layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['element','laypage', 'layer'], function(){
  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
  var laypage = layui.laypage
  ,layer = layui.layer;
  
  laypage({
    cont: 'page'
    ,pages: 50 //总页数
    ,groups: 10 //连续显示分页数
  });
});
</script>
</body>
</html>