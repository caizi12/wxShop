package ngves.asiainfo.core.check.service.interfaces;

import ngves.asiainfo.core.check.ivalues.IQBOExamineFileValue;


public interface IExamineFileSrv {
	
	/**
     * @param
     * @return ICmProvinceInfoValue
     * @throws Exception
     */
    public int getExamineFileInfoCounnt(String queryTime) throws Exception;
		
	 /**
     * @param
     * @param startNum
     * @param endNum 记录结束序号 
     */
    public IQBOExamineFileValue[] getExamineFileInfo(String queryTime,int startNum, int endNum) throws Exception ;

    public void saveExamineFileInfo(IQBOExamineFileValue value) throws Exception ;

    public void updateExamineFileInfo(IQBOExamineFileValue value) throws Exception ;

    public void delExamineFileInfo(IQBOExamineFileValue value ) throws Exception;

    public IQBOExamineFileValue[] getExamineFileInfoByMonth(String queryTime ) throws Exception ;
}
