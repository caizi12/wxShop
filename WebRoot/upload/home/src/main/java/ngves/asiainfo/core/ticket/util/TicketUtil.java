package ngves.asiainfo.core.ticket.util;

import java.io.File;

import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.core.common.cache.CacheLoaderTemplate;
import ngves.asiainfo.util.MemcachedClientUtil;
import ngves.asiainfo.core.ticket.TicketConstant;
import ngves.asiainfo.core.ticket.ivalues.ITicketTopicInfoValue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class TicketUtil {
	private static transient Log log = LogFactory.getLog(TicketUtil.class);
	/**
	 * @purpose :获得票务专题页图片 访问路径
	 * @return 路径地址，例如：/pic/ticket/
	 */
	public static String getTicketImgBasePath() {
		String imgPath = TicketConstant.PIC_TICKET_URL;
		if (imgPath.lastIndexOf("/") < 0 && imgPath.lastIndexOf("\\") < 0)
			imgPath += File.separator;
		String retFilePath = imgPath;
		if (!(retFilePath.endsWith("/") || retFilePath.endsWith("\\")))
			retFilePath = retFilePath + "/";
		retFilePath = retFilePath.replace("\\", "/");
		 log.info(retFilePath);
		return retFilePath;
	}
	/**
	 * 保存票务专题到Memcache缓存中
	 * @param value 保存票务专题对象
	 */
	public static void setTicketTopicInfo(ITicketTopicInfoValue value){
		MemcachedClientUtil.setObject(CommnConstant.MEMCACHE_TICKET_TOPIC_INFO, value);
	}
	/**
	 * 从Memcache缓存中获取票务专题对象
	 * @param value 保存票务专题对象
	 */
	public static ITicketTopicInfoValue getTicketTopicInfo() throws Exception {
		ITicketTopicInfoValue value=null;
		try {
			value = CacheLoaderTemplate.getEntity(CommnConstant.MEMCACHE_TICKET_TOPIC_INFO, null);
		} catch (Exception e) {
			log.error("getTicketTopicInfo is excep by value := " + value, e);
		}
		return  value;
	}
}
