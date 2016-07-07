package ngves.asiainfo.core.ware.service.interfaces;

import ngves.asiainfo.core.ware.dao.interfaces.IWarePicSynDAO;
import ngves.asiainfo.core.ware.ivalues.IWarePicSynValue;



/**
 * 和优选  礼品图片同步服务
 *
 */
public interface IWarePicSynSrv {
	
	public void setWarePicSynDAO(IWarePicSynDAO warePicSynDAO)throws Exception;
	
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
    public IWarePicSynValue[] getWarePicSynValue() throws Exception;
 
    
	
}
