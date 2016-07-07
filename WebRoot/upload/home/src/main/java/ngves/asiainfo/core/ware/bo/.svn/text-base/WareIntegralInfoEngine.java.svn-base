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
public class WareIntegralInfoEngine {

	  public static WareIntegralInfoBean[] getBeans(DataContainerInterface dc) throws
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

	    public static WareIntegralInfoBean getBean(long _IntegralId) throws Exception{
	    String condition = "INTEGRAL_ID = " + _IntegralId;
	      Map map = new HashMap();
	      WareIntegralInfoBean[] beans = getBeans(condition,map);
	      if(beans!=null && beans.length==1)
	              return beans[0];
	      else if(beans!=null && beans.length>1){
	              throw new Exception("[����]��������ѯ����һ�����ϼ�¼");
	      }else{
	              WareIntegralInfoBean bean = new WareIntegralInfoBean();
	                            bean.setIntegralId(_IntegralId);
	                            return bean;
	      }
	 }

	  public static  WareIntegralInfoBean[] getBeans(Criteria sql) throws Exception{
	   return getBeans(sql,-1,-1,false);
	  }
	 public static  WareIntegralInfoBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
	    String[] cols = null;
	    String condition = "";
	    if(sql != null){
	      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
	      condition = sql.toString();
	    }
	    return (WareIntegralInfoBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
	  }




	  public static  WareIntegralInfoBean[] getBeans(String condition,Map parameter) throws Exception{
		return getBeans(null,condition,parameter,-1,-1,false);
	  }

	  public static  WareIntegralInfoBean[] getBeans(String[] cols,String condition,Map parameter,
	           int startNum,int endNum,boolean isShowFK) throws Exception{
	        Connection conn = null;
	        try {
	                conn = ServiceManager.getSession().getConnection();
	                return (WareIntegralInfoBean[])ServiceManager.getDataStore().retrieve(conn,WareIntegralInfoBean.class,WareIntegralInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
	        }catch(Exception e){
	                throw e;
	        }finally{
	           if (conn != null)
	              conn.close();
	        }
	  }

	   public static  WareIntegralInfoBean[] getBeans(String[] cols,String condition,Map parameter,
	          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
	          Connection conn = null;
	          try {
	                  conn = ServiceManager.getSession().getConnection();
	                  return (WareIntegralInfoBean[])ServiceManager.getDataStore().retrieve(conn,WareIntegralInfoBean.class,WareIntegralInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
	              return ServiceManager.getDataStore().retrieveCount(conn,WareIntegralInfoBean.getObjectTypeStatic(),condition,parameter,null);
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
	                return ServiceManager.getDataStore().retrieveCount(conn,WareIntegralInfoBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
	        }catch(Exception e){
	                throw e;
	        }finally{
	          if (conn != null)
	              conn.close();
	        }
	   }

	  public static void save( WareIntegralInfoBean aBean) throws Exception
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

	   public static  void save( WareIntegralInfoBean[] aBeans) throws Exception{
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

	   public static  void saveBatch( WareIntegralInfoBean[] aBeans) throws Exception{
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


	  public static  WareIntegralInfoBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
	      Connection conn = null;
	      ResultSet resultset = null;
	      try {
	              conn = ServiceManager.getSession().getConnection();
	              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
	              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	              return (WareIntegralInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(WareIntegralInfoBean.class,WareIntegralInfoBean.getObjectTypeStatic(),resultset,null,true);

	      }catch(Exception e){
	              throw e;
	      }finally{
	          if(resultset!=null)resultset.close();
	          if (conn != null)
	              conn.close();
	      }
	   }

	     public static  WareIntegralInfoBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
	      Connection conn = null;
	      ResultSet resultset = null;
	      try {
	              conn = ServiceManager.getSession().getConnection();
	              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
	              return (WareIntegralInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(WareIntegralInfoBean.class,WareIntegralInfoBean.getObjectTypeStatic(),resultset,null,true);

	      }catch(Exception e){
	              throw e;
	      }finally{
	          if(resultset!=null)resultset.close();
	          if (conn != null)
	              conn.close();
	      }
	   }

	   public static java.math.BigDecimal getNewId() throws Exception{
	       return ServiceManager.getIdGenerator().getNewId(WareIntegralInfoBean.getObjectTypeStatic());
	   }


	   @SuppressWarnings("deprecation")
	public static java.sql.Timestamp getSysDate() throws Exception{
	       return ServiceManager.getIdGenerator().getSysDate(WareIntegralInfoBean.getObjectTypeStatic());
	   }


	   public static WareIntegralInfoBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
	     try{
	       return (WareIntegralInfoBean)DataContainerFactory.wrap(source,WareIntegralInfoBean.class,colMatch,canModify);
	     }catch(Exception e){
	       if(e.getCause()!=null)
	         throw new RuntimeException(e.getCause());
	       else
	         throw new RuntimeException(e);
	     }
	   }
	   public static WareIntegralInfoBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
	     try {
	       WareIntegralInfoBean result = new WareIntegralInfoBean();
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

	   public static WareIntegralInfoBean transfer(IWareIntegralInfoValue value) {
	   	if(value==null)
	   		return null;
		try {
			if(value instanceof WareIntegralInfoBean){
				return (WareIntegralInfoBean)value;
			}
			WareIntegralInfoBean newBean = new WareIntegralInfoBean();

			DataContainerFactory.transfer(value ,newBean);
			return newBean;
		}catch (Exception ex) {
			if(ex.getCause()!=null)
				throw new RuntimeException(ex.getCause());
			else
				throw new RuntimeException(ex);
		}
	   }

	   public static WareIntegralInfoBean[] transfer(IWareIntegralInfoValue[] value) {
	   	if(value==null || value.length==0)
	   		return null;

		try {
			if(value instanceof WareIntegralInfoBean[]){
				return (WareIntegralInfoBean[])value;
			}
			WareIntegralInfoBean[] newBeans = new WareIntegralInfoBean[value.length];
	   		for(int i=0;i<newBeans.length;i++){
	   			newBeans[i] = new WareIntegralInfoBean();
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
	  public static void save(IWareIntegralInfoValue aValue) throws Exception
	  {
	     save(transfer(aValue));
	  }

	   public static  void save( IWareIntegralInfoValue[] aValues) throws Exception{
	          save(transfer(aValues));
	   }

	   public static  void saveBatch( IWareIntegralInfoValue[] aValues) throws Exception{
	     saveBatch(transfer(aValues));
	   }
	}
