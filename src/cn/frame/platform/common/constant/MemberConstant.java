package cn.frame.platform.common.constant;

/**
 * 会员常量类
 * @author li
 *
 */
public class MemberConstant {
	
	/**一星会员 0-5000积分 */
	public static final int MEMBER_ONE_STAR_POINT=5000; 
	/**二星会员 5000+ 到 10000 */
	public static final int MEMBER_TWO_STAR_POINT=10000;
	/**三星会员 10000+ 到 20000 */
	public static final int MEMBER_THREE_STAR_POINT=20000;
	/**四星会员 20000+ 到 30000 */
	public static final int MEMBER_FOURE_STAR_POINT=30000;
	/**五星会员 30000+  */
	public static final int MEMBER_FIVE_STAR_POINT=40000;
	
	/**
	 * 根据会员总积分，得出用户当前星级
	 * @param memberPoint
	 * @return
	 */
	public static int getMemberStarLevel(int memberPoint){
		int level=1;
		if(memberPoint<=MEMBER_ONE_STAR_POINT){
			level=1;
		}else if(memberPoint<=MEMBER_TWO_STAR_POINT){
			level=1;
		}else if(memberPoint<=MEMBER_THREE_STAR_POINT){
			level=1;
		} else if(memberPoint<=MEMBER_FOURE_STAR_POINT){
			level=1;
		} else if(memberPoint<=MEMBER_FIVE_STAR_POINT){
			level=1;
		}  
		return level;
	}
 
	
	/**默认收获地址 */
	public static final String MEMBER_ADDRESS_IS_DEFAULT="1";
	/**非默认收获地址 */
	public static final String MEMBER_ADDRESS_NO_DEFAULT="0";
	
	/**会员二维码下载地址 */
	public static final String MEMBER_QR_CODE_DOWNLOAD_URL="/image/qrcode/";
	

	
	/**会员状态 0 正常*/
	public static final String MEMBER_STATUS_NORMAL="0";
	/**会员状态 1 停用*/
	public static final String MEMBER_STATUS_STOP="1";
	/**会员状态 2 锁定*/
	public static final String MEMBER_STATUS_LOCK="2";
	
	
	/**会员注册推广类型 01 扫描二维码*/
	public static final String RECOMEND_TYPE_QR_CODE="01";
	
}
