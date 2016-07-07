package ngves.asiainfo.core.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.SolrConstant;
import ngves.asiainfo.core.ware.WareConstant;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoDAO;
import ngves.asiainfo.core.ware.dao.interfaces.IWareInfoPortalIntegralDAO;
import ngves.asiainfo.core.ware.dao.interfaces.IWarePCInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IQBOAllWareKindInfoValue;
import ngves.asiainfo.core.ware.ivalues.IQBOWareProvDeliverFeeValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalIntegralValue;
import ngves.asiainfo.core.ware.ivalues.IWareInfoPortalValue;
import ngves.asiainfo.core.ware.ivalues.IWarePCRltValue;
import ngves.asiainfo.util.CommonParaUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import com.ai.appframe2.service.ServiceFactory;

/**
 * Solr索引工具类
 * @author zhangwz
 * @author 宋鲁振 父子礼品合并重构 Solr升级集群重构
 */
public class SolrClientUtil {
	private static transient Log log = LogFactory.getLog(SolrClientUtil.class);
    private static IWareInfoDAO wareInfoDAO = (IWareInfoDAO) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_WARE_INFO_DAO);
    private static IWarePCInfoDAO warePCInfoDAO = (IWarePCInfoDAO) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_WARE_PC_INFO_DAO);
    private static IWareInfoPortalIntegralDAO wareInfoPortalIntegralDAO = (IWareInfoPortalIntegralDAO) ServiceFactory.getService(CoreSrvContstant.SERVICE_CORE_WARE_PORTAL_INTEGRAL_DAO);
    private static Map<String, Map<String, String>> kindMap = null;//所有礼品的分类信息封装成HashMap
    private static Map<String, String> logisticMap = null;//所有礼品的运费信息封装成HashMap
    
    //全量更新索引时建立缓存 用于存储子礼品信息 避免2次取值
    private static Map<String, String> childKeyMap = new HashMap<String, String>();
    private static Map<String, IWareInfoPortalValue[]> childWareInfoMap = new HashMap<String, IWareInfoPortalValue[]>();

    /**
     * 获取portal表所有礼品信息
     * @return
     */
    public static IWareInfoPortalValue[] getAllWareInfoPortalValue() {
        IWareInfoPortalValue[] values = null;
        try {
            values = wareInfoDAO.getAllWareInfoPortal();
        } catch (Exception e) {
            log.error("getAllWareInfoPortalValue is exception ...", e);
        }
        return values;
    }
    
    public static IWareInfoPortalValue[] getAllCWarePortalInfosByCId(String parentWareId){
        IWareInfoPortalValue[] values = null;
        try {
            values = wareInfoDAO.qryAllCWarePortalInfosByPId(parentWareId);
        } catch (Exception e) {
            log.error("getAllCWarePortalInfosByCId is exception ...", e);
        }
        return values;
    }
    
    public static IWarePCRltValue getWarePCRltByCId(long wareChildId){
        IWarePCRltValue value = null;
        try {
            IWarePCRltValue[] values = warePCInfoDAO.getParentPCInfoByChildId(wareChildId);
            if(values.length>0){
                value = values[0];
            }
        } catch (Exception e) {
            log.error("getWarePCRltByCId is exception ...", e);
        }
        return value;
    }
    
    /**
     * 获取每个礼品对应每个省份运费积分
     * @return
     */
    public static Map<String, String> getWareProvDeliverFees() {
        if(logisticMap==null){
            logisticMap = new HashMap<String, String>();
            IQBOWareProvDeliverFeeValue[] wareProvDeliverFees = null;
            try {
                wareProvDeliverFees = wareInfoDAO.getWareProvDeliverFee();
                for (IQBOWareProvDeliverFeeValue value : wareProvDeliverFees) {
                    logisticMap.put(String.valueOf(value.getWareId()), value.getProvIntegralValue());
                }
            } catch (Exception e) {
                log.error("getWareProvDeliverFees is exception ...", e);
            }
        }
        return logisticMap;
    }
    
    /**
     * 获取某个礼品对应每个省份运费积分串
     * @return
     */
    public static String getWareProvDeliverFeesById(long wareId) {
        IQBOWareProvDeliverFeeValue value = null;
        try {
            value = wareInfoDAO.getWareProvDeliverFeeById(wareId);
        } catch (Exception e) {
            log.error("getWareProvDeliverFeesById "+ wareId +"is exception ...", e);
        }
        if(value!=null){
            return value.getProvIntegralValue();
        }
        return null;
    }
    
    /**
     * 获取某个礼品信息
     * @return
     */
    public static IWareInfoPortalValue getWareInfoPortal(long wareId) {
        IWareInfoPortalValue value = null;
        try {
            value = wareInfoDAO.getWareInfoPortal(wareId);
        } catch (Exception e) {
            log.error("getWareInfoPortal "+ wareId +"is exception ...", e);
        }
        return value;
    }
    
    /**
     * 取得所有礼品的分类信息
     * @return
     * @throws Exception 
     */
    public static Map<String, Map<String, String>> getAllWareKindInfo() throws Exception {
        if(kindMap==null){
            log.debug("getAllWareKindParent...");
            kindMap = new HashMap<String, Map<String, String>>();
            Map<String,String> kinds = null;
            IQBOAllWareKindInfoValue[] values = wareInfoDAO.getAllWareKindInfo();
            for (IQBOAllWareKindInfoValue value : values) {
                kinds = new HashMap<String,String>();
                kinds.put("bKind", String.valueOf(value.getBKindId()));
                kinds.put("mKind", String.valueOf(value.getMKindId()));
                kinds.put("sKind", String.valueOf(value.getSKindId()));
                kinds.put("bName", value.getBKindName());
                kinds.put("mName", value.getMKindName());
                kinds.put("sName", value.getSKindName());
                kindMap.put(String.valueOf(value.getWareId()), kinds);
            }
            log.debug("getAllWareKindParent.length: "+kindMap.size());
        }
        return kindMap;
    }
	
	private final static void fail(Object o) {
		log.info(o);
	}

	/**初次创建礼品索引和积分运费索引
	 * @throws Exception
	 */
	public static void createIndex() throws Exception {
		SolrServer solr = SolrServerInstance.getSolrReIndexInstance();
		//全量更新索引时是否清空索引
		if("Y".equals(CommonParaUtil.getPara(SolrConstant.SOLR_REINDEX_CLEAN))){
			removeAll(solr);
		}
		
		//重建全量索引
		IWareInfoPortalValue[] wareInfoPortalValue = getAllWareInfoPortalValue();
		
		//获取所有礼品的运费信息并封装成Map(使用静态类SolrIndexUtil懒加载)
		//获取所有礼品的类别信息并封装成Map(使用静态类SolrIndexUtil懒加载)
		List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		int i = 0;
		log.info("wareInfoPortalValue.length:" + wareInfoPortalValue.length);
		long begin = System.currentTimeMillis();
		log.info("Begin create ware index......");
		cleanMapMemory();
		for (IWareInfoPortalValue bean : wareInfoPortalValue) {
			SolrInputDocument sd = getWareSolrDoc(bean.getWareId());
			if(sd==null){
				continue;
			}
			docs.add(sd);
			i++;
			if(i % 300 == 0 || i == wareInfoPortalValue.length){
				try {
					log.info("create index total count:" + i);
					UpdateResponse response = solr.add(docs);
					docs.clear();
					// 对索引进行优化
					solr.optimize();
					solr.commit();
					fail(response);
				} catch (Exception e) {
					log.error("Solr Optimize/Commit Exception: ", e);
					throw e;
				}
			}
		}
		
		cleanMapMemory();
        long end = System.currentTimeMillis();
		log.info("End create ware index......,total time is :" + String.valueOf(end - begin));
	}
	
	/**
     * 星级体系改造 根据wareId获取Ware_Portal_Info_Integral 
     * 
     * @param integrals
     * @param wp
     * @return
     * @throws Exception 
     */
    private static IWareInfoPortalIntegralValue[] getWarePortalIntegrals(long wareId) throws Exception {
        Map<String, String> parameter = new HashMap<String, String>();
        StringBuffer condition = new StringBuffer(" 1 = 1 ");
        condition.append(" AND ").append(IWareInfoPortalIntegralValue.S_WareId).append(" = :").append(IWareInfoPortalIntegralValue.S_WareId);
        parameter.put(IWareInfoPortalIntegralValue.S_WareId, String.valueOf(wareId));
        return wareInfoPortalIntegralDAO.getWareInfoPortalIntegralValue(condition.toString(), parameter);
    }

    /**
     * 该礼品是否优惠
     * @param wipivs
     * @return
     */
    public static boolean isSale(IWareInfoPortalIntegralValue[] wipivs){
        for(IWareInfoPortalIntegralValue value : wipivs){
            //任何一个星级（五星金、钻除外）只要有一个 现积分<原积分 (现金+同理) 即是优惠礼品
            if((value.getCurIntegral()!=0&&value.getCurIntegral()<value.getOriIntegral())
                    ||(value.getCurPayIntegral()!=0&&value.getCurPayIntegral()<value.getOriPayIntegral())
                    ||(value.getCurPayCash()!=0&&value.getCurPayCash()<value.getCurPayCash())){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 该礼品渠道属性
     * @param wipivs
     * @return
     */
    private static String getChannel(IWareInfoPortalIntegralValue[] wipivs){
        List<String> channelList = new ArrayList<String>();
        for(IWareInfoPortalIntegralValue value : wipivs){
            if(!channelList.contains(value.getChannel())){
                channelList.add(value.getChannel());
            }
        }
        String channel = ",";
        for(String cl: channelList){
            channel = channel+cl+",";
        }
        return channel;
    }
    
    /**
     * 该礼品星级属性
     * @param wipivs
     * @return
     */
    private static String getStarLevel(IWareInfoPortalIntegralValue[] wipivs){
        List<String> starLevelList = new ArrayList<String>();
        for(IWareInfoPortalIntegralValue value : wipivs){
            if(!starLevelList.contains(value.getStarLevel())){
                starLevelList.add(value.getStarLevel());
            }
        }
        String starLevel = ",";
        for(String sl: starLevelList){
            starLevel = starLevel+sl+",";
        }
        return starLevel;
    }
    
    /**
     * Clear Child Map
     */
    public static void cleanMapMemory(){
        childKeyMap = new HashMap<String, String>();
        childWareInfoMap = new HashMap<String, IWareInfoPortalValue[]>();
        logisticMap = null;
        kindMap = null;
    }
    
    /**
     * 读取礼品信息 拼装Solr索引
     * @param wareId
     * @return
     * @throws Exception
     */
    public static SolrInputDocument getWareSolrDoc(long wareId) throws Exception {
            SolrInputDocument doc = new SolrInputDocument();
        
            IWareInfoPortalValue wp = getWareInfoPortal(wareId);
            if(!WareConstant.SYS_CORE_PARENT_WARE_STATUS_ONLINE.equals(wp.getWareStatus())){
            	return null;
            }
            //星级体系 获取礼品积分信息
            IWareInfoPortalIntegralValue[] wipivs = getWarePortalIntegrals(wareId);
            boolean sale = isSale(wipivs);
            String channel = getChannel(wipivs);
            String starLevel = getStarLevel(wipivs);
            String wareCode = wp.getWareCode();
            String wareName = wp.getWareName();
            //积分信息
            long oriIntegral = wp.getWareIntegralValue();
            double oriPayCash = (double)wp.getOriPayCash()/100;
            long oriPayIntegral = wp.getOriPayIntegral();
            
            String mainPic = wp.getMainPicFile();
            String funcDesc = wp.getFuncDesc();
            long exchangeId = wp.getExchangeId();
            String exchangeMode = wp.getExchangeMode();
            String alias = wp.getAlias();
            String bakCol1 = wp.getBakCol1();
            String deliverType = wp.getDeliverType();
    
            // 为了查询条件新增的字段
            String isSearch = wp.getIsSearch();
            String isHtmlChannel = wp.getIsHtmlChannel();
            String wareStatus = wp.getWareStatus();
            String provinceCode = wp.getProvinceCode();
            String searchHot = wp.getSearchHot();
            String wareHouseId = String.valueOf(wp.getWarehouseId());
            String wareStorageType = wp.getWareStorageType();
            
            String isAllowDonation = wp.getIsAllowDonation();
            Date openDate = wp.getOpenDate();
            long wareBrandId = wp.getWareBrandId();
            String keyWords = wp.getKeyWords();
            long shopPrice = wp.getShopPrice();
            float discount = wp.getDiscount();
            long saleAmount = wp.getSaleAmount();
            long commentCount = wp.getCommentCount();
            long commentValue = wp.getCommentValue();
            String isClientChannel = wp.getIsClientChannel();
            String packingList = wp.getPackingList();
            String safeGuard = wp.getSafeGuard();
            String payType=wp.getPayType();
            String isOnlinePay=wp.getIsOnlinePay();
            String isOfflinePay=wp.getIsOfflinePay();
            String offlineDesc=wp.getOfflineDesc();
             
            long wareType = wp.getWareType();
    
            doc.addField("id", wareId);
            doc.addField("wareCode", wareCode);
            doc.addField("wareName", wareName);
            doc.addField("oriIntegral", oriIntegral);
            doc.addField("mainPic", mainPic);
            doc.addField("funcDesc", funcDesc);
            doc.addField("exchangeId", exchangeId);
            doc.addField("exchangeMode", exchangeMode);
            doc.addField("alias", alias);
            doc.addField("bakCol1", bakCol1);
            doc.addField("deliverType", deliverType);
            doc.addField("isSearch", isSearch);
            doc.addField("isHtmlChannel", isHtmlChannel);
            doc.addField("wareStatus", wareStatus);
            doc.addField("provinceCode", provinceCode);
            doc.addField("searchHot", searchHot);
            
            doc.addField("wareHouseId", wareHouseId);
            doc.addField("wareStorageType", wareStorageType);
            doc.addField("isAllowDonation", isAllowDonation);
            doc.addField("wareBrandId", wareBrandId);
            doc.addField("openDate", openDate);
            doc.addField("keyWords", keyWords);
            doc.addField("shopPrice", shopPrice);
            doc.addField("discount", discount);
            doc.addField("saleAmount", saleAmount);
            doc.addField("commentCount", commentCount);
            doc.addField("commentValue", commentValue);
            doc.addField("isClientChannel", isClientChannel);
            doc.addField("packingList", packingList);
            doc.addField("safeGuard", safeGuard);
            doc.addField("typeCode", wp.getBakCol3() != null ? wp.getBakCol3() : -1);
        
            doc.addField("payType", payType);
            doc.addField("oriPayCash", oriPayCash);
            doc.addField("oriPayIntegral", oriPayIntegral);
            doc.addField("isOnlinePay",isOnlinePay);
            doc.addField("isOfflinePay",isOfflinePay);
            doc.addField("offlineDesc",offlineDesc);
            
            // 此字段是区分礼品类型，0代表普通礼品，1代表父子类礼品
            doc.addField("wareType", wareType);
            
            doc.addField("channel", channel);
            doc.addField("sale", sale);
            doc.addField("starLevel", starLevel);
            
            doc.addField("logisticIntegral", getWareProvDeliverFeesById(wareId));
            Map<String, String> kinds = getAllWareKindInfo().get(String.valueOf(wareId));
            if(kinds==null){
                return null;
            }
            
            doc.addField("sKind", kinds.get("sKind"));
            doc.addField("sName", kinds.get("sName"));
            doc.addField("mKind", kinds.get("mKind"));
            doc.addField("mName", kinds.get("mName"));
            doc.addField("bKind", kinds.get("bKind"));
            doc.addField("bName", kinds.get("bName"));
            
            //2014年11月父子礼品合并需求 父子礼品索引特殊处理：存储子礼品相应属性列表
            if(wareType==0){
                doc.addField("parentWareId", wareId);
            } else {
                String parentId = null;
                IWareInfoPortalValue[] values;
                if(childKeyMap.get(wareId)==null){
                    IWarePCRltValue pcrltValue = getWarePCRltByCId(wareId);
                    if(pcrltValue==null){
                        return null;
                    }
                    parentId = String.valueOf(pcrltValue.getPWareId());
                    values = getAllCWarePortalInfosByCId(parentId);
                    childWareInfoMap.put(parentId, values);
                    for(IWareInfoPortalValue value : values){
                        childKeyMap.put(String.valueOf(value.getWareId()), parentId);
                    }
                } else {
                    parentId = childKeyMap.get(wareId);
                    values = childWareInfoMap.get(parentId);
                }
                
                doc.addField("parentWareId", "parent_" + parentId);
                //将子礼品的所需属性放到solr document中存储
                List<String> childMainPicList = new ArrayList<String>();
                List<String> childWareCodeList = new ArrayList<String>();
                //先把当前子礼品属性放入List
                childMainPicList.add(mainPic);
                childWareCodeList.add(wareCode);
                doc.addField("childWareIdList", wareId);
                doc.addField("childWareCodeList", wareCode);
                doc.addField("childWareNameList", wareName);
                doc.addField("childMainPicList", mainPic);
                doc.addField("childOriIntegralList", oriIntegral);
                doc.addField("childOriPayCashList", oriPayCash);
                doc.addField("childOriPayIntegralList", oriPayIntegral);
                doc.addField("childSaleList", sale);
                
                for(IWareInfoPortalValue v : values){
                    String childMainPic = v.getMainPicFile();
                    String childWareCode = v.getWareCode();
                    //子礼品图片重复 仅保留一份展示
                    if(childMainPicList.contains(childMainPic)||childWareCodeList.contains(childWareCode)){
                        continue;
                    }
                    IWareInfoPortalIntegralValue[] childWipivs = getWarePortalIntegrals(v.getWareId());
                    boolean childSale = isSale(childWipivs);
                    
                    childMainPicList.add(childMainPic);
                    String childWareId = String.valueOf(v.getWareId());
                    String childWareName = v.getWareName();
                    long childOriIntegral = v.getWareIntegralValue();
                    double childOriPayCash = (double)v.getOriPayCash()/100;
                    long childOriPayIntegral = v.getOriPayIntegral();
                    
                    doc.addField("childWareIdList", childWareId);
                    doc.addField("childWareCodeList", childWareCode);
                    doc.addField("childWareNameList", childWareName);
                    doc.addField("childMainPicList", childMainPic);
                    doc.addField("childOriIntegralList", childOriIntegral);
                    doc.addField("childOriPayCashList", childOriPayCash);
                    doc.addField("childOriPayIntegralList", childOriPayIntegral);
                    doc.addField("childSaleList", childSale);
                }
            }
            return doc;
    }
	
	/**
	 * 删除全部索引
	 * @throws Exception 
	 */
	public static void removeAll(SolrServer solr) throws Exception {
		try {
			solr.deleteByQuery("*:*");
			solr.commit();
		} catch (Exception e) {
			log.error("Solr Remove All Exception", e);
			throw e;
		}
	}
	
}
