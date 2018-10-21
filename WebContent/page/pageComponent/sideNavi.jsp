<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><s:property value="getText('page_title_navi')" /></title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/Common.css">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<%--     <script src="../../assets/js/ie-emulation-modes-warning.js"></script> --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/material/listMaterial.js"></script>

</head>
<body>
	<form name="menu" target="detailFrame">
		<!--     用户信息管理 -->
		<ul class="nav nav-sidebar">
			<li class="active"><a><s:property
						value="getText('label_user_manage')" /><span class="sr-only">(current)</span></a></li>
			<li><a
				href="${pageContext.request.contextPath }/listUserInit.action"
				target=detailFrame><s:property
						value="getText('page_title_list_user')" /></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('user_info_update')" /></a></li>
		</ul>
		<!--     机器信息查询 -->
		<ul class="nav nav-sidebar">
			<li class="active"><a><s:property
						value="getText('label_system_manage')" /><span class="sr-only">(current)</span></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('page_title_list_machine')" /></a></li>
		</ul>
		<!--     素材配置 -->
		<ul class="nav nav-sidebar">
			<li class="active"><a><s:property
						value="getText('label_material_manage')" /><span class="sr-only">(current)</span></a></li>
			<li><a
				href="${pageContext.request.contextPath}/page/material/materialAdd.jsp"
				target=detailFrame><s:property
						value="getText('page_title_add_material')" /></a></li>
						
			<li><a href="javascript:void(0);" onclick="doMenuAction('listMaterialInit.action');" target=detailFrame><s:property
						value="getText('page_title_list_material')"/>onClick</a></li>
			<li><a
				href="${pageContext.request.contextPath}/listMaterialInit.action" target=detailFrame><s:property value="getText('page_title_list_material')" /></a></li>
						
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('page_title_list_advertise')" /></a></li>
		</ul>
		<!--     统计分析-->
		<ul class="nav nav-sidebar">
			<li class="active"><a><s:property
						value="getText('label_analyse_manage')" /><span class="sr-only">(current)</span></a></li>
			<li><a
				href="${pageContext.request.contextPath}/page/analyse/pageTitleDayUseAnalyse.jsp"
				target=detailFrame><s:property
						value="getText('page_title_day_use_analyse')" /></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('page_title_week_use_analyse')" /></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('page_title_month_use_analyse')" /></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('page_title_season_use_analyse')" /></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('page_title_year_use_analyse')" /></a></li>
			<li><a href="javascript:void(0);"
				onclick="doMenuAction('listUserInit.action');"><s:property
						value="getText('detailed_inquiry')" /></a></li>
		</ul>
	</form>
</body>
</html>