package cn.frame.platform.sys.menu.control;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.util.MessageUtil;
import cn.frame.platform.entitys.SysMenu;
import cn.frame.platform.sys.menu.service.SysMenuSrv;
 
@Controller
@RequestMapping("/sys/menu")
public class SysMenuControl  {

	@Autowired
	private SysMenuSrv sysMenuSrv;
	
	@RequestMapping("/sysMenuMng")
	public ModelAndView sysMenuMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("sys/menu/sysMenuMng","menuList",sysMenuSrv.queryMenuList(null));
	}
	
	@RequestMapping("/queryMenuList")
	@ResponseBody
	public List<Map<String,Object>> queryMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<SysMenu> list=sysMenuSrv.queryMenuList(null);
		Map<String,Object> map;
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		for (SysMenu menu:list){
			map=new HashMap<String,Object>();
			map.put("menuId", menu.getMenuId());
			map.put("menuName", menu.getMenuName());
			map.put("parentMenuId", menu.getParentMenuId());
			mapList.add(map);
		}
		return mapList;
	}
	
	 
	@SuppressWarnings("unchecked")
	@RequestMapping("/insertSysMenu")
	@ResponseBody
	public MessageUtil insertSysMenu(SysMenu sysMenu)  {
		try{
		 long menuId=sysMenuSrv.insertSysMenu(sysMenu);
		 HashMap dataMap=new HashMap();
		 dataMap.put("menuId", menuId);
		 return MessageUtil.message(MessageUtil.SUCCESS,dataMap); 
		}catch(Exception e){
			e.printStackTrace();
			return MessageUtil.message(MessageUtil.ERROR);
		}
	}

	@RequestMapping("/updateSysMenu")
	@ResponseBody
	public MessageUtil updateSysMenu(SysMenu sysMenu) {
		try{
			int row = sysMenuSrv.updateSysMenu(sysMenu);
			return MessageUtil.message(row>0?MessageUtil.SUCCESS:MessageUtil.ERROR);
		}catch(Exception e){
			e.printStackTrace();
			return MessageUtil.message(MessageUtil.ERROR);
		}
	}

	 
	@RequestMapping("/selectSysMenuById")
	@ResponseBody
	public SysMenu selectSysMenuById(String menuId) throws SQLException {
		if(StringUtils.isBlank(menuId)) return null;
		return sysMenuSrv.selectSysMenuById(menuId);
	}
	
	@RequestMapping("/deleteSysMenuById")
	@ResponseBody
	public int deleteSysMenuById(String menuId) throws SQLException {
		int rows = sysMenuSrv.deleteSysMenuById(menuId);
		return rows;
	}
	 
}
