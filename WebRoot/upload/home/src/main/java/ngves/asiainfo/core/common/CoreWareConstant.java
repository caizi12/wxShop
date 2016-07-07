/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common;

/**
 * @author wzg 2010.09.27
 *
 */
public abstract class CoreWareConstant {
	
	/**
	 * 推荐分类类型-分类区域推荐
	 */
	public static final int WARE_RECORMEND_CATEGORY = 3;
	/**
	 * 推荐分类类型-首页全球通推荐
	 */
	public static final int WARE_RECORMEND_GLOBAL = 0;
	/**
	 * 推荐分类类型-首页动感地带推荐
	 */
	public static final int WARE_RECORMEND_MZONE = 2;
	/**
	 * 推荐分类类型-首页神州行推荐
	 */
	public static final int WARE_RECORMEND_EASYOWN =1;
	/**
	 * 推荐分类类型-首页客户端推荐
	 */
	public static final int WARE_RECORMEND_CLIENT = 4;
	
	/**
	 * 分类推荐区域要显示礼品总数为20个
	 * by shenfl at 2012-5-2 商城优化-分类区域由原来的20个该为12
	 */
	public static final int RECORMEND_CATEGORY_COUNT = 12;
	/**
	 * 礼品上线时间降序排列
	 */
	public static final String RC_WARE_SORT_DATE_DESC = "01";
	/**
	 * 绑定礼品的排序号升序排列
	 */
	public static final String RC_WARE_SORT_SORTID_ASC = "02";

	/**
	 * 推荐礼品置顶的标记为1(int)
	 */
	public static final int TOP_VALID = 1;
	/**
	 * 推荐礼品没有置顶的标记为0(int)
	 */
	public static final int TOP_INVALID = 0;

	
	
}
