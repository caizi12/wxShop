package ngves.asiainfo.core.common.util;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.ware.service.interfaces.IWareDetailSrv;

import com.ai.appframe2.service.ServiceFactory;
/**
 *  礼品业务属性相关工具类
 * @author zhanghj
 *
 */
public class WareDescUtil {
	
	/**
	 *  根据礼品Id获取礼品支持的所有星级或品牌
	 * @param ware_id
	 * @return
	 * @throws Exception
	 */
	public static String[] getWareSupportStarLevel(long ware_id) throws Exception {
		IWareDetailSrv wareDetailSrv = (IWareDetailSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_WARE_DETAIL);
		return  wareDetailSrv.getWareSupportStarLevel(ware_id);
	}

}
