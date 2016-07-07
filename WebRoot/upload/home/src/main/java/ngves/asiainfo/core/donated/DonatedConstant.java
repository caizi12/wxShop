package ngves.asiainfo.core.donated;

import ngves.asiainfo.util.PropertyReader;

public class DonatedConstant {

	// 积分捐赠活动上传主图片时，图片大小限制 KB
	public static final int MAX_PIC_FILE_SIZE_MAIN = 60;
	// 积分捐赠活动主图片，图片宽度限制 950px
	public static final int MAX_PIC_WIDTH_MAIN = 950;
	// 积分捐赠活动主图片，图片高度限制300px
	public static final int MAX_PIC_HEIGHT_MAIN = 300;
	

	// 积分捐赠活动上传背景图片时，图片大小限制 KB
	public static final int MAX_PIC_FILE_SIZE_BG = 60;
	// 积分捐赠活动背景图片，图片宽度限制 950px
	public static final int MAX_PIC_WIDTH_BG = 950;
	// 积分捐赠活动背景图片，图片高度限制300px
	public static final int MAX_PIC_HEIGHT_BG = 300;
	
	//积分捐赠活动的主图片的类型
	public static final String DONATED_ACTIVITY_IMG_TYPE_MAIN = "0";
	
	//积分捐赠活动的捐赠说明区背景图类型
	public static final String DONATED_ACTIVITY_IMG_TYPE_BG = "1";
	
	//积分捐赠活动的捐赠背景图片 (最大的那个图)
	public static final String DONATED_ACTIVITY_IMG_TYPE_FULL_BG = "2";
	//积分捐赠对象状态为启用（默认为启用）
	public static final String DONATED_OBJECT_STATUS_ABLE ="0";
	
	//积分捐赠对象状态为停用
	public static final String DONATED_OBJECT_STATUS_DISABLE="1";
	
	public static final String DONATED_PORTAL_URL_KEY = "pic.donated.url";
	public static final String DONATED_PORTAL_URL = PropertyReader.getProperty(DonatedConstant.DONATED_PORTAL_URL_KEY);
 	
	
	//积分捐赠活动状态，未发布、已发布、进行中、已结束）
	public static final long DONATED_ACTIVITY_STATUS_CREATE 	= 	0;
	public static final long DONATED_ACTIVITY_STATUS_PUBLISH 	=  	1;
	public static final long DONATED_ACTIVITY_STATUS_PROGRESS 	= 	2;
	public static final long DONATED_ACTIVITY_STATUS_END 		= 	3;
	
	
	//积分捐赠活动的捐赠类型   0-积分捐赠  1-礼品捐赠 2-积分礼品捐赠
	public static final String DONATED_TYPE_ONLY_INTEGRAL 		= "0";
	public static final String DONATED_TYPE_ONLY_WARE 			= "1";
	public static final String DONATED_TYPE_BOTH_INTEGRAL_WARE 	= "2";
	
	//捐赠对象表名
	public static final String TABLE_DONATED_OBJECTS = "DONATED_OBJECTS";
	
	public static final String DONATED_ACTIVITY_TABLE_NAME = "DONATED_ACTIVITY";
	
	//对象分割字符','(英文下半角逗号)
	public static final String SEPARATE_CHAR_COMMA = ",";
	public static final String DONATED_OBJECT_RLT_MAX_NUM_KEY = "donated.object.rlt.num";
	public static final String DONATED_OBJECT_RLT_MAX_NUM = PropertyReader.getProperty(DonatedConstant.DONATED_OBJECT_RLT_MAX_NUM_KEY);
	
	
	//积分捐赠活动，为礼品指定绑定对象时，绑定状态
	public static final String DONATED_WARE_OBJECT_STATE_BIND = "0";
	//积分捐赠活动，为礼品指定绑定对象时，不绑定状态
	public static final String DONATED_WARE_OBJECT_STATE_UNBIND = "1";
 	
	
}
