package cn.myshop.platform.common.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jquery easyUi dataGrid模型类
 * @date 2012-09-24 20:20:29
 * @author llliang
 *
 */
public class DataGridModel  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int page=1; //当前页,默认为第一页
	private int pageRows=10 ; //每页显示条数,默认10条
	private String sort; //排序字段
	private String order; //排序规则
	private int total;//总数
	@SuppressWarnings("unchecked")
	private List rows;//结果集
	private int startRow;
	private int endRow;
	
	private Map<String,Object> queryMap=new HashMap<String,Object>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Map<String, Object> getQueryMap() {
		return queryMap;
	}
	public void setQueryMap(Map<String, Object> queryMap) {
		this.queryMap = queryMap;
	}
	@SuppressWarnings("unchecked")
	public List getRows() {
		return rows;
	}
	@SuppressWarnings("unchecked")
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
}
