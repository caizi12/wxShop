package ngves.asiainfo.core.floor.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.floor.bo.FineRecomonBean;
import ngves.asiainfo.core.floor.ivalues.IFineRecomonValue;

public interface IFineRecomonDAO {
	 /**
     * 根据id查询数据对象，得到FineRecomonBean 
     * @param recomonId
     * @throws Exception   
     */
	public FineRecomonBean queryFineRecomonInfoById(String recomonId) throws Exception;
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
     * 根据conditon组装查询sql，匹配查询结果总数.,用于前台分页--fineRecomonName
     * @param 
     * @throws Exception 
     * @return int
     */
    public int queryFineRecomonInfoCount(String conditon, Map<String, String> parameter) throws Exception;
	/**
	 *根据前台是否展示标示，查询精品推荐信息，用于前台web端的页面数据查询
	 * @param  showFlag
	 * @return IFineRecomonValue[] 
     * @throws Exception
	 */
    public IFineRecomonValue[] getFineRecomonInfosByShowFlag(String showFlag) throws Exception;
	

}
