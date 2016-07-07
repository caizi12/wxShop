package com.asiainfo.comment;


/**
 * 索引法
 * @author Administrator
 *
 */
public class CommentFilter1 extends CommentInit {

//	private static HashSet<String> filterWordsMin;
//	private static int minLength;
//	private static Iterator it;
	public static String doFilter(String comment) {
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

//	/**
//	 * 根据索引词重新生成一个小型过滤库，再进行过滤词替换
//	 * @param i
//	 * @param comment
//	 * @return
//	 */
//	public static String replaceFilterWords(int i, String comment) {
//		filterWordsMin=new HashSet<String>();
//		it=filterWords.iterator();
//		while(it.hasNext()){
//			String s=(String) it.next();
//			if(s.matches(comment.charAt(i)+"(.)*")){
//				minLength=minLength<s.length()?s.length():minLength;
//				filterWordsMin.add(s);
//			}
//				
//		}
//		
//		String temp = "";
//		int length = 0;
//		for (int j = 0; j < minLength; j++) {
//			//是否大于内容长度最大值
//			length = (i + j) < comment.length() ? (i + j) : comment.length();
//
//			temp = comment.substring(i, length);
//			if (filterWordsMin.contains(temp.toString())) {
//				comment=comment.replace(temp.toString(), "***");
//				break;
//			}
//			if (length == (comment.length() - 1))
//				break;
//		}
//		return comment;
//	}
	
	/**
	 * 优化版
	 * @param i
	 * @param comment
	 * @return
	 */
//	public static String replaceFilterWords(int i, String comment) {
//		String temp = "";
//		int length = 0;
//		for (int j = 0; j < maxLength; j++) {
//			//是否大于内容长度最大值
//			length = (i + j) < comment.length() ? (i + j) : comment.length();
//
//			//			temp += String.valueOf(s.charAt(length));
//			temp = comment.substring(i, length);
//			if (filterWords.contains(temp.toString())) {
//				comment=comment.replace(temp.toString(), "***");
//				break;
//			}
//			if(String.valueOf(comment.charAt(length)).matches("[\\pP‘’“”]"))
//				break;
//			if (length == (comment.length() - 1))
//				break;
//		}
//		return comment;
//}
	
	/**
	 * 替换过滤词
	 * @param i
	 * @param comment
	 * @return
	 */
	public static String replaceFilterWords(int i, String comment) {
		String temp = "";
		int length = 0;
		for (int j = 0; j < maxLength; j++) {
			//是否大于内容长度最大值
			length = (i + j) < comment.length() ? (i + j) : comment.length();

			//			temp += String.valueOf(s.charAt(length));
			temp = comment.substring(i, length+1);
			System.out.println(temp);
			if (filterWords.contains(temp.toString())) {
				comment=comment.replace(temp.toString(), "***");
				break;
			}
			if (length == (comment.length() - 1))
				break;
		}
		return comment;
	}
}
