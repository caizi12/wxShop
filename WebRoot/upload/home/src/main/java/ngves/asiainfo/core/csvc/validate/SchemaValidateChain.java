/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.csvc.validate;

import java.util.LinkedList;
import java.util.List;

import com.ai.appframe2.common.DataStructInterface;

import ngves.asiainfo.InterSchemaException;
import ngves.asiainfo.core.common.model.ItemRuleCollection;
import ngves.asiainfo.core.csvc.validate.impl.ItemOccurrenceValidation;
import ngves.asiainfo.core.csvc.validate.impl.ItemValueLengthValidation;
import ngves.asiainfo.interfaces.csvc.bean.csvcBussi.in.CsvcBussiRequestInItem;

/**
 * 单例
 * @author wzg
 *
 */
public class SchemaValidateChain {
	
	/**
	 * 报文验证链表
	 */
	private List<IValidateSchema> schemaValidateChains = new LinkedList<IValidateSchema>();

	private SchemaValidateChain() {
		schemaValidateChains.add(new ItemOccurrenceValidation());
		schemaValidateChains.add(new ItemValueLengthValidation());
	}

	private static class ValidateSchemaFactoryLoader {
		private static final SchemaValidateChain validateSchema = new SchemaValidateChain();
	}

	public static SchemaValidateChain getInstance() {
		return ValidateSchemaFactoryLoader.validateSchema;
	}

	public void executeValidation(CsvcBussiRequestInItem[] reqItems, DataStructInterface dataContainer)
			throws InterSchemaException, Exception {
		ItemRuleCollection itemRules = SchemaRuleFactory.getItemRuleCollection(dataContainer);
		for (IValidateSchema v : schemaValidateChains) {
			v.validateSchema(reqItems, itemRules);
		}
	}
}
