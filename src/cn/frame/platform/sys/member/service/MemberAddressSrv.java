package cn.frame.platform.sys.member.service;

import java.util.List;
import java.util.Map;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.MemberAddress;

public interface MemberAddressSrv {
	public MemberAddress getMemberAddress(MemberAddress memberAddress);
	public int queryCountMemberAddress(Map<String, Object> userMap);
	public DataGridModel queryMemberAddressData(DataGridModel dataGrid);
	public boolean addMemberAddress(MemberAddress memberAddress);
	public int updateMemberAddress(MemberAddress memberAddress);
	public int batchDelMemberAddress(List<String> userId)  throws Exception;
	public int updateShopToDelStatus(final List<String> list);
	
	public List<MemberAddress> queryMemberAddress(Map<String, Object> paramMap);
	
	public boolean updateMemberDefaulAddress(MemberAddress memberAddress) ;
	
	public boolean deleteAddress(String addressId);
	
}
