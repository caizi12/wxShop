$(function(){
    $('.newInpt').click(function(){
       $(this).parent().find('.new_Icon').show();
    });
    $('.new_Icon').click(function(){
       $('.newInpt').val('');
    });
    $(".sortMain div").click(function(){
		   var divKind=$(this);
		   var ulKind=divKind.next(".sortListTxt");		   
			if(ulKind.css('display')=='none'){	
				$('.sortMain ul.WareKindType').hide();	
				$('.sortMain i.upsortListTit').removeClass('upsortListTit').addClass('downsortListTit');	
				ulKind.addClass('WareKindType').animate({height: 'toggle', opacity: 'toggle'}, "slow");
				divKind.find(".downsortListTit").removeClass('downsortListTit').addClass('upsortListTit');
			}else{
				ulKind.removeClass('WareKindType').animate({height: 'toggle', opacity: 'toggle'}, "slow");
				divKind.find(".upsortListTit").removeClass('upsortListTit').addClass('downsortListTit');
			}
	   });
    $('.insurList h2').click(function(){
        $(this).next('ul').stop().slideToggle(300); 
        return false;
    });
    $('.insurList li').click(function(){
        $(this).parent().prev('h2').html($(this).html());
        $(this).siblings().removeClass('active').end().addClass('active');
        $('.insurList ul').hide();
    });
    $('.insurList li').hover(function(){
        $(this).toggleClass('bg_eee');  
    });
    $(document).click(function(){
        $('.insurList ul').slideUp();
        $('.dateYear').fadeOut();
    }); 
});

function openMenu(){
	if($(".navList").css("display")=="none"){
		$('.navList').show();
		//重新设置suggest div位置
		suggestObj.resizeShowDiv();
	}else{
		$('.navList').hide();
		//重新设置suggest div位置
		suggestObj.resizeShowDiv();
	}
}