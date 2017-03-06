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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Province.
 */
@Entity
@Table(name = "province")
public class Province implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2693405353279027272L;

	/** The id. */
	private int id;

	/** The province name. */
	private String provinceName;

	/** The type. */
	private String type;

	/** The country. */
	private Country country;

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
	 * Gets the province name.
	 *
	 * @return the province name
	 */
	@Column(name = "province_name")
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * Sets the province name.
	 *
	 * @param provinceName the new province name
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
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
	 * Gets the country.
	 *
	 * @return the country
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
}
