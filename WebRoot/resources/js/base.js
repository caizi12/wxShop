
/*
 *系统公共函数 
 *部分函数需要jquery支持
 *Date：2012-11-23
 *
*/

/*
 *禁用form表单中所有的input[文本框、复选框、单选框],select[下拉选],多行文本框[textarea]
 * formId:form表单Id
 * isDisabled:true/false
*/
function disableForm(formId,isDisabled) {
    
    var attr="disable";
	if(!isDisabled){
	   attr="enable";
	}
	$("form[id='"+formId+"'] :text").attr("disabled",isDisabled);
	$("form[id='"+formId+"'] textarea").attr("disabled",isDisabled);
	$("form[id='"+formId+"'] select").attr("disabled",isDisabled);
	$("form[id='"+formId+"'] :radio").attr("disabled",isDisabled);
	$("form[id='"+formId+"'] :checkbox").attr("disabled",isDisabled);
	
	//禁用jquery easyui中的下拉选
	$("#" + formId + " input[class='combobox-f combo-f']").each(function () {
		if (this.id) {
			$("#" + this.id).combobox(attr);
		}
	});
	
	//禁用jquery easyui中的下拉选
	$("#" + formId + " select[class='combobox-f combo-f']").each(function () {
		if (this.id) {
			$("#" + this.id).combobox(attr);
		}
	});
	
	//禁用jquery easyui中的日期组件dataBox
	$("#" + formId + " input[class='datebox-f combo-f']").each(function () {
		if (this.id) {
			$("#" + this.id).datebox(attr);
		}
	});
}

