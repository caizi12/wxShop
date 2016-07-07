package ngves.asiainfo.core.ware.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.common.util.DBCnnUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WareCommonUtil {
	
	private static Log log = LogFactory.getLog(WareCommonUtil.class);
	 /**
     * 将多个数组合并成为一个数组
     * @param arrs 对象数据
     * @return
     */
    public static Object[] mergeArrays(Object[]... arrs) {
    	//参数不能为空
		if (arrs == null || arrs.length == 0) {
			return new String[0];
		}

		int nSize = 0;
		//记录所有数据总和的长度
		for (Object[] _arr : arrs) {
			if (_arr == null) {
				continue;
			}
			nSize += _arr.length;
		}

		//长度为0
		if (nSize == 0) {
			return new Object[0];
		}

		//新建一个数组，长度为整个数组的总长度
		Object[] newArr = new Object[nSize];
		int _size = 0, _destPos = 0;

		for (Object[] _arr : arrs) {
			//数组为空，直接跳过
			if (_arr == null) {
				continue;
			}

			_size = _arr.length;
			//该数组长度为0 ，直接跳过
			if (_size == 0) {
				continue;
			}

			System.arraycopy(_arr, 0, newArr, _destPos, _size);
			_destPos += _size;
		}

		return newArr;
	}
    
    
    /**
     * 根据Code，获取对应的编码
     * @param codeStr  用户传给需要转码的字符串 
     * @param tableName 转码时的表名称
     * @param codeColumn 转码code对应的字段
     * @param viewNameColumn 转码viewName对应的字段
     * @param codeSplitStr 用户转码字符串的分割字符
     * @param viewNameSplitStr 用户转码后展示给用户时，各个编码之间用的分割字符
     * @return
     * @throws Exception 
     */
    public static String getViewNameByCode(String codeStr,String tableName,String codeColumn,String viewNameColumn,String codeSplitStr,String viewNameSplitStr,String condition) throws Exception{
		//1、先将需要转码的字符串（codeStr）利用编码的分割字符进行分割，形成SQL查询需要的'A','B','C','D'
    	StringBuffer viewNameBuffer = new StringBuffer();
    	StringBuffer codeNameBuffer = new StringBuffer();
    	if(StringUtil.isBlank(codeStr)){
    		return "";
    	}
    	//参数不合法
    	if(StringUtil.isBlank(tableName)||StringUtil.isBlank(codeColumn)||StringUtil.isBlank(viewNameColumn)){
    		log.error("invild parameters");
    		throw new Exception("invild parameters.please check table and column names.");
    	}
    	String [] _codeArrs = codeStr.split(codeSplitStr);
    	for(int i=0;i<_codeArrs.length;i++){
    		//Q1 、这个逗号用常量替换吗？
    		//A1 这个逗号是oracle默认的分隔符，暂不需替换
    		if(StringUtil.isNotBlank(_codeArrs[i])){
	    		if(i>0){
	    			codeNameBuffer.append(",");
	    		}
	    		codeNameBuffer.append("'"+_codeArrs[i]+"'");
    		}
    	}
    	
    	//2、拼接查询需要的SQL
    	//拼接完成的结果例子： select ware_name,ware_code from ware_info where ware_code in('A','B','C');
    	StringBuffer sqlBuffer = new StringBuffer();
    	sqlBuffer.append(" select "+viewNameColumn +"," +codeColumn);
    	sqlBuffer.append(" from " + tableName);
    	sqlBuffer.append(" where " +codeColumn+ " in ("+codeNameBuffer.toString() +")");
    	if(!StringUtil.isBlank(condition)){
    		sqlBuffer.append(" and ").append(condition);
    	}
    	
    	Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		//用来保存查询结果的Map
		Map<String,String> paraMap =  new HashMap<String,String>();
		
		try {
			conn = DBCnnUtil.getDBConnection();
			ps = conn.prepareStatement(sqlBuffer.toString());
			
			rs = ps.executeQuery();
			while (rs.next()) {
				//将这些数据加载进map
				paraMap.put(rs.getString(codeColumn),rs.getString(viewNameColumn));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBCnnUtil.closeDBConnetion(rs,ps,conn);
		}
		//3、将code转成需要的编码
		for(int i = 0;i < _codeArrs.length; i++){
			//通过code ，去Map中查询出viewName
			if(StringUtil.isNotBlank(_codeArrs[i])){
				if(i>0){
					viewNameBuffer.append(viewNameSplitStr);
				}
				viewNameBuffer.append(paraMap.get(_codeArrs[i]));
			}
		}
		
		return viewNameBuffer.toString();
		
    }
    
    
    public static boolean compareArrayStrSame(String firstArray,String secondArray){
    	boolean isSame = true;
    	//对于CMG0001,CMG0002,CMG0003 和 CMG0003,CMG0002,CMG0001 应该是一样的。
    	//字符串A 和字符串B 一定都是非空
    	//两个字符串相等
    	//isSame = true;
    	if(firstArray.length() != secondArray.length()){
    		//长度不一样，肯定不相等
    		isSame = false;
    	}else{
    		//将字符串进行','分割
    		String [] _firstArray = firstArray.split(",");
    		for(int i=0;i<_firstArray.length;i++){
    			if(!secondArray.contains(_firstArray[i])){
    				isSame = false;
    				break;
    			}
    		}
    		String [] _secondArray = secondArray.split(",");
    		for(int i=0;i<_secondArray.length;i++){
    			if(!firstArray.contains(_secondArray[i])){
    				isSame = false;
    				break;
    			}
    		}
    	}
    	
    	
    	return isSame;
    }
   
}
