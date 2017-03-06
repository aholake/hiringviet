package vn.com.hiringviet.api.dto.request;

import java.io.Serializable;

/**
 * The Class SearchRequestDTO.
 */
public class SearchRequestDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7112674141025721411L;

	/** The key word. */
	private String keyWord;

	/** The search company. */
	private boolean searchCompany;

	/** The search job. */
	private boolean searchJob;

	/** The search member. */
	private boolean searchMember;

	/** The search skill. */
	private boolean searchSkill;

	/**
	 * Gets the key word.
	 *
	 * @return the key word
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * Sets the key word.
	 *
	 * @param keyWord
	 *            the new key word
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * Checks if is search company.
	 *
	 * @return true, if is search company
	 */
	public boolean isSearchCompany() {
		return searchCompany;
	}

	/**
	 * Sets the search company.
	 *
	 * @param searchCompany
	 *            the new search company
	 */
	public void setSearchCompany(boolean searchCompany) {
		this.searchCompany = searchCompany;
	}

	/**
	 * Checks if is search job.
	 *
	 * @return true, if is search job
	 */
	public boolean isSearchJob() {
		return searchJob;
	}

	/**
	 * Sets the search job.
	 *
	 * @param searchJob
	 *            the new search job
	 */
	public void setSearchJob(boolean searchJob) {
		this.searchJob = searchJob;
	}

	/**
	 * Checks if is search member.
	 *
	 * @return true, if is search member
	 */
	public boolean isSearchMember() {
		return searchMember;
	}

	/**
	 * Sets the search member.
	 *
	 * @param searchMember
	 *            the new search member
	 */
	public void setSearchMember(boolean searchMember) {
		this.searchMember = searchMember;
	}

	/**
	 * Checks if is search skill.
	 *
	 * @return true, if is search skill
	 */
	public boolean isSearchSkill() {
		return searchSkill;
	}

	/**
	 * Sets the search skill.
	 *
	 * @param searchSkill
	 *            the new search skill
	 */
	public void setSearchSkill(boolean searchSkill) {
		this.searchSkill = searchSkill;
	}

}
