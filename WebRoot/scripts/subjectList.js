
    var loading = false;//是否在加载中
	var sKind=$("#sKind").val();
	var pageNo=$("#pageNo").val();
	if(pageNo=="undefined"||pageNo==''||pageNo=='null'){
    	pageNo=1;
    }
    var param="sKind="+sKind+"&pageNo="+pageNo+"&rows="+rows;
    var pageAction = contextPath + "/portal/ware/web/SearchWareAction?action=searchWareySkindForSubject"; 
          	
        $(document).ready(function(){
        	   	
        	queryWare(param);    	
        	$(window).scroll(function(){                   
                maxnum = $("#maxIndexPages").val(); //设置加载最多次数
                pageNo=$("#pageNo").val();
                var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();        
               if(bottomHeight<5){
                   if(!loading&&parseInt(pageNo) < parseInt(maxnum)){                	                 	
                   	    viewMore();                	
                   }                
               }
           });		
        });
        function viewMore(){
        	sKind=$("#sKind").val();
        	pageNo=$("#pageNo").val();
            pageNo=parseInt(pageNo)+1;
            param="sKind="+sKind+"&pageNo="+pageNo+"&rows="+rows;
            queryWare(param);
        } 
            	
//查询礼品基本信息	
function queryWare(param){	
	    $('p.list-loading').show();		
            $.ajax({
                type:"POST",
                url:pageAction,
                async:true,
                dataType:"json",
                data: param,
                error: function(obj,msg){           	     
    		    },
                success: function(data){
    		    var html="";    	      
    		       if(data!=''&&data.wareInfos.length>0){		    	
    		    		$("#sKind").val(data.sKind);
    			    	$("#pageNo").val(data.pageNo);   			 
    			    	$("#maxIndexPages").val(data.maxIndexPages);    			    	   
    			    	var maxValue="";
    			    	var sWareImgSrc="";		   			  
    					loading = true;    					   					      					   		            		    	   			      			    	  			    		    				    	
    			        for(var i=0;i<data.wareInfos.length;i++){
    			        	maxValue = data.wareInfos[i].oriIntegral;
    			        	sWareImgSrc =contextPath+"/pic/ware/"+data.wareInfos[i].mainPicFile.replace("_110.","_480.");
    			        	html+="<li><a href="+contextPath+"/ware/"+data.wareInfos[i].wareId+".html  target=\"_self\">";
    			        	html+="<img src='"+sWareImgSrc+"'/></a>";
    			        	html+="<div><a href="+contextPath+"/ware/"+data.wareInfos[i].wareId+".html  target=\"_self\">";
    			        	html+=data.wareInfos[i].wareName+"</a></div>";
    			        	
    			        	var payType = data.wareInfos[i].payType;
    				    	var oriIntegral = data.wareInfos[i].oriIntegral;
    				    	var oriPayCash = data.wareInfos[i].oriPayCash;
    				    	
    				    	if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
    				    		html+="<div class=\"total\">积分 &nbsp;&nbsp;<span>"+maxValue+"</span>";
    				    		html+="&nbsp;&nbsp;&nbsp;&nbsp;<i>现金+</i>";
    				    	}else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
    				    		html+="<div class=\"total\">现金+&nbsp;&nbsp;<span><span style='font-family:Arial;'>&yen;</span>"+oriPayCash+"+"+oriIntegral+"</span>";
    				    	}else{
    				    		html+="<div class=\"total\">积分 &nbsp;&nbsp;<span>"+maxValue+"</span>";
    				    	}
    	                	
    	                	
    	                	
    	                    html+="</div></li>";
    			        }
    			        $('.list-loading').hide();
    					if(data.pageNo < data.maxIndexPages){
    						loading = false;
    					}
    					$('ul.ligeCon').append(html);
    		    	}else{		    	    
    		    		$('#nothingFoundDiv').show();
    			    	$('p.list-loading').hide();	  		           			    		
    		    	}
    		       
                }                             
            });
    	}   



	   function showMore(){
		   var divKind=$("div.conHide");		   
			if(divKind.css('display')=='none'){				
				divKind.animate({height: 'toggle', opacity: 'toggle'}, "slow");
			}else{
				divKind.animate({height: 'toggle', opacity: 'toggle'}, "slow");
			}
	   }