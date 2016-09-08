package com.litchi.pojo;

import java.io.Serializable;
import java.util.List;

public class EzUIDataGridResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private long total;

	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public EzUIDataGridResult(long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public EzUIDataGridResult() {
		super();
	}

}