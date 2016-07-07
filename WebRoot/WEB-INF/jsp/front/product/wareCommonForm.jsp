<%@ page import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/ngves-taglib.tld" prefix="ngves"%>
<%@ page import="ngves.asiainfo.portal.ware.web.WareDetailAction"%>
<%@ page import="ngves.asiainfo.portal.ware.domain.WareAllElementBean"%>
<%@ page import="ngves.asiainfo.portal.ware.domain.DWareParticularBean"%>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IQBOWareImageValue"%>
<%@ page import="ngves.asiainfo.portal.PortalConstant"%>
<%@ page import="ngves.asiainfo.portal.ware.domain.DWareDescBean"%>
<%@ page import="ngves.asiainfo.util.StringUtil" %>
<%@ page import="ngves.asiainfo.core.ware.WareConstant"%>
<%@ page import="ngves.asiainfo.portal.util.PortalHttpUtil"%>
<%@ page import="ngves.asiainfo.core.CoreConstant"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="ngves.asiainfo.portal.user.model.RegionBean"%>
<%@ page import="ngves.asiainfo.portal.common.util.RegionInfoUtil"%>
<%@ page import="ngves.asiainfo.portal.ware.WareParamConstant"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="ngves.asiainfo.portal.order.OrderConstant"%>
<%@ page import="ngves.asiainfo.portal.user.model.SessionInfoValue"%>
<%@ page import="ngves.asiainfo.portal.common.util.SNAUtil"%>
<%@ page import="ngves.asiainfo.portal.ware.domain.DescInfo"%>
<%@ page import="ngves.asiainfo.portal.order.util.UserOrderUtil"%>
<%@ page import="ngves.asiainfo.CommnConstant"%>
<%@ page import="ngves.asiainfo.portal.util.WareViewUtil"%>
<%@ page import="ngves.asiainfo.portal.common.util.SysDataUtil" %>
<%@ page import="ngves.asiainfo.portal.common.util.WareShowUtil"%>

<%@ page import=" ngves.asiainfo.portal.ware.service.interfaces.IWareDetailSrv"%>
<%@ page import="ngves.asiainfo.portal.ware.WareSrvConstant"%>
<%@ page import="ngves.asiainfo.portal.ware.ivalues.IWareInfoPortalValue"%>
<%@ page import=" com.ai.appframe2.service.ServiceFactory"%>
<%@page import="ngves.asiainfo.portal.ware.model.WareShowFunc"%>

<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String UserOrderAction = path + "/portal/order/web/UserOrderAction?action=";
	String WareDetailActionUrl = path + "/portal/ware/web/WareDetailAction?action=";
	String ware_id = request.getParameter("ware_id");
	if (ware_id == null && "".equals(ware_id)) {
		System.out.println(" ware_id is null \n ");
		request.getRequestDispatcher("/error.jsp?code=").forward(request, response);
		return;
	}
	//false表示配送方式为17的月末限制兑换
    boolean LimitFor = false;
	String provBusinessInfo = "";//展示提示
	WareAllElementBean  wareAllBean = WareDetailAction.getWareAllElement(request,response,ware_id);
	IQBOWareImageValue[] ware_images =	wareAllBean.getWare_images();
	DWareParticularBean ware = wareAllBean.getWare();
	String payType = wareAllBean.getPayType();
	String wareProCode = ware.getProvince_code();
    String wareHouseId = ware.getWareHouseId()+"";
    String deliveType = ware.getDeliver_type();
	//用于标识活动礼品类型   1-国家大剧院礼品   2-通票类礼品  3-在线选座礼品
	String wareTypeCode =wareAllBean.getWareTypeCode(); 
	boolean isShowExchenge = wareAllBean.isShowExchenge();
	//--加载省份区县信息--
    RegionBean[] provinceInfo = null;
    try {
        provinceInfo = RegionInfoUtil.getProvinceList();
    } catch (Exception e) {
        provinceInfo = new RegionBean[0];
        provinceInfo[0].setCode("");
        provinceInfo[0].setName("请选择");
        e.printStackTrace();
    }
    Map<String,RegionBean[]> cityList = RegionInfoUtil.getCityShortList();
    Map<String,RegionBean[]> districtList = RegionInfoUtil.getDistrictShortList();
    Gson gson = new Gson();
    String strCityInfo = gson.toJson(cityList);
    String strDistrictInfo = gson.toJson(districtList);
    String wareStorageType = ware.getWare_storage_type();
    String detailAction = path + "/portal/ware/web/WareDetailAction?";
    //礼品归属省份名称
    String wareProvinceName= ngves.asiainfo.interfaces.hp.ProvinceUtil.lessProvincesList.get(wareProCode);
    
    SessionInfoValue sessionInfoValue = SNAUtil.getLoginUserInfo(request);
    String userProvinceCode = "bj";
    String userProvinceName = "北京";
    if (SNAUtil.isUserLogin(sessionInfoValue)) {
    	userProvinceCode = sessionInfoValue.getProvCode();
    }
    
	//参与评论人数
	int pepoles = wareAllBean.getPepoles();
	//平均得分
	float avg_score = wareAllBean.getAvg_score();
	HashMap<Integer, Integer> map_comments = wareAllBean.getMap_comments();
	
    List<DescInfo> descInfoList = wareAllBean.getDescInfo();
	//子礼品属性个数
	int descCount = -1;
	//子礼品id用于展示运费
	String wareId = "";
	if(descInfoList != null && descInfoList.size() > 0){
		for(DescInfo descInfo:descInfoList){
			if(!StringUtil.isBlank(descInfo.getWareId())){
				wareId = descInfo.getWareId();
			}
		}
		descCount = descInfoList.size();
	}
	String p_ware_id = ware.getWare_id()+"";
    String allWareDescInfosJson = wareAllBean.getAllWareDescInfosJson();
    //获取第一个礼品支持品牌信息
    String onlyMobileBrand = WareViewUtil.getOnlyWareBrand(wareId,CommnConstant.EXGCHANNEL_MOBILE);
    
    //获取第一个礼品的全部信息
    IWareDetailSrv wareDetailService = (IWareDetailSrv) ServiceFactory.getService(WareSrvConstant.WARE_DETAIL_SRV);
    IWareInfoPortalValue[] vals = wareDetailService.getWareValueByPid(p_ware_id);
    
    //打折信息，默认不打折
    String isSale ="0";
    if(null!=vals && 0<vals.length){
    	//只要有一个子礼品打折，则标记为打折
    	for(IWareInfoPortalValue result:vals){
    		if(!StringUtil.isBlank(result.getSale()) && "1".equals(result.getSale())){
        		isSale ="1";
        	}
    	}
    }
	
	//是否显示礼品车按扭
	boolean isDisplayShopBtn=false;
	if( OrderConstant.HYX_WARE.equals(ware.getDeliver_type())){
		isDisplayShopBtn=true;
	}
	String mainPic = "";
	String noWareMesg="";
    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<title>礼品详情页</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/layout.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/idangerous.swiper.css" >
<link rel="stylesheet" type="text/css" href="<%=path%>/styles/default/m_ware_detail_Rotate.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/styles/default/newDetail.css"/>
</head>
<body>

<section style="min-width:320px;max-width:640px;margin:0 auto;">
    <jsp:include page="/common/commonHead.jsp"> 
		<jsp:param value="商品详情" name="name" />
		<jsp:param value="0" name="type" />
	</jsp:include>
</section>
<section class="fathDetail">
    <!--动效-->
    <div class="choose_tasks">
        <div class="swiper-container">
            <div class="swiper-wrapper">
	            <% String sWareImage = null;
	          	   for(int i=0;i< ware_images.length;i++){
	          			if("1".equals(ware_images[i].getIsMainPic())){
	          				mainPic =  ware_images[i].getFileName();
	          			}
	          			sWareImage = (null==ware_images[i]||null==ware_images[i].getFileName())?"":ware_images[i].getFileName().replaceAll("\\.","_480.");
	            %> 
                <div class="swiper-slide swiper-slide1">
                	<ngves:image id="big_img" data="0" type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" src='<%=sWareImage%>' alt="<%=ware.getWare_name()%>" /> 
                </div>
                <% }%>
            </div>
            <div class="pagination"></div>
        </div>
        <div id="collectHeart" class="heart" onclick="collect()"><i></i></div>
    </div>
    <!--动效 end-->
    <div class="sonInfo clearfix">
        <a href="<%=path %>/portal/ware/web/WareDetailAction?action=getWareChangeInfo&ware_id=<%=ware_id %>">
	        <h2 class="fl"><%=ware.getWare_name()%></h2>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
    </div>
    <div class="sonCont">
    	<%if(wareAllBean.getPayType().contains("01")){ %>
        <div class="integral clearfix">
	        <span class="name fl">积分</span>
	        <i class="set fl"  id="allIntgela"></i>
        </div>
        <%} %>
        <%if(wareAllBean.getPayType().contains("02")){ %>
        <div class="integral clearfix">
	        <span class="name fl">现金+</span>
	        <i class="set fl"  id="payIntgela"></i>
        </div>
        <%} %>
        <div class="integral clearfix" id="sendAddr">
	        <span class="names fl">送至</span>
	        <div class="jf-prop">
               <span class="fa-sele-box">
	               <select id="proviceArea" onchange="updateCity(0)">
	               	<% 
	               	if (provinceInfo != null && provinceInfo.length > 0) {
						if(WareParamConstant.GLOBAL_WARE.equals(wareProCode)){ %>
						<% for (int i = 0; i < provinceInfo.length; i++) { 
							//查询用户手机号归属省code和名称，用于判断有货无货
							if(userProvinceCode.equals(provinceInfo[i].getCode())){
								userProvinceName = provinceInfo[i].getName();
							}
						%>
	                    <option value="<%=provinceInfo[i].getCode() %>"><%=provinceInfo[i].getName() %></option>
	                    <%}
						} else {
							for (int i = 0; i < provinceInfo.length; i++) {
								if(wareProCode.equals(provinceInfo[i].getCode())){%>
									<option value="<%=provinceInfo[i].getCode() %>"> <%=provinceInfo[i].getName() %> </option>
								<%
									break;
								}
							}
						}
	               	}
					%>
	                </select>
                <i id="pShow"style="font-style:normal;"></i>
             	</span>
             	<span class="fa-sele-box">
             		<i id="citytip" style="font-style:normal;"></i>
                	<select  id="cityArea" onchange="updateDistrict(this.value)"> </select>
                </span>
                <span class="fa-sele-box">
                	<i id="countrytip" style="font-style:normal;"></i>
                	<select id ="countryArea" onchange="updateResult(this.value)"> </select>
                </span>
                <p id="hasGoods" class="have" style="line-height:34px; color:#ff0000;"></p>
                
		        <input id="ware_id" name="ware_id" type="hidden"></input>
		        <input id="ware_name" name="ware_name" type="hidden"></input>
		        <input id="selProVal" type="hidden"></input>
				<input id="selCityVal" type="hidden"></input>
				<input id="selCountryVal" type="hidden"></input>
	        </div>
        </div>
    </div>
    <div class="sonStyle clearfix">
        <a href="javascript:goChangeFrom('3');" >
	        <h2 class="fl">选择规格 样式</h2>
	        <div class="cusp"><img src="<%=path%>/styles/default/images/cusp.png" /></div>
        </a>
    </div>
    <div class="sonCont">
        <div class="integral clearfix">
	        <span class="name fl">品牌</span>
	        <b class="set fl"><%=ware.getWare_brand_name()%></b>
        </div>
        <div class="integral clearfix">
	        <span class="name fl">评分</span>
	        <span class="set">
		        <i class="<%=WareShowFunc.getClassForVoteScore(avg_score)[0] %>"></i>
		        <cite>（<%=pepoles%>位用户参与评分）</cite>
	        </span>
        </div>
		<% if(!wareAllBean.isLoginUser() &&  "1".equals(isSale)){%>
		<div class="integral clearfix">
			<span id="tdVIPShow"><span style="color:#ff0000;" >星级优惠：</span>
				<a href="javascript:void(0)" onclick="doLoginBeforeDonation('<%=wareId%>')" class="alogin">登录</a>后确认是否享此优惠
			</span>
		</div>
		<%} %>
    </div>
    <div class="hint">
	    <%if(!StringUtil.isBlank(onlyMobileBrand)){ %> 
	    <p class="import" id="productId" ><%=onlyMobileBrand%></p>
	    <%} %>
	    
	    <%if(null != ware.getImportant_desc() && !ware.getImportant_desc().equals("")){%>
        <p class="import strong">重要提示：<%=ware.getImportant_desc()%></p>
        <%} %>
        
        <!-- 短信兑换：编辑短信内容 -->
	 	<p class="note" id="smsCode" style="display: none; color: #215ba5; margin-top: 15px;"></p>
	 	<div class="important" id="donateMsg" style="display: none;color:#f00;"></div>
	 	
		<%if(wareAllBean.getPayType().contains("02")){ %>
			<%if("1".equals(wareAllBean.getIsOnLinePay()) && "1".equals(wareAllBean.getIsOffLinePay())){ %>
				<p class="import" id="PayNote">现金支持的支付方式：手机支付账户、网银、快捷支付、<%=SysDataUtil.getSysParaData("900000000000006",wareAllBean.getOffLineDesc()).getParaName() %></p>
			<%}else if(!"1".equals(wareAllBean.getIsOnLinePay()) && "1".equals(wareAllBean.getIsOffLinePay())){ %>
				<p class="import" id="PayNote">现金支持的支付方式：<%=SysDataUtil.getSysParaData("900000000000006",wareAllBean.getOffLineDesc()).getParaName() %></p>
			<%}else if("1".equals(wareAllBean.getIsOnLinePay()) && !"1".equals(wareAllBean.getIsOffLinePay())){ %>
				<p class="import" id="PayNote">现金支持的支付方式：手机支付账户、网银、快捷支付</p>
			<%}else{ %>
			<%}
		} %>
    </div>


    <div class="totalAlls">
    <%
	//只支持和优选，自有业务类父子礼品
	if((StringUtils.isBlank(wareTypeCode) || "0".equals(wareTypeCode)) && wareAllBean.isParentWare() == true){
		if ("1".equals(ware.getIs_online())){
			if(isShowExchenge){
    %>
				<%
				if(!ware.getDeliver_type().equals(WareParamConstant.WARE_DELIVER_TYPE_DIY)){ //非diy礼品显示按钮
				  try {
				       UserOrderUtil.provBusinessWareValidate(ware.getDeliver_type());
				%> 
				        <div class="total">
					        <a href="javascript:goShoppingCart();"><img src="<%=path%>/styles/default/images/che.jpg" />
					        <span><cite id="cartNum">0</cite></span></a>
				        </div>
				        <%if(isDisplayShopBtn){ %>
				        <div id="shopcarDiv" class="add"><a id="shopcarId" href="javascript:goChangeFrom('2');">加入购物车</a></div>
				        <%}%>  
				        <div id="exchangeDiv" class="mast"><a id="exchangeId" href="javascript:goChangeFrom('1');">立即兑换</a></div>
	           <%
                 }catch(Exception e) {
                     provBusinessInfo = "<div id=\"noWare\" class=\"important\"><b>每月最后一天，不能进行该礼品兑换</b></div>";
                     LimitFor = true;
                 }
				}%>
				<%if(!provBusinessInfo.equals(""))out.println(provBusinessInfo);%>
			
	        <%}else{
	        	noWareMesg = "此礼品暂不提供兑换服务";
	        } %>
		        
        <%}else{
        	noWareMesg = "此礼品已下线，暂时无法兑换";
        } %>
        
    <%}else{
    	noWareMesg = "<span>该礼品暂不支持兑换，如需兑换请登录中国移动积分商城 <a style=\"color:#0085d0;\" href=\"http://jf.10086.cn\">http://jf.10086.cn</a></span>";
      } %>
    </div>
    
	<%if(!"".equals(noWareMesg)){ %>
    <div id="noWareMes" class="noWareMes">
        <div id="noWare"><%=noWareMesg %></div>
    </div>
	<%} %>
</section>	


<section class="addExchange" style="display:none">
    <div class="addExtop clearfix">
        <a href="javascript:;"><ngves:image src="<%=WareShowUtil.changImgName(mainPic,WareParamConstant.WARE_SHOW_IMG_PX_110)%>" 
		         						type="<%=PortalConstant.PORTAL_IMAGE_PATH_TYPE_WARE%>" /></a>
        <h2><a href="javascript:;"><%=ware.getWare_name()%></a></h2>
        <p class="productId">商品编号：</p>
    </div>
    
    <div class="payment">
        <ul>
            <li>
                <p>支付方式</p>
                <%if(wareAllBean.getPayType().contains("01")){ %>
                <div id="allIntgelArea" ><a href="javascript:void(0)" onclick="changeType('01')" class="white click" >积分 <i id="allIntgel"></i></a></div>
                <%} %>
                
                <%if(wareAllBean.getPayType().contains("02")){ %>
                <div id="payIntgelArea"><a href="javascript:void(0)" onclick="changeType('02')" class="white" >现金+ <i id="payIntgel"></i></a></div>
                <%} %>
            </li>
            <%if (null !=descInfoList && descInfoList.size()>0){ %>
	            <%for(DescInfo descInfo : descInfoList){ %>
		            <li>
		                <p><%=descInfo.getDescName() %>：</p>
		                <div id="detail">
		            	<%//显示属性值
		                	String str[] = descInfo.getDescValue().split(",");
		                 	for(int i=0; i<str.length; ++i){ %>
		                <a  name="<%=descInfo.getDescName() %>" class="white" title="<%=str[i] %>" ><%=str[i] %></a>
		                <% } %>
		            </div>
		            </li>
	            <%} 
		    }%>

        </ul>
        <div style="<%if(OrderConstant.PROV_BUSINESS_WARE.equals(ware.getDeliver_type())){%>display:none<%} %>">
	        <h2>数量</h2>
	        <div class="count clearfix">
	            <a href="javascript:deductAmount()"><span class="fl">-</span></a>
	            <input class="fl" type="text" value="1" id="shopInventory" maxlength="3" onblur="updateMount();" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
	            <a href="javascript:addAmount();"><span class="fl">+</span></a>
	        </div>
	        <p id="errorMsg" style="color:red;font-size:10px;"></p>
        </div>
    </div>
    <a id="changeWare" class="confirm" href="javascript:thisDirectExchange();">确认</a>
</section>	

<form id="direct_form" action="<%=path %>/portal/order/web/UserOrderAction?action=directExchangeWare"
      method="post"><input type="hidden" name="wareIds" id="_wareIds"/>
    <input type="hidden" name="magIds" id="_magIds"/>
    <input type="hidden" name="amount" id="_amount"/>
    <input type="hidden" name="typeCode" id="_typeCode"/>
    <input type="hidden" name="selectPayType" id="_selectPayType"/>
    <input type="hidden" name="proCode" id="proCode"/>
    <input type="hidden" name="cityCode" id="cityCode"/>
    <input type="hidden" name="disCode" id="disCode"/>
</form>
</body>
<ngves:version src="/scripts/tab.js" type="text/javascript"/>
<ngves:version src="/scripts/CommUtil.js" type="text/javascript"/>
<ngves:version src="/scripts/idangerous.swiper.min.js" type="text/javascript"/>
<ngves:version src="/scripts/public.js" type="text/javascript"/>

<script type="text/javascript">

var userProvinceCode = '<%=userProvinceCode%>';
var userProvinceName = '<%=userProvinceName%>';
var wareProvinceCode = "<%=wareProCode%>";
var wareProvinceName = '<%=wareProvinceName%>';
var selProvinceCode = wareProvinceCode;
var selProvinceName = wareProvinceName;
var shop_ware_name = "<%=ware.getWare_name()%>";
var ware_img = "<%=ware_images[0].getFileName()%>";
//选项卡重用
var isShwTag = <%=ware.isShowTag()%>;

var allWareDescInfosJson = '<%= allWareDescInfosJson%>';
//是否显示选择数量框
var isShowOrderQuantity = <%=ware.isShowOrderQuantity() %>;

var wareId = "<%=wareId%>";
var initWareId = "<%=ware_id%>";//页面url地址的截取的礼品id，为页面初始化使用。
var descCount = "<%=descCount%>";
var typeCode = "<%=wareTypeCode%>"; 
var p_ware_id = "<%= p_ware_id%>";
var path='<%=path%>';
var payType = '<%=payType%>';
var jsonCityInfo = <%=strCityInfo%>;
var jsonDistrictInfo = <%=strDistrictInfo%>;

var wareStorageType = '<%=wareStorageType%>';
var wareProvinceHouse = '<%=OrderConstant.WARE_HOUSE_TYPE_PROVINCE%>';
var detailAction = '<%=detailAction%>';
var userOrderAction = '<%=UserOrderAction%>';
var globalWare = '<%=WareParamConstant.GLOBAL_WARE%>';
var LimitFor = '<%=LimitFor %>';
var wareBrand = '<%=ware.getWare_brand_name()%>';


</script>

<!--加载JS信息-->
<ngves:version src="/scripts/ware_common_form.js" type="text/javascript"/>
</html>