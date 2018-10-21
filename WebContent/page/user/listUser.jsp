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
<%--     <script src="../../assets/js/ie-emulation-modes-warning.js"></script> --%>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>

    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/listUser.js"></script>
    <script type="text/javascript">
      $(document).ready(function(){
        setBackColorForList();
      });
    </script>
  </head>
  <body>
    <div class="container">
      <s:form action="listUser">
        <s:hidden id = "currentPage" name = "currentPage"/>
        <s:hidden id = "turnPageType" name = "turnPageType"/>
        <s:hidden id = "bankIdOrgin" name = "bankIdOrgin" value = "%{bankId}"/>
        <s:hidden id = "userNameOrgin" name = "userNameOrgin" value = "%{userName}"/>
        <s:hidden id = "bankIdOperation" name = "bankIdOperation"/>
        <s:hidden id = "userNameOperation" name = "userNameOperation"/>
        <s:hidden name = "userPriorityOperation" id ="userPriorityOperation"/>
        <s:hidden id = "updateDatetimeOperation" name = "updateDatetimeOperation"/>
        <div class="tableCaption">
          <div class="tableTitle"><s:property value="getText('page_title_list_user')"/></div>
          <hr/>
        </div>

         <!-- 检索条件部 -->
        <div class="divCenter">
          <table class="searchTable" >
            <tr>
              <td><label class="label"><s:property value="getText('label_bank')"/></label></td>
              <td>
                <!-- super user -->
                <s:if test="#session.userPriority == 1">
                  <s:select label="%{getText('label_bank')}"
                        name="bankId"
                        id="bankId"
                        list="#session.bankList"
                        listKey="bank_id"
                        listValue="bank_name"
                        headerKey="000"
                        headerValue="%{getText('label_allBankName')}"
                        size="1"
                        value="%{bankId}" theme = "simple"/>
                </s:if>
                <!--2,3 user -->
                <s:else>
                  <s:select label="%{getText('label_bank')}"
                        name="bankId"
                        id="bankId"
                        list="#session.bankList"
                        listKey="bank_id"
                        listValue="bank_name"
                        size="1"
                        value="%{bankId}" theme = "simple"/></s:else></td>
              <td><label class="label"><s:property value="getText('label_username')"/></label></td>
              <td>
                <s:if test="#session.userPriority == 3">
                  <s:textfield name="userName" id="userName" theme = "simple" disabled = "true"/></s:if>
                <s:else>
                  <s:textfield name="userName" id="userName" theme = "simple"/>
                </s:else></td>
            </tr>
          </table>
          <div class="rightClick">
            <ul class="list-search-cols">
              <li>
                <s:if test="#session.userPriority == 3">&nbsp;</s:if>
                <s:else>
                  <input type="button" onclick="doSearch();return false;" value="查询" />
                </s:else>
              </li>
              <li>
                <s:if test="#session.userPriority == 3">
					<input type="button"  onclick="showDialog()" value="添加用户" />
				</s:if>
                <s:else>
                  <input type="button" onclick="addUser()"  value="添加用户" />
                </s:else>
              </li>
            </ul>
          </div>
        </div>
        <div><s:actionerror cssStyle = "color:red"/></div>
        <s:if test="%{hassError == true}"></s:if>
        <s:else>
          <s:if test="%{totalRows < 1}">
            <s:property value="%{getText('msg_no_data_found')}"/>
          </s:if>
          <s:else>
            <s:include value="/page/pageComponent/pageTurn.jsp" />
            <table class="ListTable">
              <tr>
                <td>No.</td>
                <td>银行 </td>
                <td>用户名 </td>
                <td class="td-descripton">说明 </td>
                <td>用户权限 </td>
                <td>修改密码 </td>
                <td>修改权限 </td>
                <td>删除 </td>
              </tr>
            <s:iterator value="#request.list" id="us" status="L">
              <tr>
                <td><s:property value="#request.pager.startRow + #L.index + 1"/></td>
                <td><s:property value="#us.bank_name"/></td>
                <td><s:property value="#us.name"/></td>
                <td class="td-descripton"><s:property value="#us.instruction"/></td>
                <td>
                  <s:if test="#us.priority == 1"><s:property value="%{getText('super_user')}"/></s:if>
                  <s:elseif test="#us.priority == 2"><s:property value="%{getText('read_write')}"/></s:elseif>
                  <s:elseif test="#us.priority == 3"><s:property value="%{getText('read_only')}"/></s:elseif>
                  <s:else>&nbsp;</s:else></td>
                <td>
                  <s:if test="#us.priority >= #session.userPriority">
                  	 <a	href="${pageContext.request.contextPath }/toEdit.action?name=<s:property value="#us.name" />">修改密码</a>
                    </s:if></td>
                <td>
                  <s:if test="#session.userPriority == 1 && #us.priority >= 1">
                  <a href="${pageContext.request.contextPath }/page/user/modifyPermissions.jsp?userName=<s:property value="#us.name"/>&userProvity=<s:property value="#us.priority"/>">修改权限</a></s:if>
                  <s:elseif test="#session.userPriority == 2 && #us.priority >= 2">
                  <a href="${pageContext.request.contextPath }/page/user/modifyPermissions.jsp?userName=<s:property value="#us.name"/>&userProvity=<s:property value="#us.priority"/>">修改权限</a></s:elseif>
                  <s:elseif test="#session.userPriority == 3 && #us.priority >= 3"></s:elseif>
                  <s:else>&nbsp;</s:else>
                  </td>
                <td>
                  <s:if test="#session.userPriority == 3">&nbsp;</s:if>
                  <s:elseif test="%{#session.userName != #us.name || #session.userBankId != #us.bank_Id}">
                    <s:a href="javascript:void(0);" onclick="delUser('%{#us.name}', '%{#us.update_datetime}');">删除</s:a></s:elseif>
                  <s:else>&nbsp;</s:else></td>
              </tr>
            </s:iterator>
            </table>
          </s:else>
        </s:else>
      </s:form>
    </div>
  </body>
</html>
