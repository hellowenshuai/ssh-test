<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/Common.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/list.css">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/user/listUser.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		setBackColorForList();
		var obj = document.getElementById('myform');
		obj.onsubmit = function() {
			var newpass = document.getElementById("newpass");
			var confirmpass = document.getElementById("confirmpass");
			if (newpass.value != confirmpass.value) {
				passModifyMess.innerHTML = "* 两次输入的新密码不一致，请重新输入！";
				newpass.value = '';
				confirmpass.value = '';
				newpass.focus();
				return false;
			}
			if (newpass.value == '' && confirmpass.value == '') {
				passModifyMess.innerHTML = "*输入框为空，请重新输入！";
				newpass.value = '';
				confirmpass.value = '';
				newpass.focus();
				return false;
			}
			return true;
		};
	});
</script>
</head>
<body>
	<div class="container">
		<div class="tableCaption">
			<div class="tableTitle">密码修改</div>
			<hr />
		</div>
		<div align="center">
			<!-- 前台校验的提示信息 -->
			<b id="passModifyMess" style="color: red;"></b>
			<!-- 后台校验的提示信息 -->
			<b><span style="color: red" id="message">${message }</span></b>
			<form action="${pageContext.request.contextPath }/editPassword.action"
				method="post" id="myform">
				姓名：<input type="text" name="name" value="${name }" readonly="readonly"><br>
				<c:choose>
					<c:when test="${isSelf==1}">
					原密码：<input type="password" name="password" required><br>
					</c:when>
				</c:choose>
				新密码：<input type="password" name="rePassword01" id="newpass" required><br>
				确认密码：<input type="password" name="rePassword02" id="confirmpass" required><br>
				<button type='submit'>确认</button>
				<button type="button" onclick="javascript:history.back(-1);">返回</button>
			</form>
		</div>
	</div>
</body>
</html>