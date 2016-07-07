/**
 * Copyright (c) 2010 asiainfo-linkage.com
 * 2010-10-26 上午11:49:02
 */
package ngves.asiainfo.core.ware.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import ngves.asiainfo.core.common.dao.interfaces.IClobInfoDAO;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePreviewDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareDescValue;
import ngves.asiainfo.core.ware.ivalues.IQBOBusiWareInfoValue;
import ngves.asiainfo.core.ware.model.WarePreviewInfoBean;
import ngves.asiainfo.core.ware.service.interfaces.IWarePreviewSrv;
import ngves.asiainfo.core.ware.model.MagAttr;
import ngves.asiainfo.core.ware.model.MagBean;
import ngves.asiainfo.core.ware.WareParamConstant;
import ngves.asiainfo.util.DateTimeUtil;
import ngves.asiainfo.util.StringUtil;

/**
 * 礼品预览服务接口
 * 
 * @author huangsong
 */
public class WarePreviewSrvImpl implements IWarePreviewSrv {
	private static Log log = LogFactory.getLog(WarePreviewSrvImpl.class);
	private IWarePreviewDAO warePreviewDAO = null;
	private IClobInfoDAO 	clobInfoDAO = null;

	public void setWarePreviewDAO(IWarePreviewDAO warePreviewDAO) throws Exception {
		this.warePreviewDAO = warePreviewDAO;
	}
	
	public void setClobInfoDAO(IClobInfoDAO clobInfoDAO) {
		this.clobInfoDAO = clobInfoDAO;
	}
	//
	private static String BUSI_WARE_TABLE_NAME = "BUSI_WARE_INFO";

	/**
	 * 获取礼品的预览信息
	 * 
	 * @param busiId
	 * @return
	 * @throws Exception
	 */
	public WarePreviewInfoBean getWarePreviewInfo(long busiId) throws Exception {
		WarePreviewInfoBean warePreviewInfo = null;
		IQBOBusiWareInfoValue busiWareInfo = warePreviewDAO.getBusiWareInfo(busiId);
		if (null != busiWareInfo) {
			warePreviewInfo = new WarePreviewInfoBean();

			warePreviewInfo.setCountType(busiWareInfo.getCountType());
			warePreviewInfo.setCountValue(busiWareInfo.getCountValue());
			warePreviewInfo.setDeliverType(busiWareInfo.getDeliverType());
			warePreviewInfo.setFuncDesc(busiWareInfo.getFuncDesc());
			warePreviewInfo.setMarketPrice(busiWareInfo.getMarketPrice());
			warePreviewInfo.setPartner(busiWareInfo.getPartner());
			warePreviewInfo.setProvinceCode(busiWareInfo.getProvinceCode());
			warePreviewInfo.setShopPrice(busiWareInfo.getShopPrice());
			warePreviewInfo.setWareBrandId(busiWareInfo.getWareBrandId());
			warePreviewInfo.setWareCode(busiWareInfo.getWareCode());
			warePreviewInfo.setWareHouseId(busiWareInfo.getWarehouseId());
			warePreviewInfo.setWareId(busiWareInfo.getWareId());
			warePreviewInfo.setWareName(busiWareInfo.getWareName());
			warePreviewInfo.setWareStorageType(busiWareInfo.getWareStorageType());
			warePreviewInfo.setWareKindId(busiWareInfo.getWareKindId());
			warePreviewInfo.setWareBrandName(busiWareInfo.getWareBrandName());
			warePreviewInfo.setAlias(busiWareInfo.getAlias());
		
			IQBOBusiWareDescValue[] descs = warePreviewDAO.getBusiWareDesc(busiId);
			warePreviewInfo.setWareImages(warePreviewDAO.getWareImages(busiWareInfo.getWareId(),busiId));

			if (null != descs && 1 <= descs.length) {
				warePreviewInfo.setWareDescs(descs);

				// 短信兑换码
				String mobileExchangeCode = "";

				String handMobileExchangeCode = "";

				boolean canMobileExchange = false;
				boolean isViewSMSExchangWap = false;

				for (IQBOBusiWareDescValue desc : descs) {
					if (desc.getDescDefineId() == WareConstant.IMPORTANT_DESC_DEFINE_ID) {
						warePreviewInfo.setImportantDesc(desc.getWareDescValue());
					}

					/**
					 * 判断是否支持短信兑换
					 */
					if (desc.getDescDefineId() == WareConstant.EXCHANGE_TYPE_DEFINE_ID
							&& !StringUtils.isBlank(desc.getWareDescValue())) {

						if (desc.getWareDescValue().indexOf(WareConstant.EXCHANGE_TYPE_SMS) != -1)
							canMobileExchange = true;
					}
					
					/**
					 * 判断是否展示短信兑换码
					 */
					if(desc.getDescDefineId() == WareConstant.VIEW_SMS_DEFINE_ID
							&& !StringUtils.isBlank(desc.getWareDescValue())
							&& "1".equals(desc.getWareDescValue())){
						isViewSMSExchangWap = true;
					}

					/**
					 * 得到手工设置的短信兑换码
					 */
					if (desc.getDescDefineId() == WareConstant.MOBILE_EXCHANGE_DEFINE_ID
							&& !StringUtils.isBlank(desc.getWareDescValue())) {
						handMobileExchangeCode = desc.getWareDescValue();
					}

				}
				//当短信兑换渠道为真并且‘是否展示短信兑换提示’为是   时才显示短信兑换码
				if(!canMobileExchange || !isViewSMSExchangWap){
					canMobileExchange = false;
				}

				// 设置是否支持兑换短信兑换
				warePreviewInfo.setCanMobileExchange(canMobileExchange);

				if (canMobileExchange) {
					if (handMobileExchangeCode.length() > 0)
						mobileExchangeCode = handMobileExchangeCode;
					else
						// 支持短信兑换码，没有手工设置的短信兑换码，则直接使用礼品id
						mobileExchangeCode = busiWareInfo.getWareCode();
				}
				warePreviewInfo.setMobileExchangeCode(mobileExchangeCode);

				// --以下为期刊杂志信息----
				MagAttr magAttr = null;
				List<MagBean> magBeanList = null;
				boolean isMagWare = false;
				// --期刊杂志类礼品
				if (WareConstant.UNI_MAG_WARE.equals(busiWareInfo.getDeliverType())) {
					magAttr = getMagAtrrInfo(descs);
				}
				// ---判断是否为期刊杂志礼品---
				if (null != magAttr && !StringUtil.isBlank(magAttr.getMagType())) {
					// ---取得可以兑换的期数信息-----
					magBeanList = getMagInfo(magAttr);
					isMagWare = true;
				}

				warePreviewInfo.setMagWare(isMagWare);
				warePreviewInfo.setMagBean(magBeanList);
			}
			
			
			//获取礼品富文本信息
			String richText = clobInfoDAO.getContent(busiWareInfo.getBusiId(), BUSI_WARE_TABLE_NAME);
			String packingList=busiWareInfo.getPackingList();			
			String safeGuard=busiWareInfo.getSafeGuard();
			warePreviewInfo.setRichTextDescInfo(richText);
			warePreviewInfo.setPackingList(StringUtil.htmlifyTextExcludeATag(packingList));
			warePreviewInfo.setSafeGuard(StringUtil.htmlifyTextExcludeATag(safeGuard));
			//如果礼品富文本 发货清单 售后保障信息不为空(展示页签,设置富文本信息)
			if(!StringUtil.isBlank(richText)||!StringUtil.isBlank(packingList)||!StringUtil.isBlank(safeGuard)) {
				warePreviewInfo.setShowTag(true);
			}
			
		}
		return warePreviewInfo;
	}

	/**
	 * 取得期刊杂志的属性信息
	 * 
	 * @param descs
	 * @return
	 */
	private MagAttr getMagAtrrInfo(IQBOBusiWareDescValue[] descs) {
		if (null == descs || descs.length <= 0)
			return null;
		MagAttr magBean = new MagAttr();
		for (int i = 0; i < descs.length; i++) {
			// --期刊类型--
			if (String.valueOf(descs[i].getDescDefineId()).equals(WareParamConstant.MAG_ATTR_TYPE)) {
				magBean.setMagType(descs[i].getWareDescValue());
			}
			// --出刊日--
			else if (String.valueOf(descs[i].getDescDefineId()).equals(WareParamConstant.MAG_ATTR_PUB_DATE)) {
				magBean.setPubDate(descs[i].getWareDescValue());
			}
			// --提前出刊时间--
			else if (String.valueOf(descs[i].getDescDefineId()).equals(WareParamConstant.MAG_ATTR_SUBMIT_TYPE)) {
				magBean.setBeforePubType(descs[i].getWareDescValue());
			}
			// --期刊截止兑换时间--
			else if (String.valueOf(descs[i].getDescDefineId()).equals(WareParamConstant.MAG_ATTR_END_DATE)) {
				magBean.setMagEndDate(descs[i].getWareDescValue());
			}
		}
		return magBean;
	}

	/**
	 * 通过礼品属性，取得当前可以兑换的期刊信息 modify by wangyw @2010.3.10. 修改页面显示的可兑换期刊数，
	 * 显示从当前日期到截止日期所有可以兑换的期刊 保留原代码为当前年等于截止年的情况 modify by zhulin @2010.3.15重构代码
	 * 
	 * @param magAttr
	 * @return
	 */
	private List<MagBean> getMagInfo(MagAttr magAttr) throws Exception {

		if (StringUtil.isBlank(magAttr.getMagType()) || StringUtil.isBlank(magAttr.getPubDate())
				|| StringUtil.isBlank(magAttr.getBeforePubType()) || StringUtil.isBlank(magAttr.getMagEndDate())) {
			log.error("get mag ware attribute exist null!!!");
			throw new Exception("get mag ware attribute exist null!!!");
		}
		// --存放可以兑换的期刊信息----
		List<MagBean> magBeanList = new ArrayList<MagBean>();

		// --当前年，月，天----
		int curYear = DateTimeUtil.getCurrYear();
		int curMonth = DateTimeUtil.getCurrMonth();
		int curDay = DateTimeUtil.getCurrDay();
		// --期刊截止年，月--
		String magEndDate = magAttr.getMagEndDate();
		int magEndYear = Integer.parseInt(magEndDate.substring(0, 4));
		int magEndMonth = Integer.parseInt(magEndDate.substring(5, 7));
		// 期刊类型，单月，奇数双，偶数双
		String magType = magAttr.getMagType();
		// 出刊日
		String pubDate = magAttr.getPubDate();
		// 提前出刊类型
		String beforePubType = magAttr.getBeforePubType();
		// 当前日大于出刊日，当前月不记为一个月,从下个月开始计算
		if (Integer.parseInt(pubDate) <= curDay) {
			curMonth = curMonth + 1;
		}

		// 根据提前出刊类型，确定当前时间可以兑换的第一期出刊月份
		if (beforePubType.equals(WareParamConstant.MAG_TIME_CUR_MONTH_PUB)) {
		} else if (beforePubType.equals(WareParamConstant.MAG_TIME_BEFORE_ONE_MONTH_PUB)) {
			curMonth = curMonth + 1;
		} else if (beforePubType.equals(WareParamConstant.MAG_TIME_BEFORE_TWO_MONTH_PUB)) {
			curMonth = curMonth + 2;
		} else {
			log.error("the beforePubType is illegal in getMagInfo....");
			throw new Exception("the beforePubType is illegal in getMagInfo....");
		}

		if (magEndYear == curYear) {
			if (curMonth <= magEndMonth) {
				if (magType.equals(WareParamConstant.MAG_TYPE_SINGLE)) {
					// 单月刊
					for (int i = curMonth; i <= magEndMonth; i++) {
						magBeanList.add(new MagBean(curYear, i));
					}
				} else if (magType.equals(WareParamConstant.MAG_TYPE_ODD)) {
					// 奇数双月刊
					for (int i = curMonth; i <= magEndMonth; i++) {
						if (i % 2 != 0)
							magBeanList.add(new MagBean(curYear, i));
					}
				} else if (magType.equals(WareParamConstant.MAG_TYPE_EVEN)) {
					// 偶数双月刊
					for (int i = curMonth; i <= magEndMonth; i++) {
						if (i % 2 == 0)
							magBeanList.add(new MagBean(curYear, i));
					}
				} else {
					log.error("the magType is illegal in getMagInfo....");
					throw new Exception("the magType is illegal in getMagInfo....");
				}
			}
		} else if (magEndYear > curYear) {
			if (magType.equals(WareParamConstant.MAG_TYPE_SINGLE)) {
				// 当前年当前月以后所有月份均可兑换
				if (curMonth <= 12) {
					for (int i = curMonth; i <= 12; i++) {
						magBeanList.add(new MagBean(curYear, i));
					}
				}
				// 截止年截止月以前所有月份均可兑换
				if (magEndMonth >= 1) {
					for (int j = 1; j <= magEndMonth; j++) {
						magBeanList.add(new MagBean(magEndYear, j));
					}
				}
				// 当前年以后截止年以前（不包括当前年和截止年）所有月份均可兑换
				if (curYear + 1 <= magEndYear - 1) {
					for (int m = curYear + 1; m <= magEndYear - 1; m++) {
						for (int n = 1; n <= 12; n++) {
							magBeanList.add(new MagBean(m, n));
						}
					}
				}
			} else if (magType.equals(WareParamConstant.MAG_TYPE_ODD)) {
				// 当前年当前月以后所有月份均可兑换
				if (curMonth <= 12) {
					for (int i = curMonth; i <= 12; i++) {
						if (i % 2 != 0)
							magBeanList.add(new MagBean(curYear, i));
					}
				}
				// 截止年截止月以前所有月份均可兑换
				if (magEndMonth >= 1) {
					for (int j = 1; j <= magEndMonth; j++) {
						if (j % 2 != 0)
							magBeanList.add(new MagBean(magEndYear, j));
					}
				}
				// 当前年以后截止年以前（不包括当前年和截止年）所有月份均可兑换
				if (curYear + 1 <= magEndYear - 1) {
					for (int m = curYear + 1; m <= magEndYear - 1; m++) {
						for (int n = 1; n <= 12; n++) {
							if (n % 2 != 0)
								magBeanList.add(new MagBean(m, n));
						}
					}
				}
			} else if (magType.equals(WareParamConstant.MAG_TYPE_EVEN)) {
				// 当前年当前月以后所有月份均可兑换
				if (curMonth <= 12) {
					for (int i = curMonth; i <= 12; i++) {
						if (i % 2 == 0)
							magBeanList.add(new MagBean(curYear, i));
					}
				}
				// 截止年截止月以前所有月份均可兑换
				if (magEndMonth >= 1) {
					for (int j = 1; j <= magEndMonth; j++) {
						if (j % 2 == 0)
							magBeanList.add(new MagBean(magEndYear, j));
					}
				}
				// 当前年以后截止年以前（不包括当前年和截止年）所有月份均可兑换
				if (curYear + 1 <= magEndYear - 1) {
					for (int m = curYear + 1; m <= magEndYear - 1; m++) {
						for (int n = 1; n <= 12; n++) {
							if (n % 2 == 0)
								magBeanList.add(new MagBean(m, n));
						}
					}
				}
			} else {
				log.error("the magType is illegal in getMagInfo....");
				throw new Exception("the magType is illegal in getMagInfo....");
			}
		} else {
			log.error(" an exec occur beacause magEndYear < curYear in getMagInfo....");
		}
		return magBeanList;
	}

	public long getCwareId(long busiId) throws Exception {
		IQBOBusiWareInfoValue busiWareInfo = warePreviewDAO.getBusiWareInfo(busiId);
		if(null != busiWareInfo){
			return busiWareInfo.getWareId();
		}
		return 0;
	}
}
