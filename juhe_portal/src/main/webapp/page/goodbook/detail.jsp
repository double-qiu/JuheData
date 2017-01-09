<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookId = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>好书商城</title>
		<link href="<%=request.getContextPath()%>/layui/css/layui.css" rel="stylesheet" />
		<link href="<%=request.getContextPath()%>/layui/css/main.css" rel="stylesheet" />
         <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/prettyPhoto/css/prettyPhoto.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/font-awesome/css/font-awesome.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/social-icons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ebook-style.css">
</head>
<body class="layui-body-gbook">
<style>
a, a:hover {
   text-decoration: none;
}
.over{opacity: 0.6;  }
.layui-search .search{
display: block;
width: 100%;
padding-left: 10px;
height: 38px;
line-height: 38px;
border: 1px solid #e6e6e6;
background-color: #fff;
border-radius: 2px; 
 }
</style>
<div id="goodbook">
<div class="layui-header header header-index">
<div class="layui-main">
		<input type="hidden" id="bookId" name="bookId" value="<%=bookId%>"/>
		<a class="logo" href="javascript:void(0);">
	      <img src="<%=request.getContextPath()%>/images/logo.png" alt="layui">
	    </a>
		<ul class="layui-nav">
		   <li class="layui-nav-item"><a href ="javascript:void(0);"  v-on:click="getBookByListId('')">最新推荐</a></li>
		  <li class="layui-nav-item "  v-for="sl in sortList">
		    <a >{{sl.name}}</a>
		     <dl class="layui-nav-child">
		    	<dd v-for="tl in sl.typeList"><a  href ="javascript:void(0);"   v-on:click="getBookByListId(tl.typeId)">{{tl.catalog}}</a></dd>
		    </dl>
		  </li>
		</ul>
		<!-- <form action="#search" class="layui-search">
			<i class="layui-icon icon-sousuo searchIco" style="font-size: 24px; color: #1E9FFF;top: 5px;">&#xe615;</i>
			<input class="layui-input search" autocomplete="off" placeholder="搜索内容，回车跳转" type="text" name="q">
		</form> -->
	</div>
</div>
        <!-- Product Showcase -->
        <div class="product-showcase" style = "height:900px;">
                <div class="container">
                    <div class="row">
                        <div class="span12 product-background">
                            <div class="row">
                                <div class="span5 product-image ">
                                    <img :src="bookVO.img" alt="">
                                    <div class="product-reading">
                                    <h3> <strong>{{bookVO.reading}}人阅读</strong></h3>
                                    <p>购买图书平台<strong><br/>
                                    <a href ="javascript:void(0);"    v-on:click= goUrl(bl.mallUrl) v-for="bl in bookVO.onlineList" style="text-align: left;">{{bl.mallName}}<br/></a>
                                   </strong></p>	
                                    </div>
                                </div>
                                <div class="span7 product-title">
									 <h1> <strong>{{bookVO.title}}</strong> </h1>
                                    <div class="product-description">
                                        <p>{{bookVO.catalog}} &nbsp;&nbsp;&nbsp;&nbsp;<strong>{{bookVO.tags}} </strong></p>
                                        <p id="content" v-on:click= showContent(bookVO.sub2) >
                                        {{bookVO.sub2Short}}
										</p>                  
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
		</div>
		<div id="page" class="text-center"></div>
	<div class="layui-footer footer-index footer">
	  <div class="layui-main">
	    <p>2016 © <a href="/">layui.com</a> LGPL license</p>
	    <p>
	      <a href="http://www.ufdouble.com" target="_blank">作者博客</a>
	      <a href="mailto:934590736@qq.com">广告联系</a>
	      <a href="https://github.com/double-qiu/JuheData" target="_blank">Git仓库</a>
	      <a href="http://weibo.com/ufdouble" target="_blank" rel="nofollow">微博</a>
	    </p>
	  </div>
	</div>
</div>
 		<script src="<%=request.getContextPath()%>/assets/js/jquery-1.8.2.min.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/jquery.backstretch.min.js"></script>
         <script src="<%=request.getContextPath()%>/assets/js/jquery.tweet.js"></script>
        <script src="<%=request.getContextPath()%>/assets/prettyPhoto/js/jquery.prettyPhoto.js"></script>
        <script src="<%=request.getContextPath()%>/assets/js/ebook-scripts.js"></script>
		<script src="<%=request.getContextPath()%>/layui/layui.js" charset="utf-8"></script>
		<script  type="text/javascript"  src="<%=request.getContextPath()%>/js/vue.min.js" charset="utf-8"></script>
<script>
var vue = new Vue({
    el: '#goodbook',
    data: {
    	sortList : [{
							typeList:[{catalog:''}],
							id:'1',
							name:'文学馆'
    				},
    				{
						typeList:[{catalog:''}],
						id:'2',
						name:'经管馆'
					},
					{
						typeList:[{catalog:''}],
						id:'3',
						name:'计算机馆'
					},
					{
						typeList:[{catalog:''}],
						id:'4',
						name:'生活馆'
					},
					{
						typeList:[{catalog:''}],
						id:'5',
						name:'励志成功馆'
					}
    	            ],
    	       bookList:[],
    	       bookVO:{
    	    	   reading:'',
    	    	   title:'',
    	    	   catalog:'',
    	    	   tags:'',
    	    	   sub2Short:''
    	       }
    },
    methods: {
    	getBookByListId: function (id) {
    		window.location.href="<%=request.getContextPath()%>/page/goodbook/index.jsp?id="+id ;
        },
        goUrl: function (url) {
        	window.open(url);
        },
       showContent:function(content){
    	   
    	   var html ='<blockquote class="layui-elem-quote layui-quote-nm">'+content+'</blockquote>';
    	   
    	   layer.open({
       		  type: 1
       		  ,title: false //不显示标题栏
       		  ,closeBtn: true
       		  ,area: '800px;'
       		  ,shade: 0.8
       		  ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
       		  ,resize: false
       		 // ,btn: ['火速围观', '残忍拒绝']
       		  ,btnAlign: 'c'
       		  ,moveType: 0 //拖拽模式，0或者1
       		  ,content: html
       		  ,success: function(layero){
       		    var btn = layero.find('.layui-layer-btn');
       		    btn.find('.layui-layer-btn0').attr({
       		      href: 'http://www.layui.com/'
       		      ,target: '_blank'
       		    });
       		  }
       		});
       }
    }
})

layui.config({
	base: 'plugins/layui/modules/'
});
layui.use([ 'element','laypage', 'layer','form'], function(){
	  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
	  var laypage = layui.laypage
	  ,layer = layui.layer;
	  layer.ready(function(){
		  
		  $("#content").mouseover(function(){
			  $(this).addClass("over");
			 }).mouseout(function(){
			  $(this).removeClass("over");
			});
		  
		  $('.product-showcase').backstretch('<%=request.getContextPath()%>/assets/img/backgrounds/1-.jpg');
		  $.ajax({
	          type: 'GET',
	          data: {},
	          url: '<%=request.getContextPath()%>/goodbook/typeList',
	          success:function(result) {
	          	if(result.success) {
	              	vue.sortList =result.data;
	          	} else {
	          		parent.layer.alert("数据加载失败");
	          	}
	          }
	      });
		  var id = $("#bookId").val();
		  $.ajax({
              type: 'GET',
              data: {"id":id},
              url: '<%=request.getContextPath()%>/goodbook/detail',
              success:function(result) {
              	if(result.success) {
              		vue.bookVO = result.data;
              	} else {
              		parent.layer.alert("数据加载失败");
              	}
              }
       }); 
	  });    
	});
</script>
</body>
</html>