package ngves.asiainfo.core.floor.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import ngves.asiainfo.core.floor.bo.FineRecomonBean;
import ngves.asiainfo.core.floor.dao.interfaces.IFineRecomonDAO;
import ngves.asiainfo.core.floor.ivalues.IFineRecomonValue;
import ngves.asiainfo.core.floor.service.interfaces.IFineRecomonSrv;
import ngves.asiainfo.json.JsonUtil;


public class FineRecomonSrvImpl implements IFineRecomonSrv {
    //SRV层，使用dao层进行业务逻辑和数据交互
	 private IFineRecomonDAO fineRecomonDAO; 

	 /**
	  * setFineRecomonDAO :用于框架srv层加载dao实例。
	  * 如果没有这个setFineRecomonDAO接口方法，会出现服务未定义错误
	  * 通过这种方式，在srv层中直接注入dao层实例。减少srv层在使用dao层引用时候每次通过getService()去获取。
	  * @param fineRecomonDAO
	  * @throws Exception    
	  */
	public void setFineRecomonDAO(IFineRecomonDAO fineRecomonDAO) throws Exception {
		this.fineRecomonDAO = fineRecomonDAO;
	}
	public IFineRecomonDAO getFineRecomonDAO() {
		return fineRecomonDAO;
	}
	
	 /**
     * 根据id查询数据对象，得到FineRecomonBean 
     * @param recomonId
     * @throws Exception   
     */
	public FineRecomonBean queryFineRecomonInfoById(String recomonId) throws Exception{
		return fineRecomonDAO.queryFineRecomonInfoById(recomonId);		
	
	}
	
	 /**
     * 删除方法 入参为 IFineRecomonValue对象
     * @param recomonValue
     * @throws Exception   
     */
	@Override
	public void deleteFineRecomonInfo(IFineRecomonValue recomonValue)
			throws Exception {
		if(null==recomonValue){
			throw new Exception("删除对象为空");
		} 
		else{
			fineRecomonDAO.deleteFineRecomonInfo(recomonValue);
		}

	}

	
	/**
     * 根据 名称、起始页查询结果集.如果fineRecomonName为空，查询所有精品推荐记录
     * @param  fineRecomonName，startNum，endNum
     * @throws Exception 
     * @return ITestDemonValue[]
     */
	@Override
	public IFineRecomonValue[] queryAllFineRecomonInfos(String fineRecomonName,	int startNum, int endNum) throws Exception {
		
		return fineRecomonDAO.queryAllFineRecomonInfos(fineRecomonName, startNum, endNum);

	}
	
	
	 /**
     * 根据名称查询数据对象，得到IFineRecomonValue[] 因为涉及到模糊查询 
     * @param recomoonName
     * @throws Exception   
     */	  
	public IFineRecomonValue[] queryFineRecomonInfo(String recomoonName)
			throws Exception {
		if(null!=recomoonName){
		   return 	fineRecomonDAO.queryFineRecomonInfo(recomoonName);
		}
		else{
		   return null;
		}
	
	}
    
	/**
	 * 前台table，用于分页的时候。必须使用一个服务层方法来计算总数。
	 * 根据精品推荐需求，客户只需要输入查询名称或者不输入任何字符来获取结果。
	 * 在服务层，只需要一个参数fineRecomonName。所以方法设计为如下：
	 * @param  fineRecomonName
	 * @return int
     * @throws Exception
	 */
	 public int getFineRecomonInfosCount(String fineRecomonName) throws Exception{
		 StringBuffer condition = new StringBuffer("1=1");
		 int result=0;
		 Map<String, String> parameter = new HashMap<String, String>();
		 if(null!=fineRecomonName&&!"".equals(fineRecomonName)){//利用名称进行模糊查询，计算总数  like : ,在绑定数据传入参数的时候也是需要%%的
			 condition.append(" AND ");
			 String str=IFineRecomonValue.S_RecomonName+" LIKE :"+IFineRecomonValue.S_RecomonName;
			 condition.append(str);
			 parameter.put(IFineRecomonValue.S_RecomonName, "%"+fineRecomonName+"%");  
			 result=fineRecomonDAO.queryFineRecomonInfoCount(condition.toString(), parameter);
		 }
		 else{//查询所有数据，计算总数。
			 result= fineRecomonDAO.queryFineRecomonInfoCount(condition.toString(), parameter);
		 }
		return result;
	 }
	
	  /**
	   * 保存方法。入参为 IFineRecomonValue对象
	   * @param recomonValue
	   * @throws Exception   
	   */
	@Override
	public void saveFineRecomonInfo(IFineRecomonValue recomonValue)
			throws Exception {
		if(null!=recomonValue){
			fineRecomonDAO.saveFineRecomonInfo(recomonValue);
		}
		else{
			throw new Exception("保存对象为空！");
		}
		



	}
   
	  /**
	   * 更新方法。入参为 IFineRecomonValue对象
	   * @param recomonValue
	   * @throws Exception   
	   */
	@Override
	public void updateFineRecomonInfo(IFineRecomonValue recomonValue)
			throws Exception {
		if(null!=recomonValue){
			fineRecomonDAO.updateFineRecomonInfo(recomonValue);
		}
		else{
			throw new Exception("更新对象为空！");
		}
	}
	
	
	public IFineRecomonValue[] getFineRecomonInfosByShowFlag(String showFlag) throws Exception{
		return fineRecomonDAO.getFineRecomonInfosByShowFlag(showFlag);
	}   
	
	public String getFineRecomonByShowFlag(String showFlag) throws Exception{
		IFineRecomonValue[] values=fineRecomonDAO.getFineRecomonInfosByShowFlag(showFlag);
		FineRecomonBean fineRecomonBean=null;
		List<FineRecomonBean> list=new ArrayList<FineRecomonBean>();
		for(IFineRecomonValue temp:values){
			fineRecomonBean=new FineRecomonBean();
			fineRecomonBean.setFineRecomonId(temp.getFineRecomonId());
			fineRecomonBean.setRecomonName(temp.getRecomonName());
			fineRecomonBean.setRecomonHref(temp.getRecomonHref());
			fineRecomonBean.setRecomonImgUrl(temp.getRecomonImgUrl());
			list.add(fineRecomonBean);
			fineRecomonBean=null;
		}
		//循环加载泛型对象到List数组结束
		String brandRecomonJson = JsonUtil.toJson(list);
		return brandRecomonJson;
	}
	

}
