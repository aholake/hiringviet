package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class District.
 */
@Entity
@Table(name = "district")
public class District implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2897165655843882015L;

	/** The id. */
	private int id;

	/** The district name. */
	private String districtName;

	/** The type. */
	private String type;

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
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	@Column(name = "district_name")
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Column(name = "type")
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the province.
	 *
	 * @return the province
	 */
	@ManyToOne(fetch = FetchType.EAGER)
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
