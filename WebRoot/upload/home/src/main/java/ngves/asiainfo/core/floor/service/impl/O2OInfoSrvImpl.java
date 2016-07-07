package ngves.asiainfo.core.floor.service.impl;

import java.util.HashMap;
import java.util.Map;
import ngves.asiainfo.core.floor.bo.O2OInfoBean;
import ngves.asiainfo.core.floor.dao.interfaces.IO2OInfoDAO;
import ngves.asiainfo.core.floor.dao.interfaces.IO2OWareRltDAO;
import ngves.asiainfo.core.floor.ivalues.IO2OInfoValue;
import ngves.asiainfo.core.floor.ivalues.IO2OWareRltValue;
import ngves.asiainfo.core.floor.service.interfaces.IO2OInfoSrv;
public class O2OInfoSrvImpl implements IO2OInfoSrv {
    private IO2OInfoDAO o2oInfoDao;   
    private IO2OWareRltDAO o2oWareRltDao;
    public void setO2oInfoDao(IO2OInfoDAO o2oInfoDao) throws Exception {
		this.o2oInfoDao = o2oInfoDao;
	 }	
    public void setO2oWareRltDao(IO2OWareRltDAO wareRltDao) throws Exception {
		   o2oWareRltDao = wareRltDao;
	   }
	
	public void deleteO2OInfo(IO2OInfoValue infobean) throws Exception {
		if(null!=infobean){
			o2oInfoDao.deleteO2OInfo(infobean);
		}
	}
	 public void deleteO2OInfo(String  o2oId) throws Exception{
		 if(null!=o2oId&&!"".equals(o2oId)){
			 o2oInfoDao.deleteO2OInfo(o2oId);
		 }
	 }

	
	public O2OInfoBean queryO2OInfoById(String o2oId) throws Exception {
		if(null!=o2oId&&!"".equals(o2oId)){
			return o2oInfoDao.queryO2OInfoById(o2oId);			
		}
		else{
			return null;
		}
		
	}

	
	public IO2OInfoValue[] queryO2OInfos(String o2oInfoName, int startNum, int endNum)
			throws Exception {		
			return o2oInfoDao.queryO2OInfos(o2oInfoName, startNum, endNum);
	}

	
	public int queryO2OInfosCount(String o2oInfoName) throws Exception{
		 StringBuffer condition = new StringBuffer("  1=1   ");
		 int result=0; 
		 Map<String, String> parameter = new HashMap<String, String>();
		 if(null!=o2oInfoName&&!"".equals(o2oInfoName)){
			 condition.append(" AND "+IO2OInfoValue.S_O2oName+" like "+"'%"+o2oInfoName+"%'");
			 parameter.put(IO2OInfoValue.S_O2oName, o2oInfoName);
			 result=o2oInfoDao.queryO2OInfosCount(condition.toString(), parameter);
		   
		 }
		 else{
			  result=o2oInfoDao.queryO2OInfosCount(condition.toString(), parameter); 
		 }
		  return result;	
	}

	
	public void saveO2OInfo(IO2OInfoValue infobean) throws Exception {
		if(null!=infobean){
			o2oInfoDao.saveO2OInfo(infobean);
		}
	}
	 
	 /**
     * 更新O2OInfo信息，保存和更新操作共用一个方法
     * @param o2oInfobean
     * @throws Exception 
     * @return long  返回新增或者更新实体对应数据库的id值
     */
    public long saveO2OInfoByEntity(IO2OInfoValue o2oInfobean) throws Exception{
    	long o2oInfoId=0;
    	if(null!=o2oInfobean){
    		o2oInfoId=o2oInfoDao.saveO2OInfoByEntity(o2oInfobean);    		
    	}
    	return o2oInfoId;
    }
    
    /**
     * 根据O2O是否首页展示   查询O2OInfo[]信息,用于web端数据展示
     * @param isShowFlag
     * @throws Exception 
     * @return O2OInfoBean
     */
    public IO2OInfoValue[] queryO2OInfoByShowFlag(String isShowFlag) throws Exception{
    		
    	return o2oInfoDao.queryO2OInfoByShowFlag(isShowFlag);    
    	
    }
    //查询O2O类型是商品，并且在前台展示的信息
    public IO2OInfoValue[] queryO2OInfoByType(String type) throws Exception{
        return o2oInfoDao.queryO2OInfoByType(type);   	
    
    }
    
    public IO2OWareRltDAO getO2oWareRltDao() {
	     return o2oWareRltDao;
   }
 
   //O2O与礼品的关系处理方法 开始   

	public void deleteO2OWareRlt(IO2OWareRltValue wareRltValue)
			throws Exception {
		o2oWareRltDao.deleteO2OWareRlt(wareRltValue);

	}
	public IO2OWareRltValue[] queryO2OWareRltById(String id) throws Exception {
		
		return o2oWareRltDao.queryO2OWareRltById(id);
	}

	public void saveO2OWareRlt(IO2OWareRltValue wareRltValue) throws Exception {
		o2oWareRltDao.saveO2OWareRlt(wareRltValue);

	}
	public void deleteO2OWareRltByO2OId(String o2oId) throws Exception{
		IO2OWareRltValue[] tempO2oWareRlt=o2oWareRltDao.queryO2OWareRltById(o2oId);
		if(tempO2oWareRlt.length>0){
			for(int i=0;i<tempO2oWareRlt.length;i++){
				long o2oWareRltId=tempO2oWareRlt[i].getO2oRltId();
				o2oWareRltDao.deleteO2OWareRlt(o2oWareRltId);
				
			}
		}
		
	}
	
	public IO2OInfoDAO getO2oInfoDao() {
		return o2oInfoDao;
	}

}
