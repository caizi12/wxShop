/**
 * Copyright (c) 2011 asiainfo.com
 */
package ngves.asiainfo.core.system.service.impl;

import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.system.dao.interfaces.IShowControlDAO;
import ngves.asiainfo.core.system.ivalues.IShowControlValue;
import ngves.asiainfo.core.system.service.interfaces.IShowControlSrv;
/**
 * 置灰状态控制
 * @author ggs
 */
public class ShowControlSrvImpl implements IShowControlSrv {

	private IShowControlDAO controlDao;

	private static final String ZHI_HUI = "置灰";

	private static final String BU_ZHI_HUI = "不置灰";

	private static final String HAS_ZHI_HUI = "已经置灰";

	private static final String NO_ZHI_HUI = "未置灰";

	public IShowControlValue[] queryShowControl(String showName, String isGrey, int startIndex, int endIndex)
			throws Exception {

		IShowControlValue[] values = controlDao.queryShowControl(showName, isGrey, startIndex, endIndex);
		for (IShowControlValue v : values) {
			StringBuffer sb = new StringBuffer();
			if (SystemSrvConstant.IS_GREY_YES.equals(v.getIsGrey())) {
				v.setBakCol2(ZHI_HUI);
				sb.append(String.format(SystemSrvConstant.CONTROL_STATE_SHOW_LINK_ON, v.getShowId()));
				v.setBakCol(sb.toString());
			} else {
				v.setBakCol2(BU_ZHI_HUI);
				sb.append(String.format(SystemSrvConstant.CONTROL_STATE_SHOW_LINK_OFF, v.getShowId()));
				v.setBakCol(sb.toString());
			}
		}
		return values;
	}

	public IShowControlValue getControlShowByIdAndModify(String showId) throws Exception {

		IShowControlValue v = controlDao.getControlShowById(showId);
		StringBuffer sb = new StringBuffer();
		if (SystemSrvConstant.IS_GREY_NO.equals(v.getIsGrey())) {
			v.setBakCol2(HAS_ZHI_HUI);
			v.setIsGrey(SystemSrvConstant.IS_GREY_YES);
			sb.append(String.format(SystemSrvConstant.CONTROL_STATE_SHOW_LINK_ON, v.getShowId()));
			v.setBakCol(sb.toString());
		} else {
			v.setIsGrey(SystemSrvConstant.IS_GREY_NO);
			v.setBakCol2(NO_ZHI_HUI);
			sb.append(String.format(SystemSrvConstant.CONTROL_STATE_SHOW_LINK_OFF, v.getShowId()));
			v.setBakCol(sb.toString());
		}
		return v;
	}

	public void saveOrUpdate(IShowControlValue value) throws Exception {

		controlDao.saveOrUpdate(value);
	}

	public IShowControlDAO getControlDao() {
		return controlDao;
	}

	public void setControlDao(IShowControlDAO controlDao) {
		this.controlDao = controlDao;
	}

}
