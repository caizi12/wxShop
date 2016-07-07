package ngves.asiainfo.core.common.util;

import javax.mail.MessagingException;

import ngves.asiainfo.core.common.CorePropsConstant;
import ngves.asiainfo.mail.MailHelper;
import ngves.asiainfo.util.PropertyReader;

public class AiMailUtil {
	public static MailHelper getIntance() {
        MailHelper mh = new MailHelper();
        Object obj = PropertyReader.getProperty(CorePropsConstant.MAIL_SMTP_HOST);
        if (null != obj)
            mh.setMailSmtpHost(obj.toString());
        
        obj = PropertyReader.getProperty(CorePropsConstant.MAIL_SMTP_AUTH);
        if (null != obj)
            mh.setMailSmtpAuth(obj.toString());
        
        obj = PropertyReader.getProperty(CorePropsConstant.MAIL_SEND_CONTENT_TYPE);
        if (null != obj)
            mh.setMailContentType(obj.toString());
        
        obj = PropertyReader.getProperty(CorePropsConstant.MAIL_SEND_ADDR);
        if (null != obj)
            mh.setMailSendAddress(obj.toString());
        
        obj = PropertyReader.getProperty(CorePropsConstant.MAIL_SEND_ACCOUNT);
        if (null != obj)
            mh.setSendAccount(obj.toString());
        
        obj = PropertyReader.getProperty(CorePropsConstant.MAIL_SEND_PASSWD);
        if (null != obj)
            mh.setSendAccountPasswd(obj.toString());
        //对应配置项,不做特殊说明都不能为null/""
        mh.setSendSmtpHost(PropertyReader.getProperty(CorePropsConstant.MAIL_SEND_SMTP_HOST));
        mh.setMailSendName(PropertyReader.getProperty(CorePropsConstant.MAIL_SEND_NAME));
        
        return mh;
	}
	
	/**
	 *	发送普通文本邮件 
	 */
	public static void  sendPlainTxt(String toAddress,String subject,String content)throws Exception{
		getIntance().sendPlainTxt(toAddress, subject, content);
	}
	
	/**
	 * 发送多表体或者带附件的邮件
	 * @param toAddress
	 * @param subject
	 * @param content
	 * @param fileName
	 * @throws MessagingException
	 */
	public static void sendMultipart(String toAddress, String subject, String content, String fileName)
	throws Exception {
		getIntance().sendMultipart(toAddress, subject, content, fileName);
	}
	
	
	
	public static void main(String[] args ) {
		String initCont = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><title></title></head><body>" + 
		"<div  style=\"border:1px solid #999; background:#f3f3f3; line-height:1.6em;\">" + 
		"尊敬的中国移动客户您好，此封邮件来自于中国移动积分商城" + 
		"<a href=\"http://jf.10086.cn\">http://jf.10086.cn</a>，若您无法正常浏览此邮件，请点[<a href=\"#\">这里</a>]。</div>\n\r" +
		"请替换此处文本\n\r" + 
		"<div style=\"border:1px solid #999; background:#f3f3f3; line-height:1.6em;\">本邮件由系统自动发出，请勿直接回复，如不希望再收到类似邮件，" +
		"请点击[<a href=\"#\">退订</a>]</div></body></html>";
		try {
			sendMultipart("wangzg2@asiainfo-linkage.com", "心动积分商城", initCont, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
