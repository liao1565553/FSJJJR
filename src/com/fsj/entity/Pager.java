package com.fsj.entity;

import java.io.Serializable;
import java.util.List;

//分页类，包含 每页显示记录数，当前页，总页数，总记录数，每页显示数据的集合
public class Pager<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageSize = 3;// 每页显示记录数
	private int pageNo;// 当前页
	private int pageCount;// 总页数
	private int rowCount;// 总记录数
	private List<T> result;// 每页集合

	public Pager() {
		super();
	}

	public Pager(int pageSize, int pageNo, int pageCount, int rowCount,
			List<T> result) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.pageCount = pageCount;
		this.rowCount = rowCount;
		this.result = result;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
