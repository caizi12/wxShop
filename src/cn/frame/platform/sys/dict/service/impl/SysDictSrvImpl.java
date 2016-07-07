package cn.frame.platform.sys.dict.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.SysDict;
import cn.frame.platform.sys.dict.dao.SysDictDao;
import cn.frame.platform.sys.dict.service.SysDictSrv;

@Service("sysDictSrv")
public class SysDictSrvImpl implements SysDictSrv {
    
	@Autowired
	public SysDictDao sysDictDao;


    public void insertSysDict(SysDict sysDict)  {
    	sysDictDao.insertSysDict(sysDict);
    }

	public int deleteSysDict(String dictId) {
		return sysDictDao.deleteSysDict(Integer.valueOf(dictId));
	}

	public int batchDeleteSysDict(String[] dictIds) {
		int i=0;
		for(String dict:dictIds){
			i+=sysDictDao.deleteSysDict(Integer.valueOf(dict));
		}
		return i;
	}
	
	public List<SysDict> querySysDictList(Map<String,String> map,DataGridModel dataGrid) {
		return  sysDictDao.querySysDictList(map, dataGrid);
	}
	
	public DataGridModel querySysDictForPage(DataGridModel dataGrid) {
		return  sysDictDao.querySysDictForPage(dataGrid);
	}
	
	/**
	 * 查询字典项
	 */
	public List<SysDict> querySysDictByDictValue(Map<String,String> map) {
		map.put("dictType", "1");
		map.put("status", ConstantPlatform.DICT_STATUS_NORMAL);
		return  sysDictDao.querySysDictByDictValue(map);
	}
	
	/**
	 * 查询某个字典项的名称
	 * @param map
	 * @return
	 */
	public String querySysDictName(Map<String,String> map) {
		map.put("status", ConstantPlatform.DICT_STATUS_NORMAL);
		List<SysDict> dictList= sysDictDao.querySysDictByDictValue(map);
		
		if(dictList.size()>0)return dictList.get(0).getDictName();
			
		return "";
	}

	@SuppressWarnings("unchecked")
	public List<SysDict> querySysDictType(Map<String,String> map) {
		if(map==null){map=new HashMap();}
		map.put("dictType", "0");
		return sysDictDao.querySysDictType(map);
	}
	
	public SysDict selectSysDictById(Integer dictId) {
		return (SysDict) sysDictDao.selectSysDictById(dictId);
	}

	public int updateSysDict(SysDict sysDict) {
		return  sysDictDao.updateSysDict(sysDict);
	}
	
	/**
	 * 批量新增，修改业务字典
	 * @param sysDicts
	 * @return
	 */
	public int batchSaveSysDict(SysDict[] sysDicts) {
		int i=0;
		for(SysDict sysDict:sysDicts){
			if(sysDict.getDictId()!=null&&sysDict.getDictId()>0){
				i=+sysDictDao.updateSysDict(sysDict);
			}else{
				sysDictDao.insertSysDict(sysDict);
				i++;
			}	
		}
		return  i;
	}

}