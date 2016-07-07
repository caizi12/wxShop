(function($) {

	/**
	 * 判断jquery的版本是否符合
	 */
	if (/1\.(0|1|2)\.(0|1|2)/.test($.fn.jquery) || /^1.1/.test($.fn.jquery)) {
		alert('dialog组件需要jQuery v1.2.3以上版本!  您正使用 v' + $.fn.jquery);
		return;
	}
	
	/**
	 * 弹出窗口展示
	 */
	$.dialog = $.dialog || {};
	
	$.dialog.type = {
	  MESSAGE_TYPE_SUCCESS:0,	//成功
	  MESSAGE_TYPE_INFO:1,		//信息
	  MESSAGE_TYPE_ALARM:2,		//警告
	  MESSAGE_TYPE_ERROR:3,		//错误
	  MESSAGE_TYPE_CONFIRM:4
	};
	
	// 右上角关闭窗口回调函数
	$.cancelCallBack = null;
	
	$.dialog.show = function(opts) {

		var _body = document.body;
		var screen_width = $(_body).width();
		var screen_height = $(_body).height();
		var window_height = $(window).height();
		var scroll_top = document.documentElement.scrollTop || document.body.scrollTop || 0;
		var msg_width = 0;
		var msg_height = 0;
		var _msg = {};
		var title_class;
		
		// 获取消息
		var msg = opts
				&& (opts.msg !== undefined || opts.message !== undefined) ? (opts.msg || opts.message)
				: undefined;

	    // 获取消息标题
		var msg_title = opts && opts.title !== undefined ? opts.title : undefined;
				
		// 消息类型
		var msg_type = opts && opts.type !== undefined ? opts.type : undefined;
		
		// 按钮
		var msg_btn = opts && opts.button !== undefined ? opts.button : undefined;

		// 右上角关闭窗口回调函数
		$.cancelCallBack = opts && opts.cancelCallBack !== undefined && jQuery.isFunction(opts.cancelCallBack) ? opts.cancelCallBack : null;
		
		//用于关闭此窗口（链接）
		var other_msg = opts
				&& (opts.other_msg !== undefined || opts.other_message !== undefined) ? (opts.other_msg || opts.other_message)
				: undefined;
		
		// 默认的消息显示类型
		if(msg_type==undefined){
		  msg_type = $.dialog.type.MESSAGE_TYPE_INFO;
		}
		// 不同消息类型的图标样式
		if(msg_type==$.dialog.type.MESSAGE_TYPE_SUCCESS){
		  tilte_class = "popSuccess";
		  msg_title = msg_title?msg_title:"成功";
		}else if(msg_type==$.dialog.type.MESSAGE_TYPE_INFO){
		  title_class = "popInfo";
		  msg_title = msg_title?msg_title:"信息";
		}else if(msg_type==$.dialog.type.MESSAGE_TYPE_ALARM){
		  title_class = "popAlarm";
		  msg_title = msg_title?msg_title:"警告";
		}else if(msg_type==$.dialog.type.MESSAGE_TYPE_ERROR){
		  title_class = "popError";
		  msg_title = msg_title?msg_title:"错误";
		}else if(msg_type==$.dialog.type.MESSAGE_TYPE_CONFIRM){
		  title_class = "popInfo";
		  msg_title = msg_title?msg_title:"信息";
		}
		
		
		
		if($('#lyr1').html()){
			/**	
			_msg = $('#lyr1');
			$('#msg_content').html(msg);
			if(msg_btn){
				$('#msg_btn').html(msg_btn);
			}
			_msg.show();
			
			 **/	
			$('#lyr1').replaceWith('');
		}
		//else{
			var buf_inner_html = [] ;
			
			buf_inner_html[buf_inner_html.length] = '<div id="lyr1" style="position:absolute; top:0; left:0; width:100%; height:100%;z-index:999999">';
			/*
			if($.browser.msie && /MSIE 6.0/.test(navigator.userAgent)){
				buf_inner_html[buf_inner_html.length] =  '<IFRAME class=dialog style="BORDER-RIGHT: medium none; PADDING-RIGHT: 0px; BORDER-TOP: medium none; PADDING-LEFT: 0px; Z-INDEX: 1000; FILTER: alpha(opacity=0); LEFT: 0px; PADDING-BOTTOM: 0px; MARGIN: 0px; BORDER-LEFT: medium none; WIDTH: 100%; PADDING-TOP: 0px; BORDER-BOTTOM: medium none; ZOOM: 1; POSITION: absolute; TOP: 0px; HEIGHT: 100%" src="javascript:false"></IFRAME>';
			}*/
			if($.browser.msie && /MSIE 6.0/.test(navigator.userAgent)){
			}else{
				buf_inner_html[buf_inner_html.length] =  '<div style="background:#c3c3c3; top:0; left:0; position:absolute; width:100%; min-width:980px; height:100%; filter:alpha(opacity=50); -moz-opacity:0.5; opacity:0.5;"></div>';
			}
			buf_inner_html[buf_inner_html.length] =  '  <div id="msg_box" style="position:absolute;">';
			if(msg_type==$.dialog.type.MESSAGE_TYPE_CONFIRM){
				buf_inner_html[buf_inner_html.length] =  '	  <div id="popBgB"><div id="pop">';
				buf_inner_html[buf_inner_html.length] =  '<div id="popB">';
			}else{
				buf_inner_html[buf_inner_html.length] =  '	  <div class="popBg"><div id="pop">';
				buf_inner_html[buf_inner_html.length] =  '<div id="popS">';
			}
			buf_inner_html[buf_inner_html.length] =  '	    <h4><span id="msg_title" class="' + title_class + '">' + msg_title + '</span><a href="#" onclick="$.dialog.cancel();">关闭</a></h4>';
			buf_inner_html[buf_inner_html.length] =  '     <div class="popInfoDetail">';
			buf_inner_html[buf_inner_html.length] =  '	      <p id="msg_content">' + msg + '</p>';
			if(msg_btn){
				buf_inner_html[buf_inner_html.length] =  '   <div id="msg_btn" class="popctrl">' + msg_btn + '</div>';
			}
			if(other_msg){
				buf_inner_html[buf_inner_html.length] =  '   <div class="ohrMsg"><a href="#" onclick="$.dialog.cancel();">'+other_msg+'</a></div>';
			}
			buf_inner_html[buf_inner_html.length] =  '	    </div>';
			buf_inner_html[buf_inner_html.length] =  '	  </div>';
			
			buf_inner_html[buf_inner_html.length] =  '  </div></div></div>';
			buf_inner_html[buf_inner_html.length] =  '</div>';
			
			var inner_html = buf_inner_html.join('');
			
			_msg = $(inner_html);
			$(_body).append(_msg);
		//}
		$('#lyr1').height(window_height<screen_height?screen_height:window_height);
		msg_width = $('#pop').width();
		msg_height = $('#pop').height();
		$('#msg_box').width(msg_width);
		$('#msg_box').css('left',(screen_width-msg_width)/2 + 'px');
		$('#msg_box').css('top', ((getViewportInfo().h - msg_height)/2 + scroll_top )+ 'px');
		if(0<$('#msg_btn button').length){
			$('#msg_btn button')[0].focus();
		}
		var p = $("#pop");
		if(p != null && p.bgiframe ) {
			p.bgiframe();
		}
	};
	
	function fixIE(){var wHeight=document.body.scrollHeight +'px';var wWidth=$(window).width()+'px';this.dialog.overlay.css({position:'absolute',height:wHeight,width:wWidth});this.dialog.container.css({position:'absolute'});this.dialog.iframe=$('<iframe src="javascript:false;">').css($.extend(this.opts.iframeCss,{opacity:0,position:'absolute',height:wHeight,width:wWidth,zIndex:1000,width:'100%',top:0,left:0})).hide().appendTo('body');}
	
	/**
	 * 弹出窗口关闭
	 */
	$.dialog.close = function() {
		$("#lyr1").hide();
		$.closeDialog();
	};
	
	/**
	 * 弹出窗口点击右上角按钮关闭
	 */
	$.dialog.cancel = function() {
		
		$.dialog.close();

		if(null != $.cancelCallBack) {
			$.cancelCallBack();
		}
	};
	
	/**
	 * 获取浏览器当前可见部分的高度和宽度
	 */
	function getViewportInfo() {     
	    var w = (window.innerWidth) ? window.innerWidth : (document.documentElement && document.documentElement.clientWidth) ? document.documentElement.clientWidth : document.body.offsetWidth;     
	    var h = (window.innerHeight) ? window.innerHeight : (document.documentElement && document.documentElement.clientHeight) ? document.documentElement.clientHeight : document.body.offsetHeight;    
	    return {w:w,h:h}; 
	}; 	
})(jQuery);