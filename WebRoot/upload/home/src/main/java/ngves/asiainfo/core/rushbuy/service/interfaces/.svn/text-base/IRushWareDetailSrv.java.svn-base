package ngves.asiainfo.core.rushbuy.service.interfaces;

import ngves.asiainfo.core.rushbuy.dao.interfaces.IRushWareDetailDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOMainImageInfoValue;

/**
 * 抢兑礼品详细页
 * 更加ware_info表取得礼品信息
 * @author zhulin
 *
 */
public interface IRushWareDetailSrv {
    
    public void setRushWareDetailDAO(IRushWareDetailDAO rushWareDetailDAO);
    
    /**
     * 取得抢兑礼品主图片信息
     * @return
     * @throws Exception
     */
    public IQBOMainImageInfoValue[] getWareMainImgInfo() throws Exception;
    /**
     * 根据礼品ID获取对应的主图片,如果没有内容或多于1个会返回null
     * @param wareId
     * @return
     * @throws Exception
     */
    public IQBOMainImageInfoValue getWareMainImgById(long wareId) throws Exception;
   

}
