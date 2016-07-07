package cn.frame.platform.sys.member.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.ProductAttrInfo;
import cn.frame.platform.entitys.ProductAttrType;
import cn.frame.platform.entitys.ProductImg;
import cn.frame.platform.entitys.ProductInfo;

public interface ProductInfoSrv {
	public ProductInfo getProductInfo(ProductInfo productInfo);
	public int queryCountProductInfo(Map<String, Object> userMap);
	public DataGridModel queryProductInfoData(DataGridModel dataGrid);
	public Integer addProductInfo(ProductInfo productInfo);
	public int updateProductInfo(ProductInfo productInfo);
	public int batchDelProductInfo(List<String> userId)  throws Exception;
	public int updateProductToDelStatus(final List<String> list);
	public int saveProductDetail(ProductInfo productInfo);
	@SuppressWarnings("unchecked")
	public List<ProductAttrType> queryProductAttrType(Map paraMap);
	public int saveProductAttrInfo(final String productId,final ProductAttrInfo[] attrList);
	public List<ProductAttrInfo> queryProductAttrInfo(Map<String,String> paraMap);
	public Integer saveProductImg(ProductImg[] list,Integer productId) ;
	public  List<ProductImg> queryProductImg(Map<String,String> paraMap);
	@SuppressWarnings("unchecked")
	public List<ProductInfo> queryProductInfoForFront(Map map);
	@SuppressWarnings("unchecked")
	public List<ProductInfo> queryProductInfoForFront(Map map,int pageSize,int pageNo);
}
