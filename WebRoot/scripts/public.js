
$(function(){
    //单选
    $('.radio font:last-child').css('margin-right',0);
    $('.radio font').bind('click',function(){
        $(this).siblings().removeClass('active').find('input:radio').removeAttr('checked');
        $(this).addClass('active').find('input:radio').prop('checked',true);
        return false;
    });
});

//tab
$(function(){
    //选项卡重用
    clickFun('solid_data','active','wareInfoShowArea');	
    function clickFun(nav,navStyle,content){
        $("#"+nav).find("li").click(function(){
            $("#"+nav).find("li").removeClass(navStyle);
            $(this).addClass(navStyle);
            var index = $(this).index();
            $("#"+content).children().hide();
            $("#"+content).children("div").eq(index).show();
        });
    } 

});



  



































