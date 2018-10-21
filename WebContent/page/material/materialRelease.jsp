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
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/listUser.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/user/listMaterial.js"></script>
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
       	<!-- 素材类型 -->
        <s:hidden id = "materialTypeOrgin" name = "materialTypeOrgin" value = "%{xx}"/>
       	<!-- 版本 -->
        <s:hidden id = "materialVersionOrgin" name = "materialVersionOrgin" value = "%{xx}"/>
       	<!-- 备注 -->
        <s:hidden id = "remarkOrgin" name = "remarkOrgin" value = "%{userName}"/>
        <s:hidden id = "bankIdOperation" name = "bankIdOperation"/>
        <s:hidden id = "userNameOperation" name = "userNameOperation"/>
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
                        value="%{bankId}" theme = "simple"/></s:else>
                 </td>
             <td><label class="label"><s:property value="%{getText('label_material')}"/></label></td> 
              <td>
              <s:select 
              		label="%{getText('label_material')}"
              		name="material_type" 
              		list="{'体验机APP','银行素材','手机银行素材','第三方APP'}" 
              		headerKey=""
              		headerValue="全体"
              		theme = "simple"/>
              </td>
            </tr>
            <tr>
              <td><label class="label"><s:property value="getText('label_version')"/></label></td>
              <td> <s:textfield name="material_version" id="version" theme = "simple"/> </td>
              
              <td><label class="label"><s:property value="getText('label_note')"/></label></td>
              <td><s:textfield name="remark" id="note" theme = "simple"/></td>
            </tr>
          </table>
          <div class="rightClick">
            <ul class="list-search-cols">
              <li>
                  <input type="button" onclick="doSearch();return false;" value="查询" />
              </li>
              <li>
                  <input type="button" onclick="doReset()"  value="重置" />
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
                <td>素材类型</td>
                <td>版本号</td>
                <td class="td-descripton">备注</td>
                <td>发布状态</td>
                <td>已部署机器台数 </td>
                <td colspan="2">操作 </td>
              </tr>
           <s:iterator value="#request.list" id="ms" status="L">
              <tr>
                <td><s:property value="#request.pager.startRow + #L.index + 1"/></td>
                <td><s:property value="#ms.material_type"/></td>
                <td><s:property value="#ms.material_version"/></td>
                <td class="td-descripton"><s:property value="#ms.instruction"/></td>
                <td>
                  <s:if test="#session.userPriority == 3">&nbsp;</s:if>
                  <s:elseif test="%{#session.userName != #ms.name || #session.userBankId != #ms.bank_Id}">
                    <s:a href="javascript:void(0);" onclick="delUser('%{#ms.name}', '%{#ms.update_datetime}');">删除</s:a></s:elseif>
                  <s:else>&nbsp;</s:else></td>
                <td>
                  <s:if test="#ms.priority >= #session.userPriority">
                  	 <a	href="${pageContext.request.contextPath }/toEdit.action?name=<s:property value="#ms.name" />">发布</a>
                    </s:if>
                </td>
              </tr>
            </s:iterator>
            </table>
          </s:else>
        </s:else>
      </s:form>
    </div>
  </body>
</html>
