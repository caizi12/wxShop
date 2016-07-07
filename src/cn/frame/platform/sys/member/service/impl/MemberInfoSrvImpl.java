package cn.frame.platform.sys.member.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Service;

import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.common.base.DataGridModel;
import cn.frame.platform.common.constant.MemberConstant;
import cn.frame.platform.entitys.MemberInfo;
import cn.frame.platform.entitys.MemberRecomendInfo;
import cn.frame.platform.sys.member.service.MemberInfoSrv;
import cn.frame.platform.sys.member.service.MemberRecomendInfoSrv;

import com.ibatis.sqlmap.client.SqlMapExecutor;

@Service("memberInfoSrv")
public class MemberInfoSrvImpl implements MemberInfoSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	
	@Autowired
	public MemberRecomendInfoSrv memberRecomendInfoSrv;
	
	/**
	 * 获取用户信息
	 * 
	 * @param MemberInfo
	 * @return
	 */
	public MemberInfo getMemberInfo(MemberInfo memberInfo) {
		memberInfo = (MemberInfo) baseDao.getIbatisTemplate().queryForObject("getMemberInfo", memberInfo);
		return memberInfo;
	}

	/**
	 * 查询系统用户总数
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int queryCountMemberInfo(Map<String, Object> userMap) {
		return baseDao.getQueryCount("queryMemberInfo", userMap);
	}

	/**
	 * 查询系统用户
	 */
	public DataGridModel queryMemberInfoData(DataGridModel dataGrid) {
		return baseDao.queryForPageDataGrid("queryMemberInfo", dataGrid);
	}

	/**
	 * 添加用户
	 */
	public boolean addMemberInfo(MemberInfo memberInfo) {
		memberInfo.setCreateTime(new Date());
		baseDao.getIbatisTemplate().insert("addMemberInfo", memberInfo);
		return true;
	}

	/**
	 *新用户注册
	 */
	public String registerMember(MemberInfo memberInfo) {
		MemberInfo member=this.getMemberInfo(memberInfo);
		if(member!=null){return "false";}
		//新注册用户送500分
		memberInfo.setTotalPoint(500);
		memberInfo.setCanPoint(500);
		memberInfo.setStatus("0");
		memberInfo.setPhoneNo(memberInfo.getMobileNo());
		memberInfo.setCreateTime(new Date());
		memberInfo.setUserName(memberInfo.getMobileNo());
		Integer memberId=(Integer)baseDao.getIbatisTemplate().insert("addMemberInfo", memberInfo);
	
		//如果是二维码扫描推荐注册用户，则需要保存推荐关系
		if(StringUtils.isNotBlank(memberInfo.getRecomendId())){
			MemberRecomendInfo recomendInfo=new MemberRecomendInfo();
			recomendInfo.setRecomendMemberId(Integer.valueOf(memberInfo.getRecomendId()));
			recomendInfo.setMemberId(memberId);
			recomendInfo.setRecomendType(MemberConstant.RECOMEND_TYPE_QR_CODE);
			memberRecomendInfoSrv.addMemberRecomendInfo(recomendInfo);
		}

		
		return "true";
	}
	
	/**
	 * 批量删除用户
	 */
	@SuppressWarnings("unchecked")
	public int batchDelMemberInfo(final List<String> list) throws Exception {
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.delete("batchDelMemberInfo", list.get(i));
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
	 * 修改用户信息
	 */
	public int updateMemberInfo(MemberInfo MemberInfo) {
		return baseDao.getIbatisTemplate().update("updateMemberInfo", MemberInfo);
	}

	
	/**
	 * 保存用户二维码图片信息
	 */
	public int updateMemberQrImg(MemberInfo MemberInfo) {
		return baseDao.getIbatisTemplate().update("updateMemberQrImg", MemberInfo);
	}
	
	@Override
	public int changeMemberInfoPwd(MemberInfo memberInfo) {
	 
		return 0;
	}
 
	
	@SuppressWarnings("unchecked")
	public int updateMemberToDelStatus(final List<String> list){
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0, n = list.size(); i < n; i++) {
						executor.update("updateMemberToDelStatus", list.get(i));
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
	 * 重置用户密码 
	 * 重置后密码为666888
	 */
	@SuppressWarnings("unchecked")
	public boolean resetMemberInfoPasswor(final List<MemberInfo> list) {
		
		if (list != null) {
			baseDao.getIbatisTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
					executor.startBatch();
					for (int i = 0;i< list.size();  i++) {
						executor.update("resetMemberPassword", list.get(i));
					}
					executor.executeBatch();
					return null;
				}
			});
		}
		
		return true;
	}


}