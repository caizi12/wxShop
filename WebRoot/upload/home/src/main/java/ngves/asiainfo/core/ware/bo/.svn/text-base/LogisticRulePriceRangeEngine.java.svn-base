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

public class LogisticRulePriceRangeEngine {

  @SuppressWarnings("unchecked")
public static LogisticRulePriceRangeBean[] getBeans(DataContainerInterface dc) throws
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
	public static LogisticRulePriceRangeBean getBean(long _RangeId) throws Exception{
    String condition = "RANGE_ID = " + _RangeId;
      Map map = new HashMap();
      LogisticRulePriceRangeBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              LogisticRulePriceRangeBean bean = new LogisticRulePriceRangeBean();
                            bean.setRangeId(_RangeId);
                            return bean;
      }
 }

  public static  LogisticRulePriceRangeBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 @SuppressWarnings("unchecked")
public static  LogisticRulePriceRangeBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (LogisticRulePriceRangeBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  @SuppressWarnings("unchecked")
public static  LogisticRulePriceRangeBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  @SuppressWarnings("unchecked")
public static  LogisticRulePriceRangeBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (LogisticRulePriceRangeBean[])ServiceManager.getDataStore().retrieve(conn,LogisticRulePriceRangeBean.class,LogisticRulePriceRangeBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   @SuppressWarnings("unchecked")
public static  LogisticRulePriceRangeBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (LogisticRulePriceRangeBean[])ServiceManager.getDataStore().retrieve(conn,LogisticRulePriceRangeBean.class,LogisticRulePriceRangeBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,LogisticRulePriceRangeBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,LogisticRulePriceRangeBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( LogisticRulePriceRangeBean aBean) throws Exception
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

   public static  void save( LogisticRulePriceRangeBean[] aBeans) throws Exception{
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

   public static  void saveBatch( LogisticRulePriceRangeBean[] aBeans) throws Exception{
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
public static  LogisticRulePriceRangeBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (LogisticRulePriceRangeBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(LogisticRulePriceRangeBean.class,LogisticRulePriceRangeBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     @SuppressWarnings("unchecked")
	public static  LogisticRulePriceRangeBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (LogisticRulePriceRangeBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(LogisticRulePriceRangeBean.class,LogisticRulePriceRangeBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(LogisticRulePriceRangeBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(LogisticRulePriceRangeBean.getObjectTypeStatic());
   }


   @SuppressWarnings("unchecked")
public static LogisticRulePriceRangeBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (LogisticRulePriceRangeBean)DataContainerFactory.wrap(source,LogisticRulePriceRangeBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   @SuppressWarnings("unchecked")
public static LogisticRulePriceRangeBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       LogisticRulePriceRangeBean result = new LogisticRulePriceRangeBean();
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

   public static LogisticRulePriceRangeBean transfer(ILogisticRulePriceRangeValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof LogisticRulePriceRangeBean){
			return (LogisticRulePriceRangeBean)value;
		}
		LogisticRulePriceRangeBean newBean = new LogisticRulePriceRangeBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static LogisticRulePriceRangeBean[] transfer(ILogisticRulePriceRangeValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof LogisticRulePriceRangeBean[]){
			return (LogisticRulePriceRangeBean[])value;
		}
		LogisticRulePriceRangeBean[] newBeans = new LogisticRulePriceRangeBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new LogisticRulePriceRangeBean();
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
  public static void save(ILogisticRulePriceRangeValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( ILogisticRulePriceRangeValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( ILogisticRulePriceRangeValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
