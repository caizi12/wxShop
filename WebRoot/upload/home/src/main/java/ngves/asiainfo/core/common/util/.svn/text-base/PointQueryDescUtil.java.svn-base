package ngves.asiainfo.core.common.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.util.JSONUtils;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.model.GrantResultListBean;
import ngves.asiainfo.core.common.model.PointGrantQueryBean;
import ngves.asiainfo.core.common.model.PointQueryInfoBean;
import ngves.asiainfo.core.common.model.PointTypeInfoBean;
import ngves.asiainfo.core.common.model.PointUseQueryBean;
import ngves.asiainfo.core.common.service.interfaces.IBaseInfoSynSrv;
import ngves.asiainfo.core.ware.WareParamConstant;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 
 * 用户积分明细查询工具类（WEB、WAP、APP调用）
 * @author luohuan
 * @date 2014-5-14
 *
 */
public class PointQueryDescUtil {

	

	/**
	 * 用户明细积分查询
	 * @param orgID 发起请求方标识(0001:积分平台 0004:WAP渠道 0006:手机客户端渠道)
	 * @param orgName 发起请求方名称
	 * @param mobileNum 客户手机号码
	 * @return
	 * @throws Exception
	 * 
	 * eg: 门户调用该方法为 
	 * PointQueryDescUtil.getPointQueryDesc(CommnConstant.INTER_ORG_WEB,CommnConstant.INTER_NAME_WEB,"13900000000");
	 */
	public static PointQueryInfoBean getPointQueryDesc(String orgID,String orgName,String mobileNum) throws Exception{
		IBaseInfoSynSrv baseInfoSynSrv = (IBaseInfoSynSrv) ServiceFactory.getService(
				CoreSrvContstant.SERVICE_CORE_SYS_BASE_SYN_SRV);

		return baseInfoSynSrv.getPointQueryDesc(orgID, orgName, mobileNum);
	}
	/**
	 * 获取积分信息
	 * 与旧版本【getPointQueryDesc】的区别：1、将原来JSP的处理逻辑放于sv处理，2、将最终展示的数据返回给前台
	 * @param orgID
	 * @param orgName
	 * @param mobileNum
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> getPointQueryDescForWeb(String orgID,String orgName,String mobileNum) throws Exception{
		Map<String,Object> retMap = new HashMap<String,Object>();
		IBaseInfoSynSrv baseInfoSynSrv = (IBaseInfoSynSrv) ServiceFactory.getService(
				CoreSrvContstant.SERVICE_CORE_SYS_BASE_SYN_SRV);
		PointQueryInfoBean pointQueryInfoBean=baseInfoSynSrv.getPointQueryDesc(orgID, orgName, mobileNum);
		
        if(null!=pointQueryInfoBean){ 
            PointTypeInfoBean[] pointTypeInfoBeans=pointQueryInfoBean.getPointTypeInfo();
        	if(null!=pointTypeInfoBeans&&pointTypeInfoBeans.length!=0){ 
        		
				//积分类型 只展示 消费积分和促销积分，为了方便展示 声明两list，把消费积分和促销积各存放list
        		List<PointTypeInfoBean> consumptionList  =new  ArrayList<PointTypeInfoBean>();
        		List<PointTypeInfoBean> promotionList  =new  ArrayList<PointTypeInfoBean>();
				for(PointTypeInfoBean poinBean : pointTypeInfoBeans){
            		if(WareParamConstant.PATA_CONSUME_POINT_NUM.equals(poinBean.getPointType().trim()) ||
            				WareParamConstant.PATA_CONSUME_POINT_NUM ==	poinBean.getPointType().trim()){
            			PointTypeInfoBean consumptionBean = new PointTypeInfoBean();
            			consumptionBean.setPointSum(poinBean.getPointSum());
            			consumptionBean.setPointType(WareParamConstant.PATA_CONSUME_POINT);
            			if("".equals(poinBean.getValidateTime())){
            				consumptionBean.setValidateTime("无");
						}else{
							consumptionBean.setValidateTime(poinBean.getValidateTime());
						}
            			consumptionList.add(consumptionBean);
            		}
					if(WareParamConstant.PATA_PROMOTION_POINT_NUM.equals(poinBean.getPointType().trim()) ||
							WareParamConstant.PATA_PROMOTION_POINT_NUM ==	poinBean.getPointType()){
						PointTypeInfoBean promotionBean = new PointTypeInfoBean();
						promotionBean.setPointSum(poinBean.getPointSum());
						promotionBean.setPointType(WareParamConstant.PATA_PROMOTION_POINT);
						if("".equals(poinBean.getValidateTime())){
							promotionBean.setValidateTime("无");
						}else{
							promotionBean.setValidateTime(poinBean.getValidateTime());
						}
						promotionList.add(promotionBean);
            		}
            	}
		       retMap.put("totalPoint", pointQueryInfoBean.getTotalPoint());//积分余额合计
		       retMap.put("userScore", pointQueryInfoBean.getUserScore());//用户可用积分
               retMap.put("consumptionList",(PointTypeInfoBean[])consumptionList.toArray(new PointTypeInfoBean[consumptionList.size()]) );//消费积分
               retMap.put("promotionList", (PointTypeInfoBean[])promotionList.toArray(new PointTypeInfoBean[promotionList.size()]));//促销回馈积分
               retMap.put("consumptSize", consumptionList.size());//消费积分
               retMap.put("promotSize", promotionList.size());//促销回馈积分
             }
        }
		return retMap;
	}
	

	/**
	 * 用户发放积分查询
	 * @param orgID 发起请求方标识(0001 积分平台;0004 WAP渠道;0006 手机客户端渠道)
	 * @param orgName 发起请求方名称
	 * @param mobileNum 用户手机号
	 * @param searchDateType 查询时间类型(00:一个月以内 01:三个月以内 02:半年以内 03:一年以内 )
	 * @return 
	 * @throws Exception
	 * eg:门户查询一个月的发放积分
	 * PointQueryDescUtil.getPointGrantQueryInfo(CommnConstant.INTER_ORG_WEB,CommnConstant.INTER_NAME_WEB,"13900000000","00");
	 */
	public static PointGrantQueryBean getPointGrantQueryInfo(String orgID,String orgName,String mobileNum,String searchDateType)
		throws Exception{
		IBaseInfoSynSrv baseInfoSynSrv = (IBaseInfoSynSrv) ServiceFactory.getService(
				CoreSrvContstant.SERVICE_CORE_SYS_BASE_SYN_SRV);
		return baseInfoSynSrv.getPointGrantQueryInfo(orgID, orgName, mobileNum, searchDateType);

	}
	
	
	/**
	 * 用户使用积分查询
	 * @param orgID 发起请求方标识(0001 积分平台;0004 WAP渠道;0006 手机客户端渠道)
	 * @param orgName 发起请求方名称
	 * @param mobileNum 用户手机号
	 * @param searchDateType 查询时间类型(00:一个月以内 01:三个月以内 02:半年以内 03:一年以内 )
	 * @return 
	 * @throws Exception
	 * eg:门户查询一个月的发放积分
	 * PointQueryDescUtil.getPointUseQueryInfo(CommnConstant.INTER_ORG_WEB,CommnConstant.INTER_NAME_WEB,"13900000000","01");
	 */
	public static PointUseQueryBean getPointUseQueryInfo(String orgID,String orgName,String mobileNum,String searchDateType)
		throws Exception{
		IBaseInfoSynSrv baseInfoSynSrv = (IBaseInfoSynSrv) ServiceFactory.getService(
				CoreSrvContstant.SERVICE_CORE_SYS_BASE_SYN_SRV);
		
		return baseInfoSynSrv.getPointUseQueryInfo(orgID, orgName, mobileNum, searchDateType);

	}
}
