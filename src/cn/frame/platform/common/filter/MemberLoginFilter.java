package cn.frame.platform.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import cn.frame.platform.common.util.UserSessionUtil;

public class MemberLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
			ServletException {
		
		if(UserSessionUtil.getMemberIdFromSession((HttpServletRequest) request)>0){
			filterChain.doFilter(request, response);
		}else{
			HttpServletRequest servletRequest=(HttpServletRequest)request;
			String referer =servletRequest.getHeader("referer");
			String prefixPath=servletRequest.getServerPort()+"/"+servletRequest.getContextPath();
			String suffixPath=".do";
			if(referer!=null&&referer.indexOf("/member/myAccount.do")>-1){
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginPage.do");
			dispatcher.forward(request, response); 
			return;
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
