package ngves.asiainfo.core.smsformwork.service.interfaces;

import java.util.List;

import ngves.asiainfo.core.common.model.SysPara;
import ngves.asiainfo.core.smsformwork.dao.interfaces.IWareTempDAO;
import ngves.asiainfo.core.smsformwork.ivalues.IQBOWareTempValue;

/**
 * 礼品所属短信模板列表查询服务
 * @author liuyf
 * 2013-12-04
 */
public interface IWareTempSrv {

	/**
	 * 礼品所属短信模板列表查询
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
	public IQBOWareTempValue[] getWareTempList(String wareFirstKindId, String wareKindParentId , String wareKindId, String wareName,String wareCode,String provinceCode,String tempName,String activeKind,String activeName,String wareKindInfoId, int startNum, int endNum) throws Exception;
	
	public int getWareTempListCount(String wareFirstKindId, String wareKindParentId, String wareKindId,
			String wareName, String wareCode, String provinceCode, String tempName, String activeKind, String activeName,String wareKindInfoId)
			throws Exception;
			
	public void setWareTempDAO(IWareTempDAO wareTempDAO);
	
	public List<SysPara> getactiveKindJson(String activeKind) throws Exception;
}
