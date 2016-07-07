package cn.frame.platform.sys.member.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.util.RequestParmConvert;
import cn.frame.platform.common.util.file.FileUtil;
import cn.frame.platform.common.util.properties.PropertiesUtil;
import cn.frame.platform.common.util.upload.HttpUpload;
import cn.frame.platform.common.util.upload.HttpUploadResult;
import cn.frame.platform.entitys.ProductAttrInfo;
import cn.frame.platform.entitys.ProductAttrType;
import cn.frame.platform.entitys.ProductImg;
import cn.frame.platform.entitys.ProductInfo;
import cn.frame.platform.sys.dict.service.SysDictSrv;
import cn.frame.platform.sys.member.service.ProductInfoSrv;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/sys")
public class ProductInfoControl  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductInfoSrv productInfoSrv;
	
	@Autowired
	private SysDictSrv sysDictSrv;
	 
	private static ObjectMapper objectMapper=new ObjectMapper();
	
	@RequestMapping("/mngProductInfo_page")
	public ModelAndView  productPage(ProductInfo productInfo) {
		
		Map<String,String> paramMap=new HashMap<String,String>();
	    Map map=new HashMap();
		paramMap.put("dictTypeValue", "productStatus");
		map.put("status", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "productBrand");
		map.put("productBrand", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "productKind");
		map.put("productKind", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "isYesOrNo");
		map.put("isRecomend", sysDictSrv.querySysDictByDictValue(paramMap));
		 
		return new ModelAndView("sys/product/mng_product_info","dictMap",map);
	}
	
	@RequestMapping("/queryProductInfo")
	@ResponseBody
	public DataGridModel queryProductInfoList(DataGridModel dataGrid,HttpServletRequest request){
		
		RequestParmConvert.intropectToDataGrid(request,dataGrid);
		return productInfoSrv.queryProductInfoData(dataGrid);
	}
	

	/**
	 * 添加/编辑礼品信息页面
	 * @param productInfo
	 * @param viewType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getProductInfo")
	@ResponseBody
	public ModelAndView getProductInfo(ProductInfo productInfo,@RequestParam("viewType") String viewType) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("viewType", viewType);
		Map paraMap=new HashMap();
		if(!"add".equals(viewType)){
			productInfo= productInfoSrv.getProductInfo(productInfo);
			map.put("productInfo",productInfo);
			paraMap.put("productId", productInfo.getProductId());
			paraMap.put("attrKind", productInfo.getProductKind());
			map.put("productAttrInfo", objectMapper.writeValueAsString(productInfoSrv.queryProductAttrInfo(paraMap)));
			map.put("productImg", objectMapper.writeValueAsString(productInfoSrv.queryProductImg(paraMap)));
		}else{
			paraMap.put("attrKind","0001");
			map.put("productAttrInfo", objectMapper.writeValueAsString(productInfoSrv.queryProductAttrType(paraMap)));
			map.put("productImg", objectMapper.writeValueAsString(new ProductImg[]{new ProductImg("",0)}));
		}
		return new ModelAndView("sys/product/product_info","dataMap",map);
	}
	
	
	
	@RequestMapping("/getProductAttrInfo")
	@ResponseBody
	public List<ProductAttrType>  getProductAttrInfo(@RequestParam("attrKind") String attrKind) throws Exception{
		Map paraMap=new HashMap();
		paraMap.put("attrKind",attrKind);
		return  productInfoSrv.queryProductAttrType(paraMap);
	}
	
	@RequestMapping("/addProductInfo_page")
	public ModelAndView  addProductInfoPage(){
		return new ModelAndView("sys/product/add_sys_user");
	}
	
	@RequestMapping("/addProductInfo")
	@ResponseBody
	public Map<String,String>  addProductInfo(ProductInfo productInfo){
		Map<String,String> msg=new HashMap<String,String>();
		try{ 
			  productInfoSrv.addProductInfo(productInfo);
		  msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
		}catch(Exception e){
		  msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
		  e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping("/viewProductInfo_page")
	public ModelAndView  productInfoViewPage() throws ServletException, IOException{
		return new ModelAndView("sys/product/product_info");
	}
	
	/**
	 * 保存商品基本信息
	 * @param productInfo
	 * @param viewType
	 * @return
	 */
	
	@SuppressWarnings("finally")
	@RequestMapping("/saveBaseProductInfo")
	@ResponseBody
	public Map<String,Object>  saveBaseProductInfo(ProductInfo productInfo,@RequestParam("viewType") String viewType){
		Map<String,Object> msg=new HashMap<String,Object>();
		Integer productId=0;
		try{
		 if ("add".equals(viewType)) {
			   productId=productInfoSrv.addProductInfo(productInfo);
			} else if ("update".equals(viewType)) {
				if(productInfoSrv.updateProductInfo(productInfo)>0){
					productId=productInfo.getProductId();
				}
			}
		 
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

    /**
     * 保存商品详细信息
     * @param productInfo
     * @param productId
     * @return
     */
	@SuppressWarnings("finally")
	@RequestMapping("/saveProductDetail")
	@ResponseBody
	public Map<String,String>  saveProductDetail(ProductInfo productInfo){
		Map<String,String> msg=new HashMap<String,String>();
		int result=0;
		try{
			  result=productInfoSrv.saveProductDetail(productInfo);
		}catch(Exception e){
		  e.printStackTrace();
		}finally{
		     if(result>0){
			    msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
			    msg.put("result","true");
			  }else{
				msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result","false");
			  }
		   return msg;	
		}
	}
	
	 /**
     * 保存商品属性信息
     * @param productInfo
     * @param productId
     * @return
     */
	@SuppressWarnings("finally")
	@RequestMapping("/saveProductAttrInfo")
	@ResponseBody
	public Map<String,String>  saveProductAttrInfo(@RequestParam("productId") String productId,@RequestParam("attrInfoJson") String attrInfoJson){
		Map<String,String> msg=new HashMap<String,String>();
		int result=0;
		try{
			ProductAttrInfo[] list= objectMapper.readValue(attrInfoJson,ProductAttrInfo[].class);
			result=productInfoSrv.saveProductAttrInfo(productId,list);
		}catch(Exception e){
		  e.printStackTrace();
		}finally{
		   if(result>0){
			    msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
			    msg.put("result","true");
			  }else{
				msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result","false");
			  }
		return msg;	
		}
	}
	
	
	
	@RequestMapping("/batchDelProductInfo")
	@ResponseBody
	public Map<String,String>  batchDelProductInfo(@RequestParam("productId") List<String> productId) {
		Map<String,String> msg=new HashMap<String,String>();
		try{
		  productInfoSrv.batchDelProductInfo(productId);
		  msg.put("result", "true");
		  msg.put("msg", PropertiesUtil.getMessValue("sys_del_succeed"));
		}catch(Exception e){
		  msg.put("result", "false");
		  msg.put("msg",PropertiesUtil.getMessValue("sys_del_error"));
		  e.printStackTrace();
		}
		return msg;
	}
	
	
	@RequestMapping("/updateProductToDelStatus")
	@ResponseBody
	public Map<String,String>  updateProductToDelStatus(@RequestParam("productId") List<String> productId) {
		Map<String,String> msg=new HashMap<String,String>();
		try{
		  productInfoSrv.updateProductToDelStatus(productId);
		  msg.put("result", "true");
		  msg.put("msg", PropertiesUtil.getMessValue("sys_del_succeed"));
		}catch(Exception e){
		  msg.put("result", "false");
		  msg.put("msg",PropertiesUtil.getMessValue("sys_del_error"));
		  e.printStackTrace();
		}
		return msg;
	}
	
	
	 /**
     * 保存商品图片信息
     * @param productInfo
     * @param productId
     * @return
     */
	@SuppressWarnings("finally")
	@RequestMapping("/saveProductImg")
	@ResponseBody
	public Map<String,String>  saveProductImg(@RequestParam("productId") Integer productId,@RequestParam("productImgJson") String productImgJson){
		Map<String,String> msg=new HashMap<String,String>();
		int result=0;
		try{
			ProductImg[] list= objectMapper.readValue(productImgJson,ProductImg[].class);
			result=productInfoSrv.saveProductImg(list,productId);
		}catch(Exception e){
		  e.printStackTrace(); 
		}finally{
		   if(result>0){
			    msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
			    msg.put("result","true");
			  }else{
				msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result","false");
			  }
		return msg;	
		}
	}
	/**
	 * 图片上传
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadProductImg")
	@ResponseBody
	public String uploadProductImg(HttpServletRequest request) throws Exception{
		String rootPath=request.getSession().getServletContext().getRealPath("/");
		String imgUploadPath =rootPath+"upload/"; 
 
		FileUtil.mkDir(imgUploadPath, true);
		String fileName = new Date().getTime() + ".jpg";
 
		// 先将图片上传到临时目录
		HttpUpload httpUpload = new HttpUpload();
		httpUpload.setMaxSize(10* 1024 * 1024);
		HttpUploadResult result = httpUpload.upload(request, imgUploadPath,fileName);
		fileName = result.getFileNames().size() > 0 ? result.getFileNames().get(0) : fileName;
		
		//预览路径
		return "/upload/"+fileName;
	}
 
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//true:允许输入空值，false:不能为空值
	}
}
