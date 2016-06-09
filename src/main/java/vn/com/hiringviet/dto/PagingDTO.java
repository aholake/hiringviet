package vn.com.hiringviet.dto;

import java.io.Serializable;

public class PagingDTO implements Serializable {

	private static final long serialVersionUID = 8439065417800645428L;

	private Integer currentPage;

	private Integer firstItem;

	private Integer maxRecord;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getFirstItem() {
		return firstItem;
	}

	public void setFirstItem(Integer firstItem) {
		this.firstItem = firstItem;
	}

	public Integer getMaxRecord() {
		return maxRecord;
	}

	public void setMaxRecord(Integer maxRecord) {
		this.maxRecord = maxRecord;
	}

}
