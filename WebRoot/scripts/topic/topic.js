
var columnHigth="";
var loadTopicWareAction = contextPath+'/portal/topic/web/TopicAction?action=loadTopicWare';
var pageNo=1; 
var param="topicId="+topicId;
var maxNo=0;
var loading = false;//

$(document).ready(function(){
	queryTopicWare(param);
	
	$(window).scroll(function(){                    
       var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();        
       if(bottomHeight<10){ 
           if(!loading&&pageNo<maxNo){ 
              	loading = true;               	
              	viewMore();                	
           }
       }
   });	
});
	
function viewMore(){
	pageNo = pageNo + 1;
	queryTopicWare(param);
}
function queryTopicWare(param){
	$('#list-loading').show();
	param = param + "&pageNo="+pageNo;       
    $.ajax({
        type: "POST",
        url: loadTopicWareAction,
        async: true,
        dataType: "json",
        data: param,
        error: function(obj,msg){
        alert(msg);
	    },
        success: function(data){
	    	var maxValue="";
	    	if(data!=''){	
	    		maxNo = data.maxNo;
		    	var html="";
	    		var topicWareData = data.topicWareData;    		    		
	    		for(var i=0;i<topicWareData.length;i++){
			    	html+='<li>';
			    	html+='<a href="'+topicWareData[i].wareUrl+'"><img src="'+contextPath+"/pic/ware/"+topicWareData[i].img+'" /></a>';
			    	html+='<div>'+topicWareData[i].wareName+'</div>';
			    	html+=topicWareData[i].pay;
			    	html+='</li>';
		    	}
	    		$('#topicWareUl').append(html);
	    		$('#list-loading').hide();
	    		loading = false;
		    }
        }          
    });
}
