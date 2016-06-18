package vn.com.hiringviet.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.CountryDAO;
import vn.com.hiringviet.model.Country;

@Repository
@Transactional
public class CountryDAOImpl extends CommonDAOImpl<Country> implements CountryDAO{

}
