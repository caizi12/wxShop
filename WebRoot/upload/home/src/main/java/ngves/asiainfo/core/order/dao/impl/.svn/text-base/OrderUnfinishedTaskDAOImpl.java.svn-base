package ngves.asiainfo.core.order.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.order.bo.OrderUnfinishedTaskEngine;
import ngves.asiainfo.core.order.dao.interfaces.IOrderUnfinishedTaskDAO;
import ngves.asiainfo.core.order.ivalues.IOrderUnfinishedTaskValue;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderUnfinishedTaskDAOImpl implements IOrderUnfinishedTaskDAO {
	private static Log log = LogFactory.getLog(OrderUnfinishedTaskDAOImpl.class);

	public void saveTaskInfo(IOrderUnfinishedTaskValue value) throws Exception {
		if (value.isNew()) {
			if(StringUtil.isBlank((value.getTaskId()+""))){
				value.setTaskId(OrderUnfinishedTaskEngine.getNewId().longValue());
			}
		}
		OrderUnfinishedTaskEngine.save(value);
	}

	public IOrderUnfinishedTaskValue getOrderTaskById(String taskId) throws Exception {
		if (!StringUtil.isBlank(taskId)) {
			return OrderUnfinishedTaskEngine.getBean(Long.parseLong(taskId));
		} else {
			log.info("taskId is null.....");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public IOrderUnfinishedTaskValue[] getOrderUnfininshedTaskInfo(String condition, Map parameter, int startIndex,
			int endIndex) throws Exception {
		return OrderUnfinishedTaskEngine.getBeans(null, condition, parameter,
				startIndex, endIndex, false);
	}
	@SuppressWarnings("unchecked")
	public int getOrderUnfininshedTaskInfoCount(String condition,Map parameter) throws Exception {
		return OrderUnfinishedTaskEngine.getBeansCount(condition,parameter);
	}

}
