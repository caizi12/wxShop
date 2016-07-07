package ngves.asiainfo.core.check.dao.interfaces;

import ngves.asiainfo.core.check.ivalues.IQBOExamineWareOffLineValue;

import java.util.Map;

/**
 * 考核礼品下线
 *  shenfl
 */
public interface IExamineWareOffLineDAO {

    /**
     * 取得考核下线礼品信息
     * @param conditon
     * @param parameter
     * @return
     * @throws Exception
     */
    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String conditon,Map<String,String> parameter)
            throws Exception;

    /**
     * 分页查询 考核下线礼品信息
     * @param conditon        查询条件
     * @param parameter       条件对应的参数
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String conditon,Map<String,String> parameter,int startIndex,int endIndex)
            throws Exception;


    /**
     * 取得当前考核礼品下线信息的记录数
     * @param conditon
     * @param parameter
     * @return
     * @throws Exception
     */
    public int  queryExamineWareOffLineInfoCount(String conditon,Map<String,String> parameter)
            throws Exception;


    /**
     * 上传文件前进行保存信息
     * @param value
     * @throws Exception
     */
    public void saveExamineWareOffLineInfo(IQBOExamineWareOffLineValue value) throws  Exception;
    
    public void deleteExamineWareOffLine(IQBOExamineWareOffLineValue value) throws Exception; 
}
