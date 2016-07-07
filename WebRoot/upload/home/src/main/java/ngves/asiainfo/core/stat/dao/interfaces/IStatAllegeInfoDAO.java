package ngves.asiainfo.core.stat.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.stat.ivalues.IQBOAllegeDetailQRYValue;


public interface IStatAllegeInfoDAO {

	  /**
	   * 客诉详单查询
	   * @param condition
	   * @param parameter
	   * @param startIndex
	   * @param endIndex
	   * @return
	   * @throws Exception
	   */
	   @SuppressWarnings("unchecked")
	    public IQBOAllegeDetailQRYValue[] queryAllegeDetail(String condition, Map parameter, int startIndex, int endIndex)
	            throws Exception;
    
    /**
     * 客诉详单查询的数据个数获取
     * @param condition
     * @param parameter
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public int queryAllegeDetailCount(String condition, Map parameter) throws Exception;
}
