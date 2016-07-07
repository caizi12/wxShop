function b(){
	h = $(window).height();
	t = $(document).scrollTop();
	if(t > h){
		$('.gotop .top').show();
	}else{
		$('.gotop .top').hide();
	}
}
$(function() {
	b();
	$('.gotop #indextop').click(function(){
		$("html,body").animate({ scrollTop: 0 },300);
	});
	
});
$(window).scroll(function(e){
	b();		
});