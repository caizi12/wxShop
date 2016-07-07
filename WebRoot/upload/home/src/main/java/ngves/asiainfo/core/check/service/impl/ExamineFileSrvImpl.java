package ngves.asiainfo.core.check.service.impl;


import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.check.dao.interfaces.IExamineFileDAO;
import ngves.asiainfo.core.check.ivalues.IQBOExamineFileValue;
import ngves.asiainfo.core.check.service.interfaces.IExamineFileSrv;


import com.ai.appframe2.service.ServiceFactory;

public class ExamineFileSrvImpl implements IExamineFileSrv {

	public IQBOExamineFileValue[] getExamineFileInfo(String queryTime,
			int startNum, int endNum) throws Exception {
		IExamineFileDAO examineFile = (IExamineFileDAO) ServiceFactory
			.getService(CoreSrvContstant.SERVICE_CORE_CHECK_EXAMINE_DAO);
		IQBOExamineFileValue[] iefv = examineFile.getExamineFile(queryTime, startNum, endNum);

       /*
        * 增加合作商类型
        * 1. real_partner_examine       实物类礼品商
        * 2. co_partner_examine         合作类礼品商
        * 3. storage_partner_examine    仓储商
        * 4. deliver_partner_examine    配送商
        */

		return fillHTMLOperationField(iefv);
	}

    /**
     * 根据月份查询
      * @param queryTime
     * @return
     */
   public IQBOExamineFileValue[] getExamineFileInfoByMonth(String queryTime ) throws Exception {
       	IExamineFileDAO examineFile = (IExamineFileDAO) ServiceFactory
			.getService(CoreSrvContstant.SERVICE_CORE_CHECK_EXAMINE_DAO);
       IQBOExamineFileValue[] examineFileValues = examineFile.getExamineFile(queryTime, -1, -1);
       return examineFileValues;
   }

    /**
     * 保存
     * @param value
     * @throws Exception
     */
    public void saveExamineFileInfo(IQBOExamineFileValue value) throws Exception {
         IExamineFileDAO examineFile = (IExamineFileDAO) ServiceFactory
			.getService(CoreSrvContstant.SERVICE_CORE_CHECK_EXAMINE_DAO);
        examineFile.saveExamineFileInfo(value);
    }

    public void delExamineFileInfo(IQBOExamineFileValue value) throws Exception {

       IExamineFileDAO examineFile = (IExamineFileDAO) ServiceFactory
			.getService(CoreSrvContstant.SERVICE_CORE_CHECK_EXAMINE_DAO);

        examineFile.delExamineFileInfo(value);
    }

    /**
     * 保存 和更新
     * @param value
     * @throws Exception
     */
    public void updateExamineFileInfo(IQBOExamineFileValue value) throws Exception {
        IExamineFileDAO examineFile = (IExamineFileDAO) ServiceFactory
			.getService(CoreSrvContstant.SERVICE_CORE_CHECK_EXAMINE_DAO);
        examineFile.updateExamineFileInfo(value);
    }


    public int getExamineFileInfoCounnt(String queryTime) throws Exception {
		IExamineFileDAO examineFile = (IExamineFileDAO) ServiceFactory
        .getService(CoreSrvContstant.SERVICE_CORE_CHECK_EXAMINE_DAO);
       return examineFile.getExamineFileInfoCount(queryTime);
	}
	
	/**
	 * 向文件名字后面添加超链接操作
	 */
	private IQBOExamineFileValue[] fillHTMLOperationField(IQBOExamineFileValue[] groups){
		for(IQBOExamineFileValue group: groups){
			 StringBuffer sb = new StringBuffer();
		     sb.append(String.format("<a href='javascript:indexControl(\""+ group.getExamineFileName() + "\")'>"+group.getExamineFileName()+"</a>", group.getExamineFileName()));
			group.setExamineFileName(sb.toString());
        }
        return groups;
    }

    public static void main(String [] args) {
        String fileName = "real_partner_examine";

        System.out.println("real_partner_examine".equals(fileName));
    }
}
