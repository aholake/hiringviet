package vn.com.hiringviet.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MemberAdminTableDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Member;

// TODO: Auto-generated Javadoc
/**
 * The Interface MemberService.
 */
@Service("memberService")
public interface MemberService {

	/**
	 * Adds the member.
	 *
	 * @param member the member
	 * @return the int
	 */
	public int addMember(Member member);

	/**
	 * Delete member.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteMember(int id);

	/**
	 * Gets the member list.
	 *
	 * @return the member list
	 */
	public List<Member> getMemberList();
	
	/**
	 * Update member.
	 *
	 * @param member the member
	 * @return true, if successful
	 */
	public boolean updateMember(Member member);

	/**
	 * Gets the member by id.
	 *
	 * @param memberID the member id
	 * @return the member by id
	 */
	public Member getMemberByID(Integer memberID);

	/**
	 * Gets the member by account.
	 *
	 * @param account the account
	 * @return the member by account
	 */
	public Member getMemberByAccount(Account account);

	/**
	 * Gets the member by account id.
	 *
	 * @param accountId the account id
	 * @return the member by account id
	 */
	public MemberDTO getMemberByAccountId(Integer accountId);

	/**
	 * Adds the skills of member.
	 *
	 * @param account the account
	 * @param skills the skills
	 * @return true, if successful
	 */
	public boolean addSkillsOfMember(Account account, Set<SkillDTO> skills);

	/**
	 * Gets the list member suggest.
	 *
	 * @param keywork the keywork
	 * @return the list member suggest
	 */
	public List<MemberDTO> getListMemberSuggest(String keywork);

	/**
	 * Adds the connect.
	 *
	 * @param formMember the form member
	 * @param toMemberId the to member id
	 */
	public void addConnect(Member formMember, Integer toMemberId);

	/**
	 * Gets the list member for admin page.
	 *
	 * @return the list member for admin page
	 */
	public List<MemberAdminTableDTO> getListMemberForAdminPage();
}
