package ngves.asiainfo.core.award.util;
import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.award.ivalues.IAwardInfoValue;
import ngves.asiainfo.core.award.service.interfaces.IAwardInfoSrv;
import ngves.asiainfo.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ai.appframe2.service.ServiceFactory;

public class AwardInfoUtil {
	private static transient Log log = LogFactory.getLog(AwardInfoUtil.class);
    /**
    * 根据活动ID获得活动的基本信息
    * @param awardId
    * @return
    */
	public static IAwardInfoValue getAwardInfoById(String awardId) {
		IAwardInfoValue value = null;
		if (!StringUtil.isBlank(awardId)) {
			IAwardInfoSrv AwardInfoSrv = (IAwardInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_AWARD_INFO);			
			try {
				value = AwardInfoSrv.getAwardInfoById(awardId);
			} catch (Exception e) {
				log.error("exception occors when getting award info ,please contact to adminstrator.",e);
			}
		}
		return value;
	}
	
}
