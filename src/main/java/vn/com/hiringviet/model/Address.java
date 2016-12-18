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

	/** District */
	private District district;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "explicit_address")
	public String getExplicitAddress() {
		return explicitAddress;
	}

	public void setExplicitAddress(String explicitAddress) {
		this.explicitAddress = explicitAddress;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "district_id")
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
