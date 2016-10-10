package vn.com.hiringviet.converter;

import vn.com.hiringviet.dto.MemberAdminTableDTO;
import vn.com.hiringviet.model.Member;

public class MemberConverter {
	public static MemberAdminTableDTO convertToMemberAdminTableDTO(Member member) {
		MemberAdminTableDTO adminTableDTO = new MemberAdminTableDTO();
		adminTableDTO.setId(member.getId());
		adminTableDTO.setEmail(member.getAccount().getEmail());
		adminTableDTO.setFirstName(member.getFirstName());
		adminTableDTO.setLastName(member.getLastName());
		adminTableDTO.setActive(member.getAccount().getStatus());
		return adminTableDTO;
	}
}
