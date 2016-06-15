package vn.com.hiringviet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "district")
public class District {
	private int id;
	private String districtName;
	private List<Ward> wards;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "district_name")
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id")
	public List<Ward> getWards() {
		return wards;
	}

	public void setWards(List<Ward> wards) {
		this.wards = wards;
	}

}
