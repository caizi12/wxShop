/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.ware.ivalues.IWarePicSynValue;


/**
 * @author asiainfo
 *
 */
public interface IWarePicSynDAO {
	
	/**
	 * 保存礼品图片同步对象
	 * @param value
	 * @throws Exception
	 */
	public long saveWarePicSynValue(IWarePicSynValue value) throws Exception;

	/**
	 * 根据主键查询礼品图片同步对象
	 * @param warePicSynId
	 * @return
	 * @throws Exception
	 */
    public IWarePicSynValue getWarePicSynById(long warePicSynId) throws Exception;
    
    /**
     * 查询所有待处理的礼品图片对象（状态为0的）
     * @param wareId
     * @param descDefineId
     * @return
     * @throws Exception
     */
    public IWarePicSynValue[] getWarePicSynValue(String condition, Map<String, Object> parameter) throws Exception;
    
    /**
     * 根据wareId busiId删除礼品同步图片
     * @param wareId
     * @param busiId
     * @throws Exception
     */
    public void delWarePicSyn(long wareId) throws Exception;

 
    
}
