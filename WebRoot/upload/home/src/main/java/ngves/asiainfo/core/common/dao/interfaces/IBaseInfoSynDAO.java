package ngves.asiainfo.core.common.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.common.ivalues.IBaseInfoSynValue;
import ngves.asiainfo.core.common.ivalues.IUpdateNotifyInfoValue;

public interface IBaseInfoSynDAO {
	 /**
     * 查询要同步的信息
     * @param condition
     * @param parameter
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public IBaseInfoSynValue[] querySynInfos(String condition, Map parameter) throws Exception;

    /**
     * 保存要同步信息
     * @param synInfos
     * @throws Exception
     */
    public void saveSynInfos(IBaseInfoSynValue[] synInfos) throws Exception;
    
    
    /**
     * 查询通知信息
     * @param condition
     * @param parameter
     * @return
     * @throws Exception
     */
	public IUpdateNotifyInfoValue[] queryNotifyInfo(String condition,Map<String, String> parameter) throws Exception;
	/**
	 * 更新通知信息
	 * @param notifyInfo
	 * @throws Exception
	 */
    public void updateNotifyInfo(IUpdateNotifyInfoValue notifyInfo) throws Exception;
	/**
	 * 保存通知信息
	 * @param notifyInfos
	 * @throws Exception
	 */
    public void saveNotifyInfo(IUpdateNotifyInfoValue[] notifyInfos) throws Exception;
}
