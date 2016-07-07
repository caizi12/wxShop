/**
 * Copyright (c) 2010 asiainfo-linkage.com
 * 2010-10-26 上午11:48:06
 */
package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePreviewDAO;
import ngves.asiainfo.core.ware.model.WarePreviewInfoBean;

/**
 * 礼品预览服务接口
 * 
 * @author huangsong
 */
public interface IWarePreviewSrv {

	public void setWarePreviewDAO(IWarePreviewDAO warePreviewDAO) throws Exception;
	
	public void setClobInfoDAO(IClobInfoDAO clobInfoDAO) throws Exception;

	/**
	 * 获取礼品的预览信息
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public WarePreviewInfoBean getWarePreviewInfo(long busiId) throws Exception;
	/**
	 * 获取礼品的wareId
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public long getCwareId(long busiId) throws Exception;
}
