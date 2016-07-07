package ngves.asiainfo.core.tuan.dao.interfaces;

import ngves.asiainfo.core.tuan.ivalues.ITuanProvinceValue;

/**
 * 
 * @author liuyq
 * @date 2011-07-15
 * @purpose 团购活动中涉及到不生效省份信息的处理
 * 
 */
public interface ITuanProvinceDAO {

	/**
	 * @purpose 根据团购活动ID 查询出所有团购活动不生效的省份信息
	 * @param tuanId
	 * @return
	 * @throws Exception
	 * @date 2011-07-15
	 */
	public ITuanProvinceValue[] queryTuanProvinceById(String tuanId) throws Exception;

	/**
	 * @purpose 添加团购活动时，添加团购活动不生效的省份信息，
	 * @param value
	 *            团购活动对应不生效省份信息数组 DAO层代码不做value为空的判断
	 * @return
	 * @throws Exception
	 *             团购活动省份信息添加失败后，会抛出异常
	 * @date 2011-07-15
	 */
	public void addTuanProvince(ITuanProvinceValue[] value) throws Exception;

	/**
	 * @purpose 修改团购活动时， <li>1、先删除团购活动对应的原来不生效省份信息数据。</li> <li>2、然后再添加新数据。</li>
	 *          这里只做删除操作，修改操作借鉴addTuanProvince(ITuanProvinceValue [] value);
	 * @param tuanId
	 * @return
	 * @throws Exception
	 * @date 2011-07-15
	 */
	public void deleteTuanProvinceById(String tuanId) throws Exception;
}
