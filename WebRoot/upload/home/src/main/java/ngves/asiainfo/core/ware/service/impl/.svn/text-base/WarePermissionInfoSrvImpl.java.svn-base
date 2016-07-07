/**
 * 
 */
package ngves.asiainfo.core.ware.service.impl;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoDetailBean;
import ngves.asiainfo.core.common.bo.BusiInfoDetailEngine;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.ivalues.IBusiInfoDetailValue;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.bo.PermissionInfoBean;
import ngves.asiainfo.core.ware.bo.PermissionInfoEngine;
import ngves.asiainfo.core.ware.bo.PermissionRuleRltBean;
import ngves.asiainfo.core.ware.bo.PermissionRuleRltEngine;
import ngves.asiainfo.core.ware.bo.PermissionTypeInfoBean;
import ngves.asiainfo.core.ware.bo.PermissionTypeInfoEngine;
import ngves.asiainfo.core.ware.bo.QBOPermissionInfoBean;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePermissionInfoDAO;
import ngves.asiainfo.core.ware.exception.WarePermissionConException;
import ngves.asiainfo.core.ware.ivalues.IPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IPermissionTypeInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionRuleRltValue;
import ngves.asiainfo.core.ware.ivalues.IQBOPermissionWareRltValue;
import ngves.asiainfo.core.ware.model.PermissionInfoVOBean;
import ngves.asiainfo.core.ware.service.interfaces.IWarePermissionInfoSrv;
import ngves.asiainfo.core.ware.util.PermissionInfoUtil;
import ngves.asiainfo.core.ware.util.WareCommonUtil;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author asiainfo
 *
 */
public class WarePermissionInfoSrvImpl implements IWarePermissionInfoSrv{

	private static Log log = LogFactory.getLog(WarePermissionInfoSrvImpl.class);

	private IWarePermissionInfoDAO warePermissionInfoDAO;
	
	public void setWarePermissionInfoDAO(IWarePermissionInfoDAO warePermissionInfoDAO) throws Exception {
		this.warePermissionInfoDAO =  warePermissionInfoDAO;
	}

	public void deleteWarePermissionInfoValue(long permissionId,long staffId,String comType,long orgId) throws Exception {
		// 根据规则ID删除礼品规则的信息
		log.info("删除促销规则信息。。。");
		//1、判断是否可以删除数据
		boolean isBinded = isRuleBindingWare(permissionId);
	
		if(!isBinded){
			log.info("没有绑定礼品信息，可以删除");
			//2、删除permission_info表的信息
			IPermissionInfoValue value = warePermissionInfoDAO.getPermissionInfoById(permissionId);
			if(null != value){
				value.delete();
				warePermissionInfoDAO.savePermissionInfoValue(value);
			}
			//3、删除permission_type_info的信息
			delPermissionTypeValuesById(permissionId);
			//记录日志
			long busiId = BusiInfoEngine.getNewId().longValue();
			//记录概要信息
			//String busiId, String busiTypeId, long staffId, String note, String opt_type, String opt_obj,long StaffId,String ComType,long OrgId
			BusiInfoUtil.recordBusiInfo(busiId + "",
					CoreConstant.SYS_PARA_BUSI_TYPE_DELETE_PERMISSION, 
					staffId , "删除优惠兑换资格："+value.getPermissionName(),
					"",
					"优惠兑换资格名称："+value.getPermissionName() +" 优惠兑换资格ID："+permissionId ,
					staffId,
					comType,
					orgId);;

			log.info("删除成功...");
		}else{
			throw new Exception();
		}
		log.info("删除促销规则信息结束。。。");

	}


	public long saveWarePermissionInfoValue(IPermissionInfoValue value, IPermissionTypeInfoValue[] typeValues,long staffId,String comType,long orgId)
			throws Exception {

		log.info("===新增优惠兑换校验规则信息====");
		//保存优惠兑换资格规则的信息
		
		
		
		log.info("1、保存基本信息，存储在permission_info表中");
		//1、保存基本信息，存储在permission_info表中
		IPermissionInfoValue permissionInfoValue = new PermissionInfoBean();
		permissionInfoValue.copy(value);
		permissionInfoValue.setPermissionId(PermissionInfoEngine.getNewId().longValue());
		long permissionInfoId = warePermissionInfoDAO.savePermissionInfoValue(permissionInfoValue);
		//2、保存适用的礼品信息，存储在permission_type_info表中
		
		if(null != typeValues && typeValues.length > 0 ){
			log.info("有适合省份/小类/礼品商/特殊礼品的信息");
			//建议不更改传入的参数数值，重新定义对象
			IPermissionTypeInfoValue[] tmp = new PermissionTypeInfoBean[typeValues.length];
			for(int i=0;i<typeValues.length;i++){
				tmp[i] = new PermissionTypeInfoBean();
				tmp[i].setPermissionId(permissionInfoId);
				tmp[i].setPermissionCode(typeValues[i].getPermissionCode());
				tmp[i].setPermissionName(typeValues[i].getPermissionName());
				tmp[i].setPermissionTypeId(PermissionTypeInfoEngine.getNewId().longValue());
				
			}
			
			log.info("开始保存适合省份/小类/礼品商/特殊礼品的信息...");
			warePermissionInfoDAO.savePermissionTypeInfo(tmp);
			log.info("保存适合省份/小类/礼品商/特殊礼品的信息成功！");

		}
		long busiId = BusiInfoEngine.getNewId().longValue();
		//记录概要信息
		//String busiId, String busiTypeId, long staffId, String note, String opt_type, String opt_obj,long StaffId,String ComType,long OrgId
		BusiInfoUtil.recordBusiInfo(busiId + "",
				CoreConstant.SYS_PARA_BUSI_TYPE_NEW_PERMISSION, 
				staffId , 
				"新增优惠兑换资格",
				"",
				"优惠兑换资格名称："+value.getPermissionName()+",规则的ID："+permissionInfoId,
				staffId,
				comType,
				orgId);

		//3、返回当前规则的ID，有必要吗？
		return permissionInfoId;
	}


	public long updateWarePermissionInfoValue(IPermissionInfoValue value, IPermissionTypeInfoValue[] typeValues,long staffId,String comType,long orgId)
			throws Exception {
		log.info("更新规则信息开始....");
	
		//1、更新规则的基本信息 
		
		IPermissionInfoValue permissionValue =  new PermissionInfoBean();
		//获得规则的创建时间
		IPermissionInfoValue tmp =  warePermissionInfoDAO.getPermissionInfoById(value.getPermissionId());
		
		
		//记录该条记录的先前数值
		//IQBOPermissionInfoValue oldBean = new QBOPermissionInfoBean();
		//oldBean.
		permissionValue.setPermissionId(value.getPermissionId());
		permissionValue.setStsToOld();
		//更新时间为创建时间
		permissionValue.setCretaeTime(tmp.getCretaeTime());
		permissionValue.setPermissionName(value.getPermissionName());
		permissionValue.setExchangeChannel(value.getExchangeChannel());
		permissionValue.setItemScope(value.getItemScope());
		permissionValue.setSupportType(value.getSupportType());
		permissionValue.setWareGmeValue(value.getWareGmeValue());
		if(value.getMaxItemNum() != 0){
			permissionValue.setMaxItemNum(value.getMaxItemNum());
		}else{
			permissionValue.setMaxItemNumNull();
		}
		if(value.getMaxTimes() != 0){
			permissionValue.setMaxTimes(value.getMaxTimes());
		}else{
			permissionValue.setMaxTimesNull();
		}
		permissionValue.setMobileBrandCode(value.getMobileBrandCode());
		permissionValue.setOrderEndTime(value.getOrderEndTime());
		permissionValue.setOrderStartTime(value.getOrderStartTime());
		permissionValue.setOrderNum(value.getOrderNum());
		permissionValue.setOrderStatus(value.getOrderStatus());
		permissionValue.setOrderScope(value.getOrderScope());
		// added by 满足复杂资格判定的优惠礼品短信推广 2012/09/11 
    	//是否支持优惠礼品短信推广
		permissionValue.setIsSpread(value.getIsSpread());
		
		permissionValue.setPayType(value.getPayType());
		permissionValue.setPayIntegral(value.getPayIntegral());
		permissionValue.setPayCash(value.getPayCash());
		
		log.info("permissionValue 数值为"+permissionValue);
		long id = warePermissionInfoDAO.savePermissionInfoValue(permissionValue);
		
		//2、更新礼品校验规则表的基本信息 permission_type_info.
		//Q1 是选择更新操作，还是选择删除后再次新增？
		//A1 由于是分开写入数据库，所以这里选择全部是删除，然后再次新增。
		
		//删除permission_type_info中的数据
		StringBuffer condition  = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		if(0 != value.getPermissionId()){
			condition.append(" and ").append(IPermissionTypeInfoValue.S_PermissionId).append("=:").append(IPermissionTypeInfoValue.S_PermissionId);
			parameter.put(IPermissionTypeInfoValue.S_PermissionId, String.valueOf(value.getPermissionId()));
		}
		IPermissionTypeInfoValue [] delValues = warePermissionInfoDAO.getWarePermissionTypeValues(condition.toString(), parameter);
		//删除这些数据
		
		if(null != delValues && delValues.length > 0){
			log.info("正在删除数据。。。等待新增。。。");
			for(int i=0;i<delValues.length;i++){
				//做删除标记
				delValues[i].delete();
			}
			//进行删除
			warePermissionInfoDAO.savePermissionTypeInfo(delValues);
		}

		//新增这些新的数据
		if(null != typeValues && typeValues.length > 0 ){
			log.info("新增数据，有适合省份/小类/礼品商/特殊礼品的信息");
			for(int i=0;i<typeValues.length;i++){
				typeValues[i].setStsToNew();
				typeValues[i].setPermissionId(id);
				typeValues[i].setPermissionCode(typeValues[i].getPermissionCode());
				typeValues[i].setPermissionName(typeValues[i].getPermissionName());
				typeValues[i].setPermissionTypeId(PermissionTypeInfoEngine.getNewId().longValue());
			}
			log.info("开始保存适合省份/小类/礼品商/特殊礼品的信息...");
			warePermissionInfoDAO.savePermissionTypeInfo(typeValues);
			log.info("保存适合省份/小类/礼品商/特殊礼品的信息成功！");
		}
		
		//判断是否有礼品绑定，如果有则同步给HP
		boolean isBinded = isRuleBindingWare(value.getPermissionId());
    	if(isBinded){
    		IQBOPermissionRuleRltValue[] qboPermissionRuleRltValues = queryQBOPermissionRuleRlt(value.getPermissionId());
    		for (IQBOPermissionRuleRltValue values:qboPermissionRuleRltValues) {
				PermissionInfoUtil.updatePermissionWareRlt(value.getPermissionId(), values.getWareId(), values.getActionStartTime().toString(),
						values.getActionEndTime().toString(), WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_MODIFY, values.getPermissionId(), values.getWareId());
			}
    	}
		
		//记录日志
		
		
		
		//Q2 这部分日志如何记录，有难度呀？删除又新增，这样更新的日志怎么记录呀？？？
		//A2 不知道,这种粒子性的东西，根本没法记录嘛。。。
		
		
		//2012年8月14日 就是没办法记录日志呀！！！
		//本次操作的日志流水记录
		long busiId = BusiInfoEngine.getNewId().longValue();
		
		//记录概要信息
		//String busiId, String busiTypeId, long staffId, String note, String opt_type, String opt_obj,long StaffId,String ComType,long OrgId
		BusiInfoUtil.recordBusiInfo(busiId + "",
				CoreConstant.SYS_PARA_BUSI_TYPE_MODIFY_PERMISSION, 
				staffId , 
				"修改优惠兑换资格",
				CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
				"优惠兑换资格名称："+value.getPermissionName()+",规则的ID："+value.getPermissionId(),
				staffId,
				comType,
				orgId);;

		
		//记录详情
        BusiInfoUtil.recordBusiDetail(busiId + "", new Object[]{tmp}, new Object[]{permissionValue}, "PermissionId");

       
        List<String> oldList = getCodeByArrays(delValues);
        List<String> newList = getCodeByArrays(typeValues);
        String[] codeView = {"礼品小类","礼品所属礼品商","礼品编码","省份编码"};
        //神马，程序中惊现三目运算符
        for(int i=0;i<((oldList.size()>newList.size())?oldList.size():newList.size());i++){
        	//只要有一个不为空，那么会进行比较
        	if(!StringUtil.isBlank((String)(oldList.get(i))) || !StringUtil.isBlank((String)(newList.get(i)))){
        		//两个字符串不相等
        		if(!WareCommonUtil.compareArrayStrSame((String)(oldList.get(i)),(String)(newList.get(i)))){
        			IBusiInfoDetailValue detailValue = new BusiInfoDetailBean();
        			detailValue.setBusiId(busiId);
        			detailValue.setBeforeValue((String)(oldList.get(i)));
        			detailValue.setAfterValue((String)(newList.get(i)));
        			detailValue.setFieldName(codeView[i]);
        			detailValue.setMainFldName("PERMISSION_ID");
        			detailValue.setMainFldValue(String.valueOf(value.getPermissionId()));
        			//这四个字段被映射到这个 PERMISSION_INFO表中吗？
        			detailValue.setBusiTable("PermissionInfo");
        			detailValue.setDetailId(BusiInfoDetailEngine.getNewId().longValue());
        			BusiInfoUtil.recordBusiDetail(detailValue);
        			
        		}
        	}
        	//两个都为空，没必要进行比较
        }
        //记录其他的数值变化
        BusiInfoUtil.recordBusiDetail(busiId + "", new Object[]{delValues}, new Object[]{typeValues}, "PermissionTypeId");
		
		log.info("更新规则信息结束....");

		
    	
		return value.getPermissionId();
	}

	
	
	/**
	 * 根据数组中的元素，获得四个type的数据内容
	 * @param values
	 * @return
	 */
	private List<String> getCodeByArrays(IPermissionTypeInfoValue[] values){
		List<String> list  = new ArrayList<String>();
		
		StringBuffer subKindBuffer = new StringBuffer();
		StringBuffer partnerCodeBuffer = new StringBuffer();
		StringBuffer wareCodeBuffer = new StringBuffer();
		StringBuffer provinceCodeBuffer = new StringBuffer();
		
		String subKind = "";
		String partnerCode = "";
		String wareCode  ="";
		String provinceCode ="";
		if(null!=values && values.length > 0 ){
			for( int i=0;i< values.length;i++){
		
				if(WareConstant.SYS_PERMISSION_TYPE_CODE_SUBKINDCODE.equals(values[i].getPermissionName())){
					//礼品小类
					subKindBuffer.append(values[i].getPermissionCode()).append(",");
				}else if(WareConstant.SYS_PERMISSION_TYPE_CODE_PARTNERCODE.equals(values[i].getPermissionName())){
					//礼品所属合作商
					partnerCodeBuffer.append(values[i].getPermissionCode()).append(",");
				}else if(WareConstant.SYS_PERMISSION_TYPE_CODE_WARECODE.equals(values[i].getPermissionName())){
					wareCodeBuffer.append(values[i].getPermissionCode()).append(",");
					//礼品编码
				}else if(WareConstant.SYS_PERMISSION_TYPE_CODE_PROVINCECODE.equals(values[i].getPermissionName())){
					//省编码
					provinceCodeBuffer.append(values[i].getPermissionCode()).append(",");
				}
			}
		}
		subKind = subKindBuffer.toString();
		partnerCode = partnerCodeBuffer.toString();
		wareCode = wareCodeBuffer.toString();
		provinceCode = provinceCodeBuffer.toString();
		
		if(!StringUtil.isBlank(subKind) && ','== subKind.charAt(subKind.length()-1)){
			subKind = subKind.substring(0, subKind.length()-1);
		}
		if(!StringUtil.isBlank(partnerCode) && ','== partnerCode.charAt(partnerCode.length()-1)){
			partnerCode = partnerCode.substring(0, partnerCode.length()-1);
		}
		if(!StringUtil.isBlank(wareCode) && ','== wareCode.charAt(wareCode.length()-1)){
			wareCode = wareCode.substring(0, wareCode.length()-1);
		}
		if(!StringUtil.isBlank(provinceCode) && ','== provinceCode.charAt(provinceCode.length()-1)){
			provinceCode = provinceCode.substring(0, provinceCode.length()-1);
		}
		list.add(subKind);
		list.add(partnerCode);
		list.add(wareCode);
		list.add(provinceCode);
		return list;
	}
	
	/**
	 * 
	 * @param ruleIds
	 * @return
	 * @throws Exception
	 */
	public boolean isRuleBindingWare(long ruleId) throws Exception{
		boolean isBinding = false;
		IQBOPermissionRuleRltValue[] values = queryQBOPermissionRuleRlt(ruleId);
		if(null != values && values.length > 0){
			//有关联该规则的礼品信息，无论正在生效的还是失效的。
			log.info("该规则"+ruleId +" ,有绑定的礼品信息呀，在permission_rule_rlt表中,数量为"+values.length);
			isBinding = true;
		}
		return isBinding;
	}
	
	protected void delPermissionTypeValuesById(long permissionId) throws Exception{
		//查询出该规则ID permissionId 对应在type表中数据
		StringBuffer condition  = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		if(0 != permissionId){
			condition.append(" and ").append(IPermissionTypeInfoValue.S_PermissionId).append("=:").append(IPermissionTypeInfoValue.S_PermissionId);
			parameter.put(IPermissionTypeInfoValue.S_PermissionId, String.valueOf(permissionId));
		}
		IPermissionTypeInfoValue [] delValues = warePermissionInfoDAO.getWarePermissionTypeValues(condition.toString(), parameter);
		//删除这些数据
		
		if(null != delValues && delValues.length > 0){
			log.info("正在删除数据。。。等待新增。。。");
			for(int i=0;i<delValues.length;i++){
				//做删除标记
				delValues[i].delete();
			}
			//进行删除
			warePermissionInfoDAO.savePermissionTypeInfo(delValues);
		}
	}
	@SuppressWarnings("unchecked")
	public int getPermissionRuleCount(String permissionName, String wareGMEValue,
			String exchangeChannel, String mobileBrandCode, String itemScope,String orderStatus,String orderScope) throws Exception {
		List tmpList = getPermissionRuleSQL(permissionName,wareGMEValue,exchangeChannel,mobileBrandCode,itemScope,orderStatus,orderScope);
		StringBuffer condition = (StringBuffer)tmpList.get(0);
		Map<String,String> parameter = (Map<String,String>)tmpList.get(1);
		int count = warePermissionInfoDAO.getPermissionRuleCount(condition.toString(), parameter);
		
		return count;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.service.interfaces.IWarePermissionInfoSrv#getPermissionRule(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public IQBOPermissionInfoValue[] getPermissionRule(String permissionName, String wareGMEValue,
			String exchangeChannel, String mobileBrandCode, String itemScope,String orderStatus,String orderScope, int startNum, int endNum) throws Exception {
		
		List tmpList = getPermissionRuleSQL(permissionName,wareGMEValue,exchangeChannel,mobileBrandCode,itemScope,orderStatus,orderScope);
		StringBuffer condition = (StringBuffer)tmpList.get(0);
		Map<String,String> parameter = (Map<String,String>)tmpList.get(1);
		
		condition.append(" order by "+IQBOPermissionInfoValue.S_CretaeTime +" desc");
		IQBOPermissionInfoValue[] values = warePermissionInfoDAO.getPermissionRule(condition.toString(), parameter, startNum, endNum);
		String viewValue = null;
		for (int i = 0; i < values.length; i++) {
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getExchangeChannel(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", ",","PARA_TYPE_ID='1051'");
			values[i].setExchangeChannel(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getMobileBrandCode(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", ",","PARA_TYPE_ID='13'");
			values[i].setMobileBrandCode(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getProviceCode(), "cm_province_info", "province_code", "province_name", ",", "，","");
			values[i].setProvinceView(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getSubkindCode(), "ware_kind", "kind_code", "kind_name", ",", "，","");
			values[i].setSubkindView(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getPartnerCode(), "PARTNER_INFO", "PARTNER_CODE", "PARTNER_NAME", ",", "，","");
			values[i].setPartnerView(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getWareCode(), "WARE_INFO", "WARE_CODE", "WARE_NAME", ",", "，","");
			values[i].setWareView(viewValue);
			// 订单范围
			viewValue = WareCommonUtil.getViewNameByCode(values[i].getOrderScope(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", ",","PARA_TYPE_ID='900000000000012'");
			values[i].setOrderScope(viewValue);
			viewValue = null;
		
			//混合支付
			String payType=values[i].getPayType();
			if (payType.matches(".*"+CoreConstant.PAY_TYPE_INTEGRAL_CASH)) {
				//02或01,02方式
				
				//仅02情况
				if (payType.matches("^"+CoreConstant.PAY_TYPE_INTEGRAL_CASH+"$")) {
					values[i].setBakCol2("现金+积分");
				}else {
					//01,02方式
					values[i].setBakCol2("全积分，现金+积分");
				}	
				double dPayCash=values[i].getPayCash()/100.0;
				DecimalFormat df = new DecimalFormat("0.##");
				values[i].setBakCol1(df.format(dPayCash)+"元+"+String.valueOf(values[i].getPayIntegral()+"积分"));
			}else {
				//仅01情况
				values[i].setBakCol2("全积分");
			}
		}
		return fillHTMLOperationField(values);
	}
	@SuppressWarnings("unchecked")
	private List getPermissionRuleSQL(String permissionName, String wareGMEValue,
			String exchangeChannel, String mobileBrandCode, String itemScope,String orderStatus,String orderScope){
		List tmpList = new ArrayList();
		StringBuffer condition  = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		if(!StringUtil.isBlank(permissionName)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_PermissionName).append(" like :").append(IQBOPermissionInfoValue.S_PermissionName);
			parameter.put(IQBOPermissionInfoValue.S_PermissionName, "%"+permissionName+"%");
		}
		if(!StringUtil.isBlank(wareGMEValue)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_WareGmeValue).append(" = :").append(IQBOPermissionInfoValue.S_WareGmeValue);
			parameter.put(IQBOPermissionInfoValue.S_WareGmeValue, wareGMEValue);
		}
		if(!StringUtil.isBlank(exchangeChannel) && !"-1".equals(exchangeChannel)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_ExchangeChannel).append(" like :").append(IQBOPermissionInfoValue.S_ExchangeChannel);
			parameter.put(IQBOPermissionInfoValue.S_ExchangeChannel, "%"+exchangeChannel+"%");
		}
		if(!StringUtil.isBlank(mobileBrandCode) && !"-1".equals(mobileBrandCode)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_MobileBrandCode).append(" like :").append(IQBOPermissionInfoValue.S_MobileBrandCode);
			parameter.put(IQBOPermissionInfoValue.S_MobileBrandCode, "%"+mobileBrandCode+"%");
		}
		if(!StringUtil.isBlank(itemScope) && !"-1".equals(itemScope)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_ItemScope).append(" = :").append(IQBOPermissionInfoValue.S_ItemScope);
			parameter.put(IQBOPermissionInfoValue.S_ItemScope, itemScope);
		}
		if(!StringUtil.isBlank(orderStatus)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_OrderStatus).append("=:").append(IQBOPermissionInfoValue.S_OrderStatus);
			parameter.put(IQBOPermissionInfoValue.S_OrderStatus, orderStatus);
		}
		if(!StringUtil.isBlank(orderScope)){
			condition.append(" AND "+IQBOPermissionInfoValue.S_OrderScope).append(" like '");
			String[] scopes = orderScope.trim().split(CoreConstant.STRING_SPLIT_COMMA);
			for(int i = 0;i<scopes.length;i++){
				condition.append("%"+scopes[i]);
			}
			condition.append("%'");
		}
		tmpList.add(condition);
		tmpList.add(parameter);
		return tmpList;
	}


	/**
     *  优惠规则链接的模板
     */
    public static final String MODIFY_PERMISSION_INFO_LINK = "<a href='javascript:editPermissionInfo(%s)'>编辑"+ "</a>";
    public static final String DELETE_PERMISSION_INFO_LINK = "<a href='javascript:deletePermissionInfo(%s)'>删除"+ "</a>";
    
	/**
	 * @param values
	 * @throws Exception 
	 */
	private IQBOPermissionInfoValue[] fillHTMLOperationField(IQBOPermissionInfoValue[] values) throws Exception {
		for(IQBOPermissionInfoValue value: values){
			StringBuffer sb = new StringBuffer();
			sb.append(String.format(MODIFY_PERMISSION_INFO_LINK, value.getPermissionId()));
			sb.append("&nbsp;&nbsp;");
			sb.append(String.format(DELETE_PERMISSION_INFO_LINK, value.getPermissionId()));
			value.setOperField(sb.toString());
        }
        return values;
    }

	public IQBOPermissionInfoValue[] queryPermissionInfoValues(String ruleName, String wareGMEValue,
			String supportType, String exchangeChannel, String brandCode, String itemScope,int startIndex,int endIndex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPermissionInfoJsonById(long permissionId) throws Exception {
		String json = null;
		//1、根据ID，获得规则的基本信息 Permission_info数据表中信息
		
		IPermissionInfoValue permissionInfoValue = warePermissionInfoDAO.getPermissionInfoById(permissionId);
//		//2、根据ID，获得规则类别表中信息 permission_type_info数据表中信息
//		
//		IPermissionTypeInfoValue[] typeValues = warePermissionInfoDAO.getWarePermissionTypeValuesById(permissionId);
		
		IQBOPermissionInfoValue[] values = warePermissionInfoDAO.getPermissionRule(IQBOPermissionInfoValue.S_PermissionId+"="+permissionId,null, -1,-1);
		
		IQBOPermissionInfoValue infoValue = new QBOPermissionInfoBean();
		
		if(values != null && values.length>0){
			infoValue = values[0];
			String viewValue = null;
			viewValue = WareCommonUtil.getViewNameByCode(infoValue.getProviceCode(), "cm_province_info", "province_code", "province_name", ",", "，","");
			infoValue.setProvinceView(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(infoValue.getSubkindCode(), "ware_kind", "kind_code", "kind_name", ",", "，","");
			infoValue.setSubkindView(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(infoValue.getPartnerCode(), "PARTNER_INFO", "PARTNER_CODE", "PARTNER_NAME", ",", "，","");
			infoValue.setPartnerView(viewValue);
			viewValue = WareCommonUtil.getViewNameByCode(infoValue.getWareCode(), "WARE_INFO", "WARE_CODE", "WARE_NAME", ",", "，","");
			infoValue.setWareView(viewValue);
			viewValue = null;
		}
		//3、将所得到的信息转换成为PermissionWareBean
		PermissionInfoVOBean  bean = new PermissionInfoVOBean();

		//	3.1 规则基本信息对象
		//log.info("infoValue.getCretaeTime()" +infoValue.getCretaeTime());
		//log.info("infoValue.getOrderEndTime()" +infoValue.getOrderEndTime());
		//log.info("infoValue.getOrderStartTime()" +infoValue.getOrderStartTime());
		bean.setCreateTime(DateTimeUtil.timeStampToString(infoValue.getCretaeTime(),"yyyy-MM-dd HH:mm:ss"));
		bean.setExchangeChannel(infoValue.getExchangeChannel());
		bean.setItemScope(infoValue.getItemScope());
		bean.setMaxItemNum(infoValue.getMaxItemNum());
		bean.setMaxTimes(infoValue.getMaxTimes());
		bean.setMobileBrandCode(infoValue.getMobileBrandCode());
		//bean.setOptType(infoValue.getOptType());
		bean.setOrderEndTime(DateTimeUtil.timeStampToString(infoValue.getOrderEndTime(),"yyyy-MM-dd HH:mm:ss"));
		bean.setOrderNum(infoValue.getOrderNum());
		bean.setOrderStartTime(DateTimeUtil.timeStampToString(infoValue.getOrderStartTime(),"yyyy-MM-dd HH:mm:ss"));
		bean.setOrderStatus(infoValue.getOrderStatus());
		bean.setPermissionId(infoValue.getPermissionId());
		bean.setPermissionName(infoValue.getPermissionName());
		bean.setSupportType(infoValue.getSupportType());
		bean.setWareGmeValue(infoValue.getWareGmeValue());

		bean.setRuleProvince(infoValue.getProviceCode());
		bean.setRuleSubKind(infoValue.getSubkindCode());
		bean.setRulePartnerCode(infoValue.getPartnerCode());
		bean.setRuleWareCode(infoValue.getWareCode());
		
		bean.setRuleProvinceView(infoValue.getProvinceView());
		bean.setRuleSubKindView(infoValue.getSubkindView());
		bean.setRulePartnerCodeView(infoValue.getPartnerView());
		bean.setRuleWareCodeView(infoValue.getWareView());
		
		bean.setIsSpread(permissionInfoValue.getIsSpread());
		
		//混合支付新增字段
		bean.setPayType(permissionInfoValue.getPayType());
		bean.setPayIntegral(permissionInfoValue.getPayIntegral());
		bean.setPayCash(permissionInfoValue.getPayCash());
		// 订单范围
		bean.setOrderScopeView(permissionInfoValue.getOrderScope());
		//4、将PermissionWareBean 转换成为json格式数据 ，返回到Action层
		
		json = bean.toJson();
		log.info("获得的json数据为：" +json);
		return json;
	}

	public boolean isExistPermissionRuleName(String permissionRuleName) throws Exception {
		//1、根据输入的名称，查询数据库
		
		boolean isExistName = false;
		//TODO 输入的参数需要trim处理
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		if(!StringUtil.isBlank(permissionRuleName)){
			condition.append(" and ").append(IPermissionInfoValue.S_PermissionName).append("=:").append(IPermissionInfoValue.S_PermissionName);
			
			parameter.put(IPermissionInfoValue.S_PermissionName, permissionRuleName);
		}
		IPermissionInfoValue[] values = warePermissionInfoDAO.getPermissionInfoValues(condition.toString(), parameter);
		
		if(null != values && values.length > 0){
			isExistName = true;
		}
		return isExistName;
	}

	@SuppressWarnings("unchecked")
	public int queryPermissionWareRltCount(String partner_id, String ware_brand_id, String ware_first_kind_id,
			String ware_kind_parent_id, String ware_kind_id, String beg_time, String end_time, String ware_status,
			String ware_name, String ware_code, String permissionId,String mobile_code,String province_code,String wareKindInfoId) throws Exception {
 
		List list = getQueryCondition(partner_id, ware_brand_id, ware_first_kind_id,
				ware_kind_parent_id, ware_kind_id, beg_time, end_time, ware_status,
				ware_name, ware_code, permissionId,mobile_code,province_code,wareKindInfoId);
		String condition = (String)list.get(0);
		Map<String,String> parameter = (Map<String,String>)list.get(1);
		return 	warePermissionInfoDAO.getQBOPermissionWareRltCount(condition, parameter);
	}

	@SuppressWarnings("unchecked")
	public IQBOPermissionWareRltValue[] queryPermissionWareRltValues(String partner_id, String ware_brand_id,
			String ware_first_kind_id, String ware_kind_parent_id, String ware_kind_id, String beg_time,
			String end_time, String ware_status, String ware_name, String ware_code, String permissionId,String mobile_code,
			String province_code,String wareKindInfoId,int startIndex, int endIndex) throws Exception {
		List list = getQueryCondition(partner_id, ware_brand_id, ware_first_kind_id,
				ware_kind_parent_id, ware_kind_id, beg_time, end_time, ware_status,
				ware_name, ware_code, permissionId,mobile_code,province_code,wareKindInfoId);
		String condition = (String)list.get(0);
		Map<String,String> parameter = (Map<String,String>)list.get(1);
		
		IQBOPermissionWareRltValue [] values = warePermissionInfoDAO.getQBOPermissionWareRltValues(condition, parameter, startIndex, endIndex);
		
		if(null != values){
			for(int i=0;i<values.length;i++){
				//去除该字段中的逗号中的空
				String mobileCode =values[i].getMobileCode();
				StringBuilder sb = new StringBuilder();
				if(StringUtil.isNotBlank(mobileCode)){
					String[] mobileCodes = mobileCode.split(",");
					for(int j=0;j<mobileCodes.length;j++){
						if(StringUtil.isNotBlank(mobileCodes[j])){
							if(sb.length()!=0){
								sb.append(",");
							}
							sb.append(mobileCodes[j]);
						}
					}
				}
				
				values[i].setMobileCodeView(WareCommonUtil.getViewNameByCode(sb.toString(), "SYS_PARA_DATA", "PARA_CODE", "PARA_NAME", ",", ",","PARA_TYPE_ID='13'"));
			}
		}
		return values;
	}
	
	@SuppressWarnings("unchecked")
	private List getQueryCondition(String partner_id, String ware_brand_id, String ware_first_kind_id,
			String ware_kind_parent_id, String ware_kind_id, String beg_time, String end_time, String ware_status,
			String ware_name, String ware_code, String permissionId,String mobile_code,String province_code,String wareKindInfoId){
		
		List list = new ArrayList();
		
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		if(!StringUtil.isBlank(mobile_code) && !"-1".equals(mobile_code)){
			condition.append(" AND "+IQBOPermissionWareRltValue.S_MobileCode).append(" like :").append(IQBOPermissionWareRltValue.S_MobileCode);
			parameter.put(IQBOPermissionWareRltValue.S_MobileCode, "%"+mobile_code+"%");
		}
		//不查询无效的记录
		//condition.append(" and ("+IQBOPermissionWareRltValue.S_BindStatus).append("<>").append("'0'").append(" or "+IQBOPermissionWareRltValue.S_BindStatus).append(" is null ");
		//不为空，并且不为-1
		if(!StringUtil.isBlank(partner_id) && !"-1".equals(partner_id)){
			log.debug(" partner ID "+partner_id);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_PartnerId).append("=:").append(IQBOPermissionWareRltValue.S_PartnerId);
			parameter.put(IQBOPermissionWareRltValue.S_PartnerId, partner_id);
		}
		if(!StringUtil.isBlank(ware_brand_id) && !"-1".equals(ware_brand_id)){
			log.debug(" S_WareBrandId "+ware_brand_id);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareBrandId).append("=:").append(IQBOPermissionWareRltValue.S_WareBrandId);
			parameter.put(IQBOPermissionWareRltValue.S_WareBrandId, ware_brand_id);
		}
		
		if(!StringUtil.isBlank(ware_brand_id) && !"-1".equals(ware_brand_id)){
			log.debug(" S_WareBrandId "+ware_brand_id);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareBrandId).append("=:").append(IQBOPermissionWareRltValue.S_WareBrandId);
			parameter.put(IQBOPermissionWareRltValue.S_WareBrandId, ware_brand_id);
		}
		
		//TODO 客户品牌项目有待确认
		
		if(!StringUtil.isBlank(ware_first_kind_id) && !"-1".equals(ware_first_kind_id)){
			log.debug(" ware_first_kind_id "+ware_first_kind_id);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareFirstKindId).append("=:").append(IQBOPermissionWareRltValue.S_WareFirstKindId);
			parameter.put(IQBOPermissionWareRltValue.S_WareFirstKindId, ware_first_kind_id);
		}
		
		if(!StringUtil.isBlank(ware_kind_parent_id) && !"-1".equals(ware_kind_parent_id)){
			log.debug(" ware_kind_parent_id "+ware_kind_parent_id);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareKindParentId).append("=:").append(IQBOPermissionWareRltValue.S_WareKindParentId);
			parameter.put(IQBOPermissionWareRltValue.S_WareKindParentId, ware_kind_parent_id);
		}
		
		if(!StringUtil.isBlank(ware_kind_id) && !"-1".equals(ware_kind_id)){
			log.debug(" ware_kind_id "+ware_kind_id);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareKindId).append("=:").append(IQBOPermissionWareRltValue.S_WareKindId);
			parameter.put(IQBOPermissionWareRltValue.S_WareKindId, ware_kind_id);
		}
		if(!StringUtil.isBlank(wareKindInfoId) && !"-1".equals(wareKindInfoId)){
			log.debug(" wareKindInfoId "+wareKindInfoId);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareKindInfoId).append("=:").append(IQBOPermissionWareRltValue.S_WareKindInfoId);
			parameter.put(IQBOPermissionWareRltValue.S_WareKindInfoId, wareKindInfoId);
		}
		
		if(!StringUtil.isBlank(ware_status) && !"-1".equals(ware_status)){
			log.debug(" ware_status "+ware_status);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareStatus).append("=:").append(IQBOPermissionWareRltValue.S_WareStatus);
			parameter.put(IQBOPermissionWareRltValue.S_WareStatus, ware_status);
		}
		//礼品名称为模糊查询
		if(!StringUtil.isBlank(ware_name)){
			log.debug(" ware_name "+ware_name);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareName).append(" like :").append(IQBOPermissionWareRltValue.S_WareName);
			parameter.put(IQBOPermissionWareRltValue.S_WareName, "%"+ware_name+"%");
		}
		//礼品编码为模糊查询
		if(!StringUtil.isBlank(ware_code)){
			log.debug(" ware_code "+ware_code);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_WareCode).append(" like :").append(IQBOPermissionWareRltValue.S_WareCode);
			parameter.put(IQBOPermissionWareRltValue.S_WareCode, "%"+ware_code+"%");
		}
		
		//优惠规则，选择-1时，什么也不限制
		if(!StringUtil.isBlank(permissionId) && !"-1".equals(permissionId)){
			log.debug(" permissionId "+permissionId);
			//condition.append(" and ").append(IQBOPermissionWareRltValue.S_PermissionId).append("=:").append(IQBOPermissionWareRltValue.S_PermissionId);
			//parameter.put(IQBOPermissionWareRltValue.S_PermissionId, permissionId);
			
			//利用','进行分割字符串
			String [] permissionIds = permissionId.split(",");
			if(null != permissionIds && permissionIds.length > 0){
				for(int i=0;i<permissionIds.length;i++){
					//0 表示没有绑定规则的礼品 即规则ID为空
					if(!StringUtil.isBlank(permissionIds[i])){
						//第一个元素
						if(0 == i){
							condition.append(" and ("
								+ IQBOPermissionWareRltValue.S_PermissionId
								+ " = :permissionIds" + i);
						}else{
							//其他元素就用or 
							condition.append("  or "
									+ IQBOPermissionWareRltValue.S_PermissionId
									+ " = :permissionIds" + i);
						}
						//最后一个元素的时候，将后面的括号补全
						if (i == permissionIds.length - 1) {
							condition.append(" )");
						}
						//or id is null
						parameter.put("permissionIds" + i, permissionIds[i]);
					}
				}
			
			}
			
//			for (int i = 0; i < discount_id.length; i++)
//				if (!StringUtil.isBlank(discount_id[i])) {
//					if (i == 0) {
//						condition.append(" and ("
//								+ IQBOWareDiscountRltValue.S_DiscountId
//								+ " = :discount_id" + i);
//					} else {
//						condition.append("  or "
//								+ IQBOWareDiscountRltValue.S_DiscountId
//								+ " = :discount_id" + i);
//					}
//					if (i == discount_id.length - 1) {
//						condition.append(" )");
//					}
//					parameter.put("discount_id" + i, discount_id[i]);
//				}

		}
		
		//开始时间和结束时间 精确到
		//肯定不会出现-1？？
		if (!"".equals(beg_time) && beg_time != null && !beg_time.equals("-1")) {
			condition.append(
					" and " + IQBOPermissionWareRltValue.S_ActionStartTime
							+ " >= to_date('").append(
					beg_time + "','yyyy-mm-dd HH24:mi:ss') ");
		}
		if (!"".equals(end_time) && end_time != null && !end_time.equals("-1")) {
			condition.append(
					" and " + IQBOPermissionWareRltValue.S_ActionEndTime
							+ " <= to_date('").append(
					end_time + "','yyyy-mm-dd HH24:mi:ss') ");
		}
		
		if(!StringUtil.isBlank(province_code) && !"-1".equals(province_code)){
			log.debug(" S_ProvinceCode "+province_code);
			condition.append(" and ").append(IQBOPermissionWareRltValue.S_ProvinceCode).append("=:").append(IQBOPermissionWareRltValue.S_ProvinceCode);
			parameter.put(IQBOPermissionWareRltValue.S_ProvinceCode, province_code);
		}
		
		list.add(condition.toString());
		list.add(parameter);
		return list;
	}

	public IPermissionInfoValue[] queryAllPermissionInfoValues() throws Exception {
		//StringBuffer condition = new StringBuffer(" 1=1 ");
		IPermissionInfoValue[] values = warePermissionInfoDAO.getPermissionInfoValues(null, null);
		return values;
	}

	public void  mixPayBind(String permissionId,String wareid) throws Exception{
		warePermissionInfoDAO.mixPayBind(permissionId, wareid);
	}
	
	public String createPermissionWareRlt(long permissionId, long wareId, String startTime, String endTime ,long staffId,String comType,long orgId)
			throws Exception {
		
		//2012/08/15  如果用户打开两个以上的浏览器，或者2个用户同时操作，那么会同时执行两条新增的操作。
		// 新增之前，先用ware_id在permission_rule_rlt中查询一下，查看是否存在生效的记录，如果存在，提示用户不能进行新增操作。
		
		StringBuffer condition  =  new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		
		condition.append(" and ").append(IPermissionRuleRltValue.S_WareId).append("=:").append(IPermissionRuleRltValue.S_WareId);
		parameter.put(IPermissionRuleRltValue.S_WareId, String.valueOf(wareId));
		
		
		condition.append(" and ").append(IPermissionRuleRltValue.S_BindStatus).append("=:").append(IPermissionRuleRltValue.S_BindStatus);
		// 1表示有效，0 表示无效
		parameter.put(IPermissionRuleRltValue.S_BindStatus, WareConstant.SYS_PERMISSION_WARE_RLT_STATUS_VALID);
		
		
		IPermissionRuleRltValue []values = warePermissionInfoDAO.getWarePermissionRltValues(condition.toString(), parameter);
		
		if(null != values && values.length > 0){
			//存在数据
			throw new WarePermissionConException("there occors concurrent operation, saving permission info infomation failed. the operation is new saving");
		}
		long pemissionRuleRltID = PermissionRuleRltEngine.getNewId().longValue();
		//根据这些条件，调用HP接口。
		//01新增
		//String retVal = PermissionInfoUtil.synPermissionRuleToHp(permissionId, wareId, startTime, endTime, WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_NEW,pemissionRuleRltID);
		String retVal =PermissionInfoUtil.createPermissionWareRlt(permissionId, wareId, startTime, endTime, WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_NEW);
		//同步成功
		if(WareConstant.SYS_HP_INTER_SUCCESS.equals(retVal)){
			//将内容写入数据库
			IPermissionRuleRltValue value = new PermissionRuleRltBean();
			value.setWareBindRuleRltId(pemissionRuleRltID);
			value.setPermissionId(permissionId);
			value.setWareId(wareId);
			value.setActionStartTime(DateTimeUtil.stringToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss"));
			value.setActionEndTime(DateTimeUtil.stringToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss"));
			// 0表示生效  1表示无效
			value.setBindStatus(WareConstant.SYS_PERMISSION_WARE_RLT_STATUS_VALID);
			
			warePermissionInfoDAO.saveWarePermissionRltValue(value);
			
			long busiId = BusiInfoEngine.getNewId().longValue();
			//记录概要信息
			//String busiId, String busiTypeId, long staffId, String note, String opt_type, String opt_obj,long StaffId,String ComType,long OrgId
			BusiInfoUtil.recordBusiInfo(busiId + "",
					CoreConstant.SYS_PARA_BUSI_TYPE_NEW_PERMISSION_BIND, 
					staffId , 
					"新增绑定优惠兑换规则",
					"",
					"绑定优惠兑换规则的ID："+permissionId +";绑定的礼品ID："+wareId +";开始时间："+startTime +";结束时间："+endTime,
					staffId,
					comType,
					orgId);;

		}else{
			log.info(" 返回的结果为 " + retVal);
		}
		
		return retVal;
	}

	public String  updatePermissionWareRlt(long permissionId, long wareId, String startTime, String endTime,
			long wareBindRuleRltId,long staffId,String comType,long orgId) throws Exception {
		IPermissionRuleRltValue oldValue = warePermissionInfoDAO.getPermissionRuleRltValue(wareBindRuleRltId);

//		//修改绑定规则，需要新生成规则ID传递HP和更新AI数据库
		long newPermissionRuleRltID = PermissionRuleRltEngine.getNewId().longValue();
		//String retVal = PermissionInfoUtil.synPermissionRuleToHp(permissionId, wareId, startTime, endTime, WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_MODIFY,newPermissionRuleRltID);
		String retVal = PermissionInfoUtil.updatePermissionWareRlt(permissionId, wareId, startTime, endTime,
				WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_MODIFY, oldValue.getPermissionId(), oldValue.getWareId());
		//同步成功
		if(WareConstant.SYS_HP_INTER_SUCCESS.equals(retVal)){
			//旧的状态设置为无效 0 表示无效
			oldValue.setBindStatus(WareConstant.SYS_PERMISSION_WARE_RLT_STATUS_UNVALID);
			warePermissionInfoDAO.saveWarePermissionRltValue(oldValue);
			
			//将新内容写入数据库
			IPermissionRuleRltValue value = new PermissionRuleRltBean();
			value.setWareBindRuleRltId(newPermissionRuleRltID);
			value.setPermissionId(permissionId);
			value.setWareId(wareId);
			value.setActionStartTime(DateTimeUtil.stringToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss"));
			value.setActionEndTime(DateTimeUtil.stringToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss"));
			// 1表示生效
			value.setBindStatus(WareConstant.SYS_PERMISSION_WARE_RLT_STATUS_VALID);
			
			warePermissionInfoDAO.saveWarePermissionRltValue(value);
			long busiId = BusiInfoEngine.getNewId().longValue();
			//记录概要信息
			BusiInfoUtil.recordBusiInfo(busiId + "",
					CoreConstant.SYS_PARA_BUSI_TYPE_MODIFY_PERMISSION_BIND, 
					staffId , 
					"修改绑定优惠兑换规则",
					CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,
					"新的优惠兑换资格ID："+permissionId+",新的礼品的ID："+wareId,
					staffId,
					comType,
					orgId);
			
			//更新的时候，只记录规则ID的变化，开始时间的变化，结束时间的变化
			
			if(oldValue.getPermissionId() != permissionId){
				IBusiInfoDetailValue detailValue = new BusiInfoDetailBean();
    			detailValue.setBusiId(busiId);
    			detailValue.setBeforeValue(String.valueOf(oldValue.getPermissionId()));
    			detailValue.setAfterValue(String.valueOf(permissionId));
    			detailValue.setFieldName("PERMISSION_ID");
    			detailValue.setMainFldName("WARE_BIND_RULE_RLT_ID");
    			detailValue.setMainFldValue(String.valueOf(value.getPermissionId()));
    			detailValue.setBusiTable("PermissionRuleRlt");
    			detailValue.setDetailId(BusiInfoDetailEngine.getNewId().longValue());
    			BusiInfoUtil.recordBusiDetail(detailValue);
			}
			
			if(!oldValue.getActionStartTime().equals(DateTimeUtil.stringToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss"))){
				IBusiInfoDetailValue detailValue = new BusiInfoDetailBean();
    			detailValue.setBusiId(busiId);
    			detailValue.setBeforeValue(String.valueOf(oldValue.getActionStartTime()));
    			detailValue.setAfterValue(String.valueOf(startTime));
    			detailValue.setFieldName("ACTION_START_TIME");
    			detailValue.setMainFldName("WARE_BIND_RULE_RLT_ID");
    			detailValue.setMainFldValue(String.valueOf(oldValue.getWareBindRuleRltId()));
    			detailValue.setBusiTable("PermissionRuleRlt");
    			detailValue.setDetailId(BusiInfoDetailEngine.getNewId().longValue());
    			BusiInfoUtil.recordBusiDetail(detailValue);
			}
			if(!oldValue.getActionEndTime().equals(DateTimeUtil.stringToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss"))){
				IBusiInfoDetailValue detailValue = new BusiInfoDetailBean();
    			detailValue.setBusiId(busiId);
    			detailValue.setBeforeValue(String.valueOf(oldValue.getActionEndTime()));
    			detailValue.setAfterValue(String.valueOf(endTime));
    			detailValue.setFieldName("ACTION_END_TIME");
    			detailValue.setMainFldName("WARE_BIND_RULE_RLT_ID");
    			detailValue.setMainFldValue(String.valueOf(oldValue.getWareBindRuleRltId()));
    			detailValue.setBusiTable("PermissionRuleRlt");
    			detailValue.setDetailId(BusiInfoDetailEngine.getNewId().longValue());
    			BusiInfoUtil.recordBusiDetail(detailValue);
			}
			
		}else{
			log.info(" 返回的结果为 " + retVal);
		}
		return retVal;
		
	}

	public String  unBindPermissionWareRlt(long wareBindRuleRltId,long staffId,String comType,long orgId) throws Exception {
		
		//1、利用wareBindRuleRltId 到permission_ware_rlt 表中查询数据
		IPermissionRuleRltValue value = warePermissionInfoDAO.getPermissionRuleRltValue(wareBindRuleRltId);
		//2、获得wareId,startTime,endTime
		
		//3、同步给HP
		long wareId = value.getWareId();
		Timestamp startTime = value.getActionStartTime();
		Timestamp endTime = value.getActionEndTime();
		long permissionId = value.getPermissionId();
		
		//String retVal = PermissionInfoUtil.synPermissionRuleToHp(permissionId, wareId, DateTimeUtil.timeStampToString(startTime,"yyyy-MM-dd HH:mm:ss"), DateTimeUtil.timeStampToString(endTime,"yyyy-MM-dd HH:mm:ss"), WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_DELETE,wareBindRuleRltId);
		String retVal =PermissionInfoUtil.unBindPerimissionWareRlt(permissionId, wareId, WareConstant.SYS_PERMISSION_HP_INTER_OPT_TYPE_DELETE);
		
		//4、如果返回成功，那么更新该条记录的BindStatus为 0 无效
		if(WareConstant.SYS_HP_INTER_SUCCESS.equals(retVal)){
			//设置成为无效
			value.setBindStatus(WareConstant.SYS_PERMISSION_WARE_RLT_STATUS_UNVALID);
			log.info("同步成功，当前的时间是："+DateTimeUtil.getDefaultSysDate());
			//更新结束时间为当前时间
			value.setActionEndTime(DateTimeUtil.getDefaultSysDate());
			warePermissionInfoDAO.saveWarePermissionRltValue(value);
			
			long busiId = BusiInfoEngine.getNewId().longValue();
			//记录概要信息
			BusiInfoUtil.recordBusiInfo(busiId + "",
					CoreConstant.SYS_PARA_BUSI_TYPE_DELETE_PERMISSION_BIND, 
					staffId , 
					"解除绑定优惠兑换规则",
					"",
					"绑定优惠兑换规则的ID："+permissionId +";绑定的礼品ID："+wareId +";开始时间："+startTime +";结束时间："+endTime,
					staffId,
					comType,
					orgId);;
		}else{
			log.info(" 返回的结果为 " + retVal);
		}
		return retVal;
		
		
		
	}
	public IPermissionInfoValue getPermissionInfoValueById(long permissionId) throws Exception {
		log.info("查询获得规则的基本信息。。。"+permissionId);
		IPermissionInfoValue value = warePermissionInfoDAO.getPermissionInfoById(permissionId);
		return value;
	}

	public IPermissionTypeInfoValue[] getPermissionTypeInfoValuesById(long permissionId, String typeCode)
			throws Exception {
		StringBuffer condition = new StringBuffer(" 1=1 ");
		Map<String,String> parameters = new HashMap<String,String>();
		
		if(0!=permissionId){
			condition.append(" and ").append(IPermissionTypeInfoValue.S_PermissionId).append("=:").append(IPermissionTypeInfoValue.S_PermissionId);
			parameters.put(IPermissionTypeInfoValue.S_PermissionId, String.valueOf(permissionId));
		}
		
		if(!StringUtil.isBlank(typeCode)){
			condition.append(" and ").append(IPermissionTypeInfoValue.S_PermissionName).append("=:").append(IPermissionTypeInfoValue.S_PermissionName);
			parameters.put(IPermissionTypeInfoValue.S_PermissionName, String.valueOf(typeCode));
		}
		IPermissionTypeInfoValue[] values = warePermissionInfoDAO.getWarePermissionTypeValues(condition.toString(), parameters);
		
		return values;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.ware.service.interfaces.IWarePermissionInfoSrv#queryQBOPermissionRuleRlt(java.lang.Long)
	 */
	public IQBOPermissionRuleRltValue[] queryQBOPermissionRuleRlt(long permissionId) throws Exception {
		//利用ruleId 到 permission_rule_rlt
		StringBuffer condition  = new StringBuffer(" 1=1 ");
		Map<String,String> parameter = new HashMap<String,String>();
		if(0 != permissionId){
			condition.append(" and ").append(IQBOPermissionRuleRltValue.S_PermissionId).append(" = :").append(IQBOPermissionRuleRltValue.S_PermissionId);
			parameter.put(IPermissionTypeInfoValue.S_PermissionId, String.valueOf(permissionId));
			condition.append(" and ").append(IQBOPermissionRuleRltValue.S_BindStatus).append("=:").append(IQBOPermissionRuleRltValue.S_BindStatus);
			//只查询生效的绑定记录  有效状态 为 1
			parameter.put(IQBOPermissionRuleRltValue.S_BindStatus, WareConstant.SYS_PERMISSION_WARE_RLT_STATUS_VALID);
		}
		IQBOPermissionRuleRltValue [] values = warePermissionInfoDAO.queryQBOPermissionRuleRlt(condition.toString(), parameter);
		
		return values;
	}

}
