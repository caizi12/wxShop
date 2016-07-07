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
public class WareLimitExchangeNumEngine {

  
public static WareLimitExchangeNumBean[] getBeans(DataContainerInterface dc) throws
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

    public static WareLimitExchangeNumBean getBean(String _WareLimitId) throws Exception{
    String condition = "WARE_LIMIT_ID = " + _WareLimitId;
      Map map = new HashMap();
      WareLimitExchangeNumBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              WareLimitExchangeNumBean bean = new WareLimitExchangeNumBean();
                            bean.setWareLimitId(_WareLimitId);
                            return bean;
      }
 }

  public static  WareLimitExchangeNumBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  WareLimitExchangeNumBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (WareLimitExchangeNumBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  WareLimitExchangeNumBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  WareLimitExchangeNumBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (WareLimitExchangeNumBean[])ServiceManager.getDataStore().retrieve(conn,WareLimitExchangeNumBean.class,WareLimitExchangeNumBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  WareLimitExchangeNumBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (WareLimitExchangeNumBean[])ServiceManager.getDataStore().retrieve(conn,WareLimitExchangeNumBean.class,WareLimitExchangeNumBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,WareLimitExchangeNumBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,WareLimitExchangeNumBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( WareLimitExchangeNumBean aBean) throws Exception
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

   public static  void save( WareLimitExchangeNumBean[] aBeans) throws Exception{
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

   public static  void saveBatch( WareLimitExchangeNumBean[] aBeans) throws Exception{
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


  public static  WareLimitExchangeNumBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (WareLimitExchangeNumBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(WareLimitExchangeNumBean.class,WareLimitExchangeNumBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  WareLimitExchangeNumBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (WareLimitExchangeNumBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(WareLimitExchangeNumBean.class,WareLimitExchangeNumBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(WareLimitExchangeNumBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(WareLimitExchangeNumBean.getObjectTypeStatic());
   }


   public static WareLimitExchangeNumBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (WareLimitExchangeNumBean)DataContainerFactory.wrap(source,WareLimitExchangeNumBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static WareLimitExchangeNumBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       WareLimitExchangeNumBean result = new WareLimitExchangeNumBean();
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

   public static WareLimitExchangeNumBean transfer(IWareLimitExchangeNumValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof WareLimitExchangeNumBean){
			return (WareLimitExchangeNumBean)value;
		}
		WareLimitExchangeNumBean newBean = new WareLimitExchangeNumBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static WareLimitExchangeNumBean[] transfer(IWareLimitExchangeNumValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof WareLimitExchangeNumBean[]){
			return (WareLimitExchangeNumBean[])value;
		}
		WareLimitExchangeNumBean[] newBeans = new WareLimitExchangeNumBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new WareLimitExchangeNumBean();
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
  public static void save(IWareLimitExchangeNumValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IWareLimitExchangeNumValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IWareLimitExchangeNumValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
