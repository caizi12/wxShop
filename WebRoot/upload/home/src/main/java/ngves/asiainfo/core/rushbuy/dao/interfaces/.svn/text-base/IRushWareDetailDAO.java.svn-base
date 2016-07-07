package ngves.asiainfo.core.rushbuy.dao.interfaces;

import ngves.asiainfo.core.rushbuy.ivalues.IQBOMainImageInfoValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOWareDescInfoValue;
import ngves.asiainfo.core.rushbuy.ivalues.IWareKindBrandInfoValue;

/**
 * 抢兑礼品详细页数据持久化层
 * @author zhulin
 *
 */
public interface IRushWareDetailDAO {
    

    /**
     * 取得礼品类别和品牌信息，用于礼品详细页展示
     * @param wareId
     * @return
     * @throws Exception
     */
    public IWareKindBrandInfoValue getWareKindBrandInfo(String wareId)throws Exception;
    
    /**
     * 取得抢兑礼品主图片信息
     * @return
     * @throws Exception
     */
    public IQBOMainImageInfoValue[] getWareMainImgInfo() throws Exception;
    
    /**
     * 取得礼品某一个属性信息
     * @param wareId
     * @param descId
     * @return
     * @throws Exception
     */
    public IQBOWareDescInfoValue getWareDescInfo(String wareId,String descId) throws Exception; 
    
    /**
     * 根据礼品ID获取对应的主图片,如果没有内容或多于1个会返回null
     * @param wareId
     * @return
     * @throws Exception
     */
    public IQBOMainImageInfoValue getWareMainImgById(long wareId) throws Exception;
    
}
