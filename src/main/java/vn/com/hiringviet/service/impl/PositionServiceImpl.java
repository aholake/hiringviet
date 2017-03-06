package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.PositionDAO;
import vn.com.hiringviet.model.Position;
import vn.com.hiringviet.service.PositionService;

// TODO: Auto-generated Javadoc
/**
 * The Class PositionServiceImpl.
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
	
	/** The position dao. */
	@Autowired
	private PositionDAO positionDAO;
	
	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.PositionService#getPositionList()
	 */
	@Override
	public List<Position> getPositionList() {
		return positionDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.PositionService#findOne(java.lang.Integer)
	 */
	@Override
	public Position findOne(Integer positionId) {
		return positionDAO.findOne(positionId);
	}

}
