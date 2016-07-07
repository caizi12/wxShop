package ngves.asiainfo.core.check.service.impl;

import ngves.asiainfo.core.check.dao.interfaces.IExamineWareOffLineDAO;
import ngves.asiainfo.core.check.ivalues.IQBOExamineWareOffLineValue;
import ngves.asiainfo.core.check.service.interfaces.IExamineWareOffLineSrv;
import ngves.asiainfo.util.StringUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * 考核礼品下线业务逻辑实现类
 *  shenfl
 */
public class ExamineWareOffLineSrvImpl implements IExamineWareOffLineSrv{

    private IExamineWareOffLineDAO examineWareOffLineDAO;


    public void setExamineWareOffLineDAO(IExamineWareOffLineDAO examineWareOffLineDAO) throws  Exception{
        this.examineWareOffLineDAO = examineWareOffLineDAO;
    }

    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String examineYear, String examineMonths, String ruleType, int startIndex,int endIndex)
            throws Exception {
        StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();

        //年份不为空，添加对应的条件
        if(!StringUtil.isBlank(examineYear)) {

            condition.append(" and " + IQBOExamineWareOffLineValue.S_ExamineYear
					+ "=:examineYear");
			parameter.put("examineYear", examineYear);
        }

        if(!"-1".equals(examineMonths))   {
             condition.append(" and " + IQBOExamineWareOffLineValue.S_ExmineMonths
					+ "=:examineMonths");
			parameter.put("examineMonths", examineMonths);
        }

        if(!"-1".equals(ruleType))   {
             condition.append(" and " + IQBOExamineWareOffLineValue.S_RuleType
					+ "=:ruleType");
			parameter.put("ruleType", ruleType);
        }

        // 取得考核下线的数据
        IQBOExamineWareOffLineValue[] values = this.examineWareOffLineDAO.queryExamineWareOffLineInfo(condition.toString(),parameter, startIndex, endIndex);
        IQBOExamineWareOffLineValue  value = null;

        for(int i = 0;i<values.length;i++) {
            value = values[i];
            if("1".equals(value.getExmineMonths())) {
                   value.setExmineMonths("一季度");
                   //判读规则类型
                   if("1".equals(value.getRuleType())){
                         value.setRuleType("兑换量过低");
                   } else {
                         value.setRuleType("投诉率过高");
                   }
            }  else if("2".equals(value.getExmineMonths())){
                   value.setExmineMonths("二季度");
                   //判读规则类型
                   if("1".equals(value.getRuleType())){
                         value.setRuleType("兑换量过低");
                   } else {
                         value.setRuleType("投诉率过高");
                   }
            } else if("3".equals(value.getExmineMonths())) {
                    value.setExmineMonths("三季度");
                   //判读规则类型
                   if("1".equals(value.getRuleType())){
                         value.setRuleType("兑换量过低");
                   } else {
                         value.setRuleType("投诉率过高");
                   }
            }  else if("4".equals(value.getExmineMonths())){
                    value.setExmineMonths("四季度");
                   //判读规则类型
                   if("1".equals(value.getRuleType())){
                         value.setRuleType("兑换量过低");
                   } else {
                         value.setRuleType("投诉率过高");
                   }
            }
            values[i] = value;
        }
        return fillHTMLOperationField(values) ;

    }
    
    /**
	 * 向文件名字后面添加超链接操作
	 */
	private IQBOExamineWareOffLineValue[] fillHTMLOperationField(IQBOExamineWareOffLineValue[] groups){
		for(IQBOExamineWareOffLineValue group: groups){
			 StringBuffer sb = new StringBuffer();
		     sb.append(String.format("<a href='javascript:indexControl(\""+ group.getFileName() + "\")'>"+group.getFileName()+"</a>", group.getFileName()));
			group.setFileName(sb.toString());
        }
        return groups;
    }

    public int queryExamineWareOffLineInfoCount(String examineYear, String examineMonths, String ruleType)
            throws Exception {

        StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String, String> parameter = new HashMap<String, String>();

        //年份不为空，添加对应的条件
        if(!StringUtil.isBlank(examineYear)) {

            condition.append(" and " + IQBOExamineWareOffLineValue.S_ExamineYear
					+ "=:examineYear");
			parameter.put("examineYear", examineYear);
        }

        if(!"-1".equals(examineMonths))   {
             condition.append(" and " + IQBOExamineWareOffLineValue.S_ExmineMonths
					+ "=:examineMonths");
			parameter.put("examineMonths", examineMonths);
        }

        if(!"-1".equals(ruleType))   {
             condition.append(" and " + IQBOExamineWareOffLineValue.S_RuleType
					+ "=:ruleType");
			parameter.put("ruleType", ruleType);
        }

        return this.examineWareOffLineDAO.queryExamineWareOffLineInfoCount(condition.toString(),parameter);
    }


    /**
     * 上传文件保存数据
     * @param value
     * @throws Exception
     */
    public void saveExamineWareOffLineInfo(IQBOExamineWareOffLineValue value) throws  Exception{

            examineWareOffLineDAO.saveExamineWareOffLineInfo(value);
    }
    
    /**
     * 查询考核礼品下线的信息  
     * @param examineYear  当前年
     * @param thisReason   当前年对应季度 
     * @return
     * @throws Exception
     */
    public IQBOExamineWareOffLineValue[] queryExamineWareOffLineInfo(String examineYear,String thisReason,String fileName) throws Exception {
        
        // 存放当前年和当前年对应的季度 
        Map<String,String> parameter = new HashMap<String,String>();
        StringBuffer condition = new StringBuffer("1=1");
        
        //年份不为空，添加对应的条件
        if(!StringUtil.isBlank(examineYear)) {

            condition.append(" and " + IQBOExamineWareOffLineValue.S_ExamineYear
                    + "=:examineYear");
            parameter.put("examineYear", examineYear);
        }

        if(!"-1".equals(thisReason))   {
             condition.append(" and " + IQBOExamineWareOffLineValue.S_ExmineMonths
                    + "=:examineMonths");
            parameter.put("examineMonths", thisReason);
        }
        
        if(!"-1".equals(fileName))   {
            condition.append(" and " + IQBOExamineWareOffLineValue.S_FileName
                   + "=:fileName");
           parameter.put("fileName", fileName);
       }
      
        return this.examineWareOffLineDAO.queryExamineWareOffLineInfo(condition.toString(), parameter);
    }
    
    
    
    /**
     * 删除当前前对应的季度信息  
     */
    public void deleteExamineWareOffLine(IQBOExamineWareOffLineValue[] value) throws Exception {
        
        for(IQBOExamineWareOffLineValue bean:value) {
            // 执行删除操作 
            this.examineWareOffLineDAO.deleteExamineWareOffLine(bean);
        }
    }
}
