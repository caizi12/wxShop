package ngves.asiainfo.core.floor.service.interfaces;

import ngves.asiainfo.core.floor.bo.FineRecomonBean;
import ngves.asiainfo.core.floor.dao.interfaces.IFineRecomonDAO;
import ngves.asiainfo.core.floor.ivalues.IFineRecomonValue;

public interface IFineRecomonSrv {
	 /**
     * setFineRecomonDAO :用于框架srv层加载dao实例。
     * 如果没有这个setFineRecomonDAO接口方法，会出现服务未定义错误
     * 通过这种方式，在srv层中直接注入dao层实例。减少srv层在使用dao层引用时候每次通过getService()去获取。
     * @param fineRecomonDAO
     * @throws Exception    
     */
	public void setFineRecomonDAO(IFineRecomonDAO fineRecomonDAO) throws Exception;
	 /**
     * 根据名称查询数据对象，得到IFineRecomonValue[] 因为涉及到模糊查询 
     * @param recomoonName
     * @throws Exception   
     */	  
	public IFineRecomonValue[] queryFineRecomonInfo(String recomoonName) throws Exception;
	  /**
	   * 保存方法。入参为 IFineRecomonValue对象
	   * @param recomonValue
	   * @throws Exception   
	   */
	
	public void saveFineRecomonInfo(IFineRecomonValue recomonValue) throws Exception;
	 /**
     * 根据id查询数据对象，得到FineRecomonBean 
     * @param recomonId
     * @throws Exception   
     */
	public FineRecomonBean queryFineRecomonInfoById(String recomonId) throws Exception;
	  /**
	   * 更新方法。入参为 IFineRecomonValue对象
	   * @param recomonValue
	   * @throws Exception   
	   */
	public void  updateFineRecomonInfo(IFineRecomonValue recomonValue) throws Exception;
	  /**
       * 删除方法 入参为 IFineRecomonValue对象
       * @param recomonValue
       * @throws Exception   
       */
	public void deleteFineRecomonInfo(IFineRecomonValue recomonValue) throws Exception;
	/**
     * 根据 名称、起始页查询结果集.如果fineRecomonName为空，查询所有精品推荐记录
     * @param  fineRecomonName，startNum，endNum
     * @throws Exception 
     * @return ITestDemonValue[]
     */
	public IFineRecomonValue[] queryAllFineRecomonInfos(String  fineRecomonName,int startNum,int endNum) throws Exception;
	
	/**
	 * 前台table，用于分页的时候。必须使用一个服务层方法来计算总数。
	 * 根据精品推荐需求，客户只需要输入查询名称或者不输入任何字符来获取结果。
	 * 在服务层，只需要一个参数fineRecomonName。所以方法设计为如下：
	 * @param  fineRecomonName
	 * @return int
     * @throws Exception
	 */
	 public int getFineRecomonInfosCount(String fineRecomonName) throws Exception;
		/**
		 *根据前台是否展示标示，查询精品推荐信息，用于前台web端的页面数据查询
		 * @param  showFlag
		 * @return IFineRecomonValue[] 
	     * @throws Exception
		 */
	 public IFineRecomonValue[] getFineRecomonInfosByShowFlag(String showFlag) throws Exception;
	  
	 public String getFineRecomonByShowFlag(String showFlag) throws Exception;
}
