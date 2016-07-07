package ngves.asiainfo.core.theatre.service.impl;

import java.util.List;

import ngves.asiainfo.core.theatre.dao.interfaces.ITheatreInfoDAO;
import ngves.asiainfo.core.theatre.service.interfaces.ITheatreInfoSrv;
import ngves.asiainfo.interfaces.hp.bean.theatreInventoryQuery.in.TheatreInventoryQueryInBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.theatreInventoryQuery.in.TheatreInventoryQueryInItemInfo;
import ngves.asiainfo.interfaces.hp.bean.theatreInventoryQuery.in.TheatreInventoryQueryInItemList;
import ngves.asiainfo.interfaces.hp.bean.theatreInventoryQuery.out.TheatreInventoryQueryOutBizRegReq;
import ngves.asiainfo.interfaces.hp.bean.theatreInventoryQuery.out.TheatreInventoryQueryOutItemInfo;
import ngves.asiainfo.interfaces.hp.bean.theatreInventoryQuery.out.TheatreInventoryQueryOutItemList;
import ngves.asiainfo.interfaces.hp.realtime.TheatreInventoryQueryInter;
import ngves.asiainfo.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TheatreInfoSrvImpl implements ITheatreInfoSrv {

     private static transient Log log = LogFactory.getLog(TheatreInfoSrvImpl.class);
    private ITheatreInfoDAO theatreInfoDAO;

	public void setTheatreInfoDAO(ITheatreInfoDAO theatreInfoDAO) {
		this.theatreInfoDAO = theatreInfoDAO;
	}

	public String getTheatreSurplusCount(String wareCode) throws Exception {
		return theatreInfoDAO.getTheatreSurplusCount(wareCode);
	}

	public List<String> getWareCodeByWareType(String wareType) throws Exception {
		return theatreInfoDAO.getWareCodeByWareType(wareType);
	}

/**
     * 控制层调用
     *
     * @param wareCode
     * @return 根据wareCode获取对应的库存量
     */
    public  int checkTheatreInvetory(String wareCode) throws Exception {

        TheatreInventoryQueryInBizRegReq in = TheatreInventoryQueryInter.getTheatreVentoryInter();

        if (StringUtil.isBlank(wareCode)) {
            log.warn(" the parameter  wareCode is null call  HP TheatreInventoryQueryInter ");
        }
        TheatreInventoryQueryOutBizRegReq out = null;
        int ventory = 0;
        //输入参数-子礼品的wareCode
        TheatreInventoryQueryInItemList itemList = in.addNewItemList();
        TheatreInventoryQueryInItemInfo itemInfo = itemList.addNewItemInfo();
        itemInfo.setItemID(wareCode);

        out = TheatreInventoryQueryInter.doBusi(in);
        log.debug("rejectReasion of HP==>" + out.getRejectReason());
        log.debug("errorMsg of HP==>" + out.getErrorMsg());

        /*访问HP成功,直接返回库存*/
        if ("0000".equals(out.getRejectReason())) {
            // 获取库存量
            TheatreInventoryQueryOutItemList outItemList = out.getItemList();
            if (itemList != null && itemList.sizeOfItemInfoArray() > 0) {
                //存在一个或多个记录，该大剧院通过直接兑换操作，仅一条记录
                TheatreInventoryQueryOutItemInfo[] itemInfoArray = outItemList.getItemInfoArray();
                ventory = itemInfoArray[0].getInventory();
            }
        } else {
            //失败 -2998	系统错误等查询失败	兑换失败，请联系管理员
            ventory = -3;
        }
        log.info("query ventory from hp is " + ventory);
        return ventory;
    }

}
