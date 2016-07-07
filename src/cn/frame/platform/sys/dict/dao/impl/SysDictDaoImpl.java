package cn.frame.platform.sys.dict.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.SysDict;
import cn.frame.platform.sys.dict.dao.SysDictDao;

@Repository("sysDictDao")
public class SysDictDaoImpl implements SysDictDao {
    
	@Autowired
	public BaseDaoTemplate baseDao;


    public void insertSysDict(SysDict sysDict)  {
    	sysDict.setDictId(baseDao.getColumnMaxValueForInt("sys_dict", "dict_id")+1);
    	sysDict.setCreateDate(new Date());
        baseDao.getIbatisTemplate().insert("insertSysDict", sysDict);
    }

	public int deleteSysDict(int dictId) {
		return baseDao.getIbatisTemplate().delete("deleteSysDict",dictId);
	}

	@SuppressWarnings("unchecked")
	public List<SysDict> querySysDictList(Map<String,String> map,DataGridModel dataGrid) {
		return  baseDao.queryForPageList("querySysDictList", dataGrid);
	}
	
	public DataGridModel querySysDictForPage(DataGridModel dataGrid) {
		return baseDao.queryForPageDataGrid("querySysDictList", dataGrid);
	}

	@SuppressWarnings("unchecked")
	public List<SysDict> querySysDictType(Map<String,String> map) {
		return  baseDao.getIbatisTemplate().queryForList("querySysDictType", map);
	}
	
	/**
	 * 根据字典类型查询字典项
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysDict> querySysDictByDictValue(Map<String,String> map) {
		return  baseDao.getIbatisTemplate().queryForList("querySysDictByDictValue", map);
	}
	
	
	public SysDict selectSysDictById(Integer dictId) {
		return (SysDict) baseDao.getIbatisTemplate().queryForObject("selectSysDictById", dictId);
	}

	public int updateSysDict(SysDict sysDict) {
		sysDict.setUpdateDate(new Date());
		return  baseDao.getIbatisTemplate().update("updateSysDict", sysDict);
	}

}