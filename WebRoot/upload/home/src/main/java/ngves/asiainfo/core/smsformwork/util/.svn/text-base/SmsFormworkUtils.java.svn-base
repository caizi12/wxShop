package ngves.asiainfo.core.smsformwork.util;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.util.StringUtil;

import com.ai.secframe.bo.orgmodel.SysStaffEngine;
import com.ai.secframe.ivalues.orgmodel.ISysOperatorValue;

/**   
 * @author Fsr   
 * @version 1.0
 * 创建时间：2013-12-4 下午03:46:46  
 * 类说明 
 */
public class SmsFormworkUtils {
	
	/**
	 * 根据传入的操作人编号，返回相应的操作人名称
	 * @param operCode
	 * @return
	 */
	public static String operCodeToName(String operCode){
		if(!StringUtil.isBlank(operCode)){
		    if(!"SYSTEM".equalsIgnoreCase(operCode)){
		    	StringBuffer sqlBuf = new StringBuffer();
		    	sqlBuf.append("SELECT s.STAFF_NAME FROM SYS_OPERATOR O ,SYS_STAFF S WHERE O.STAFF_ID = S.STAFF_ID AND O.CODE = :").append(ISysOperatorValue.S_Code);
		    	Map<String,String> map = new HashMap<String,String>();
		    	map.put(ISysOperatorValue.S_Code,operCode);
		    	try {
		    		return SysStaffEngine.getBeansFromSql(sqlBuf.toString(), map)[0].getStaffName();//显示操作人名称
				} catch (Exception e) {
					//如果出错，显示工号
				}	
		    }else{
		    	return "系统初始化";
		    }
	    }
		return operCode;
	}
	
	/**
	 * 去除查询条件中的下划线
	 * @param condition
	 * @return
	 */
	public static String delUnderline(String condition){
		if(!StringUtil.isBlank(condition)){
			condition = condition.replaceAll("\\_", "\\\\_");
	    }
		return condition;
	}
	
	/**
	 * 校验接口中为String类型字段的，是否存在“%、&、<” 存在返回false,否则返回true
	 * @param condition
	 * @return
	 */
	public static boolean checkInterfaceString(String condition){
		boolean flag = true;
		if(!StringUtil.isBlank(condition)){
			if(condition.indexOf("%")>-1 || condition.indexOf("&")>-1 || condition.indexOf("<")>-1){
				flag = false;
			}
	    }
		return flag;
	}

}
