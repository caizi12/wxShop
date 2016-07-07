package cn.frame.platform.sys.member.service;

import java.util.List;
import java.util.Map;

import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.MemberInfo;

public interface MemberInfoSrv {
	public MemberInfo getMemberInfo(MemberInfo memberInfo);
	public int queryCountMemberInfo(Map<String, Object> userMap);
	public DataGridModel queryMemberInfoData(DataGridModel dataGrid);
	public boolean addMemberInfo(MemberInfo memberInfo);
	public int updateMemberInfo(MemberInfo memberInfo);
	public int batchDelMemberInfo(List<String> userId)  throws Exception;
	public int changeMemberInfoPwd(MemberInfo memberInfo);
	public int updateMemberToDelStatus(final List<String> list);
	public boolean resetMemberInfoPasswor(List<MemberInfo> list);
	public String registerMember(MemberInfo memberInfo) ;
	
	public int updateMemberQrImg(MemberInfo MemberInfo);
}
