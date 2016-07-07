package cn.frame.platform.common;

/**
 * 系统常量类，主要用于存放系统基础常量信息
 * @date 2012-08-27 19:22:05
 * @author llliang
 *
 */
public class ConstantPlatform {
	
	/**存放登录用户信息 */
	public static final String SYS_USER_INFO="sysUserSessionInfo";
	
	/**存放注册会员用户信息 */
	public static final String MEMBER_INFO="memberSessionInfo";
	
	/**存放会员星级 */
	public static final String MEMBER_STAR_LEVEL="memberStarLevel";
	
	/**提示类型 成功*/
	public static final String SUCCESS="success";
	/**提示类型 失败*/
	public static final String ERROR="error";
	/**提示类型 警告*/
	public static final String WARN="warn";
	
	/**系统用户状态 正常*/
	public static final String SYSUSER_STATUS_NORMAL="0";
	/**系统用户状态 停用*/
	public static final String SYSUSER_STATUS_STOP="1";
	/**系统用户状态 锁定*/
	public static final String SYSUSER_STATUS_LOCK="2";
	
	/**系统业务字典状态 1 启用	 * */
	public static final String DICT_STATUS_NORMAL="1";
	/**系统业务字典状态 0 停用	 * */
	public static final String DICT_STATUS_STOP="0";
	
	/**分隔符 逗号	* */
	public static final String SYS_SEPARATOR_COMMA=","; 
	
	/**
	 * 系统网址域名
	 */
	public static final String SYS_NET_URL="http://www.gssc51.com";
	
	/**
	 * 商城地址
	 */
	public static final String SYS_SHOP_NET_URL=SYS_NET_URL+"/wxShop";
		
}
