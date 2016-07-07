function doUpdate(num, subOrder,mobNum) {
        if (num == (wait / 1000)) {
            $("#sendButton_" + subOrder).attr("onclick", "reSend2DimSms('"+subOrder+"','"+mobNum+"')");
            $("#sendButton_" + subOrder).html("重发卡密");
        } else {
            wut = (wait / 1000) - num;
            var sendNum = 3;
            $("#sendButton_" + subOrder).html(wut);
        }
}
	var secs = 60;
    var wait = secs * 1000;//一分钟
    var wut;
    var g_flag = false;
	function reSend2DimSms(subOrder, mobNum) {
        var url =path;
        url += "/portal/user/web/UserOrderQueryAction?action=reSendSms";
		$.ajax({
			type:"post",
			dataType:"json",
			url:url,
			data:"subOrderId=" + subOrder + "&mobile=" + mobNum,
			success:function(data) {
			    if (data.msg == "success") {
			        $("#sendButton_" + subOrder).attr('onclick','');
			        for (var i = 1; i <= (wait / 1000); i++) {
			            window.setTimeout("doUpdate(" + i + " , '" + subOrder + "','"+mobNum+"')", i * 1000);
			        }
			    }
			    Dialog('.detailDialog');
			    msg = data.content;
	        	$("#showMessage").html(msg);
	    		$("#wareName").val('');
			}
		});

    }