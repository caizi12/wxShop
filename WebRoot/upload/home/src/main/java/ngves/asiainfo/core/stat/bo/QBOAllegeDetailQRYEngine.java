package ngves.asiainfo.core.stat.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;

import ngves.asiainfo.core.stat.ivalues.IQBOAllegeDetailQRYValue;

import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;


public class QBOAllegeDetailQRYEngine {

  @SuppressWarnings("unchecked")
public static QBOAllegeDetailQRYBean[] getBeans(DataContainerInterface dc) throws
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

  
  public static  QBOAllegeDetailQRYBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 @SuppressWarnings("unchecked")
public static  QBOAllegeDetailQRYBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (QBOAllegeDetailQRYBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  @SuppressWarnings("unchecked")
public static  QBOAllegeDetailQRYBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  @SuppressWarnings("unchecked")
public static  QBOAllegeDetailQRYBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (QBOAllegeDetailQRYBean[])ServiceManager.getDataStore().retrieve(conn,QBOAllegeDetailQRYBean.class,QBOAllegeDetailQRYBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   @SuppressWarnings("unchecked")
public static  QBOAllegeDetailQRYBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (QBOAllegeDetailQRYBean[])ServiceManager.getDataStore().retrieve(conn,QBOAllegeDetailQRYBean.class,QBOAllegeDetailQRYBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,QBOAllegeDetailQRYBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,QBOAllegeDetailQRYBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( QBOAllegeDetailQRYBean aBean) throws Exception
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

   public static  void save( QBOAllegeDetailQRYBean[] aBeans) throws Exception{
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

   public static  void saveBatch( QBOAllegeDetailQRYBean[] aBeans) throws Exception{
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
public static  QBOAllegeDetailQRYBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (QBOAllegeDetailQRYBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(QBOAllegeDetailQRYBean.class,QBOAllegeDetailQRYBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     @SuppressWarnings("unchecked")
	public static  QBOAllegeDetailQRYBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (QBOAllegeDetailQRYBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(QBOAllegeDetailQRYBean.class,QBOAllegeDetailQRYBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(QBOAllegeDetailQRYBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(QBOAllegeDetailQRYBean.getObjectTypeStatic());
   }


   @SuppressWarnings("unchecked")
public static QBOAllegeDetailQRYBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (QBOAllegeDetailQRYBean)DataContainerFactory.wrap(source,QBOAllegeDetailQRYBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   @SuppressWarnings("unchecked")
public static QBOAllegeDetailQRYBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       QBOAllegeDetailQRYBean result = new QBOAllegeDetailQRYBean();
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

   public static QBOAllegeDetailQRYBean transfer(IQBOAllegeDetailQRYValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof QBOAllegeDetailQRYBean){
			return (QBOAllegeDetailQRYBean)value;
		}
		QBOAllegeDetailQRYBean newBean = new QBOAllegeDetailQRYBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static QBOAllegeDetailQRYBean[] transfer(IQBOAllegeDetailQRYValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof QBOAllegeDetailQRYBean[]){
			return (QBOAllegeDetailQRYBean[])value;
		}
		QBOAllegeDetailQRYBean[] newBeans = new QBOAllegeDetailQRYBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new QBOAllegeDetailQRYBean();
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
  public static void save(IQBOAllegeDetailQRYValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IQBOAllegeDetailQRYValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IQBOAllegeDetailQRYValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
