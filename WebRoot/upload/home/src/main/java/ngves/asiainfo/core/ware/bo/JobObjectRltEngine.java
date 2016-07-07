package ngves.asiainfo.core.ware.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import ngves.asiainfo.core.ware.ivalues.*;

public class JobObjectRltEngine {

  @SuppressWarnings("unchecked")
public static JobObjectRltBean[] getBeans(DataContainerInterface dc) throws
      Exception {
    Map ps = dc.getProperties();
    StringBuffer buffer = new StringBuffer();
    Map pList = new HashMap();
    for (java.util.Iterator cc = ps.entrySet().iterator(); cc.hasNext(); ) {
      Map.Entry e = (Map.Entry) cc.next();
      if(buffer.length() >0)
         buffer.append(" and ");
      buffer.append(e.getKey().toString() + " = :p_" + e.getKey().toString());
      pList.put("p_" + e.getKey().toString(),e.getValue());
    }
    Connection conn = ServiceManager.getSession().getConnection();
    try {
      return getBeans(buffer.toString(), pList);
    }finally{
      if (conn != null)
        conn.close();
    }
  }

    @SuppressWarnings("unchecked")
	public static JobObjectRltBean getBean(long _JobObjectRltId) throws Exception{
    String condition = "JOB_OBJECT_RLT_ID = " + _JobObjectRltId;
      Map map = new HashMap();
      JobObjectRltBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              JobObjectRltBean bean = new JobObjectRltBean();
                            bean.setJobObjectRltId(_JobObjectRltId);
                            return bean;
      }
 }

  public static  JobObjectRltBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 @SuppressWarnings("unchecked")
public static  JobObjectRltBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (JobObjectRltBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  @SuppressWarnings("unchecked")
public static  JobObjectRltBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  @SuppressWarnings("unchecked")
public static  JobObjectRltBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (JobObjectRltBean[])ServiceManager.getDataStore().retrieve(conn,JobObjectRltBean.class,JobObjectRltBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   @SuppressWarnings("unchecked")
public static  JobObjectRltBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (JobObjectRltBean[])ServiceManager.getDataStore().retrieve(conn,JobObjectRltBean.class,JobObjectRltBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
          }catch(Exception e){
                  throw e;
          }finally{
        	if (conn != null)
                  conn.close();
          }
   }


   @SuppressWarnings("unchecked")
public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              return ServiceManager.getDataStore().retrieveCount(conn,JobObjectRltBean.getObjectTypeStatic(),condition,parameter,null);
      }catch(Exception e){
              throw e;
      }finally{
          if (conn != null)
              conn.close();
      }
   }

   @SuppressWarnings("unchecked")
public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
      	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return ServiceManager.getDataStore().retrieveCount(conn,JobObjectRltBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( JobObjectRltBean aBean) throws Exception
  {
  	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
   		ServiceManager.getDataStore().save(conn,aBean);
   	}catch(Exception e){
		throw e;
	}finally{
		conn.close();
	}
  }

   public static  void save( JobObjectRltBean[] aBeans) throws Exception{
     	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                ServiceManager.getDataStore().save(conn,aBeans);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

   public static  void saveBatch( JobObjectRltBean[] aBeans) throws Exception{
     	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                ServiceManager.getDataStore().saveBatch(conn,aBeans);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }


  @SuppressWarnings("unchecked")
public static  JobObjectRltBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (JobObjectRltBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(JobObjectRltBean.class,JobObjectRltBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     @SuppressWarnings("unchecked")
	public static  JobObjectRltBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (JobObjectRltBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(JobObjectRltBean.class,JobObjectRltBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(JobObjectRltBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(JobObjectRltBean.getObjectTypeStatic());
   }


   @SuppressWarnings("unchecked")
public static JobObjectRltBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (JobObjectRltBean)DataContainerFactory.wrap(source,JobObjectRltBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   @SuppressWarnings("unchecked")
public static JobObjectRltBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       JobObjectRltBean result = new JobObjectRltBean();
       DataContainerFactory.copy(source, result, colMatch);
       return result;
     }
     catch (AIException ex) {
       if(ex.getCause()!=null)
         throw new RuntimeException(ex.getCause());
       else
         throw new RuntimeException(ex);
     }
    }

   public static JobObjectRltBean transfer(IJobObjectRltValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof JobObjectRltBean){
			return (JobObjectRltBean)value;
		}
		JobObjectRltBean newBean = new JobObjectRltBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static JobObjectRltBean[] transfer(IJobObjectRltValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof JobObjectRltBean[]){
			return (JobObjectRltBean[])value;
		}
		JobObjectRltBean[] newBeans = new JobObjectRltBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new JobObjectRltBean();
			DataContainerFactory.transfer(value[i] ,newBeans[i]);
		}
		return newBeans;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }
  public static void save(IJobObjectRltValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IJobObjectRltValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IJobObjectRltValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
