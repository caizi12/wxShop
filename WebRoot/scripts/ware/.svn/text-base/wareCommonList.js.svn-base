 var orderAction = contextPath+'/ware/wareCommonList.jsp?action='+targetUrl;
    var param="wareName="+wareName+"&pageNo="+pageNo; 
		param=param+"&sortWay="+sortWay+"&sortColumn="+sortValue;
		param=param+"&sKind="+sKind+"&bigKind="+bigKind;
		param=param+"&mobileBrand="+mobileBrand+"&valueLevel="+valueLevel;

	$(document).ready(function(){	
		    $("#wareName").val(decodeURIComponent(wareName));
			$("#sortAsc").css('display','block');
			$("#sortDesc").css('display','none');
			$("#sortAsc").addClass("active");
            if(""!=sortWay&&sortWay=="DESC"){
            	$("#sortAsc").css('display','none');
    			$("#sortDesc").css('display','block');
    			$("#sortDesc").addClass("active");
            }		
		if(null!=sortValue&&''!=sortValue&&'0'!=sortValue){
			$("li.active").removeClass("active");
			$("#sortColumn"+sortValue).addClass("active");
			$(".scoreSortPic").hide();
		}
		queryWare(param,showType);
		columnHigth = $('ul.order_listCon').eq(0).find('li').eq(0).height();        		  
        $(window).scroll(function(){                    
             maxnum = $("#maxIndexPages").val(); //设置加载最多次数
             pageNo=$("#pageNo").val();
             var bottomHeight=getScrollHeight()-getScrollTop()-getClientHeight();        
            if(bottomHeight<10){
                if(!loading&&parseInt(pageNo) < parseInt(maxnum)){               	             	
                	viewMore();                	
                }                
            }
        });		
	});
	$(function(){
	    $('.newInpt').click(function(){
	       $(this).parent().find('.new_Icon').show();
	    });
	    $('.new_Icon').click(function(){
	       $('.newInpt').val('');
	    });
	    $('.navList').hide();
	    
	});
   
	function queryWareInfo(type){
		showType = type;
		queryWare(param,showType);
	}
	
    function openMenu(){       
    	if($(".navList").css("display")==='none'){
    		$('.navList').css({"display":"block"});
    	}else{
    		$('.navList').css({"display":"none"});
    	}
    }

  //排序
    function sortColumn(sortColumn){
		var param1=getQueryUrl(sortColumn, sortWay)+"&refreshEventType=sortColumnChange"+"&d="+Math.random();				
		window.location.href=orderAction+param1;		
	}
		
	function getQueryUrl(sortColumn, sortWay){
		wareName=$("#wareName").val();
		var param1="&sortWay="+sortWay+"&sortColumn="+sortColumn+"&showType="+showType;
		if("searchWareInfo"==targetUrl){
			param1 = param1+'&sKind='+sKind+'&bigKind='+bigKind+'&wareName='+encodeURI(encodeURI(wareName))+
			          '&mobileBrand='+mobileBrand+'&valueLevel='+valueLevel;
		}else if("searchWareInfoBySkind"==targetUrl){
			param1 = param1+'&sKind='+sKind;
		}
		return param1;
	}
	//按分值排序
	function sortByScore(sortWay){
		var param1=getQueryUrl(0,sortWay)+"&refreshEventType=sortWayChange"+"&d="+Math.random();
		window.location.href=orderAction+param1;
	}	
	//给每个li添加点击事件
	$(".liarea").click(function(){
        window.location=contextPath+"/ware/"+$(this).attr('name')+".html";
	});
    function viewMore(){
    	wareName=$("#wareName").val();
    	sortWay=$("#sortWay").val();
    	sortValue=$("#sortColumn").val();
    	sKind=$("#sKind").val();
    	bigKind=$("#bigKind").val();
    	mobileBrand=$("#mobileBrand").val();
    	valueLevel=$("#valueLevel").val();
    	pageNo=$("#pageNo").val();
    	pageNo=parseInt(pageNo)+1;
    	param="wareName="+wareName+"&pageNo="+pageNo; 
    	param=param+"&sortWay="+sortWay+"&sortColumn="+sortValue;
    	param=param+"&sKind="+sKind+"&bigKind="+bigKind;
    	param=param+"&mobileBrand="+mobileBrand+"&valueLevel="+valueLevel;
    	queryWare(param,showType);
    }
    function queryWare(param,showType){
    	loading = true;    
    	$('p.list-loading').show();       		       
        $.ajax({
            type:"POST",
            url:pageAction,
            async:true,
            dataType:"json",
            data: param+"&showType="+showType,
            error: function(obj,msg){
        	    
		    },
            success: function(data){	  
	            var html="";
		    	var maxValue="";
		    	if(data!=''&data.wareInfos.length>0){		    		    		
		    		//$("#wareName").val(data.wareName);
			    	$("#targetUrl").val(data.action);
			    	$("#sortWay").val(data.sortWay);
			    	$("#sortColumn").val(data.sortColumn);
			    	$("#sKind").val(data.sKind);
			    	$("#bigKind").val(data.bigKind);
			    	$("#mobileBrand").val(data.mobileBrand);
			    	$("#valueLevel").val(data.valueLevel);
			    	$("#pageNo").val(data.pageNo);		
			    	$("#maxIndexPages").val(data.maxIndexPages);
			    		    				    			    	
			    	for(var i=0;i<data.wareInfos.length;i++){
			    		maxValue = data.wareInfos[i].oriIntegral;
			    		if(showType=="list"){
							if(i==data.wareInfos.length-1){
								html+="<li class=\"clearfix\"  name="+data.wareInfos[i].wareId+"  style='border:0;'>";
							}else if(i==0&&data.pageNo>1){
								if(showType=="img"){
									html+="<li class=\"clearfix\"  name="+data.wareInfos[i].wareId+">";
								}else{
									html+="<li class=\"clearfix\"  name="+data.wareInfos[i].wareId+"  style='border-top:1px #e0dfdf solid'>";
								}
								
							}else{
								html+="<li class=\"clearfix\"  name="+data.wareInfos[i].wareId+">";
							}																	
					    	html+='<a href=\"javascript:wareInfoDetail(\'ware/'+data.wareInfos[i].wareId+'.html\')\" target=\"_self\">';	
					    	html+="<img  class=\"img\" src="+contextPath+"/pic/ware/"+data.wareInfos[i].mainPicFile+"></a>";
					    	html+=' <h2 class=\"comList\"> <a href="javascript:wareInfoDetail("ware/'+data.wareInfos[i].wareId+'.html")"  target=\"_self\" ';
					    	html+=">"+data.wareInfos[i].wareName+"</a></h2>";
					    	var payType = data.wareInfos[i].payType;
					    	var oriPayIntegral = data.wareInfos[i].oriPayIntegral;
					    	var oriPayCash = data.wareInfos[i].oriPayCash;
					    	if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
					    		html+="<p>积分<b>&nbsp;"+maxValue+"</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					    		html+="<i>现金+</i>";
					    	}else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
					    		html+="<p>现金+<b>&nbsp;<span style='font-family:Arial;'>&yen;</span>"+oriPayCash+"+"+oriPayIntegral+"</b>";
			    			}else{
					    		html+="<p>积分<b>&nbsp;"+maxValue+"</b>";
					    	}
					    	html+="</p></li>";	
			    		}else if(showType=="img"){
			    			var payType = data.wareInfos[i].payType;
			    			html+="<li name="+data.wareInfos[i].wareId+">";
			    	        html+='<a href=\"javascript:wareInfoDetail(\'ware/'+data.wareInfos[i].wareId+'.html\')\" target=\"_self\">';
			    	        html+="<img  class=\"img\" src="+contextPath+"/pic/ware/"+data.wareInfos[i].mainPicFile+"></a>";
			                html+='<div><a href="javascript:wareInfoDetail("ware/'+data.wareInfos[i].wareId+'.html")"  target=\"_self\" >'+data.wareInfos[i].wareName+'</a></div>';
			                if(payType.indexOf("02")>-1 && payType.indexOf("01")>-1){
			                	html+="<div class='clearfix'><p class='fl'>积分: <span>"+maxValue+"</span></p><i class='fr'>现金+</i></div></li>";
			                }else if(payType.indexOf("02")>-1 && payType.indexOf("01")<0){
						    	var oriPayIntegral = data.wareInfos[i].oriPayIntegral;
						    	var oriPayCash = data.wareInfos[i].oriPayCash;
			                	html+="<div class='clearfix'>现金+: <span><span style='font-family:Arial;'>&yen;</span>"+oriPayCash+"+"+oriPayIntegral+"</span></div></li>";
			                }else{
			                	html+="<div class='clearfix'>积分: <span>"+maxValue+"</span></div></li>";
			                }
			    		}		    	
			    	}
			    	$('p.list-loading').hide();
			    	if(showType=="list"){
			    		$(".searchL_img").hide();
			    		$(".searchL_list").show();
			    		$('ul.order_listCon').append(html);
			    		$('ul.ligCon').html("");
			    		$(".rightIcon2").css("display","none");
			    		$(".rightIcon1").css("display","inline-block");
			    		
			    	}else if(showType=="img"){
			    		$(".searchL_list").hide();
			    		$(".searchL_img").show();
			    		$('ul.order_listCon').html("");
			    		$('ul.ligCon').append(html);
			    		$(".rightIcon1").css("display","none");
			    		$(".rightIcon2").css("display","inline-block");
			    	}
			    	
					loading = false;
				  }else{	
					  if($("#maxIndexPages").val()=="0"){
						  $('#nothingFoundDiv').show(); 
					  }		    	    
			    	  $('p.list-loading').hide();	           			    		
			      }
            }      
        });
	}
    function wareInfoDetail(url){
    	//common.openPage(url,null,"商品详情",0);
    	window.location.href=contextPath+"/"+url;
    }
	//菜单栏事件
    function goAllClass(){
    	window.location.href = contextPath+'/ware/classify.html';
    }

    function goUserOrder(){
    	window.location.href = contextPath+'/asynorder/user/web/UserOrderQueryAction?action=initOrderQuery&timePrior=360&queryType=0&queryOrderType=1&actionId=';
    }

    function goIndex(){
    	window.location.href = contextPath+'/index.html';
    }

    function goShoppingCart(){
    	window.location.href = contextPath+'/portal/order/web/ShoppingCartAction?action=showUserShopInfo';
    }
    
    function goUserAccount(){
 	   window.location.href = contextPath+'/mobile/user/myAccount.html';	
    }
