package ngves.asiainfo.core.review.bo;

import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.Connection;
import com.ai.appframe2.common.AIException;
import com.ai.appframe2.common.DataContainerInterface;
import com.ai.appframe2.common.ServiceManager;
import com.ai.appframe2.util.criteria.Criteria;
import com.ai.appframe2.bo.DataContainerFactory;

import ngves.asiainfo.core.review.ivalues.*;
@SuppressWarnings("unchecked")
public class ReviewInfoEngine {


public static ReviewInfoBean[] getBeans(DataContainerInterface dc) throws
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

  
  public static  ReviewInfoBean[] getBeans(Criteria sql) throws Exception{
   return getBeans(sql,-1,-1,false);
  }
 public static  ReviewInfoBean[] getBeans(Criteria sql,int startNum,int endNum,boolean isShowFK) throws Exception{
    String[] cols = null;
    String condition = "";
    if(sql != null){
      cols = (String[])sql.getSelectColumns().toArray(new String[0]);
      condition = sql.toString();
    }
    return (ReviewInfoBean[])getBeans(cols,condition,null,startNum,endNum,isShowFK);
  }
 /**
  * 根据id查找
  * @param _ReviewId
  * @return
  * @throws Exception
  */
	public static ReviewInfoBean getBean(long _ReviewId) throws Exception{
		 String condition = "REVIEW_ID = " + _ReviewId;
			Map map = new HashMap();
			ReviewInfoBean[] beans = getBeans(condition, map);
			if (beans != null && beans.length == 1)
				return beans[0];
			else if (beans != null && beans.length > 1) {
				throw new Exception("[错误]根据主键查询出现一条以上记录");
			} else {
				ReviewInfoBean bean = new ReviewInfoBean();
				bean.setReviewId(_ReviewId);
				return bean;
		}
	}
	 /**
     *  拼接sql语句做分页
     * @param sql sql语句
     * @param parameter Map 
     * @param startNum 开始页
     * @param endNum 结束页
     * @param isShowFK  是否展示外键 false
     * @return object对象
     * @throws Exception
     */
    public static  ReviewInfoBean[] getBeansFromSql(String sql,Map parameter,int startNum,int endNum,boolean isShowFK) throws Exception{
       Connection conn = null;
       ResultSet resultset = null;
       try {
               conn = ServiceManager.getSession().getConnection();
               resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
               return (ReviewInfoBean[])ServiceManager.getDataStore().retrieve(conn,ReviewInfoBean.class,ReviewInfoBean.getObjectTypeStatic(),null,null,parameter,startNum,endNum,isShowFK,false,null);

       }catch(Exception e){
               throw e;
       }finally{
           if(resultset!=null)resultset.close();
           if (conn != null)
               conn.close();
       }
   }


  public static  ReviewInfoBean[] getBeans(String condition,Map parameter) throws Exception{
	return getBeans(null,condition,parameter,-1,-1,false);
  }

  public static  ReviewInfoBean[] getBeans(String[] cols,String condition,Map parameter,
           int startNum,int endNum,boolean isShowFK) throws Exception{
        Connection conn = null;
        try {
                conn = ServiceManager.getSession().getConnection();
                return (ReviewInfoBean[])ServiceManager.getDataStore().retrieve(conn,ReviewInfoBean.class,ReviewInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,null);
        }catch(Exception e){
                throw e;
        }finally{
           if (conn != null)
              conn.close();
        }
  }

   public static  ReviewInfoBean[] getBeans(String[] cols,String condition,Map parameter,
          int startNum,int endNum,boolean isShowFK,String[] extendBOAttrs) throws Exception{
          Connection conn = null;
          try {
                  conn = ServiceManager.getSession().getConnection();
                  return (ReviewInfoBean[])ServiceManager.getDataStore().retrieve(conn,ReviewInfoBean.class,ReviewInfoBean.getObjectTypeStatic(),cols,condition,parameter,startNum,endNum,isShowFK,false,extendBOAttrs);
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
              return ServiceManager.getDataStore().retrieveCount(conn,ReviewInfoBean.getObjectTypeStatic(),condition,parameter,null);
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
                return ServiceManager.getDataStore().retrieveCount(conn,ReviewInfoBean.getObjectTypeStatic(),condition,parameter,extendBOAttrs);
        }catch(Exception e){
                throw e;
        }finally{
          if (conn != null)
              conn.close();
        }
   }

  public static void save( ReviewInfoBean aBean) throws Exception
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

   public static  void save( ReviewInfoBean[] aBeans) throws Exception{
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

   public static  void saveBatch( ReviewInfoBean[] aBeans) throws Exception{
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


  public static  ReviewInfoBean[] getBeansFromQueryBO(String soureBO,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              String sql = ServiceManager.getObjectTypeFactory().getInstance(soureBO).getMapingEnty();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (ReviewInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(ReviewInfoBean.class,ReviewInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }

     public static  ReviewInfoBean[] getBeansFromSql(String sql,Map parameter) throws Exception{
      Connection conn = null;
      ResultSet resultset = null;
      try {
              conn = ServiceManager.getSession().getConnection();
              resultset =ServiceManager.getDataStore().retrieve(conn,sql,parameter);
              return (ReviewInfoBean[])ServiceManager.getDataStore().crateDtaContainerFromResultSet(ReviewInfoBean.class,ReviewInfoBean.getObjectTypeStatic(),resultset,null,true);

      }catch(Exception e){
              throw e;
      }finally{
          if(resultset!=null)resultset.close();
          if (conn != null)
              conn.close();
      }
   }
    
   public static java.math.BigDecimal getNewId() throws Exception{
       return ServiceManager.getIdGenerator().getNewId(ReviewInfoBean.getObjectTypeStatic());
   }


   @SuppressWarnings("deprecation")
public static java.sql.Timestamp getSysDate() throws Exception{
       return ServiceManager.getIdGenerator().getSysDate(ReviewInfoBean.getObjectTypeStatic());
   }


   public static ReviewInfoBean wrap(DataContainerInterface source,Map colMatch,boolean canModify){
     try{
       return (ReviewInfoBean)DataContainerFactory.wrap(source,ReviewInfoBean.class,colMatch,canModify);
     }catch(Exception e){
       if(e.getCause()!=null)
         throw new RuntimeException(e.getCause());
       else
         throw new RuntimeException(e);
     }
   }
   public static ReviewInfoBean copy(DataContainerInterface source,Map colMatch,boolean canModify){
     try {
       ReviewInfoBean result = new ReviewInfoBean();
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

   public static ReviewInfoBean transfer(IReviewInfoValue value) {
   	if(value==null)
   		return null;
	try {
		if(value instanceof ReviewInfoBean){
			return (ReviewInfoBean)value;
		}
		ReviewInfoBean newBean = new ReviewInfoBean();

		DataContainerFactory.transfer(value ,newBean);
		return newBean;
	}catch (Exception ex) {
		if(ex.getCause()!=null)
			throw new RuntimeException(ex.getCause());
		else
			throw new RuntimeException(ex);
	}
   }

   public static ReviewInfoBean[] transfer(IReviewInfoValue[] value) {
   	if(value==null || value.length==0)
   		return null;

	try {
		if(value instanceof ReviewInfoBean[]){
			return (ReviewInfoBean[])value;
		}
		ReviewInfoBean[] newBeans = new ReviewInfoBean[value.length];
   		for(int i=0;i<newBeans.length;i++){
   			newBeans[i] = new ReviewInfoBean();
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
  public static void save(IReviewInfoValue aValue) throws Exception
  {
     save(transfer(aValue));
  }

   public static  void save( IReviewInfoValue[] aValues) throws Exception{
          save(transfer(aValues));
   }

   public static  void saveBatch( IReviewInfoValue[] aValues) throws Exception{
     saveBatch(transfer(aValues));
   }
}
