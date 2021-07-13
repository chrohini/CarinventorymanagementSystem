package com.carinventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.carinventory.model.Car;

public class Cardao {
	JdbcTemplate template;

	public void saveCar(Car car) {
		String sql = "insert into car values(car.getId,car.getMake,car.getModel,car.getPrice)";
		template.update(sql);

	}

	public List<Car> fetchCarDetails() {
		return template.query("select * from car", new RowMapper<Car>() {
			public Car mapRow(ResultSet rs, int row) throws SQLException {
				Car e = new Car();
				e.setId(rs.getInt(1));
				e.setMake(rs.getString(2));
				e.setModel(rs.getString(3));
				e.setPrice(rs.getDouble(4));
				return e;
			}
		});

	}
}
