<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>微信公众号素材管理</title>
		<%@ include file="/jsp/common/common.jsp"%>
		<script src="${ctx}/resources/jquery/ligerui/lib/ligerUI/js/plugins/ligerLayout.js" type="text/javascript"></script>
		<%@ include file="/jsp/easyui-validate.jsp"%>
	</head>

	<body>
		<div id="layout1">
		 
			<div position="center" title="微信公众号素材维护">
				<form id="menuForm"> 
				<table height="400px" class="inputTable" cellpadding="0" cellspacing="1"
					 border="0" align="center">
				 	<tr>
						<td    colspan="2" >
							<h3>微信公众号素材查询</h3>
						</td>
					</tr>
					<tr>
						<th  align="right" width="100">
							 查询条件
						</th>
						<td >
						    <textarea rows="1" class="width3" id="materialGetParam" name="materialGetParam">${dataMap.materialGetParam }</textarea>
						</td>
					</tr>
				 	<tr id="actionDisplay">
						<th  align="right">查询结果
						</th>
						<td > 
				             <textarea rows="14" class="width4" id="materialInfo" name="materialInfo"></textarea>
						</td>
					</tr>
					<tr id="actionDisplay">
						<td  align="right"><br></td>
						<td > 
				             <input id="updateMenu" class="btn"  onclick="getMaterial()"  type="button" value="查询公众号素材信息"/>
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
 		 
 		function getMaterial(){
 		  $.post("${ctx}/weixin/material/getMaterial.do",{"materialParam":$("#materialGetParam").val()},
 		     function(data){
		      $("#materialInfo").val(data);
		  });
 		}
 		 
</script>