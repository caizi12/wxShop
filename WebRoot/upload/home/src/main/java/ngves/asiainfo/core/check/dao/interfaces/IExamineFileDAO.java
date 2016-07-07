package ngves.asiainfo.core.check.dao.interfaces;

import ngves.asiainfo.core.check.ivalues.IQBOExamineFileValue;



/**
 *  考核信息
 * @author chenzhd
 *
 */
public interface IExamineFileDAO {
    /**
     * 根据月份取出考核信息
     * @param month 月份
     * @return ICmProvinceInfoValue
     * @throws Exception
     */
    public int getExamineFileInfoCount(String queryTime) throws Exception ;
    
   /**
    * 月份查询结算单记录条�?
    * @param querytime 月份
    * @param startNum 记录�?始序�?
    * @param endNum 记录结束序号 
    */
   public IQBOExamineFileValue[] getExamineFile(String queryTime,int startNum, int endNum
			) throws Exception ;

    public void saveExamineFileInfo(IQBOExamineFileValue value)  throws Exception ;

    public void updateExamineFileInfo(IQBOExamineFileValue value ) throws Exception ;

     public void delExamineFileInfo(IQBOExamineFileValue value) throws Exception ;



}
