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
		<title></title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
	</head>

	<body>
		<div class="admin-main">
			<blockquote class="layui-elem-quote">
				<p>本项目前端基于LayUI实现 ,支持所有LayUI组件.</p>
				前端UI项目地址：
				<a href="https://github.com/double-qiu/JUHE_UI" target="_blank"> <cite style="color: #1AA094;">https://github.com/double-qiu/JUHE_UI</cite></a>
				<p>本项目目前后端采用springboot + spring data jpa + dubbo + zookeeper + redis + Spring Security + vue + swagger2 + mysql 实现
				</p>
				项目地址：
				<a href="https://github.com/double-qiu/JuheData" target="_blank"> <cite style="color: #1AA094;">https://github.com/double-qiu/JuheData</cite></a>
				<p>建议反馈和问题收集地址:
					<a href="http://ufdouble.com" target="_blank"><cite style="color: #1AA094;">http://ufdouble.com</cite></a>
				</p>
				<p>QQ：934590736</p>
				<p>邮箱：934590736@qq.com</p>
			</blockquote>
			<fieldset class="layui-elem-field">
				<legend>更新日志</legend>
				<div class="layui-field-box">
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.1-SNAPSHOT 2017-01-20</legend>
						<div class="layui-field-box">
							<p>1、项目基本整体架构搭建完成，实现微信精选、新闻头条、驾考题库、聊天机器人、影视影讯检索、历史的今天、图书电商数据等模块功能！</p>
						</div>
					</fieldset>
					<!-- <fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.8 2016-12-21</legend>
						<div class="layui-field-box">
							<p>1、navbar组件 添加属性 <cite style="color: #1AA094;">spreadOne </cite>"设置是否只展开一个二级菜单，默认为false"</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.8 2016-12-05</legend>
						<div class="layui-field-box">
							<p>1、对navbar组件添加缓存支持</p>
							<p>2、更新navbar组件说明文档</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.8 2016-12-02</legend>
						<div class="layui-field-box">
							<p>1、layui版本更新到1.0.7</p>
							<p>2、添加layout三级菜单布局页面
								<a href="http://beginner.zhengjinfan.cn/demo/beginner_admin/layout.html" style="color: #1AA094;" target="_blank">点击这里查看演示</a>
							</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.7 2016-11-29</legend>
						<div class="layui-field-box">
							<p>1、layui版本更新到1.0.6</p>
							<p>2、添加常用的正则</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.6 2016-11-27</legend>
						<div class="layui-field-box">
							<p>1、添加tab组件</p>
							<p>2、使用tab组件优化tab选项卡的代码</p>
							<p>3、将index.html页面的js代码独立出来</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.5 2016-11-26</legend>
						<div class="layui-field-box">
							<p>1、添加隐藏左侧导航栏功能</p>
							<p>2、修改tab选项卡样式</p>
							<p>3、添加左侧nav导航栏选中状态</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.4 2016-11-25</legend>
						<div class="layui-field-box">
							<p>1、添加Navbar组件（动态渲染nav）</p>
							<p>2、更新首页nav的渲染方式 (使用Navbar组件动态渲染)</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.3 2016-11-22</legend>
						<div class="layui-field-box">
							<p>1、table 添加单选，全选功能</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;1.1、依赖组件iCheck 文档地址：
								<a href="http://www.bootcss.com/p/icheck/" target="_blank">http://www.bootcss.com/p/icheck/</a>
							</p>
							<p>2、添加登录页面</p>
							<p>--------------------------------------------------------------------</p>
							<p>3、top样式修改</p>
							<p>4、修复直接选中checkbox时背景色没变化，感谢
								<a href="http://fly.layui.com/u/2451288/" target="_blank">@瀮月</a>的反馈</p>
						</div>
					</fieldset>
					<fieldset class="layui-elem-field layui-field-title">
						<legend>版本号:# v0.0.1 2016-11-20</legend>
						<div class="layui-field-box">
							<p>1、基本布局 tab + iframe</p>
							<p>2、动态添加，删除tab</p>
							<p>3、表格样式</p>
							<p>4、分页组件</p>
						</div>
					</fieldset>
				</div>
			</fieldset> -->
		</div>
	</body>

</html>