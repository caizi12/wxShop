/**
 * 
 */
package ngves.asiainfo.core.delivertype.service.impl;

import ngves.asiainfo.core.common.util.DeliverTypeEnum;
import ngves.asiainfo.core.common.util.DeliverTypeUtil;
import ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv;

/**
 * 配送方式相关接口实现类
 * @author zhaoyj@asiainfo-linkage.com
 *
 */
public class DeliverTypeSrvImpl implements IDeliverTypeSrv {

	/* (non-Javadoc)
	 * @see ngves.asiainfo.portal.delivertype.service.interfaces.IDeliverTypeSrv#getServiceValueForSynWareInfo(java.lang.String)
	 */
	public String getServiceValueForSynWareInfo(String deliverType) {

		if(DeliverTypeEnum.AIR_MILES_WARE.getAIValue().equals(deliverType)){
			//TODO ...
		}else if(DeliverTypeEnum.SPD_BANK_WARE.getAIValue().equals(deliverType)){
			//TODO ...
		}else{
			//TODO ...
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#getItemTypeBeans(java.lang.String)
	 */
	public String getItemTypeBeans(String deliverType) {
		
		String itemTypeBeans = null;

		if (DeliverTypeUtil.isGloLogicWare(deliverType)) {
			itemTypeBeans = "itemGBeans";
		} else if (DeliverTypeUtil.isProvLogicWare(deliverType)) {
			itemTypeBeans = "itemPLBeans";
		} else if (DeliverTypeUtil.isProvBusiOfficeWare(deliverType)) {
			itemTypeBeans = "itemPHBeans";
		} else if (DeliverTypeUtil.isDirectExchangeWare(deliverType)) {
			itemTypeBeans = "itemSBeans";
		} else if (DeliverTypeUtil.isUniDeliverWare(deliverType)) {
			itemTypeBeans = "itemUBeans";
		}
		
		return itemTypeBeans;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#getSendProvinceCode(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getSendProvinceCodeForPackage(String deliverType,
			String sendProvinceCode, String location) {
		
		if(DeliverTypeUtil.isPackageDeliverType(deliverType)){
			sendProvinceCode = location;
		}
		return sendProvinceCode;
	}
	
	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#getSendProvinceCodeForRushBuy(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getSendProvinceCodeForRushBuy(String deliverType,
			String sendProvinceCode, String location) {
		
		if(DeliverTypeUtil.isDirectExchangeWareForRushBuy(deliverType)){
			sendProvinceCode = location;
		}
		return sendProvinceCode;
	}


	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#getSendProvinceCodeForDirect(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getSendProvinceCodeForDirect(String deliverType,
			String sendProvinceCode, String location) {
		
		if(DeliverTypeUtil.isDirectExchangeWare(deliverType)){
			sendProvinceCode = location;
		}
		return sendProvinceCode;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#isLimitedNumOrder(java.lang.String)
	 */
	public boolean isLimitedNumOrder(String deliverType) {
		if(DeliverTypeUtil.isGloLogicWare(deliverType) || DeliverTypeUtil.isDimCodeWare(deliverType)){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#getItemTypeWareForShop(java.lang.String)
	 */
	public String getItemTypeWareForShop(String deliverType) throws Exception {
		String itemTypeWare = null;
		if(DeliverTypeUtil.isGloLogicWare(deliverType)){
			itemTypeWare = "isExistGWare";
		}else if(DeliverTypeEnum.ELE_PASSWD_WARE.getAIValue().equals(deliverType) || DeliverTypeEnum.DIM_CODE_WARE.getAIValue().equals(deliverType)){
			itemTypeWare = "isExistSWare";
		}else if(DeliverTypeEnum.UNI_MAG_WARE.getAIValue().equals(deliverType)){
			itemTypeWare = "isExistUWare";
		}else if(DeliverTypeUtil.isProvLogicWare(deliverType)){
			itemTypeWare = "isExistPLWare";
		}else if(DeliverTypeUtil.isProvBusiOfficeWare(deliverType)){
			itemTypeWare = "isExistPHWare";
		}else{
			throw new Exception();
		}
		
		return itemTypeWare;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#isSameForSendProvAndLocation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean isConsistentProvince(String deliverType,
			String sendProvinceCode, String userLocation) {
		
		if(DeliverTypeUtil.isProvLogicWare(deliverType) && !sendProvinceCode.equals(userLocation)){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.delivertype.service.interfaces.IDeliverTypeSrv#isNeedFillReserveWhenOrder(java.lang.String)
	 */
	public boolean isNeedFillReserveWhenOrder(String deliverType) {
		
		if(DeliverTypeEnum.UNI_DIY_WARE.getAIValue().equals(deliverType) || DeliverTypeEnum.AIR_MILES_WARE.getAIValue().equals(deliverType)
				|| DeliverTypeEnum.GAS_CARD_WARE.getAIValue().equals(deliverType) || DeliverTypeEnum.SPD_BANK_WARE.getAIValue().equals(deliverType)){
			return true;
		}
		return false;
	}


	

}
