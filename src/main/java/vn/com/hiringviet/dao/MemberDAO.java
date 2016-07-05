package vn.com.hiringviet.dao;

import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Member;

public interface MemberDAO extends CommonDAO<Member> {

	public Member getMemberByAccount(Account account);

	public MemberDTO getMemberByAccountId(Integer accountId);

}
