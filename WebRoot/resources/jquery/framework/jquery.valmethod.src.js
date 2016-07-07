(function($) {
	
	jQuery.val = {
		isNumber: function(value) {
			return (/^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(value));
		}
	} 
	
})(jQuery);