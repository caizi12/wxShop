/**
 * 
 */
package ngves.asiainfo.core.ware.util;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.util.StringUtil;

/**
 * 礼品状态转换的表格
 * 
 * @author asiainfo
 *
 */
public class WareStatusAccessMap {

	//加载礼品上下线的可到达状态
	
	private static Map<String,Boolean> accessMap = new HashMap<String,Boolean> ();
	static{
		//这些状态转换的可到达性参照《 中国移动统一积分系统五期项目礼品上下线规格调整需求功能规格说明书》图3.2.1.1-2状态迁移总图（改善后）
		
		//原状态       未上线0 上线1 下线2
		//目的状态  未上线0 上线1 下线2
		//操作类型  人工上线0 人工下线1 定时上线2 定时下线3 自动上线4 自动下线5
		
		//编码范围  原状态,目的状态,操作类型
		//例如 0,1,1 未上线到上线 通过人工上线时可达的
		
		//未上线-->上线    渠道：人工上线
		accessMap.put("0,1,0", new Boolean(true));
		//未上线-->上线    渠道：定时上线
		accessMap.put("0,1,2", new Boolean(true));
				
		//上线-->下线  渠道:自动下线
		accessMap.put("1,2,5", new Boolean(true));

		//上线-->下线  渠道:定时下线
		accessMap.put("1,2,3", new Boolean(true));

		//上线-->下线  渠道:人工下线
		accessMap.put("1,2,1", new Boolean(true));
		
		
		//上线可以继续上线，为了修改上线原因
		//上线-->上线  渠道:人工上线
		accessMap.put("1,1,0", new Boolean(true));
		//上线-->上线  渠道:定时上线
		accessMap.put("1,1,2", new Boolean(true));
		
		
		//下线-->上线  渠道:人工上线
		accessMap.put("2,1,0", new Boolean(true));
		
		//下线-->上线  渠道:定时上线
		accessMap.put("2,1,2", new Boolean(true));

		//下线-->上线  渠道:自动上线
		accessMap.put("2,1,4", new Boolean(true));
			
		//下线 --> 下线  渠道：人工下线
		accessMap.put("2,2,1", new Boolean(true));
		
		
		//下线 --> 下线  渠道：定时下线
		accessMap.put("2,2,3", new Boolean(true));
		
	}
	
	
	/**
	 * 根据礼品的原始状态和目的状态，判断状态转换之间是否可达
	 * @param originStatus 原始状态	
	 * @param distStatus	目的状态
	 * @param operType 操作类型
	 * @return   true:可以到达  false:不可到达
	 * @throws Exception
	 */
	public static boolean getAccessValue(String originStatus,String distStatus,String operType) throws Exception{
		
		boolean retValue =   false;
		String accessKey = null;

		if(!StringUtil.isBlank(operType) && !StringUtil.isBlank(originStatus) && !StringUtil.isBlank(distStatus)){
			//三个参数都不能为空，否则会直接返回false
			accessKey = originStatus+","+distStatus+","+operType;
			if(accessMap.containsKey(accessKey)){
				//如果存在，那么取出该数值
				Boolean isAccess  = accessMap.get(accessKey);
				retValue = isAccess.booleanValue();
			}
		}
		return retValue;
	}
	
	public static void main(String []args){
		try {
			WareStatusAccessMap.getAccessValue("0", "1", "0");
			WareStatusAccessMap.getAccessValue("2", "1", "0");
			WareStatusAccessMap.getAccessValue("2", "2", "1");
			WareStatusAccessMap.getAccessValue("2", "2", "2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
