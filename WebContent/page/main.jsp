<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><s:property value="getText('page_title_main')"/></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Common.css">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top"  >
      <iframe src="<%=request.getContextPath()%>/page/pageComponent/header.jsp"  name="headFrame" id="headFrame"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0" height="77px"></iframe>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <iframe src="<%=request.getContextPath()%>/page/pageComponent/sideNavi.jsp" name="sideNaviFrame" id="sideNaviFrame" frameborder="0" marginwidth="0" marginheight="0" onload="iFrameHeight('sideNaviFrame')"></iframe>
        </div>
      </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" >
        <iframe src="listUserInit.action"  name="detailFrame" id="detailFrame" marginwidth="0"  frameborder="0" marginwidth="0" marginheight="0" onload="iFrameHeight('detailFrame')"></iframe>
      </div>
    </div>
    <%-- <s:include value="/page/pageComponent/city.jsp"></s:include> --%>
  </body>
</html>
