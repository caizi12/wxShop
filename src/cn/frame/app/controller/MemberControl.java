package cn.frame.app.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.common.constant.MemberConstant;
import cn.frame.platform.common.util.MD5Encoder;
import cn.frame.platform.common.util.ProvinceUtil;
import cn.frame.platform.common.util.RandomNumUtil;
import cn.frame.platform.common.util.RequestParmConvert;
import cn.frame.platform.common.util.SendSmsUtil;
import cn.frame.platform.common.util.UserSessionUtil;
import cn.frame.platform.entitys.MemberAddress;
import cn.frame.platform.entitys.MemberInfo;
import cn.frame.platform.entitys.ShopInfo;
import cn.frame.platform.sys.member.service.MemberAddressSrv;
import cn.frame.platform.sys.member.service.MemberInfoSrv;
import cn.frame.platform.sys.member.service.ShopInfoSrv;

/**
 * 会员
 * @author li
 *
 */
@RequestMapping("/member")
@Controller
public class MemberControl  {
	
	@Autowired
	private MemberInfoSrv memberInfoSrv;
	
	@Autowired
	private MemberAddressSrv memberAddressSrv;
	
	@Autowired
	private ShopInfoSrv shopInfoSrv;
	
	
	/**
	 * 我的账户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/myAccount")
	public ModelAndView userAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
 		return new ModelAndView("front/user/myAccount","message","list.size()");
	}

	 /**
	  * 登录页面
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginPage")
	public ModelAndView loginPage(HttpServletRequest request) throws Exception {
		String queryString=request.getQueryString();
		String targetUrl="";
		if(StringUtils.isNotBlank(queryString)){
			targetUrl=request.getContextPath()+queryString.substring("target=".length());
		}else{
			String referer=request.getHeader("referer");
			if(StringUtils.isNotBlank(referer)){
				targetUrl=referer;
			}else{
				targetUrl=request.getContextPath()+"/";
			}
		}
		Map dataMap=new HashMap();
		dataMap.put("targetUrl", targetUrl);
 		return new ModelAndView("front/login/login","dataMap",dataMap);
	}
	
	 /**
	  * 登录
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@RequestMapping("/login")
	@ResponseBody
	public 	Map<String,String> memberLogin(MemberInfo memberInfo,HttpServletRequest request) throws Exception {
		String validCode=request.getParameter("validCode");
		HttpSession session=request.getSession();
		String sessionValidCode=String.valueOf(session.getAttribute("memberLoginCode"));
		String msg=null;
		String logingFlag="false";
		if(validCode==null || !validCode.toUpperCase().equals(sessionValidCode)){
			msg="验证码输入错误，请重新输入";
		}else if(StringUtils.isBlank(memberInfo.getPassword()) ||  StringUtils.isBlank(memberInfo.getMobileNo())){
			msg="请正确输入用户名、密码！";
		}else{
			memberInfo.setStatus(MemberConstant.MEMBER_STATUS_NORMAL);
			memberInfo.setPassword(MD5Encoder.getMD5(memberInfo.getPassword()));
			memberInfo=memberInfoSrv.getMemberInfo(memberInfo);
			
			if(memberInfo!=null &&  null!= memberInfo.getMemberId() &&  memberInfo.getMemberId()>0){
				session.setAttribute(ConstantPlatform.MEMBER_STAR_LEVEL, MemberConstant.getMemberStarLevel(memberInfo.getTotalPoint()));
				session.setAttribute(ConstantPlatform.MEMBER_INFO, memberInfo);
				logingFlag="true";
			}else{
				msg="用户名或密码错误！";
			}
		}	
		
	
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("logingFlag", logingFlag);
		map.put("msg", msg);
	 
		return map;
	}
	
	
	/**
	 * 检查用户是否登录
	 * @param request
	 * @param memberInfo
	 * @return
	 */
	@RequestMapping("/isLogin")
	@ResponseBody
	public boolean  checkIsLogin(HttpServletRequest request){
		Integer memberId=UserSessionUtil.getMemberIdFromSession(request);
		if(memberId!=null&&memberId>0){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 用户扫描二维码进入注册页面
	 * 
	 * recomendId 为推广人的会员编号
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/{recomendId}/registerPage")
	public ModelAndView  recomendMemberRegisterPage(HttpServletRequest request,@PathVariable(value="recomendId") Integer recomendId){
		MemberInfo memberInfo=new MemberInfo();
		memberInfo.setMemberId(recomendId);
		memberInfo=memberInfoSrv.getMemberInfo(memberInfo);
		return new ModelAndView("front/login/memberRegister","recomendMember",memberInfo);
	}
	
	 
	/**
	 * 新用户注册页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/memberRegisterPage")
	public ModelAndView  memberRegisterPage(HttpServletRequest request,MemberInfo memberInfo){
	 
		return new ModelAndView("front/login/memberRegister");
	}
	
    /**
     *  新用户注册
     * @param request
     * @param memberInfo
     * @return
     */
	@RequestMapping("/memberRegister")
	@ResponseBody
	public String  memberRegister(HttpServletRequest request,MemberInfo memberInfo){
		String result="";
		try{ 
			String validCode=request.getParameter("validCode");
			HttpSession session=request.getSession();
			String  radndCode=(String)session.getAttribute(memberInfo.getMobileNo());
			
			if( StringUtils.isNotBlank(validCode) && validCode.equals(radndCode) ){
				memberInfo.setPassword(MD5Encoder.getMD5(memberInfo.getPassword()));
				result=memberInfoSrv.registerMember(memberInfo);
			}else{
				result="validError";
			}
			 
			return result;
		}catch(Exception e){
		  e.printStackTrace();
		}
		return result;
	}
	
    /**
     *  新用户注册发送手机验证码
     * @param request
     * @param memberInfo
     * @return
     */
	@RequestMapping("/sendSmsCode")
	@ResponseBody
	public String  sendSmsCode(HttpServletRequest request,MemberInfo memberInfo){
		
		
		//校验是否来自当前注册页面的提交，防止站外提交
		String refererUrl=request.getHeader("Referer");
		if(!(refererUrl.indexOf("member/memberRegisterPage.do") > 0||
			refererUrl.indexOf("/registerPage.do") > 0 ))		
		{
			return "fail";
		}
		
		String mobileNo=memberInfo.getMobileNo();
		//校验手机号格式
		Pattern pattern = Pattern.compile("1[2-9]{1}[0-9]{9}");  
		Matcher matcher = pattern.matcher(mobileNo);
		if(StringUtils.isBlank(mobileNo) || !matcher.find()){
			return "error";
		}
		
		//校验该手机号是否已经存在
		memberInfo=memberInfoSrv.getMemberInfo(memberInfo);
		if(memberInfo!=null && StringUtils.isNotBlank(memberInfo.getMobileNo())){
			return "exits";
		}
		
		//发送短信，发送成功后放入session中，4分钟失效
		String radndCode=RandomNumUtil.getFourRandomCode();
		boolean result=SendSmsUtil.sendSmsForRegister(mobileNo, radndCode);
		if(result){
			HttpSession session=request.getSession();
			session.setAttribute(mobileNo, radndCode);
			session.setMaxInactiveInterval(4*60);
			return "true";
		}
		
	 
		return "fail";
	}
	
	 /**
	  * 退出
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession(true).invalidate();
		return new ModelAndView("front/index","message","list.size()");
	}
	
	
	 /**
	  * 提交订单填写选择收货地址
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/address/choose")
	public ModelAndView chooseMyAddress(HttpServletRequest request) throws Exception {
		Map map=RequestParmConvert.intropectToMap(request);
		HttpSession session=request.getSession(true);
		MemberInfo memberInfo=(MemberInfo)session.getAttribute(ConstantPlatform.MEMBER_INFO);
		if(memberInfo==null){
			return new ModelAndView("front/login/login");
		}
		map.put("memberId", memberInfo.getMemberId());
		List<MemberAddress> addressList=memberAddressSrv.queryMemberAddress(map);
		map.put("addressList", addressList);
		map.put("provinceMap", ProvinceUtil.getProvinceMap());
		map.put("cityMap", ProvinceUtil.getCityMap());
		map.put("countryMap", ProvinceUtil.getCountryMap());
		
		return new ModelAndView("front/user/chooseMyAddress","dataMap",map);
	}
	
	 /**
	  * 收货地址列表
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/address/list")
	public ModelAndView addressList(HttpServletRequest request) throws Exception {
		Map map=new HashMap();
		Integer memberId=UserSessionUtil.getMemberIdFromSession(request);
		if(memberId==null){
			return new ModelAndView("front/login/login");
		}
		map.put("memberId", memberId);
		List<MemberAddress> addressList=memberAddressSrv.queryMemberAddress(map);
		map.put("addressList", addressList);
		map.put("provinceMap", ProvinceUtil.getProvinceMap());
		map.put("cityMap", ProvinceUtil.getCityMap());
		map.put("countryMap", ProvinceUtil.getCountryMap());
		return new ModelAndView("front/user/myAddressList","dataMap",map);
	}
	
	 /**
	  * 新增收货地址
	  */
	@RequestMapping("/address/add")
	@ResponseBody
	public String addAddress(HttpServletRequest request,MemberAddress memberAddress) throws Exception {
		memberAddress.setMemberId(UserSessionUtil.getMemberIdFromSession(request));
	 	memberAddressSrv.addMemberAddress(memberAddress);
		return "true";
	}
	
	 /**
	  * 新增收货地址
	  */
	@RequestMapping("/address/addPage")
	public ModelAndView addAddressPage(HttpServletRequest request) throws Exception {
		Map map=RequestParmConvert.intropectToMap(request);
		return new ModelAndView("front/user/addAddress","dataMap",map);
	}
	
	 /**
	  * 设置默认收货地址
	  */
	@RequestMapping("/address/setDefault")
	@ResponseBody
	public boolean setDefaultAddress(HttpServletRequest request,MemberAddress memberAddress) throws Exception {
		Integer memberId=UserSessionUtil.getMemberIdFromSession(request);
		if(memberId==null){
			return false;
		}
		memberAddress.setMemberId(memberId);
		boolean result=memberAddressSrv.updateMemberDefaulAddress(memberAddress);
		return result;
	}
	
	 /**
	  * 编辑收货地址
	  */
	@RequestMapping("/address/edit/{addressId}")
	public ModelAndView ediAddress(HttpServletRequest request,@PathVariable(value="addressId") String addressId) throws Exception {
		return new ModelAndView("front/user/editAddress","message","list.size()");
	}
	
	 /**
	  * 删除收货地址
	  */
	@RequestMapping("/address/delete")
	@ResponseBody
	public boolean deleteAddress(HttpServletRequest request) throws Exception {
		String addressId=request.getParameter("addressId");
		MemberInfo memberId=UserSessionUtil.getMemberInfoFromSession(request);
		if(memberId!=null&&StringUtils.isNotBlank(addressId)){
			return memberAddressSrv.deleteAddress(addressId);
		}
		
		return false;
	}
	
	
	 /**
	  * 用户购物车列表页面
	  * @param request
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/shop/list")
	public ModelAndView shopList(HttpServletRequest request) throws Exception {
		Integer memberId=UserSessionUtil.getMemberIdFromSession(request);
		if(memberId==null){
			new ModelAndView("front/login/login");
		}
		Map paraMap=new HashMap();
		paraMap.put("memberId", memberId);
		List shopInfoList=shopInfoSrv.queryShopInfo(paraMap);
		paraMap.put("shopInfoList", shopInfoList);
		return new ModelAndView("front/user/shopList","dataMap",paraMap);
	}
	
	
	 /**
	  * 商品添加到购物车
	  */
	@RequestMapping("/shop/add")
	public ModelAndView shopAdd(HttpServletRequest request,ShopInfo shopInfo) throws Exception {
		Integer memberId=UserSessionUtil.getMemberIdFromSession(request);
		if(memberId==null){
			new ModelAndView("front/login/login");
		}
		shopInfoSrv.addShopInfo(shopInfo);
		return new ModelAndView("front/user/cartList","message","list.size()");
	}
	
	 /**
	  * 修改购物车信息
	  */
	@RequestMapping("/shop/edit")
	public ModelAndView shopEdit(HttpServletRequest request) throws Exception {
		return new ModelAndView("front/user/cartList","message","list.size()");
	}

	 /**
	  * 删除购物车商品
	  */
	@RequestMapping("/shop/del")
	public ModelAndView shopDel(HttpServletRequest request) throws Exception {
		return new ModelAndView("front/user/cartList","message","list.size()");
	}
} 
