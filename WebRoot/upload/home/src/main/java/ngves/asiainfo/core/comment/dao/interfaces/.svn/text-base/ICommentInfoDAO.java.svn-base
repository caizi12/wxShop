package ngves.asiainfo.core.comment.dao.interfaces;

import java.util.Map;

import ngves.asiainfo.core.comment.IQBOCommentInfoValue;
import ngves.asiainfo.core.comment.bo.CommentInfoBean;
import ngves.asiainfo.core.comment.ivalues.ICommentInfoValue;
import ngves.asiainfo.core.comment.model.Comment;

/**礼品评论数据层接口
 * @author LiuLin
 *
 */
public interface ICommentInfoDAO {

	/**
	 * 查询礼品评论信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public ICommentInfoValue[] queryCommentInfo(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * 用于分页的查询
	 * @param condition
	 * @param parameter
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public ICommentInfoValue[] queryCommentInfo(String condition, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception;

	/**
	 * 查询评论总条数
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int queryCommentInfoCount(String condition, Map<String, String> parameter) throws Exception;

	/**
	 * 更新评论审核信息
	 * @param commentInfo
	 * @throws Exception
	 */
	//	public void updateBussiPartnerInfo(ICommentInfoValue commentInfo) throws Exception;
	/**批量更新礼品评论审核状态
	 * @param commentInfos
	 * @throws Exception
	 */
	public void updateBussiPartnerInfoBatch(ICommentInfoValue[] commentInfos) throws Exception;

	public void saveCommentInfo(CommentInfoBean commentInfo)throws Exception;
	
	/**
     * 门户使用iBatis获取数据
     * 根据礼品ID得到审核通过的礼品评论(带分页)
     * @return
     * @throws Exception
     */
    public Comment[] getAllCommentInfo(String wareId, int startIndex, int endIndex) throws Exception;
    
    /**
     * 门户使用iBatis获取数据
     * 根据礼品ID得到审核通过的礼品评论总条数
     * @param wareId
     * @return
     */
    public int getAllCommentInfoCount(String wareId) throws Exception;
    
    /**
     * 门户使用iBatis保存数据
     * 保存礼品评论
     * @param wareId
     * @return
     */
    public long saveComment(Comment comentInfo) throws Exception;
    
    
    /**
     * 门户使用iBatis获取数据
     * 根据父礼品ID得到审核通过的礼品评论(带分页)
     * @param pWareId 父礼品ID
     * @param startIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    public Comment[] getAllCommentInfoByPwareId(String pWareId, int startIndex, int endIndex) throws Exception;
    
    
    /**
     * 门户使用iBatis获取数据
     * 根据父礼品ID得到审核通过的礼品评论总条数
     * @param wareId
     * @return
     */
    public int getAllCommentInfoCountByPwareId(String pWareId) throws Exception;

	/**门户使用iBatis获取数据
	 * 根据手机号得到用户的礼品评论（包含通过和未通过的）
	 * @param mobileNo
	 * @return
	 */
	public Comment[] getAllCommentByMobileNo(String mobileNo) throws Exception;

	
	/**
	 * 查询礼品评论信息
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public IQBOCommentInfoValue[] queryQBOCommentInfo(String string,
			Map<String, String> parameter, int startIndex, int endIndex) throws Exception;

	/**
	 * 查询礼品评论信息分页
	 * @param condition
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public int queryQBOCommentInfoCount(String string,
			Map<String, String> parameter) throws Exception;
    
}
