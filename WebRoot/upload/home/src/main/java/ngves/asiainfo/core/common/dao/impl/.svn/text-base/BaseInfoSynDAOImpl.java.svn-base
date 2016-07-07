/**
 * 
 */
package ngves.asiainfo.core.common.dao.impl;

import java.util.Map;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BaseInfoSynEngine;
import ngves.asiainfo.core.common.bo.UpdateNotifyInfoEngine;
import ngves.asiainfo.core.common.dao.interfaces.IBaseInfoSynDAO;
import ngves.asiainfo.core.common.ivalues.IBaseInfoSynValue;
import ngves.asiainfo.core.common.ivalues.IUpdateNotifyInfoValue;


/**
 * @author asiainfo
 * 
 */
public class BaseInfoSynDAOImpl implements IBaseInfoSynDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.common.dao.interfaces.IBaseInfoSynDAO#querySynInfos
	 * (java.lang.String, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public IBaseInfoSynValue[] querySynInfos(String condition, Map parameter) throws Exception {
		return BaseInfoSynEngine.getBeans(condition, parameter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngves.asiainfo.core.common.dao.interfaces.IBaseInfoSynDAO#saveSynInfos
	 * (ngves.asiainfo.core.common.ivalues.IBaseInfoSynValue[])
	 */
	public void saveSynInfos(IBaseInfoSynValue[] synInfos) throws Exception {
		for (IBaseInfoSynValue value : synInfos) {
			if (value.isNew()) {
				value.setSynId(BaseInfoSynEngine.getNewId().longValue());
				value.setSynCreateTime(BaseInfoSynEngine.getSysDate());
				value.setSynInfoState(CoreConstant.SYS_PARA_SYN_STATE_WAIT);
			}
		}
		BaseInfoSynEngine.save(synInfos);
	}

	public IUpdateNotifyInfoValue[] queryNotifyInfo(String condition, Map<String, String> parameter) throws Exception {
		return UpdateNotifyInfoEngine.getBeans(condition, parameter);

	}

	public void saveNotifyInfo(IUpdateNotifyInfoValue[] notifyInfos) throws Exception {
		for (IUpdateNotifyInfoValue value : notifyInfos) {
	    	if (value.isNew()) {
	    		value.setNotifyInfoId(UpdateNotifyInfoEngine.getNewId().longValue());
	    		value.setCreateTime(UpdateNotifyInfoEngine.getSysDate());
	    		value.setStatus(CommnConstant.SYS_NOTIFY_STATE_WAIT);
	        }
    	}
    	UpdateNotifyInfoEngine.save(notifyInfos);
	}

	public void updateNotifyInfo(IUpdateNotifyInfoValue notifyInfo) throws Exception {
    	UpdateNotifyInfoEngine.save(notifyInfo);
		
	}

}
