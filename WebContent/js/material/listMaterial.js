/*
 *素材一览
 */


/*
 * 恢复备份的检索条件
 */
function restorelistMaterialCondition() {
   document.getElementById("bankId").value = document.getElementById("bankIdOrgin").value;
   document.getElementById("type").value = document.getElementById("materialTypeOrgin").value;
   document.getElementById("version").value = document.getElementById("materialVersionOrgin").value;
   document.getElementById("remark").value = document.getElementById("remarkOrgin").value;
}
/*
 * 检索处理
 */
function doSearch() {
  document.forms[0].action="listMaterial.action";
  document.getElementById("currentPage").value = "";
  document.getElementById("turnPageType").value = "";
  document.forms[0].submit();
}

/*
 * 翻页处理_前页
 */
function prev() {
    document.forms[0].action="listMaterial.action";
    document.getElementById("turnPageType").value = "prev";
    restorelistMaterialCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_首页
 */
function first() {
    document.forms[0].action="listMaterial.action";
    document.getElementById("turnPageType").value = "first";
    restorelistMaterialCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_次页
 */
function next() {
    document.forms[0].action="listMaterial.action";
    document.getElementById("turnPageType").value = "next";
    restorelistMaterialCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_末页
 */
function last() {
    document.forms[0].action="listMaterial.action";
    document.getElementById("turnPageType").value = "last";
    restorelistMaterialCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_指定页跳转
 */
function spec() {
    document.forms[0].action="listMaterial.action";
    document.getElementById("turnPageType").value = "spec";
    document.getElementById("currentPage").value = document.getElementById("jump").value;
    restorelistMaterialCondition();
    document.forms[0].submit();
}


/**
 * 清空输入框
 */
function doReset(){
	 document.getElementById("remark").value = "";
	 document.getElementById("version").value = "";
	 var a = document.getElementById("type");
	 a.options[0].selected = true;
	 var a = document.getElementById("bankId");
	 a.options[0].selected = true;
}

/**
 * 素材发布
 */
function doRelease(id){
	document.forms[0].action="releaseMaterial.action?id="+id;
	restorelistMaterialCondition()
//	document.getElementById("turnPageType").value = "spec";
//	document.getElementById("currentPage").value = document.getElementById("jump").value;
//	window.location.href="releaseMaterial.action?id="+id;
	document.forms[0].submit();
}
/**
 * 素材一览
 */
function doMenuAction(action){
	alert(action);
//	document.forms[0].action=action;
//	restorelistMaterialCondition()
//	document.getElementById("turnPageType").value = "spec";
//	document.getElementById("currentPage").value = document.getElementById("jump").value;
//	window.location.href="listMaterialInit.action?target=detailFrame";
	javascript:parent.frames['detailFrame'].location=action;
//	target=detailFrame;
//	window.location.href="releaseMaterial.action?id="+id;
//	document.forms[0].submit();
}




