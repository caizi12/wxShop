package ngves.asiainfo.core.comment.service.interfaces;

import java.util.ArrayList;

import ngves.asiainfo.core.comment.IQBOCommentInfoValue;
import ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO;
import ngves.asiainfo.core.comment.ivalues.ICommentInfoValue;
import ngves.asiainfo.core.comment.model.Comment;

/**
 * 礼品评论服务接口
 * @author LiuLin
 *
 */
public interface ICommentInfoSrv {
	public void setCommentInfoDAO(ICommentInfoDAO commentInfoDAO);

	/**
	 * 礼品评论信息列表
	 * 
	 * @param wareName
	 * @param wareId
	 * @param mobileNum
	 * @param auditFlag
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public ICommentInfoValue[] queryCommentInfo(String wareName, String wareId,
			String mobilePhoneNo, String auditFlag, String startTime,
			String endTime, int startIndex, int endIndex) throws Exception;

	/**
	 * 礼品评论信息数量
	 * 
	 * @param wareName
	 * @param wareId
	 * @param mobileNum
	 * @param auditFlag
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int queryCommentInfoCount(String wareName, String wareId,
			String mobileNum, String auditFlag, String startTime, String endTime)
			throws Exception;

	/**
	 * 礼品评论审核通过
	 * 
	 * @param commentInfoList
	 * @throws Exception
	 */
	public void auditCommentInfoPass(
			ArrayList<ICommentInfoValue> commentInfoList) throws Exception;

	/**
	 * 礼品评论审核不通过
	 * 
	 * @param commentInfoList
	 */
	public void auditCommentInfoRejectPass(
			ArrayList<ICommentInfoValue> commentInfoList) throws Exception;

	/**
	 * 根据id找评论信息
	 * 
	 * @param commentId
	 * @return
	 * @throws Exception
	 */
	public ICommentInfoValue queryCommentInfoByCommentId(String commentId)
			throws Exception;

	/**
	 * 保存礼品评论
	 * 
	 * @param wareId
	 * @param wareName
	 * @param commentOriginal
	 * @param mobileNo
	 * @param voteValue
	 * @throws Exception
	 */
	public void saveCommentInfo(String wareId, String pWareId, String wareCode,
			String wareName, String commentOriginal, String mobileNo,
			String voteValue) throws Exception;

	/**
	 * 根据礼品ID获取 startIndex-endIndex条的 审核通过 的礼品评论
	 * 
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public ICommentInfoValue[] getPassCommentInfoByWareId(String wareId,
			int startIndex, int endIndex) throws Exception;

	/**
	 * 根据礼品ID获取 通过审核的礼品评论总数
	 * 
	 * @param wareId
	 * @return
	 * @throws Exception
	 */
	public int queryPassCommentInfoCount(String wareId) throws Exception;

	/**
	 * 以IBatis方式 获取数据 根据礼品ID获取 审核通过 的礼品评论
	 * 
	 * @return
	 * @throws Exception
	 */
	public Comment[] getAllComment(String wareId, int startIndex, int endIndex)
			throws Exception;

	/**
	 * 门户使用iBatis获取数据 根据礼品ID得到审核通过的礼品评论总条数
	 * 
	 * @param wareId
	 * @return
	 */
	public int getAllCommentInfoCount(String wareId) throws Exception;

	/**
	 * 门户使用iBatis保存数据 保存礼品评论
	 * 
	 * @param wareId
	 * @return
	 */
	public long saveComment(Comment comentInfo) throws Exception;

	/**
	 * 以IBatis方式 获取数据 根据父礼品ID获取 审核通过 的礼品评论
	 * 
	 * @return
	 * @throws Exception
	 */
	public Comment[] getAllCommentByPwareId(String pWareId, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 门户使用iBatis获取数据 根据父礼品ID得到审核通过的礼品评论总条数
	 * 
	 * @param wareId
	 * @return
	 */
	public int getAllCommentInfoCountByPwareId(String pWareId) throws Exception;

	/**
	 * 以IBatis方式 获取数据 根据手机号获取 的礼品评论（包含通过和未通过的）
	 * 
	 * @param mobileNo
	 * @return
	 * @throws Exception
	 */
	public Comment[] getAllCommentByMobileNo(String mobileNo) throws Exception;

	/**
	 * 礼品评论信息列表
	 * 
	 * @param fId
	 * @param bigKindId
	 * @param kindId
	 * @param wareName
	 * @param wareCode
	 * @param mobilePhoneNo
	 * @param auditFlag
	 * @param startTime
	 * @param endTime
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public IQBOCommentInfoValue[] queryQBOCommentInfo(String fId,
			String bigKindId, String kindId, String wareName, String wareCode,
			String mobilePhoneNo, String auditFlag, String startTime,
			String endTime,String wareKindInfoId, int startIndex, int endIndex) throws Exception;
	
	/**
	 * 礼品评论信息列表个数
	 * 
	 * @param fId
	 * @param bigKindId
	 * @param kindId
	 * @param wareName
	 * @param wareCode
	 * @param mobilePhoneNo
	 * @param auditFlag
	 * @param startTime
	 * @param endTime
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public int queryQBOCommentInfoCount(String fId,
			String bigKindId, String kindId, String wareName, String wareCode,
			String mobilePhoneNo, String auditFlag, String startTime,
			String endTime,String wareKindInfoId) throws Exception;
	
}
