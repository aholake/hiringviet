package vn.com.hiringviet.converter;

import vn.com.hiringviet.dto.MemberAdminTableDTO;
import vn.com.hiringviet.model.Member;

// TODO: Auto-generated Javadoc
/**
 * The Class MemberConverter.
 */
public class MemberConverter {
	
	/**
	 * Convert to member admin table dto.
	 *
	 * @param member the member
	 * @return the member admin table dto
	 */
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
