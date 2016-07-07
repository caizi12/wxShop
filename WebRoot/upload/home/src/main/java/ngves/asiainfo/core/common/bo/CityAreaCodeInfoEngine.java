package ngves.asiainfo.core.common.bo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.ivalues.ICityAreaCodeInfoValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
@SuppressWarnings("unchecked")
public class CityAreaCodeInfoEngine {

 
public static CityAreaCodeInfoBean[] getBeans(DataContainerInterface dc) throws
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

    public static CityAreaCodeInfoBean getBean(long _CityAreaCodeId) throws Exception{
    String condition = "CITY_AREA_CODE_ID = " + _CityAreaCodeId;
      Map map = new HashMap();
      CityAreaCodeInfoBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[错误]根据主键查询出现一条以上记录");
      }else{
              CityAreaCodeInfoBean bean = new CityAreaCodeInfoBean();
                            bean.setCityAreaCodeId(_CityAreaCodeId);
                            return bean;
      }
 }

  public static  CityAreaCodeInfoBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  CityAreaCodeInfoBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (CityAreaCodeInfoBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  CityAreaCodeInfoBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  CityAreaCodeInfoBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (CityAreaCodeInfoBean[])ServiceManager.getDataStore().retrieve(conn,CityAreaCodeInfoBean.class,CityAreaCodeInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  CityAreaCodeInfoBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (CityAreaCodeInfoBean[])ServiceManager.getDataStore().retrieve(conn,CityAreaCodeInfoBean.class,CityAreaCodeInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,CityAreaCodeInfoBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,CityAreaCodeInfoBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( CityAreaCodeInfoBean aBean) throws Exception
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

   public static  void save( CityAreaCodeInfoBean[] aBeans) throws Exception{
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

   public static  void saveBatch( CityAreaCodeInfoBean[] aBeans) throws Exception{
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


  public static  CityAreaCodeInfoBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (CityAreaCodeInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(CityAreaCodeInfoBean.class,CityAreaCodeInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  CityAreaCodeInfoBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (CityAreaCodeInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(CityAreaCodeInfoBean.class,CityAreaCodeInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(CityAreaCodeInfoBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(CityAreaCodeInfoBean.getObjectTypeStatic());
   }


   public static CityAreaCodeInfoBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (CityAreaCodeInfoBean)DataContainerFactory.wrap(source,CityAreaCodeInfoBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static CityAreaCodeInfoBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       CityAreaCodeInfoBean result = new CityAreaCodeInfoBean();
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

   public static CityAreaCodeInfoBean transfer(ICityAreaCodeInfoValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof CityAreaCodeInfoBean){
			return (CityAreaCodeInfoBean)value;
		}
		CityAreaCodeInfoBean newBean = new CityAreaCodeInfoBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static CityAreaCodeInfoBean[] transfer(ICityAreaCodeInfoValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof CityAreaCodeInfoBean[]){
			return (CityAreaCodeInfoBean[])value;
		}
		CityAreaCodeInfoBean[] newBeans = new CityAreaCodeInfoBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new CityAreaCodeInfoBean();
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
  public static void save(ICityAreaCodeInfoValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( ICityAreaCodeInfoValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( ICityAreaCodeInfoValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
