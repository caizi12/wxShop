/**
 * 
 */
package ngves.asiainfo.core.common.cache;

/**
 * 缓存加载操作接口
 * @author wzg
 *
 */
public interface ICacheLoader<V> {
	
	/**
	 * 根据key查询需要放入到缓存的数据
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public V findBeansByKey(String key) throws Exception;
		
}
