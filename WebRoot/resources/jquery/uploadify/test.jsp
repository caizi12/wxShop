
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>My Uploadify Implementation</title>
	<link rel="stylesheet" type="text/css" href="uploadify.css">
 <script type="text/javascript" src="<%=request.getContextPath() %>/resources/jquery/jquery-1.5.2.min.js"></script>
			<script charset="utf-8" src="jquery.uploadify.min.js"></script>
	
	<script type="text/javascript">
	$(function() {
		$('#file_upload').uploadify({
			    'width':102,
				 'height':27,
				 'fileTypeDesc':'支持格式:jpg gif png',
				'fileTypeExts':'*.jpg;*.gif;*.png',
				'swf':'${ctx}/resources/jquery/uploadify/uploadify.swf',
				'uploader' : '${ctx}/sys/uploadProductImg.do',
				'buttonImage': '${ctx}/resources/img/upload.gif',
				'onUploadSuccess' : function(file, data, response) {
				     $("#pimg").attr("src",'${ctx}'+data);
           			  $.ligerDialog.success("图片上传成功！");
                 }	
		});
	});
	</script>
</head>
<body>
<input type="file" name="file_upload" id="file_upload" />
<img id="pimg" src="" height="100" width="200"/>
</body>
</html>