package ngves.asiainfo.core.stat.service.interfaces;

import ngves.asiainfo.core.stat.dao.interfaces.IStatAllegeInfoDAO;
import ngves.asiainfo.core.stat.ivalues.IQBOAllegeDetailQRYValue;


public interface IStatAllegeInfoSrv {
	
	public void setStatAllegeInfoDAO(IStatAllegeInfoDAO statAllegeInfoDAO) throws Exception;
	
	 /**
     * 客诉明细信息查询(新增礼品中类，礼品小类，礼品编码列)
     * @param allegeStatus
     * @param wareFirstKind
     * @param timeSelectType
     * @param startTime
     * @param endTime
     * @param allegeKind
     * @param allegeSubKind
     * @param allegeLevel
     * @param provinceCode
     * @param overTime
     * @param exchangeChannel
     * @param respPartnerType
     * @param respPartnerId
     * @param mobilePhone
     * @param indictseq
     * @param warecode
     * @param userBrand
     * @param lstWareParentKind
     * @param lstWareKind
     * @param indictStatus
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
     
    public IQBOAllegeDetailQRYValue[] queryAllegeDetail(String allegeStatus, String wareFirstKind, String timeSelectType,
            String startTime, String endTime, String allegeKind, String allegeSubKind, String allegeLevel,
            String provinceCode, String overTime, String exchangeChannel, String respPartnerType, String respPartnerId,
            String mobilePhone, String indictseq, String warecode, String userBrand, String lstWareParentKind, String lstWareKind, String indictStatus,String wareKindInfoId,int startIndex, int endIndex ) throws Exception;
    
    /**
	 * 客诉明细信息查询的数据个数获取(新增礼品编码、礼品中类、礼品小类)
	 * 
	 * @param allegeStatus
	 * @param wareFirstKind
	 * @param timeSelectType
	 * @param startTime
	 * @param endTime
	 * @param allegeKind
	 * @param allegeSubKind
	 * @param allegeLevel
	 * @param provinceCode
	 * @param overTime
	 * @param exchangeChannel
	 * @param respPartnerType
	 * @param respPartnerId
	 * @param mobilePhone
	 * @param indictseq
	 * @param warecode
	 * @param userBrand
	 * @param lstWareParentKind
	 * @param lstWareKind
	 * @param indictStatus
	 * @return
	 * @throws Exception
	 */
	public int queryAllegeDetailCount(String allegeStatus, String wareFirstKind,
			String timeSelectType, String startTime, String endTime,
			String allegeKind, String allegeSubKind, String allegeLevel,
			String provinceCode, String overTime, String exchangeChannel,
			String respPartnerType, String respPartnerId, String mobilePhone,
			String indictseq, String warecode, String userBrand,
			String lstWareParentKind, String lstWareKind, String indictStatus,String wareKindInfoId)
			throws Exception;
    
}
