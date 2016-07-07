package cn.frame.platform.sys.dict.control;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.util.MessageUtil;
import cn.frame.platform.common.util.RequestParmConvert;
import cn.frame.platform.entitys.SysDict;
import cn.frame.platform.sys.dict.service.SysDictSrv;
 
@Controller
@RequestMapping("/sys/dict")
public class SysDictControl  {

	@Autowired
	private SysDictSrv sysDictSrv;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/sysDictTypeMng")
	public ModelAndView sysDictTypeMng(HttpServletRequest request, DataGridModel dataGrid) throws Exception {
		
		Map<String,String> paramMap=new HashMap<String,String>();
	    Map map=new HashMap();
	    paramMap.put("dictTypeValue", "dictType");
		map.put("dictType", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "status");
		map.put("status", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "dictCategory");
		map.put("dictCategory", sysDictSrv.querySysDictByDictValue(paramMap));
		 
		return new ModelAndView("sys/dict/sysDictTypeMng","dictData",map);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/sysDictMng")
	public ModelAndView sysDictMng(HttpServletRequest request, DataGridModel dataGrid) throws Exception {
		
		Map<String,String> paramMap=new HashMap<String,String>();
	    Map map=new HashMap();
	    paramMap.put("dictTypeValue", "dictType");
		map.put("dictTypeSelect", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "status");
		map.put("status", sysDictSrv.querySysDictByDictValue(paramMap));
		
		paramMap.put("dictTypeValue", "dictCategory");
		map.put("dictCategory", sysDictSrv.querySysDictByDictValue(paramMap));
		
		map.put("dictType",sysDictSrv.querySysDictType(paramMap));
		
		return new ModelAndView("sys/dict/sysDictMng","dictData",map);
	}
	
	
	@RequestMapping("/querySysDictList")
	@ResponseBody
	public DataGridModel queryMenuList(HttpServletRequest request, DataGridModel dataGrid) throws Exception {
		RequestParmConvert.intropectToDataGrid(request,dataGrid);
		DataGridModel data=sysDictSrv.querySysDictForPage(dataGrid);
//		Map<String,Object> map;
//		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
//		for (SysDict sysDict:list){
//			map=new HashMap<String,Object>();
//			mapList.add(map);
//		}
		return data;
	}
	
//	@RequestMapping("/querySysDictByDictTypeId")
//	@ResponseBody
//	public List<Map<String,Object>> querySysDictByDictTypeId(HttpServletRequest request,String dictTypeId) throws Exception {
//	    if(StringUtils.isBlank(dictTypeId))return null;
//		Map<String,String> paramMap=new HashMap<String,String>();
//	    paramMap.put("dictTypeId", dictTypeId);
//	    List<SysDict> list=sysDictSrv.querySysDictByDictType(paramMap);
//	    
//		Map<String,Object> map;
//		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
//		for (SysDict sysDict:list){
//			map=new HashMap<String,Object>();
//			map.put("dictId",sysDict.getDictId() );
//			map.put("dictName", sysDict.getDictName());
//			map.put("dictValue", sysDict.getDictValue());
//			mapList.add(map);
//		}
//		return mapList;
//	}
	
	@RequestMapping("/querySysDictByDictVal")
	@ResponseBody
	public List<SysDict> querySysDictByDictVal(@RequestParam("dictTypeValue") String  dictTypeValue){
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("dictTypeValue", dictTypeValue);
		return sysDictSrv.querySysDictByDictValue(paramMap);
	}
	 
	@RequestMapping("/insertSysDict")
	@ResponseBody
	public MessageUtil insertSysDict(SysDict sysDict)  {
		try{
		 sysDictSrv.insertSysDict(sysDict);
		 return MessageUtil.message(MessageUtil.SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			return MessageUtil.message(MessageUtil.ERROR);
		}
	}

	@RequestMapping("/updateSysDict")
	@ResponseBody
	public MessageUtil updateSysDict(SysDict sysDict) {
		try{
			int row = sysDictSrv.updateSysDict(sysDict);
			return MessageUtil.message(row>0?MessageUtil.SUCCESS:MessageUtil.ERROR);
		}catch(Exception e){
			e.printStackTrace();
			return MessageUtil.message(MessageUtil.ERROR);
		}
	}

	/**
	 * 批量新增，修改业务字典
	 * @param sysDict
	 * @return
	 */
	@RequestMapping("/batchSaveSysDict")
	@ResponseBody
	public MessageUtil batchSaveSysDict(@RequestBody SysDict[] sysDict) {
		try{
			int row = sysDictSrv.batchSaveSysDict(sysDict);
			return MessageUtil.message(row>0?MessageUtil.SUCCESS:MessageUtil.ERROR);
		}catch(Exception e){
			e.printStackTrace();
			return MessageUtil.message(MessageUtil.ERROR);
		}
	} 
	
	@RequestMapping("/selectSysDictById")
	@ResponseBody
	public SysDict selectSysDictById(Integer dictId) {
		return sysDictSrv.selectSysDictById(dictId);
	}
	
	@RequestMapping("/batchDelSysDict")
	@ResponseBody
	public int deleteSysDictById(String dictId) {
		 String[] dictIds=dictId.split(ConstantPlatform.SYS_SEPARATOR_COMMA);
		 int rows = sysDictSrv.batchDeleteSysDict(dictIds);
		return rows;
	}

	
	
}
