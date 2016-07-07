/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.validate.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.InterSchemaException;
import ngves.asiainfo.core.common.model.CsvcItemRule;
import ngves.asiainfo.core.common.model.ItemRuleCollection;
import ngves.asiainfo.core.csvc.SysResponseConstant;
import ngves.asiainfo.core.csvc.validate.IValidateSchema;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInItem;

/**
 * 进行节点出现次数的验证
 * @author wzg
 *
 */
public class ItemOccurrenceValidation implements IValidateSchema {

	public void validateSchema(CsvcBussiRequestInItem[] reqItems, ItemRuleCollection itemRules)
			throws InterSchemaException, Exception {
		Map<String, Integer> occurences = new HashMap<String, Integer>();
		Integer value = null;
		//汇总每个节点出现的次数形成值对{节点名称,节点出现的次数}
		for (CsvcBussiRequestInItem reqItem : reqItems) {
			value = occurences.get(reqItem.getName());
			if (value == null) {
				value = new Integer(1);
			} else {
				value++;
			}
			occurences.put(reqItem.getName(), value);
			value = null;
			reqItem = null;
		}
		//与规定的节点出现次数进行比较
		Map<String, CsvcItemRule> temp = itemRules.getItemMap();
		CsvcItemRule rule = null;
		for (Map.Entry<String, Integer> entry : occurences.entrySet()) {
			value = entry.getValue();
			rule = temp.get(entry.getKey());
			if(rule == null ) {
				//如果没有获取规则对象,抛出格式异常
				throw new InterSchemaException(SysResponseConstant.SYS_RESP_CSVC_ERROR, entry.getKey()
						+ SCHEMA_ITEM_EXCEP);
			}
			if (!(value >= rule.getMinNum() && value <= rule.getMaxNum())) {
				//如果出现的次数不在规定的{最小值,最大值}范围内,抛异常
				throw new InterSchemaException(SysResponseConstant.SYS_RESP_CSVC_ERROR, rule.getName()
						+ SCHEMA_LENGTH_EXCEP);
			}
			temp.remove(entry.getKey());
			rule = null;
			value = null;
			entry = null;
		}
		//如果<code>temp<code>中还有内容,看这些节点规定出现的最小值,如果最小值大于0,说明是应该出现的节点,但是没有出现
		for (Map.Entry<String, CsvcItemRule> entry : temp.entrySet()) {
			if (entry.getValue().getMinNum() > 0) {
				throw new InterSchemaException(SysResponseConstant.SYS_RESP_CSVC_ERROR, entry.getValue().getName()
						+ SCHEMA_OCCURENCE_NO);
			}
			entry = null;
		}
	}
	
	
	public static void main(String[] args) {
		Integer i = new Integer(2);
		i++;
		System.out.println(" i := " + i);
	}

}
