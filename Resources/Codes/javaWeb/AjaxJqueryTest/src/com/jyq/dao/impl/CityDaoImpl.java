package com.jyq.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jyq.dao.CityDao;
import com.jyq.domain.CityBean;
import com.jyq.utils.JDBCUtils;

public class CityDaoImpl implements CityDao {

	@Override
	public List<CityBean> findCityByPid(int pid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource("city"));
		return runner.query("select * from city where pid=?", new BeanListHandler<CityBean>(CityBean.class),pid);
	}

}
