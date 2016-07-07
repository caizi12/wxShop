package cn.frame.platform.sys.auth.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.util.MD5Encoder;
import cn.frame.platform.common.util.RequestParmConvert;
import cn.frame.platform.common.util.properties.PropertiesUtil;
import cn.frame.platform.entitys.SysUser;
import cn.frame.platform.entitys.SysUserSessionInfo;
import cn.frame.platform.sys.auth.service.SysUserSrv;
import cn.frame.platform.sys.dict.service.SysDictSrv;

@Controller
@RequestMapping("/sys")
public class SysUserControl  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SysUserSrv sysUserSrv;
	
	@Autowired
	private SysDictSrv sysDictSrv;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/mngSysUser_page")
	public ModelAndView  userPage(SysUser sysUser) {
		
		Map<String,String> paramMap=new HashMap<String,String>();
	    Map map=new HashMap();
		paramMap.put("dictTypeValue", "userStatus");
		map.put("status", sysDictSrv.querySysDictByDictValue(paramMap));
		 
		return new ModelAndView("sys/sysmng/mng_sys_user","dictMap",map);
	}
	
	@RequestMapping("/querySysUser")
	@ResponseBody
	public DataGridModel querySysUserList(DataGridModel dataGrid,HttpServletRequest request){
		
		RequestParmConvert.intropectToDataGrid(request,dataGrid);
		//dataGrid.getQueryMap().put("userId", 1);
		//dataGrid.getQueryMap().put("userName", "admin");
		return sysUserSrv.querySysUserData(dataGrid);
	}
	
	@RequestMapping("/getSysUser")
	@ResponseBody
	public ModelAndView getSysUser(SysUser sysUser,@RequestParam("viewType") String viewType){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("viewType", viewType);
		if(!"add".equals(viewType)){
			map.put("sysUser", sysUserSrv.getSysUser(sysUser));
		}
		return new ModelAndView("sys/sysmng/view_sys_user","userMap",map);
	}
	
	@RequestMapping("/addSysUser_page")
	public ModelAndView  addSysUserPage(){
		return new ModelAndView("sys/sysmng/add_sys_user");
	}
	
	@RequestMapping("/addSysUser")
	@ResponseBody
	public Map<String,String>  addSysUser(SysUser sysUser){
		Map<String,String> msg=new HashMap<String,String>();
		try{ 
			  sysUser.setPassword(MD5Encoder.getMD5(sysUser.getPassword()));
			  sysUserSrv.addSysUser(sysUser);
		  msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
		}catch(Exception e){
		  msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
		  e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping("/viewSysUser_page")
	public ModelAndView  sysUserViewPage() throws ServletException, IOException{
		return new ModelAndView("sys/sysmng/view_sys_user");
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("/updateSysUser")
	@ResponseBody
	public Map<String,String>  updateSysUser(SysUser sysUser,@RequestParam("viewType") String viewType){
		Map<String,String> msg=new HashMap<String,String>();
		boolean result=false;
		try{
		 if ("add".equals(viewType)) {
				sysUser.setPassword(MD5Encoder.getMD5(sysUser.getPassword()));
				result=sysUserSrv.addSysUser(sysUser);
			} else if ("update".equals(viewType)) {
				if(sysUserSrv.updateSysUser(sysUser)>0){
				 result=true;
				}
			}
		 
		}catch(Exception e){
		  e.printStackTrace();
		}finally{
		   if(result){
			    msg.put("msg", PropertiesUtil.getMessValue("sys_save_succeed"));
			    msg.put("result","true");
			  }else{
				msg.put("msg",PropertiesUtil.getMessValue("sys_save_error"));
				msg.put("result","false");
			  }
		return msg;	
		}
	}
	
	
	@RequestMapping("/batchDelSysUser")
	@ResponseBody
	public Map<String,String>  batchDelSysUser(@RequestParam("userId") List<String> userId) {
		Map<String,String> msg=new HashMap<String,String>();
		try{
		  sysUserSrv.batchDelSysUser(userId);
		  msg.put("result", "true");
		  msg.put("msg", PropertiesUtil.getMessValue("sys_del_succeed"));
		}catch(Exception e){
		  msg.put("result", "false");
		  msg.put("msg",PropertiesUtil.getMessValue("sys_del_error"));
		  e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping("/changeUserPassword")
	@ResponseBody
	public Map<String,Object> changeUserPassword(HttpServletRequest request,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		String msg=null;
		boolean result=false;
		try{
			SysUserSessionInfo sessionInfo=(SysUserSessionInfo)session.getAttribute(ConstantPlatform.SYS_USER_INFO);
			
			SysUser sessionSysUser=null;
			if(sessionInfo==null||sessionInfo.getSysUser()==null){
				msg= "用户会话超时或者未登录，请登录后再进行修改！";
				map.put("msg", msg);
				return map;
			}
			sessionSysUser=sessionInfo.getSysUser();
			
			String newPwd=request.getParameter("newPwd");
			String newPwd2=request.getParameter("newPwd2");
			if(newPwd==null||!newPwd.equals(newPwd2)){
				msg= "新密码输入有误，请重新输入！";
			}
			
			SysUser sysUser=new SysUser();
			sysUser.setUserName(sessionSysUser.getUserName());
			sysUser=sysUserSrv.getSysUser(sysUser);
			if(!sysUser.getPassword().equals(MD5Encoder.getMD5(request.getParameter("oldPwd")))){
				msg= "原密码输入不正确，请重新输入！";
			}
			
			sysUser.setPassword(MD5Encoder.getMD5(newPwd));
			if(msg==null&&sysUserSrv.changeSysUserPwd(sysUser)==1){
				result=true;
				msg= "修改密码成功！";
			}
		}catch(Exception e){
			msg= "系统异常，修改密码失败，请联系管理员！";
			e.printStackTrace();
		}
		map.put("msg", msg);
		map.put("result", result);
		return map;
	}
	
	@RequestMapping("/checkUserName")
	@ResponseBody
	public String checkUserName(HttpServletRequest request){
		Map<String,Object> map=RequestParmConvert.intropectToMap(request);
		try{
			int countUser=sysUserSrv.queryCountSysUser(map);
			if(countUser==0){
				return "true";
			}else{
				return "false";
			}
		}catch(Exception e){
			map.put("msg", "系统异常请稍后再试！");
			map.put("result", false);
		}	
		return "";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//true:允许输入空值，false:不能为空值
	}
}
