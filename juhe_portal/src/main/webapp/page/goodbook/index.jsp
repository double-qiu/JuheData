<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String catalogId = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>好书商城</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" media="all" />
		<link href="<%=request.getContextPath()%>/layui/css/main.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"/>
</head>
<body class="layui-body-gbook">
<style>
a, a:hover {
   text-decoration: none;
}
</style>
<div  id="goodbook">
<div class="layui-header header header-index">
	<div class="layui-main">
		<input type="hidden" id="catalogId" name="catalogId" value="<%=catalogId%>"/>
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
	<!-- 导航栏 -->
	<div class="row ">
			 		<div class=" col-md-4 col-sm-6 "   v-for="bl in bookList">
                            <div class="text-center">
                                <img :src="bl.img" alt=""  v-on:click="detail(bl.id)" style="width: 200px; height: 280px;" >
                                <div>
                                    <h4><a href="javascript:void(0);"  v-on:click="detail(bl.id)">{{bl.title}}</a></h4>
                                </div>
                                <div class="text-center">
                                    <div class="inside">
                                        <h4><a href="javascript:void(0);"  v-on:click="detail(bl.id)">{{bl.catalog}}</a></h4>
                                        <p>{{bl.sub1}}</p>
                                    </div>
                                </div>
                            </div>
                        </div> 
           </div>
		<div id="page" class="text-center"></div>
	</div>
</div>

<div class="layui-footer footer-index">
  <div class="layui-main">
    <p>2017 © <a href="/">layui.com</a> LGPL license</p>
    <p>
      <a href="http://fly.layui.com/jie/3147.html" target="_blank">捐赠作者</a>
      <a href="mailto:xianxin@layui.com">广告联系</a>
      <a href="https://github.com/sentsin/layui/" target="_blank">Git仓库</a>
      <a href="http://weibo.com/SentsinXu" target="_blank" rel="nofollow">微博</a>
      <a href="http://fly.layui.com/jie/2461.html" target="_blank">微信公众号</a>
    </p>
  </div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
<script  type="text/javascript"  src="<%=request.getContextPath()%>/js/vue.min.js" charset="utf-8"></script>
<script  type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-2.1.3.js" charset="utf-8"></script>
<script>
layui.config({
	base: 'plugins/layui/modules/'
});
layui.use([ 'element','laypage', 'layer','form'], function(){
	  var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
	  var laypage = layui.laypage
	  ,layer = layui.layer;
	  layer.ready(function(){
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
		  var catalogId = $("#catalogId").val();
		  if (typeof(catalogId) == "undefined"||catalogId=="undefined") { 
			  catalogId = "";
			} 
		  $.ajax({
              type: 'GET',
              data: {},
              url: '<%=request.getContextPath()%>/goodbook/total',
              success:function(result) {
              	if(result.success) {
              		var pages = result.data;
              		if(pages <= 10) {
              			var groups = pages;
              		}else {
              			var groups = 10;
              		}
              		 laypage({
         				cont: 'page',
         				pages: pages, //总页数
         				groups: groups, //连续显示分页数
         				jump: function(obj, first) {
         					 var curr = obj.curr;
         					 $.ajax({
         	                      type: 'GET',
         	                     data: {"current":curr,"rowCount":"9","catalogId":catalogId},
         	                      url: '<%=request.getContextPath()%>/goodbook/bookList',
         	                      success:function(result) {
         	                      	if(result.success) {
         	                      		vue.bookList = result.data;
         	                      	} else {
         	                      		parent.layer.alert("数据加载失败");
         	                      	}
         	                      }
         	               });
         				}
         			}); 
              	} else {
              		parent.layer.alert("数据加载失败");
              	}
              }
       });
	  });    
	});

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
    	       bookVO:''
    },
    methods: {
    	getBookByListId: function (id) {
    		 var _self = this;
    		 var laypage = layui.laypage;
    		 $.ajax({
                 type: 'GET',
                 data: {'catalogId':id},
                 url: '<%=request.getContextPath()%>/goodbook/total',
                 success:function(result) {
                 	if(result.success) {
                 		var pages = result.data;
                 		if(pages <= 10) {
                  			var groups = pages;
                  		}else {
                  			var groups = 10;
                  		}
                 		 laypage({
            				cont: 'page',
            				pages:pages, //总页数
            				groups: groups, //连续显示分页数
            				jump: function(obj, first) {
            					 var curr = obj.curr;
            					 $.ajax({
            	                      type: 'GET',
            	                      data: {"current":curr,"rowCount":"9","catalogId":id},
            	                      url: '<%=request.getContextPath()%>/goodbook/bookList',
            	                      success:function(result) {
            	                      	if(result.success) {
            	                      		_self.bookList = result.data;
            	                      	} else {
            	                      		parent.layer.alert("数据加载失败");
            	                      	}
            	                      }
            	               });
            				}
            			}); 
                 	} else {
                 		parent.layer.alert("数据加载失败");
                 	}
                 }
          });
        },
        detail: function (id) {
         	window.location.href="<%=request.getContextPath()%>/page/goodbook/detail.jsp?id="+id ;
        }
    }
})



</script>
</body>
</html>