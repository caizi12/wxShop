package ngves.asiainfo.core.floor.dao.impl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import ngves.asiainfo.core.floor.bo.O2OWareRltEngine;
import ngves.asiainfo.core.floor.dao.interfaces.IO2OWareRltDAO;
import ngves.asiainfo.core.floor.ivalues.IO2OWareRltValue;

public class O2OWareRltDAOImpl implements IO2OWareRltDAO {  

	@Override
	public void deleteO2OWareRlt(IO2OWareRltValue wareRltValue)
			throws Exception {
		long o2owareRltId=wareRltValue.getO2oRltId();
		if(o2owareRltId!=0){
			IO2OWareRltValue  o2owareTemp=O2OWareRltEngine.getBean(o2owareRltId);
	        	 if(null!=o2owareTemp){
	        		 o2owareTemp.delete();
	        		 O2OWareRltEngine.save(o2owareTemp);        		 
	        	 }        	 
	    }		
	}



	@Override
	public void saveO2OWareRlt(IO2OWareRltValue wareRltValue) throws Exception {
		 if(wareRltValue.isNew()){
			 long o2owareRltId=O2OWareRltEngine.getNewId().longValue();
			 wareRltValue.setO2oRltId(o2owareRltId);
			 wareRltValue.setCreateDate(new Timestamp(new Date().getTime()));
			 O2OWareRltEngine.save(wareRltValue);			 
		 }
		 else{
			 wareRltValue.setModifyDate(new Timestamp(new Date().getTime()));
			 O2OWareRltEngine.save(wareRltValue);		
		 }

	}


    /**
     * 根据O2O专区ID查询，O2O和礼品关系表数据
     **/
	@Override
	public IO2OWareRltValue[] queryO2OWareRltById(String o2oid) throws Exception {
		StringBuffer strbuffer=new StringBuffer();
		Map<String,String >  parame=new  HashMap<String, String>();
		strbuffer.append(IO2OWareRltValue.S_O2oId+"=:"+IO2OWareRltValue.S_O2oId);
		parame.put(IO2OWareRltValue.S_O2oId, o2oid);
		strbuffer.append("  order by "+IO2OWareRltValue.S_O2oRltId);		
		return O2OWareRltEngine.getBeans(strbuffer.toString(), parame);
	}
	//根据主键删除实体方法
	public void deleteO2OWareRlt(Long o2owareRltId) throws Exception{
		if(o2owareRltId!=0){
			IO2OWareRltValue  o2owareTemp=O2OWareRltEngine.getBean(o2owareRltId);
	        	 if(null!=o2owareTemp){
	        		 o2owareTemp.delete();
	        		 O2OWareRltEngine.save(o2owareTemp);        		 
	        	 }        	 
	    }	
	}


}
