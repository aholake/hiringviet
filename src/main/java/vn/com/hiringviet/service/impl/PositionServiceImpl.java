package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.PositionDAO;
import vn.com.hiringviet.model.Position;
import vn.com.hiringviet.service.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionDAO positionDAO;
	
	@Override
	public List<Position> getPositionList() {
		// TODO Auto-generated method stub
		return positionDAO.findAll();
	}

}
