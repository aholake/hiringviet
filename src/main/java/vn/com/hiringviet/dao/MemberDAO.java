package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.model.Member;

public interface MemberDAO extends CommonDAO<Member> {

	public Member getMemberByAccount(Account account);

	public MemberDTO getMemberByAccountId(Integer accountId);

	public List<MemberDTO> getListMemberSuggest(String keywork);

	public void addConnect(Connect connect);
}
