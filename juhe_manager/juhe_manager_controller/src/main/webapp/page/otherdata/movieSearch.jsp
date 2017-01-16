<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class="" lang="zh-cn">
	<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>影视搜索</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/yishiStatic/main1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/yishiStatic/main2.css">
</head><body class="g-wide">
<div id="movie">
    <div class="eb-subhead">
		<div class="b-detailfilter-form g-clear" >
		<img src="<%=request.getContextPath()%>/yishiStatic/movielogo.png">
			<div class="kw-main g-clear">
				<div class="kw-wrap g-clear">
					<input type="text" name="kw" class="kw" id = "searchNote"  autocomplete="off">
				</div>
				<div class="sub-wrap">
					<a v-on:click="search()"  id="search" class="sub" ><label >搜索</label></a>
				</div>
			</div>
		</div>
	</div>
<div id="content"  style="display:none;">
<div class="p-top-bg"></div>
<div class="p-top">

	<div class="p-top-main-wrap">
		<div class="p-top-main">
			<div class="top g-clear">
				<div class="top-left">
			<div class="b-detailcover tj-cover" monitor-desc="大海报">
				<a :href="movie.play" class="g-playicon b-detailcover-img" data-num="1">
					<img :src="movie.cover"><i class="ico-pay"></i>
				</a>
			</div>
				</div>
				<div class="top-right">
					<div data-block="tj-info" monitor-desc="详细信息" class="top-info">
						<div class="top-info-title">
							<div class="title-left g-clear">
								<h1>{{movie.title}}</h1>
							</div>
						</div>

						<div id="js-desc-switch" class="top-info-detail g-clear">
							<div class="g-clear item-wrap">
								<p class="item"><span>类型：</span>{{movie.tag}}</p>
								<p class="item"><span>年代：</span>{{movie.year}}</p>
								<p class="item"><span>地区：</span>{{movie.area}}</p>
								<p class="item">
									<span>导演：</span>
									{{movie.dir}}
								</p>
								<p class="item">
									<span>演员：</span>
									{{movie.act}}
								</p>
							</div>
							<p class="item-desc js-close-wrap" ><span>简介：</span>{{movie.desc}}</p>							
						</div>
					</div>

					<div data-block="tj-site" monitor-desc="剧集">
							<div id="js-siteact" class="top-list">
								<div class="top-list-zd g-clear top-list-zd-wide">
									<div v-if="movie.vdo_status == 'play'"  class="txt-wrap">
										<span class="txt">播放平台:</span>
											 <a v-if="movie.playlinks.qq != null" class="js-site ea-site ea-site-qq" :href="movie.playlinks.qq">腾讯</a>
											<a v-if="movie.playlinks.qiyi != null" class="js-site ea-site ea-site-qiyi" :href="movie.playlinks.qiyi">爱奇艺</a>
											<a v-if="movie.playlinks.tudou != null" class="js-site ea-site ea-site-tudou" :href="movie.playlinks.tudou">土豆</a>
											<a v-if="movie.playlinks.youku != null" class="js-site ea-site ea-site-youku" :href="movie.playlinks.youku">优酷</a> 
											<a v-if="movie.playlinks.leshi != null" class="js-site ea-site ea-site-leshi" :href="movie.playlinks.leshi">乐视</a> 
											<a v-if="movie.playlinks.sohu != null" class="js-site ea-site ea-site-sohu" :href="movie.playlinks.sohu">搜狐</a>
											<a v-if="movie.playlinks.imgo != null" class="js-site ea-site ea-site-imgo" :href="movie.playlinks.imgo">芒果TV</a> 
											<a v-if="movie.playlinks.pptv != null" class="js-site ea-site ea-site-pptv" :href="movie.playlinks.pptv">PPTV</a> 
											<a v-if="movie.playlinks.baofeng != null" class="js-site ea-site ea-site-baofeng" :href="movie.playlinks.baofeng">暴风</a> 
											<a v-if="movie.playlinks.huashu != null" class="js-site ea-site ea-site-huashu" :href="movie.playlinks.huashu">华数TV</a> 
											<a v-if="movie.playlinks.fengxing != null" class="js-site ea-site ea-site-fengxing" :href="movie.playlinks.fengxing">风行</a> 
									</div>
									<div v-if="movie.vdo_status == 'none'"  class="txt-wrap">
										<span class="txt">暂未播出</span>
									</div>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

    <div class="p-body-wrap">
        <div class="p-body-bg"></div>
        <div class="p-body g-clear">
		<div data-block="tj-tuijian" class="tuijian p-mod g-clear js-tab-switch " monitor-desc="相关推荐">
			<div class="b-dstar-title g-clear">
				<span class="label">猜你喜欢</span>
				<ul class="g-clear b-dstar-slist js-ibars">
				</ul>
			</div>
			<div class="content js-itabs">
				<ul class="tuijian-list g-clear js-itab w-newfigure-list" style="display:block;">
					<li  v-bind:title="video.title" class="w-newfigure w-newfigure-180x287"  v-for = "video in  movie.video_rec">
						<a :href="video.detail_url">
							<div class="w-newfigure-imglink g-playicon js-playicon"> 
							<img :src="video.cover"    v-bind:alt="video.title"></div>
							<div class="w-newfigure-detail">
								<p class="title g-clear"><span class="s1">{{video.title}}</span></p>
							</div>
						</a>
					</li>
				</ul>
			</div>
		</div>


                                    
	<div data-block="tj-actor" class="b-dstar p-mod g-clear js-tab-switch " monitor-desc="演员">
		<div class="b-dstar-title g-clear">
			<span class="label">演员</span>
			<ul class="g-clear b-dstar-slist js-ibars">
			</ul>
		</div>
		<div class="content js-itabs">
				<ul class="tuijian-list g-clear js-itab w-newfigure-list" style="display:block;">
					<li  v-bind:title="act.name" class="w-newfigure w-newfigure-180x287"  v-for = "act in movie.act_s">
						<a :href="act.url">
							<div class="w-newfigure-imglink g-playicon js-playicon"> 
							<img :src="act.image"    v-bind:alt="act.name"></div>
							<div class="w-newfigure-detail">
								<p class="title g-clear"><span class="s1">{{act.name}}</span></p>
							</div>
						</a>
					</li>
				</ul>
			</div>
	</div>
	</div>
   
    </div>

	<div class="eb-foot eb-foot-index">
		<div class="eb-foot-wrap g-clear">
			<div class="eb-foot-left">
				<p><img src="<%=request.getContextPath()%>/yishiStatic/movielogo.png"></p>
				<p>Copyright © 安全网址. All Rights Reserved.</p>
			</div>
			<div class="eb-foot-right g-clear">
				<dl>
					<dt>关于</dt>
					<dd><a href="http://ufdouble.com" target="_blank">作者博客</a></dd>
					<dd><a href="https://github.com/double-qiu/JuheData" target="_blank">Git仓库</a></dd>
					<dd><a href="http://weibo.com/ufdouble" target="_blank" rel="nofollow">微博</a></dd>	
				</dl>
				<dl>
					<dt>服务</dt>
					<dd><a class="js-addfavorite" href="http://ufdouble.com/#">加入收藏</a></dd>
					<dd><a href="mailto:934590736@qq.com" target="_blank">广告联系</a></dd>
					<dd><a href="http://ufdouble.com/about/">联系方式</a></dd>
				</dl>
				<dl>
					<dt>微信打赏</dt>
					<dd><img src="<%=request.getContextPath()%>/yishiStatic/wechat.jpg"></dd>
				</dl>
			</div>
		</div>		
	</div>
	</div>
</div>
	<script src="<%=request.getContextPath()%>/yishiStatic/main1.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/yishiStatic/main2.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/yishiStatic/main3.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/yishiStatic/main4.js" type="text/javascript"></script>
	<script type="text/javascript">define("other.jquery",function(){return window.$;});</script>
	<script type="text/javascript">define("other.easing", ["other.jquery"], function($){ });</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
<script>
		var vue = new Vue({
            el: '#movie',
            data: {
            	movie : {
            		playlinks:{qq:'',qiyi:'',tudou:'',youku:'',leshi:'',sohu:'',imgo:'',pptv:'',baofeng:'',huashu:'',fengxing:''},
            		video_rec:[{cover:'',detail_url:'',title:''}],
            		act_s:[{name:'',url:'',image:''}]
            	}
            },
            methods: {
                search: function () {
                    var _self = this;
                    var q = $("#searchNote").val();
                    if(q == "") {
                    	parent.layer.alert("请输入查询影视名称");
                    }else {
                    	  $.ajax({
                              type: 'GET',
                              data: {"q":q},
                              url: '<%=request.getContextPath()%>/movie/search',
                              success:function(result) {
                              	if(result.success) {
                              		$("#content").show();
                                  	_self.movie =result.data;
                              	} else {
                              		parent.layer.alert(result.errorMessage);
                              	}
                              }
                          });
                    }
                }
            },
            beforeMount: function() {
            	$("#content").hide();
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
				
			});
		</script>
</body>
</html>