package cn.frame.platform.sys.member.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.entitys.ShopInfo;
import cn.frame.platform.sys.member.service.ShopInfoSrv;

import com.ibatis.sqlmap.client.SqlMapExecutor;

@Service("shopInfoSrv")
public class ShopInfoSrvImpl implements ShopInfoSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	/**
	 * 获取购物车信息
	 * 
	 * @param ShopInfo
	 * @return
	 */
	public ShopInfo getShopInfo(ShopInfo shopInfo) {
		shopInfo = (ShopInfo) baseDao.getIbatisTemplate().queryForObject("getShopInfo", shopInfo);
		return shopInfo;
	}

	
	/**
	 * 查询购物车
	 */
	@SuppressWarnings("unchecked")
	public List<ShopInfo> queryShopInfo(Map paraMap) {
		return baseDao.getIbatisTemplate().queryForList("queryShopInfo", paraMap);
	}

	/**
	 * 添加购物车
	 */
	public boolean addShopInfo(ShopInfo shopInfo) {
		shopInfo.setCreateTime(new Date());
		baseDao.getIbatisTemplate().insert("addShopInfo", shopInfo);
		return true;
	}

	/**
	 * 批量删除购物车
	 */
	@SuppressWarnings("unchecked")
	public int batchDelShopInfo(final List<String> list) throws Exception {
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.delete("batchDelShopInfo", list.get(i));
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
	 * 修改购物车信息
	 */
	public int updateShopInfo(ShopInfo ShopInfo) {
		return baseDao.getIbatisTemplate().update("updateShopInfo", ShopInfo);
	}

 
	
	@SuppressWarnings("unchecked")
	public int updateShopToDelStatus(final List<String> list){
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.update("updateShopToDelStatus", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

 
}