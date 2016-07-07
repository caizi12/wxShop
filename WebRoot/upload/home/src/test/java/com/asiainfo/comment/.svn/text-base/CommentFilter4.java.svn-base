package com.asiainfo.comment;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * DFA算法
 * @author Administrator
 *
 */
public class CommentFilter4 extends CommentInit {

	@SuppressWarnings("unchecked")
	public CommentFilter4(){
		ArrayList list=new ArrayList();
		list.addAll(filterWords);
		try {
			createKeywordTree(list);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** 
	 * 根节点 
	 */
	private TreeNode rootNode = new TreeNode();

	/** 
	 * 关键词缓存 
	 */
	private ByteBuffer keywordBuffer = ByteBuffer.allocate(1024);

	/** 
	 * 关键词编码 
	 */
	private String charset = "GBK";

	/** 
	 * 创建DFA 
	 * @param keywordList 
	 * @throws UnsupportedEncodingException  
	 */
	public void createKeywordTree(List<String> keywordList) throws UnsupportedEncodingException {

		for (String keyword : keywordList) {
			if (keyword == null)
				continue;
			keyword = keyword.trim();
			byte[] bytes = keyword.getBytes(charset);

			TreeNode tempNode = rootNode;
			//循环每个字节  
			for (int i = 0; i < bytes.length; i++) {
				int index = bytes[i] & 0xff; //字符转换成数字  
				TreeNode node = tempNode.getSubNode(index);

				if (node == null) { //没初始化  
					node = new TreeNode();
					tempNode.setSubNode(index, node);
				}

				tempNode = node;

				if (i == bytes.length - 1) {
					tempNode.setKeywordEnd(true); //关键词结束， 设置结束标志  
				}
			}//end for  
		}//end for  

	}

	/** 
	 * 搜索关键字 
	 */
	public String doFilter(String text) throws UnsupportedEncodingException {
		String comment=searchKeyword(text,text.getBytes(charset));
		while (comment.contains("******")) {
			comment = comment.replaceAll("\\*{6}", "***");
		}
		return comment;
	}

	/** 
	 * 搜索关键字 
	 */
	public String searchKeyword(String text,byte[] bytes) {
		StringBuilder words = new StringBuilder();

		if (bytes == null || bytes.length == 0) {
			return words.toString();
		}

		TreeNode tempNode = rootNode;
		int rollback = 0; //回滚数  
		int position = 0; //当前比较的位置  

		while (position < bytes.length) {
			int index = bytes[position] & 0xFF;
			keywordBuffer.put(bytes[position]); //写关键词缓存  
			tempNode = tempNode.getSubNode(index);

			//当前位置的匹配结束  
			if (tempNode == null) {
				position = position - rollback; //回退 并测试下一个字节  
				rollback = 0;
				tempNode = rootNode; //状态机复位  
				keywordBuffer.clear(); //清空  
			} else if (tempNode.isKeywordEnd()) { //是结束点 记录关键词  
				keywordBuffer.flip();
				String keyword = Charset.forName(charset).decode(keywordBuffer).toString();
				keywordBuffer.limit(keywordBuffer.capacity());
				text=text.replace(keyword, "***");
				
				if (words.length() == 0)
					words.append(keyword);
				else
					words.append(":").append(keyword);

				rollback = 1; //遇到结束点  rollback 置为1  
			} else {
				rollback++; //非结束点 回退数加1  
			}

			position++;
		}
//		return words.toString();
		return text;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

}

class TreeNode {
	private static final int NODE_LEN = 256;

	/** 
	 * true 关键词的终结 ； false 继续 
	 */
	private boolean end = false;

	private List<TreeNode> subNodes = new ArrayList<TreeNode>(NODE_LEN);

	public TreeNode() {
		for (int i = 0; i < NODE_LEN; i++) {
			subNodes.add(i, null);
		}
	}

	/** 
	 * 向指定位置添加节点树 
	 * @param index 
	 * @param node 
	 */
	public void setSubNode(int index, TreeNode node) {
		subNodes.set(index, node);
	}

	public TreeNode getSubNode(int index) {
		return subNodes.get(index);
	}

	public boolean isKeywordEnd() {
		return end;
	}

	public void setKeywordEnd(boolean end) {
		this.end = end;
	}
}
