<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>微信公众号菜单管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
		<%@ include file="/jsp/easyui-validate.jsp"%>
	</head>

	<body>
		<div id="layout1">
		 
			<div position="center" title="微信公众号菜单维护">
				<form id="menuForm"> 
				<table height="400px" class="inputTable" cellpadding="0" cellspacing="1"
					 border="0" align="center">
				 
					<tr>
						<th  align="right" width="100">
							微信公众号菜单：
						</th>
						<td >
							<textarea rows="14" class="width4" id="menuData" name="menuData">${dataMap.menuJson}</textarea>
						</td>
					</tr>
				 
					<tr id="actionDisplay">
						<td  align="right"><br></td>
						<td > 
				             <input id="updateMenu" class="btn"  onclick="createMenu()"  type="button" value="更新公众号菜单"/>
							 <input id="delMenu" class="btn" onclick="deleteMenu()" type="button" value="删除公众号菜单"/>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
 		 
 		function deleteMenu(){
 		  var errcode;
 		  $.getJSON("${ctx}/weixin/menu/deleteMenu.do",
 		     function(data){
		      errcode=data.errcode;
		  });
		  return errcode;
 		}
 		
 function createMenu(){
 		  $.post("${ctx}/weixin/menu/createMenu.do",{"menuData":encodeURIComponent($("#menuData").val())},
 		     function(data){
		      alert(data);
		  });
 		}		
</script>