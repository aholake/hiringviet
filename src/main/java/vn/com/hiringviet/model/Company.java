package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 7621411313072097608L;

	private Integer id;

	private Account account;

	private String displayName;

	private Integer companySize;

	private Address address;

	private String businessField;

	private String description;

	private Integer foundedYear;

	private String avatar;

	private String coverImage;

	private String website;

	private String location;

	private Country hostCountry;

	private Integer isVip;

	private String companyPolicies;

	private ChangeLog changeLog;

	private Set<CompanyPhoto> companyPhotoSet;

	private Set<Job> jobs;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer companyID) {
		this.id = companyID;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "company_size")
	public Integer getCompanySize() {
		return companySize;
	}

	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "business_field")
	public String getBusinessField() {
		return businessField;
	}

	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "founded_year")
	public Integer getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(Integer foundedYear) {
		this.foundedYear = foundedYear;
	}

	@Column(name = "avatar")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "cover_avatar")
	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Column(name = "website")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_country_id")
	public Country getHostCountry() {
		return hostCountry;
	}

	public void setHostCountry(Country hostCountry) {
		this.hostCountry = hostCountry;
	}

	@Column(name = "is_vip")
	public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	@Column(name = "company_policies")
	public String getCompanyPolicies() {
		return companyPolicies;
	}

	public void setCompanyPolicies(String companyPolicies) {
		this.companyPolicies = companyPolicies;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	public Set<CompanyPhoto> getCompanyPhotoSet() {
		return companyPhotoSet;
	}

	public void setCompanyPhotoSet(Set<CompanyPhoto> companyPhotoSet) {
		this.companyPhotoSet = companyPhotoSet;
	}
}
