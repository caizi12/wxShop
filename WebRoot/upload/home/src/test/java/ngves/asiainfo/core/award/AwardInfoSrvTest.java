package ngves.asiainfo.core.award;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.award.service.interfaces.IAwardInfoSrv;
import ngves.asiainfo.util.DateTimeUtil;

import org.junit.Before;
import org.junit.Test;

import com.ai.appframe2.common.SessionManager;
import com.ai.appframe2.privilege.UserInfoInterface;
import com.ai.appframe2.service.ServiceFactory;
import com.ai.secframe.bean.sysmgr.UserInfoDefaultImpl;

public class AwardInfoSrvTest {
	
	private IAwardInfoSrv awardInfoSrv = (IAwardInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_AWARD_INFO);
	
	IAwardInfoValue value = null;
	IAwardInfoValue oldvalue = null;
	
	@Before
	public void initValue()throws Exception{
		value = awardInfoSrv.getAwardInfoById("100000000002201");
		oldvalue = awardInfoSrv.getAwardInfoById("100000000002201");
		
	}
	/**
	 * 测试不同情况下修改活动信息
	 * @throws Exception
	 */
	@Test
	public void modifyAwardInfoTest() throws Exception{
		value.setAwardName("单元测试修改");
		value.setAwardDesc("<p>单元测试修改活动描述545dsassyaodfhaso</p>");
		value.setCreateDate(new Timestamp(new Date().getTime()));
		
		awardInfoSrv.modifyAwardInfo(value ,Long.parseLong("100000001081"),"0",Long.parseLong("100000001081"));
		
		IAwardInfoValue newValue =  awardInfoSrv.getAwardInfoById("100000000002201");
		
	
		assertEquals("单元测试修改",newValue.getAwardName());
		assertEquals("单元测试修改活动描述545",newValue.getAwardDesc());
		assertEquals(oldvalue.getCreateDate(), newValue.getCreateDate());
		
	}
	@Test
	public void copyAward() throws Exception{
		UserInfoInterface user = new UserInfoDefaultImpl();
		user.setID(Long.parseLong("11111111111111"));
		SessionManager.setUser(user);
		String copyawardId = "100000000001410";
		String awardId =awardInfoSrv.copyAwardByID(copyawardId);
		IAwardInfoValue oldValue = awardInfoSrv.getAwardInfoById(copyawardId);
		IAwardInfoValue value = awardInfoSrv.getAwardInfoById(awardId);
		 Timestamp starttime = DateTimeUtil.stringToTimestamp(DateTimeUtil.dateAdd(1,
		    		DateTimeUtil.getNowTimeStamp().toString(),CommnConstant.DATETIME_JAVA_FORMAT),
		    		CommnConstant.DATETIME_JAVA_FORMAT);
		 Timestamp endtime = DateTimeUtil.stringToTimestamp(DateTimeUtil.dateAdd(7,
		    		DateTimeUtil.getNowTimeStamp().toString(),CommnConstant.DATETIME_JAVA_FORMAT),
		    		CommnConstant.DATETIME_JAVA_FORMAT);
		 Timestamp stopgettime = DateTimeUtil.stringToTimestamp(DateTimeUtil.dateAdd(7,
		    		DateTimeUtil.getNowTimeStamp().toString(),CommnConstant.DATETIME_JAVA_FORMAT),
		    		CommnConstant.DATETIME_JAVA_FORMAT);
		Date d = DateTimeUtil.parse( DateTimeUtil.format(stopgettime, "yyyy-MM-dd 23:59:59"),
		    		"yyyy-MM-dd HH:mm:ss");
		Timestamp stopTime = new Timestamp(d.getTime());   
		System.out.println("startTime:"+starttime+"endTime:"+endtime+"stopTime:"+stopTime);
//		assertEquals(starttime, value.getStartTime());
//		assertEquals(endtime, value.getEndTime());
//		assertEquals(stopTime, value.getStopGetTime());
		assertEquals(oldValue.getAwardName(), value.getAwardName());
		assertEquals(oldValue.getAwardDesc().trim(), value.getAwardDesc().trim());
		assertEquals(oldValue.getBaseWareId(), value.getBaseWareId());
		assertEquals(oldValue.getBaseIntegral(), value.getBaseIntegral());
		assertEquals(oldValue.getMainPic(), value.getMainPic());
		assertEquals("11111111111111", value.getRecordStaff());
	}
	@Test
	public void queryAwardInfoTest()throws Exception{
		try {
			IAwardInfoValue[] value = awardInfoSrv.queryAwardInfo("",1,5);
			System.out.println(value.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
