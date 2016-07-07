package cn.frame.platform.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.frame.platform.common.ConstantPlatform;
import cn.frame.platform.entitys.MemberInfo;

public class UserSessionUtil {

	/**
	 * 获取注册会员session信息
	 * @param request
	 * @return
	 */
	public static MemberInfo getMemberInfoFromSession(HttpServletRequest request){
		HttpSession session=request.getSession(true);
		MemberInfo memberInfo=(MemberInfo)session.getAttribute(ConstantPlatform.MEMBER_INFO);
		return memberInfo;
	}
	
	public static Integer getMemberIdFromSession(HttpServletRequest request){
		MemberInfo memberInfo=getMemberInfoFromSession(request);
		if(memberInfo!=null){
			return memberInfo.getMemberId();
		}
		return null;
	}
	
	
}
