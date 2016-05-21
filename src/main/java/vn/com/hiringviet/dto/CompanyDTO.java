package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CompanyDTO implements Serializable {

	private static final long serialVersionUID = 7621411313072097608L;

	private Integer companyID;

	private MemberDTO member;

	private DistrictDTO district;

	private CountryDTO country;

	private String displayName;

	private Integer companySize;

	private String companyAddress;

	private String title;

	private String description;

	private Integer foundedYear;

	private byte[] avatar;

	private byte[] coverImage;

	private String website;

	private String location;

	private Integer status;

	private Date createAt;

	private Date updateAt;

	private Date deleteAt;

	@JsonIgnore
	private Set<CompanyPhotoDTO> companyPhotoSet;

	@JsonIgnore
	private Set<JobDTO> jobSet;

	public Integer getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	public DistrictDTO getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDTO district) {
		this.district = district;
	}

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getCompanySize() {
		return companySize;
	}

	public void setCompanySize(Integer companySize) {
		this.companySize = companySize;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(Integer foundedYear) {
		this.foundedYear = foundedYear;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public byte[] getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Date getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}

	public Set<CompanyPhotoDTO> getCompanyPhotoSet() {
		return companyPhotoSet;
	}

	public void setCompanyPhotoSet(Set<CompanyPhotoDTO> companyPhotoSet) {
		this.companyPhotoSet = companyPhotoSet;
	}

	public Set<JobDTO> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<JobDTO> jobSet) {
		this.jobSet = jobSet;
	}

}
