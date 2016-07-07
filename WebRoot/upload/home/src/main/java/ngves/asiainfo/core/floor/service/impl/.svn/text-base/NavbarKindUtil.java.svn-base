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
import com.ai.appframe2.util.StringUtils;

public class NavbarKindUtil {
	private static final Log log = LogFactory.getLog(NavbarKindUtil.class);

	//一级列表
	private List<INavbarKindInfoValue> oneKindList = new ArrayList<INavbarKindInfoValue>();
	// key 为导航id，value是对应的一级信息
	private Map<String, INavbarKindInfoValue[]> oneKindsMap = new LinkedHashMap<String, INavbarKindInfoValue[]>();
	// key为一级ID，value为对应的一级信息
	private Map<String, INavbarKindInfoValue> oneKinds = new HashMap<String, INavbarKindInfoValue>();
	// key 为一级ID，value是对应的二级信息
	private Map<String, INavbarKindInfoValue[]> twokindsMap = new HashMap<String, INavbarKindInfoValue[]>();
	// key 为二级ID，value是对应的二级信息
	private Map<Long, INavbarKindInfoValue> twokinds = new HashMap<Long, INavbarKindInfoValue>();

	// key为二级id,value是二级对应的一级id
	private Map<Long, Long> twoRelatParent = new HashMap<Long, Long>();
	// key为二级ID，value为二级对应的三级信息
	private Map<String, INavbarKindInfoValue[]> threekindsMap = new HashMap<String, INavbarKindInfoValue[]>();
	// key 为三级ID，value是对应的三级信息
	private Map<Long, INavbarKindInfoValue> threekinds = new HashMap<Long, INavbarKindInfoValue>();

	// key为三级id,value是三级对应的二级id
	private Map<Long, Long> threeRelatParent = new HashMap<Long, Long>();
	
	// 拼好的前台导航html
	private String navigationHtmlInfo = "";
	
	public NavbarKindUtil() {

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
			
			initNavigationHtmlInfo();
			
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
		INavbarKindInfoValue[] parents = navbarKindInfoSrv.getOneNavbarKindInfoForWeb(true);
		//设置parentKindList
		setParentKindList(Arrays.asList(parents));	
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_ONEKINDLIST, oneKindList);
		return oneKindList;
	}
	/**
	 * 加载一级Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue[]> initOneKindsMap() throws Exception {	
		if(null==oneKindsMap){
			oneKindsMap = new LinkedHashMap<String, INavbarKindInfoValue[]>();
		}
		//一级分类，按导航类目分类
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的一级
		INavbarKindInfoValue[] parents = navbarKindInfoSrv.getOneNavbarKindInfoForWeb(true);
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
					oneKindsMap.put(String.valueOf(valuetmps[0].getNavbarId()),valuetmps);
					values.clear();
					values.add(parents[i]);
				}					
			}	
			navbarId = String.valueOf(parents[i].getNavbarId());
		}
		if( values.size() > 0){
			INavbarKindInfoValue[] valuetmps = (INavbarKindInfoValue[]) values.toArray(new INavbarKindInfoValue[0]);
			oneKindsMap.put(navbarId,valuetmps);
			values.clear();
		}
		
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_ONEKINDSMAP, oneKindsMap);	
		return oneKindsMap;
	}
	/**
	 * 加载一级单Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue> initOneKinds() throws Exception {
		if(null==oneKinds){
			oneKinds = new HashMap<String, INavbarKindInfoValue>();
		}
		Map<String, INavbarKindInfoValue> KindMapTmp = new HashMap<String, INavbarKindInfoValue>();
		//一级类目
		for (INavbarKindInfoValue parent : oneKindList) {
			
			KindMapTmp.put(String.valueOf(parent.getNavbarKindId()), parent);
			parent = null;
		}
		for(Map.Entry<String, INavbarKindInfoValue> entry  : KindMapTmp.entrySet()){
			oneKinds.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_ONEKINDS, oneKinds);
		return oneKinds;
	}
	/**
	 * 加载二级Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue[]> initTwokindsMap() throws Exception {	
		if(null==twokindsMap){
			twokindsMap = new HashMap<String, INavbarKindInfoValue[]>();
		}
		// 取出所有的二级	
		Map<String, INavbarKindInfoValue[]> KindMapTmp = new HashMap<String, INavbarKindInfoValue[]>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		INavbarKindInfoValue[] ks = null;
		for (INavbarKindInfoValue wareParent : oneKindList) {
			long wareParentKindId = wareParent.getNavbarKindId();
			ks = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,true);
			KindMapTmp.put(String.valueOf(wareParentKindId), ks);
			ks = null;
			wareParent = null;
		}
		for(Map.Entry<String, INavbarKindInfoValue[]> entry  : KindMapTmp.entrySet()){
			twokindsMap.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWOKINDSMAP, twokindsMap);
		return twokindsMap;
	}
	/**
	 * 加载二级单Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, INavbarKindInfoValue> initTwokinds() throws Exception {	
		if(null==twokinds){
			twokinds = new HashMap<Long, INavbarKindInfoValue>();
		}
		Map<Long, INavbarKindInfoValue> kindsTmp = new HashMap<Long, INavbarKindInfoValue>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		INavbarKindInfoValue[] ks = null;
		for (INavbarKindInfoValue wareParent : oneKindList) {
			long wareParentKindId = wareParent.getNavbarKindId();
			ks = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,true);
			for (INavbarKindInfoValue kind : ks) {
				kindsTmp.put(kind.getNavbarKindId(), kind);
				kind = null;
			}
			ks = null;
			wareParent = null;
		}
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : kindsTmp.entrySet()){
			twokinds.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWOKINDS, twokinds);
		return twokinds;
	}
	/**
	 * 加载一二级父子Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, Long> initTwoRelatParent() throws Exception {	
		if(null==twoRelatParent){
			twoRelatParent = new HashMap<Long, Long>();
		}
		Map<Long, Long> kindRelatParentTmp = new HashMap<Long, Long>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		INavbarKindInfoValue[] ks = null;
		for (INavbarKindInfoValue wareParent : oneKindList) {
			long wareParentKindId = wareParent.getNavbarKindId();
			ks = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,true);
			for (INavbarKindInfoValue kind : ks) {
				kindRelatParentTmp.put(kind.getNavbarKindId(), wareParentKindId);
				kind = null;
			}
			ks = null;
			wareParent = null;
		}
		for(Map.Entry<Long, Long> entry  : kindRelatParentTmp.entrySet()){
			twoRelatParent.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWORELATPARENT, twoRelatParent);
		return twoRelatParent;
	}
	
	/**
	 * 加载三级Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<String, INavbarKindInfoValue[]> initThreekindsMap() throws Exception {	
		if(null==threekindsMap){
			threekindsMap = new HashMap<String, INavbarKindInfoValue[]>();
		}
		Map<String, INavbarKindInfoValue[]> threekindMapTmp = new HashMap<String, INavbarKindInfoValue[]>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的三级
		INavbarKindInfoValue[] thr = null;
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : twokinds.entrySet()){
			long wareParentKindId = entry.getKey();
			thr = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,true);
			threekindMapTmp.put(String.valueOf(wareParentKindId), thr);
			thr = null;
			entry = null;
		}
		for(Map.Entry<String, INavbarKindInfoValue[]> entry  : threekindMapTmp.entrySet()){
			threekindsMap.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_THREEKINDSMAP, threekindsMap);
		return threekindsMap;
	}
	/**
	 * 加载二级单Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, INavbarKindInfoValue> initThreekinds() throws Exception {	
		if(null==threekinds){
			threekinds = new HashMap<Long, INavbarKindInfoValue>();
		}
		Map<Long, INavbarKindInfoValue> thrkindsTmp = new HashMap<Long, INavbarKindInfoValue>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的三级
		INavbarKindInfoValue[] thr = null;
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : twokinds.entrySet()){
			long wareParentKindId = entry.getKey();
			thr = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,true);
			for (INavbarKindInfoValue kind : thr) {
				thrkindsTmp.put(kind.getNavbarKindId(), kind);
				kind = null;
			}
			thr = null;
			entry = null;
		}
		
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : thrkindsTmp.entrySet()){
			threekinds.put(entry.getKey(),entry.getValue());
		}
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_THREEKINDS, threekinds);
		return 	threekinds;
	}
	/**
	 * 加载一二级父子Map
	 * 
	 * @return
     * @throws Exception 
	 */
	public Map<Long, Long> initThreeRelatParent() throws Exception {	
		if(null==threeRelatParent){
			threeRelatParent = new HashMap<Long, Long>();
		}
		Map<Long, Long> thrkindRelatParentTmp = new HashMap<Long, Long>();
		INavbarKindInfoSrv navbarKindInfoSrv = (INavbarKindInfoSrv) ServiceFactory.getService(CoreSrvContstant.SERVICE_NAVBARKIND_INFO_SRV);
		// 取出所有的三级
		INavbarKindInfoValue[] thr = null;
		for(Map.Entry<Long, INavbarKindInfoValue> entry  : twokinds.entrySet()){
			long wareParentKindId = entry.getKey();
			thr = navbarKindInfoSrv.getValueByparentNavbarForWeb(wareParentKindId,true);
			for (INavbarKindInfoValue kind : thr) {
				thrkindRelatParentTmp.put(kind.getNavbarKindId(), wareParentKindId);
				kind = null;
			}
			thr = null;
			entry = null;
		}		
		for(Map.Entry<Long, Long> entry  : thrkindRelatParentTmp.entrySet()){
			threeRelatParent.put(entry.getKey(),entry.getValue());
		}	
		MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_THREERELATPARENT, threeRelatParent);
		return threeRelatParent;
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
			oneKindsMap = (Map<String, INavbarKindInfoValue[]>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_ONEKINDSMAP);
		} catch (Exception e) {
			log.error("get oneKindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==oneKindsMap){
				initOneKindList();
				initOneKindsMap();
			}		    
		}
		return oneKindsMap;
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
			oneKindList = (List<INavbarKindInfoValue>)MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_ONEKINDLIST);
		} catch (Exception e) {
			log.error("get oneKindList from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==oneKindList){
				initOneKindList();
			}		    
		}
		return oneKindList;
	}

	public void setParentKindList(List<INavbarKindInfoValue> parentKindList) {
		this.oneKindList = parentKindList;
	}
	/**
	 * 根据大类ID获取大类信息
	 * 
	 * @param parentKindId
	 * @return
	 * @throws Exception 
	 */
	public INavbarKindInfoValue getOneNavbarKind(String navbarKindId) throws Exception {
		if(null==oneKinds || oneKinds.isEmpty()){
			initOneKindList();
			initOneKinds();
		}	
		return oneKinds.get(navbarKindId);
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
			twokindsMap = (Map<String, INavbarKindInfoValue[]>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_TWOKINDSMAP);
		} catch (Exception e) {
			log.error("get twokindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==twokindsMap){
				initOneKindList();
				initTwokindsMap();
			}		    
		}
		return twokindsMap;
	}
	
	/**
	 * 根据一级的ID获取相应的二级Map
	 * 
	 * @param wareParentKindId
	 * @return
	 * @throws Exception 
	 */
	public INavbarKindInfoValue[] getTwoNavbarKind(String navbarKindId) throws Exception {
		if(null==twokindsMap || twokindsMap.isEmpty()){
			this.getAllTwoNavbarKind();
		}
		return twokindsMap.get(navbarKindId);
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
			//MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_TWOKINDS, twokinds);
			twokinds = (Map<Long, INavbarKindInfoValue>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_TWOKINDS);
		} catch (Exception e) {
			log.error("get threekindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==twokinds){
				initOneKindList();
				initTwokinds();
			}		    
		}
		return twokinds;
	}
	
	/**
	 * 根据二级的ID获取相应的二级信息
	 * @param navbarKindId
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue getTwoNavbarKindInfo(String navbarKindId) throws Exception {
		
		if(null==twokinds || twokinds.isEmpty()){
			this.getAllTwoNavbarKindInfo();
		}
		return twokinds.get(navbarKindId);
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
			threekindsMap = (Map<String, INavbarKindInfoValue[]>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_THREEKINDSMAP);
		} catch (Exception e) {
			log.error("get threekindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==threekindsMap){
				initOneKindList();
				initTwokinds();
				initThreekindsMap();
			}		    
		}
		return threekindsMap;
	}
	
	/**
	 * 根据二级的ID获取相应的三级信息
	 * 
	 * @param wareParentKindId
	 * @return
	 * @throws Exception 
	 */
	public INavbarKindInfoValue[] getThreeNavbarKind(String navbarKindId) throws Exception {
		if(null==threekindsMap || threekindsMap.isEmpty()){
			this.getAllThreeNavbarKind();
		}
		return threekindsMap.get(navbarKindId);
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
			threekinds = (Map<Long, INavbarKindInfoValue>) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_THREEKINDS);
		} catch (Exception e) {
			log.error("get threekindsMap from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，从数据库重新加载
			if(null==threekinds){
				initOneKindList();
				initTwokinds();
				initThreekinds();
			}		    
		}
		return threekinds;
	}
	
	
	/**
	 * 根据三级的ID获取相应的三级信息
	 * @param navbarKindId
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue getThreeNavbarKindInfo(String navbarKindId) throws Exception {
		
		if(null==threekinds || threekinds.isEmpty()){
			this.getAllThreeNavbarKindInfo();
		}
		return threekinds.get(navbarKindId);
	}
	
	/**
	 * 根据二、三级id获取相对应的二、三级信息
	 * @param navbarKindId
	 * @return
	 * @throws Exception
	 */
	public INavbarKindInfoValue getNavbarKindInfo(String navbarKindId) throws Exception {
		
		INavbarKindInfoValue value = null;
		
		if(null==twokinds || twokinds.isEmpty()){
			this.getAllTwoNavbarKindInfo();
		}
		value = twokinds.get(navbarKindId);
		
		if( null == value || value.getNavbarKindId() == 0){
			if(null==threekinds || threekinds.isEmpty()){
				this.getAllThreeNavbarKindInfo();
			}
			value = threekinds.get(navbarKindId);
		}
		return value;
	}
	
	/**
	 * 初始化拼好前台导航html
	 * 
	 * @param wareParentKindId
	 * @return
	 * @throws Exception 
	 */
	public void initNavigationHtmlInfo() throws Exception {

		Map<String, INavbarKindInfoValue[]> oneValues = this.getAllOneNavbarKind();
		String htmlStr = "";
        for(Map.Entry<String, INavbarKindInfoValue[]> entry  : oneValues.entrySet()){
        	INavbarKindInfoValue[] oneKeyValues = entry.getValue();
			htmlStr+="<div class=\"item\">";
			int headalllength = 1;
			int totallength = 12;
			htmlStr+="<h3>";
			for ( int j = 0; j < oneKeyValues.length; j++) {
				int onelength = oneKeyValues[j].getKindName().length();
				headalllength+=onelength;
				htmlStr+="<a href=\"#\" onclick=\"searchNaviWare('"+oneKeyValues[j].getKindContent()+"','"+oneKeyValues[j].getKindType()+"','"+oneKeyValues[j].getKindName()+"');\">";
				if(headalllength<totallength){
					htmlStr+=oneKeyValues[j].getKindName();
				}else{
					htmlStr+=oneKeyValues[j].getKindName().substring(0,((totallength+onelength-headalllength)<0?0:(totallength+onelength-headalllength))>onelength?onelength:((totallength+onelength-headalllength)<0?0:(totallength+onelength-headalllength)));
				}
				htmlStr+="</a>";
				if(j!=oneKeyValues.length-1){
					htmlStr+="、";
				}
				if(j==oneKeyValues.length-1){
					htmlStr+="<i>></i>";
				}
				headalllength+=1;
			}
			htmlStr+="</h3>";
			htmlStr+="<div class=\"p_item-list clearfix\">";
			htmlStr+="<div class=\"subitem\">";
			for ( int k = 0; k < oneKeyValues.length; k++) {
				INavbarKindInfoValue[] twoKeyValues = this.getTwoNavbarKind(String.valueOf(oneKeyValues[k].getNavbarKindId()));
				for (int l = 0; l < twoKeyValues.length; l++) {
					htmlStr+="<dl class=\"fore"+l+"\">";
					htmlStr+="<dt><a href=\"#\" onclick=\"searchNaviWare('"+oneKeyValues[k].getKindContent()+"','"+oneKeyValues[k].getKindType()+"','"+oneKeyValues[k].getKindName()+"','"+twoKeyValues[l].getKindContent()+"','"+twoKeyValues[l].getKindType()+"','"+twoKeyValues[l].getKindName()+"');\">"+twoKeyValues[l].getKindName()+"</a></dt>";
					htmlStr+="<dd>";
					INavbarKindInfoValue[] threeKeyValues = this.getThreeNavbarKind(String.valueOf(twoKeyValues[l].getNavbarKindId()));
					for ( int m = 0; m < threeKeyValues.length; m++) {
						htmlStr+="<em><a href=\"#\" onclick=\"searchNaviWare('"+oneKeyValues[k].getKindContent()+"','"+oneKeyValues[k].getKindType()+"','"+oneKeyValues[k].getKindName()+"','"+twoKeyValues[l].getKindContent()+"','"+twoKeyValues[l].getKindType()+"','"+twoKeyValues[l].getKindName()+"','"+threeKeyValues[m].getKindContent()+"','"+threeKeyValues[m].getKindType()+"','"+threeKeyValues[m].getKindName()+"');\">"+threeKeyValues[m].getKindName()+"</a></em>";
					}
					htmlStr+="</dd>";						
					htmlStr+="</dl>";
				}
			}	
			htmlStr+="</div>";						
			htmlStr+="</div>";
			htmlStr+="</div>";			
        }
        navigationHtmlInfo = htmlStr;
        MemcachedClientUtil.setObject(FloorConstant.MEMCACHED_KEY_NAVIGATIONHTMLINFO, navigationHtmlInfo);	
	}
	
	/**
	 * 获取拼好前台导航html
	 * 
	 * @param wareParentKindId
	 * @return
	 * @throws Exception 
	 */
	public String getNavigationHtmlInfo() throws Exception {
		try {
			navigationHtmlInfo = (String) MemcachedClientUtil.getObject(FloorConstant.MEMCACHED_KEY_NAVIGATIONHTMLINFO);
		} catch (Exception e) {
			log.error("get navigationHtmlInfo from mem ERR!", e);
			e.printStackTrace();	
		}finally{
			//缓存中取不到数据的时候，再拼一次并加到缓存中去
			if(StringUtils.isEmptyString(navigationHtmlInfo)){
				initNavigationHtmlInfo();
			}		    
		}
		return navigationHtmlInfo;
	}
}
