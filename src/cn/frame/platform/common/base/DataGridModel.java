package cn.frame.platform.common.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * jquery  dataGrid模型类
 * @date 2012-09-24 20:20:29
 * @author llliang
 *
 */
public class DataGridModel  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int page=1; //当前页,默认为第一页
	private int pagesize=10 ; //每页显示条数,默认10条
	private String sort; //排序字段
	private String order; //排序规则
	@JsonProperty
	private int Total;//总数
	@SuppressWarnings("unchecked")
	//JsonProperty 可设置在转为json格式时保持原来的大小写
	@JsonProperty
	private List Rows;//结果集
	private int startRow;
	private int endRow;
	
	private Map<String,Object> queryMap=new HashMap<String,Object>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
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
	@JsonIgnore
	public int getTotal() {
		return Total;
	}
	@JsonIgnore
	public void setTotal(int total) {
		this.Total = total;
	}
	public Map<String, Object> getQueryMap() {
		return queryMap;
	}
	public void setQueryMap(Map<String, Object> queryMap) {
		this.queryMap = queryMap;
	}
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public List getRows() {
		return Rows;
	}
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setRows(List rows) {
		this.Rows = rows;
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
