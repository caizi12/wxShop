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
@SuppressWarnings("unchecked")
public class QBOLimitExchangeNumWareEngine {

  
public static QBOLimitExchangeNumWareBean[] getBeans(DataContainerInterface dc) throws
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

  
  public static  QBOLimitExchangeNumWareBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  QBOLimitExchangeNumWareBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (QBOLimitExchangeNumWareBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  QBOLimitExchangeNumWareBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  QBOLimitExchangeNumWareBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (QBOLimitExchangeNumWareBean[])ServiceManager.getDataStore().retrieve(conn,QBOLimitExchangeNumWareBean.class,QBOLimitExchangeNumWareBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  QBOLimitExchangeNumWareBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (QBOLimitExchangeNumWareBean[])ServiceManager.getDataStore().retrieve(conn,QBOLimitExchangeNumWareBean.class,QBOLimitExchangeNumWareBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,QBOLimitExchangeNumWareBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,QBOLimitExchangeNumWareBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( QBOLimitExchangeNumWareBean aBean) throws Exception
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

   public static  void save( QBOLimitExchangeNumWareBean[] aBeans) throws Exception{
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

   public static  void saveBatch( QBOLimitExchangeNumWareBean[] aBeans) throws Exception{
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


  public static  QBOLimitExchangeNumWareBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (QBOLimitExchangeNumWareBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(QBOLimitExchangeNumWareBean.class,QBOLimitExchangeNumWareBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  QBOLimitExchangeNumWareBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (QBOLimitExchangeNumWareBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(QBOLimitExchangeNumWareBean.class,QBOLimitExchangeNumWareBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(QBOLimitExchangeNumWareBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(QBOLimitExchangeNumWareBean.getObjectTypeStatic());
   }


   public static QBOLimitExchangeNumWareBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (QBOLimitExchangeNumWareBean)DataContainerFactory.wrap(source,QBOLimitExchangeNumWareBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static QBOLimitExchangeNumWareBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       QBOLimitExchangeNumWareBean result = new QBOLimitExchangeNumWareBean();
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

   public static QBOLimitExchangeNumWareBean transfer(IQBOLimitExchangeNumWareValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof QBOLimitExchangeNumWareBean){
			return (QBOLimitExchangeNumWareBean)value;
		}
		QBOLimitExchangeNumWareBean newBean = new QBOLimitExchangeNumWareBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static QBOLimitExchangeNumWareBean[] transfer(IQBOLimitExchangeNumWareValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof QBOLimitExchangeNumWareBean[]){
			return (QBOLimitExchangeNumWareBean[])value;
		}
		QBOLimitExchangeNumWareBean[] newBeans = new QBOLimitExchangeNumWareBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new QBOLimitExchangeNumWareBean();
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
  public static void save(IQBOLimitExchangeNumWareValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IQBOLimitExchangeNumWareValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IQBOLimitExchangeNumWareValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
