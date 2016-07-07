package ngves.asiainfo.core.check.service.interfaces;

import ngves.asiainfo.core.check.dao.interfaces.IExamineWareOffLineDAO;
import ngves.asiainfo.core.check.ivalues.IQBOExamineWareOffLineValue;

/**
 * 考核礼品下线业务逻辑处理
 */
public interface IExamineWareOffLineSrv {

    public void setExamineWareOffLineDAO(IExamineWareOffLineDAO examineWareOffLineDAO)
            throws  Exception;
    /**
     * 考核礼品下线记录
     * @param examineYear
     * @param examineMonths
     * @param ruleType
     * @return
     * @throws Exception
     */
    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String examineYear,String examineMonths,String ruleType,int startIndex,int endIndex)
            throws Exception;


    /**
     * 考核礼品下线记录数
     * @param examineYear
     * @param examineMonths
     * @param ruleType
     * @return
     * @throws Exception
     */
    public int   queryExamineWareOffLineInfoCount(String examineYear,String examineMonths,String ruleType )
           throws Exception;

    public void saveExamineWareOffLineInfo(IQBOExamineWareOffLineValue value) throws  Exception;
    
   
    /**
     * 查询考核礼品下线的信息  
     * @param examineYear  当前年
     * @param thisReason   当前年对应季度 
     * @return
     * @throws Exception
     */
    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String examineYear,String thisReason,String fileName) throws Exception;
    
    
    
    public void deleteExamineWareOffLine(IQBOExamineWareOffLineValue[] value) throws Exception; 
}
