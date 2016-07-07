package ngves.asiainfo.core.check.dao.impl;


import ngves.asiainfo.core.check.bo.QBOExamineWareOffLineEngine;
import ngves.asiainfo.core.check.dao.interfaces.IExamineWareOffLineDAO;
import ngves.asiainfo.core.check.ivalues.IQBOExamineWareOffLineValue;

import java.util.Map;

/**
 *  DAO实现类
 */
public class ExamineWareOffLineDAOImpl implements IExamineWareOffLineDAO{

    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String conditon, Map<String, String> parameter) throws Exception {
        return  QBOExamineWareOffLineEngine.getBeans(conditon,parameter);
    }

    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String conditon, Map<String, String> parameter, int startIndex, int endIndex) throws Exception {
        return QBOExamineWareOffLineEngine.getBeans(null,conditon,parameter,startIndex,endIndex,false);
    }

    public int queryExamineWareOffLineInfoCount(String conditon, Map<String, String> parameter) throws Exception {
        return QBOExamineWareOffLineEngine.getBeansCount(conditon,parameter);
    }

    /**
     * 上传文件进行保存操作
     * @param value
     * @throws Exception
     */
    public void saveExamineWareOffLineInfo(IQBOExamineWareOffLineValue value) throws  Exception{

        if(value.isNew()) {
            value.setExamineWareOfflineId(QBOExamineWareOffLineEngine.getNewId().longValue());
        }
        QBOExamineWareOffLineEngine.save(value);
    }
    
    public void deleteExamineWareOffLine(IQBOExamineWareOffLineValue value) throws Exception {
        
        value.delete();
        QBOExamineWareOffLineEngine.save(value);
    }
}
