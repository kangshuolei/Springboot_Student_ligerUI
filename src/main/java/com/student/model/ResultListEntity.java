package com.student.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultListEntity<T> {
	@JsonProperty("Rows")
	private List<T> rows;

	@JsonProperty("Total")
	private Integer total;
	
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}	
}
