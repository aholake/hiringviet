package vn.com.hiringviet.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class PagingDTO.
 */
public class PagingDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8439065417800645428L;

	/** The current page. */
	private Integer currentPage;

	/** The first item. */
	private Integer firstItem;

	/** The max record. */
	private Integer maxRecord;

	/**
	 * Gets the current page.
	 *
	 * @return the current page
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets the current page.
	 *
	 * @param currentPage the new current page
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Gets the first item.
	 *
	 * @return the first item
	 */
	public Integer getFirstItem() {
		return firstItem;
	}

	/**
	 * Sets the first item.
	 *
	 * @param firstItem the new first item
	 */
	public void setFirstItem(Integer firstItem) {
		this.firstItem = firstItem;
	}

	/**
	 * Gets the max record.
	 *
	 * @return the max record
	 */
	public Integer getMaxRecord() {
		return maxRecord;
	}

	/**
	 * Sets the max record.
	 *
	 * @param maxRecord the new max record
	 */
	public void setMaxRecord(Integer maxRecord) {
		this.maxRecord = maxRecord;
	}

}
