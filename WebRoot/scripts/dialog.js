/*
 
 */

function tip(code,level){
	$.ajax({
		type: 'GET',
		url: '../cache/tips.v2.json',
		dataType: 'json',
		success:function(data){
			$.messageInfo('',data[code],level);
		} 
	});
} 

;(function($) {

	if (/1\.(0|1|2)\.(0|1|2)/.test($.fn.jquery) || /^1.1/.test($.fn.jquery)) {
    alert('dialog组件需要jQuery v1.2.3以上版本!  您正使用 v' + $.fn.jquery);
    return;
	}

$.fn._fadeIn = $.fn.fadeIn;



// global $ methods for blocking/unblocking the entire page
$.dialog   = function(opts) { install(window, opts); };
$.closeDialog = function(opts) { remove(window, opts); };
$.messageInfo = function(title, message, type,func,path) {

    var imgPath = path || '';
	var $m = $('<div id="message_box"></div>');
	// 判断传入的函数是否为空
	if(func==null){
		func = '$.closeDialog();';	
	}else if(func!=null&&!jQuery.isFunction(func)){
		alert('传入参数func必须是函数对象，请传入正确的函数对象！');
		return false;
	}
	callBack = func;
	
	// 根据传入的type的值判断用什么信息的图片 
	// 0：成功
	// 1：信息
	// 2：询问
	// 3: 警告
	// 4：错误
	// 5: loading窗口，用于ajax的等待处理过程
	if(type==3){
		//img = '/styles/mzone/images/message_warn.gif';
        img = imgPath+'/styles/default/images/message_warn.gif';
		title = title!=''?title:'警告';
	}
	else if(type==2){
		img = imgPath+'/styles/default/images/message_confirm.gif';
		title = title!=''?title:'询问';
	}
	else if(type==4){
		img = imgPath+'/styles/default/images/message_error.gif';
		title = title!=''?title:'错误';
	}
	else if(type==5){
		img = imgPath+'/styles/default/images/message_busy.gif';
		title = title!=''?title:'加载';
	}
	else if(type==0){
		img = imgPath+'/styles/default/images/message_success.gif';
		title = title!=''?title:'成功';
	}
	else{
		img = imgPath+'/styles/default/images/message_info.gif';
		title = title!=''?title:'信息';
	}
	
	if(type!=5){
		$m.append('<div id="message_head"><div>' + title + '</div></div>');
	}
	
	$m.append('<div id="message_content"><table width="100%" cellspacing="10" style="border:none;"><tr><td align="center" valign="middle" style="border:none;"><img src="' + img + '"/></td><td align="left" style="border:none;">' + message + '</td></tr></table></div>');
	if(type==2){
		$m.append('<div id="message_btn"><button id="btn_confirm" onclick="callBack();">确定</button><button id="btn_ok" onclick="$.closeDialog();">取消</button></div>');
		
	}
	else if(type!=5){
		$m.append('<div id="message_btn"><button id="btn_ok" onclick="$.closeDialog();">确定</button></div>');
	}
	
  $.dialog({
		message: $m,
		css:{
			border: '1px solid #93AAC6',
			cursor:'default',
			backgroundColor: '#fff',
			width: '20%',
			left:  '40%'
		},
    overlayCSS:  {
        backgroundColor: '#CCCCCC',
        opacity:         '0.6'
    }		
  });
 
};

// convenience method for quick growl-like notifications  (http://www.google.com/search?q=growl)
$.growlUI = function(title, message, timeout) {
	var $m = $('<div class="growlUI"></div>');
	if (title) $m.append('<h1>'+title+'</h1>');
	if (message) $m.append('<h2>'+message+'</h2>');
	if (timeout == undefined) timeout = 3000;
    $.dialog({
		message: $m, fadeIn: 700, fadeOut: 1000, centerY: false,
		timeout: timeout, showOverlay: false,
		css: $.dialog.defaults.growlCSS
    });
};

// plugin method for blocking element content
$.fn.block = function(opts) {
    return this.unblock({ fadeOut: 0 }).each(function() {
        if ($.css(this,'position') == 'static')
            this.style.position = 'relative';
        if ($.browser.msie)
            this.style.zoom = 1; // force 'hasLayout'
        install(this, opts);
    });
};

// plugin method for unblocking element content
$.fn.unblock = function(opts) {
    return this.each(function() {
        remove(this, opts);
    });
};

$.dialog.version = 2.18; // 2nd generation blocking at no extra cost!

// override these in your code to change the default behavior and style
$.dialog.defaults = {
    // message displayed when blocking (use null for no message)
    message:  '<h1>Please wait...</h1>',

    // styles for the message when blocking; if you wish to disable
    // these and use an external stylesheet then do this in your code:
    // $.dialog.defaults.css = {};
    css: {
        padding:        0,
        margin:         0,
        width:          '20%',
        top:            '40%',
        left:           '40%',
        textAlign:      'center',
        color:          '#000',
        border:         '3px solid #aaa',
        backgroundColor:'#fff',
        cursor:         'wait'
    },

    // styles for the overlay
    overlayCSS:  {
        backgroundColor: '#000',
        opacity:         '0.6'
    },

	// styles applied when using $.growlUI
	growlCSS: {
		width:    '350px',
		top:      '10px',
		left:     '',
		right:    '10px',
	    border:   'none',
	    padding:  '5px',
	    opacity:  '0.6',
		cursor:    null,
	    color:    '#fff',
	    backgroundColor: '#000',
	    '-webkit-border-radius': '10px',
	    '-moz-border-radius':    '10px'
	},
	
	iframeSrc: 'javascript:false', // 'about:blank' fails on HTTPS

	// force usage of iframe in non-IE browsers (handy for blocking over objects and applets)
	forceIframe: false,

    // z-index for the blocking overlay
    baseZ: 1000,

    // set these to true to have the message automatically centered
    centerX: true, // <-- only effects element blocking (page block controlled via css above)
    centerY: true,

    // allow body element to be stetched in ie6; this makes blocking look better
    // on "short" pages.  disable if you wish to prevent changes to the body height
    allowBodyStretch: true,

    // be default dialog will supress tab navigation from leaving blocking content;
    constrainTabKey: true,

    // fadeIn time in millis; set to 0 to disable fadeIn on block
    fadeIn:  200,

    // fadeOut time in millis; set to 0 to disable fadeOut on unblock
    fadeOut:  400,

	// time in millis to wait before auto-unblocking; set to 0 to disable auto-unblock
	timeout: 0,

	// disable if you don't want to show the overlay
	showOverlay: true,

    // if true, focus will be placed in the first available input field when
    // page blocking
    focusInput: true,

    // suppresses the use of overlay styles on FF/Linux (due to performance issues with opacity)
    applyPlatformOpacityRules: true,

    // callback method invoked when unblocking has completed; the callback is
    // passed the element that has been unblocked (which is the window object for page
    // blocks) and the options that were passed to the unblock call:
    //     onUnblock(element, options)
    onUnblock: null,

    // don't ask; if you really must know: http://groups.google.com/group/jquery-en/browse_thread/thread/36640a8730503595/2f6a79a77a78e493#2f6a79a77a78e493
    quirksmodeOffsetHack: 4
};

// private data and functions follow...

var ie6 = $.browser.msie && /MSIE 6.0/.test(navigator.userAgent);
var pageBlock = null;
var pageBlockEls = [];

function install(el, opts) {
    var full = (el == window);
    var msg = opts && opts.message !== undefined ? opts.message : undefined;
    opts = $.extend({}, $.dialog.defaults, opts || {});
    opts.overlayCSS = $.extend({}, $.dialog.defaults.overlayCSS, opts.overlayCSS || {});
    var css = $.extend({}, $.dialog.defaults.css, opts.css || {});
    msg = msg === undefined ? opts.message : msg;

    // remove the current block (if there is one)
    if (full && pageBlock)
        remove(window, {fadeOut:0});

    // if an existing element is being used as the blocking content then we capture
    // its current place in the DOM (and current display style) so we can restore
    // it when we unblock
    if (msg && typeof msg != 'string' && (msg.parentNode || msg.jquery)) {
        var node = msg.jquery ? msg[0] : msg;
        var data = {};
        $(el).data('dialog.history', data);
        data.el = node;
        data.parent = node.parentNode;
        data.display = node.style.display;
        data.position = node.style.position;
		if (data.parent)
			data.parent.removeChild(node);
    }

    var z = opts.baseZ;

    // dialog uses 3 layers for blocking, for simplicity they are all used on every platform;
    // layer1 is the iframe layer which is used to supress bleed through of underlying content
    // layer2 is the overlay layer which has opacity and a wait cursor
    // layer3 is the message content that is displayed while blocking

    var lyr1 = ($.browser.msie) ? $('<iframe class="dialog" style="z-index:'+ (z++) +';display:none;border:none;margin:0;padding:0;position:absolute;width:100%;height:100%;top:0;left:0" src="'+opts.iframeSrc+'"></iframe>')
                                : $('<div class="dialog" style="display:none"></div>');

    var lyr2 = $('<div class="dialog blockOverlay" style="z-index:'+ (z++) +';display:none;cursor:wait;border:none;margin:0;padding:0;width:100%;height:100%;top:0;left:0"></div>');
    var lyr3 = full ? $('<div class="dialog blockMsg blockPage" style="z-index:'+z+';display:none;position:fixed"></div>')
                    : $('<div class="dialog blockMsg blockElement" style="z-index:'+z+';display:none;position:absolute"></div>');

    // if we have a message, style it
    if (msg)
        lyr3.css(css);

    // style the overlay
    if (!opts.applyPlatformOpacityRules || !($.browser.mozilla && /Linux/.test(navigator.platform)))
        lyr2.css(opts.overlayCSS);
    lyr2.css('position', full ? 'fixed' : 'absolute');

    // make iframe layer transparent in IE
    if ($.browser.msie)
        lyr1.css('opacity','0.0');

    $([lyr1[0],lyr2[0],lyr3[0]]).appendTo(full ? 'body' : el);

    // ie7 must use absolute positioning in quirks mode and to account for activex issues (when scrolling)
    var expr = $.browser.msie && ($.browser.version < 8 || !$.boxModel) && (!$.boxModel || $('object,embed', full ? null : el).length > 0);
    if (ie6 || (expr && lyr3[0].style.setExpression)) {
        // give body 100% height
        if (full && opts.allowBodyStretch && $.boxModel)
            $('html,body').css('height','100%');

        // fix ie6 issue when blocked element has a border width
        if ((ie6 || !$.boxModel) && !full) {
            var t = sz(el,'borderTopWidth'), l = sz(el,'borderLeftWidth');
            var fixT = t ? '(0 - '+t+')' : 0;
            var fixL = l ? '(0 - '+l+')' : 0;
        }

        // simulate fixed position
        $.each([lyr1,lyr2,lyr3], function(i,o) {
            var s = o[0].style;
            s.position = 'absolute';
            if (i < 2) {
                full ? s.setExpression('height','Math.max(document.body.scrollHeight, document.body.offsetHeight) - (jQuery.boxModel?0:'+opts.quirksmodeOffsetHack+') + "px"')
                     : s.setExpression('height','this.parentNode.offsetHeight + "px"');
                full ? s.setExpression('width','jQuery.boxModel && document.documentElement.clientWidth || document.body.clientWidth + "px"')
                     : s.setExpression('width','this.parentNode.offsetWidth + "px"');
                if (fixL) s.setExpression('left', fixL);
                if (fixT) s.setExpression('top', fixT);
            }
            else if (opts.centerY) {
                if (full) s.setExpression('top','(document.documentElement.clientHeight || document.body.clientHeight) / 2 - (this.offsetHeight / 2) + (blah = document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + "px"');
                s.marginTop = 0;
            }
			else if (!opts.centerY && full) {
				var top = (opts.css && opts.css.top) ? parseInt(opts.css.top) : 0;
				var expression = '((document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + '+top+') + "px"';
                s.setExpression('top',expression);
			}
        });
    }

    // show the message
	if (msg) {
		lyr3.append(msg);
		if (msg.jquery || msg.nodeType)
			$(msg).show();
	}
	if ($.browser.msie && opts.showOverlay)
		lyr1.show(); // opacity is zero
	if (opts.fadeIn) {
		if (opts.showOverlay)
			lyr2._fadeIn(opts.fadeIn);
		if (msg)
			lyr3.fadeIn(opts.fadeIn);
	}
	else {
		if (opts.showOverlay)
			lyr2.show();
		if (msg)
			lyr3.show();
	}

    // bind key and mouse events
    bind(1, el, opts);

    if (full) {
        pageBlock = lyr3[0];
        pageBlockEls = $(':input:enabled:visible',pageBlock);
        if (opts.focusInput)
            setTimeout(focus, 20);
    }
    else
        center(lyr3[0], opts.centerX, opts.centerY);

	if (opts.timeout) {
		// auto-unblock
		var to = setTimeout(function() {
			full ? $.closeDialog(opts) : $(el).unblock(opts);
		}, opts.timeout);
		$(el).data('dialog.timeout', to);
	}
};

// remove the block
function remove(el, opts) {
    var full = el == window;
	var $el = $(el);
    var data = $el.data('dialog.history');
	var to = $el.data('dialog.timeout');
	if (to) {
		clearTimeout(to);
		$el.removeData('dialog.timeout');
	}
    opts = $.extend({}, $.dialog.defaults, opts || {});
    bind(0, el, opts); // unbind events
    var els = full ? $('body').children().filter('.dialog') : $('.dialog', el);

    if (full)
        pageBlock = pageBlockEls = null;

    if (opts.fadeOut) {
        els.fadeOut(opts.fadeOut);
        setTimeout(function() { reset(els,data,opts,el); }, opts.fadeOut);
    }
    else
        reset(els, data, opts, el);
};

// move blocking element back into the DOM where it started
function reset(els,data,opts,el) {
    els.each(function(i,o) {
        // remove via DOM calls so we don't lose event handlers
        if (this.parentNode)
            this.parentNode.removeChild(this);
    });

    if (data && data.el) {
        data.el.style.display = data.display;
        data.el.style.position = data.position;
		if (data.parent)
			data.parent.appendChild(data.el);
        $(data.el).removeData('dialog.history');
    }

    if (typeof opts.onUnblock == 'function')
        opts.onUnblock(el,opts);
};

// bind/unbind the handler
function bind(b, el, opts) {
    var full = el == window, $el = $(el);

    // don't bother unbinding if there is nothing to unbind
    if (!b && (full && !pageBlock || !full && !$el.data('dialog.isBlocked')))
        return;
    if (!full)
        $el.data('dialog.isBlocked', b);

    if (b && !opts.showOverlay) // don't prevent events when overlay not in use
		return;

    // bind anchors and inputs for mouse and key events
    var events = 'mousedown mouseup keydown keypress';
    b ? $(document).bind(events, opts, handler) : $(document).unbind(events, handler);

// former impl...
//    var $e = $('a,:input');
//    b ? $e.bind(events, opts, handler) : $e.unbind(events, handler);
};

// event handler to suppress keyboard/mouse events when blocking
function handler(e) {
    // allow tab navigation (conditionally)
    if (e.keyCode && e.keyCode == 9) {
        if (pageBlock && e.data.constrainTabKey) {
            var els = pageBlockEls;
            var fwd = !e.shiftKey && e.target == els[els.length-1];
            var back = e.shiftKey && e.target == els[0];
            if (fwd || back) {
                setTimeout(function(){focus(back)},10);
                return false;
            }
        }
    }
    // allow events within the message content
    if ($(e.target).parents('div.blockMsg').length > 0)
        return true;

    // allow events for content that is not being blocked
    return $(e.target).parents().children().filter('div.dialog').length == 0;
};

function focus(back) {
    if (!pageBlockEls)
        return;
    var e = pageBlockEls[back===true ? pageBlockEls.length-1 : 0];
    if (e)
        e.focus();
};

function center(el, x, y) {
    var p = el.parentNode, fs = el.style;
    var l = ((p.offsetWidth - el.offsetWidth)/2) - sz(p,'borderLeftWidth');
    var t = ((p.offsetHeight - el.offsetHeight)/2) - sz(p,'borderTopWidth');
    if (x) s.left = l > 0 ? (l+'px') : '0';
    if (y) s.top  = t > 0 ? (t+'px') : '0';
};

function sz(el, p) {
    return parseInt($.css(el,p))||0;
};

function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}

})(jQuery);
