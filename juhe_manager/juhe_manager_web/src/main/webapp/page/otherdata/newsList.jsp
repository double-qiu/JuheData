<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>新闻头条</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/global.css" media="all">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css" />
	</head>

	<body>
		<div class="admin-main" id="news">
		<form class="layui-form" action="">
			<blockquote class="layui-elem-quote">
				<label class="layui-form-label">新闻类型</label>
					<div class="layui-input-inline">
						<select name="type" id="type"  >
							<option value="top" selected="selected">头条</option>
							<option value="shehui" >社会</option>
							<option value="guonei" >国内</option>
							<option value="guoji">国际</option>
							<option value="yule">娱乐</option>
							<option value="tiyu" >体育</option>
							<option value="junshi" >军事</option>
							<option value="keji" >科技</option>
							<option value="caijing">财经</option>
							<option value="shishang" >时尚</option>
						</select>
					</div>
				<a v-on:click="search()" class="layui-btn " id="search">
					<i class="layui-icon">&#xe615;</i> 搜索
				</a>
			</blockquote>
			</form>
			<fieldset class="layui-elem-field">
				<legend>数据列表</legend>
				 <div class="layui-field-box"  >
					<table class="site-table table-hover">
						<thead>
							<tr>
								<th>标题</th>
								<th>时间</th>
								<th>新闻类型</th>
								<th>新闻来源</th>
								<th>来源地址</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr  v-for="el in newsList">
								<td>{{el.title}}</td>
								<td>{{el.date}}</td>
								<td>{{el.category}}</td>
								<td>{{el.author_name}}</td>
								<td>{{el.url}}</td>
								<td>
									<a  v-bind:href ="el.url" class="layui-btn layui-btn-normal layui-btn-mini"  >详情</a>
									<a href="javascript:void(0);" class="layui-btn  layui-btn-mini" v-on:click="detail(el.url)">原文</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.3.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
		
		<script>
		var vue = new Vue({
            el: '#news',
            data: {
            	newsList : ''
            },
            methods: {
                search: function () {
                    var _self = this;
                    var type = $("#type").val();
                    $.ajax({
                        type: 'GET',
                        data: {"type":type},
                        url: '<%=request.getContextPath()%>/news/list',
                        success:function(result) {
                        	if(result.success) {
                            	_self.newsList =result.data;
                        	} else {
                        		parent.layer.alert("数据加载失败");
                        	}
                        }
                    });
                },
                detail: function (url) {
                	window.open(url);
                	
                }
            }
        })
			layui.config({
				base: 'plugins/layui/modules/'
			});
			layui.use(['icheck', 'laypage','layer','form'], function() {
				
				var form = layui.form();
				var $ = layui.jquery,
				laypage = layui.laypage,
				layer = parent.layer === undefined ? layui.layer : parent.layer;
				layer.ready(function(){
					 $.ajax({
	                     type: 'GET',
	                     data: {"type":"top"},
	                     url: '<%=request.getContextPath()%>/news/list',
	                     success:function(result) {
	                     	if(result.success) {
	                         	vue.newsList = result.data;
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