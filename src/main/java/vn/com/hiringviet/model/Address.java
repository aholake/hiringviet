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
 * The Class Address.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7566847492913663184L;

	/** The id. */
	private int id;

	/** The explicit address. */
	private String explicitAddress;

	/**  District. */
	private District district;

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
	 * Gets the explicit address.
	 *
	 * @return the explicit address
	 */
	@Column(name = "explicit_address")
	public String getExplicitAddress() {
		return explicitAddress;
	}

	/**
	 * Sets the explicit address.
	 *
	 * @param explicitAddress the new explicit address
	 */
	public void setExplicitAddress(String explicitAddress) {
		this.explicitAddress = explicitAddress;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	@ManyToOne(fetch = FetchType.EAGER)
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
}
