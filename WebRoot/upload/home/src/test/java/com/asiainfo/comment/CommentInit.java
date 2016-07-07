package com.asiainfo.comment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class CommentInit {
	protected static HashSet<String> filterFirstWords;
	protected static HashSet<String> filterWords;
	protected static long maxLength = 0L;

	static {
		File file = new File("file/ExcelDemo.xls");
		String[][] result = null;
		System.out.println("start to read filter words.");
		Long l1 = System.currentTimeMillis();
		try {
			result = ReadExcel.getData(file, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int rowLength = result.length;
		filterFirstWords = new HashSet<String>();
		filterWords = new HashSet<String>();
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < result[i].length; j++) {
				filterFirstWords.add(String.valueOf(result[i][1].charAt(0)));
				filterWords.add(result[i][1]);
				maxLength = result[i][1].length() > maxLength ? result[i][1].length() : maxLength;

			}
		}
		Long l2 = System.currentTimeMillis();
		System.out.println("init completed,use:" + (l2 - l1) + "ms");
		System.out.println("filterFirstWords.lenth:" + filterFirstWords.size() + ":" + filterFirstWords);
		System.out.println("filterWords.lenth:" + filterWords.size() + ":" + filterWords);
		System.out.println("maxLength:" + maxLength);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		long n=100000000000001L;
		Iterator it=filterWords.iterator();
		for(int i=0;i<filterWords.size();i++){
			String s=it.next().toString();
			System.out.println("insert into FILTER_WORDS_INFO(filter_word_id,filter_word,update_time)" +
					" values(SEQ_FILTER_WORDS_INFO.nextval,'"
					+s+"',"
					+"sysdate);");
			if(i>0&&i%100==0)
				System.out.println("commit;");
			n++;
		}
		
		
	}
	
	
}