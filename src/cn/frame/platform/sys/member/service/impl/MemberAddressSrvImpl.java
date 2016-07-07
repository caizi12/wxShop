package cn.frame.platform.sys.member.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.entitys.MemberAddress;
import cn.frame.platform.sys.member.service.MemberAddressSrv;

import com.ibatis.sqlmap.client.SqlMapExecutor;

@Service("memberAddressSrv")
public class MemberAddressSrvImpl implements MemberAddressSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	/**
	 * 获取用户地址信息
	 * 
	 * @param MemberAddress
	 * @return
	 */
	public MemberAddress getMemberAddress(MemberAddress memberAddress) {
		memberAddress = (MemberAddress) baseDao.getIbatisTemplate().queryForObject("getMemberAddress", memberAddress);
		return memberAddress;
	}

	/**
	 * 查询用户地址总数
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int queryCountMemberAddress(Map<String, Object> userMap) {
		return baseDao.getQueryCount("queryMemberAddress", userMap);
	}

	/**
	 * 查询用户地址
	 */
	public DataGridModel queryMemberAddressData(DataGridModel dataGrid) {
		return baseDao.queryForPageDataGrid("queryMemberAddress", dataGrid);
	}
	
	/**
	 * 查询用户地址
	 */
	@SuppressWarnings("unchecked")
	public List<MemberAddress> queryMemberAddress(Map<String, Object> paramMap) {
		return baseDao.getIbatisTemplate().queryForList("queryMemberAddress", paramMap);
	}

	/**
	 * 添加用户地址
	 */
	public boolean addMemberAddress(MemberAddress memberAddress) {
		memberAddress.setCreateTime(new Date());
		baseDao.getIbatisTemplate().insert("insertMemberAddress", memberAddress);
		return true;
	}

	/**
	 * 批量删除用户地址
	 */
	@SuppressWarnings("unchecked")
	public int batchDelMemberAddress(final List<String> list) throws Exception {
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.delete("batchDelMemberAddress", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	/**
	 * 修改用户地址信息
	 */
	public int updateMemberAddress(MemberAddress MemberAddress) {
		return baseDao.getIbatisTemplate().update("updateMemberAddress", MemberAddress);
	}

	/**
	 * 设置用户默认地址
	 * @param MemberAddress
	 * @return
	 */
	public boolean updateMemberDefaulAddress(MemberAddress memberAddress) {
		memberAddress.setIsDefault("1");
		 //先更新用户默认地址为非默认地址
		baseDao.getIbatisTemplate().update("updateMemberDefaulAddress", memberAddress);
		
		//再修改指定地址为默认地址
		baseDao.getIbatisTemplate().update("setMemberDefaulAddress", memberAddress);
		
		return true;
	}
	
 
	
	@SuppressWarnings("unchecked")
	public int updateShopToDelStatus(final List<String> list){
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.update("updateShopToDelStatus", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		int i = 0;
		return i;
	}

	/**
	 * 用户删除收获地址
	 */
	public boolean deleteAddress(String addressId) {
		baseDao.getIbatisTemplate().update("deleteByAddressId", addressId);
		return true;
	}

 
}