package com.asiainfo.comment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
@SuppressWarnings("unused")
public class Main {
	private static String fileFileName = "file/text1.txt";
//	private static String fileFileName = "file/text5.txt";
//	private static String fileFileName = "file/text10.txt";
//	private static String fileFileName = "file/text20.txt";
//	private static String fileFileName = "file/text50.txt";
//	private static String fileFileName = "file/text100.txt";
//	private static String fileFileName = "file/text300.txt";
//	private static String fileFileName = "file/text500.txt";

	public static void main(String[] args) throws Exception {
//		testCommentFilter4();//DFA法
		testCommentFilter1();//索引法
//		testCommentFilter2();//普通法
//		testCommentFilter3();//正则表达式法
	}

	
	private static void testCommentFilter2() throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(fileFileName)), "gbk"));
		StringBuilder sb=new StringBuilder();
		String s="";

		Long l1 = System.currentTimeMillis();
		while ((s = br.readLine()) != null) {
			sb.append("\n"+CommentFilter2.doFilter(s));
		}
		Long l2 = System.currentTimeMillis();
		System.out.println("result:" + sb.toString());
		System.out.println("普通法 use:" + (l2 - l1) + "ms\n");
	}

	private static void testCommentFilter1() throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(fileFileName)), "gbk"));
		StringBuilder sb=new StringBuilder();
		String s="";

		Long l1 = System.currentTimeMillis();
		while ((s = br.readLine()) != null) {
			sb.append("\n"+CommentFilter1.doFilter(s));
		}
		Long l2 = System.currentTimeMillis();
		System.out.println("result:" + sb.toString());
		System.out.println("索引法 use:" + (l2 - l1) + "ms\n");
	}

	private static void testCommentFilter3() throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(fileFileName)), "gbk"));
		StringBuilder sb=new StringBuilder();
		String s="";

		Long l1 = System.currentTimeMillis();
		while ((s = br.readLine()) != null) {
			sb.append("\n"+CommentFilter3.doFilter(s));
		}
		Long l2 = System.currentTimeMillis();
		System.out.println("result:" + sb.toString());
		System.out.println("正则表达式法 use:" + (l2 - l1) + "ms\n");
	}
	private static void testCommentFilter4() throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(fileFileName)), "gbk"));
		StringBuilder sb=new StringBuilder();
		String s="";
		CommentFilter4 cf4=new CommentFilter4();
		Long l1 = System.currentTimeMillis();
		while ((s = br.readLine()) != null) {
			sb.append("\n"+cf4.doFilter(s));
		}
		Long l2 = System.currentTimeMillis();
		System.out.println("result:" + sb.toString());
		System.out.println("DFA法 use:" + (l2 - l1) + "ms\n");
	}
}
