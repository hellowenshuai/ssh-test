<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><s:property value="getText('page_title_list_user')"/></title>
  </head>
<body>
<div class="tableCaption">
  <div class="tableTitle"><h3><s:property value="getText('page_title_modify_priority')"/></h3></div>
  <br><br>
  <div style="padding-left: 200px">
  <form action="${pageContext.request.contextPath }/modifyPermissions.action" method="post">
  	<input type="hidden" name="userName" value="<%=request.getParameter("userName") %>">
  	 用户名：
  	<input type="text" name=name readonly="readonly" value='<%=request.getParameter("userName") %> '>
  	
<!--   	判断登陆者权限显示可修改权限范围 -->
  	<br><br>
  	<s:if test="#session.userPriority == 1">权限：
  	<select name="priority">
		<option value="1">权限1</option>
		<option value="2">权限2</option>
		<option value="3">权限3</option>
		</select>
		</s:if>
	<s:elseif test="#session.userPriority == 2">权限：
	<select name="priority">
		<option value="2">权限2</option>
		<option value="3">权限3</option>
		</select>
		</s:elseif>
	<s:elseif test="#session.userPriority == 3">权限：
	<select name="priority">
		<option value="3">权限3</option>
		</select>
		</s:elseif>
	<s:else>&nbsp;</s:else>
	
	<br><br>
	
<!-- 	修改完成以后提示成功与否 -->
	<s:if test="#request.success!=null">
	 <font color="red"><s:property value="#request.success"/></font></s:if>
	<s:if test="request.error!=null">
	<font color="red"><s:property value="#request.error"/></font>
	</s:if>
	
	<br><br>
	
    <!-- 确认返回按钮 -->
	<input type="submit" value="确认" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" onclick="javascript:history.go(-1);" value="返回">
  </form>
  </div>
</div>

</body>
</html>