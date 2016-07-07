package ngves.asiainfo.core.rushbuy.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.rushbuy.bo.QBOMainImageInfoBean;
import ngves.asiainfo.core.rushbuy.bo.QBOMainImageInfoEngine;
import ngves.asiainfo.core.rushbuy.bo.QBOWareDescInfoEngine;
import ngves.asiainfo.core.rushbuy.bo.WareKindBrandInfoEngine;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IRushWareDetailDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOMainImageInfoValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOWareDescInfoValue;
import ngves.asiainfo.core.rushbuy.ivalues.IWareKindBrandInfoValue;
/**
 * 抢兑礼品详细页数据持久化层
 * @author zhulin
 *
 */
public class RushWareDetailDAOImpl implements IRushWareDetailDAO {
	
	private static Log logger = LogFactory.getLog(RushWareDetailDAOImpl.class);
	
	private static final String GETWAREMAINIMGBYID_SQL = IQBOMainImageInfoValue.S_WareId + " = :" + IQBOMainImageInfoValue.S_WareId;

    public IWareKindBrandInfoValue getWareKindBrandInfo(String wareId)throws Exception{
        Map<String,String> param  = new HashMap<String,String>();
        param.put("wareId", wareId);
        IWareKindBrandInfoValue[] wareKindBrandInfos = WareKindBrandInfoEngine.getBeans(null, param);
        return wareKindBrandInfos.length > 0  ? wareKindBrandInfos[0] : null;
    }
    
    /**
     * 取得抢兑礼品主图片信息
     * @return
     * @throws Exception
     */
    public IQBOMainImageInfoValue[] getWareMainImgInfo() throws Exception{
        return QBOMainImageInfoEngine.getBeans(null, null);
    }
    
    
    public IQBOMainImageInfoValue getWareMainImgById(long wareId) throws Exception{
    	Map<String,Long> param  = new HashMap<String,Long>();
        param.put(IQBOMainImageInfoValue.S_WareId, wareId);
        QBOMainImageInfoBean[] wareMainImgInfos = QBOMainImageInfoEngine.getBeans(GETWAREMAINIMGBYID_SQL, param);
        if(wareMainImgInfos.length != 1 ) {
        	logger.error(" getWareMainImgById  length := " + wareMainImgInfos.length  + " by wareId := " + wareId);
        	return null;
        }
        return wareMainImgInfos[0];
    }
    /**
     * 取得礼品某一个属性信息
     * @param wareId
     * @param descId
     * @return
     * @throws Exception
     */
    public IQBOWareDescInfoValue getWareDescInfo(String wareId,String descId) throws Exception{
        Map<String,String> param = new HashMap<String,String>();
        param.put("wareId", wareId);
        param.put("descId", descId);
        IQBOWareDescInfoValue[] wareDescInfos = QBOWareDescInfoEngine.getBeans(null, param);
        return wareDescInfos.length > 0 ? wareDescInfos[0] : null;
    }
}
