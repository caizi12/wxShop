package ngves.asiainfo.core.stat.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.stat.bo.QBOAllegeDetailQRYEngine;
import ngves.asiainfo.core.stat.dao.interfaces.IStatAllegeInfoDAO;
import ngves.asiainfo.core.stat.ivalues.IQBOAllegeDetailQRYValue;

public class StatAllegeInfoDAOImpl implements IStatAllegeInfoDAO {

    
    @SuppressWarnings("unchecked")
    public IQBOAllegeDetailQRYValue[] queryAllegeDetail(String condition, Map parameter)
            throws Exception {
        return QBOAllegeDetailQRYEngine.getBeans(condition, parameter);
    }
    
    @SuppressWarnings("unchecked")
    public int queryAllegeDetailCount(String condition, Map parameter) throws Exception {
        return QBOAllegeDetailQRYEngine.getBeansCount(condition, parameter);
    }

    @SuppressWarnings("unchecked")
    public IQBOAllegeDetailQRYValue[] queryAllegeDetail(String condition, Map parameter, int startIndex, int endIndex)
            throws Exception {
        return QBOAllegeDetailQRYEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
    }

}
