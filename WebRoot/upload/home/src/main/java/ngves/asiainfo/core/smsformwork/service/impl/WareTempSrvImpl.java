package ngves.asiainfo.core.smsformwork.service.impl;

import java.util.List;

import ngves.asiainfo.core.common.model.SysPara;
import ngves.asiainfo.core.smsformwork.dao.interfaces.IWareTempDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IQBOWareTempValue;
import ngves.asiainfo.core.smsformwork.service.interfaces.IWareTempSrv;
import ngves.asiainfo.core.smsformwork.util.SmsFormworkUtils;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 礼品所属短信模板列表查询服务
 * 
 * @author liuyf 2013-12-04
 */
public class WareTempSrvImpl implements IWareTempSrv {

	public IWareTempDAO wareTempDAO;
	private static Log logger = LogFactory.getLog(WareTempSrvImpl.class);

	public IWareTempDAO getWareTempDAO() {
		return wareTempDAO;
	}

	public void setWareTempDAO(IWareTempDAO wareTempDAO) {
		this.wareTempDAO = wareTempDAO;
	}

	/**
	 * 礼品所属短信模板列表查询
	 * 
	 * @param wareFirstKindId
	 * @param wareKindParentId
	 * @param wareKindId
	 * @param wareName
	 * @param wareCode
	 * @param provinceCode
	 * @param tempName
	 * @param activeKind
	 * @param activeName
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOWareTempValue[] getWareTempList(String wareFirstKindId, String wareKindParentId, String wareKindId,
			String wareName, String wareCode, String provinceCode, String tempName, String activeKind,
			String activeName,String wareKindInfoId, int startNum, int endNum) throws Exception {
		String args = "wareFirstKindId:" + wareFirstKindId + "\nwareKindParentId:" + wareKindParentId + "\nwareKindId:"
				+ wareKindId + "\nwareName:" + wareName + "\nwareCode:" + wareCode + "\nprovinceCode:" + provinceCode
				+ "\ntempName:" + tempName + "\nactiveKind:" + activeKind + "\nactiveName:" + activeName
				+ "\nstartNum:" + startNum + "\nendNum:" + endNum + "\n";
		logger.debug(args);
		IQBOWareTempValue[] wareTempValues = wareTempDAO.getWareTempList(wareFirstKindId, wareKindParentId, wareKindId,
				wareName, wareCode, provinceCode, tempName, activeKind, activeName,wareKindInfoId, startNum, endNum);
		for (IQBOWareTempValue value : wareTempValues) {
			if (!StringUtil.isBlank(value.getOperatorCode())) {
				value.setOperatorCode(SmsFormworkUtils.operCodeToName(value.getOperatorCode()));
			}
		}
		return wareTempValues;
	}

	public int getWareTempListCount(String wareFirstKindId, String wareKindParentId, String wareKindId,
			String wareName, String wareCode, String provinceCode, String tempName, String activeKind, String activeName,String wareKindInfoId)
			throws Exception {
		return wareTempDAO.getWareTempListCount(wareFirstKindId, wareKindParentId, wareKindId, wareName, wareCode,
				provinceCode, tempName, activeKind, activeName,wareKindInfoId);
	}

	public List<SysPara> getactiveKindJson(String activeKind) throws Exception {
		return wareTempDAO.getactiveKindJson(activeKind);
	}

}
