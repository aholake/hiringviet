package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Position;

public interface PositionService {

	public List<Position> getPositionList();

	public Position findOne(Integer positionId);
}
