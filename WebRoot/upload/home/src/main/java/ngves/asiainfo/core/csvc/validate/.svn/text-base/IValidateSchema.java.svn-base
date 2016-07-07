/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.validate;


import ngves.asiainfo.InterSchemaException;
import ngves.asiainfo.core.common.model.ItemRuleCollection;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInItem;

/**
 * 根据每个item的规则对Shema的对象进行验证
 * @author wzg
 *
 */
public interface IValidateSchema {
	
	public static final String SCHEMA_LENGTH_EXCEP  = "节点长度不符合要求";
	public static final String SCHEMA_OCCURENCE_NO  = "节点不存在";
	public static final String SCHEMA_OCCURENCE_EXCEP  = "节点出现次数不符合规定";
	public static final String SCHEMA_ITEM_EXCEP  = "该节点名称不符合规定";

	public void validateSchema(CsvcBussiRequestInItem[] reqItems, ItemRuleCollection itemRules)
			throws InterSchemaException,Exception;
}
