package ngves.asiainfo.core.floor.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ngves.asiainfo.core.CoreSrvContstant;
import ngves.asiainfo.core.floor.FloorConstant;
import ngves.asiainfo.core.floor.ivalues.INavbarKindInfoValue;
import ngves.asiainfo.core.floor.service.interfaces.INavbarKindInfoSrv;
import ngves.asiainfo.util.MemcachedClientUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ai.appframe2.service.ServiceFactory;
/*
 * 全部分类列表，（启用，没有是否首页展示的限制）
 */
public class NavbarKindUtilAll {
	private static final Log log = LogFactory.getLog(NavbarKindUtilAll.class);

	//一级列表
	private List<INavbarKindInfoValue> oneKindListAll = new ArrayList<INavbarKindInfoValue>();
	// key 为导航id，value是对应的一级信息
	private Map<String, INavbarKindInfoValue[]> oneKindsMapAll = new LinkedHashMap<String, INavbarKindInfoValue[]>();
	// key为一级ID，value为对应的一级信息
	private Map<String, INavbarKindInfoValue> oneKindsAll = new HashMap<String, INavbarKindInfoValue>();
	// key 为一级ID，value是对应的二级信息
	private Map<String, INavbarKindInfoValue[]> twokindsMapAll = new HashMap<String, INavbarKindInfoValue[]>();
	// key 为二级ID，value是对应的二级信息
	private Map<Long, INavbarKindInfoValue> twokindsAll = new HashMap<Long, INavbarKindInfoValue>();

	// key为二级id,value是二级对应的一级id
	private Map<Long, Long> twoRelatParentAll = new HashMap<Long, Long>();
	// key为二级ID，value为二级对应的三级信息
	private Map<String, INavbarKindInfoValue[]> threekindsMapAll = new HashMap<String, INavbarKindInfoValue[]>();
	// key 为三级ID，value是对应的三级信息
	private Map<Long, INavbarKindInfoValue> threekindsAll = new HashMap<Long, INavbarKindInfoValue>();

	// key为三级id,value是三级对应的二级id
	private Map<Long, Long> threeRelatParentAll = new HashMap<Long, Long>();
	
	
	public NavbarKindUtilAll() {

	}
	
	/**
	 * 从数据库中读取数据，初始化大类，小类信息。
	 */
	/**
     * 加上同步锁,避免多线程操作
	 * @throws Exception 
     */
    public synchronized void init()  {
    	
		try {
			log.info("##### Init NavbarKind and Kind is start #####");
			
			initOneKindList();
			initOneKindsMap();
			initOneKinds();
			
			initTwokindsMap();
			initTwokinds();
			initTwoRelatParent();
			
			initThreekindsMap();
			initThreekinds();
			initThreeRelatParent();
			
			log.info("##### Init NavbarKind and Kind is end #####");
		}catch (Exception e) {
			log.error(" NavbarKind init is excep ...", e);
		}
	}
	
    /**
	 * 加载一级列表
	 * 
	 * @return
     * @throws Exception 
	 */
	public List<INavbarKindInfoValue> initOneKindList() throws Exception {	
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的一级
		INavbarKindInfoValue[] parents = navbarKindInfoSrv.getOneNavbarKindInfoForWeb(false);
		//设置parentKindList
		setParentKindList(Arrays.asList(parents));	
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_ONEKINDLIST_ALL, oneKindListAll);
		return oneKindListAll;
	}
	/**
	 * 加载一级Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue[]> initOneKindsMap() throws Exception {	
		if(null==oneKindsMapAll){
			oneKindsMapAll = new LinkedHashMap<String, INavbarKindInfoValue[]>();
		}
		//一级分类，按导航类目分类
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的一级
		INavbarKindInfoValue[] parents = navbarKindInfoSrv.getOneNavbarKindInfoForWeb(false);
		List<INavbarKindInfoValue> values= new ArrayList<INavbarKindInfoValue>();
		String navbarId = "";
		for (int i = 0; i < parents.length; i++) {
			if(i==0){
				values.add(parents[0]);
			}else{
				if(parents[i].getNavbarId() == parents[i-1].getNavbarId()){
					values.add(parents[i]);				
				}else{
					INavbarKindInfoValue[] valuetmps = (INavbarKindInfoValue[]) values.toArray(new INavbarKindInfoValue[0]);
					oneKindsMapAll.put(String.valueOf(valuetmps[0].getNavbarId()),valuetmps);
					values.clear();
					values.add(parents[i]);
				}					
			}	
			navbarId = String.valueOf(parents[i].getNavbarId());
		}
		if( values.size() > 0){
			INavbarKindInfoValue[] valuetmps = (INavbarKindInfoValue[]) values.toArray(new INavbarKindInfoValue[0]);
			oneKindsMapAll.put(navbarId,valuetmps);
			values.clear();
		}
		
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_ONEKINDSMAP_ALL, oneKindsMapAll);	
		return oneKindsMapAll;
	}
	/**
	 * 加载一级单Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue> initOneKinds() throws Exception {
		if(null==oneKindsAll){
			oneKindsAll = new HashMap<String, INavbarKindInfoValue>();
		}
		Map<String, INavbarKindInfoValue> KindMapTmp = new HashMap<String, INavbarKindInfoValue>();
		//一级类目
		for (INavbarKindInfoValue parent : oneKindListAll) {
			
			KindMapTmp.put(String.valueOf(parent.getNavbarKindId()), parent);
			parent = null;
		}
		for(Map.Entry<String, INavbarKindInfoValue> entry  : KindMapTmp.entrySet()){
			oneKindsAll.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_ONEKINDS_ALL, oneKindsAll);
		return oneKindsAll;
	}
	/**
	 * 加载二级Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue[]> initTwokindsMap() throws Exception {	
		if(null==twokindsMapAll){
			twokindsMapAll = new HashMap<String, INavbarKindInfoValue[]>();
		}
		// 取出所有的二级	
		Map<String, INavbarKindInfoValue[]> KindMapTmp = new HashMap<String, INavbarKindInfoValue[]>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		INavbarKindInfoValue[] ks = null;
		for (INavbarKindInfoValue wareParent : oneKindListAll) {
			long wareParentKindId = wareParent.getNavbarKindId();
			ks = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,false);
			KindMapTmp.put(String.valueOf(wareParentKindId), ks);
			ks = null;
			wareParent = null;
		}
		for(Map.Entry<String, INavbarKindInfoValue[]> entry  : KindMapTmp.entrySet()){
			twokindsMapAll.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWOKINDSMAP_ALL, twokindsMapAll);
		return twokindsMapAll;
	}
	/**
	 * 加载二级单Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, INavbarKindInfoValue> initTwokinds() throws Exception {	
		if(null==twokindsAll){
			twokindsAll = new HashMap<Long, INavbarKindInfoValue>();
		}
		Map<Long, INavbarKindInfoValue> kindsTmp = new HashMap<Long, INavbarKindInfoValue>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		INavbarKindInfoValue[] ks = null;
		for (INavbarKindInfoValue wareParent : oneKindListAll) {
			long wareParentKindId = wareParent.getNavbarKindId();
			ks = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,false);
			for (INavbarKindInfoValue kind : ks) {
				kindsTmp.put(kind.getNavbarKindId(), kind);
				kind = null;
			}
			ks = null;
			wareParent = null;
		}
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : kindsTmp.entrySet()){
			twokindsAll.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWOKINDS_ALL, twokindsAll);
		return twokindsAll;
	}
	/**
	 * 加载一二级父子Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, Long> initTwoRelatParent() throws Exception {	
		if(null==twoRelatParentAll){
			twoRelatParentAll = new HashMap<Long, Long>();
		}
		Map<Long, Long> kindRelatParentTmp = new HashMap<Long, Long>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		INavbarKindInfoValue[] ks = null;
		for (INavbarKindInfoValue wareParent : oneKindListAll) {
			long wareParentKindId = wareParent.getNavbarKindId();
			ks = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,false);
			for (INavbarKindInfoValue kind : ks) {
				kindRelatParentTmp.put(kind.getNavbarKindId(), wareParentKindId);
				kind = null;
			}
			ks = null;
			wareParent = null;
		}
		for(Map.Entry<Long, Long> entry  : kindRelatParentTmp.entrySet()){
			twoRelatParentAll.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWORELATPARENT_ALL, twoRelatParentAll);
		return twoRelatParentAll;
	}
	
	/**
	 * 加载三级Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue[]> initThreekindsMap() throws Exception {	
		if(null==threekindsMapAll){
			threekindsMapAll = new HashMap<String, INavbarKindInfoValue[]>();
		}
		Map<String, INavbarKindInfoValue[]> threekindMapTmp = new HashMap<String, INavbarKindInfoValue[]>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的三级
		INavbarKindInfoValue[] thr = null;
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : twokindsAll.entrySet()){
			long wareParentKindId = entry.getKey();
			thr = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,false);
			threekindMapTmp.put(String.valueOf(wareParentKindId), thr);
			thr = null;
			entry = null;
		}
		for(Map.Entry<String, INavbarKindInfoValue[]> entry  : threekindMapTmp.entrySet()){
			threekindsMapAll.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_THREEKINDSMAP_ALL, threekindsMapAll);
		return threekindsMapAll;
	}
	/**
	 * 加载二级单Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, INavbarKindInfoValue> initThreekinds() throws Exception {	
		if(null==threekindsAll){
			threekindsAll = new HashMap<Long, INavbarKindInfoValue>();
		}
		Map<Long, INavbarKindInfoValue> thrkindsTmp = new HashMap<Long, INavbarKindInfoValue>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的三级
		INavbarKindInfoValue[] thr = null;
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : twokindsAll.entrySet()){
			long wareParentKindId = entry.getKey();
			thr = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,false);
			for (INavbarKindInfoValue kind : thr) {
				thrkindsTmp.put(kind.getNavbarKindId(), kind);
				kind = null;
			}
			thr = null;
			entry = null;
		}
		
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : thrkindsTmp.entrySet()){
			threekindsAll.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_THREEKINDS_ALL, threekindsAll);
		return 	threekindsAll;
	}
	/**
	 * 加载一二级父子Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, Long> initThreeRelatParent() throws Exception {	
		if(null==threeRelatParentAll){
			threeRelatParentAll = new HashMap<Long, Long>();
		}
		Map<Long, Long> thrkindRelatParentTmp = new HashMap<Long, Long>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的三级
		INavbarKindInfoValue[] thr = null;
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : twokindsAll.entrySet()){
			long wareParentKindId = entry.getKey();
			thr = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,false);
			for (INavbarKindInfoValue kind : thr) {
				thrkindRelatParentTmp.put(kind.getNavbarKindId(), wareParentKindId);
				kind = null;
			}
			thr = null;
			entry = null;
		}		
		for(Map.Entry<Long, Long> entry  : thrkindRelatParentTmp.entrySet()){
			threeRelatParentAll.put(entry.getKey(),entry.getValue());
		}	
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_THREERELATPARENT_ALL, threeRelatParentAll);
		return threeRelatParentAll;
	}
	
	
	/**
	 * 获取所有一级Map
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, INavbarKindInfoValue[]> getAllOneNavbarKind() throws Exception {
		try {
			oneKindsMapAll = (Map<String, INavbarKindInfoValue[]>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_ONEKINDSMAP_ALL);
		} catch (Exception e) {
			log.error("get oneKindsMapAll from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==oneKindsMapAll){
				initOneKindList();
				initOneKindsMap();
			}		    
		}
		return oneKindsMapAll;
	}
	
	/**
	 * 获取所有一级列表
	 * 
	 * @return
	 * @throws Exception 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<INavbarKindInfoValue> getParentKindList() throws Exception {
		try {
			oneKindListAll = (List<INavbarKindInfoValue>)MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_ONEKINDLIST_ALL);
		} catch (Exception e) {
			log.error("get oneKindListAll from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==oneKindListAll){
				initOneKindList();
			}		    
		}
		return oneKindListAll;
	}

	public void setParentKindList(List<INavbarKindInfoValue> parentKindList) {
		this.oneKindListAll = parentKindList;
	}
	/**
	 * 根据大类ID获取大类信息
	 * 
	 * @param parentKindId
	 * @return
	 * @throws Exception 
	 */
	public INavbarKindInfoValue getOneNavbarKind(String navbarKindId) throws Exception {
		if(null==oneKindsAll || oneKindsAll.isEmpty()){
			initOneKindList();
			initOneKinds();
		}	
		return oneKindsAll.get(navbarKindId);
	}
	/**
	 * 获取所有二级Map
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, INavbarKindInfoValue[]> getAllTwoNavbarKind() throws Exception {
		try {
			twokindsMapAll = (Map<String, INavbarKindInfoValue[]>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_TWOKINDSMAP_ALL);
		} catch (Exception e) {
			log.error("get twokindsMapAll from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==twokindsMapAll){
				initOneKindList();
				initTwokindsMap();
			}		    
		}
		return twokindsMapAll;
	}
	
	/**
	 * 根据一级的ID获取相应的二级Map
	 * 
	 * @param wareParentKindId
	 * @return
	 * @throws Exception 
	 */
	public INavbarKindInfoValue[] getTwoNavbarKind(String navbarKindId) throws Exception {
		if(null==twokindsMapAll || twokindsMapAll.isEmpty()){
			this.getAllTwoNavbarKind();
		}
		return twokindsMapAll.get(navbarKindId);
	}
	
	/**
	 * 获取所有二级id对应存放二级信息的map
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map<Long, INavbarKindInfoValue> getAllTwoNavbarKindInfo() throws Exception {
		try {
			twokindsAll = (Map<Long, INavbarKindInfoValue>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_TWOKINDS_ALL);
		} catch (Exception e) {
			log.error("get threekindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==twokindsAll){
				initOneKindList();
				initTwokinds();
			}		    
		}
		return twokindsAll;
	}
	
	/**
	 * 根据二级的ID获取相应的二级信息
	 * @param navbarKindId
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue getTwoNavbarKindInfo(String navbarKindId) throws Exception {
		
		if(null==twokindsAll || twokindsAll.isEmpty()){
			this.getAllTwoNavbarKindInfo();
		}
		return twokindsAll.get(navbarKindId);
	}

	
	/**
	 * 获取所有三级的信息
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, INavbarKindInfoValue[]> getAllThreeNavbarKind() throws Exception {
		try {
			threekindsMapAll = (Map<String, INavbarKindInfoValue[]>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_THREEKINDSMAP_ALL);
		} catch (Exception e) {
			log.error("get threekindsMapAll from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==threekindsMapAll){
				initOneKindList();
				initTwokinds();
				initThreekindsMap();
			}		    
		}
		return threekindsMapAll;
	}
	
	/**
	 * 根据二级的ID获取相应的三级信息
	 * 
	 * @param wareParentKindId
	 * @return
	 * @throws Exception 
	 */
	public INavbarKindInfoValue[] getThreeNavbarKind(String navbarKindId) throws Exception {
		if(null==threekindsMapAll || threekindsMapAll.isEmpty()){
			this.getAllThreeNavbarKind();
		}
		return threekindsMapAll.get(navbarKindId);
	}
	
	
	/**
	 * 获取所有三级id对应存放三级信息的map
	 * 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map<Long, INavbarKindInfoValue> getAllThreeNavbarKindInfo() throws Exception {
		try {
			threekindsAll = (Map<Long, INavbarKindInfoValue>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_THREEKINDS_ALL);
		} catch (Exception e) {
			log.error("get threekindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==threekindsAll){
				initOneKindList();
				initTwokinds();
				initThreekinds();
			}		    
		}
		return threekindsAll;
	}
	
	
	/**
	 * 根据三级的ID获取相应的三级信息
	 * @param navbarKindId
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue getThreeNavbarKindInfo(String navbarKindId) throws Exception {
		
		if(null==threekindsAll || threekindsAll.isEmpty()){
			this.getAllThreeNavbarKindInfo();
		}
		return threekindsAll.get(navbarKindId);
	}
	
	/**
	 * 根据二、三级id获取相对应的二、三级信息
	 * @param navbarKindId
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue getNavbarKindInfo(long navbarKindId) throws Exception {
		
		INavbarKindInfoValue value = null;
		
		if(null==twokindsAll || twokindsAll.isEmpty()){
			this.getAllTwoNavbarKindInfo();
		}
		value = twokindsAll.get(navbarKindId);
		
		if( null == value || value.getNavbarKindId() == 0){
			if(null==threekindsAll || threekindsAll.isEmpty()){
				this.getAllThreeNavbarKindInfo();
			}
			value = threekindsAll.get(navbarKindId);
		}
		return value;
	}

	
	
}
