/**
 * Copyright (c) 2012 asiainfo.com
 */
package ngves.asiainfo.core.ticket;

import ngves.asiainfo.util.PropertyReader;

/**
 * 票务专题页中的常量
 *
 * @author WL
 * 
 */
public class TicketConstant {


	// 专题图片 访问路径
	public static final String PIC_TICKET_URL_KEY = "pic.ticket.url";
	public static final String TICKET_PREVIEW_PATH_KEY = "portal.server.url";
	public static final String PIC_TICKET_URL = PropertyReader.getProperty(TicketConstant.PIC_TICKET_URL_KEY);
	public static final String TICKET_PREVIEW_PATH =PropertyReader.getProperty(TicketConstant.TICKET_PREVIEW_PATH_KEY);
	
	/*
	 * 新增、删除、修改、预览操作标识
	 */
	public static final String OPERATE_ADD="add";
	public static final String OPERATE_UPDATE="update";
	public static final String OPERATE_DELETE="delete";
	public static final String OPERATE_PREVIEW="preview";
	
	/**
	 * 临时文件夹大小
	 */
	public static final int MAX_TEMP_FILE_SIZE=2048;
	
	/**
	 * 票务专题页上传图片时，标题图片大小限制 2048k
	 */
	public static final int MAX_TITLE_PIC_FILE_SIZE=2048;
	/**
	 * 票务专题页上传图片时，标题图片宽度950
	 */
	public static final int MAX_TITLE_PIC_WIDTH=950;
	/**
	 * 票务专题页上传图片时，标题图片高度：?暂无
	 */
	//public static final int MAX_TITLE_PIC_HEIGHT=950;
	
	/**
	 * 票务专题页上传图片时，说明区背景图大小限制 500k
	 */
	public static final int MAX_DESC_BG_FILE_SIZE=500;
	/**
	 * 票务专题页上传图片时，说明区背景图宽度950
	 */
	public static final int MAX_DESC_BG_WIDTH=950;
	/**
	 * 票务专题页上传图片时，说明区背景图高度：?暂无
	 */
	//public static final int MAX_DESC_BG_HEIGHT=950;
	
	/**
	 * 票务专题页上传图片时，专题背景图大小限制 500k
	 */
	public static final int MAX_TOPIC_BG_FILE_SIZE=500;
	/**
	 * 票务专题页上传图片时，专题背景图宽度950
	 */
	public static final int MAX_TOPIC_BG_WIDTH=950;
	/**
	 * 票务专题页上传图片时，专题背景图高度：?暂无
	 */
	//public static final int MAX_TOPIC_BG_HEIGHT=950;
	
	
	/**
	 * 国家大剧院模版
	 */
	public static final String TICCKET_TOPIC_TEMPLET_THEATRE="01";
	
	/**
	 * 影院类模版
	 */
	public static final String TICCKET_TOPIC_TEMPLET_CINEMA="02";
	/**
	 * 影票Cookie标记
	 */
	public static final String USER_LOCATION_INFO = "USERLOCATIONINFO";
	
}
