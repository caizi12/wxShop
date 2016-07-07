package ngves.asiainfo.core.tuan.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.tuan.ivalues.ICategoryShowControlValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;

public class CategoryShowControlEngine {
	  @SuppressWarnings("unchecked")
  public static CategoryShowControlBean[] getBeans(DataContainerInterface dc) throws
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
    public static CategoryShowControlBean getBean(long _ShowId) throws Exception{
    String condition = "SHOW_ID = " + _ShowId;
      Map map = new HashMap();
      CategoryShowControlBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              CategoryShowControlBean bean = new CategoryShowControlBean();
                            bean.setShowId(_ShowId);
                            return bean;
      }
 }

  public static  CategoryShowControlBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
  @SuppressWarnings("unchecked")
 public static  CategoryShowControlBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (CategoryShowControlBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }



  @SuppressWarnings("unchecked")
  public static  CategoryShowControlBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }
  @SuppressWarnings("unchecked")
  public static  CategoryShowControlBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (CategoryShowControlBean[])ServiceManager.getDataStore().retrieve(conn,CategoryShowControlBean.class,CategoryShowControlBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }
  @SuppressWarnings("unchecked")
   public static  CategoryShowControlBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (CategoryShowControlBean[])ServiceManager.getDataStore().retrieve(conn,CategoryShowControlBean.class,CategoryShowControlBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,CategoryShowControlBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,CategoryShowControlBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( CategoryShowControlBean aBean) throws Exception
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

   public static  void save( CategoryShowControlBean[] aBeans) throws Exception{
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

   public static  void saveBatch( CategoryShowControlBean[] aBeans) throws Exception{
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
  public static  CategoryShowControlBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (CategoryShowControlBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(CategoryShowControlBean.class,CategoryShowControlBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }
   @SuppressWarnings("unchecked")
     public static  CategoryShowControlBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (CategoryShowControlBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(CategoryShowControlBean.class,CategoryShowControlBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(CategoryShowControlBean.getObjectTypeStatic());
   }

   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(CategoryShowControlBean.getObjectTypeStatic());
   }
   @SuppressWarnings("unchecked")
   public static CategoryShowControlBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (CategoryShowControlBean)DataContainerFactory.wrap(source,CategoryShowControlBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   @SuppressWarnings("unchecked")
   public static CategoryShowControlBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       CategoryShowControlBean result = new CategoryShowControlBean();
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

   public static CategoryShowControlBean transfer(ICategoryShowControlValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof CategoryShowControlBean){
			return (CategoryShowControlBean)value;
		}
		CategoryShowControlBean newBean = new CategoryShowControlBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static CategoryShowControlBean[] transfer(ICategoryShowControlValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof CategoryShowControlBean[]){
			return (CategoryShowControlBean[])value;
		}
		CategoryShowControlBean[] newBeans = new CategoryShowControlBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new CategoryShowControlBean();
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
  public static void save(ICategoryShowControlValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( ICategoryShowControlValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( ICategoryShowControlValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
