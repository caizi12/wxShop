package cn.frame.com.service;

import cn.frame.platform.entitys.SysUser;

public interface DubboTestSrv {
  public String testOne(String str);
  public boolean addUser(SysUser user) throws Exception ;
}
