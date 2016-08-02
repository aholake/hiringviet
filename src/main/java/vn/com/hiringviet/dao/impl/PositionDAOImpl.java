package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.PositionDAO;
import vn.com.hiringviet.model.Position;

@Repository
@Transactional
public class PositionDAOImpl extends CommonDAOImpl<Position> implements PositionDAO {

}
