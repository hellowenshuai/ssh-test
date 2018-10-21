<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>error page</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Common.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/errorPage.css">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script>-->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%-- <script type="text/javascript">
      function custom_close(){
       if(confirm("您确定要关闭本页吗？")){
         parent.window.opener=null;
         parent.window.open("","_self");
         parent.window.close();
       }else{}
       }
    </script> --%>
  </head>
  <body>
    <div class="container">
      <div class="center-div">
        <div class="error-title">抱歉，出错啦！</div>
        <div class="mainContent">
          <div class="left-img">
            <img alt="出错了" src="<%=request.getContextPath()%>/images/errorIma.PNG">
          </div>
          <div class="right-info">
            <div class="error-msg">无法处理您的请求内容！
            </div>
            <div class="jump">
              <ul class="error-jump">
                <li><a href="javascript:void();" onclick="window.history.back();">返回上一页</a></li>
              </ul>
              <p>您可能指定了无效的网址，或者所请求的资源文件无效。
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
