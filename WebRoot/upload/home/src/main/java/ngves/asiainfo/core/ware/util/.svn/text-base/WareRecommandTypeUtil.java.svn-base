/**
 * @date:2012-10-15
 *
 * Copyright 2012 asiainfo-linkage, Inc. All rights reserved. 
 * @author:shenfl
 */
package ngves.asiainfo.core.ware.util;

import org.apache.commons.lang.StringUtils;

public class WareRecommandTypeUtil {

	/**
	 * 001 主推商品 101 新品推荐 102 礼品车展示礼品推荐 300 品牌推荐 A 全部分类
	 * 
	 * @param typeCode
	 * @return
	 */
	public static String getRecommandTypeName(String paraCode) {

		String recommandName = "礼品分类推荐";
		if (!StringUtils.isBlank(paraCode)) {

			if ("001".equals(paraCode)) {
				recommandName = "主推商品";
			} else if ("101".equals(paraCode)) {
				recommandName = "新品推荐";
			} else if ("102".equals(paraCode)) {
				recommandName = "礼品车展示礼品推荐";
			} else if ("300".equals(paraCode)) {
				recommandName = "品牌推荐";
			} else {
			}
		}
		return recommandName;
	}
}
