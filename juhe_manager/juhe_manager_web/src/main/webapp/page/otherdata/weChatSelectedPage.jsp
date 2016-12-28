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
		<title>Table</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/global.css" media="all">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css" />
	</head>

	<body>
		<div class="admin-main" id="wechat">
		<!-- <form class="layui-form" action="">
			<blockquote class="layui-elem-quote">
				<label class="layui-form-label">日期</label>
					<div class="layui-input-inline">
						<select name="month" id="month"  >
							<option value="" selected="">请选择月</option>
							<option v-for="month in monthList" v-bind:value="month.value">{{month.name}}</option>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="day" id="day">
							<option value="" selected="">请选择日</option>
							<option v-for="day in dayList" v-bind:value="day.value">{{day.name}}</option>
						</select>
				</div> 
				<a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 添加信息
				</a>
				<a href="#" class="layui-btn layui-btn-small" id="import">
					<i class="layui-icon">&#xe608;</i> 导入信息
				</a>
				<a href="#" class="layui-btn layui-btn-small">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i> 导出信息
				</a>
				<a v-on:click="search()" class="layui-btn " id="search">
					<i class="layui-icon">&#xe615;</i> 搜索
				</a>
			</blockquote>
			</form> -->
			<fieldset class="layui-elem-field">
				<legend>微信精选</legend>
				 <div class="layui-field-box"  >
					<table class="site-table table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>标题</th>
								<th>来源</th>
								<th>地址</th>
							</tr>
						</thead>
						<tbody>
							<tr  v-for="wechats in weChatSelectedPage">
								<td>{{wechats.id}}</td>
								<td>{{wechats.title}}</td>
								<td>{{wechats.source}}</td>
								<td>{{wechats.url}}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
			 <div class="admin-table-page">
				<div id="page" class="page">
				</div>
			</div> 
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.3.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
		
		<script>
		var vue = new Vue({
            el: '#wechat',
            data: {
            	weChatSelectedPage : '',
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
				
				 laypage({
						cont: 'page',
						pages: 100, //总页数
						groups: 5, //连续显示分页数
						jump: function(obj, first) {
							 var curr = obj.curr;
							 $.ajax({
			                        type: 'GET',
			                        data: {"pno":curr,"ps":"20"},
			                        url: '<%=request.getContextPath()%>/weChatSelected/page',
			                        success:function(result) {
			                        	if(result.success) {
			                        		vue.weChatSelectedPage =result.data.list;
			                        	} else {
			                        		parent.layer.alert("数据加载失败");
			                        	}
			                        }
			                 });
						}
					}); 
			});
		</script>
	</body>
</html>