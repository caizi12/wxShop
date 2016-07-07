package cn.frame.platform.sys.member.service;

import java.util.List;
import java.util.Map;
import cn.frame.platform.entitys.MemberRecomendInfo;

public interface MemberRecomendInfoSrv {
	public MemberRecomendInfo getMemberRecomendInfo(MemberRecomendInfo memberRecomendInfo);
	@SuppressWarnings("unchecked")
	public List<MemberRecomendInfo> queryMemberRecomendInfo(Map paraMap);
	public boolean addMemberRecomendInfo(MemberRecomendInfo memberRecomendInfo);
	public int updateMemberRecomendInfo(MemberRecomendInfo memberRecomendInfo);
}
