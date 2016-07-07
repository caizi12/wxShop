package ngves.asiainfo.core.floor.domain;

import java.sql.Timestamp;

import ngves.asiainfo.core.CoreConstant;
import ngves.asiainfo.core.common.bo.BusiInfoEngine;
import ngves.asiainfo.core.common.util.BusiInfoUtil;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.bo.FloorSubKindBean;
import ngves.asiainfo.core.floor.ivalues.IFloorSubKindValue;
import ngves.asiainfo.core.floor.service.interfaces.IFloorInfoSrv;

import com.ai.appframe2.service.ServiceFactory;

public class FloorSubKindValue {

	private String wareKindId;
	private String floorId;
	private String floorSubName;
	private String floorSubId;
	private String modifyDate;
	private String bakCol1;
	private String createDate;
	private static String field = "BakCol1,WareKindId,FloorId,CreateDate,FloorSubName,FloorSubId,ModifyDate";
	public FloorSubKindValue() {
	}

	public String getWareKindId() {
		return wareKindId;
	}

	public void setWareKindId(String wareKindId) {
		this.wareKindId = wareKindId;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorSubName() {
		return floorSubName;
	}

	public void setFloorSubName(String floorSubName) {
		this.floorSubName = floorSubName;
	}

	public String getFloorSubId() {
		return floorSubId;
	}

	public void setFloorSubId(String floorSubId) {
		this.floorSubId = floorSubId;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getBakCol1() {
		return bakCol1;
	}

	public void setBakCol1(String bakCol1) {
		this.bakCol1 = bakCol1;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public static void toBeans(FloorSubKindValue[] value, IFloorSubKindValue[] ivalue, long floorInfoId,long staffId, String comType, long orgId) {
		if (ivalue == null)
			ivalue = new IFloorSubKindValue[value.length];
		IFloorInfoSrv service = (IFloorInfoSrv) ServiceFactory.getService("ngves.asiainfo.core.floor.FloorInfoService");
		try {
			for (int i = 0; i < value.length; i++) {
				if (!"0".equals(value[i].getFloorSubId())&&!"".equals(value[i].getFloorSubId())) {//修改
					ivalue[i] = service.queryFloorSubKindById(Long.valueOf(value[i].getFloorSubId()).longValue());
					IFloorSubKindValue oldValue=new FloorSubKindBean();
					oldValue.copy(ivalue[i]);
					ivalue[i].setModifyDate(new Timestamp(System.currentTimeMillis()));
					ivalue[i].setFloorSubName(value[i].getFloorSubName());
					ivalue[i].setWareKindId(Long.valueOf(value[i].getWareKindId()).longValue());
					ivalue[i].setFloorId(floorInfoId);
					//记录业务日志信息
					  long busiInfoId = BusiInfoEngine.getNewId().longValue();
					  BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_SUB_MODIFY, -1,
					      "修改楼层关联中类",CoreConstant.BUSI_INFO_OPT_TYPE_MODIFY,"修改楼层关联中类的ID："+value[i].getFloorSubId()+"修改关联中类的名字："+value[i].getFloorSubName(), staffId, comType, orgId);
					 //记录日志详情
					BusiInfoUtil.recordBusiDetail(busiInfoId+"", new Object[]{oldValue}, new Object[]{ivalue[i]}, field);
					  
				}else{//新增
					ivalue[i] = new FloorSubKindBean();
					ivalue[i].setFloorSubId(service.getSubKindNewId());
					ivalue[i].setCreateDate(new Timestamp(System.currentTimeMillis()));
					ivalue[i].setFloorSubName(value[i].getFloorSubName());
					ivalue[i].setWareKindId(Long.valueOf(value[i].getWareKindId()).longValue());
					ivalue[i].setFloorId(floorInfoId);
					//记录业务日志信息
					long busiInfoId = BusiInfoEngine.getNewId().longValue();
				    BusiInfoUtil.recordBusiInfo(busiInfoId + "", FloorConstant.SYS_PARA_BUSI_TYPE_WEB_FLOOR_SUB_CREATE, -1,
					       "新增楼层关联中类",CoreConstant.BUSI_INFO_OPT_TYPE_ADD,"新增楼层关联中类的ID："+value[i].getFloorSubId()+"新增关联中类的名字："+value[i].getFloorSubName(), staffId, comType, orgId);
				}
								
			

			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
