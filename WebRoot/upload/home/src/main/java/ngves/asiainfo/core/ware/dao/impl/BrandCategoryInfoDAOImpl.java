package ngves.asiainfo.core.ware.dao.impl;

import java.util.Map;

import ngves.asiainfo.core.ware.bo.BrandCategoryInfoEngine;
import ngves.asiainfo.core.ware.dao.interfaces.IBrandCategoryInfoDAO;
import ngves.asiainfo.core.ware.ivalues.IBrandCategoryInfoValue;

public class BrandCategoryInfoDAOImpl implements IBrandCategoryInfoDAO {

	public IBrandCategoryInfoValue[] getBrandCategoryInfo(String condition, Map<String, String> parameter)
			throws Exception {
		IBrandCategoryInfoValue[] value = BrandCategoryInfoEngine.getBeans(condition, parameter);
		return value;
	}

	public IBrandCategoryInfoValue getBrandCategoryInfoById(long id) throws Exception {
		//IBrandCategoryInfoValue value = BrandCategoryInfoEngine.
		return null;
	}

	public long saveBrandCategoryInfo(IBrandCategoryInfoValue value) throws Exception {
		BrandCategoryInfoEngine.save(value);
		return value.getCategoryId();
	}

	public void saveBrandCategoryInfo(IBrandCategoryInfoValue[] value) throws Exception {
		BrandCategoryInfoEngine.save(value);

	}

}
