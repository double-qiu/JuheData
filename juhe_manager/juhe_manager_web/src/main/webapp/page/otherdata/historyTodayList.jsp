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
		<div class="admin-main" id="historyToday">
		<form class="layui-form" action="">
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
				<!-- <a href="javascript:;" class="layui-btn layui-btn-small" id="add">
					<i class="layui-icon">&#xe608;</i> 添加信息
				</a>
				<a href="#" class="layui-btn layui-btn-small" id="import">
					<i class="layui-icon">&#xe608;</i> 导入信息
				</a>
				<a href="#" class="layui-btn layui-btn-small">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i> 导出信息
				</a> -->
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
								<th>年</th>
								<th>月</th>
								<th>日</th>
								<th>简述</th>
								<th>农历</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr  v-for="events in historyTodayEventList">
								<td>{{events.title}}</td>
								<td>{{events.year}}</td>
								<td>{{events.month}}</td>
								<td>{{events.day}}</td>
								<td>{{events.des}}</td>
								<td>{{events.lunar}}</td>
								<td>
									<a href="javascript:;" class="layui-btn layui-btn-normal layui-btn-mini" v-on:click="detail(events._id)">详情</a>
									<!-- <a href="/detail-1" target="_blank" class="layui-btn layui-btn-normal layui-btn-mini">预览</a> -->
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
			<!-- <div class="admin-table-page">
				<div id="page" class="page">
				</div>
			</div> -->
		</div>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.3.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
		
		<script>
		var vue = new Vue({
            el: '#historyToday',
            data: {
            	historyTodayEventList : '',
            	monthList : '',
            	dayList : ''
            },
            methods: {
                search: function () {
                	var day = $("#day").val();
                	if(day == "") {
                		parent.layer.alert('请选择日');
                	} 
                	var month = $("#month").val();
                	if(month == "") {
                		parent.layer.alert('请选择月');
                	}
                    var _self = this;
                    $.ajax({
                        type: 'GET',
                        data: {"month":month,"day":day},
                        url: '<%=request.getContextPath()%>/historyToday/eventList',
                        success:function(result) {
                        	if(result.success) {
                            	_self.historyTodayEventList =result.data;
                        	} else {
                        		parent.layer.alert("数据加载失败");
                        	}
                        }
                    });
                },
                detail: function (id) {
                	$.getJSON('<%=request.getContextPath()%>/historyToday/eventDetail',{"id":id},function(result){
                		if(result.success) {
                			var html =
                				'<fieldset class="layui-elem-field layui-field-title">\
                			  		<legend>'+result.data.title+'</legend>\
                				</fieldset>\
                				<blockquote class="layui-elem-quote">'+result.data.des+'</blockquote>\
                				<div style="width:100%; ">\
	                				<div class="layui-inline"  style="width:100%; text-align:center;vertical-align: middle;">\
	                				  <img src="'+result.data.pic+'"  >\
	                				</div>\
                				</div>\
                			 	<blockquote class="layui-elem-quote layui-quote-nm">'+result.data.content+'</blockquote>';
                			layer.open({
  	                		  type: 1
  	                		  ,title: false //不显示标题栏
  	                		  ,closeBtn: true
  	                		  ,area: '1200px;'
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
                	});
                	
                }
            },
            
            beforeMount: function() {
            	var _self = this;
            	var myDate = new Date();
            	var month = myDate.getMonth()+1; 
            	var day = myDate.getDate();
            	 $.ajax({
                     type: 'GET',
                     data: {"month":month,"day":day},
                     url: '<%=request.getContextPath()%>/historyToday/eventList',
                     success:function(result) {
                     	if(result.success) {
                         	_self.historyTodayEventList =result.data;
                     	} else {
                     		parent.layer.alert("数据加载失败");
                     	}
                     }
                 });
            	$.ajax({
                    type: 'GET',
                    data: {},
                    url: '<%=request.getContextPath()%>/historyToday/getMonths',
                    success:function(result) {
                    	if(result.success) {
                    		_self.monthList =result.data;
                    	}
                    }
                });
            	$.ajax({
                    type: 'GET',
                    data: {},
                    url: '<%=request.getContextPath()%>/historyToday/getDays',
                    success:function(result) {
                    	if(result.success) {
                    		_self.dayList =result.data;
                    	}
                    }
                });
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
				
				$('input').iCheck({
					checkboxClass: 'icheckbox_flat-green'
				});
				
				//绑定详情事件
	            /* $('a[data-opt=detail]').each(function(){
	                $(this).on('click',function(){
	                    var $this =$(this);
	                    var id = $this.data('id');
	                    $.getJSON('/historyToday/eventDetail',{id:id},function(result){
	                        var getTpl = $('#detail-temp').html();
	                        laytpl(getTpl).render(result, function(html){
	                            if(result.success){
	                                layer.open({
	                                    title:'事件详情',
	                                    type: 1,
	                                    skin: 'layui-layer-rim', //加上边框
	                                    area: ['800px', '600px'], //宽高
	                                    content: html
	                                });
	                            }
	                        });
	                    });
	                });
	            }); */
				
				//page
				/* laypage({
					cont: 'page',
					pages: 25, //总页数
					groups: 5, //连续显示分页数
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
						}
					}
				}); */
				/* $('#search').on('click', function() {
					parent.layer.alert('你点击了搜索按钮')
				}); */

				$('#add').on('click', function() {
					$.get('temp/edit-form.html', null, function(form) {
						layer.open({
							type: 1,
							title: '添加表单',
							content: form,
							btn: ['保存', '取消'],
							area: ['600px', '400px'],
							maxmin: true,
							yes: function(index) {
								console.log(index);
							},
							full: function(elem) {
								var win = window.top === window.self ? window : parent.window;
								$(win).on('resize', function() {
									var $this = $(this);
									elem.width($this.width()).height($this.height()).css({
										top: 0,
										left: 0
									});
									elem.children('div.layui-layer-content').height($this.height() - 95);
								});
							}
						});
					});
				});

				$('#import').on('click', function() {
					var that = this;
					var index = layer.tips('只想提示地精准些', that,{tips: [1, 'white']});
					$('#layui-layer'+index).children('div.layui-layer-content').css('color','#000000');
				});

				$('.site-table tbody tr').on('click', function(event) {
					var $this = $(this);
					var $input = $this.children('td').eq(0).find('input');
					$input.on('ifChecked', function(e) {
						$this.css('background-color', '#EEEEEE');
					});
					$input.on('ifUnchecked', function(e) {
						$this.removeAttr('style');
					});
					$input.iCheck('toggle');
				}).find('input').each(function() {
					var $this = $(this);
					$this.on('ifChecked', function(e) {
						$this.parents('tr').css('background-color', '#EEEEEE');
					});
					$this.on('ifUnchecked', function(e) {
						$this.parents('tr').removeAttr('style');
					});
				});
				$('#selected-all').on('ifChanged', function(event) {
					alert(222);
					var $input = $('.site-table tbody tr td').find('input');
					$input.iCheck(event.currentTarget.checked ? 'check' : 'uncheck');
				});
			});
		</script>
	</body>

</html>