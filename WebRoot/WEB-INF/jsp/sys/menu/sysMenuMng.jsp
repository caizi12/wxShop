<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>系统菜单管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
		<%@ include file="/jsp/easyui-validate.jsp"%>
		<%@ include file="/jsp/zTree.jsp"%>
	</head>

	<body>
		<div id="layout1">
			<div position="left" title="菜单列表">
				<div style="margin: auto 0;">
					<ul id="menuTree" class="ztree"></ul>
				</div>
			</div>
			<div position="center" title="菜单维护">
				<form id="menuForm"> 
				<table height="400px" class="inputTable" cellpadding="0" cellspacing="1"
					 border="0" align="center">
					<tr>
						<th width="15%" align="right">
							菜单编号：
						</th>
						<td  width="85%" >
							<input class="formText width1" value=""
								readonly="true" type="text" title="自动生成" id="menuId" name="menuId" />
						</td>
					</tr>
					<tr>
						<th  align="right">
							菜单名称：
						</th>
						<td >
							<input class="formText easyui-validatebox width2" value=""
								required="true" type="text" id="menuName" name="menuName" validType="length[2,30]"/>
							<label class="requireField">
								*
							</label>
						</td>
					</tr>
					<tr >
						<th  align="right">
							菜单路径：
						</th>
						<td >
							<input type="text" name="menuUrl"
								class="formText width3 easyui-validatebox"
								maxLength="300" value="" />
						</td>
					</tr>
					<tr>
						<th  align="right">
							显示顺序：
						</th>
						<td >
							<input class="formText width1"   maxlength="3" type="text" name="sort" />
						</td>
					</tr>
					<tr>
						<th  align="right">
							上级菜单名称：
						</th>
						<td >
							<input class="formText easyui-validatebox width2" value=""
								required="true" readonly="true" type="text" invalidMessage='123' message="请选择上级菜单" id="parentMenuName" name="parentMenuName" />
							<label class="requireField">
								*
							</label>
							<input type="text" name="parentMenuId"  id="parentMenuId" value="" style="display: none" />
						</td>
					</tr>
					<tr>
						<th  align="right">
							状态：
						</th>
						<td >	<input value="" type="text" id="menuStatus" name="menuStatus" />
						 <input  type="hidden" id="status" value="" name="status" />	</td>
					</tr>
					<tr>
						<th  align="right">
							备注：
						</th>
						<td >
							<textarea rows="2" class="width2" name="menuDesc"></textarea>
						</td>
					</tr>
						<tr>
						<th  align="right">
							添加时间：
						</th>
						<td >
							<input class="formText width2" readonly="true" type="text" name="createDate" />
						</td>
					</tr>
					<tr>
					<th  align="right">
							 最后修改时间：
						</th>
						<td >
							<input class="formText width2"  readonly="true" type="text" name="updateDate" />
						</td>
					</tr>
					<tr id="actionDisplay">
						<td  align="right"><br></td>
						<td > 
				           <input id="save" class="btn" type="button" value="保 存"/>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</body>
</html>
	<SCRIPT type="text/javascript">
	
 
		$(document).ready(function(){
		
		 	var menuStatus=$("#menuStatus").ligerComboBox({
            width : 100,
            valueFieldID:"status",
            url: '${ctx}/sys/dict/querySysDictByDictVal.do?dictTypeValue=status',
            cancelable: false,
            valueField : 'dictValue',
            textField: 'dictName'
		   });
		
		   $("#layout1").ligerLayout({ leftWidth: 250 ,allowLeftCollapse:false,allowRightCollapse:false,allowBottomResize:true});
		   
		  var menuTree= initTree();
		
		//展示信息到右边
		function viewMenuInfoToRight(treeId, treeNode){ 
		  $('#menuForm').form('clear');
		  viewMenuInfo(treeNode.menuId);
		}
		
		//展示菜单信息
		function viewMenuInfo(menuId){
		   if(menuId!=null && menuId > 0){
			  $.post("${ctx}/sys/menu/selectSysMenuById.do",{'menuId':menuId},function(data){
			     $('#menuForm').form('load',data);
			     $("#parentMenuName").val(menuTree.getNodeByParam("menuId", data.parentMenuId).menuName) ;
			      menuStatus.setValue(data.status);
		     });
		   }
		}
		
			
	    //保存数据
		$("#save").bind("click",function(){
		
		   if(!($("#menuForm").form('validate'))) {
			 return false;
	        }
	         
	       var menuId=$.trim($("#menuId").val());
	       var submitFormField="#menuForm [name='menuName'],[name='menuUrl'],[name='sort'],[name='parentMenuId'],[name='menuDesc'],[name='status']";
	       
	       var postUrl='${ctx}/sys/menu/insertSysMenu.do';
	       //修改要提交menuId
		   if(menuId!=null && menuId.length>0){
		       submitFormField +=",[name='menuId']";
		       postUrl='${ctx}/sys/menu/updateSysMenu.do';
		   }
		 
		   $.post(postUrl,$(submitFormField).serializeArray(),function(data){
		       
		       $.ligerDialog.alert(data.msg, '提示', data.msgType);
		       if(data.msgType=='success'){
		            if(data.dataMap){
		               menuId=data.dataMap.menuId;
		            }
		            refreshTree();
		            $('#menuForm').form('clear');
		       }
		      viewMenuInfo(menuId);
		   });
			 
		});
			
			
		//当鼠标移动到节点上时，显示用户自定义的控件
		function addHoverDom(treeId, treeNode) { 
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode["menuId"]).length>0) return false;
			var sObj = $("#" + treeNode.tId + "_a");
			var btnStr = "<span class='button add' id='addBtn_" + treeNode["menuId"]+ "' title='添加下级菜单' onfocus='this.blur();'></span>";
			btnStr += "<span class='button remove' id='deleteBtn_" + treeNode["menuId"]+ "' title='删除' onfocus='this.blur();'></span>";
			sObj.append(btnStr);
			
			
			//单击添加下级资源按钮触发的事件
			var addBtn = $("#addBtn_"+treeNode["menuId"]);
			if (addBtn) {
				addBtn.bind("click", function(){
                   $('#menuForm').form('clear');
				   $("#parentMenuName").val(treeNode["menuName"]) ;
				   $('#parentMenuId').val(treeNode["menuId"]);
				   menuStatus.setValue("1");
				   return false;
                 });
			}
			
			//如果根节点 ，删除按钮不显示
			if(treeNode.level == 0){
			    $("#deleteBtn_"+treeNode["menuId"]).hide();
			}
			
			//单击删除按钮触发的事件
			var deleteBtn = $("#deleteBtn_"+treeNode["menuId"]);
			if(deleteBtn) deleteBtn.bind("click", function() {
			 
			//如果是叶子节点的话 ，删除按钮不显示
			if(treeNode["isParent"] && treeNode.children.length>0){
			 	 alert("请先删除该菜单下的所有子菜单再进行删除！");
			 	 return false;
			}
			    
			    
			if(confirm("确定删除【"+treeNode["menuName"]+"】该节点吗?")) {
			  $.post("${ctx}/sys/menu/deleteSysMenuById.do",{'menuId':treeNode["menuId"]},function(data){
			    if(data==1){
		         	$.ligerDialog.success('删除成功！');
		         	refreshTree(treeNode.getParentNode());
		         	$('#menuForm').form('clear');
		         }else {
		           $.ligerDialog.warn('删除失败！');
		         }
		      });
			}
			});
		
	};
			
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode["menuId"]).unbind().remove();
		$("#deleteBtn_"+treeNode["menuId"]).unbind().remove();
	};	
	
	
	  
		  //初始化树
	      function initTree(){
	    
	       	   var setting = {
			   view: {
			        dblClickExpand:true,
					addHoverDom: addHoverDom,
					removeHoverDom: removeHoverDom,
					selectedMulti: false
				},
				edit: {
					enable: false
				},
				data: {
					simpleData: {
						enable: true,
						idKey: "menuId",
						pIdKey: "parentMenuId",
						rootPId: null
					},
					key: {
						name: 'menuName'
					}
				},
				async: {
					enable: true,
					dataType: 'text',
					type: 'POST',
					url: '${ctx}/sys/menu/queryMenuList.do',
					autoParam: []		
				},
				callback: {
					beforeClick: viewMenuInfoToRight
				}
		     };
	    
		   var menuList = new Array();
           menuList.push({menuId: 0, parentMenuId: null, menuName: "菜单树",open: true,icon: '${ctx}/resources/jquery/zTree/css/zTreeStyle/img/diy/1_open.png'});
		   $.ajax({
			async: false,
			type: 'POST',
			url: '${ctx}/sys/menu/queryMenuList.do',
			success : function(data) {
 			     menuList = menuList.concat(data);
			}
	  	   });
	  	
	  	 return  $.fn.zTree.init($("#menuTree"), setting, menuList);
		}
		 
		//刷新整个树
		function refreshTree(nodeId){
		   var rootMenu=menuTree.getNodeByParam("menuId", '0');
		   menuTree.reAsyncChildNodes(rootMenu,"refresh");
		}   
			
	    	//根节点不显示删除节点
	    function hideRootEvent(treeId, treeNode) {
			return treeNode.level > 0;
		}
		
		//双击节点时，是否自动展开父节点的标识
		function dblClickExpand(treeId, treeNode) {
			return treeNode.level > 0;
		};
	
 });
	</SCRIPT>