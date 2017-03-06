package vn.com.hiringviet.converter;

import vn.com.hiringviet.dto.CompanyAdminTableDTO;
import vn.com.hiringviet.model.Company;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyConverter.
 */
public class CompanyConverter {
	
	/**
	 * Convert to company admin table dto.
	 *
	 * @param company the company
	 * @return the company admin table dto
	 */
	public static CompanyAdminTableDTO convertToCompanyAdminTableDTO(
			Company company) {
		CompanyAdminTableDTO companyAdminTableDTO = new CompanyAdminTableDTO();
		companyAdminTableDTO.setId(company.getId());
		companyAdminTableDTO.setDisplayName(company.getDisplayName());
		companyAdminTableDTO.setEmail(company.getAccount().getEmail());
		companyAdminTableDTO.setIsVip(company.getIsVip());
		companyAdminTableDTO.setStatus(company.getAccount().getStatus());
		companyAdminTableDTO.setBusinessField(company.getBusinessField());
		return companyAdminTableDTO;
	}
}
