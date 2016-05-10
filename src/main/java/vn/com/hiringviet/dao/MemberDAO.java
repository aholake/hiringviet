package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Member;

@Repository
@Transactional
public interface MemberDAO {

	public boolean addMember(Member member);

	public Member checkLogin(String email, String password);

	public boolean activeAccount(Integer memberID);
}
