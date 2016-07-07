package ngves.asiainfo.core.floor.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import ngves.asiainfo.core.floor.bo.FineRecomonBean;
import ngves.asiainfo.core.floor.bo.FineRecomonEngine;
import ngves.asiainfo.core.floor.dao.interfaces.IFineRecomonDAO;
import ngves.asiainfo.core.floor.ivalues.IFineRecomonValue;

public class FineRecomonDAOImpl implements IFineRecomonDAO {
	 /**
     * 根据id查询数据对象，得到FineRecomonBean 
     * @param recomonId
     * @throws Exception   
     */    
	public FineRecomonBean queryFineRecomonInfoById(String recomonId) throws Exception{
		if(null!=recomonId){
			long fineRecomonId=Long.parseLong(recomonId);
			return FineRecomonEngine.getBean(fineRecomonId);
		}
		else{
			return null;
		}
		
	}  

	 /**
     * 根据conditon组装查询sql，匹配查询结果总数.,用于前台分页--fineRecomonName
     * @param 
     * @throws Exception 
     * @return int
     */
    public int queryFineRecomonInfoCount(String conditon, Map<String, String> parameter) throws Exception{
    	return FineRecomonEngine.getBeansCount(conditon, parameter);
    }
    
	@Override
	public void deleteFineRecomonInfo(IFineRecomonValue recomonValue)
			throws Exception {
		long fineRecomonId=recomonValue.getFineRecomonId();
		if(fineRecomonId!=0){
			IFineRecomonValue fineRecomonTemp=FineRecomonEngine.getBean(fineRecomonId);
			fineRecomonTemp.delete();
			FineRecomonEngine.save(fineRecomonTemp);
		}

	}
    
	
	
	/**
     * 根据 名称、起始页查询结果集.如果fineRecomonName为空，查询所有精品推荐记录
     * @param  fineRecomonName，startNum，endNum
     * @throws Exception 
     * @return ITestDemonValue[]
     */
	@Override
	public IFineRecomonValue[] queryAllFineRecomonInfos(String fineRecomonName,
			int startNum, int endNum) throws Exception {  
		StringBuffer strbuffer=new StringBuffer();
		Map<String,String >  parame=new  HashMap<String, String>();
		if(null!=fineRecomonName&&!"".equals(fineRecomonName)){//采用数据绑定方法
			strbuffer.append(IFineRecomonValue.S_RecomonName+" like "+"'%"+fineRecomonName+"%'"); 
			parame.put(IFineRecomonValue.S_RecomonName, fineRecomonName);			
		}
		//最新需求：需求将首页展示的数据放结果集最前面，同时按原有照排序展示
		strbuffer.append(" order by "+"to_number("+IFineRecomonValue.S_IsHomeShow+") desc,");
		//需求要求是按照排序字段排序 设计的时候为varchar 需要强转 
		strbuffer.append(" to_number("+IFineRecomonValue.S_Sort+")" );
		return FineRecomonEngine.getBeans(null, strbuffer.toString(), parame, startNum, endNum, false);
	} 
	
	
	 /**
     * 根据名称查询数据对象，得到IFineRecomonValue[] 因为涉及到模糊查询 
     * @param recomoonName
     * @throws Exception   
     */
	@Override
	public IFineRecomonValue[] queryFineRecomonInfo(String recomoonName)
			throws Exception {		
        //根据姓名查询  和 分页查询可以合并。。要执行模糊查询
		//直接组装sql进行查询
		String sqlString=null;
		Map<String,String >  parame=new  HashMap<String, String>();
		if(null!=recomoonName&& !"".equals(recomoonName)){
			sqlString=IFineRecomonValue.S_RecomonName+" like "+"'%"+recomoonName+"%'"; 
			parame.put(IFineRecomonValue.S_RecomonName, recomoonName);
		}
		 return FineRecomonEngine.getBeansFromSql(sqlString, parame);
	}
   
	
	  /**
	   * 保存方法。入参为 IFineRecomonValue对象.针对对象是否是new(),进行主键生成
	   * @param recomonValue
	   * @throws Exception   
	   */
	@Override
	public void saveFineRecomonInfo(IFineRecomonValue recomonValue)
			throws Exception {
		if(recomonValue.isNew()){//新对象，生成主键
			long rencomId=FineRecomonEngine.getNewId().longValue();
			recomonValue.setFineRecomonId(rencomId);
			recomonValue.setCreateDate(new Timestamp(new Date().getTime()));
			FineRecomonEngine.save(recomonValue);
		}
		else{//更新老对象
			 recomonValue.setModifyDate(new Timestamp(new Date().getTime()));
			 FineRecomonEngine.save(recomonValue);	
		}
		

	}

	@Override
	public void updateFineRecomonInfo(IFineRecomonValue recomonValue)
			throws Exception {
		if(!recomonValue.isNew()){ //更新操作，不是新对象
			FineRecomonEngine.save(recomonValue);
		}	

	}
	
	 public IFineRecomonValue[] getFineRecomonInfosByShowFlag(String showFlag) throws Exception{
		 //是否为空验证，在上层代码中执行
		 StringBuffer strbuffer=new StringBuffer();
		 strbuffer.append(" 1=1 ");
		 Map<String,String >  parame=new  HashMap<String, String>();
		 strbuffer.append(" AND "+IFineRecomonValue.S_IsHomeShow+" =:"+IFineRecomonValue.S_IsHomeShow);
		 parame.put(IFineRecomonValue.S_IsHomeShow, showFlag);		
		 strbuffer.append(" order by  "+" to_number("+IFineRecomonValue.S_Sort+")" );
		 return FineRecomonEngine.getBeans(strbuffer.toString(), parame);
	 }

}
