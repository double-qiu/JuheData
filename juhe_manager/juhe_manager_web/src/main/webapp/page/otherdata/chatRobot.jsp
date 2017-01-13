<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="keywords" content="客服系统,客服机器人,智能问答机器人,智齿问答机器人">
<title>aidoRobot</title>
<link href="<%=request.getContextPath()%>/robot/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/robot/nanoscroller.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/robot/jquery.autocomplete.css">
<link href="">
</head>
<body>
<div class="toppart"> 
  <!--==============logo=========================-->
  <div class="logo"> <a href="javascript:;" style="margin:0 0 0 10px;"> <img id="weblogo" style="margin-top:8px; height:60px;" src="<%=request.getContextPath()%>/robot/logo.png"> </a> </div>
 
  <!--===============预留logo========================-->
  <div class="companylogo">
    <p class="cimg"></p>
  </div>
</div>
<table id="givemetable" width="100%" border="0" cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td class="vtdl"><!--=======================================-->
        
        <div class="vtddcontent scroll_content" id="con_div" >
          <div id="scroll-div" class="nano has-scrollbar">
            <div class="content" tabindex="0">
              <p class="spacing"></p>
              <div class="vtddcntin" id="left_content">
				<div class="msgleft"><p class="i">
					  <img src="<%=request.getContextPath()%>/robot/fi1.png" width="50"></p><div class="msgcontent">
					  <p class="spacing"></p>
					  <div class="kftext">
						  <div><span class="s1">aido</span>：您好，我是智能客服机器人，我可以回答您相关的业务问题，有什么问题就问我吧！ 很高兴为您服务！</div>
						  <p class="spacing5"></p>
						  <div class="ishaveyong"><p class="spacing5"></p><span></span></div>
					  </div>
					  <p class="spacing"></p></div>
				</div>
				<p class="spacing15"></p>  
			 </div>
			 <div id = "robotMsg">
			 </div>
            </div>
          <div class="pane" style="height: 100%; display: none; opacity: 1; visibility: visible;"><div class="slider" style="height: 751px;"></div></div>
          </div>
        </div>
       
        
        <div class="vooinputforms" id= "robot">
          <p class="showWaring" id="showErrorId"><span></span></p>
          <p class="spacing7"> <a href="javascript:;" id="clearScreen">清空聊天记录</a>&nbsp;&nbsp;&nbsp;&nbsp; <span>您还可以输入<span id="wordremain">{{wordremain}}</span>个字</span> </p>
          <table class="vamtable" width="100%" border="0" cellpadding="0" cellspacing="0">
            <tbody>
              <tr>
                <td class="xtdx1">&nbsp;</td>
                <td class="xtdx2"><div class="">
                    <input id="text-in" class="vaxtxtear ac_input" maxlength="100" autocomplete="off" oldvalue="请输入您要咨询的内容" style="color: rgb(153, 153, 153);">
                  </div>
                  <p class="spacing5" style=" height:20px; margin-top:7px; font-size:11px; text-align:center;" id="devP">对机器人感兴趣请百度&nbsp;&nbsp;AidoRobot智能问答机器人</p></td>
                <td class="xtdx3"></td>
                <td class="xtdx4"><input id="inputPR" name="" value="" class="dosubmitss" type="button"></td>
              </tr>
            </tbody>
          </table>
        </div></td>
     
    </tr>
  </tbody>
</table>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/robot/jquery-1.8.3.min.js"></script> 
<script language="javascript" type="text/ecmascript" src="<%=request.getContextPath()%>/robot/jquery.autocomplete.js"></script> 
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/robot/base.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/robot/nanoScroller.js"></script> 
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/robot/jquery.faqrobot.dev.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/vue.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/layui/layui.js"></script>
<script type="text/javascript" >

var vue = new Vue({
    el: '#robot',
    data: {
    	wordremain : '30',
    	i:1
    },
    methods: {
      
    }
})
$(function(){
	
	$('body').keydown(function(e){
		  if(e.keyCode==13){
			Answer();
		  }
	});
	$("body").keyup(function(){
	    var len = $("#text-in").val().length;
	    var wordLen = 30 - len;
	    var text= '';
	    if(wordLen <= 0) {
	    	parent.layer.alert("输入字数过多");
	    	var text = $("#text-in").val().substring(0,30);
	    	$("#text-in").val(text);
	    	vue.wordremain = 0;
	    } else {
	    	vue.wordremain = wordLen;
	    }
	 });
});

function Answer() {
	var info = $("#text-in").val();
	if(info != '') {
		 $.ajax({
	         type: 'GET',
	         data: {"info":info},
	         url: '<%=request.getContextPath()%>/chatRobot/answer',
	         success:function(result) {
	         	if(result.success) {
	         		var info = 
	         			'<div class="msgright" id = "m'+vue.i+'"><p class="ri">\
	         			<img width="55" src="<%=request.getContextPath()%>/robot/fi2.jpg" style="margin-left:5px;width:52px; height:52px; border-radius:50%; overflow:hidden;"></p>\
	         			<div class="rmsgcontent">\
	         			<p class="spacing15"></p>\
	         			<div class="metext">\
	         			<span class="s1">我：</span><span>'+result.data.info+'</span>&nbsp;&nbsp;<br>\
	         			<span class="s2">'+result.data.time+'</span><p class="spacing5"></p>\
	         			</div>\
	         		<div class="ishaveyong"><p class="spacing5"></p></div>\
	         		<p class="spacing"></p>\
	         		</div>\
	         		</div>\
	         		<p class="spacing15"></p>\
	         		<div class="msgleft"><p class="i">\
	         		  <img src="<%=request.getContextPath()%>/robot/fi1.png" width="50"></p>\
	         		  <div class="msgcontent"><p class="spacing"></p>\
	         		  <div class="kftext">\
	         			<div><span class="s1">aido</span>：<span><p>'+result.data.text+'</p></span><br><span class="s2">'+result.data.time+'</span></div>\
	         			<p class="spacing5"></p>\
	         			<div class="ishaveyong"><p class="spacing5"></p></div>\
	         		  </div>\
	         		  <p class="spacing"></p>\
	         		  </div>\
	         		</div>\
	         		<p class="spacing15"></p>'; 
					$("#robotMsg").append(info);
					$("#text-in").val('');
					vue.wordremain = 30;
					
					var container = $('div'),
					scrollTo = $("#m"+vue.i+"");
					container.scrollTop(
						scrollTo.offset().top - container.offset().top + container.scrollTop()
					);

					container.animate({
						scrollTop: scrollTo.offset().top - container.offset().top + container.scrollTop()
					}); 
					vue.i = vue.i+1;
					
	         	} else {
	         		parent.layer.alert("未搜索出答案");
	         	}
	         }
	  });
	}
}

$("#inputPR").click(function(){
	Answer();
});

$("#clearScreen").click(function(){
  $("#robotMsg").remove();
  $("#left_content").after("<div id = 'robotMsg'></div>");
});



layui.config({
	base: 'plugins/layui/modules/'
});
layui.use([ 'layer','form'], function() {
	var form = layui.form();
	var $ = layui.jquery,
	layer = parent.layer === undefined ? layui.layer : parent.layer;
	
});
</script>
</body></html>