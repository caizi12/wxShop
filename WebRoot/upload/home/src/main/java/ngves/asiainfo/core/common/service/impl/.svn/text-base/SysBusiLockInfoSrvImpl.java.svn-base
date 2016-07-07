/**
 * 
 */
package ngves.asiainfo.core.common.service.impl;

import ngves.asiainfo.core.common.bo.SysBusiLockInfoBean;
import ngves.asiainfo.core.common.dao.interfaces.ISysBusiLockInfoDAO;
import ngves.asiainfo.core.common.ivalues.ISysBusiLockInfoValue;
import ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv;
import ngves.asiainfo.util.DateTimeUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author asiainfo
 *
 */
public class SysBusiLockInfoSrvImpl implements ISysBusiLockInfoSrv {
    private static transient Log log = LogFactory.getLog(SysBusiLockInfoSrvImpl.class);

	private ISysBusiLockInfoDAO  sysBusiLockInfoDAO;
	

	/**
	 * @param sysBusiLockInfoDAO the sysBusiLockInfoDAO to set
	 */
	public void setSysBusiLockInfoDAO(ISysBusiLockInfoDAO sysBusiLockInfoDAO) {
		this.sysBusiLockInfoDAO = sysBusiLockInfoDAO;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv#gainBusiLock(java.lang.String, java.lang.String)
	 * 
	 * 已经加锁的ID
     * 54   业务类型-投诉单关闭
     * 999  未完结订单更新任务
     * 2001 短信模板管理
     * 2002 短信模板
     * 2000 短信模板
     * 10   判断是否生成或撤销短信任务
     * 3000 礼品三级分类的的业务码
     * 01   修改礼品业务属性对当前礼品加锁
     * 04   更新礼品的上下线状态
     * 001  积分反赠撤回
     * 002	积分反赠撤销
     * 003	积分反赠修改
     * 004	积分返赠审核
	 */
	
	public boolean gainBusiLock(String busiLockId, String busiType,long staffId) throws Exception {
		log.debug("trying to gain the busi lock , update the state of ware_info...");
		 boolean locked = false;
	        try {
	            ISysBusiLockInfoValue lockInfo = new SysBusiLockInfoBean();
	            lockInfo.setBusiLockCode(busiLockId);
	            lockInfo.setBusiLockType(busiType);
	            lockInfo.setBusiLockTime(DateTimeUtil.getDefaultSysDate());
	            lockInfo.setBusiLockOpNo(String.valueOf(staffId));

	            sysBusiLockInfoDAO.saveLockInfo(lockInfo);
	            locked = true;
	        } catch (Exception e) {
	            locked = false;
	            log.error(e);
	            throw new Exception();
	        }
	        return locked;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv#getLockInfo(java.lang.String, java.lang.String)
	 */
	public ISysBusiLockInfoValue getLockInfo(String lockCode, String lockType) throws Exception {
		ISysBusiLockInfoValue value  = sysBusiLockInfoDAO.getSysBusiLockInfoValue(lockCode, lockType);	
		return value;
	}

	/* (non-Javadoc)
	 * @see ngves.asiainfo.core.common.service.interfaces.ISysBusiLockInfoSrv#releaseBusiLock(java.lang.String, java.lang.String)
	 */
	public boolean releaseBusiLock(String lockCode, String lockType) throws Exception {
		log.debug(" trying to release the lock info . update state of ware_info...");
		boolean locked = false;
		try {
			ISysBusiLockInfoValue value = sysBusiLockInfoDAO.getSysBusiLockInfoValue(lockType,lockCode);	
	        //value.setBusiLockTime(DateTimeUtil.getDefaultSysDate());
			value.delete();
	        sysBusiLockInfoDAO.saveLockInfo(value);
	        
			locked = true;
			log.debug(" release the lock info is OK.");

		} catch (Exception e) {
			log.debug(" release the lock info is ERROR.");

			locked = false;
			log.error(e);
			throw new Exception();
		}
		return locked;
	}

}
