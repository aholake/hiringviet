package vn.com.hiringviet.converter;

import vn.com.hiringviet.dto.CompanyAdminTableDTO;
import vn.com.hiringviet.model.Company;

public class CompanyConverter {
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
