<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>业务字典管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<%@ include file="/jsp/easyui-validate.jsp"%>
		 <script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
		 <script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
    <script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerSpinner.js" type="text/javascript"></script>
	</head>

	<body >
	    <div id="layout_query" >
	      <div position="left" title="查询" >
	           <form id="menuForm"> 
				<table height="450px" class="inputTable" cellpadding="0" cellspacing="1"
					 border="0" align="center">
					<tr>
						<th width="10%" align="right">
							字典ID：
						</th>
						<td  width="17%" >
							<input class="formText width1" value=""
								 type="text" title="自动生成" id="dictId" name="dictId" />
						</td>
						<th width="10%" align="right">
							字典名称：
						</th>
						<td width="17%">
							<input class="formText  width1" value=""
								 type="text" id="dictName" name="dictName" />
						 
						</td>
						<th width="10%" align="right">
							字典类型编码：
						</th>
						<td width="17%">
							<input class="formText width1" value=""
								 type="text" id="dictValue" name="dictValue" />
						</td>
					</tr>
					<tr >
						<th  align="right">
							字典类别：
						</th>
						<td >
							<input value=""
								 type="text" id="dictCategorySelect" name="dictCategorySelect" />
						</td>
						<th  align="right">
							状态：
						</th>
						<td >
						<input type="text" id="statusSelect"  name="statusSelect" />
								
							<input type="hidden" id="status"  name="status"
								value="" />
						</td>
						
					</tr>
					
					<tr>
					 <td colspan="5" align="center"> 
					 <input id="addDict" class="btn" type="button" value="新 增"/>
					  <input id="saveDict" class="btn" type="button" value="保 存"/>
					   <input id="delDict" class="btn" type="button" value="删 除"/>
					  <input id="refreshDictCache" class="btn" type="button" value="刷新缓存"/>
					  <input id="queryDict" class="btn"   type="button" value="查 询"/>
					    <input id="resetForm" class="btn" type="button" value="重 置"/>
					 </td>
					 <td> </td>
					</tr>
				</table>
				</form>
	      </div>
	    </div>
		<div id="layout1">
			<div position="left" title="字典列表">
			     <div id="maingrid"></div>
			</div>
		</div>
	</body>
</html>
<SCRIPT type="text/javascript">
	
$(document).ready(function(){

$.ligerDefaults.Grid.editors.maxLength=null;
 
 
 //$("#layout_query").ligerLayout({leftWidth: '99%',allowLeftCollapse:false, height: 160});

 $("#layout1").ligerLayout({ leftWidth: '99%',allowLeftCollapse:false,height:'100%'});

 var dictTypeData = [];
 <c:forEach items="${dictData.dictType}" var="dictType" >
   dictTypeData=dictTypeData.concat({"dictValue": "<c:out value="${dictType.dictValue}"/>","dictName":"<c:out value="${dictType.dictName}"/>"});
 </c:forEach>
 
 var dictStatus =[];
 <c:forEach items="${dictData.status}" var="status" >
   dictStatus=dictStatus.concat({"dictValue": "<c:out value="${status.dictValue}"/>","dictName":"<c:out value="${status.dictName}"/>"});
 </c:forEach>	
 
 var dictCategory =[];
 <c:forEach items="${dictData.dictCategory}" var="category" >
   dictCategory=dictCategory.concat({"dictValue": "<c:out value="${category.dictValue}"/>","dictName":"<c:out value="${category.dictName}"/>"});
 </c:forEach>	
 
 $("#statusSelect").ligerComboBox({
            width : 100,
            valueFieldID:"status",
            data:dictStatus,
            cancelable: true,
            valueField : 'dictValue',
            textField: 'dictName'
 });	 
 
 $("#dictCategorySelect").ligerComboBox({
            width : 100,
            valueFieldID:"dictCategory",
            data:dictCategory,
            //url: '${ctx}/sys/dict/querySysDictByDictTypeId.do?dictTypeId=1',
            cancelable: true,
            valueField : 'dictValue',
            textField: 'dictName'
 });	

 var dictGrid;
 function queryDict(){
     var param=$("#menuForm").serialize();
     dictGrid.loadServerData(param,null);
  }
 $("#queryDict").bind("click",queryDict)
   
 f_initGrid();
 function f_initGrid()
 { 
         dictGrid = $("#maingrid").ligerGrid({
         columns: [
         { display: '字典ID', name: 'dictId', width:'8%', type: 'int',frozen:true },
         { display: '字典名称', name: 'dictName',width:'12%',editor: {type: 'text' }},
         { display: '字典类型编码', name: 'dictValue',width:'12%',editor: {type: 'text' }},
         { display: '字典类型', width: '8%', name: 'dictType',type:'int',
             editor: { type: 'select', data: dictTypeData,readonly:true, valueColumnName: 'dictValue',displayColumnName:"dictName" },
             render: function (item)
             {    
                for(var i=0;i<dictTypeData.length;i++){
                 if (dictTypeData[i].dictValue==item.dictType)
                    return dictTypeData[i].dictName;
                 }
             }
         },
         { display: '字典类别', name: 'dictCategory', width: '12%', type: 'int', 
             editor: { type: 'select', data: dictCategory,readonly:true, valueColumnName: 'dictValue',displayColumnName:"dictName" },
             render: function (item)
             {    
                for(var i=0;i<dictCategory.length;i++){
                 if (dictCategory[i].dictValue==item.dictCategory)
                    return dictCategory[i].dictName;
                 }
             } 
          }, 
         { display: '排序', name: 'sort', width: '6%',editor: {type: 'text' ,maxLength:10 }
           },
         { display: '状态', name: 'status', width: '6%', editor: { type: 'select', data: dictStatus, valueColumnName: 'dictValue',displayColumnName:'dictName'  }
           ,render: function (item)
             {    
                for(var i=0;i<dictStatus.length;i++){
                 if (dictStatus[i].dictValue==item.status)
                    return dictStatus[i].dictName;
                 }
             }},
         { display: '备注', name: 'note', width: '20%',editor: {type: 'text' }}, 
         { display: '修改时间', name: 'updateDate', width: '12%'} 
         
         ],
         onSelectRow: function (rowdata, rowindex)
         {
             $("#txtrowindex").val(rowindex);
         },
         enabledEdit: true, 
         clickToEdit: true, isScroll: false,  
         url:'${ctx}/sys/dict/querySysDictList.do?dictType=0',
         width: '100%',
         delayLoad:false,
         height:'100%',
         pageSize:10,
         checkbox:true,
         allowAdjustColWidth:true
     });   
 }	 
	  
  $("#addDict").bind("click",function(){
         dictGrid.addEditRow({ 
                dictType: 0,
                dictCategory:1
            });
  })

   $("#delDict").bind("click",function(){ 
        var rows = dictGrid.getSelectedRows();
        if (!rows || rows.length<=0) { alert('请先选择数据'); return; }
        $.ligerDialog.confirm('确定要删除吗？', function (yes) { 
        if(yes){
             var dictIds = '';
	         $.each(rows,function(i){
	     		  dictIds += this.dictId+",";
		     });
		     $.post('${ctx}/sys/dict/batchDelSysDict.do',{'dictId':dictIds},function(data){
			     $.ligerDialog.success('删除成功！');
		     });
			  dictGrid.deleteSelectedRow();
	      } 
       });
    })
    
      
 $("#saveDict").bind("click",function(){ 
      var rows=new Array();
      dictGrid.endEdit();
      var changeDatas = dictGrid.getChanges();
      if(changeDatas.length<=0){ $.ligerDialog.warn('没有数据修改！');return;}  
     $.ajax({  
      type : 'POST',  
      contentType : 'application/json',  
      url : '${ctx}/sys/dict/batchSaveSysDict.do',  
      processData : false,  
      dataType : 'json',  
      data : JSON.stringify(changeDatas),  
      success : function(data) { 
         if(data.msgType=="success"){
            queryDict();
            $.ligerDialog.success('保存成功！');
          }else{
            $.ligerDialog.error('保存失败！');  
          } 
      },  
      error : function() {  
           $.ligerDialog.error('保存失败！');  
      }  
    });  
          
  })
     
      function cancelEdit() {
          var row = dictGrid.getSelectedRow();
          if (!row) { alert('请选择行'); return; }
          dictGrid.cancelEdit(row);
      }
      function cancelAllEdit()
      {
          dictGrid.cancelEdit();
      }
      function endEdit()
      {
          var row = dictGrid.getSelectedRow();
          if (!row) { alert('请选择行'); return; }
          dictGrid.endEdit(row);
      }
      function endAllEdit()
      {
          dictGrid.endEdit();
      }
    
  $("#resetForm").bind("click",function(){
  	$("#menuForm").form('clear');
  	 dictGrid.cancelEdit();
  });  
       
      function getSelected()
      { 
          var row = dictGrid.getSelectedRow();
          if (!row) { alert('请选择行'); return; }
          alert(JSON.stringify(row));
      }
      function getData()
      { 
          var data = dictGrid.getData();
          alert(JSON.stringify(data));
      } 

 });
 
	</SCRIPT>