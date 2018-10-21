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
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
      <script type="text/javascript">
    	window.onload = function(){
    		if(window.parent != window){
    			window.parent.location.href = "<%=request.getContextPath()%>/login.jsp"
    		}
    	};
    </script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top"  >
      <table class="header" style="width:100%">
        <tr>
          <td  class="logo">
            <div class="logo-project-name">手机银行体验机后台管理</div></td>
          <td class="logo-right"></td >
        </tr>
        <tr><td class="headLine" colspan="2"></td>
        </tr>
      </table>
    </div>
      <div class="leftPage">
        <div  class="fixed-bottom">
          <s:form action="userLogin">

            <tr><td colspan="2"><div class = "errorMSG"><s:actionerror cssStyle = "color:red"/></div></td></tr>
            <tr><td colspan="2" class="tableTitle"><s:property value="%{getText('page_title_user_login')}" /></td></tr>
            <s:textfield name="user.name" label="%{getText('label_username')}" />
            <s:password name="user.password" label="%{getText('label_password')}" onkeydown="if(event.keyCode==13){document.forms[0].submit();}"/>
            <tr>
              <td></td>
              <td>
                <input type="button" onclick="document.forms[0].submit();" value="登录" /></td>
            </tr>
          </s:form>
        </div>
      </div>
  </body>
</html>
