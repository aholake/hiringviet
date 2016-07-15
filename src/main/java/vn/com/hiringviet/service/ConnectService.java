package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Connect;

@Service("connectService")
public interface ConnectService {

	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId);
}
