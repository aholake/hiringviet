package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Connect;

@Repository
@Transactional
public interface ConnectDAO extends CommonDAO<Connect> {

	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId);
}
