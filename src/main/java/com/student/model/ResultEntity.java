package com.student.model;

public class ResultEntity<T> {
	private String msg;
	
	private String status;
	
	private ResultListEntity<T> resultListEntity;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResultListEntity<T> getResultListEntity() {
		return resultListEntity;
	}

	public void setResultListEntity(ResultListEntity<T> resultListEntity) {
		this.resultListEntity = resultListEntity;
	}
	
	
}
