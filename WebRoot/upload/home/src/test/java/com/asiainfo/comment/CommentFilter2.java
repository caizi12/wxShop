package com.asiainfo.comment;

/**
 * 普通过滤法
 * @author Administrator
 *
 */
public class CommentFilter2 extends CommentInit {

	public static String doFilter(String comment) {

		String s = "";
		for (int i = 0; i < comment.length(); i++) {
			for (int j = 0; j < maxLength; j++) {
				int length=(i+j)<comment.length()?(i+j):comment.length();
				s = comment.substring(i, length);
				if (filterWords.contains(s)) {
					comment = comment.replace(s, "***");
				}
				if ((i + j) == comment.length())
					break;

			}
		}
		while (comment.contains("******")) {
			comment = comment.replaceAll("\\*{6}", "***");
		}
		return comment;
	}
}
