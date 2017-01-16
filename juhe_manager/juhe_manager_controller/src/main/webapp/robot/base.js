
$(document).ready(function(){
	FrameLoad();
	//3栏切换内容
	$(".calist p").click(
	   function(){
		  $(".calist p").removeClass("pnow");		
		  $(this).addClass("pnow"); 
		  xid=$(this).index();
		  $(".valcontentwrap .valcontent").hide();
		  $(".valcontentwrap .valcontent").eq(xid).show();
	   }	   
	);
   //关闭窗口
   $(".doclose").click(function() {
	   if(confirm("确定要退出吗？")){
	   		windowclose();
   		}
   });
 
});
function FrameLoad(){
	var d_left_content=document.getElementById("con_div");
	var winHeight = getBodyHeight();
	if(winHeight<450){
		winHeight=450;
	}
	d_left_content.style.height = winHeight - 72 - 85 - 57 - 30 + "px";
}

function getBodyHeight() {
	var height = (window.innerHeight || document.documentElement.clientHeight) || document.body.clientHeight;
	return height;
}

window.onresize=function(){ 
	FrameLoad();
}

function windowclose() {
     var browserName = navigator.appName;
        if(browserName == "Netscape") {
            window.open('', '_self', '');
            window.close();
            try {
                window.open('', '_self');
                window.close();
            } catch(e) {
                try {
                    window.open('', '_parent', '');
                    window.close();
                } catch(e) {
                    window.close();
                }
            };
            window.location.href = 'about:blank ';
        } else {
            if(browserName == "Microsoft Internet Explorer") {
                window.opener = null;
                window.open('', '_top');
                window.close();
            }
        }

};


//获取聊天的时间
function getTime(){
		var now= new Date();
		var year=now.getFullYear();
		var month=now.getMonth()+1;
		var day=now.getDate();
		var hour=now.getHours();
		var minute=now.getMinutes();
		var second=now.getSeconds();
		return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
}

//意见反馈
    $(".rdoGood").live('click',function(){
        $(".notManyi").hide();
    })
    $(".rdoBad").live('click',function(){
        $(".notManyi").show();
    })
	

function $xss(str,type){
//空过滤
if(!str){
return str===0 ? "0" : "";
}

switch(type){
case "none": //过度方案
return str+"";
break;
case "html": //过滤html字符串中的XSS
return str.replace(/[&'"<>\/\\\-\x00-\x09\x0b-\x0c\x1f\x80-\xff]/g, function(r){
return "&#" + r.charCodeAt(0) + ";"
}).replace(/ /g, " ").replace(/\r\n/g, "").replace(/\n/g,"").replace(/\r/g,"");
break;
case "htmlEp": //过滤DOM节点属性中的XSS
return str.replace(/[&'"<>\/\\\-\x00-\x1f\x80-\xff]/g, function(r){
return "&#" + r.charCodeAt(0) + ";"
});
break;
case "url": //过滤url
return escape(str).replace(/\+/g, "%2B");
break;
case "miniUrl":
return str.replace(/%/g, "%25");
break;
case "script":
return str.replace(/[\\"']/g, function(r){
return "\\" + r;
}).replace(/%/g, "\\x25").replace(/\n/g, "\\n").replace(/\r/g, "\\r").replace(/\x01/g, "\\x01");
break;
case "reg":
return str.replace(/[\\\^\$\*\+\?\{\}\.\(\)\[\]]/g, function(a){
return "\\" + a;
});
break;
default:
return escape(str).replace(/[&'"<>\/\\\-\x00-\x09\x0b-\x0c\x1f\x80-\xff]/g, function(r){
return "&#" + r.charCodeAt(0) + ";"
}).replace(/ /g, " ").replace(/\r\n/g, "<br />").replace(/\n/g,"<br />").replace(/\r/g,"<br />");
break;
}
}