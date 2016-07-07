 $(".liarea").click(function(){
        window.location="<%=path%>/ware/"+$(this).attr('name')+".html";
	});
	
    $(document).ready(function(){       	
    	queryWareRank(param);
    	$(window).scroll(function(){                    
           var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();        
           if(bottomHeight<5){
        	   if(!loading&&pageNo<maxNo){ 
                 	loading = true;               	
                 	viewMore();                	
              }              
           }
       });		
    });
    function viewMore(){
        pageNo=pageNo+1;
        queryWareRank(param);
    } 
            	
	//查询排行榜基本信息	
	function queryWareRank(param){
		param=param+"&pageNo="+pageNo;
		$('p.list-loading').show();   
        $.ajax({
            type:"POST",
            url:pageAction,
            async:true,
            dataType:"json",
            data: param,
            error: function(obj,msg){},
            success: function(data){
	            var html="";
		    	var maxValue="";
		    	if(data!=''&&data.wareInfos.length>0){	
		    		maxNo = data.maxNo;
			    	var step=20*(pageNo-1);
			    	var rankNo=0;  		    			    		    	  			    		    				    	
			    	for(var i=0;i<data.wareInfos.length;i++){
			    		maxValue = data.wareInfos[i].oriIntegral;
						html+="<li class=\"clearfix\"  name="+data.wareInfos[i].wareId+">";
						rankNo=step+i+1;
						html+="<div class=\"topNum\"><span>"+rankNo+".</span></div>";
				    	html+="<div><a href="+contextPath+"/ware/"+data.wareInfos[i].wareId+".html  target=\"_self\">";	
				    	html+="<img  class=\"rankimg\" src="+contextPath+"/pic/ware/"+data.wareInfos[i].mainPicFile+"></a>";
				    	html+=" <h2 class=\"comList\"> <a href="+contextPath+"/ware/"+data.wareInfos[i].wareId+".html  target=\"_self\" ";
				    	html+=">"+data.wareInfos[i].wareName+"</a></h2>";
				    	var payType = data.wareInfos[i].payType;
				    	var oriPayIntegral = data.wareInfos[i].oriPayIntegral;
				    	var oriPayCash = data.wareInfos[i].oriPayCash;
				    	
				    	if(data.wareInfos[i].bakCol3!=1){
				    		if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
				    			html+="<p>积分<b style=\"color:\#999;\">&nbsp;"+maxValue+"</b>";
					    		html+="&nbsp;&nbsp;&nbsp;&nbsp;<i style=\"background:\#999;\">现金+</i>";
					    		html+="<span style=\"color:\#999;\">（此礼品已下线）</span>";
					    	}else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
					    		html+="<p>现金+<b style=\"color:\#999;\"><span style='font-family:Arial;'>&yen;</span>"+oriPayCash+"+"+oriPayIntegral+"</b>";
						    	html+="<span style=\"color:\#999;\">（此礼品已下线）</span>";
				    		}else{
					    		html+="<p>积分<b style=\"color:\#999;\">&nbsp;"+maxValue+"</b>";
						    	html+="<span style=\"color:\#999;\">（此礼品已下线）</span>";	
					    	}
					    	html+="</p></div>";	
				    	} else {
				    		if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
				    			html+="<p>积分<b>&nbsp;"+maxValue+"</b>";
					    		html+="&nbsp;&nbsp;&nbsp;&nbsp;<i>现金+</i>";
					    	}else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
					    		html+="<p>现金+<b><span style='font-family:Arial;'>&yen;</span><b>"+oriPayCash+"+"+oriPayIntegral+"</b>";
					    	}else{
					    		html+="<p>积分<b>&nbsp;"+maxValue+"</b>";
					    	}
				    		html+="</p></div>";	
					    }
				    	html+="</li>";    					    	
			    	}
			    	$('ul.order_listCon').append(html);
			      }
		    	$('p.list-loading').hide();
			    if(pageNo < maxNo){
				  loading = false;
				}       
            }            
	      });
        }