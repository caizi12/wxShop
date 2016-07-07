package ngves.asiainfo.core.rushbuy.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import ngves.asiainfo.core.rushbuy.ivalues.*;

@SuppressWarnings("unchecked")
public class QBOFinishedActivityLimitGroupEngine {

  public static QBOFinishedActivityLimitGroupBean[] getBeans(DataContainerInterface dc) throws
      Exception {
    Map ps = dc.getProperties();
    StringBuffer buffer = new StringBuffer();
    Map pList = new HashMap();
      for (Object o : ps.entrySet()) {
          Map.Entry e = (Map.Entry) o;
          if (buffer.length() > 0)
              buffer.append(" and ");
          buffer.append(e.getKey().toString()).append(" = :p_").append(e.getKey().toString());
          pList.put("p_" + e.getKey().toString(), e.getValue());
      }
    Connection conn = ServiceManager.getSession().getConnection();
    try {
      return getBeans(buffer.toString(), pList);
    }finally{
      if (conn != null)
        conn.close();
    }
  }

  
  public static  QBOFinishedActivityLimitGroupBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  QBOFinishedActivityLimitGroupBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[]) sql.getSelectColumns().toArray(new String[sql.getSelectColumns().size()]);
      condition = sql.toString();
    }
    return getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  QBOFinishedActivityLimitGroupBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  QBOFinishedActivityLimitGroupBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (QBOFinishedActivityLimitGroupBean[])ServiceManager.getDataStore().retrieve(conn,QBOFinishedActivityLimitGroupBean.class,QBOFinishedActivityLimitGroupBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        } finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  QBOFinishedActivityLimitGroupBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (QBOFinishedActivityLimitGroupBean[])ServiceManager.getDataStore().retrieve(conn,QBOFinishedActivityLimitGroupBean.class,QBOFinishedActivityLimitGroupBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
          } finally{
        	if (conn != null)
                  conn.close();
          }
   }


   public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              return ServiceManager.getDataStore().retrieveCount(conn,QBOFinishedActivityLimitGroupBean.getObjectTypeStatic(),condition,parameter,null);
      } finally{
          if (conn != null)
              conn.close();
      }
   }

   public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
      	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return ServiceManager.getDataStore().retrieveCount(conn,QBOFinishedActivityLimitGroupBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        } finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( QBOFinishedActivityLimitGroupBean aBean) throws Exception
  {
  	Connection conn = null;
	try {
		conn = ServiceManager.getSession().getConnection();
   		ServiceManager.getDataStore().save(conn,aBean);
   	} finally{
        if (conn != null) {
            conn.close();
        }
    }
  }

   public static  void save( QBOFinishedActivityLimitGroupBean[] aBeans) throws Exception{
     	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                ServiceManager.getDataStore().save(conn,aBeans);
        } finally{
          if (conn != null)
              conn.close();
        }
   }

   public static  void saveBatch( QBOFinishedActivityLimitGroupBean[] aBeans) throws Exception{
     	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                ServiceManager.getDataStore().saveBatch(conn,aBeans);
        } finally{
          if (conn != null)
              conn.close();
        }
   }


  public static  QBOFinishedActivityLimitGroupBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (QBOFinishedActivityLimitGroupBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(QBOFinishedActivityLimitGroupBean.class,QBOFinishedActivityLimitGroupBean.getObjectTypeStatic(),resultset,null,true);

      } finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  QBOFinishedActivityLimitGroupBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (QBOFinishedActivityLimitGroupBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(QBOFinishedActivityLimitGroupBean.class,QBOFinishedActivityLimitGroupBean.getObjectTypeStatic(),resultset,null,true);

      } finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(QBOFinishedActivityLimitGroupBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(QBOFinishedActivityLimitGroupBean.getObjectTypeStatic());
   }


   public static QBOFinishedActivityLimitGroupBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (QBOFinishedActivityLimitGroupBean)DataContainerFactory.wrap(source,QBOFinishedActivityLimitGroupBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static QBOFinishedActivityLimitGroupBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       QBOFinishedActivityLimitGroupBean result = new QBOFinishedActivityLimitGroupBean();
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

   public static QBOFinishedActivityLimitGroupBean transfer(IQBOFinishedActivityLimitGroupValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof QBOFinishedActivityLimitGroupBean){
			return (QBOFinishedActivityLimitGroupBean)value;
		}
		QBOFinishedActivityLimitGroupBean newBean = new QBOFinishedActivityLimitGroupBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static QBOFinishedActivityLimitGroupBean[] transfer(IQBOFinishedActivityLimitGroupValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof QBOFinishedActivityLimitGroupBean[]){
			return (QBOFinishedActivityLimitGroupBean[])value;
		}
		QBOFinishedActivityLimitGroupBean[] newBeans = new QBOFinishedActivityLimitGroupBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new QBOFinishedActivityLimitGroupBean();
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
  public static void save(IQBOFinishedActivityLimitGroupValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IQBOFinishedActivityLimitGroupValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IQBOFinishedActivityLimitGroupValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
