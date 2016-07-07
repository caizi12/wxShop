<%@ page language="java"  contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/public.css">
<script type="text/javascript" src="<%=path%>/resources/jquery/jquery-1.5.2.min.js"></script>
<script>var path = "<%=path%>";
function doSearch(){
    	var productName = $.trim($("#searchProductName").val());   
    	var CheckData = /<|>|'|;|&|_|#|"|'|\*|\^|\{|\}|\[|\]|\/\/|%|[\$]/;
    	var title = '搜索不正确';
    	if(CheckData.test(productName)){  
        	var msg = '您输入非法字符，请重新输入!';
        	alert(msg)    
    		$("#searchProductName").val('');
    		return;
    	}
        $("#searchProductForm").submit();
    	//window.location=path+"/product/list_page.do?productName="+ encodeURIComponent(encodeURIComponent(productName));
    }
</script>
