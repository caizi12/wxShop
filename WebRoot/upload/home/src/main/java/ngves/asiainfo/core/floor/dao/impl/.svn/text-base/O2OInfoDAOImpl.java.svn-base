package ngves.asiainfo.core.floor.dao.impl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import ngves.asiainfo.core.floor.bo.O2OInfoBean;
import ngves.asiainfo.core.floor.bo.O2OInfoEngine;
import ngves.asiainfo.core.floor.dao.interfaces.IO2OInfoDAO;
import ngves.asiainfo.core.floor.ivalues.IO2OInfoValue;

public class O2OInfoDAOImpl implements IO2OInfoDAO {

	
	public void deleteO2OInfo(IO2OInfoValue infobean) throws Exception {
         long o2oInfoId=infobean.getO2oId();
         if(o2oInfoId!=0){
        	 IO2OInfoValue  o2oInfoTemp=O2OInfoEngine.getBean(o2oInfoId);
        	 if(null!=o2oInfoTemp){
        		 o2oInfoTemp.delete();
        		 O2OInfoEngine.save(o2oInfoTemp);        		 
        	 }        	 
         }
	}

    public void deleteO2OInfo(String  o2oId) throws Exception{
    	   long o2oInfoId=Long.parseLong(o2oId);    	 
    	   if(o2oInfoId!=0){
          	 IO2OInfoValue  o2oInfoTemp=O2OInfoEngine.getBean(o2oInfoId);
          	 if(null!=o2oInfoTemp){
          		 o2oInfoTemp.delete();
          		 O2OInfoEngine.save(o2oInfoTemp);        		 
          	 }         	 
           }
    }

	
	public O2OInfoBean queryO2OInfoById(String id) throws Exception {
		if(null!=id){
			long o2oInfoId=Long.parseLong(id);
			return O2OInfoEngine.getBean(o2oInfoId);			
		}
		else{
			return null;
		}
	}
    //支持按照名称查询的模糊分页处理
	 
	public IO2OInfoValue[] queryO2OInfos(String name, int startNum, int endNum)
			throws Exception {
		StringBuffer strbuffer=new StringBuffer();
		Map<String,String >  parame=new  HashMap<String, String>();
		if(null!=name&&!"".equals(name)){
			strbuffer.append(IO2OInfoValue.S_O2oName+" like '%"+name+"%'");
			parame.put(IO2OInfoValue.S_O2oName, name);
		}
		//根据需求，需按照sort进行排序 ..这里排序字段 设计时候本身是NUMBER类型 。。不用to_number()转换
		strbuffer.append(" order by "+IO2OInfoValue.S_Sort);		
		return O2OInfoEngine.getBeans(null, strbuffer.toString(), parame, startNum, endNum, false);
		
	}

	public int queryO2OInfosCount(String conditon, Map<String, String> parameter)
			throws Exception {
	      return O2OInfoEngine.getBeansCount(conditon, parameter);
	}

	public void saveO2OInfo(IO2OInfoValue infobean) throws Exception {
		if(infobean.isNew()){//新对象，产生主键，再进行保存操作。
			long o2oInfoId=O2OInfoEngine.getNewId().longValue();
			infobean.setO2oId(o2oInfoId);
			infobean.setCreateDate(new Timestamp(new Date().getTime()));
			O2OInfoEngine.save(infobean);
		}
		else{//更新对象 操作时候，直接进行保存(操作时间更改时间在dao层复用)
			infobean.setModifyDate(new Timestamp(new Date().getTime()));
			O2OInfoEngine.save(infobean);
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
    	if(o2oInfobean.isNew()){//新对象，产生主键，再进行保存操作。
			long newId=O2OInfoEngine.getNewId().longValue();
			o2oInfobean.setO2oId(newId);
			o2oInfobean.setCreateDate(new Timestamp(new Date().getTime()));
			O2OInfoEngine.save(o2oInfobean);
			o2oInfoId=newId; //对象保存之后，返回新的主键值
		}   
		else{//更新对象 操作时候，直接进行保存
			o2oInfobean.setModifyDate(new Timestamp(new Date().getTime()));
			O2OInfoEngine.save(o2oInfobean);
			o2oInfoId=o2oInfobean.getO2oId();
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
    	StringBuffer strbuffer=new StringBuffer();
		Map<String,String >  parame=new  HashMap<String, String>();
    	strbuffer.append(IO2OInfoValue.S_IsHomeShow+"=:"+IO2OInfoValue.S_IsHomeShow);
    	strbuffer.append(" AND "+IO2OInfoValue.S_O2oContent+" IS NOT NULL ");
    	parame.put(IO2OInfoValue.S_IsHomeShow, isShowFlag);      
    	strbuffer.append(" order by "+IO2OInfoValue.S_Sort);    	
    	return O2OInfoEngine.getBeans(strbuffer.toString(), parame);
    	
    }
   // 根据O2O专区类型,并且在前台展示的信息 
    public IO2OInfoValue[] queryO2OInfoByType(String type) throws Exception{
    	StringBuffer strbuffer=new StringBuffer();
		Map<String,String >  parame=new  HashMap<String, String>();
		if(null!=type&&!"".equals(type)){
    		strbuffer.append(IO2OInfoValue.S_O2oType+"=:"+IO2OInfoValue.S_O2oType);
    		parame.put(IO2OInfoValue.S_O2oType, type);
    		strbuffer.append(" AND "+IO2OInfoValue.S_IsHomeShow+"=:"+IO2OInfoValue.S_IsHomeShow);
    		strbuffer.append(" AND "+IO2OInfoValue.S_O2oContent+"  IS NOT NULL  ");
    		String isShowFlag="1";//首页展示
    		parame.put(IO2OInfoValue.S_IsHomeShow,isShowFlag);
    	}
		strbuffer.append(" order by "+IO2OInfoValue.S_Sort);    	
    	return O2OInfoEngine.getBeans(strbuffer.toString(), parame);
    }

}
