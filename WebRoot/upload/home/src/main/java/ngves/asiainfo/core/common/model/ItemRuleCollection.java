/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 线程安全类
 * @author wzg
 *
 */
public class ItemRuleCollection implements Serializable{
	
	private static final long serialVersionUID = 8930901658960645254L;
	private Map<String, CsvcItemRule> items = new HashMap<String, CsvcItemRule>();
	
	public void add(CsvcItemRule rule ) {
		items.put(rule.getName(), rule);
	}
	
	/**
	 * 复制返回,保持对象的不可变
	 * @return
	 */
	public Map<String, CsvcItemRule> getItemMap() {
		Map<String, CsvcItemRule> temp = new HashMap<String, CsvcItemRule>();
		temp.putAll(items);
		return temp;
	}
	
	/**
	 * 根据名称返回规则
	 * @param name
	 * @return
	 */
	public CsvcItemRule getCsvcItemRule(String name) {
		return items.get(name);
	}
	
	public static void main(String[] args) {
		CsvcItemRule item = new CsvcItemRule("aaa", 0, 23, 1, 1, "AAA");
		ItemRuleCollection v = new ItemRuleCollection();
		v.add(item);
		Map<String, CsvcItemRule> m = v.getItemMap();
		m.remove(item);
		Map<String, CsvcItemRule> m2 = v.getItemMap();
		System.out.println(" m2 := " + m2);
	}
}
