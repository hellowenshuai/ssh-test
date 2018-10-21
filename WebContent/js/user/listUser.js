/*
 * 用户一览
 */


/*
 * 恢复备份的检索条件
 */
function restorelistUserCondition() {
   document.getElementById("bankId").value = document.getElementById("bankIdOrgin").value;
   document.getElementById("userName").value = document.getElementById("userNameOrgin").value;
}
/*
 * 检索处理
 */
function doSearch() {
  document.forms[0].action="listUser.action";
  document.getElementById("currentPage").value = "";
  document.getElementById("turnPageType").value = "";
  document.forms[0].submit();
}

/*
 * 翻页处理_前页
 */
function prev() {
    document.forms[0].action="listUser.action";
    document.getElementById("turnPageType").value = "prev";
    restorelistUserCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_首页
 */
function first() {
    document.forms[0].action="listUser.action";
    document.getElementById("turnPageType").value = "first";
    restorelistUserCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_次页
 */
function next() {
    document.forms[0].action="listUser.action";
    document.getElementById("turnPageType").value = "next";
    restorelistUserCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_末页
 */
function last() {
    document.forms[0].action="listUser.action";
    document.getElementById("turnPageType").value = "last";
    restorelistUserCondition();
    document.forms[0].submit();
}

/*
 * 翻页处理_指定页跳转
 */
function spec() {
    document.forms[0].action="listUser.action";
    document.getElementById("turnPageType").value = "spec";
    document.getElementById("currentPage").value = document.getElementById("jump").value;
    restorelistUserCondition();
    document.forms[0].submit();
}
/*
 * 单击提示3级用户权限不足不能跳转
 */
function showDialog()
{
	  alert("权限不足");
}
/*
 * 单击添加用户跳转添加页面
 */
function addUser(){
	window.location.href="page/user/addUser.jsp";
}





