package vn.com.hiringviet.service;

import vn.com.hiringviet.model.Address;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddressService.
 */
public interface AddressService {
	
	/**
	 * Gets the full address base on id.
	 *
	 * @param pureAddress the pure address
	 * @return the full address base on id
	 */
	public Address getFullAddressBaseOnId(Address pureAddress);
}
