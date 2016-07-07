/*----------------------------- 
Name: parallax js
Design:Yzx
Time: 2014-08-04
-----------------------------*/


//tab选项卡
function clickFun(nav,navStyle,content){
	$("#"+nav).find("li").click(function(){
		$("#"+nav).find("li").removeClass(navStyle);
		$(this).addClass(navStyle);
		var index = $(this).index();
		$("#"+content).children().hide();
		$("#"+content).children("div").eq(index).show();
	});
}     

        




















