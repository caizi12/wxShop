package cn.frame.app.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.constant.MemberConstant;
import cn.frame.platform.common.constant.OrderConstant;
import cn.frame.platform.common.util.ProvinceUtil;
import cn.frame.platform.common.util.RandomNumUtil;
import cn.frame.platform.common.util.RequestUtil;
import cn.frame.platform.common.util.SendSmsUtil;
import cn.frame.platform.common.util.UserSessionUtil;
import cn.frame.platform.entitys.MemberInfo;
import cn.frame.platform.entitys.OrderInfo;
import cn.frame.platform.entitys.OrderInfoList;
import cn.frame.platform.entitys.ProductInfo;
import cn.frame.platform.pay.weixin.PayConstant;
import cn.frame.platform.pay.weixin.PayRequstBean;
import cn.frame.platform.pay.weixin.PayResponseBean;
import cn.frame.platform.pay.weixin.WeiXinOauth2Token;
import cn.frame.platform.pay.weixin.util.HttpsRequest;
import cn.frame.platform.pay.weixin.util.RandomStringGenerator;
import cn.frame.platform.pay.weixin.util.Signature;
import cn.frame.platform.sys.member.service.MemberAddressSrv;
import cn.frame.platform.sys.member.service.MemberInfoSrv;
import cn.frame.platform.sys.member.service.OrderInfoSrv;
import cn.frame.platform.sys.member.service.ProductInfoSrv;

/**
 * 订单
 * @author li
 *
 */
@RequestMapping("/order")
@Controller
public class OrderControl  {
	private static  Logger log=Logger.getLogger(OrderControl.class);
	private static ObjectMapper objectMapper=new ObjectMapper();
	
	@Autowired
	private MemberInfoSrv memberInfoSrv;
	
	@Autowired
	private ProductInfoSrv productInfoSrv;
	
	@Autowired
	private OrderInfoSrv orderInfoSrv;
	
	@Autowired
	private MemberAddressSrv memberAddressSrv;
	
	/**
	 * 立即兑换页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/exchange")
	public ModelAndView exchange(HttpServletRequest request,String productIds) throws Exception {		
		MemberInfo memberInfo=(MemberInfo)UserSessionUtil.getMemberInfoFromSession(request);
		if(memberInfo==null || memberInfo.getMemberId()<=0 ){
			return new ModelAndView("front/login/login");
		}
		
		String amounts=request.getParameter("amounts");
		Map dataMap=new HashMap();
		
		//查询商品信息
		ProductInfo productInfo=new ProductInfo();
		dataMap.put("productIds", productIds);
		List productList=productInfoSrv.queryProductInfoForFront(dataMap);
		
		//查询会员收获地址
		String selectAddressId=request.getParameter("selectAddressId");
		dataMap.put("memberId", memberInfo.getMemberId());
		//如果选择了收获地址则查询选择的收获地址，否则展示默认地址
		if(StringUtils.isNotBlank(selectAddressId)){
			dataMap.put("addressId",selectAddressId);	
		}else{
			dataMap.put("isDefault",MemberConstant.MEMBER_ADDRESS_IS_DEFAULT);
		}
		
		List memberAdds=memberAddressSrv.queryMemberAddress(dataMap);

		dataMap.put("productInfo", productInfo);
		dataMap.put("memberAddress", memberAdds);
		
		dataMap.put("amounts", amounts);
		dataMap.put("provinceMap", ProvinceUtil.getProvinceMap());
		dataMap.put("cityMap", ProvinceUtil.getCityMap());
		dataMap.put("countryMap", ProvinceUtil.getCountryMap());
		
		setOrderList(productIds,amounts,productList,dataMap);
		
 		return new ModelAndView("front/order/directConfirmInfo","dataMap",dataMap);
	}

	/**
	 * 设置商品信息
	 * @param productIds
	 * @param amounts
	 * @param productList
	 * @param dataMap
	 */
	@SuppressWarnings("unchecked")
	public void setOrderList(String productIds,String amounts,List<ProductInfo> productList,Map dataMap){
		String[] amount=amounts.split(",");
		String[] productId=productIds.split(",");
		Map productIdMap=new HashMap();
		int i=0;
		for(String id:productId){
			productIdMap.put(id, amount[i]);
			i++;
		}
		
		//订单页面订单信息
		List orderList=new ArrayList();
		double price=0.00;
		//商品数量
		int productAmount=0;
		//订单总计
	    double orderTotalPrice=0.00;
		Map productMap=null;
		for(ProductInfo info:productList){
			productMap=new HashMap();
			productMap.put("productId", info.getProductId());
			productMap.put("productName", info.getProductName());
			productMap.put("price", info.getPrice());
			productMap.put("amount",productIdMap.get(String.valueOf(info.getProductId())));
			productMap.put("productImg",info.getProductImg());
			
			price= info.getPrice();
			productAmount=Integer.parseInt(String.valueOf(productMap.get("amount")));
		
			orderTotalPrice+=productAmount*price;
			
			orderList.add(productMap);
		}
		
		dataMap.put("productNum", orderList);
		dataMap.put("orderList", orderList);
		dataMap.put("orderTotalPrice", orderTotalPrice);
	}
	
	
	 /**
	  * 用户确认生成订单
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@RequestMapping("/create")
	public ModelAndView createOrder(HttpServletRequest request,OrderInfo orderInfo) throws Exception {
		MemberInfo memberInfo=(MemberInfo)UserSessionUtil.getMemberInfoFromSession(request);
		if(memberInfo==null || memberInfo.getMemberId()<=0 ){
			return new ModelAndView("front/login/login");
		}
		
		String confirmCode=request.getParameter("confirmCode");
		HttpSession session=request.getSession(true);
		if(StringUtils.isBlank(confirmCode) || !confirmCode.equals(session.getAttribute(memberInfo.getMobileNo()))){
			//return errorPage("验证码输入错误");
		}else{
			session.removeAttribute(memberInfo.getMobileNo());
		}
		
		String productIds=request.getParameter("productIds");
		String amounts=request.getParameter("amounts");
		
		//生成大订单
		String orderId=orderInfoSrv.getNewOrderId();
		orderInfo.setOrderId(orderId);
		orderInfo.setMemberId(memberInfo.getMemberId()+"");
		orderInfo.setOrderStatus(OrderConstant.ORDER_STATUS_NEW);
		orderInfo.setPayStatus(OrderConstant.ORDER_PAY_STATUS_NO);
		
		Double orderCash=0.00;
		ProductInfo product=null;
		String[] amount=amounts.split(",");
		//生成子订单
		List<OrderInfoList> list=new ArrayList<OrderInfoList>();
		OrderInfoList orderList=null;
		int orderNo=0;
		for(String productId:productIds.split(",")){
			product=new ProductInfo();
			product.setProductId(Integer.parseInt(productId));
			product=productInfoSrv.getProductInfo(product);
			
			orderList=new OrderInfoList();
			orderList.setOrderId(orderId);
			orderList.setOrderListId(orderInfoSrv.getNewOrderListId(String.format("%03d",orderNo)));
			orderList.setProductId(productId);
			orderList.setProductNum(Integer.parseInt(amount[orderNo]));
			orderList.setProductPrice(product.getPrice());
			orderList.setMemberId(String.valueOf(memberInfo.getMemberId()));
			orderList.setCreateTime(new Date());
			list.add(orderList);
			
			//订单总价
			orderCash+=orderList.getProductNum()*orderList.getProductPrice();
			
			orderNo++;
		}
		
		orderInfo.setOrderCash(orderCash);
		orderInfo.setGivePoint(orderCash.intValue());
		
		orderInfoSrv.createOrderInfo(orderInfo,list);
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		dataMap.put("orderId", orderId);
		dataMap.put("payType", orderInfo.getPayType());
		dataMap.put("orderCash", orderCash);
		dataMap.put("oauthUrl", PayConstant.getOauthUrl().replace("PARAM_STATE", orderId));
		
		return new ModelAndView("front/order/orderResult","dataMap",dataMap);
	}
	
	
	 /**
	  * 我的订单
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/myOrder")
	@ResponseBody
	public ModelAndView myOrder(HttpServletRequest request) throws Exception {
		MemberInfo memberInfo=UserSessionUtil.getMemberInfoFromSession(request);
		if(memberInfo==null||StringUtils.isBlank(memberInfo.getMobileNo())){
			return new ModelAndView("front/login/login");
		}
		Map  paraMap=new HashMap();
		paraMap.put("memberId",UserSessionUtil.getMemberIdFromSession(request));
		List<OrderInfo> orderList=orderInfoSrv.queryOrderInfo(paraMap);
		List<OrderInfoList> orderInfoList=orderInfoSrv.queryMemberOrderInfoList(paraMap);
		
 		return new ModelAndView("front/user/myOrder","dataMap",getMyOrderInfoMap(orderList,orderInfoList));
	}
	
	public static Map<String,Object>  getMyOrderInfoMap(List<OrderInfo> orderList,List<OrderInfoList> orderInfoList){
		
		List<List<OrderInfo>> list=new ArrayList<List<OrderInfo>>();
		//待付款订单
		List<OrderInfo> noPay=new ArrayList<OrderInfo>();
		//已完成订单
		List<OrderInfo> finishOrder=new ArrayList<OrderInfo>();
		//取消，未完成的订单
		List<OrderInfo> cancelOrder=new ArrayList<OrderInfo>();
		//待收货的订单
		List<OrderInfo> waitReceive=new ArrayList<OrderInfo>();
		for(OrderInfo orderInfo :orderList){
			//选择微信支付、未支付的订单
			if(OrderConstant.ORDER_PAY_TYPE_WEIXIN.equals(orderInfo.getPayType())&&
			   OrderConstant.ORDER_PAY_STATUS_NO.equals(orderInfo.getPayStatus())){
				noPay.add(orderInfo);
			}else if(OrderConstant.ORDER_STATUS_FINISH.equals(orderInfo.getOrderStatus())||
					 OrderConstant.ORDER_STATUS_RECEIVING.equals(orderInfo.getOrderStatus())){
				finishOrder.add(orderInfo);
			}else if(OrderConstant.ORDER_STATUS_CANCEL.equals(orderInfo.getOrderStatus())||
					OrderConstant.ORDER_STATUS_MEMBER_RETURN.equals(orderInfo.getOrderStatus())||
					OrderConstant.ORDER_STATUS_NO_PERSON_RECEIVING.equals(orderInfo.getOrderStatus())){
				cancelOrder.add(orderInfo);
			//已支付或者货到付款，订单状态为新订单，已确认、已发货都归为用户待收货
			}else if((OrderConstant.ORDER_PAY_STATUS_YES.equals(orderInfo.getPayStatus())||
					  OrderConstant.ORDER_PAY_TYPE_OFFLINE.equals(orderInfo.getPayType()))&&(
					 OrderConstant.ORDER_STATUS_NEW.equals(orderInfo.getOrderStatus())||
					 OrderConstant.ORDER_STATUS_CONFIRM.equals(orderInfo.getOrderStatus())||
					 OrderConstant.ORDER_STATUS_SENDING.equals(orderInfo.getOrderStatus())))
			{
				waitReceive.add(orderInfo);
			}
		}
		
		//设置子订单，根据大订单id分组
		Map<String,List<OrderInfoList>> orderInfoListMap=new HashMap<String,List<OrderInfoList>>();
		for (OrderInfoList info:orderInfoList){
			if(orderInfoListMap.get(info.getOrderId())!=null){
				orderInfoListMap.get(info.getOrderId()).add(info);
			}else{
				List<OrderInfoList> infoList=new ArrayList<OrderInfoList>();
				infoList.add(info);
				orderInfoListMap.put(info.getOrderId(),infoList);
			}
		}
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		list.add(noPay);
		list.add(waitReceive);
		list.add(finishOrder);
		list.add(cancelOrder);
		dataMap.put("orderInfoMap", list);
		dataMap.put("orderInfoListMap", orderInfoListMap);
		dataMap.put("oauthUrl", PayConstant.getOauthUrl());
		
		return dataMap;
	}
	
	 
	 /**
	  * 
	  */
	@RequestMapping("/updateStatus")
	public ModelAndView orderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new ModelAndView("front/user/orderList","message","list.size()");
	}
	
	 /**
	  * 订单详情
	  */
	@RequestMapping("/detail/{orderId}")
	public ModelAndView orderDetail(HttpServletRequest request, @PathVariable(value="orderId") String orderId) throws Exception {
		Map<String,Object>  paraMap=new HashMap<String,Object> ();
		paraMap.put("memberId",UserSessionUtil.getMemberIdFromSession(request));
		paraMap.put("orderId", orderId);
	    OrderInfo  orderInfo=orderInfoSrv.getOrderInfo(paraMap);
		List<OrderInfoList> orderInfoList=orderInfoSrv.queryMemberOrderInfoList(paraMap);
		paraMap.put("orderInfo", orderInfo);
		paraMap.put("orderInfoList", orderInfoList);
		paraMap.put("oauthUrl", PayConstant.getOauthUrl());
		return new ModelAndView("front/user/orderDetail","dataMap",paraMap);
	}
	
	
	 /**
     *  用户提交订单发送手机验证码
     * @param request
     * @param memberInfo
     * @return
     */
	@RequestMapping("/sendSmsCode")
	@ResponseBody
	public String  sendSmsCode(HttpServletRequest request){
		
		//校验是否来自当前注册页面的提交，防止站外提交
		String refererUrl=request.getHeader("Referer");
		if(!(refererUrl.indexOf("order/exchange.do") > 0) ){
			return "fail";
		}
		
		MemberInfo memberInfo=(MemberInfo)UserSessionUtil.getMemberInfoFromSession(request);
		String mobileNo=memberInfo.getMobileNo();
		if(memberInfo==null || memberInfo.getMemberId()<=0 ||StringUtils.isBlank(mobileNo) ){
			return "nologin";
		}
		
		//发送短信，发送成功后放入session中，4分钟失效
		String radndCode=RandomNumUtil.getFourRandomCode();
		boolean result=SendSmsUtil.sendSmsForOrder(mobileNo, radndCode);
		if(result){
			HttpSession session=request.getSession();
			session.setAttribute(mobileNo, radndCode);
			session.setMaxInactiveInterval(10*60);
			return "true";
		}
	 
		return "fail";
	}
	
 
	public static  ModelAndView  errorPage(String message){
		return new ModelAndView("front/common/error","message",message);
	}
	
	/**
	 * 订单支付
	 * @param request
	 * @return
	 */ 
	@RequestMapping("/pay/getOpenid")
	public ModelAndView  payTest(HttpServletRequest request){
		Map<String,Object> dataMap=new HashMap<String,Object>();
		return new ModelAndView("front/pay/pay","dataMap",dataMap);
	}
	
	/**
	 * 微信支付成功
	 * @param request
	 * @return
	 */
	@RequestMapping("/payResult")
	public ModelAndView  payResult(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> dataMap=new HashMap<String,Object>();
		 try {
			StringBuffer sb = new StringBuffer() ; 
			InputStream is = request.getInputStream(); 
			InputStreamReader isr = new InputStreamReader(is);   
			BufferedReader br = new BufferedReader(isr); 
			String s = "" ; 
			while((s=br.readLine())!=null){ 
			sb.append(s) ; 
			} 
			String result =sb.toString(); 
			log.info("pay result:"+result);
			OrderInfo orderInfo=new OrderInfo();
			PayResponseBean responseBean=(PayResponseBean)PayResponseBean.getObjectFromXML(result,PayResponseBean.class);
			if(PayConstant.RESULT_CODE_SUCCESS.equals(responseBean.getResult_code())&&
			   PayConstant.RETURN_CODE_SUCCESS.equals(responseBean.getReturn_code()))
			{
				orderInfo.setOrderId(responseBean.getOut_trade_no());
				orderInfo.setPayStatus(OrderConstant.ORDER_PAY_STATUS_YES);
				orderInfo.setPayTradeId(responseBean.getTransaction_id());
				orderInfo.setPayCash(Double.valueOf(responseBean.getTotal_fee())/100);
				orderInfo.setGivePoint(Integer.valueOf(responseBean.getTotal_fee())/100);
				orderInfo.setPayTime(new Date());
				orderInfoSrv.updateOrderInfoStatus(orderInfo);
				
				response.getWriter().write("ok");
				dataMap.put("orderInfo", orderInfo);
			}
			
		} catch (IOException e) {
			log.error("pay result error ",e);
		}
	
		return new ModelAndView("front/pay/payResult","dataMap",dataMap);
	}
	
	/**
	 * 微信支付
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/pay")
	public ModelAndView  pay(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		
		    String code = request.getParameter("code");
		    String orderId=request.getParameter("state");
		    log.info("pay State="+orderId+" ,code="+code);
		    WeiXinOauth2Token token=new WeiXinOauth2Token();
		    //发送请求，获取openid
		    if(code!=null&&!"authdeny".equals(code)){
		    	token=WeiXinOauth2Token.getOauth2AccessToken(code);	
		    }
		    Map paraMap=new HashMap();
		    paraMap.put("orderId", orderId);
		    OrderInfo orderInfo=orderInfoSrv.getOrderInfo(paraMap);
		    
			Map<String,Object> dataMap=new HashMap<String,Object>();
			
		    //取到openid，调用统一支付接口，获取预支付id
			String sign=null;
			if(token.getOpenid()!=null){
		    	PayRequstBean requestBean=new PayRequstBean();
		    	requestBean.setNonce_str(RandomStringGenerator.getRandomStringByLength(20));
		    	requestBean.setBody("净水商城商品购买");
		    	requestBean.setOut_trade_no(orderInfo.getOrderId());
		    	requestBean.setSpbill_create_ip(RequestUtil.getClientIP(request));
		    	requestBean.setTotal_fee(String.valueOf(Math.round(orderInfo.getOrderCash()*100)));
		    	requestBean.setOpenid(token.getOpenid());
		    	requestBean.setNotify_url(PayConstant.PAY_RESULT_URL);
		    	sign=Signature.getSign(requestBean);
		    	requestBean.setSign(sign);
		    	
		    	HttpsRequest http=new HttpsRequest();
		    	String result=http.sendPost(PayConstant.PAY_URL, requestBean);
		    	
		    	PayResponseBean responseBean=(PayResponseBean)PayResponseBean.getObjectFromXML(result,PayResponseBean.class);
		    	
		    	//都返回成功时，即调统一支付ok
		    	if(PayConstant.RETURN_CODE_SUCCESS.equals(responseBean.getReturn_code())&&
		    	   PayConstant.RESULT_CODE_SUCCESS.equals(responseBean.getResult_code())){
		    		dataMap.put("appId", responseBean.getAppid());
		    		dataMap.put("timeStamp", new Date().getTime());
					dataMap.put("nonceStr", responseBean.getNonce_str());
					dataMap.put("package", "prepay_id="+responseBean.getPrepay_id());
					dataMap.put("signType", PayConstant.PAY_SIGN_TYPE);
					
					dataMap.put("paySign", Signature.getSign(dataMap));
					
					dataMap.put("prepay_id", responseBean.getPrepay_id());
		    	}
			}
			
			dataMap.put("orderId", orderId);
			return new ModelAndView("front/pay/pay","dataMap",dataMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
} 
