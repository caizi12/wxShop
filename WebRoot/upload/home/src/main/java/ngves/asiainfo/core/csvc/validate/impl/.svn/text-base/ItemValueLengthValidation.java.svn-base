/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.validate.impl;


import ngves.asiainfo.CommnConstant;
import ngves.asiainfo.InterSchemaException;
import ngves.asiainfo.core.common.model.CsvcItemRule;
import ngves.asiainfo.core.common.model.ItemRuleCollection;
import ngves.asiainfo.core.csvc.SysResponseConstant;
import ngves.asiainfo.core.csvc.validate.IValidateSchema;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInItem;
import ngves.asiainfo.util.StringUtil;

/**
 * 进行节点内容长度验证
 * @author wzg
 *
 */
public class ItemValueLengthValidation implements IValidateSchema {

	public void validateSchema(CsvcBussiRequestInItem[] reqItems, ItemRuleCollection itemRules)
			throws InterSchemaException,Exception {
		String value = null;
		CsvcItemRule rule = null;
		//预防性能,循环变量及时置空
		for(CsvcBussiRequestInItem reqItem : reqItems ) {
			value = reqItem.getValue();
			value = value == null ? "" : value;
			rule = itemRules.getCsvcItemRule(reqItem.getName());
			int length = StringUtil.bytesLength(value, CommnConstant.ENCODING_GBK);
			if( !(length >= rule.getMinLength() && length <= rule.getMaxLength()) ) {
				//如果内容的长度不在规定的{最小值,最大值}范围内,抛异常
				throw new InterSchemaException(SysResponseConstant.SYS_RESP_CSVC_ERROR, reqItem.getName() + SCHEMA_LENGTH_EXCEP);
			}
			value = null;
			rule = null;
			reqItem = null;
		}
	}
	
	public static void main(String[] args) {
		try {
			String ss = "0152-积分专席基地";
			System.out.println(" ss len := " + StringUtil.bytesLength(ss, CommnConstant.ENCODING_GBK));
			System.out.println(" ss len2 := " + StringUtil.bytesLength(ss, CommnConstant.ENCODING_UTF));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
