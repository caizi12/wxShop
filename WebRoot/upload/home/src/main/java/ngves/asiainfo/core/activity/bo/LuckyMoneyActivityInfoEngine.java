package ngves.asiainfo.core.activity.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import ngves.asiainfo.core.activity.ivalues.*;
@SuppressWarnings("unchecked")
public class LuckyMoneyActivityInfoEngine {

  public static LuckyMoneyActivityInfoBean[] getBeans(DataContainerInterface dc) throws
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

    public static LuckyMoneyActivityInfoBean getBean(long _LuckyId) throws Exception{
    String condition = "LUCKY_ID = " + _LuckyId;
      Map map = new HashMap();
      LuckyMoneyActivityInfoBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("");
      }else{
              LuckyMoneyActivityInfoBean bean = new LuckyMoneyActivityInfoBean();
                            bean.setLuckyId(_LuckyId);
                            return bean;
      }
 }

  public static  LuckyMoneyActivityInfoBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  LuckyMoneyActivityInfoBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (LuckyMoneyActivityInfoBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  LuckyMoneyActivityInfoBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  LuckyMoneyActivityInfoBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (LuckyMoneyActivityInfoBean[])ServiceManager.getDataStore().retrieve(conn,LuckyMoneyActivityInfoBean.class,LuckyMoneyActivityInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  LuckyMoneyActivityInfoBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (LuckyMoneyActivityInfoBean[])ServiceManager.getDataStore().retrieve(conn,LuckyMoneyActivityInfoBean.class,LuckyMoneyActivityInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,LuckyMoneyActivityInfoBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,LuckyMoneyActivityInfoBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( LuckyMoneyActivityInfoBean aBean) throws Exception
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

   public static  void save( LuckyMoneyActivityInfoBean[] aBeans) throws Exception{
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

   public static  void saveBatch( LuckyMoneyActivityInfoBean[] aBeans) throws Exception{
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


  public static  LuckyMoneyActivityInfoBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (LuckyMoneyActivityInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(LuckyMoneyActivityInfoBean.class,LuckyMoneyActivityInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  LuckyMoneyActivityInfoBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (LuckyMoneyActivityInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(LuckyMoneyActivityInfoBean.class,LuckyMoneyActivityInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(LuckyMoneyActivityInfoBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(LuckyMoneyActivityInfoBean.getObjectTypeStatic());
   }


   public static LuckyMoneyActivityInfoBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (LuckyMoneyActivityInfoBean)DataContainerFactory.wrap(source,LuckyMoneyActivityInfoBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static LuckyMoneyActivityInfoBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       LuckyMoneyActivityInfoBean result = new LuckyMoneyActivityInfoBean();
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

   public static LuckyMoneyActivityInfoBean transfer(ILuckyMoneyActivityInfoValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof LuckyMoneyActivityInfoBean){
			return (LuckyMoneyActivityInfoBean)value;
		}
		LuckyMoneyActivityInfoBean newBean = new LuckyMoneyActivityInfoBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static LuckyMoneyActivityInfoBean[] transfer(ILuckyMoneyActivityInfoValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof LuckyMoneyActivityInfoBean[]){
			return (LuckyMoneyActivityInfoBean[])value;
		}
		LuckyMoneyActivityInfoBean[] newBeans = new LuckyMoneyActivityInfoBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new LuckyMoneyActivityInfoBean();
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
  public static void save(ILuckyMoneyActivityInfoValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( ILuckyMoneyActivityInfoValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( ILuckyMoneyActivityInfoValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
