package ngves.asiainfo.core.comment.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ngves.asiainfo.core.SqlMapSessionTemplate;
import ngves.asiainfo.core.comment.IQBOCommentInfoValue;
import ngves.asiainfo.core.comment.QBOCommentInfoEngine;
import ngves.asiainfo.core.comment.bo.CommentInfoBean;
import ngves.asiainfo.core.comment.bo.CommentInfoEngine;
import ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO;
import ngves.asiainfo.core.comment.ivalues.ICommentInfoValue;
import ngves.asiainfo.core.comment.model.Comment;

/**礼品评论数据层实现类
 * @author LiuLin
 *
 */
public class CommentInfoDAOImpl extends SqlMapSessionTemplate implements ICommentInfoDAO {

	private static transient Log log = LogFactory.getLog(CommentInfoDAOImpl.class);

	/* 查询礼品评论信息
	 * (non-Javadoc)
	 * @see ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO#queryCommentInfo(java.lang.String, java.util.Map)
	 */
	public ICommentInfoValue[] queryCommentInfo(String condition, Map<String, String> parameter) throws Exception {
		return CommentInfoEngine.getBeans(condition, parameter);
	}

	/* 查询总条数
	 * (non-Javadoc)
	 * @see ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO#queryCommentInfoCount(java.lang.String, java.util.Map)
	 */
	public int queryCommentInfoCount(String condition, Map<String, String> parameter) throws Exception {
		return CommentInfoEngine.getBeansCount(condition, parameter);
	}

	/* 
	 * 用于分页查询
	 * @see ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO#queryCommentInfo(java.lang.String, java.util.Map, int, int)
	 */
	public ICommentInfoValue[] queryCommentInfo(String condition, Map<String, String> parameter, int startIndex,
			int endIndex) throws Exception {
		return CommentInfoEngine.getBeans(null, condition, parameter, startIndex, endIndex, false);
	}

	/* 
	 * 批量更新审核状态
	 * (non-Javadoc)
	 * @see ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO#updateBussiPartnerInfoBatch(ngves.asiainfo.core.comment.ivalues.ICommentInfoValue[])
	 */
	public void updateBussiPartnerInfoBatch(ICommentInfoValue[] commentInfos) throws Exception {
		CommentInfoEngine.saveBatch(commentInfos);
	}

	public void saveCommentInfo(CommentInfoBean commentInfo) throws Exception {
		CommentInfoEngine.save(commentInfo);
	}

	//根据普通礼品ID(或子礼品ID)查询出通过审核的礼品评论（门户调用方法）
	@SuppressWarnings("unchecked")
	public Comment[] getAllCommentInfo(String wareId, int startIndex, int endIndex) throws Exception {
		log.info("method:getAllCommentInfo>>>  pWareId:" + wareId + "  startIndex:" + startIndex + "  endIndex:"
				+ endIndex + " is running...");
		List<Comment> commentList = null;
		Comment[] result = null;
		Comment comment = new Comment();
		comment.setWareId(new Long(wareId));
		comment.setStartIndex(startIndex);
		comment.setEndIndex(endIndex);

		log.info("method:getAllCommentInfo>>>  pWareId:" + wareId + "  startIndex:" + startIndex + "  endIndex:"
				+ endIndex + "  from DB by Ibatis  start...");

		commentList = (List<Comment>)queryForList("Comment.validCommentByWareId", comment);
		//commentList = (List<Comment>) queryForList("Comment.validCommentByWareId1", new Long(wareId), 2, 3);
		log.info("method:getAllCommentInfo>>> pWareId:" + wareId + "  startIndex:" + startIndex + "  endIndex:"
				+ endIndex + "  from DB by Ibatis  end...");

		result = new Comment[commentList.size()];//分配空间，此时仅有引用
		for (int i = 0; i < commentList.size(); i++) {
			result[i] = new Comment();//分配内存
			result[i] = commentList.get(i);
		}
		return result;
	}

	//根据普通礼品ID(或子礼品ID)查询  审核通过的 礼品评论总条数
	public int getAllCommentInfoCount(String wareId) throws Exception {

		return (Integer) queryForObject("Comment.validCommentCountByWareId", wareId);
	}

	//保存礼品评论
	public long saveComment(Comment comentInfo) throws Exception {
		log.info("method:saveComment>>> wareId:" + comentInfo.getWareId() + " is running...");
		return (Long) insert("Comment.insertComment", comentInfo);
	}

	//根据父礼品ID查询出通过审核的礼品评论（门户调用方法）
	@SuppressWarnings("unchecked")
	public Comment[] getAllCommentInfoByPwareId(String pWareId, int startIndex, int endIndex) throws Exception {
		log.info("getAllCommentInfoByPwareId>>>pWareId:" + pWareId + "  startIndex:" + startIndex + "  endIndex:"
				+ endIndex + " is running...");
		List<Comment> commentList = null;
		Comment[] result = null;
		Comment comment = new Comment();
		comment.setPWareId(new Long(pWareId));
		comment.setStartIndex(startIndex);
		comment.setEndIndex(endIndex);

		log.info("method:getAllCommentInfoByPwareId>>> pWareId:" + pWareId + "  startIndex:" + startIndex
				+ "  endIndex:" + endIndex + "  from DB by Ibatis  start...");

		commentList = (List<Comment>) queryForList("Comment.validCommentByPWareId", comment);

		log.info("method:getAllCommentInfoByPwareId>>> pWareId:" + pWareId + "  startIndex:" + startIndex
				+ "  endIndex:" + endIndex + ")  from DB by Ibatis  end...");

		result = new Comment[commentList.size()];//分配空间，此时仅有引用
		for (int i = 0; i < commentList.size(); i++) {
			result[i] = new Comment();//分配内存
			result[i] = commentList.get(i);
		}
		return result;
	}

	//根据父礼品ID查询  审核通过的 礼品评论总条数
	public int getAllCommentInfoCountByPwareId(String pWareId) throws Exception {
		return (Integer) queryForObject("Comment.validCommentCountByPWareId", pWareId);
	}

	/**门户使用iBatis获取数据
	 * 根据手机号得到用户的礼品评论（包含通过和未通过的）
	 * @throws Exception 
	 * @see ngves.asiainfo.core.comment.dao.interfaces.ICommentInfoDAO#getAllCommentByMobileNo(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Comment[] getAllCommentByMobileNo(String mobileNo) throws Exception {
		List<Comment> commentList = null;
		Comment[] result = null;
		log.info("method:getAllCommentByMobileNo>>> mobileNo:" + mobileNo + "  from DB by Ibatis  start...");
		commentList = (List<Comment>) queryForList("Comment.commentInfoByPhoneNo", mobileNo);
		log.info("method:getAllCommentByMobileNo>>> mobileNo:" + mobileNo + " from DB by Ibatis  end...");
		
		result = new Comment[commentList.size()];//分配空间，此时仅有引用
		for (int i = 0; i < commentList.size(); i++) {
			result[i] = new Comment();//分配内存
			result[i] = commentList.get(i);
		}
		return result;

	}

	public IQBOCommentInfoValue[] queryQBOCommentInfo(String string,
			Map<String, String> parameter, int startIndex, int endIndex) throws Exception {
		return QBOCommentInfoEngine.getBeans(null, string, parameter, startIndex, endIndex, false);
	}

	public int queryQBOCommentInfoCount(String string,
			Map<String, String> parameter) throws Exception {
		return QBOCommentInfoEngine.getBeansCount(string, parameter);
	}

}
