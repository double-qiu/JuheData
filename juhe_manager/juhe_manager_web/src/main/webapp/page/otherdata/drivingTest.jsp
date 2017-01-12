<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String rootPath =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">

<title>驾驶证考试科目一模拟考试题库</title>
<meta content="驾驶证考试科目一模拟考试题库等在线考试系统供大家练习" name="description">
<meta name="keywords" content="驾驶证考试科目一模拟考试题库">


<link href="<%=request.getContextPath()%>/css/drivingTest.css" rel="stylesheet" type="text/css"></head>
<link href="<%=request.getContextPath()%>/drivingTest/bdsstyle.css" rel="stylesheet" type="text/css"></head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/global.css" media="all">
<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/table.css" />
<body>
<div id="driving">
<form class="layui-form" action="" style="text-align: center;">
<blockquote class="layui-elem-quote">
					<span style="font-size:18px; text-align:center">科目类型<span/>
					<div class="layui-input-inline">
						<select name="subject" id="subject"  >
							<option value="1" selected="selected">科目1</option>
							<option value="4" >科目4</option>
						</select>
					</div>
					<span style="font-size:18px; text-align:center">驾照类型<span/>
					<div class="layui-input-inline">
						<select name="model" id="model"  >
							<option value="c1" >C1</option>
							<option value="c2" >C2</option>
							<option value="a1" >A1</option>
							<option value="a2" >A2</option>
							<option value="b1" >B1</option>
							<option value="b2" >B2</option>
						</select>
					</div>
			<a v-on:click="search()" class="layui-btn " id="search">
					<i class="layui-icon">&#xe615;</i> 搜索
				</a>
			</blockquote>
</form>
<div class="wrap"  id = "wrap">
	<h1 style="font-size:28px; text-align:center">驾驶证考试题库</h1>
	<div class="q" style="border-top:1px solid #39c;" id="l1">
	</div>
	<div class="q" id="l1"  v-for="dt in drivingTestList">
		<div class="p1"  v-if="dt.url != ''"><img :src="dt.url" class="imgbig" ></div>
		<div class="t" style="background: rgb(241, 241, 241);" >
			{{dt.id}}{{dt.question}}<span> {{dt.answerUS}}</span>
		</div>
		<ul>
			<li><label >{{dt.item1}}</label></li>
			<li><label >{{dt.item2}}</label></li>
			<li v-if="dt.item3 != ''"><label >{{dt.item3}}</label></li>
			<li v-if="dt.item4 != ''"><label >{{dt.item4}}</label></li>
			<li><label >{{dt.explains}}</label></li>
		</ul>
	</div>
	</div>
	
</div>
<div class="admin-table-page" style="margin-bottom: -9px;">
		<div id="page" class="page">
		</div>
	</div> 
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.3.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
		
		<script>
		var vue = new Vue({
            el: '#driving',
            data: {
            	drivingTestList : {id:"",
        			question:"",
        			answer:"",
        			item1:"",
        			item2:"",
        			item3:"",
        			item4:"",
        			explains:"",
        			url:""
        			}
            },
            methods: {
                search: function () {
                    var _self = this;
        			var subject = $("#subject").val();
					var model = $("#model").val();
					var totalPage = 100;
					var laypage = layui.laypage;
					 $.ajax({
	                        type: 'GET',
	                        data: {"subject":subject,"model":model},
	                        url: '<%=rootPath%>/juhe_manager_jpa/drivingTest/total',
	                        success:function(result) {
	                        	if(result.success) {
	                        		totalPage = result.data;
	                        		 laypage({
	             						cont: 'page',
	             						pages:totalPage, //总页数
	             						groups: 10, //连续显示分页数
	             						jump: function(obj, first) {
	             							 var curr = obj.curr;
	             							 $.ajax({
	             			                        type: 'GET',
	             			                        data: {"current":curr,"rowCount":"20","subject":subject,"model":model},
	             			                        url: '<%=rootPath%>/juhe_manager_jpa/drivingTest/page',
	             			                        success:function(result) {
	             			                        	if(result.success) {
	             			                        		_self.drivingTestList = result.data;
	             			                        	} else {
	             			                        		parent.layer.alert("数据加载失败");
	             			                        	}
	             			                        }
	             			                 });
	             						}
	             					}); 
	                        	} 
	                        }
	                 });
                }
            }
        })
			layui.config({
				base: 'plugins/layui/modules/'
			});
			layui.use([ 'laypage','layer','form'], function() {
				
				var form = layui.form();
				var $ = layui.jquery,
				laypage = layui.laypage,
				layer = parent.layer === undefined ? layui.layer : parent.layer;
				layer.ready(function(){
					var subject = "1";
					var model = "c1";
					var totalPage = 100;
					var laypage = layui.laypage;
					 $.ajax({
	                        type: 'GET',
	                        data: {"subject":subject,"model":model},
	                        url: '<%=rootPath%>/juhe_manager_jpa/drivingTest/total',
	                        success:function(result) {
	                        	if(result.success) {
	                        		totalPage = result.data;
	                        		 laypage({
	             						cont: 'page',
	             						pages:totalPage, //总页数
	             						groups: 10, //连续显示分页数
	             						jump: function(obj, first) {
	             							 var curr = obj.curr;
	             							 $.ajax({
	             			                        type: 'GET',
	             			                        data: {"current":curr,"rowCount":"20","subject":subject,"model":model},
	             			                        url: '<%=rootPath%>/juhe_manager_jpa/drivingTest/page',
	             			                        success:function(result) {
	             			                        	if(result.success) {
	             			                        		vue.drivingTestList = result.data;
	             			                        	} else {
	             			                        		parent.layer.alert("数据加载失败");
	             			                        	}
	             			                        }
	             			                 });
	             						}
	             					}); 
	                        	} 
	                        }
	                 });
				});
			});
		</script>
</body></html>