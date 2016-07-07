package cn.frame.platform.sys.dict.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.SysDict;

public interface SysDictSrv {
	
	public void insertSysDict(SysDict sysDict) ;

    public int updateSysDict(SysDict sysDict) ;

    public List<SysDict> querySysDictList(Map<String,String> map,DataGridModel dataGrid) ;
    
    public DataGridModel querySysDictForPage(DataGridModel dataGrid);
    
    public List<SysDict> querySysDictType(Map<String,String> map);
    
    public List<SysDict> querySysDictByDictValue(Map<String,String> map);

    public SysDict selectSysDictById(Integer dictId) ;

    public int deleteSysDict(String dictIds) ;
    
    public int batchDeleteSysDict(String[] dictIds);
    
    public int batchSaveSysDict(SysDict[] sysDicts);
    
	public String querySysDictName(Map<String,String> map);
   
}