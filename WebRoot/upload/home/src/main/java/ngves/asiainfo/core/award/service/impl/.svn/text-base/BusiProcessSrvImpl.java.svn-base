package ngves.asiainfo.core.award.service.impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import ngves.asiainfo.core.award.service.interfaces.IBusiProcessSrv;



public class BusiProcessSrvImpl implements IBusiProcessSrv{

	@SuppressWarnings("unchecked")
	public void recordBusiInfoDetails(String busiId, Map<String, Object> oldValues, Map<String, Object> newValues,
			Map<String, List> retMap) throws Exception {
		// return recordBusiInfoDetails(busiId, oldValues, newValues, null);

		Iterator iterAdd = null;
		iterAdd = newValues.entrySet().iterator();

		Iterator iterDel = null;
		iterDel = oldValues.entrySet().iterator();

		Iterator iterModify = null;
		iterModify = newValues.entrySet().iterator();

		List<Object> listNew = new ArrayList<Object>();
		List<Object> listDel = new ArrayList<Object>();
		List<Object> listModifyToCheckOld = new ArrayList<Object>();
		List<Object> listModifyToCheckNew = new ArrayList<Object>();

		// 首先判断新增的
		while (iterAdd.hasNext()) {
			Map.Entry<String, Object> newValue = (Entry<String, Object>) iterAdd.next();
			if (!oldValues.containsKey(newValue.getKey())) {
				listNew.add(newValue.getValue());
			}
		}

		// 判断删除的

		while (iterDel.hasNext()) {
			Map.Entry<String, Object> oldValue = (Entry<String, Object>) iterDel.next();
			if (!newValues.containsKey(oldValue.getKey())) {
				listDel.add(oldValue.getValue());
			}
		}

		// 判断修改的
		while (iterModify.hasNext()) {
			Map.Entry<String, Object> value = (Entry<String, Object>) iterModify.next();
			if (newValues.containsKey(value.getKey()) && oldValues.containsKey(value.getKey())) {
				listModifyToCheckNew.add(newValues.get(value.getKey()));
				listModifyToCheckOld.add(oldValues.get(value.getKey()));
			}
		}

		retMap.put("listNew", listNew);
		retMap.put("listDel", listDel);
		retMap.put("listModifyToCheckOld", listModifyToCheckOld);
		retMap.put("listModifyToCheckNew", listModifyToCheckNew);
	}
}
