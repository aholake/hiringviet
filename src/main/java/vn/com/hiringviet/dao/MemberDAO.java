package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.model.Member;

// TODO: Auto-generated Javadoc
/**
 * The Interface MemberDAO.
 */
public interface MemberDAO extends CommonDAO<Member> {

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
	 * Gets the list member suggest.
	 *
	 * @param keywork the keywork
	 * @return the list member suggest
	 */
	public List<MemberDTO> getListMemberSuggest(String keywork);

	/**
	 * Adds the connect.
	 *
	 * @param connect the connect
	 */
	public void addConnect(Connect connect);
}
