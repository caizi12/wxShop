package ngves.asiainfo.core.rechargepoints.util;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargeFileValue;
import ngves.asiainfo.core.rechargepoints.ivalues.IRechargePointsTaskValue;
import ngves.asiainfo.core.rechargepoints.service.interfaces.IRechargePointsTaskSrv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;

/**
 * 2014-09-09
 * @author yeqh
 * 积分返赠工具类
 */

public class RechargePointsUtils {
	
	private static Log logger = LogFactory.getLog(RechargePointsUtils.class);
	private static IRechargePointsTaskSrv rechargePointsTaskSrv = (IRechargePointsTaskSrv) ServiceFactory.getService(CoreSrvContstant.RECHARGE_POINTS_TASK);
	
	/**
	 * 将充值文件正式表中的对象作为参数，用于文件记录流水信息
	 */
	
	public static void recordBusiRechargeFile(IRechargeFileValue rechargeFile)throws Exception{
		logger.info(" 正在更新充值文件记录流水表  ");
		rechargePointsTaskSrv.recordBusiRechargeFile(rechargeFile);
		logger.info(" 更新充值文件记录流水表完毕  ");
	}
	
	
	/**
	 * 将充值任务正式表中的对象作为参数，用于任务记录流水信息
	 */
	public static void recordBusiRechargePointsTask(IRechargePointsTaskValue rechargePointsTask) throws Exception{
		logger.info(" 正在更新充值任务记录流水表  ");
		rechargePointsTaskSrv.recordBusiRechargePointsTask(rechargePointsTask);
		logger.info(" 更新充值任务记录流水表完毕  ");
	}

}
