package vn.com.hiringviet.api.dto.response;

public class ExportMemberDTO {

	private String name;

	private String sex;

	private String birthDay;

	private String address;

	private String email;

	private String phone;

	private String summary;

	public ExportMemberDTO(String name, String sex, String birthDay,
			String address, String email, String phone, String summary) {
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.summary = summary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
