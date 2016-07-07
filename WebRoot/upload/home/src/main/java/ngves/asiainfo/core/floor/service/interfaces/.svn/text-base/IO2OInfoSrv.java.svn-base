package ngves.asiainfo.core.floor.service.interfaces;

import ngves.asiainfo.core.floor.bo.O2OInfoBean;
import ngves.asiainfo.core.floor.dao.interfaces.IO2OInfoDAO;
import ngves.asiainfo.core.floor.dao.interfaces.IO2OWareRltDAO;
import ngves.asiainfo.core.floor.ivalues.IO2OInfoValue;
import ngves.asiainfo.core.floor.ivalues.IO2OWareRltValue;

public interface IO2OInfoSrv {
	
	 /**
	  * setO2oInfoDao :用于框架srv层加载dao实例。
	  * 如果没有这个setO2oInfoDao接口方法，会出现服务未定义错误
	  * 通过这种方式，在srv层中直接注入dao层实例。减少srv层在使用dao层引用时候每次通过getService()去获取。
	  * @param infoDao
	  * @throws Exception    
	  */
	 public void setO2oInfoDao(IO2OInfoDAO o2oInfoDao) throws Exception;
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
      public IO2OInfoValue[] queryO2OInfos(String  o2oInfoName,int startNum,int endNum) throws Exception;
   
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
       * @param o2oInfoName
       * @throws Exception 
       * @return int
       */
      public int queryO2OInfosCount(String o2oInfoName) throws Exception;
      
      /**
       * 根据O2O是否首页展示   查询O2OInfo[]信息,用于web端数据展示
       * @param isShowFlag
       * @throws Exception 
       * @return O2OInfoBean
       */
      public IO2OInfoValue[] queryO2OInfoByShowFlag(String isShowFlag) throws Exception;
      /**
       * 根据O2O专区类型,并且在前台展示的信息 用于web端数据展示
       * @param type
       * @throws Exception 
       * @return IO2OInfoValue[]
       */
      public IO2OInfoValue[] queryO2OInfoByType(String type) throws Exception;
      
      //o2o和礼品关系表操方法,注入IO2OWareRltDAO
       public void setO2oWareRltDao(IO2OWareRltDAO wareRltDao) throws Exception;
       /**
        * 根据O2O专区ID，查询关系表对象数组信息
        * @param type
        * @throws Exception 
        * @return IO2OWareRltValue[]
        */
       public IO2OWareRltValue[] queryO2OWareRltById(String o2oId) throws Exception;
       /**
        * 保存O2O与礼品关系
        * @param type
        * @throws Exception 
        * @return 
        */
       public void saveO2OWareRlt(IO2OWareRltValue o2oWareRltValue) throws Exception;
       /**
        * 根据关系表对象 ，删除操作
        * @param type
        * @throws Exception 
        */
       public void deleteO2OWareRlt(IO2OWareRltValue o2oWareRltValue) throws Exception;
       /**
        * 根据O2O专区ID，删除关系表中数据
        * @param type
        * @throws Exception 
        */
	   public void deleteO2OWareRltByO2OId(String o2oId) throws Exception;
}
