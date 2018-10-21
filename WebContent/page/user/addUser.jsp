<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><s:property value="getText('page_title_list_user')"/></title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Common.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/list.css">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>

    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/listUser.js"></script>

   	</script>
   	
   	
    <script type="text/javascript">
	function reListUser()
    {
    	window.location.href("${pageContext.request.contextPath }/listUserInit.action");
    } 
    $(".message").html(""); 
    $(function() {
		$(".bitian").blur(function() {
			var value = this.value;

			if($(this).is("#username")) {
				if(value.length < 4) {
					$("#yhjy").html("<font color='red' class='onError'>*用户名太短了</font>");
				} else if(value.length > 13) {

					$("#yhjy").html("<font color='red' class='onError'>*用户名太长了</font>");
				} else {

					$("#yhjy").html("<font color='green' class='onSuccess'>*用户名可用</font>");
				}
			}

			if($(this).is("#password")) {
				if(value.length < 4) {
					$("#mmjy").html("<font color='red' class='onError'>*密码太短了</font>");
					return false;
				} else if(value.length > 13) {
					$("#mmjy").html("<font color='red' class='onError'>*密码太长了</font>");
					return false;
				} else {
					$("#mmjy").html("<font color='green' class='onSuccess'>*密码可用</font>");
					return true;
				}
			}
			var mm = $("#password").val();
			if($(this).is("#confirmpass")) {
				if(value != mm) {
					$("#yzmm").html("<font color='red' class='onError'>*密码不一致</font>");
				} else {
					$("#yzmm").html("<font color='green' class='onSuccess'>*密码输入一致</font>");
				}
			}
			if($(this).is("#explain")) {
				if(value.length ==0) {
					$("#smyz").html("<font color='red' class='onError'>*说明不能为空</font>");
				} else {
					$("#smyz").html("<font color='green' class='onSuccess'>*说明可用</font>");
				}
			}
			

		}).focus(function() {
			$(this).triggerHandler("blur");
		}).keyup(function() {
			$(this).triggerHandler("blur");
		})
		$("form").submit(function() {
			$(".bitian").trigger("blur");
			var length = $(".onError").length;
			if(length > 0 ) {
				alert("注册信息格式不正确");
				return false;
			}
			return true;
		});

	});
    /* ------------------------------ */
  	<%-- var success=<%=request.getAttribute("success") %>;
			var error=<%=request.getAttribute("error") %>;
			if(success==null){
				$("#message").html("<font color='green'>erro  r</font>");
			}else{
				$("#message").html("<font color='green'>success</font>");
			} --%>
     
    </script>

  </head>
  <body>
        <div class="container">
          
     	<form action="${pageContext.request.contextPath }/userAction.action" method="post">
        <s:hidden id = "currentPage" name = "currentPage"/>
        <s:hidden id = "turnPageType" name = "turnPageType"/>
        <s:hidden id = "bankIdOrgin" name = "bankIdOrgin" value = "%{bankId}"/>
        <s:hidden id = "userNameOrgin" name = "userNameOrgin" value = "%{userName}"/>
        <s:hidden id = "bankIdOperation" name = "bankIdOperation"/>
        <s:hidden id = "userNameOperation" name = "userNameOperation"/>
        <s:hidden name = "userPriorityOperation" id ="userPriorityOperation"/>
        <s:hidden id = "updateDatetimeOperation" name = "updateDatetimeOperation"/>
        <div class="tableCaption">
          <div class="tableTitle"><s:property value="getText('page_title_add_user')"/></div>
          <hr/>
        </div>
        <table align="center" width="100%">
        	<tr>
        		<td width="35%"></td>
        		<td>
        			 <div id="message">
        				<s:if test="#request.success!=null">
							<font color="red"><s:property value="#request.success"/> </font>	        
        				</s:if>
       					 <s:if test="#request.error!=null">
							<font color="red"> <s:property value="#request.error"/> </font>       
        				</s:if>
       				 </div>
        		</td>
        	</tr>
        	<tr>
        		<td width="35%"></td>
        		<td>
        			<h3>新用户</h3>
        		</td>
        	</tr>
        </table>
       
       
        
        
        <br>
        <div class="divCenter">
		<table align="center" width="100%">
			<tr>
				<td width="30%"></td>
				<td width="15%"><s:property value="getText('bel_bank')"/></td>
				<td>
					<s:if test="#session.userPriority == 1">
                  		<s:select label="%{getText('label_bank')}"
	                        name="bank_id"
	                        id="bankId"
	                        list="#session.bankList"
	                        listKey="bank_id"
	                        listValue="bank_name"
	                        headerKey="000"
	                        headerValue="%{getText('label_allBankName')}"
	                        size="1"
	                        value="%{bankId}" theme = "simple"/>
               		</s:if >
               		<s:else>
               			<s:select  label="%{getText('label_bank') }"
	                        name="bank_id"
	                        id="bankId"
	                        list="#session.bankList"
	                        listKey="bank_id"
	                        listValue="bank_name"
	                        headerValue="%{getText('label_allBankName')}"
	                        size="1"
	                        value="%{bankId}" theme = "simple" />
               		</s:else>
               		
               		
               		
	            </td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"></td>
				<s:if test="#session.userPriority == 1">
					<td><font color="blue">*默认所有银行,按自己需求修改</font></td>	
				</s:if>
				<s:else>
					<td><font color="blue">*默认账号所属银行,不可修改</font></td>	
				</s:else>
			</tr>
			<tr>
				<td width="30%"></td>		
				<td width="15%"><s:property value="getText('label_username')"/></td>
				<s:if test="#session.userPriority == 1 || #session.userPriority == 2">
					<td><input type="text" name="name" id="username" class="bitian"></td>
				</s:if>
				<s:else>
					<td><input type="text" name="name" id="username" class="bitian" disabled="disabled"></td>
				</s:else>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"></td>
					<td><span id="yhjy"><font color="blue">
						*用户名需在4-13位之间
					</font></span></td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"><s:property value="getText('label_password')"/></td>
				<s:if test="#session.userPriority == 1 || #session.userPriority == 2">
					<td><input type="password" name="password" id="password" class="bitian"/></td>
				</s:if>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"></td>
					<td><span id="mmjy"><font color="blue">*密码需在4-13位之间</font></span></td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"><s:property value="getText('label_confirm_password')"/></td>
				<s:if test="#session.userPriority == 1 || #session.userPriority == 2">
					<td><input type="password" name="confirmpass" id="confirmpass" class="bitian"/></td>
				</s:if>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"></td>
					<td><span id="yzmm"><font color="blue">*密码必须与上方密码相同</font></span></td>		
			</tr>

			<tr>
				<td width="30%"></td>
				<td width="15%"><s:property value="getText('label_priority')"/></td>
				<td>
					<s:if test="#session.userPriority == 1">
						<select name="priority" id="qx"> 
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
					</s:if>
					<s:else>
						<select name="priority" id="qx"> 
							<option value="2" selected>2</option>
							<option value="3">3</option>
						</select>
					</s:else>
				</td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"></td>
				<s:if test="#session.userPriority == 1">
					<td><font color="blue">*默认一级权限,按自己需求修改</font></td>
				</s:if>
				<s:else>
					<td><font color="blue">*只能添加2、3级权限</font></td>	
				</s:else>
					
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"><s:property value="getText('label_instruction')"/></td>
				<s:if test="#session.userPriority == 1 || #session.userPriority == 2">
					<td><input type="text" name="instruction" id="explain" class="bitian"/></td>
				</s:if>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="15%"></td>
					<td><span id="smyz"><font color="blue">*说明必须填写</font></span></td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td>&nbsp</td>
				<td>&nbsp</td>
			</tr>
			<tr>
				<td width="15%"></td>
				<td>&nbsp</td>
				<td>&nbsp</td>
			</tr>
			<tr width="30%">
				<td width="15%"></td>
					<td align="left"><input type="submit" value="确认"/></td>
					<td align="right">
						<input type="button" onclick="reListUser()" value="返回"/>
					</td>
				<td width="35%"></td>
			</tr>
		</table>
		</div>
	</form>
	</div>
  </body>
</html>
