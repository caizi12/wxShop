package ngves.asiainfo.core.floor.bo;



import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;

import com.ai.appframe2.bo.DataContainerFactory;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;


@SuppressWarnings("unchecked")
public class NavbarKindInfoEngine {

  public static NavbarKindInfoBean[] getBeans(DataContainerInterface dc) throws
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

    public static NavbarKindInfoBean getBean(long _NavbarKindId) throws Exception{
    String condition = "NAVBAR_KIND_ID = " + _NavbarKindId;
      Map map = new HashMap();
      NavbarKindInfoBean[] beans = getBeans(condition,map);
      if(beans!=null && beans.length==1)
              return beans[0];
      else if(beans!=null && beans.length>1){
              throw new Exception("[����]��������ѯ����һ�����ϼ�¼");
      }else{
              NavbarKindInfoBean bean = new NavbarKindInfoBean();
                            bean.setNavbarKindId(_NavbarKindId);
                            return bean;
      }
 }

  public static  NavbarKindInfoBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  NavbarKindInfoBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (NavbarKindInfoBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }




  public static  NavbarKindInfoBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  NavbarKindInfoBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (NavbarKindInfoBean[])ServiceManager.getDataStore().retrieve(conn,NavbarKindInfoBean.class,NavbarKindInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  NavbarKindInfoBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (NavbarKindInfoBean[])ServiceManager.getDataStore().retrieve(conn,NavbarKindInfoBean.class,NavbarKindInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,NavbarKindInfoBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,NavbarKindInfoBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( NavbarKindInfoBean aBean) throws Exception
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

   public static  void save( NavbarKindInfoBean[] aBeans) throws Exception{
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

   public static  void saveBatch( NavbarKindInfoBean[] aBeans) throws Exception{
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


  public static  NavbarKindInfoBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (NavbarKindInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(NavbarKindInfoBean.class,NavbarKindInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  NavbarKindInfoBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (NavbarKindInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(NavbarKindInfoBean.class,NavbarKindInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(NavbarKindInfoBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(NavbarKindInfoBean.getObjectTypeStatic());
   }


   public static NavbarKindInfoBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (NavbarKindInfoBean)DataContainerFactory.wrap(source,NavbarKindInfoBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static NavbarKindInfoBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       NavbarKindInfoBean result = new NavbarKindInfoBean();
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

   public static NavbarKindInfoBean transfer(INavbarKindInfoValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof NavbarKindInfoBean){
			return (NavbarKindInfoBean)value;
		}
		NavbarKindInfoBean newBean = new NavbarKindInfoBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static NavbarKindInfoBean[] transfer(INavbarKindInfoValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof NavbarKindInfoBean[]){
			return (NavbarKindInfoBean[])value;
		}
		NavbarKindInfoBean[] newBeans = new NavbarKindInfoBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new NavbarKindInfoBean();
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
  public static void save(INavbarKindInfoValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( INavbarKindInfoValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( INavbarKindInfoValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
