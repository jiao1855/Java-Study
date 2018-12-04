package com.jyq.dao;

import java.sql.SQLException;
import java.util.List;

import com.jyq.domain.CityBean;

public interface CityDao {
	
	/**
	 * 根据省份查询城市
	 * @param pid
	 * @return
	 */
	List<CityBean> findCityByPid(int pid) throws SQLException;
}
