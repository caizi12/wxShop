package cn.frame.platform.sys.member.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.frame.platform.common.base.BaseDaoTemplate;
import cn.frame.platform.entitys.MemberRecomendInfo;
import cn.frame.platform.sys.member.service.MemberRecomendInfoSrv;

/**
 * 推荐用户注册关联信息表
 * @author li
 *
 */
@Service("memberRecomendInfoSrv")
public class MemberRecomendInfoSrvImpl implements MemberRecomendInfoSrv {
	
	@Autowired
	public BaseDaoTemplate baseDao;
	/**
	 * 获取用户推荐信息
	 * 
	 * @param MemberRecomendInfo
	 * @return
	 */
	public MemberRecomendInfo getMemberRecomendInfo(MemberRecomendInfo memberRecomendInfo) {
		memberRecomendInfo = (MemberRecomendInfo) baseDao.getIbatisTemplate().queryForObject("getMemberRecomendInfo", memberRecomendInfo);
		return memberRecomendInfo;
	}
 

	/**
	 * 查询用户推荐的信息
	 */
	@SuppressWarnings("unchecked")
	public List<MemberRecomendInfo> queryMemberRecomendInfo(Map paraMap) {
		return baseDao.getIbatisTemplate().queryForList("queryMemberRecomendInfo", paraMap);
	}

	/**
	 * 添加一条用户推荐信息
	 */
	public boolean addMemberRecomendInfo(MemberRecomendInfo memberRecomendInfo) {
		memberRecomendInfo.setCreateTime(new Date());
		baseDao.getIbatisTemplate().insert("addMemberRecomendInfo", memberRecomendInfo);
		return true;
	}

	/**
	 * 修改推荐信息
	 */
	public int updateMemberRecomendInfo(MemberRecomendInfo MemberRecomendInfo) {
		MemberRecomendInfo.setUpdateTime(new Date());
		return baseDao.getIbatisTemplate().update("updateMemberRecomendInfo", MemberRecomendInfo);
	}

}