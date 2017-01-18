<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="聚合数据">
    <meta name="author" content="">

    <title>聚合数据平台</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/index/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="<%=request.getContextPath()%>/index/css/freelancer.min.css" rel="stylesheet">  
	<style>
		#portfolio .portfolio-item .portfolio-link .caption .caption-content{ top:36%;}
		#portfolio .portfolio-item .portfolio-link .caption .caption-content p{ font-size:16px; line-height:24px; margin:24px 16px 0;}
	</style>

</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom affix-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="<%=request.getContextPath()%>/index#page-top">聚合数据</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden active">
                        <a href="<%=request.getContextPath()%>/index#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">关于</a>
                    </li>
                     <li class="page-scroll">
                        <a href="<%=request.getContextPath()%>/login">登录</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive" src="<%=request.getContextPath()%>/index/img/portfolio/profile.png" alt="">
                    <div class="intro-text">
                        <span class="name">聚合数据</span>
                        <hr class="star-light">
                        <span class="skills">随时随地 - 方便快捷 - 智慧应用</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>应用数据的专家</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 portfolio-item">
                    <a href="http://127.0.0.1:8080/login" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                                <p>我是一个风骚的程序员</p>
                            </div>
                        </div>
                        <img src="<%=request.getContextPath()%>/index/img/portfolio/cabin.png" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="http://127.0.0.1:8080/login" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                                <p>我是一个有逼格的设计师</p>
                            </div>
                        </div>
                        <img src="<%=request.getContextPath()%>/index/img/portfolio/cake.png" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="http://127.0.0.1:8080/login" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                                <p>我是一个有风格的建筑师</p>
                            </div>
                        </div>
                        <img src="<%=request.getContextPath()%>/index/img/portfolio/circus.png" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="http://127.0.0.1:8080/login" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                                  <p>我是一个游戏狂，看看我的收藏吧！</p>
                            </div>
                        </div>
                        <img src="<%=request.getContextPath()%>/index/img/portfolio/game.png" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="http://127.0.0.1:8080/login" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                                 <p>我是一个保险柜..</p>
                            </div>
                        </div>
                        <img src="<%=request.getContextPath()%>/index/img/portfolio/safe.png" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="http://127.0.0.1:8080/login" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                                 <p>我是宅男，我喜欢潜水..</p>
                            </div>
                        </div>
                        <img src="<%=request.getContextPath()%>/index/img/portfolio/submarine.png" class="img-responsive" alt="">
                    </a>
                </div>
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section class="success" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>关于我们</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-lg-offset-2">
                    <p>我做了一个可以在线随时随地简单收藏的一个网站 
                    <br>可以在这个网站上分类整理收藏的网站或者文章，也可以查看别人都收藏了些什么。
                    <br>可以从浏览器收藏夹导入到我们的网站，也可以从我们的网站导出去做备份。
                    <br>根据共同的收藏可以找出我们相互兴趣的人。
                    </p>
                </div>
                <div class="col-lg-4">
                    <p>我们是一群热爱生活，热爱开源，热爱分享的IT人！
                     <br>开放、自由、分享、开源是我们的主题！
                     <br>当您的浏览器收藏夹收藏的网站或者文章大于1000份的时候，找东西绝对是个体力活。
                     <br>那就让聚合数据帮您解决吧，方便分类、整理、查询、搜索。
                     </p>
                </div>
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <a href="https://github.com/double-qiu" class="btn btn-lg btn-outline">
                        <i class="fa fa-download"></i> GITHUB--关注我们
                    </a>
                </div>
            </div>
        </div>
    </section>

    <!--Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>联系我们</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <br><br><br>
                    <p>请发邮件到这里
                         <a href="mailto:934590736@qq.com">
                            934590736@qq.com
                        </a>
                     </p>
                     <br>
                     <p>或者在github上面
                        <a href="https://github.com/double-qiu">
                                                           关注我们
                        </a>
                     </p>
         
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="text-center">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        <h3>位置</h3>
                        <p>银河系
                            <br.></br.>地球, 中国</p>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>联系我们</h3>
                        <ul class="list-inline">
                            <li>
                                <a href="https://github.com/double-qiu" class="btn-social btn-outline"><i class="fa fa-fw fa-github"></i></a>
                            </li>
                           
                        </ul>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>关于网站</h3>
                        <p>专注于收藏、分享、开源</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright © DOUBLE 2017
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
        <a class="btn btn-primary" href="<%=request.getContextPath()%>/index#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>


    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/index/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/index/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/index/vendor/jquery/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="<%=request.getContextPath()%>/index/js/jqBootstrapValidation.js"></script>
    <script src="<%=request.getContextPath()%>/index/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/index/js/freelancer.min.js"></script>
  



</body></html>