package ngves.asiainfo.core.check.service.interfaces;

import ngves.asiainfo.core.check.ivalues.IPartnerCheckFileValue;

/**
 * 合作商考核日志管理
 * @author chenzhd
 *
 */
public interface IPartnerCheckFileSrv {

	/*
	 * 保存合作商考核日志
	 */
	 public void savePartnerCheckFileInfo(IPartnerCheckFileValue value) throws Exception ;
}
