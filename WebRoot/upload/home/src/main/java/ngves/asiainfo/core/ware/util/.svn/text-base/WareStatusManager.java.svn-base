package ngves.asiainfo.core.ware.util;


public class WareStatusManager {

	/**
	 * 操作礼品上下线
	 * @throws Exception
	 */
	public static boolean execute(WareStatusTask task) throws Exception{
		//如果任务为空，抛出异常
		if(null == task){
			throw new Exception("null value");
		}
		
		return WareStatusUtil.updateWareState(task);
		//操作礼品上下线
		// 如果目标状态为礼品上线
		//if(WareConstant.SYS_CORE_WARE_STATUS_ONLINE.equals(task.getTargetState())){
			//执行礼品上线操作
		//	task.getWareStatus().operatorUpLineWare(task);
		//}else if(WareConstant.SYS_CORE_WARE_STATUS_OFFLINE.equals(task.getTargetState())){
			//执行礼品下线操作
		//	task.getWareStatus().operatorDownLineWare(task);
		//}
		
		
	}
	
	public static void main(String [] args){
		try {
			//WareStatusTask task = new WareStatusTask("100000000000000","0");
			WareStatusTask task = new WareStatusTask();
			task.setWareId("100000000000000");
			task.setOperType("0");
			task.setStaffId(125672345);
			task.setWareStatusCause("1");
			task.setNote("上下线任务");
			
			//task.setWareUpDownPlanId("111111111111111111");
			WareStatusManager.execute(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
