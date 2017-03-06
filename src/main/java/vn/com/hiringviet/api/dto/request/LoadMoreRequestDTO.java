package vn.com.hiringviet.api.dto.request;

import java.io.Serializable;
import java.util.List;

import vn.com.hiringviet.dto.PagingDTO;

/**
 * The Class LoadMoreRequestDTO.
 */
public class LoadMoreRequestDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8295826163922637493L;

	/** The paging dto. */
	private PagingDTO pagingDTO;

	/** The company name list. */
	private List<String> companyNameList;

	/** The position name list. */
	private List<String> positionNameList;

	/** The skill name list. */
	private List<String> skillNameList;

	/** The province name list. */
	private List<String> provinceNameList;

	/** The category name list. */
	private List<String> categoryNameList;

	/** The date ago. */
	private Integer dateAgo;

	/** The min salary. */
	private Integer minSalary;

	/** The max salary. */
	private Integer maxSalary;

	/** The company id. */
	private Integer companyId;

	/**
	 * Gets the paging dto.
	 *
	 * @return the paging dto
	 */
	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	/**
	 * Sets the paging dto.
	 *
	 * @param pagingDTO the new paging dto
	 */
	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

	/**
	 * Gets the company name list.
	 *
	 * @return the company name list
	 */
	public List<String> getCompanyNameList() {
		return companyNameList;
	}

	/**
	 * Sets the company name list.
	 *
	 * @param companyNameList the new company name list
	 */
	public void setCompanyNameList(List<String> companyNameList) {
		this.companyNameList = companyNameList;
	}

	/**
	 * Gets the position name list.
	 *
	 * @return the position name list
	 */
	public List<String> getPositionNameList() {
		return positionNameList;
	}

	/**
	 * Sets the position name list.
	 *
	 * @param positionNameList the new position name list
	 */
	public void setPositionNameList(List<String> positionNameList) {
		this.positionNameList = positionNameList;
	}

	/**
	 * Gets the skill name list.
	 *
	 * @return the skill name list
	 */
	public List<String> getSkillNameList() {
		return skillNameList;
	}

	/**
	 * Sets the skill name list.
	 *
	 * @param skillNameList the new skill name list
	 */
	public void setSkillNameList(List<String> skillNameList) {
		this.skillNameList = skillNameList;
	}

	/**
	 * Gets the province name list.
	 *
	 * @return the province name list
	 */
	public List<String> getProvinceNameList() {
		return provinceNameList;
	}

	/**
	 * Sets the province name list.
	 *
	 * @param provinceNameList the new province name list
	 */
	public void setProvinceNameList(List<String> provinceNameList) {
		this.provinceNameList = provinceNameList;
	}

	/**
	 * Gets the category name list.
	 *
	 * @return the category name list
	 */
	public List<String> getCategoryNameList() {
		return categoryNameList;
	}

	/**
	 * Sets the category name list.
	 *
	 * @param categoryNameList the new category name list
	 */
	public void setCategoryNameList(List<String> categoryNameList) {
		this.categoryNameList = categoryNameList;
	}

	/**
	 * Gets the date ago.
	 *
	 * @return the date ago
	 */
	public Integer getDateAgo() {
		return dateAgo;
	}

	/**
	 * Sets the date ago.
	 *
	 * @param dateAgo the new date ago
	 */
	public void setDateAgo(Integer dateAgo) {
		this.dateAgo = dateAgo;
	}

	/**
	 * Gets the min salary.
	 *
	 * @return the min salary
	 */
	public Integer getMinSalary() {
		return minSalary;
	}

	/**
	 * Sets the min salary.
	 *
	 * @param minSalary the new min salary
	 */
	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	/**
	 * Gets the max salary.
	 *
	 * @return the max salary
	 */
	public Integer getMaxSalary() {
		return maxSalary;
	}

	/**
	 * Sets the max salary.
	 *
	 * @param maxSalary the new max salary
	 */
	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	/**
	 * Gets the company id.
	 *
	 * @return the company id
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * Sets the company id.
	 *
	 * @param companyId the new company id
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

}
