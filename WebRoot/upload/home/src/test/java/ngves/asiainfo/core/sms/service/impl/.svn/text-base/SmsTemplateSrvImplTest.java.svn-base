package ngves.asiainfo.core.sms.service.impl;
import ngves.asiainfo.core.sms.SmsConstant;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;
import ngves.asiainfo.core.sms.service.interfaces.ISmsTemplateSrv;

import org.junit.Before;
import org.junit.Test;

import com.ai.appframe2.service.ServiceFactory;

public class SmsTemplateSrvImplTest {

	private ISmsTemplateSrv SmsTempLateService;
	private String smsTemplateTitle = "";
	private String smsTemplateContent= "";
	private String smsStatus= "-1";
	private String sendType = "-1";
	private String proCode= "00";
	private int startIndex = -1;
	private int endIndex = -1;


	@Before
	public void init() {
		System.out.println("start");
		SmsTempLateService = (ISmsTemplateSrv) ServiceFactory
				.getService(SmsConstant.SMS_INFO_SMSTEMPLATESRV);
	}

	@Test
	public void testCountMarketingSmsList() {
		
		try {
			int num = SmsTempLateService.countMarketingSmsList(smsTemplateTitle, smsTemplateContent, smsStatus,sendType, proCode);
		    System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryMarketingSmsList() {
		try {
			ISmsTemplateValue[] beans = SmsTempLateService.queryMarketingSmsList(smsTemplateTitle, smsTemplateContent, smsStatus, sendType,proCode, startIndex, endIndex);
			System.out.println(beans[0].getSendType()+"----"+beans[0].getNoCount()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    // 初审
	@Test
	public void testQueryFirstExaminCount() {
		try {
			int num = SmsTempLateService.queryFirstExaminCount(smsTemplateTitle, smsTemplateContent, smsStatus,
					"0");
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	@Test
	public void testQueryFirstExaminList() {
		try {
			ISmsTemplateValue[] beans = SmsTempLateService.queryFirstExaminList(smsTemplateTitle, smsTemplateContent,
					smsStatus, sendType, startIndex, endIndex);
			System.out.println(beans[0].getSendType() + "----" + beans[0].getNoCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**复审
	 * 
	 */
	@Test
	public void testQueryMarketingSmsListOfReview() {
		try {
			ISmsTemplateValue[] beans = SmsTempLateService.queryMarketingSmsListOfReview(smsTemplateTitle, smsTemplateContent, smsStatus, sendType, startIndex, endIndex);
			System.out.println(beans[0].getSendType() + "----" + beans[0].getNoCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void countMarketingSmsListOfReView() {
		try {
			int num = SmsTempLateService.countMarketingSmsListOfReView(smsTemplateTitle, smsTemplateContent, smsStatus,
					"0");
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
