<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>用户登录</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Common.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/signin.css">
    <script type="text/javascript">
      function logout(){
        if(confirm("确定退出么？")){
          return true;
        }
        return false;
      }
    </script>
    <style type="text/css">
      table{
        border:none;
    }
    </style>
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
  <%--   <script src="../../assets/js/ie-emulation-modes-warning.js"></script> --%>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <table style="width:100%;height:77px">
      <tr style="background:#335077">
        <td class="logo"><div class="logo-project-name">  手机银行体验机后台管理</div></td>
        <td class="logo-right">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">您好：<s:property value="#session.userName"/></a></li>
            <li><a href="userLogout.action" target="_parent" class="header-right-logout" onclick="return logout();" onfocus="this.blur();">退出</a></li>
          </ul>
        </td>
      </tr>
      <tr><td class="headLine" colspan="2"></td></tr>
    </table>
  </body>
</html>