package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Position;

// TODO: Auto-generated Javadoc
/**
 * The Interface PositionService.
 */
public interface PositionService {

	/**
	 * Gets the position list.
	 *
	 * @return the position list
	 */
	public List<Position> getPositionList();

	/**
	 * Find one.
	 *
	 * @param positionId the position id
	 * @return the position
	 */
	public Position findOne(Integer positionId);
}
