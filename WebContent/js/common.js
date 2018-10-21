/**
 * 通用JS
 */

/**
 * 选择框的当前选择值取得
 * @param selectObjName 选择框对象名
 * @returns 选择值
 */
function getSelectObjValue(selectObjName) {

  var selectObj = document.getElementById(selectObjName);
  var selectedValue =  selectObj.options[selectObj.options.selectedIndex].value;
  return selectedValue;
}

/**
 * 选择框的当前选择文本取得
 * @param selectObjName 选择框对象名
 * @returns 选择值
 */
function getSelectObjText(selectObjName) {

  var selectObj = document.getElementById(selectObjName);
  var selectedText =  selectObj.options[selectObj.options.selectedIndex].text;
  return selectedText;
}

/**
 * 指定选择框的选中项目
 * @param selectObjName 选择框对象名称
 * @param optionValue 选中值
 */
function setOptionSelected(selectObjName, optionValue) {
  var selectObj = document.getElementById(selectObjName);
  for (var i=0; i<selectObj.options.length; i++) {
    if (selectObj.options[i].value == optionValue) {
      selectObj.options[i].selected = "selected";
      break;
    }
  }
}

//自动计算框架高度
function iFrameHeight(id){
  var ifm= document.getElementById(id);
  var subWeb = document.frames ? document.frames[id].document : ifm.contentDocument;
  if(ifm != null && subWeb != null) {
    if (ifm.contentDocument) {// firefox
     if(id == "sideNaviFrame"){
        // 不明原因第一次加载侧栏导航时，计算的侧栏高度为0
        ifm.height= subWeb.body.scrollHeight < 100 ? subWeb.body.scrollHeight+700+'px':subWeb.body.scrollHeight;
      }else{
       // 动态计算的高度不一定精确，页面中加入包含了table，那么，返回的高度可能小于页面实际上的显示高度，产生滚动条
        var height = subWeb.body.scrollHeight < 500 ?500+'px':subWeb.body.scrollHeight+50+'px';
        ifm.height= height;
      }

    }else if (ifm.document && subWeb.body.scrollHeight) {
        ifm.height = subWeb.body.scrollHeight;
    } else{
      ifm.height = subWeb.body.scrollHeight;
      ifm.width = subWeb.body.scrollWidth;
    }
  }
}

/**
 * 结果一览的背景色设定
 */
function setBackColorForList() {

    // table 单双行颜色切换
    $(".ListTable tr:odd").css("background-color","rgb(254,254,254)");
    $(".ListTable tr:even").css("background-color","rgb(244,244,244)");
    $(".ListTable .listTable-td-rowspan-thStyle").css("background-color","#dbebf1");

}

/**
 * 结果一览的背景色设定（标题行为2行的场合）
 */
function setBackColorForList2() {

    // table 单双行颜色切换
    $(".ListTable tr:even").css("background-color","rgb(254,254,254)");
    $(".ListTable tr:odd").css("background-color","rgb(244,244,244)");
    $(".ListTable .listTable-td-rowspan-thStyle").css("background-color","#dbebf1");

}

/**
 * 返回用户一览
 */
function returnListUser() {
   document.forms[0].action="listUserInit.action";
   //document.getElementById("bankId").value = document.getElementById("bankIdOrgin").value;
  // document.getElementById("userName").value = document.getElementById("userNameOrgin").value;
   document.forms[0].submit();
}
