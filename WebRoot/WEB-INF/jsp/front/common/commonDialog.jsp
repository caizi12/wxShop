<%@ page language="java"  pageEncoding="UTF-8"%>
<!--弹出层-->
<div class="dialog detailDialog">
    <h2 onClick="DialogClose('.detailDialog');"></h2>
    <div class="layer">
        <p id="showMessage"></p>
        <div id="btnShow" class="btn_g">        	
        </div>
    </div>
</div>
<script>
		//弹出层-对话框
		function Dialog(dom){
		    $(dom).find('.dialog_cont').height($(window).height()-250);
		    var _domW =$(dom).width()/2;
		    var _domH = 150;
		    if(!$('body').find('.mask').length){
		        $('body').append('<div class=mask></div>'); 
		    }
		    $('.mask').height($(document).height()).show();
		    $(dom).css({'margin-left':-_domW,'margin-top':-_domH}).fadeIn();
		    if('undefined' == typeof(document.body.style.maxHeight)){
		         $("body").append('<iframe frameborder="0" class="ie6_iframe"></iframe>');
		         $('.ie6_iframe').height($(document).height());
		    }
		    $(window).resize(function(){
		        $(dom).find('.dialog_cont').height($(window).height()-250);
		        var _domW =$(dom).width()/2;
		        var _domH = 150;
		        $(dom).css({'margin-left':-_domW,'margin-top':-_domH});
		    });
		};
		
		//弹出层-关闭对话框
		function DialogClose(dom){
		    $(dom).fadeOut();
		    $(window).unbind('resize');
		    $('.mask').fadeOut(function(){
		        $('.mask').remove();
		        $(".ie6_iframe").remove();      
		    });
		    return false;
		};

		//设置弹出框内容
		function setDialogMessage(msg_btn, showMessage){
			Dialog('.detailDialog');
			$("#showMessage").html(showMessage);
	    	$("#btnShow").html(msg_btn);
		}
</script>