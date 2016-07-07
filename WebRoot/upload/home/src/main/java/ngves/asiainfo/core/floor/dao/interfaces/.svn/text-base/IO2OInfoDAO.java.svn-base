package ngves.asiainfo.core.floor.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.floor.bo.O2OInfoBean;
import ngves.asiainfo.core.floor.ivalues.IO2OInfoValue;

public interface IO2OInfoDAO { 
	  
     /**
     * 根据O2O的产品id查询 O2OInfo信息
     * @param o2oId
     * @throws Exception 
     * @return O2OInfoBean
     */
      public O2OInfoBean queryO2OInfoById(String o2oId) throws Exception;
      /**
       * 根据O2O的产品名称，分页的其实行数  查询O2OInfo[]信息,用于前台分页查询
       * @param o2oName startNum  endNum
       * @throws Exception 
       * @return O2OInfoBean
       */
      public IO2OInfoValue[] queryO2OInfos(String  o2oName,int startNum,int endNum) throws Exception;
   
      /**
       * 删除O2OInfo信息
       * @param o2oInfobean
       * @throws Exception 
       * @return void
       */
      public void deleteO2OInfo(IO2OInfoValue o2oInfobean) throws Exception;
      

      /**
       * 删除O2OInfo信息
       * @param o2oId
       * @throws Exception 
       * @return void
       */
      public void deleteO2OInfo(String  o2oId) throws Exception;
     
      /**
       * 更新O2OInfo信息，保存和更新操作共用一个方法
       * @param o2oInfobean
       * @throws Exception 
       * @return void
       */
      public void saveO2OInfo(IO2OInfoValue o2oInfobean) throws Exception;
      
      /**
       * 更新O2OInfo信息，保存和更新操作共用一个方法
       * @param o2oInfobean
       * @throws Exception 
       * @return long  返回新增或者更新实体对应数据库的id值
       */
      public long saveO2OInfoByEntity(IO2OInfoValue o2oInfobean) throws Exception;
      /**
       * 根据conditon组装查询sql，匹配查询结果总数.,用于前台分页查询数据总数
       * @param 
       * @throws Exception 
       * @return int
       */
      public int queryO2OInfosCount(String conditon, Map<String, String> parameter) throws Exception;
      
      /**
       * 根据O2O是否首页展示   查询O2OInfo[]信息,用于web端数据展示
       * @param isShowFlag
       * @throws Exception 
       * @return O2OInfoBean
       */
      public IO2OInfoValue[] queryO2OInfoByShowFlag(String isShowFlag) throws Exception;
      
      /**
       * 根据O2O专区类型,并且在前台展示的O2O信息
       * @param type
       * @throws Exception 
       * @return IO2OInfoValue[]
       */
      public IO2OInfoValue[] queryO2OInfoByType(String type) throws Exception;
      
      
 }
