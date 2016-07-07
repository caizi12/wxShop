/**
 *  左边菜单
 *  author: lixiaojin
 */
(function($) {
	
	$.leftmenu = $.leftmenu || {};
	$.extend($.leftmenu, {
		version: "1.0.0",
		visiContWidth: 0,
		visiCont: null,
		isOpenTree: true,
		getAccessor: function(obj, expr) {
			if($.type(expr) == 'function') {
				return expr(obj);
			}
			var ret = obj[expr];
			if(ret === undefined) {
				try {
					var arr, i, p;
					if($.type(expr) == 'string') {
						arr = split(".");
						i = arr.length;
						if( i ) {
							ret = obj;
							while (ret && i--) {
								p = prm.shift();
								ret = ret[p];
							}
						}
					}
				} catch(e){}
			}
			return ret;
		},
		extend: function(methods) {
			$.extend($.fn.leftmenu, methods);
		}
	});
	
	$.fn.leftmenu = function(pin) {
		if($.type(pin) == 'string') {
			var fn = $.leftmenu.getAccessor($.fn.leftmenu, pin);
			if(!fn) {
				throw ("No Such Method: " + pin);
			}
			var args = $.makeArray(arguments).slice(1);
			return fn.apply(this, args);
		}
		return this.each(function() {
			$this = $(this);
			var opts = $.extend(true, {
				width: '230px',
				container: '#container',
				containerWidth: 0,
				containerLeft : 0,
				parentMenuId: null
			}, pin || {});
			$this.append('<div class="sidebar_s"><div class="collapse"><div class="toggleCollapse"><div></div></div></div></div><div class="sidebar"><div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div><div class="accordion" fillSpace="sidebar"></div></div>');
			var _accoBox = $('.accordion', $this);
			var _sbarBox = $('.sidebar_s', $this);
			var _barBox = $('.sidebar', $this);
			_barBox.css("width", opts.width);
			//ie firefox区别
			if($.browser.msie && $.browser.version < 8) {
				$('.toggleCollapse>h2').css('line-height', '26px');
			}
			$('.toggleCollapse', $this).mouseover(function() {
				$('>div', $(this)).addClass('divhover');
			}).mouseout(function() {
				$('>div', $(this)).removeClass('divhover');
			});
			var tree =  {
				initAcco: function() {
					if(opts.menus) {
						for(var i=0; i<opts.menus.length; i++) {
							if(opts.parentMenuId == opts.menus[i].parentMenuId) {
								if(tree.isLeaf(opts.menus[i].menuId)) {
									_accoBox.append('<div class="accordionHeaderSingle"><div onclick=\'' + 
											opts.openTabMethod + '({id: "' + opts.menus[i].menuId + '", title: "' + opts.menus[i].menuName + '", url: "' + opts.menus[i].menuUrl + '"})\'><span>Folder</span>' + 
											opts.menus[i].menuName + '</div></div>');
								} else {
									_accoBox.append('<div class="accordionHeader"><h2><span>Folder</span>' + opts.menus[i].menuName + '</h2></div>');
									_accoBox.append(tree.initTree(opts.menus[i].menuId));
								}	
							}
						}
					}
					_accoBox.append('<div class="accordionContent"><ul class="tree treeFolder"></ul></div>');
					$('div.accordionContent', _accoBox).not(":first").height(0).hide().children().hide();
					$('div.accordionHeader:first>h2', _accoBox).addClass("collapsable");
					var acHeight = $this.height() - $('.toggleCollapse', $this).outerHeight(true) - 3 -
							($('.accordionHeader, .accordionHeaderSingle', _accoBox).size() * $('.accordionHeader, .accordionHeaderSingle', _accoBox).first().height());
					$.leftmenu.visiContWidth = acHeight;
					$.leftmenu.visiCont = $('div.accordionContent:first', _accoBox);
					$.leftmenu.visiCont.height(acHeight);
					$('div.accordionHeader', _accoBox).click(function() {
						var $t = $(this);
						if(!$('h2', $(this)).hasClass("collapsable")) {
							$('>h2', $t).toggleClass('collapsable');
							//$(this).siblings('.accordionContent:visible').first().slideUp(300, 'linear');
							
							var $currVObj = $t.siblings('.accordionContent:visible').first();
							if($currVObj.prev().hasClass('accordionHeader')) {
								$('>h2', $currVObj.prev()).toggleClass('collapsable');
							}
							$currVObj.animate({height: 0}, 150, function() {
								$currVObj.children().hide();
								$currVObj.hide();
							});
							//$(this).next('.accordionContent:hidden').slideDown(300, 'linear');
							var currHObj = $t.next('.accordionContent:hidden');
							$.leftmenu.visiCont = currHObj;
							currHObj.animate({height: $.leftmenu.visiContWidth}, 148);
							currHObj.show().children().show();
						} else {
							$('>h2', $t).toggleClass('collapsable');
							var $currVObj = $t.siblings('.accordionContent:visible').first();
							$currVObj.animate({height: 0}, 150, function() {
								$currVObj.children().hide();
								$currVObj.hide();
							});
							var currHObj = $t.nextAll('.accordionContent:last');
							$.leftmenu.visiCont = currHObj;
							currHObj.animate({height: $.leftmenu.visiContWidth}, 148);
							currHObj.show().children().show();
						}
					});
				},
				initTree: function(parentMenuId) {
					var $ac = $('<div class="accordionContent"><ul class="tree treeFolder"></ul></div>');
					$('>ul', $ac).append(tree.addNodes(parentMenuId, 1));
					$('div.leftmenufolder', $ac).click(function() {
						$fe = $(this);
						$('div.expandable, div.collapsable', $fe).toggleClass('expandable').toggleClass('collapsable');
						$('div.last_expandable, div.last_collapsable', $fe).toggleClass('last_expandable').toggleClass('last_collapsable');
						$folder = $('div.folder_expandable, div.folder_collapsable', $fe).toggleClass('folder_collapsable').toggleClass('folder_expandable')
						if($folder.hasClass('folder_expandable')) {
							$folder.parent().next().slideUp('fast');
						} else {
							$folder.parent().next().slideDown('fast');
						}
					});
					$('ul>div', $ac).each(function() {
						$t = $(this);
						if($t.nextAll().filter('div').size() == 0) {
							if($t.hasClass('leftmenufolder')) {
								$('.expandable', $t).removeClass('expandable').addClass("last_expandable");
								$('.vline:eq(' + (parseInt($t.attr("level")) - 1) + ')', $('>div, ul>div', $t.next())).removeClass('line').addClass('line_empty');
							} else {
								$t.addClass('last');
							}
						}
					});
					if(opts.isOpenTree) {
						$('ul', $ac).show();
						$('div.expandable, div.collapsable', $ac).toggleClass('expandable').toggleClass('collapsable');
						$('div.last_expandable, div.last_collapsable', $ac).toggleClass('last_expandable').toggleClass('last_collapsable');
						$('div.folder_expandable, div.folder_collapsable', $ac).toggleClass('folder_collapsable').toggleClass('folder_expandable')
					}
					return $ac;
				},
				addNodes: function(parentMenuId, level) {
					var content = '';
					for(var i=0; i<opts.menus.length; i++) {
						if(parentMenuId == opts.menus[i].parentMenuId) {
							if(!tree.isLeaf(opts.menus[i].menuId)) {
								content += '<div class="leftmenufolder" level="' + level + '">' + tree.addSpace(level) + '<div class="expandable"></div><div class="folder_expandable"></div><a href="javascript:;">' + opts.menus[i].menuName + '</a></div><ul style="display:none;">' + tree.addNodes(opts.menus[i].menuId, level + 1) + '</ul>';
							} else {
								content += '<div level="' + level + '">' + tree.addSpace(level) + '<div class="node"></div><div class="file"></div><a href=\'javascript:' + opts.openTabMethod + '({id: "' + opts.menus[i].menuId + '", title:"' + opts.menus[i].menuName + '", url:"' + opts.menus[i].menuUrl + '"})\'>' + opts.menus[i].menuName + '</a></div>';
							}
						}
					}
					return content;
				},
				isRoot: function(parentMenuId) {
					var isExist = true;
					for(var i=0; i<settings.menus.length; i++) {
						if(parentMenuId == settings.menus[i].menuId) {
							isExist = false;
							break;
						}
					}
					return isExist;
				},
				isLeaf: function(parentMenuId) {
					var isExist = true;
					for(var i=0; i<opts.menus.length; i++) {
						if(parentMenuId == opts.menus[i].parentMenuId) {
							isExist = false;
							break;
						}
					}
					return isExist;
				},
				addSpace: function(level) {
					var content = "";
					for(var i=1; i<level; i++) {
						content += '<div class="line vline"></div>';
					}
					return content;
				}
			};
			tree.initAcco();
			//收缩
			$('.toggleCollapse div', _barBox).click(function() {
				var cleft = $(opts.container).position().left - (_barBox.outerWidth() - _sbarBox.outerWidth());
				var cwidth = $(opts.container).outerWidth() + (_barBox.outerWidth() - _sbarBox.outerWidth());
				var barleft = _sbarBox.position().left - _sbarBox.outerWidth() - _barBox.outerWidth(); 
				$(opts.container).animate({left: cleft, width: cwidth}, 100, function() {
					_barBox.animate({left: barleft}, 500, function() {
						_barBox.hide();
						var l = _sbarBox.position().left;
						_sbarBox.height($this.height() - 2).css('left', -50).show().animate({left: 0}, 200);
					});
				});
				return false;
			});
			//显示
			$('.toggleCollapse div', _sbarBox).click(function() {
				_sbarBox.animate({left: -30}, 200, function() {
					_barBox.show();
				})
				$(opts.container).unbind('click', hideBar);
				_barBox.animate({left: 0}, 800, function() {
					$('.toggleCollapse div', _barBox).show();
					var cleft = $(opts.container).position().left + (_barBox.outerWidth() - _sbarBox.outerWidth());
					var cwidth = $(opts.container).outerWidth() - (_barBox.outerWidth() - _sbarBox.outerWidth());
					$(opts.container).css({left: cleft, width: cwidth});
				});
				return false;
			});
			$('.collapse', _sbarBox).click(function() {
				if(_barBox.is(":hidden")) {
					var l = _sbarBox.position().left + _sbarBox.outerWidth() + 1;
					$('.toggleCollapse div', _barBox).hide();
					$('div.accordionContent:visible', _accoBox).height($.leftmenu.visiContWidth);
					_barBox.show().animate({left: l}, 200);
					$(opts.container).click(hideBar);
				} else {
					var barleft = _sbarBox.position().left - _sbarBox.outerWidth() - _barBox.outerWidth(); 
					_barBox.animate({left: barleft}, 200, function() {
						_barBox.hide();
					});
				}
				return false;
			});
			function hideBar() {
				$(opts.container).unbind('click', hideBar);
				var barleft = _sbarBox.position().left - _sbarBox.outerWidth() - _barBox.outerWidth(); 
				_barBox.animate({left: barleft}, 200, function() {
					_barBox.hide();
				});
			}
			this.leftmenu = {
				resize: function(height) {
					$.leftmenu.visiContWidth =  $.leftmenu.visiContWidth + (height - _barBox.height());
					if($.leftmenu.visiCont) {
						$.leftmenu.visiCont.height($.leftmenu.visiContWidth);
					}
					_sbarBox.height(height - 2);
				},
				collapse: function() {
					$(opts.container).css({left: opts.containerLeft, width: opts.containerWidth});
				}
			};
		});
		
	};
	
})(jQuery);

(function($) {
	$.leftmenu.extend({
		resize: function(height) {
			return this.each(function() {
				this.leftmenu.resize(height);
			});
		},
		collapse: function() {
			return this.each(function() {
				this.leftmenu.collapse();
			});
		}
	});
})(jQuery);