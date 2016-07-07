package ngves.asiainfo.core.rushbuy.service.impl;
import ngves.asiainfo.core.rushbuy.dao.interfaces.IRushWareDetailDAO;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOMainImageInfoValue;
import ngves.asiainfo.core.rushbuy.ivalues.IQBOWareDescInfoValue;
import ngves.asiainfo.core.rushbuy.service.interfaces.IRushWareDetailSrv;

/**
 * 抢兑礼品详细页
 * 取得礼品信息
 * @author zhulin
 *
 */
public class RushWareDetailSrvImpl implements IRushWareDetailSrv {
    
  private IRushWareDetailDAO rushWareDetailDAO;
  public void setRushWareDetailDAO(IRushWareDetailDAO rushWareDetailDAO){
      this.rushWareDetailDAO = rushWareDetailDAO;
  }
    
  
   /**
    * 取得抢兑礼品主图片信息
    * @return
    * @throws Exception
    */
   public IQBOMainImageInfoValue[] getWareMainImgInfo() throws Exception{
       return rushWareDetailDAO.getWareMainImgInfo();
   }
   
   /**
    * 取得礼品某一个属性信息
    * @param wareId
    * @param descId
    * @return
    * @throws Exception
    */
   public IQBOWareDescInfoValue getWareDescInfo(String wareId,String descId) throws Exception{
       return rushWareDetailDAO.getWareDescInfo(wareId, descId);
   }
   
   public IQBOMainImageInfoValue getWareMainImgById(long wareId) throws Exception {
	   return rushWareDetailDAO.getWareMainImgById(wareId);
   }

}
