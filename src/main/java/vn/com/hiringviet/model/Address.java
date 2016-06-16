package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Address.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7566847492913663184L;

	/** The id. */
	private int id;

	/** The street name. */
	private String streetName;

	/** The ward. */
	private Ward ward;

	/** The district. */
	private District district;

	/** The province. */
	private Province province;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the street name.
	 *
	 * @return the street name
	 */
	@Column(name = "street_name")
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the street name.
	 *
	 * @param streetName the new street name
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Gets the ward.
	 *
	 * @return the ward
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ward_id")
	public Ward getWard() {
		return ward;
	}

	/**
	 * Sets the ward.
	 *
	 * @param ward the new ward
	 */
	public void setWard(Ward ward) {
		this.ward = ward;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id")
	public District getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the new district
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/**
	 * Gets the province.
	 *
	 * @return the province
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "province_id")
	public Province getProvince() {
		return province;
	}

	/**
	 * Sets the province.
	 *
	 * @param province the new province
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

}
