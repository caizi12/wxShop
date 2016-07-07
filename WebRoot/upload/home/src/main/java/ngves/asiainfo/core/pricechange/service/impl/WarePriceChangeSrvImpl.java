package ngves.asiainfo.core.pricechange.service.impl;

import java.util.List;
import ngves.asiainfo.core.pricechange.dao.interfaces.IWarePriceChangeDAO;
import ngves.asiainfo.core.pricechange.model.WarePriceRecordObject;
import ngves.asiainfo.core.pricechange.service.interfaces.IWarePriceChangeSrv;
import ngves.asiainfo.core.pricechange.util.WarePriceChangeConstant;
import ngves.asiainfo.util.DateTimeUtil;

public class WarePriceChangeSrvImpl implements IWarePriceChangeSrv{
	private IWarePriceChangeDAO warePriceChangeDAO;
	public void setWarePriceChangeDAO(IWarePriceChangeDAO warePriceChangeDAO) {
		this.warePriceChangeDAO = warePriceChangeDAO;
	}
	public WarePriceRecordObject findWarePriceRecordObjectByBusiId(String busiId) throws Exception{
		WarePriceRecordObject object = this.warePriceChangeDAO.findWarePriceRecordObjectByBusiId(busiId);
		if(object != null){
			//设置操作类型 00：礼品新增、01：礼品修改
			if(this.warePriceChangeDAO.isAdd(busiId)){
				object.setOperateCause(WarePriceChangeConstant.WARE_ADD);
			}else{
				object.setOperateCause(WarePriceChangeConstant.WARE_UPDATE);
			}
		}
		return object;
	}
	public String findLastBusiId(String busiId) throws Exception {
		//如果该礼品为新增，就返回该业务标识,因为业务流水表就一条记录。
		if(this.warePriceChangeDAO.isAdd(busiId)){
			return busiId;
		}
		return this.warePriceChangeDAO.findLastBusiId(busiId);
	}
	public String[] findCBusiIdIdByPBusiId(String p_busi_id) throws Exception {
		List<String> result = this.warePriceChangeDAO.findCBusiIdIdByPBusiId(p_busi_id);
		final int size = result.size();
		String[] datas = (String[])result.toArray(new String[size]);
		return datas;
	}
	public WarePriceRecordObject findWarePriceRecordObjectByWareId(String operateCause,String wareId) throws Exception {
		//礼品价格批量是根据礼品编码标识,这里进行转换
		if(wareId != null && wareId.length() <=5){
			wareId=findWareIdByWareCode(wareId);
		}
		WarePriceRecordObject object = this.warePriceChangeDAO.findWarePriceRecordObjectByWareId(wareId);
		if(object != null){
		   object.setOperateCause(operateCause);
		}
		return object;
	}
	public String findBusiId() throws Exception {
		String busiId = DateTimeUtil.getSysDate().concat(this.warePriceChangeDAO.findBusiId());
		return busiId;
	}
	public boolean saveInfoFromFiles(List<WarePriceRecordObject> datas) throws Exception {
		return this.warePriceChangeDAO.saveInfoFromFiles(datas);
	}
	public String findWareIdByWareCode(String wareCode) throws Exception {
		return this.findWareIdByWareCode(wareCode);
	}
}
