package ngves.asiainfo.core.tuan.service.interfaces;

import ngves.asiainfo.core.tuan.dao.interfaces.IWareIntegralInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;

/**
 *
 */
public interface IWareIntegralInfoSrv {

    public void setWareIntegralInfoDAO(IWareIntegralInfoDAO wareIntegralInfoDAO) throws Exception;

     /**
     * 主要获取团购礼品对应的品牌
     * 0:全球通
     * 2:动感地带
     * @param wareId
     * @return
     * @throws Exception
     */
     public IWareIntegralInfoValue[] getBeans(Long wareId) throws Exception;
}
