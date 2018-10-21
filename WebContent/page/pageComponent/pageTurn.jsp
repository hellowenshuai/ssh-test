<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 翻页控制 -->
<div class="changePage">
  <s:if test="%{pager.currentPage == 1}">
    <s:property value="%{getText('first_page')}"/>
  </s:if>
  <s:else>
    <s:a href="javascript:void(0);" onclick="first()">
      <s:property value="%{getText('first_page')}"/>
    </s:a>
  </s:else>
  &nbsp;&nbsp;
  <s:if test="%{pager.currentPage == 1}">
    <s:property value="%{getText('previous_page')}"/>
  </s:if>
  <s:else>
    <s:a href="javascript:void(0);" onclick="prev()">
      <s:property value="%{getText('previous_page')}"/>
    </s:a>
  </s:else>
  &nbsp;&nbsp;
  <s:property value="#request.pager.currentPage"/>/<s:property value="#request.pager.totalPages"/>&nbsp;
  <s:property value="%{getText('total_row')}"/><s:property value="#request.pager.totalRows"/><s:property value="%{getText('row_unit')}"/>
  &nbsp;&nbsp;
  <s:if test="%{pager.currentPage == pager.totalPages}">
    <s:property value="%{getText('next_page')}"/>
  </s:if>
  <s:else>
    <s:a href="javascript:void(0);" onclick="next()">
      <s:property value="%{getText('next_page')}"/>
    </s:a>
  </s:else>
  &nbsp;&nbsp;
  <s:if test="%{pager.currentPage == pager.totalPages}">
    <s:property value="%{getText('last_page')}"/>
  </s:if>
  <s:else>
    <s:a href="javascript:void(0);" onclick="last()">
      <s:property value="%{getText('last_page')}"/>
    </s:a>
  </s:else>
  &nbsp;&nbsp;
  <s:textfield id="jump" name="jump" value="%{pager.currentPage}" size="1" />
  <s:a href="javascript:void(0);" onclick="spec()">
    <s:property value="%{getText('jump_page')}"/>
  </s:a>
</div>
