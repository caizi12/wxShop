(function($) {
	$.nav = $.nav || {};
	$.extend($.nav, {
		version: "1.0.0",
		tabId: 0,
		currentIndex: 0,
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
			$.extend($.fn.navtab, methods);
		}
	});
	
	$.fn.navtab = function(pin) {
		if($.type(pin) == 'string') {
			var fn = $.nav.getAccessor($.fn.navtab, pin);
			if(!fn) {
				throw ("No Such Method: " + pin);
			}
			var args = $.makeArray(arguments).slice(1);
			return fn.apply(this, args);
		}
		return this.each(function() {
			var $this = $(this);
			var opts = $.extend(true, {
				moreHeight: 200  //ie不支持max-height
			},
			pin || {});
			$this.empty();
			$this.append('<div class="tabsPage"><div class="tabsPageHeader"><div class="tabsPageHeaderContent"><ul class="navTab-tab"></ul></div><div class="tabsLeft">left</div><div class="tabsRight">right</div><div class="tabsMore">more</div></div><ul class="tabsMoreList"></ul><div class="navTab-panel tabsPageContent layoutBox"></div></div>');
			var _componetBox = $('.tabsPage', $this);
			var _tabBox = $('.navTab-tab', $this);
			var _panelBox = $('.navTab-panel', $this);
			var _moreBox = $('ul.tabsMoreList', $this);
			var _prevBtn = $('.tabsLeft', $this);
			var _nextBtn = $('.tabsRight', $this);
			var _moreBtn = $('.tabsMore', $this);
			_panelBox.height($this.height() - 29);
			//special css
			if($.browser.msie) {
				_moreBox.css("height", opts.moreHeight);
			}
			var nav = {
				getTabs: function() {
					return _tabBox.find('> li');
				},
				getPanels: function() {
					return _panelBox.find('> div');
				},
				getMoreLis: function() {
					return _moreBox.find('> li');
				},
				getLeft: function() {
					return _tabBox.position().left;
				},
				getScrollbarWidth: function() {
					return _componetBox.width() - 55;
				},
				getTabsWidth: function($tabs) {
					var w = 0;
					$tabs.each(function() {
						w += $(this).outerWidth(true);
					});
					return w;
				},
				visibleStart: function() {
					var l = this.getLeft();
					var w = 0;
					var $tabs = this.getTabs();
					for(var i=0; i<$tabs.size(); i++) {
						if(l + w >= 0) {
							return i;
						}
						w += $tabs.eq(i).outerWidth(true);
					}
					return 0;
				},
				visibleEnd: function() {
					var sw = this.getScrollbarWidth();
					var l = this.getLeft();
					var w = 0;
					var $tabs = this.getTabs();
					for(var i=0; i<$tabs.size(); i++) {
						w += $tabs.eq(i).outerWidth(true);
						if(l + w > sw) {
							return i;
						}
					}
					return $tabs.size();
				},
				scrollTab: function(iLeft) {
					_tabBox.animate({left: iLeft + "px"}, 200, this.scrollBtn);
				},
				scrollPrev: function() {
					var iStart = nav.visibleStart();
					if(iStart > 0) {
						nav.scrollTab(-nav.getTabsWidth(nav.getTabs().slice(0, iStart-1)));
					}
				},
				scrollNext: function() {
					var iEnd = nav.visibleEnd();
					if(iEnd < this.getTabs().size()) {
						nav.scrollTab(-nav.getTabsWidth(nav.getTabs().slice(0, iEnd+1)) + nav.getScrollbarWidth());
					}
				},
				scrollBtn: function() {
					var $tabs = nav.getTabs();
					var iw = nav.getTabsWidth($tabs);
					if(nav.getScrollbarWidth() > iw) {
						_prevBtn.hide();
						_nextBtn.hide();
						_tabBox.parent().removeClass("tabsPageHeaderMargin");
					} else {
						_prevBtn.show().removeClass("tabsLeftDisabled");
						_nextBtn.show().removeClass("tabsRightDisabled");
						_tabBox.parent().addClass("tabsPageHeaderMargin");
						if(nav.getLeft() >= 0) {
							_prevBtn.addClass("tabsLeftDisabled");
						} else if(nav.getLeft() <= nav.getScrollbarWidth() - iw) {
							_nextBtn.addClass("tabsRightDisabled");
						}
					}
				},
				scrollCurrent: function() {
					var iw = this.getTabsWidth(this.getTabs());
					if(this.getScrollbarWidth() >= iw) {
						this.scrollTab(0);
					} else if(this.getLeft() < this.getScrollbarWidth() - iw) {
						this.scrollTab(this.getScrollbarWidth() - iw);
					} else if($.nav.currentIndex < this.visibleStart()) {
						this.scrollTab(-this.getTabsWidth(this.getTabs().slice(0, $.nav.currentIndex)));
					} else if($.nav.currentIndex >= this.visibleEnd()) {
						this.scrollTab(nav.getScrollbarWidth() - nav.getTabs().eq($.nav.currentIndex).outerWidth(true) - nav.getTabsWidth(nav.getTabs().slice(0, $.nav.currentIndex)))
					}
				},
				indexTabId: function(tabId) {
					if(!tabId) {
						return -1;
					}
					var iOpenIndex = -1;
					this.getTabs().each(function(index) {
						if($(this).attr('tabId') == tabId) {
							iOpenIndex = index;
							return;
						}
					});
					return iOpenIndex;
				},
				switchTab: function(tabId) {
					var tabIndex = this.indexTabId(tabId);
					nav.getTabs().removeClass("selected").filter('[tabId="' + tabId + '"]').addClass("selected");
					nav.getMoreLis().removeClass("selected").filter('[moreId="' + tabId + '"]').addClass("selected");
					nav.getPanels().hide().filter('[panelId="' + tabId + '"]').show();
					$.nav.currentIndex = tabIndex;
					nav.scrollCurrent();
					nav.reloadTab(nav.getTabs().filter('[tabId="' + tabId + '"]').first());
				},
				addTab: function(p) {
					_tabBox.append('<li tabId="' + p.id + '"><a><span>' + p.title + '</span></a>' + (p.close?'<a href="javascript:;" class="close"></a>':'') + '</li>');
					var t = $('li[tabId="' + p.id + '"]', _tabBox);
					if(p.iconClass) {
						t.addClass('main');
						$('>a>span', t).wrap('<span class="' + p.iconClass + '"></span>');
					}
					if(!p.iconClass && p.icon) {
						t.addClass('main');
						$('>a>span', t).wrap('<span style="background:url(' + p.icon + ') no-repeat;width:auto;padding:0 0 0 15px;background-position:0 5px;"></span>');
					}
					if(t && t.size() > 0) {
						t.eq(0).unbind('click').click(function() {
							nav.switchTab(p.id);
						});
						$('.close', t).unbind('click').click(function() {
							nav.closeTab(p.id);
						});
					}
					t.data('options', p);
				},
				addMore: function(p) {
					_moreBox.append('<li moreId="' + p.id + '"><a href="javascript:" title="' + p.title + '">' + p.title + '</a></li>');
					$('a', _moreBox).filter(':last').each(function() {
						$(this).unbind('click').click(function() {
							nav.switchTab(p.id);
						});
					});
				},
				addPenal: function(p) {
					if(!p.lazy) {
						if(p.external) {
							_panelBox.append('<div panelId="' + p.id + '" class="page unitBox"><iframe src="' + p.url + '" style="width:100%;height:100%;" scrolling="auto" frameborder="0" border="0" marginwidth="0" marginheight="0"></iframe></div>');
						} else {
							_panelBox.append('<div panelId="' + p.id + '" class="page unitBox"></div>');
						}
					}
				},
				reloadTab: function($tab) {
					var opts = $tab.data("options");
					if(opts) {
						if(opts.lazy || $('[panelId="' + opts.id + '"]', _panelBox).size() == 0) {
							opts.lazy = false;
							nav.addPenal(opts);
						} else {
							if(opts.fresh) {
								$('[panelId="' + opts.id + '"]', _panelBox).html('<iframe src="' + opts.url + '" style="width:100%;height:100%;" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>');
							} else {
								try {
									$('[panelId="' + opts.id + '"]>iframe', _panelBox)[0].contentWindow.refresh();
								}catch(e){}
							}
						}
					}
				},
				closeTab: function(tabId) {
					var tabIndex = nav.indexTabId(tabId);
					var p = nav.getPanels().filter('[panelId="' + tabId + '"]');
					$('iframe', p).attr('src', '');
					p.remove();
					var t = nav.getTabs().filter('[tabId="' + tabId + '"]');
					t.remove();
					var m = nav.getMoreLis().filter('[moreId="' + tabId + '"]')
					m.remove();
					p = null;
					t = null;
					m = null;
					if(typeof(CollectGarbage) == "function") {
						delete p;
						delete t;
						delete m;
						CollectGarbage();
					}
					
					if(tabIndex == $.nav.currentIndex) {
						if(tabIndex > 0) {
							nav.switchTab(nav.getTabs().eq(tabIndex-1).attr("tabId"));
						} else {
							nav.switchTab(nav.getTabs().eq(0).attr("tabId"));
						}
					} else {
						nav.scrollCurrent();
						if($.nav.currentIndex >= tabIndex) {
							$.nav.currentIndex--;
						}
					}
				},
				resize: function(height) {
					_panelBox.height(height - 29);
				}
			}
			this.tabBox = _tabBox;
			this.componetBox = _componetBox;
			this.panelBox = _panelBox;
			this.nav = nav;
			this.opts = opts;
			_prevBtn.click(function() {
				nav.scrollPrev();
			});
			_nextBtn.click(function() {
				nav.scrollNext();
			});
			_moreBtn.click(function() {
				_moreBox.show();
				return false;
			});
			$(document).click(function() {
				_moreBox.hide();
			});
		});
	};

	
})(jQuery);

(function($) {
	$.nav.extend({
		openMore: function(tabs) {
			for(var i=0; i<tabs.length; i++) {
				if(!tabs[i].id) {
					tabs[i].id = "navtab" + $.nav.tabId;
				}
				if(!tabs[i].title) {
					tabs[i].title = "New Tab " + $.nav.tabId;
				}
				$.nav.tabId ++;
				var p = $.extend({id: tabs[i].id, url: tabs[i].url, close: true, fresh:false, external:true, lazy: true}, tabs[i] || {});
				this.each(function() {
					this.nav.addTab(p);
					this.nav.addMore(p);
					//this.nav.addPenal(p);
					if(tabs[i].show) {
						this.nav.switchTab(p.id);
					}
				});
			}
		},
		open: function(id, url, opts) {
			var num = 0;
			if(!id) {
				id = "navtab" + $.nav.tabId;
				num = $.nav.tabId;
				$.nav.tabId ++;
			}
			if(!opts.title) {
				opts.title = "New Tab " + num;
			}
			var p = $.extend({id: id, url: url, close: true, fresh:false, external:true, lazy: false}, opts || {});
			return this.each(function() {
				if(this.nav.indexTabId(p.id) >= 0) {
					this.nav.switchTab(p.id);
				} else {
					this.nav.addTab(p);
					this.nav.addMore(p);
					//this.nav.addPenal(p);
					this.nav.switchTab(p.id);
				}
			});
		},
		close: function(id) {
			return this.each(function() {
				this.nav.closeTab(id);
			});
		},
		reload: function(id) {
			return this.each(function() {
				this.nav.reloadTab(this.nav.getTabs().filter('[tabId="' + id + '"]').first());
			});
		},
		resize: function(height) {
			return this.each(function() {
				this.nav.resize(height);
			});
		}
	});
})(jQuery);