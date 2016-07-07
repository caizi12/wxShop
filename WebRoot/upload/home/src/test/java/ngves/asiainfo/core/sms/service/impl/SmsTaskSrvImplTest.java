package ngves.asiainfo.core.sms.service.impl;

import static org.junit.Assert.fail;
import ngves.asiainfo.core.sms.SmsConstant;
import ngves.asiainfo.core.sms.service.interfaces.ISmsTaskSrv;

import org.junit.Test;

import com.ai.appframe2.service.ServiceFactory;

public class SmsTaskSrvImplTest {
	
	private final ISmsTaskSrv service = (ISmsTaskSrv) ServiceFactory.getService(SmsConstant.SMS_INFO_SMSTASKSRV);
	private String role = "1";
	private String provCode = "00";
	private String title ="";
	private String context ="";
	private String status ="";
	private String smsTemStatus ="";
	private String sendType ="0";
	private int startIndex =-1;
	private int endIndex=-1;

	@Test
	public void testGetQBOSmsTaskAndTemplateCount() {
		try {
			service.getQBOSmsTaskAndTemplateCount(role, provCode, title, context, status, smsTemStatus, sendType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetQBOSmsTaskAndTemplateValues() {
		try {
			service.getQBOSmsTaskAndTemplateValues(role, provCode, title, context, status, smsTemStatus, sendType, startIndex, endIndex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	

	@Test
	public void testExecuteSmsTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSmsTask() {
		fail("Not yet implemented");
	}


}
