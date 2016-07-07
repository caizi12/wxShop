package cn.frame.app.controller;


import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.frame.platform.entitys.ProductInfo;
import cn.frame.platform.sys.dict.service.SysDictSrv;
import cn.frame.platform.sys.member.service.ProductInfoSrv;

/**
 * 产品信息
 * @author li
 *
 */
@RequestMapping("/product")
@Controller
public class ProductControl  {

	@Autowired
	private ProductInfoSrv productInfoSrv;
	@Autowired
	private SysDictSrv sysDictSrv;
	
	
	 /**
	  * 查询商品信息
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list_page")
	public ModelAndView productList(HttpServletRequest request,Map paramMap) throws Exception {
		Map paraMap=getProductListParaMap(request,paramMap);
		
 		return new ModelAndView("front/product/productList","dataMap",paraMap);
	}
	
	
	/**
	 * 分页查询商品信息
	 * @param request
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/listByPage")
	@ResponseBody
	public List<ProductInfo> productListByPage(HttpServletRequest request,Map paramMap) throws Exception{
		Map map=getProductListParaMap(request,paramMap);
		List<ProductInfo> productList=productInfoSrv.queryProductInfoForFront(map,10,Integer.parseInt(String.valueOf(map.get("pageNo"))));
		
		return productList;
	}
	
	@SuppressWarnings("unchecked")
	public static Map getProductListParaMap(HttpServletRequest request,Map paramMap) throws Exception{
		String sortFieldType=request.getParameter("sortFieldType");
		String sortField="";
		if("1".equals(sortFieldType)){
			sortField="PRICE";
		}else if("2".equals(sortFieldType)){
			sortField="EXCHANGE_NUM";
		}else if("3".equals(sortFieldType)){
			sortField="CREATE_TIME";
		}else{
			sortFieldType="0";
			sortField="product_id";
		}
		Map map=new HashMap();
		map.put("sortField",sortField);
		map.put("sortOrder", "desc");
		
		map.put("sortFieldType", sortFieldType);
		String productName=request.getParameter("productName");
		if(StringUtils.isNotBlank(productName)){
			productName=URLDecoder.decode(productName, "utf-8");
		}
		map.put("productName",productName);
		
		String brand=request.getParameter("productBrand");
		map.put("productBrand",brand);
		
		String productKind=request.getParameter("productKind");
		map.put("productKind",productKind);
		
		int pageNo=1;
		if(request.getParameter("pageNo")!=null){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		map.put("pageNo",pageNo);
		
		
		return map;
	}
	
	
	 /**
	  * 商品详情页
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/detail/{productId}")
	public ModelAndView productDetail(HttpServletRequest request, @PathVariable(value="productId") Integer productId) throws Exception {
		ProductInfo productInfo=new ProductInfo();
		productInfo.setProductId(productId);
		productInfo=productInfoSrv.getProductInfo(productInfo);
		Map map=new HashMap();
		map.put("productBaseInfo", productInfo);
		
		Map paraMap=new HashMap();
		paraMap.put("productId", productId);
		map.put("productImg", productInfoSrv.queryProductImg(paraMap));
		
		paraMap.put("dictTypeValue", "productBrand");
		paraMap.put("dictValue", productInfo.getProductBrand());
		productInfo.setProductBrand(sysDictSrv.querySysDictName(paraMap));
		 
		return new ModelAndView("front/product/productDetail","dataMap",map);
	}
	
	//商品属性信息页面
	@SuppressWarnings("unchecked")
	@RequestMapping("/desc/{productId}")
	public ModelAndView productDescDetail(HttpServletRequest request, @PathVariable(value="productId") Integer productId) throws Exception {
		ProductInfo productInfo=new ProductInfo();
		productInfo.setProductId(productId);
		productInfo=productInfoSrv.getProductInfo(productInfo);
		
		Map map=new HashMap();
		map.put("productBaseInfo", productInfo);
		
		Map paraMap=new HashMap();
		paraMap.put("productId", productId);
		paraMap.put("attrKind", productInfo.getProductKind());
		map.put("productAttrInfo", productInfoSrv.queryProductAttrInfo(paraMap));
		
		return new ModelAndView("front/product/wareDetailDesc","dataMap",map);
	}
	 
	 
	 /**
	  * 订单列表
	  */
	@RequestMapping("/query")
	public ModelAndView queryProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new ModelAndView("front/user/orderList","message","list.size()");
	}
	
	 /**
	  * 订单详情
	  */
	@RequestMapping("/order/detail/{orderId}")
	public ModelAndView orderDetail(HttpServletRequest request, @PathVariable(value="orderId") String orderId) throws Exception {
		
		return new ModelAndView("front/user/orderDetail","message","list.size()");
	}
	
	 /**
	  * 购物车列表
	  */
	@RequestMapping("/cartList")
	public ModelAndView cartList(HttpServletRequest request) throws Exception {
		return new ModelAndView("front/user/cartList","message","list.size()");
	}
	
	 /**
	  * 收获地址列表
	  */
	@RequestMapping("/address/list")
	public ModelAndView addressList(HttpServletRequest request) throws Exception {
		return new ModelAndView("front/user/addressList","message","list.size()");
	}
	
	 /**
	  * 新增收获地址
	  */
	@RequestMapping("/address/add")
	public ModelAndView addAddress(HttpServletRequest request) throws Exception {
		return new ModelAndView("front/user/cartList","message","list.size()");
	}
	
	 /**
	  * 编辑收获地址
	  */
	@RequestMapping("/address/edit/{addressId}")
	public ModelAndView addressDetail(HttpServletRequest request,@PathVariable(value="addressId") String addressId) throws Exception {
		return new ModelAndView("front/user/editAddress","message","list.size()");
	}
} 
