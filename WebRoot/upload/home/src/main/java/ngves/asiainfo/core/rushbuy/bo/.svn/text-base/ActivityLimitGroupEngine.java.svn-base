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
public class ActivityLimitGroupEngine {

  public static ActivityLimitGroupBean[] getBeans(DataContainerInterface dc) throws
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

    public static ActivityLimitGroupBean getBean(long _AlGroupId) throws Exception{
    String condition = "AL_GROUP_ID = " + _AlGroupId;
      Map map = new HashMap();
      ActivityLimitGroupBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              ActivityLimitGroupBean bean = new ActivityLimitGroupBean();
                            bean.setAlGroupId(_AlGroupId);
                            return bean;
      }
 }

  public static  ActivityLimitGroupBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  ActivityLimitGroupBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[]) sql.getSelectColumns().toArray(new String[sql.getSelectColumns().size()]);
      condition = sql.toString();
    }
    return getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  ActivityLimitGroupBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  ActivityLimitGroupBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (ActivityLimitGroupBean[])ServiceManager.getDataStore().retrieve(conn,ActivityLimitGroupBean.class,ActivityLimitGroupBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        } finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  ActivityLimitGroupBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (ActivityLimitGroupBean[])ServiceManager.getDataStore().retrieve(conn,ActivityLimitGroupBean.class,ActivityLimitGroupBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
          } finally{
        	if (conn != null)
                  conn.close();
          }
   }


   public static int getBeansCount(String condition,Map parameter) throws Exception{
     Connection conn = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              return ServiceManager.getDataStore().retrieveCount(conn,ActivityLimitGroupBean.getObjectTypeStatic(),condition,parameter,null);
      } finally{
          if (conn != null)
              conn.close();
      }
   }

   public static int getBeansCount(String condition,Map parameter,String[] extendBOAttrs) throws Exception{
      	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return ServiceManager.getDataStore().retrieveCount(conn,ActivityLimitGroupBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        } finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( ActivityLimitGroupBean aBean) throws Exception
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

   public static  void save( ActivityLimitGroupBean[] aBeans) throws Exception{
     	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                ServiceManager.getDataStore().save(conn,aBeans);
        } finally{
          if (conn != null)
              conn.close();
        }
   }

   public static  void saveBatch( ActivityLimitGroupBean[] aBeans) throws Exception{
     	Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                ServiceManager.getDataStore().saveBatch(conn,aBeans);
        } finally{
          if (conn != null)
              conn.close();
        }
   }


  public static  ActivityLimitGroupBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (ActivityLimitGroupBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(ActivityLimitGroupBean.class,ActivityLimitGroupBean.getObjectTypeStatic(),resultset,null,true);

      } finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  ActivityLimitGroupBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (ActivityLimitGroupBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(ActivityLimitGroupBean.class,ActivityLimitGroupBean.getObjectTypeStatic(),resultset,null,true);

      } finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(ActivityLimitGroupBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(ActivityLimitGroupBean.getObjectTypeStatic());
   }


   public static ActivityLimitGroupBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (ActivityLimitGroupBean)DataContainerFactory.wrap(source,ActivityLimitGroupBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static ActivityLimitGroupBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       ActivityLimitGroupBean result = new ActivityLimitGroupBean();
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

   public static ActivityLimitGroupBean transfer(IActivityLimitGroupValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof ActivityLimitGroupBean){
			return (ActivityLimitGroupBean)value;
		}
		ActivityLimitGroupBean newBean = new ActivityLimitGroupBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static ActivityLimitGroupBean[] transfer(IActivityLimitGroupValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof ActivityLimitGroupBean[]){
			return (ActivityLimitGroupBean[])value;
		}
		ActivityLimitGroupBean[] newBeans = new ActivityLimitGroupBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new ActivityLimitGroupBean();
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
  public static void save(IActivityLimitGroupValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IActivityLimitGroupValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IActivityLimitGroupValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
