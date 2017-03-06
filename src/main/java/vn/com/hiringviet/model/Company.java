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

// TODO: Auto-generated Javadoc
/**
 * The Class Company.
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7621411313072097608L;

	/** The id. */
	private Integer id;

	/** The account. */
	private Account account;

	/** The display name. */
	private String displayName;

	/** The company size. */
	private Integer companySize;

	/** The address. */
	private Address address;

	/** The business field. */
	private String businessField;

	/** The description. */
	private String description;

	/** The founded year. */
	private Integer foundedYear;

	/** The avatar. */
	private String avatar;

	/** The cover image. */
	private String coverImage;

	/** The website. */
	private String website;

	/** The location. */
	private String location;

	/** The host country. */
	private Country hostCountry;

	/** The is vip. */
	private Integer isVip;

	/** The company policies. */
	private String companyPolicies;

	/** The change log. */
	private ChangeLog changeLog;

	/** The company photo set. */
	private Set<CompanyPhoto> companyPhotoSet;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param companyID the new id
	 */
	public void setId(Integer companyID) {
		this.id = companyID;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	@Column(name = "display_name")
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the company size.
	 *
	 * @return the company size
	 */
	@Column(name = "company_size")
	public Integer getCompanySize() {
		return companySize;
	}

	/**
	 * Sets the company size.
	 *
	 * @param companySize the new company size
	 */
	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the business field.
	 *
	 * @return the business field
	 */
	@Column(name = "business_field")
	public String getBusinessField() {
		return businessField;
	}

	/**
	 * Sets the business field.
	 *
	 * @param businessField the new business field
	 */
	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the founded year.
	 *
	 * @return the founded year
	 */
	@Column(name = "founded_year")
	public Integer getFoundedYear() {
		return foundedYear;
	}

	/**
	 * Sets the founded year.
	 *
	 * @param foundedYear the new founded year
	 */
	public void setFoundedYear(Integer foundedYear) {
		this.foundedYear = foundedYear;
	}

	/**
	 * Gets the avatar.
	 *
	 * @return the avatar
	 */
	@Column(name = "avatar")
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Sets the avatar.
	 *
	 * @param avatar the new avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * Gets the cover image.
	 *
	 * @return the cover image
	 */
	@Column(name = "cover_avatar")
	public String getCoverImage() {
		return coverImage;
	}

	/**
	 * Sets the cover image.
	 *
	 * @param coverImage the new cover image
	 */
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	/**
	 * Gets the website.
	 *
	 * @return the website
	 */
	@Column(name = "website")
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the host country.
	 *
	 * @return the host country
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "host_country_id")
	public Country getHostCountry() {
		return hostCountry;
	}

	/**
	 * Sets the host country.
	 *
	 * @param hostCountry the new host country
	 */
	public void setHostCountry(Country hostCountry) {
		this.hostCountry = hostCountry;
	}

	/**
	 * Gets the checks if is vip.
	 *
	 * @return the checks if is vip
	 */
	@Column(name = "is_vip")
	public Integer getIsVip() {
		return isVip;
	}

	/**
	 * Sets the checks if is vip.
	 *
	 * @param isVip the new checks if is vip
	 */
	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	/**
	 * Gets the company policies.
	 *
	 * @return the company policies
	 */
	@Column(name = "company_policies")
	public String getCompanyPolicies() {
		return companyPolicies;
	}

	/**
	 * Sets the company policies.
	 *
	 * @param companyPolicies the new company policies
	 */
	public void setCompanyPolicies(String companyPolicies) {
		this.companyPolicies = companyPolicies;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	/**
	 * Sets the change log.
	 *
	 * @param changeLog the new change log
	 */
	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	/**
	 * Gets the company photo set.
	 *
	 * @return the company photo set
	 */
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	public Set<CompanyPhoto> getCompanyPhotoSet() {
		return companyPhotoSet;
	}

	/**
	 * Sets the company photo set.
	 *
	 * @param companyPhotoSet the new company photo set
	 */
	public void setCompanyPhotoSet(Set<CompanyPhoto> companyPhotoSet) {
		this.companyPhotoSet = companyPhotoSet;
	}
}
