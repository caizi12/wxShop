package ngves.asiainfo.core.tuan.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.system.SystemSrvConstant;
import ngves.asiainfo.core.tuan.dao.interfaces.ICategoryShowControlDAO;
import ngves.asiainfo.core.tuan.ivalues.ICategoryShowControlValue;
import ngves.asiainfo.core.tuan.service.interfaces.ICategoryShowControlSrv;

public class CategoryShowControlSrvImpl implements ICategoryShowControlSrv {

	@SuppressWarnings("unused")
	private static Log logger =LogFactory.getLog(CategoryShowControlSrvImpl.class);
	private ICategoryShowControlDAO categoryShowControlDAO;
	public void setCategoryShowControlDAO(ICategoryShowControlDAO categoryShowControlDAO) throws Exception {
		this.categoryShowControlDAO = categoryShowControlDAO;
	}

	private static final String IS_SHOW = "显示";
	private static final String IS_NOT_SHOW = "不显示";
	private static final String HAS_SHOW = "已经显示";
	private static final String HAS_NOT_SHOW= "未显示";
	
	public ICategoryShowControlValue getControlShowByIdAndModify(String showId) throws Exception {
		
		ICategoryShowControlValue v = categoryShowControlDAO.getControlShowById(showId);
		StringBuffer sb = new StringBuffer();
		if (SystemSrvConstant.IS_SHOW_NO.equals(v.getIsShow())) {
			v.setBakCol2(HAS_SHOW);
			v.setIsShow(SystemSrvConstant.IS_SHOW_YES);
			sb.append(String.format(SystemSrvConstant.CATEGORY_STATE_SHOW_LINK_ON, v.getShowId()));
			v.setBakCol(sb.toString());
		} else {
			v.setIsShow(SystemSrvConstant.IS_SHOW_NO);
			v.setBakCol2(HAS_NOT_SHOW);
			sb.append(String.format(SystemSrvConstant.CATEGORY_STATE_SHOW_LINK_OFF, v.getShowId()));
			v.setBakCol(sb.toString());
		}
		return v;
	}

	public ICategoryShowControlValue[] queryCategoryShowControl(String showName, String is_show, int startIndex, int endIndex)
			throws Exception {
		
		ICategoryShowControlValue[] values = categoryShowControlDAO.queryCategoryShowControl(showName, is_show, startIndex, endIndex);
		for (ICategoryShowControlValue v : values) {
			StringBuffer sb = new StringBuffer();
			if (SystemSrvConstant.IS_SHOW_YES.equals(v.getIsShow())) {
				v.setBakCol2(IS_SHOW);
				sb.append(String.format(SystemSrvConstant.CATEGORY_STATE_SHOW_LINK_ON, v.getShowId()));
				v.setBakCol(sb.toString());
			} else {
				v.setBakCol2(IS_NOT_SHOW);
				sb.append(String.format(SystemSrvConstant.CATEGORY_STATE_SHOW_LINK_OFF, v.getShowId()));
				v.setBakCol(sb.toString());
			}
		}
		return values;
	}

	public void saveOrUpdate(ICategoryShowControlValue value) throws Exception {
		
		categoryShowControlDAO.saveOrUpdate(value);
	}
}
