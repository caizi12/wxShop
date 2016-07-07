package cn.frame.platform.sys.member.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.entitys.ShopInfo;

public interface ShopInfoSrv {
	public ShopInfo getShopInfo(ShopInfo shopInfo);
	@SuppressWarnings("unchecked")
	public List<ShopInfo> queryShopInfo(Map paraMap);
	public boolean addShopInfo(ShopInfo shopInfo);
	public int updateShopInfo(ShopInfo shopInfo);
	public int batchDelShopInfo(List<String> userId)  throws Exception;
	public int updateShopToDelStatus(final List<String> list);
}
