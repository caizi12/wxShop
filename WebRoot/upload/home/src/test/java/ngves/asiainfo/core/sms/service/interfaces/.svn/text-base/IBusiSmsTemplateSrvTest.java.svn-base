package ngves.asiainfo.core.sms.service.interfaces;

import ngves.asiainfo.core.sms.SmsConstant;
import ngves.asiainfo.core.sms.bo.SmsTemplateBean;
import ngves.asiainfo.core.sms.dao.interfaces.IBusiSmsTemplateDAO;
import ngves.asiainfo.core.sms.ivalues.IBusiSmsTemplateValue;
import ngves.asiainfo.core.sms.ivalues.ISmsTemplateValue;

import org.junit.Before;
import org.junit.Test;

import com.ai.appframe2.service.ServiceFactory;

public class IBusiSmsTemplateSrvTest {
	private IBusiSmsTemplateSrv busiSmsTempService;
	private IBusiSmsTemplateDAO busiSmsTemplateDAO;
	@Before
	public void init(){
		System.out.println("start");
		busiSmsTempService = (IBusiSmsTemplateSrv)ServiceFactory.getService(SmsConstant.BUSI_SMS_TEMPLATE_SRV);
		busiSmsTemplateDAO= (IBusiSmsTemplateDAO)ServiceFactory.getService("ngves.asiainfo.core.BusiSmsTemplateDAO");
	}
	@Test
	public void testGetBusiSmsTemplate() throws NumberFormatException, Exception {
		String str="100000000022142";
		IBusiSmsTemplateValue[] i= busiSmsTemplateDAO.getBusiSmsTemplateBySmsId(Long.parseLong(str));
		for (int j = 0; j < i.length; j++) {
			IBusiSmsTemplateValue busiSmsTemplateValue = i[j];
			System.out.println("smsId= "+busiSmsTemplateValue.getSmsId());
			System.out.println("title= "+busiSmsTemplateValue.getTitle());
		}
	}
	@Test
	public void testSavBusiSmsTemplate() throws Exception{
		ISmsTemplateValue v = new SmsTemplateBean();
		String str="100000000022142";
		v.setSmsId(Long.parseLong(str));
		busiSmsTempService.savBusiSmsTemplate(v);
	}
}
