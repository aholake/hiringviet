package vn.com.hiringviet.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;

/**
 * @author TanLoc Prepare data for login by spring security
 */
public class SecurityAccount extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Company company;
	private Member member;

	public SecurityAccount(String username, String password,
			Collection<? extends GrantedAuthority> authorities,
			Company company, Member member) {
		super(username, password, authorities);
		this.company = company;
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
