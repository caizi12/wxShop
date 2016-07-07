package ngves.asiainfo.core.smsformwork.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.smsformwork.ivalues.ISmsFormworkWareInfoRltValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

@SuppressWarnings("unchecked")
public class SmsFormworkWareInfoRltEngine {

  
	public static SmsFormworkWareInfoRltBean[] getBeans(DataContainerInterface dc) throws
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

    public static SmsFormworkWareInfoRltBean getBean(String _RltId) throws Exception{
    String condition = "RLT_ID = '" + _RltId + "'";
      Map map = new HashMap();
      SmsFormworkWareInfoRltBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              SmsFormworkWareInfoRltBean bean = new SmsFormworkWareInfoRltBean();
                            bean.setRltId(_RltId);
                            return bean;
      }
 }

  public static  SmsFormworkWareInfoRltBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  SmsFormworkWareInfoRltBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (SmsFormworkWareInfoRltBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  SmsFormworkWareInfoRltBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  SmsFormworkWareInfoRltBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (SmsFormworkWareInfoRltBean[])ServiceManager.getDataStore().retrieve(conn,SmsFormworkWareInfoRltBean.class,SmsFormworkWareInfoRltBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  SmsFormworkWareInfoRltBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (SmsFormworkWareInfoRltBean[])ServiceManager.getDataStore().retrieve(conn,SmsFormworkWareInfoRltBean.class,SmsFormworkWareInfoRltBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
          }catch(Exception e){
                  throw e;
          }finally{
        	if (conn != null)
                  conn.close();
          }
   }


   public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              return ServiceManager.getDataStore().retrieveCount(conn,SmsFormworkWareInfoRltBean.getObjectTypeStatic(),condition,parameter,null);
      }catch(Exception e){
              throw e;
      }finally{
          if (conn != null)
              conn.close();
      }
   }

   public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
      	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return ServiceManager.getDataStore().retrieveCount(conn,SmsFormworkWareInfoRltBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( SmsFormworkWareInfoRltBean aBean) throws Exception
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

   public static  void save( SmsFormworkWareInfoRltBean[] aBeans) throws Exception{
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

   public static  void saveBatch( SmsFormworkWareInfoRltBean[] aBeans) throws Exception{
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


  public static  SmsFormworkWareInfoRltBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (SmsFormworkWareInfoRltBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(SmsFormworkWareInfoRltBean.class,SmsFormworkWareInfoRltBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  SmsFormworkWareInfoRltBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (SmsFormworkWareInfoRltBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(SmsFormworkWareInfoRltBean.class,SmsFormworkWareInfoRltBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(SmsFormworkWareInfoRltBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
   public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(SmsFormworkWareInfoRltBean.getObjectTypeStatic());
   }


   public static SmsFormworkWareInfoRltBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (SmsFormworkWareInfoRltBean)DataContainerFactory.wrap(source,SmsFormworkWareInfoRltBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static SmsFormworkWareInfoRltBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       SmsFormworkWareInfoRltBean result = new SmsFormworkWareInfoRltBean();
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

   public static SmsFormworkWareInfoRltBean transfer(ISmsFormworkWareInfoRltValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof SmsFormworkWareInfoRltBean){
			return (SmsFormworkWareInfoRltBean)value;
		}
		SmsFormworkWareInfoRltBean newBean = new SmsFormworkWareInfoRltBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static SmsFormworkWareInfoRltBean[] transfer(ISmsFormworkWareInfoRltValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof SmsFormworkWareInfoRltBean[]){
			return (SmsFormworkWareInfoRltBean[])value;
		}
		SmsFormworkWareInfoRltBean[] newBeans = new SmsFormworkWareInfoRltBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new SmsFormworkWareInfoRltBean();
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
  public static void save(ISmsFormworkWareInfoRltValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( ISmsFormworkWareInfoRltValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( ISmsFormworkWareInfoRltValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
