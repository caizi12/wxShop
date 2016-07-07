package ngves.asiainfo.core.comment.service.impl;

import ngves.asiainfo.core.comment.service.interfaces.ICommentFilterSrv;

import java.util.HashSet;

/**
 * 索引法过滤礼品评论
 * @author LiuLin
 *
 */
public class CommentFilterImpl implements ICommentFilterSrv{
	protected static HashSet<String> filterFirstWords;
	protected static HashSet<String> filterWords;
	protected static long maxLength = 0L;

	//	private static Logger logger =Logger.getLogger(CommentFilter.class);

	/**
	 * 初始化
	 * @param filterWordsInfos
	 */
	public void setFilterWords(String[] filterWordsInfos) {
		filterFirstWords = new HashSet<String>();
		filterWords = new HashSet<String>();
		int rowLength = filterWordsInfos.length;
		for (int i = 0; i < rowLength; i++) {
			//索引词表
			filterFirstWords.add(String.valueOf(filterWordsInfos[i].charAt(0)));
			//过滤词表
			filterWords.add(filterWordsInfos[i]);
			maxLength = filterWordsInfos[i].length() > maxLength ? filterWordsInfos[i].length() : maxLength;
		}
		//		logger.info("filterFirstWords.lenth:" + filterFirstWords.size() + ":" + filterFirstWords);
		//		logger.info("filterWords.lenth:" + filterWords.size() + ":" + filterWords);
		//		logger.info("maxLength:" + maxLength);
	}

	public String doFilter(String comment) {
		for (int i = 0; i < comment.length(); i++) {
			//如果包含索引词
			if (filterFirstWords.contains(String.valueOf(comment.charAt(i)))) {
				comment = replaceFilterWords(i, comment);
			} else {
				continue;
			}
		}
		while (comment.contains("******")) {
			comment = comment.replaceAll("\\*{6}", "***");
		}
		return comment;
	}

	/**
	 * 替换过滤词
	 * @param i
	 * @param comment
	 * @return
	 */
	public String replaceFilterWords(int i, String comment) {
		String temp = "";
		int length = 0;
		for (int j = 0; j < maxLength; j++) {
			//是否大于内容长度最大值
			length = (i + j) < comment.length() ? (i + j) : comment.length();

			//			temp += String.valueOf(s.charAt(length));
			temp = comment.substring(i, length+1);
			if (filterWords.contains(temp.toString())) {
				comment = comment.replace(temp.toString(), "***");
				break;
			}
			if (length == (comment.length() - 1))
				break;
		}
		return comment;
	}
}
