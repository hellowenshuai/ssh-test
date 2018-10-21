<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <!--<script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->
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
            <div class="error-msg"><s:property value="#request.systemError"/>
            </div>
            <div class="jump">
              <ul class="error-jump">
                <s:if test="#request.continueAfterError == 1">
                  <li><a href="javascript:void();" onclick="window.history.back();">返回上一页</a></li>
                </s:if>
                <li><a href="<%=request.getContextPath()%>/" target="_parent">重新登录</a></li>
                <!-- <li><a href="javascript:void();" onclick="custom_close();">关闭页面</a></li> -->
              </ul>
              <p>
                <s:if test="#request.continueAfterError == 1">您可能输入了错误的网址，或者网络资源已经删除或移动</s:if>
                <s:else>糟糕，登录超时了。</s:else>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
