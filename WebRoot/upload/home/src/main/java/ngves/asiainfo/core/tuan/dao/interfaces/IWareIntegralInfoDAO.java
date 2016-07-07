package ngves.asiainfo.core.tuan.dao.interfaces;

import ngves.asiainfo.core.ware.ivalues.IWareIntegralInfoValue;

/**
 * 获取团购礼品对应的品牌
 * shenfl
 */
public interface IWareIntegralInfoDAO {

    /**
     * 主要获取团购礼品对应的品牌
     * 0:全球通
     * 2:动感地带
     * @param wareId
     * @return
     * @throws Exception
     */
     public IWareIntegralInfoValue[] getBeans(Long wareId) throws Exception;
     
     /**
      * 保存礼品积分信息
      * @param wareIntegralInfoValue
      * @throws Exception
      */
     public void saveWareIntegralInfo(IWareIntegralInfoValue wareIntegralInfoValue) throws Exception;

}
