package cn.frame.platform.sys.member.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.constant.ProductConstant;
import cn.frame.platform.entitys.ProductAttrInfo;
import cn.frame.platform.entitys.ProductAttrType;
import cn.frame.platform.entitys.ProductImg;
import cn.frame.platform.entitys.ProductInfo;
import cn.frame.platform.sys.member.service.ProductInfoSrv;

import com.ibatis.sqlmap.client.SqlMapExecutor;

@Service("productInfoSrv")
public class ProductInfoSrvImpl implements ProductInfoSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	/**
	 * 获取商品信息
	 * 
	 * @param ProductInfo
	 * @return
	 */
	public ProductInfo getProductInfo(ProductInfo productInfo) {
		productInfo = (ProductInfo) baseDao.getIbatisTemplate().queryForObject("getProductInfo", productInfo);
		return productInfo;
	}

	/**
	 * 查询商品总数
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int queryCountProductInfo(Map<String, Object> paraMap) {
		return baseDao.getQueryCount("queryProductInfo", paraMap);
	}

	/**
	 * 查询商品信息
	 */
	public DataGridModel queryProductInfoData(DataGridModel dataGrid) {
		return baseDao.queryForPageDataGrid("queryProductInfo", dataGrid);
	}

	/**
	 * 添加商品
	 */
	public Integer addProductInfo(ProductInfo productInfo) {
		productInfo.setCreateTime(new Date());
		productInfo.setProductCode(baseDao.getColumnMaxValueForInt("PRODUCT_INFO", "PRODUCT_CODE") + 1);
		Integer productId=(Integer)	baseDao.getIbatisTemplate().insert("insertProductInfo", productInfo);
		return productId;
	}

	/**
	 * 批量删除商品
	 */
	@SuppressWarnings("unchecked")
	public int batchDelProductInfo(final List<String> list) throws Exception {
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.delete("batchDelProductInfo", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	/**
	 * 修改商品信息
	 */
	public int updateProductInfo(ProductInfo productInfo) {
		productInfo.setUpdateTime(new Date());
		return baseDao.getIbatisTemplate().update("updateProductInfo", productInfo);
	}

 
	
	@SuppressWarnings("unchecked")
	public int updateProductToDelStatus(final List<String> list){
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.update("updateProductToDelStatus", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	 /**
	  * 保存商品详细信息
	  */
	public int saveProductDetail(ProductInfo productInfo) {
		productInfo.setUpdateTime(new Date());
		return baseDao.getIbatisTemplate().update("saveProductDetail", productInfo);
	}



	/**
	 * 查询指定商品属性类别信息
	 */
	@SuppressWarnings("unchecked")
	public List<ProductAttrType> queryProductAttrType(Map paraMap) {
		if(paraMap==null){
			paraMap=new HashMap();
		}
		paraMap.put("status", "1");
		return   baseDao.getIbatisTemplate().queryForList("queryProductAttrType", paraMap);
	}
	
	/**
	 * 保存商品属性信息
	 */
	@SuppressWarnings("unchecked")
	public int saveProductAttrInfo(final String productId,final ProductAttrInfo[] attrList){
		if(StringUtils.isBlank(productId))return 0;
		delProductAttrInfoByProductId(productId);
		Object num=0;
		if (attrList != null) {
			num=baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					int m=0;
					for(int i = 0, n = attrList.length; i < n; i++) {
						attrList[i].setProductId(productId);
						executor.insert("addProductAttrInfo", attrList[i]);
						m++;
					}
					executor.executeBatch();
					return m;
				}
			});
		}
		return Integer.parseInt(String.valueOf(num.toString()));
	}
	/**
	 * 删除商品属性信息
	 * @param productId
	 * @return
	 */
	public int delProductAttrInfoByProductId(String productId){
		return	baseDao.getIbatisTemplate().delete("delProductAttrInfoByProductId",productId);
	}
	
	/**
	 * 查询商品属性信息
	 * @param paraMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductAttrInfo> queryProductAttrInfo(Map<String,String> paraMap){
		return	 baseDao.getIbatisTemplate().queryForList("queryProductAttrInfo",paraMap);
	}
	
	/**
	 * 查询商品图片信息
	 */
	@SuppressWarnings("unchecked")
	public  List<ProductImg> queryProductImg(Map<String,String> paraMap) {
		return baseDao.getIbatisTemplate().queryForList("queryProductImg", paraMap);
	}

	/**
	 * 添加商品图片
	 */
	public Integer saveProductImg(ProductImg[] list,Integer productId) {
		if(productId<1)return 0;
		batchDelProductImgByProductId(productId);
		for(ProductImg info: list){
			info.setCreateTime(new Date());
			info.setProductId(productId);
			baseDao.getIbatisTemplate().insert("insertProductImg",info);
		}
		return list.length;
	}
	
	/**
	 * 删除商品属性信息
	 * @param productId
	 * @return
	 */
	public int batchDelProductImgByProductId(Integer productId){
		return	baseDao.getIbatisTemplate().delete("batchDelProductImgByProductId",productId);
	}
 

	/**
	 * 查询商品信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductInfo> queryProductInfoForFront(Map map){
		map.put("status",ProductConstant.PRODUCT_STATUS_DISPLAY);
		return baseDao.getIbatisTemplate().queryForList("queryProductInfoForFront",map);
	}
	

	/**
	 * 分页查询商品信息 
	 * @param map 查询参数
	 * @param pageSize 每页大小
	 * @param pageNo 查询第几页
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductInfo> queryProductInfoForFront(Map map,int pageSize,int pageNo){
		return baseDao.getIbatisTemplate().queryForList("queryProductInfoForFront",map,(pageNo-1)*pageSize,pageSize);
	}
}