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
    <!--<script src="../../assets/js/ie-emulation-modes-warning.js"></script>-->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>

    <![endif]-->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/material/listMaterial.js"></script>
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
        <!-- 四个条件 -->
        <s:hidden id = "bankIdOrgin" name = "bankIdOrgin" value = "%{bankId}"/>
        <s:hidden id = "materialTypeOrgin" name = "materialTypeOrgin" value = "%{material_type}"/>
        <s:hidden id = "materialVersionOrgin" name = "materialVersionOrgin" value = "%{material_version}"/>
        <s:hidden id = "remarkOrgin" name = "remarkOrgin" value = "%{remark}"/>
        
        <s:hidden id = "bankIdOperation" name = "bankIdOperation"/>
        <s:hidden id = "userNameOperation" name = "userNameOperation"/>
        <s:hidden name = "userPriorityOperation" id ="userPriorityOperation"/>
        <s:hidden id = "updateDatetimeOperation" name = "updateDatetimeOperation"/>
        <div class="tableCaption">
          <div class="tableTitle"><s:property value="getText('page_title_list_user')123"/></div>
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
             <td><label class="label"><s:property value="%{getText('label_material')}"/></label></td> 
              <td>
              <s:select 
              		label="%{getText('label_material')}"
              		id="type"
              		name="material_type" 
              		list="{'体验机APP','银行素材','手机银行素材','第三方APP'}" 
              		headerKey=""
              		headerValue="全体"
              		theme = "simple"/></td>
            </tr>
            <tr>
              <td><label class="label"><s:property value="getText('label_version')"/></label></td>
              <td> <s:textfield name="material_version" id="version" theme = "simple"/> </td>
              
              <td><label class="label"><s:property value="getText('label_note')"/></label></td>
              <td><s:textfield name="remark" id="remark" theme = "simple"/></td>
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
                <td class="td-descripton"><s:property value="#ms.remark"/></td>
                <s:if test="#ms.release_status==1">
                <td>未发布</td>
                </s:if>
                <s:if test="#ms.release_status==2">
                <td>发布中</td>
                </s:if>
                <s:if test="#ms.release_status==3">
                <td>已发布</td>
                </s:if>
               <%--  <td class="td-descripton"><s:property value="#ms.release_status"/></td> --%>
               <s:if test="#ms.deploy_machine_num!=0&&#ms.release_status==2">
                <td class="td-descripton"><s:property value="#ms.deploy_machine_num"/>/10000</td>
               </s:if>
               <s:else>
               <td class="td-descripton">--</td>
               </s:else>
                <%-- <td class="td-descripton"><s:property value="#ms.deploy_machine_num"/>/10000</td> --%>
                 <s:if test="#ms.release_status==1">
                <td>
                    <s:a href="javascript:void(0);" onclick="delUser('%{#ms.name}', '%{#ms.update_datetime}');">删除</s:a>
                
                <input type="hidden" id="material_id"  name="material_id"  value="<s:property value="#ms.material_id" />">
               <%--  <td><a	href="${pageContext.request.contextPath }/toEdit.action?id=<s:property value="#ms.material_id" />">发布01</a></td> --%>
                <td>
                    <s:a href="javascript:void(0);" onclick="doRelease('%{#ms.material_id}')">发布</s:a>
                </td>
                 </s:if>
                 <s:else>
                 <td>--</td>
                 <td>--</td>
                 </s:else>
                 
              </tr>
            </s:iterator>
            </table>
          </s:else>
        </s:else>
      </s:form>
    </div>
  </body>
</html>
