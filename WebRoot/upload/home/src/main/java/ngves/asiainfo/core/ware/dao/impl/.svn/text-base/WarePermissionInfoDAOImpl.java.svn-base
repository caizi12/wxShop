/**
 * 
 */
package ngves.asiainfo.core.ware.dao.impl;

import java.util.HashMap;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.ware.bo.PermissionInfoEngine;
import ngves.asiainfo.core.ware.bo.PermissionRuleRltEngine;
import ngves.asiainfo.core.ware.bo.PermissionTypeInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOPermissionInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOPermissionRuleRltEngine;
import ngves.asiainfo.core.ware.bo.QBOPermissionWareRltEngine;
import ngves.asiainfo.core.ware.bo.WareInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareRltValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoValue;

/**
 * @author asiainfo
 *
 */
public class WarePermissionInfoDAOImpl implements IWarePermissionInfoDAO {

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#getPermissionInfoById(long)
	 */
	public IPermissionInfoValue getPermissionInfoById(long permissionId) throws Exception {
		return PermissionInfoEngine.getBean(permissionId);
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#getPermissionInfoValues(java.lang.String, java.util.Map)
	 */
	public IPermissionInfoValue[] getPermissionInfoValues(String condition, Map<String, String> parameters)
			throws Exception {
		return PermissionInfoEngine.getBeans(condition, parameters);
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#savePermissionInfoValue(ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue[])
	 */
	public void savePermissionInfoValue(IPermissionInfoValue[] values) throws Exception {
		PermissionInfoEngine.saveBatch(values);
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#savePermissionInfoValue(ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue)
	 */
	public long savePermissionInfoValue(IPermissionInfoValue value) throws Exception {
		PermissionInfoEngine.save(value);
		return value.getPermissionId();
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#savePermissionTypeInfo(ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue[])
	 */
	public void savePermissionTypeInfo(IPermissionTypeInfoValue[] values) throws Exception {
		PermissionTypeInfoEngine.saveBatch(values);
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#savePermissionTypeInfo(ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue)
	 */
	public void savePermissionTypeInfo(IPermissionTypeInfoValue value) throws Exception {
		PermissionTypeInfoEngine.save(value);
	}

	public IPermissionRuleRltValue[] getWarePermissionRltValues(String condition, Map<String, String> parameters)
			throws Exception {
		return PermissionRuleRltEngine.getBeans(condition, parameters);
	}

	public void saveWarePermissionRltValue(IPermissionRuleRltValue[] values) throws Exception {
		PermissionRuleRltEngine.saveBatch(values);
	}
	
	public void  mixPayBind(String permissionId,String wareid) throws Exception {
		IWareInfoValue wareInfo=WareInfoEngine.getBean(Long.parseLong(wareid));
		
		StringBuffer cond  =  new StringBuffer(" 1=1 ");
		Map<String,String> para = new HashMap<String,String>();
		cond.append(" and ").append(IPermissionRuleRltValue.S_PermissionId).append("=:").append(IPermissionRuleRltValue.S_PermissionId);
		para.put(IPermissionRuleRltValue.S_PermissionId, permissionId);
		IQBOPermissionInfoValue[] PermissionInfo=QBOPermissionInfoEngine.getBeans(cond.toString(), para);
		
		String perPayType=PermissionInfo[0].getPayType();
		String warePayType=wareInfo.getPayType();
		//礼品和优惠支付方式非交集 绑定失败
		if (warePayType.matches("^"+CoreConstant.PAY_TYPE_INTEGRAL+"$")) {
			if (perPayType.matches("^"+CoreConstant.PAY_TYPE_INTEGRAL_CASH+"$")) {
				throw new Exception("no jiaoJi");
			}
		}
		if (warePayType.matches("^"+CoreConstant.PAY_TYPE_INTEGRAL_CASH+"$")) {
			if (perPayType.matches("^"+CoreConstant.PAY_TYPE_INTEGRAL+"$")) {
				throw new Exception("no jiaoJi");
			}
		}
		//暂不校验优惠规则 支持 星级   与礼品支持星级交集
//		String[] supportStarLevels = WareDescUtil.getWareSupportStarLevel(Long.parseLong(wareid));
//		String perMobileBrandCode = PermissionInfo[0].getMobileBrandCode();
//		if(!checkSupportStarLevel(perMobileBrandCode, supportStarLevels)){
//			throw new Exception("no supportStarLevel jiaoJi");
//		}
		
		
		
		
		//优惠全积分>礼品全积分时 绑定失败
		if (warePayType.matches(CoreConstant.PAY_TYPE_INTEGRAL+".*")&&perPayType.matches(CoreConstant.PAY_TYPE_INTEGRAL+".*")) {
			boolean f=PermissionInfo[0].getWareGmeValue()>wareInfo.getWareIntegralValue();
			if (f) {
				throw new Exception("bigger wareIntegralValue");
			}
		}
		
		//活动的混合积分的现金或积分>礼品的混合积分的现金或积分时不能绑定
		if(warePayType.matches(".*"+CoreConstant.PAY_TYPE_INTEGRAL_CASH)&&perPayType.matches(".*"+CoreConstant.PAY_TYPE_INTEGRAL_CASH)){
			boolean bIntegral=PermissionInfo[0].getPayIntegral()>wareInfo.getPayIntegral();	
			if(bIntegral){
				throw new Exception("bigger bIntegral");
			}
			boolean bPayCash=PermissionInfo[0].getPayCash()>wareInfo.getPayCash();
			if(bPayCash){
				throw new Exception("bigger bPayCash");
			}
		}

		// 两种支付方式都支持时，优惠分值（全积分）< 优惠积分+现金积分部分
		// 绑定成功，但提示“礼品编码为[xxxxxx]的礼品优惠现金+积分价格的积分部分值大于优惠全积分值，您确认要这样配置吗？”
		if (perPayType.matches("" + CoreConstant.PAY_TYPE_INTEGRAL + "," + CoreConstant.PAY_TYPE_INTEGRAL_CASH)
				&& warePayType.matches("" + CoreConstant.PAY_TYPE_INTEGRAL + "," + CoreConstant.PAY_TYPE_INTEGRAL_CASH)) {
			if (PermissionInfo[0].getWareGmeValue() < PermissionInfo[0].getPayIntegral()) {
				throw new Exception("warning but true");
			}
		}
	}
	/**
	 * 校验优惠规则与礼品支持的星级是否有交集  暂不校验优惠规则 支持 星级   与礼品支持星级交集
	 * @param perMobileBrandCode
	 * @param supportStarLevels
	 * @return
	 
	private boolean checkSupportStarLevel(String perMobileBrandCode, String[] supportStarLevels) {
		String[] preMobileBrandCodes =perMobileBrandCode.split(",");
		for(int i=0;i<supportStarLevels.length;i++){
			for(int j=0;j<preMobileBrandCodes.length;j++){
				if(preMobileBrandCodes[j].equals(supportStarLevels[i])){
					return true;
				}
			}
		}
		return false;
	}
	*/
	public void saveWarePermissionRltValue(IPermissionRuleRltValue value) throws Exception {
		PermissionRuleRltEngine.save(value);
	}

	public IPermissionTypeInfoValue[] getWarePermissionTypeValues(String condition, Map<String, String> parameter)
			throws Exception {
		return PermissionTypeInfoEngine.getBeans(condition, parameter);
	}

	public int getPermissionRuleCount(String condition, Map<String, String> parameter) throws Exception {
		return QBOPermissionInfoEngine.getBeansCount(condition, parameter);
	}
	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#getPermissionRule(java.lang.String, java.util.Map)
	 */
	public IQBOPermissionInfoValue[] getPermissionRule(String condition, Map<String, String> parameter, int startNum, int endNum) throws Exception {
		
		return QBOPermissionInfoEngine.getBeans(null, condition, parameter, startNum, endNum, false);
	}

	public IQBOPermissionInfoValue[] getQBOPermissionInfoValues(String condition, Map<String, String> parameter,int startIndex,int endIndex)
			throws Exception {
		IQBOPermissionInfoValue[] values = QBOPermissionInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex,false);
		return values;
	}

	public IPermissionTypeInfoValue[] getWarePermissionTypeValuesById(long permissionId) throws Exception {
		IPermissionTypeInfoValue[] typeValues = null;
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		condition.append(" and ").append(IPermissionTypeInfoValue.S_PermissionId).append("=:").append(IPermissionTypeInfoValue.S_PermissionId);
		
		parameter.put(IPermissionTypeInfoValue.S_PermissionId, String.valueOf(permissionId));
		typeValues = this.getWarePermissionTypeValues(condition.toString(), parameter);
		
		return typeValues;
	}

	public int getQBOPermissionWareRltCount(String condition, Map<String, String> parameter) throws Exception {
		return QBOPermissionWareRltEngine.getBeansCount(condition, parameter);
	}

	public IQBOPermissionWareRltValue[] getQBOPermissionWareRltValues(String condition, Map<String, String> parameter,
			int startIndex, int endIndex) throws Exception {
		IQBOPermissionWareRltValue[] values = QBOPermissionWareRltEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
		return values;
	}

	public IPermissionRuleRltValue getPermissionRuleRltValue(long id) throws Exception {
		IPermissionRuleRltValue value =  PermissionRuleRltEngine.getBean(id);
		return value;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO#queryPermissionWareRlt(java.lang.String, java.util.Map)
	 */
	public IQBOPermissionRuleRltValue[] queryQBOPermissionRuleRlt(String condition, Map<String, String> parameters) throws Exception {
		return QBOPermissionRuleRltEngine.getBeans(condition, parameters);
	}

}
