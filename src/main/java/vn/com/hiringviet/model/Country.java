package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY", catalog = "hiringviet")
public class Country implements Serializable {

	private static final long serialVersionUID = 7933643571717816198L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID", nullable = false, length = 11)
	private Integer countryID;

	@Column(name = "COUNTRY_CODE", nullable = false, length = 100)
	private String countryCode;

	@Column(name = "DISPLAY_NAME", nullable = false, length = 100)
	private String displayName;

	@Column(name = "LANGUAGE", nullable = false, length = 100)
	private String language;

	@Column(name = "FLAG")
	private String flag;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETED_AT")
	private Date deletedAt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
	private Set<Company> companySet;

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Set<Company> getCompanySet() {
		return companySet;
	}

	public void setCompanySet(Set<Company> companySet) {
		this.companySet = companySet;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getLenguage() {
		return language;
	}

	public void setLenguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Country [countryID=" + countryID + ", countryCode="
				+ countryCode + ", displayName=" + displayName + ", lenguage="
				+ language + ", flag=" + flag + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", deletedAt=" + deletedAt;
	}

	
}
