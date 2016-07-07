package com.asiainfo.comment;

import java.util.*;

/**
 * 正则表达式法
 * @author Administrator
 *
 */

public class CommentFilter3 extends CommentInit{
	
	@SuppressWarnings("unchecked")
	private static Iterator it;
	private static String s;
	
	public static String doFilter(String comment) {
		it=filterWords.iterator();
		int i=0;
		while(it.hasNext()){
			s = (String) it.next();
			if(comment.matches("(.)*"+s+"(.)*")){
				comment = comment.replace(s, "***");
			}
			i++;
		}
		while (comment.contains("******")) {
			comment = comment.replaceAll("\\*{6}", "***");
		}
		return comment;
	}

	
}
