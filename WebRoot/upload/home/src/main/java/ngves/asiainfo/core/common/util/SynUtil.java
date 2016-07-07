package ngves.asiainfo.core.common.util;

import java.sql.Timestamp;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.common.service.interfaces.IBaseInfoSynSrv;



import com.ai.appframe2.service.ServiceFactory;

public class SynUtil {
    /**
     * 记录同步信息
     * @param infoType  业务操作的类型：MgtCmmnConstant
     * @param infoId    
     * @param infoState
     * @throws Exception
     */
    public static void addSynInfo(String infoType, long infoId, String infoState) throws Exception {
        IBaseInfoSynSrv baseInfoSynSrv = (IBaseInfoSynSrv) ServiceFactory
                .getService(CoreSrvContstant.SERVICE_CORE_SYS_BASE_SYN_SRV);
        baseInfoSynSrv.addSynInfo(infoType, infoId, infoState);
    }
    
    /**
     * 记录同步信息 (专门用于物流配送关系同步信息)
     * @param infoType  业务操作的类型：MgtCmmnConstant
     * @param infoId    
     * @param infoState
     * @throws Exception
     */
    public static void addSynInfo(String infoType, long infoId, String infoState, Timestamp validDate) throws Exception {
        IBaseInfoSynSrv baseInfoSynSrv = (IBaseInfoSynSrv) ServiceFactory
                .getService(CoreSrvContstant.SERVICE_CORE_SYS_BASE_SYN_SRV);
        baseInfoSynSrv.addSynInfo(infoType, infoId, infoState, validDate);
    }
}
