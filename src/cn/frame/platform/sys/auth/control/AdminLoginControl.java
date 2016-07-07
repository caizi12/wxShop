package cn.frame.platform.sys.auth.control;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.common.util.MD5Encoder;
import cn.frame.platform.common.util.properties.PropertiesUtil;
import cn.frame.platform.entitys.SysMenu;
import cn.frame.platform.entitys.SysUser;
import cn.frame.platform.entitys.SysUserSessionInfo;
import cn.frame.platform.sys.auth.service.AdminLoginSrv;
import cn.frame.platform.sys.menu.service.SysMenuSrv;

@Controller
@RequestMapping("/sys")
public class AdminLoginControl {
	
	@Autowired
	public AdminLoginSrv adminLoginSrv;
 
	@Autowired
	public SysMenuSrv sysMenuSrv;
	
	/**
	 * 登录请求页面
	 * @return
	 */
	@RequestMapping("/admin_login")
	public ModelAndView  adminLoginPage(){
		return new ModelAndView("sys/login");
	}
	
	/**
	 * 用户登录校验
	 * @param requestSysUser
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public HashMap<String,Object>  adminLogin(SysUser requestSysUser,HttpSession session){
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		SysUser user=adminLoginSrv.getSysUser(requestSysUser);
		String infoMess=null;
		
		//该用户不存在
		if(requestSysUser.getUserName()==null||user==null||user.getUserId()==null){
			infoMess=PropertiesUtil.getMessValue("sys_user_noexist");
		}
		//用户已被停用
		else if(ConstantPlatform.SYSUSER_STATUS_STOP.equals(user.getStatus())){
			infoMess=PropertiesUtil.getMessValue("sys_user_stop");
		}
		//用户被锁定
		else if(ConstantPlatform.SYSUSER_STATUS_LOCK.equals(user.getStatus())){
			infoMess=PropertiesUtil.getMessValue("sys_user_lock");
		}else if(new Date().after(user.getInvalidDate())){
			infoMess=PropertiesUtil.getMessValue("sys_user_pass_invalid");
		}
		//密码错误
		else if(!MD5Encoder.getMD5(requestSysUser.getPassword()).equals(user.getPassword())){
			infoMess=PropertiesUtil.getMessValue("sys_user_pwderr");
		}
		if(infoMess==null){//redirect:/sys/index.do, forward:/jsp/admin/login.jsp 
			map.put("login", true);
			session.setAttribute(ConstantPlatform.SYS_USER_INFO, setLoginUserSessionInfo(user));
		}else{
			map.put("login", false);
			map.put("infoMess", infoMess);
		}
		
		return map;  
		
	}
	
	/**
	 * 登录成功,设置用户session信息
	 * @param sysUser
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SysUserSessionInfo setLoginUserSessionInfo(SysUser sysUser){
		SysUserSessionInfo userSessionInfo=SysUserSessionInfo.getInstance();
		
		Map<String,String> menuMap=new HashMap();
		menuMap.put("userId", sysUser.getUserId());
		List<SysMenu> menuList=sysMenuSrv.queryMenuList(menuMap);
		userSessionInfo.setUserMenus(menuList);
		
		userSessionInfo.setSysUser(sysUser);
		
		return userSessionInfo;
	}
	
	/**
	 * 系统首页
	 * @param session
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView adminIndex(HttpSession session){
		SysUserSessionInfo userInfo=(SysUserSessionInfo)session.getAttribute(ConstantPlatform.SYS_USER_INFO);
		if(userInfo==null||userInfo.getSysUser()==null){
			return this.adminLoginPage();
		}
		return new ModelAndView("sys/index");
	}
	
	
	/**
     * 用户注销
     *
     * @param session
     */
	@RequestMapping(value="/logout")
    public ModelAndView logout(HttpSession session) {

        if (session.getAttribute(ConstantPlatform.SYS_USER_INFO) != null) {
            //移除Session对象
            session.removeAttribute(ConstantPlatform.SYS_USER_INFO);
            //清除session
            session.invalidate();
        }
        //返回登陆页面
        return this.adminLoginPage();
    }
	
	
	@RequestMapping("/main")
	public ModelAndView frameTop(){
		return new ModelAndView("sys/main");
	}
	
	@RequestMapping("/left")
	public ModelAndView frameLeft(){
		return new ModelAndView("admin/left");
	}
	
	
}
