/**
 * Copyright (c) 2011 asiainfo-linkage.com
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.ware.bo.WarePicSynEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePicSynDAO;
import ngves.asiainfo.core.ware.ivalues.IWarePicSynValue;


/**
 * @author asiainfo
 * 
 *
 */
public class WarePicSynDAOImpl implements IWarePicSynDAO {

	public IWarePicSynValue getWarePicSynById(long warePicSynId)
			throws Exception {
		return WarePicSynEngine.getBean(warePicSynId);
	}

	public IWarePicSynValue[] getWarePicSynValue(String condition, Map<String, Object> parameter) throws Exception {
		return WarePicSynEngine.getBeans(condition, parameter);
	}

	public long saveWarePicSynValue(IWarePicSynValue value) throws Exception {
		long id = value.getWarePicSynId();
		if(id != 0){
			value.setUpdateTime(WarePicSynEngine.getSysDate());
			WarePicSynEngine.save(value);
		}else{
			if(value.isModified()){
				value.setStsToNew();
			}
			value.setWarePicSynId(WarePicSynEngine.getNewId().longValue());
			WarePicSynEngine.save(value);
		}
		return value.getWarePicSynId();
	}

	@SuppressWarnings("unchecked")
	public void delWarePicSyn(long wareId) throws Exception {
		Map map = new HashMap();
		map.put("wareId", Long.valueOf(wareId));
		String cond = " ware_id = :wareId ";
		// 删除礼品同步图片
		IWarePicSynValue[] wps = WarePicSynEngine.getBeans(cond, map);
		for (int i = 0; i < wps.length; i++) {
			wps[i].delete();
		}
		WarePicSynEngine.save(wps);
		
	}
	
	
	
}
