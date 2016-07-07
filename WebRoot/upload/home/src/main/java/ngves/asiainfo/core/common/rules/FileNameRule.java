/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.rules;

import ngves.asiainfo.core.common.InformationConstant;

/**
 * @author wzg
 *
 */
public abstract class FileNameRule {
	
	/**
	 * 生成信息订阅营销邮件/短信内容的文件名称规则id+".vm"
	 * @param saleId
	 * @return
	 * @throws Exception
	 */
	public static String getSaleVmFileName( long saleId ) throws Exception {
		return saleId + InformationConstant.VM_FILE_POSTFIX;
	}
}
