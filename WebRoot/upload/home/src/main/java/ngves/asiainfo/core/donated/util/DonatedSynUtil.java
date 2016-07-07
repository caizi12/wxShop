package ngves.asiainfo.core.donated.util;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.donated.DonatedConstant;
import ngves.asiainfo.core.donated.exception.MgtDonatedException;
import ngves.asiainfo.core.donated.ivalues.IDonatedActivityValue;
import ngves.asiainfo.core.donated.service.interfaces.IDonatedActivitySrv;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 积分捐赠活动中,同步HP报文的公共类
 * @author liuyq7@asiainfo-linkage.com
 *
 */
public final class DonatedSynUtil {

	/**
	 * 根据捐赠活动的ID,将该捐赠活动同步给HP
	 * @param donatedActivityId
	 * @return HP返回码
	 * @throws Exception
	 */
	public String synDonatedInfoToHp(long donatedActivityId)throws Exception{
		//1、利用捐赠活动ID查询出来捐赠活动的基本信息
		
		//2、利用捐赠活动ID，查询出来绑定的捐赠对象信息
		
		//3、利用捐赠活动ID，查询出来绑定的捐赠礼品信息
		
		//4、利用捐赠活动ID，
		
		
		return "";
	}
	
	/**
	 * 根据捐赠活动ID和捐赠活动信息，判断是否需要将捐赠信息同步给HP
	 * <p>判断依据：根据捐赠活动的页面信息和数据库中的信息来判断</p>
	 * <pre>该方法判断条件中涉及到比较如下内容
	 * <li>捐赠活动的活动状态(已经发布)</li>
	 * <li>捐赠活动的基本信息(捐赠名称/活动开始时间和结束时间/捐赠配送类型 )</li>
	 * </pre>
	 * @param donatedActivityId 捐赠活动ID 
	 * @param value  捐赠活动基本信息(来自页面)
	 * @return
	 */
	public boolean isNeedSynToHp(long donatedActivityId,IDonatedActivityValue value) throws Exception{
		boolean isNeed = false;
		
		//1、根据ID获得捐赠活动的基本信息
		IDonatedActivitySrv doantedActivityInfoSrv = (IDonatedActivitySrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_DONATED_ACTIVITY_SRV);
		IDonatedActivityValue dbValue = doantedActivityInfoSrv.getDonatedActivityById(String.valueOf(donatedActivityId));
		if(null == dbValue){
			//捐赠活动不存在，那么抛出MgtDonatedException
			throw new MgtDonatedException("the donated activity whose id is "+donatedActivityId+" is not exist. the value is null.");
		}
		//2、判断捐赠活动的状态，该活动是否处于发布状态
		
		//如果是发布状态，那么满足进行同步的最基本要求
		if(dbValue.getStatus() == DonatedConstant.DONATED_ACTIVITY_STATUS_PUBLISH){
			
			//3、比较捐赠活动的基本内容，查看是否需要进行同步
			
			// QA 1: 如何才能考虑到捐赠活动中对象的配送信息？ 不需要考虑，因为对象是单独管理的。
			
			//如果包含， 捐赠名称，活动开始时间和结束时间，捐赠配送类型 
			
			//捐赠活动中发布状态时，被绑定的捐赠对象不能进行修改（除捐赠对象描述）
			
			if(value.getDonatedName().equals(dbValue.getDonatedName())
					||value.getBeginTime().equals(dbValue.getBeginTime())
					||value.getEndTime().equals(dbValue.getEndTime())
					||value.getDiliverType().equals(dbValue.getDiliverType())){
				isNeed = true;
			}
		}else{
			//当前活动没有发布，任何操作都不涉及到与HP通信
			isNeed = false;
		}
		//4、返回
		return isNeed;
	}
	/**
	 * 根据捐赠活动ID，判断本次操作是否需要与HP进行通信
	 * <p>该函数只根据捐赠活动的活动状态来判断，即，发布状态：需要同步;其他状态：不需要进行同步</p>
	 * @param donatedActivityId 捐赠活动ID
	 * @return true 需要同步给HP;false 不需要同步给HP
	 * @throws Exception
	 */
	public boolean isNeedSynToHp(long donatedActivityId) throws Exception{
		boolean isNeed = false;

		//1、根据捐赠活动ID获得捐赠活动信息
		//1、根据ID获得捐赠活动的基本信息
		IDonatedActivitySrv doantedActivityInfoSrv = (IDonatedActivitySrv)ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_DONATED_ACTIVITY_SRV);
		IDonatedActivityValue dbValue = doantedActivityInfoSrv.getDonatedActivityById(String.valueOf(donatedActivityId));
		if(null == dbValue){
			//捐赠活动不存在，那么抛出MgtDonatedException
			throw new MgtDonatedException("the donated activity whose id is "+donatedActivityId+" is not exist. the value is null.");
		}
		//2、如果捐赠活动的状态为已发布，那么需要进行同步
		if(dbValue.getStatus() == DonatedConstant.DONATED_ACTIVITY_STATUS_PUBLISH){
			isNeed = true;
		}else{
			//当前活动没有发布，任何操作都不涉及到与HP通信
			isNeed = false;
		}
		return isNeed;
	}
	
}
