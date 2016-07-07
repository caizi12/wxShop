package cn.frame.platform.sys.member.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.app.controller.OrderControl;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.util.RequestParmConvert;
import cn.frame.platform.common.util.UserSessionUtil;
import cn.frame.platform.common.util.properties.PropertiesUtil;
import cn.frame.platform.entitys.OrderInfo;
import cn.frame.platform.entitys.OrderInfoList;
import cn.frame.platform.pay.weixin.PayConstant;
import cn.frame.platform.sys.dict.service.SysDictSrv;
import cn.frame.platform.sys.member.service.OrderInfoSrv;

/**
 * 管理员订单管理
 * @author li
 *
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/sys")
public class OrderInfoControl  extends HttpServlet{
	private static  Logger log=Logger.getLogger(OrderControl.class);

	private static final long serialVersionUID = 1L;
	@Autowired
	private OrderInfoSrv orderInfoSrv;
	
	@Autowired
	private SysDictSrv sysDictSrv;
	
	private static ObjectMapper objectMapper=new ObjectMapper();
	
	@RequestMapping("/mngOrderInfo_page")
	public ModelAndView  orderrPage(OrderInfo orderInfo) {
		
		Map<String,String> paramMap=new HashMap<String,String>();
	    Map map=new HashMap();
		paramMap.put("dictTypeValue", "orderStatus");
		map.put("orderStatus", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "payType");
		map.put("payType", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "payStatus");
		map.put("payStatus", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "isYesOrNo");
		map.put("isRecomend", sysDictSrv.querySysDictByDictValue(paramMap));
		 
		return new ModelAndView("sys/order/mng_order_info","dictMap",map);
	}
	
	@RequestMapping("/queryOrderInfo")
	@ResponseBody
	public DataGridModel queryOrderInfoList(DataGridModel dataGrid,HttpServletRequest request){
		
		RequestParmConvert.intropectToDataGrid(request,dataGrid);
		return orderInfoSrv.queryOrderInfoData(dataGrid);
	}
	

	/**
	 * 查看订单信息页面
	 * @param orderInfo
	 * @param viewType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/viewOrderInfo")
	@ResponseBody
	public ModelAndView viewOrderInfo(OrderInfo orderInfo,@RequestParam("viewType") String viewType) throws Exception{
		
		Map<String,Object>  paraMap=new HashMap<String,Object> ();
		paraMap.put("orderId", orderInfo.getOrderId());
	    orderInfo=orderInfoSrv.getOrderInfo(paraMap);
		List<OrderInfoList> orderInfoList=orderInfoSrv.queryMemberOrderInfoList(paraMap);
		paraMap.put("orderInfo", orderInfo);
		paraMap.put("orderInfoList", orderInfoList);
 
 
		return new ModelAndView("sys/order/view_order_info","dataMap",paraMap);
	}
	
	
	
 
	@RequestMapping("/addOrderInfo_page")
	public ModelAndView  addOrderInfoPage(){
		return new ModelAndView("sys/product/add_sys_user");
	}
 
	
	/**
	 * 保存商品基本信息
	 * @param orderInfo
	 * @param viewType
	 * @return
	 */
	
	@SuppressWarnings("finally")
	@RequestMapping("/saveBaseOrderInfo")
	@ResponseBody
	public Map<String,Object>  saveBaseOrderInfo(OrderInfo orderInfo,@RequestParam("viewType") String viewType){
		Map<String,Object> msg=new HashMap<String,Object>();
		Integer productId=0;
		try{
		 
		 
		}catch(Exception e){
		  e.printStackTrace();
		}finally{
		   if(productId>0){
			    msg.put("productId", productId);
			    msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
			    msg.put("result","true");
			  }else{
				msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result","false");
		  	  }
		  return msg;	
		}
	}

	
	
	
	@RequestMapping("/batchDelOrderInfo")
	@ResponseBody
	public Map<String,String>  batchDelOrderInfo(@RequestParam("productId") List<String> productId) {
		Map<String,String> msg=new HashMap<String,String>();
		try{
		  orderInfoSrv.batchDelOrderInfo(productId);
		  msg.put("result", "true");
		  msg.put("msg", PropertiesUtil.getMessValue("sys_del_succeed"));
		}catch(Exception e){
		  msg.put("result", "false");
		  msg.put("msg",PropertiesUtil.getMessValue("sys_del_error"));
		  e.printStackTrace();
		}
		return msg;
	}
	
	
	@RequestMapping("/updateOrderStatus")
	@ResponseBody
	public Map<String,String>  updateOrderStatus(OrderInfo orderInfo) {
		Map<String,String> msg=new HashMap<String,String>();
		try{
		  if(orderInfo==null||StringUtils.isBlank(orderInfo.getOrderId()) ){
			  msg.put("result", "false");
			  msg.put("msg","填写数据有误，请重新填写");
		  }else{
			  orderInfoSrv.updateOrderInfoStatus(orderInfo);
			  msg.put("result", "true");
			  msg.put("msg", "更新订单状态成功");
		  }
	 
		}catch(Exception e){
		  msg.put("result", "false");
		  msg.put("msg","更新订单失败");
		  log.error("updateOrderStatus error",e);
		}
		return msg;
	}
	
	
	@RequestMapping("/updateOrderCash")
	@ResponseBody
	public Map<String,String>  updateOrderCash(OrderInfo orderInfo) {
		Map<String,String> msg=new HashMap<String,String>();
		try{
		 
		  if(orderInfo==null||orderInfo.getOrderId()==null||!(orderInfo.getOrderCash() instanceof  Double)||orderInfo.getOrderCash()<=0 ){
			  msg.put("result", "false");
			  msg.put("msg","填写数据有误，请重新填写");
		  }else{
			  orderInfoSrv.updateOrderInfoStatus(orderInfo);
			  msg.put("result", "true");
			  msg.put("msg", "更新订单金额成功");
		  }
		}catch(Exception e){
		  msg.put("result", "false");
		  msg.put("msg","系统错误");
		  log.error("updateOrderCash error",e);
		}
		return msg;
	}
	
 
 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//true:允许输入空值，false:不能为空值
	}
}
